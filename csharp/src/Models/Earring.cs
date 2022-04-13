using NecklaceRefactoringKata.Enums;

namespace NecklaceRefactoringKata.Models
{
    public record Earring(EarringType Type, Jewel Stone) : Jewellery(Stone, IsSmall: Type == EarringType.Stud, IsEarring: true);
}
