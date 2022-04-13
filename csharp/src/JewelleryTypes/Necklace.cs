using NecklaceRefactoringKata.Enums;

namespace NecklaceRefactoringKata.JewelleryTypes
{
    public record Necklace(NecklaceType Type, Jewel Stone) : JewelleryBase(Stone)
    {
    }
}
