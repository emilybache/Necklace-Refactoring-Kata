<?php

namespace NecklaceRefactoringKata;

class JewelleryBox
{
    /**
     * @var Ring[]
     */
    public readonly array $ringCompartment;

    /**
     * @var Jewellery[]
     */
    public readonly array $topShelf;

    /**
     * @var Jewellery[]
     */
    public readonly array $mainSection;


    public function __construct()
    {
        $this->ringCompartment = [];
        $this->topShelf = [];
        $this->mainSection = [];
    }
}
