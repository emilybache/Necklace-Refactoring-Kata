using NecklaceRefactoringKata.Enums;

namespace NecklaceRefactoringKata.JewelleryTypes
{
    public record Earring(EarringType Type, Jewel Stone) : JewelleryBase(Stone)
    {
        public override bool IsSmall()
        {
            return Type == EarringType.Stud;
        }
    }
}
