using NecklaceRefactoringKata.JewelleryTypes;

namespace NecklaceRefactoringKata
{
    public class JewelleryBox
    {
        public readonly List<Ring> RingCompartment;
        public readonly List<JewelleryBase> TopShelf;
        public readonly List<JewelleryBase> MainSection;
        public JewelleryBox()
        {
            RingCompartment = new List<Ring>();
            TopShelf = new List<JewelleryBase>();
            MainSection = new List<JewelleryBase>();
        }
    }
}
