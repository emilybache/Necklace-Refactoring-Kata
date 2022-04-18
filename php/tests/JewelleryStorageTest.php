<?php

namespace Tests\NecklaceRefactoringKata;

use NecklaceRefactoringKata\Earring;
use NecklaceRefactoringKata\EarringType;
use NecklaceRefactoringKata\Jewel;
use NecklaceRefactoringKata\JewelleryStorage;
use NecklaceRefactoringKata\Packer;
use PHPUnit\Framework\TestCase;

class JewelleryStorageTest extends TestCase
{
    function test_pack_earring_stud(): void
    {
        $storage = new JewelleryStorage();
        $item = new Earring(Jewel::Amber, EarringType::Stud);

        Packer::pack($item, $storage);

        $this->assertContains($item, $storage->box->topShelf);
    }
}
