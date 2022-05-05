using NecklaceRefactoringKata.Enums;

namespace NecklaceRefactoringKata.JewelleryTypes
{
    public record Necklace(NecklaceType Type, Jewel Stone) : JewelleryBase(Stone)
    {
        public override bool IsHeavy()
        {
            return Type == NecklaceType.Beads || Type == NecklaceType.LongChain;
        }
    }
}
