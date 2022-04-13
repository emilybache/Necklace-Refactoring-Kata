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
            else if (item.Type == NecklaceType.Beads || item.Type == NecklaceType.Chain)
                storage.Tree.Add(item);
            else if (item is PendantNecklace pendantNecklace)
            {
                storage.Tree.Add(pendantNecklace.Chain);
                storage.Box.TopShelf.Add(pendantNecklace.Pendant);
            }
        }
        public static void Pack()
        {

        }
    }
}