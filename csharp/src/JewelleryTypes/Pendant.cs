using NecklaceRefactoringKata.Enums;

namespace NecklaceRefactoringKata.JewelleryTypes
{
    public record Pendant(Jewel Stone) : JewelleryBase(Stone)
    {
        public override bool IsSmall()
        {
            return true;
        }
    }
}
