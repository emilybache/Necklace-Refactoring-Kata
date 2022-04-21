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
            else if (!item.IsLarge())
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
            if (storage.IsInTravelRoll(item) && item is Ring ring1)
                storage.Box.RingCompartment.Add(ring1);
            else if (storage.IsInTravelRoll(item) && !item.IsLarge())
                storage.Box.TopShelf.Add(item);
            else if (item.Stone == Jewel.Diamond)
                storage.Safe.Add(item);
            else if (item is Ring ring2)
                storage.Box.RingCompartment.Add(ring2);
            else if (item.IsSmall())
                storage.Box.TopShelf.Add(item);
            else if (item is Earring earring)
            {
                if (earring.Type == EarringType.Hoop)
                    storage.Tree.Add(earring);
                else if (earring.Type == EarringType.Drop && earring.Stone != Jewel.Plain)
                    storage.Box.TopShelf.Add(earring);
                else if (earring.Type == EarringType.Drop)
                    storage.Box.MainSection.Add(earring);
            }
            else if (item is Necklace necklace)
            {
                if (necklace.Type == NecklaceType.Beads || necklace.Type == NecklaceType.Chain)
                    storage.Tree.Add(necklace);
                else if (necklace is PendantNecklace pendantNecklace)
                {
                    storage.Tree.Add(pendantNecklace.Chain);
                    storage.Box.TopShelf.Add(pendantNecklace.Pendant);
                }
            }
            else
                storage.DresserTop.Add(item);

            if (storage.IsInTravelRoll(item))
                storage.TravelRoll.Remove(item);
        }
    }
}