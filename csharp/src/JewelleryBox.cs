using NecklaceRefactoringKata.JewelleryTypes;

namespace NecklaceRefactoringKata
{
    public class JewelleryBox
    {
        public readonly List<JewelleryBase> RingCompartment;
        public readonly List<JewelleryBase> TopShelf;
        public readonly List<JewelleryBase> MainSection;
        public JewelleryBox()
        {
            RingCompartment = new List<JewelleryBase>();
            TopShelf = new List<JewelleryBase>();
            MainSection = new List<JewelleryBase>();
        }
    }
}
