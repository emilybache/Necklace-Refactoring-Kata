<?php

namespace NecklaceRefactoringKata;

class PendantNecklace extends Necklace
{
    public function __construct(private Necklace $chain, private Jewellery $pendant)
    {
    }

    public function isLarge(): bool
    {
        return $this->chain->isLarge() || $this->pendant->isLarge();
    }
}
