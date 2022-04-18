<?php

namespace NecklaceRefactoringKata;

class PendantNecklace extends Necklace
{
    public function __construct(
        public Jewel $stone,
        public NecklaceType $type,
        public Necklace $chain,
        public Jewellery $pendant
    ) {
    }

    public function isLarge(): bool
    {
        return $this->chain->isLarge() || $this->pendant->isLarge();
    }
}
