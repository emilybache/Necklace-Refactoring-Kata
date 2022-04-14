using NecklaceRefactoringKata.JewelleryTypes;

namespace NecklaceRefactoringKata
{
    public class JewelleryStorage
    {
        public readonly JewelleryBox Box;
        public readonly List<JewelleryBase> Tree;
        public readonly List<JewelleryBase> TravelRoll;
        public readonly List<JewelleryBase> Safe;
        public readonly List<JewelleryBase> DresserTop;

        public JewelleryStorage()
        {
            Box = new JewelleryBox();
            Tree = new List<JewelleryBase>();
            TravelRoll = new List<JewelleryBase>();
            Safe = new List<JewelleryBase>();
            DresserTop = new List<JewelleryBase>();
        }
        public bool IsInTravelRoll(JewelleryBase item)
        {
            return TravelRoll.Contains(item);
        }
    }
}
