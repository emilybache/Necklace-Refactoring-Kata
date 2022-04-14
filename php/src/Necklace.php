<?php

namespace NecklaceRefactoringKata;

enum NecklaceType {
    case Beads;
    case Chain;
    case Pendant;
    case LongChain;
}

class Necklace extends Jewellery
{
    public function __construct(public NecklaceType $type)
    {
    }

    public function isNecklace(): bool
    {
        return true;
    }

    public function isLarge(): bool
    {
        return $this->type === NecklaceType::Beads || $this->type === NecklaceType::LongChain;
    }
}
