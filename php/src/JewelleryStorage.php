<?php

namespace NecklaceRefactoringKata;

class JewelleryStorage
{
    public JewelleryBox $box;

    /**
     * @var Jewellery[]
     */
    public array $tree;

    /**
     * @var Jewellery[]
     */
    public array $travelRoll;

    /**
     * @var Jewellery[]
     */
    public array $safe;

    /**
     * @var Jewellery[]
     */
    public array $dresserTop;

    public function __construct()
    {
        $this->box = new JewelleryBox();
        $this->tree = [];
        $this->travelRoll = [];
        $this->safe = [];
        $this->dresserTop = [];
    }

    public function isInTravelRoll(Jewellery $item): bool
    {
        return in_array($item, $this->travelRoll);
    }
}
