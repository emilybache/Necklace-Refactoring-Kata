using NecklaceRefactoringKata.Enums;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NecklaceRefactoringKata.Models
{
    public record Jewellery(Jewel Stone, bool IsRing=false, bool IsSmall=false, bool IsEarring=false, bool IsNecklace=false, bool IsLarge=false);
}
