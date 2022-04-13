using NecklaceRefactoringKata.Enums;

namespace NecklaceRefactoringKata.Models
{
    public record Earring(EarringType Type, Jewel Stone) : JewelleryBase(Stone)
    {
        public override bool IsSmall()
        {
            return Type == EarringType.Stud;
        }
        public override bool IsEarring()
        {
            return true;
        }
    }
}
