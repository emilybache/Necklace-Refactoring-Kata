using NecklaceRefactoringKata.Enums;
using NecklaceRefactoringKata.JewelleryTypes;

namespace NecklaceRefactoringKata
{
    public static class Packer
    {
        public static void PackNecklace(Necklace item, JewelleryStorage storage)
        {
            if (item.Stone == Jewel.Diamond)
                storage.Safe.Add(item);
            else if (!item.IsHeavy())
                storage.Box.TopShelf.Add(item);
            else if (item is PendantNecklace pendantNecklace)
            {
                storage.Tree.Add(pendantNecklace.Chain);
                storage.Box.TopShelf.Add(pendantNecklace.Pendant);
            }
            else
                storage.Tree.Add(item);
        }

        public static void Pack(JewelleryBase item, JewelleryStorage storage)
        {
            if (storage.IsInTravelRoll(item) && !item.IsHeavy())
                storage.Box.TopShelf.Add(item);
            else if (item.Stone == Jewel.Diamond)
                storage.Safe.Add(item);
            else if (item is Necklace necklace1 && necklace1 is PendantNecklace pendantNecklace)
            {
                storage.Tree.Add(pendantNecklace.Chain);
                storage.Box.TopShelf.Add(pendantNecklace.Pendant);
            }
            else if (item.IsSmall())
                storage.Box.TopShelf.Add(item);
            else if (item is Necklace && !item.IsHeavy())
                storage.Box.TopShelf.Add(item);
            else if (item is Earring earring1 && earring1.Type == EarringType.Hoop)
                storage.Tree.Add(earring1);
            else if (item is Earring earring2 && earring2.Type == EarringType.Drop && earring2.Stone != Jewel.Plain)
                storage.Box.TopShelf.Add(earring2);
            else if (item is Earring earring3 && earring3.Type == EarringType.Drop)
                storage.Box.MainSection.Add(earring3);
            else if (item is Necklace necklace2)
                storage.Tree.Add(necklace2);

            else
                storage.DresserTop.Add(item);

            if (storage.IsInTravelRoll(item))
                storage.TravelRoll.Remove(item);
        }
    }
}