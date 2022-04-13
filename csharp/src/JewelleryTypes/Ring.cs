using NecklaceRefactoringKata.Enums;

namespace NecklaceRefactoringKata.JewelleryTypes
{
    public record Ring(Jewel Stone) : JewelleryBase(Stone);
}
