

#include "Packer.h"


void Packer::PackNecklace(Necklace* item, JewelleryStorage* storage)
{
    if (item->Stone() == Jewel::Diamond)
        storage->Safe.push_back(item);
    else if (!item->IsHeavy())
        storage->Box.TopShelf.push_back(item);
    else if (auto pendantNecklace = dynamic_cast<PendantNecklace*>(item))
    {
        storage->Tree.push_back(pendantNecklace->Chain());
        storage->Box.TopShelf.push_back(pendantNecklace->Pendant());
    }
    else
        storage->Tree.push_back(item);
}

void Packer::Pack(JewelleryBase* item, JewelleryStorage* storage)
{
    if (storage->IsInTravelRoll(item) && !item->IsHeavy())
        storage->Box.TopShelf.push_back(item);
    else if (item->Stone() == Jewel::Diamond)
        storage->Safe.push_back(item);
    else if (auto pendantNecklace = dynamic_cast<PendantNecklace*>(item))
    {
        storage->Tree.push_back(pendantNecklace->Chain());
        storage->Box.TopShelf.push_back(pendantNecklace->Pendant());
    }
    else if (item->IsSmall())
        storage->Box.TopShelf.push_back(item);
    else if (dynamic_cast<Necklace*>(item) && !item->IsHeavy()) {
        storage->Box.TopShelf.push_back(item);
    }
    else if (auto earring1 = dynamic_cast<Earring*>(item))
    {
        if (earring1->Type() == EarringType::Hoop)
            storage->Tree.push_back(earring1);
        else if (auto earring2 = dynamic_cast<Earring*>(item))
        {
            if (earring2->Type() == EarringType::Drop && earring2->Stone() != Jewel::Plain)
                storage->Box.TopShelf.push_back(earring2);
            else if (earring2->Type() == EarringType::Drop)
                storage->Box.MainSection.push_back(earring2);
        }
    }
    else if (dynamic_cast<Necklace*>(item))
        storage->Tree.push_back(item);
    else
        storage->DresserTop.push_back(item);
    
    if (storage->IsInTravelRoll(item)) {
        auto it = std::find(storage->TravelRoll.begin(), storage->TravelRoll.end(), item);
        if (it != storage->TravelRoll.end())
            storage->TravelRoll.erase(it);
    }
}
