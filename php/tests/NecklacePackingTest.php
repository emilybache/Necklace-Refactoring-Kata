<?php

namespace Tests\NecklaceRefactoringKata;

use NecklaceRefactoringKata\Jewel;
use NecklaceRefactoringKata\JewelleryStorage;
use NecklaceRefactoringKata\Necklace;
use NecklaceRefactoringKata\NecklaceType;
use NecklaceRefactoringKata\Packer;
use PHPUnit\Framework\TestCase;

class NecklacePackingTest extends TestCase
{
    function test_pack_pearl_necklace(): void
    {
        $storage = new JewelleryStorage();
        $item = new Necklace(Jewel::Pearl, NecklaceType::Beads);

        Packer::packNecklace($item, $storage);

        $this->assertContains($item, $storage->tree);
    }
}
