using NecklaceRefactoringKata.Enums;

namespace NecklaceRefactoringKata.JewelleryTypes
{
    public record PendantNecklace(NecklaceType Type, Jewel Stone, Necklace Chain, JewelleryBase Pendant) : Necklace(Type, Stone)
    {
        public override bool IsLarge()
        {
            return Chain.IsLarge() || Pendant.IsLarge();
        }
    }
}
