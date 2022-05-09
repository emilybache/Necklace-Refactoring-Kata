package necklaceRefactoringKata;

import necklaceRefactoringKata.jewellery.Earring;
import necklaceRefactoringKata.jewellery.EarringType;
import necklaceRefactoringKata.jewellery.Jewel;
import necklaceRefactoringKata.jewellery.Jewellery;
import necklaceRefactoringKata.jewellery.Necklace;
import necklaceRefactoringKata.jewellery.PendantNecklace;

public class Packer {

    public static void packNecklace(Necklace item, JewelleryStorage storage) {
        if (item.stone == Jewel.Diamond) {
            storage.safe.add(item);
        } else if (!item.isHeavy()) {
            storage.box.topShelf.add(item);
        } else if (item instanceof PendantNecklace pendantNecklace) {
            storage.tree.add(pendantNecklace.chain);
            storage.box.topShelf.add(pendantNecklace.pendant);
        } else {
            storage.tree.add(item);
        }
    }

    public static void pack(Jewellery item, JewelleryStorage storage) {
        if (storage.IsInTravelRoll(item) && !item.isHeavy()) {
            storage.box.topShelf.add(item);
        } else if (item.stone == Jewel.Diamond) {
            storage.safe.add(item);
        } else if (item instanceof PendantNecklace pendantNecklace) {
            storage.tree.add(pendantNecklace.chain);
            storage.box.topShelf.add(pendantNecklace.pendant);
        } else if (item.isSmall()) {
            storage.box.topShelf.add(item);
        } else if (!item.isHeavy() && item instanceof Necklace) {
            storage.box.topShelf.add(item);
        } else if (item instanceof Earring earring && earring.type == EarringType.Hoop) {
            storage.tree.add(earring);
        } else if (item instanceof Earring earring && earring.type == EarringType.Drop && earring.stone != Jewel.Plain) {
            storage.box.topShelf.add(earring);
        } else if (item instanceof Earring earring && earring.type == EarringType.Drop) {
            storage.box.mainSection.add(earring);
        } else if (item instanceof Necklace necklace) {
            storage.tree.add(necklace);
        } else {
            storage.dresserTop.add(item);
        }

        if (storage.IsInTravelRoll(item))
            storage.travelRoll.remove(item);
    }
}
