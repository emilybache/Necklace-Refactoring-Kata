using NecklaceRefactoringKata.Enums;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NecklaceRefactoringKata.Models
{
    public record Jewellery(Jewel Stone)
    {
        public virtual bool IsRing() { return false; }
        public virtual bool IsSmall() { return false; }
        public virtual bool IsEarring() { return false; }
        public virtual bool IsNecklace() { return false; }
        public virtual bool IsLarge() { return false; }
    }
}
