using NecklaceRefactoringKata.Enums;

namespace NecklaceRefactoringKata.JewelleryTypes
{
    public record PendantNecklace(Necklace Chain, JewelleryBase Pendant) 
        : Necklace(NecklaceType.Pendant, Pendant.Stone)
    {
        
        public override bool IsHeavy()
        {
            return Chain.IsHeavy() || Pendant.IsHeavy();
        }
    }
}
