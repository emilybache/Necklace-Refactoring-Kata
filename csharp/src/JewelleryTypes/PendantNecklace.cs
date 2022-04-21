using NecklaceRefactoringKata.Enums;

namespace NecklaceRefactoringKata.JewelleryTypes
{
    public record PendantNecklace(Jewel Stone, Necklace Chain, JewelleryBase Pendant) 
        : Necklace(NecklaceType.Pendant, Stone)
    {
        
        public override bool IsLarge()
        {
            return Chain.IsLarge() || Pendant.IsLarge();
        }
    }
}
