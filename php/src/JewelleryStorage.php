<?php

namespace NecklaceRefactoringKata;

class JewelleryStorage
{
    public readonly JewelleryBox $box;

    /**
     * @var Jewellery[]
     */
    public readonly array $tree;

    /**
     * @var Jewellery[]
     */
    public readonly array $travelRoll;

    /**
     * @var Jewellery[]
     */
    public readonly array $safe;

    /**
     * @var Jewellery[]
     */
    public readonly array $dresserTop;

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
