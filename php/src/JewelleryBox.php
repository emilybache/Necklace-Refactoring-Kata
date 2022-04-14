<?php

namespace NecklaceRefactoringKata;

class JewelleryBox
{
    /**
     * @var Ring[]
     */
    public array $ringCompartment;

    /**
     * @var Jewellery[]
     */
    public array $topShelf;

    /**
     * @var Jewellery[]
     */
    public array $mainSection;


    public function __construct()
    {
        $this->ringCompartment = [];
        $this->topShelf = [];
        $this->mainSection = [];
    }
}
