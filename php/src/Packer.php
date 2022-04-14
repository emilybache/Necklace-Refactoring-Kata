<?php

namespace NecklaceRefactoringKata;

class Packer
{
    public static function packNecklace(Necklace $item, JewelleryStorage $storage): void
    {
        if ($item->stone === Jewel::Diamond) {
            $storage->safe[] = $item;
        } elseif ($item->isLarge()) {
            $storage->box->topShelf[] = $item;
        } elseif ($item->type === NecklaceType::Beads || $item->type === NecklaceType::Chain) {
            $storage->tree[] = $item;
        } elseif ($item->type === NecklaceType::Pendant) {
            /** @var PendantNecklace $item */
            $storage->tree[] = $item->chain;
            $storage->box->topShelf[] = $item->pendant;
        }
    }

    public function pack(Jewellery $item, JewelleryStorage $storage): void
    {
        if ($storage->isInTravelRoll($item) && $item->isRing()) {
            $storage->box->ringCompartment[] = $item;
        } elseif ($storage->isInTravelRoll($item) && !$item->isLarge()) {
            $storage->box->topShelf[] = $item;
        } elseif ($item->stone === Jewel::Diamond) {
            $storage->safe[] = $item;
        } elseif ($item->isRing()) {
            $storage->box->ringCompartment[] = $item;
        } elseif ($item->isSmall()) {
            $storage->box->topShelf[] = $item;
        } elseif ($item->isEarring()) {
            /** @var Earring $item */
            if ($item->type === EarringType::Hoop) {
                $storage->tree[] = $item;
            } elseif ($item->type === EarringType::Drop && $item->stone !== Jewel::Plain) {
                $storage->box->topShelf[] = $item;
            } elseif ($item->type === EarringType::Drop) {
                $storage->box->mainSection[] = $item;
            }
        } elseif ($item->isNecklace()) {
            /** @var Necklace $item */
            if ($item->type === NecklaceType::Beads || $item->type === NecklaceType::Chain) {
                $storage->tree[] = $item;
            } elseif ($item->type === NecklaceType::Pendant) {
                /** @var PendantNecklace $item */
                $storage->tree[] = $item->chain;
                $storage->box->topShelf[] = $item->pendant;
            }
        } else {
            $storage->dresserTop[] = $item;
        }

        if ($storage->isInTravelRoll($item)) {
            $key = array_search($item, $storage->travelRoll);
            unset($storage->travelRoll[$key]);
        }
    }
}
