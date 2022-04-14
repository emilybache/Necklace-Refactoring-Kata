<?php

namespace NecklaceRefactoringKata;

enum Jewel {
    case Plain;
    case Diamond;
    case Pearl;
    case Amber;
}

class Jewellery
{
    public function __construct(private Jewel $stone)
    {
    }

    public function isRing(): bool
    {
        return false;
    }

    public function isSmall(): bool
    {
        return false;
    }

    public function isEarring(): bool
    {
        return false;
    }

    public function isNecklace(): bool
    {
        return false;
    }

    public function isLarge(): bool
    {
        return false;
    }
}
