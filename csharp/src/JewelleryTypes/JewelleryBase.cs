﻿using NecklaceRefactoringKata.Enums;

namespace NecklaceRefactoringKata.JewelleryTypes
{
    public record JewelleryBase(Jewel Stone)
    {
        public virtual bool IsSmall() { return false; }
        public virtual bool IsHeavy() { return false; }
    }
    //TODO: Replace "is a" methods with idiomatic "is"
}
