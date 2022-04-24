package necklace

import necklace.enums.Juwel
import necklace.juwellery.Necklace
import necklace.juwellery.PendantNecklace
import necklace.storage.JuwelleryStorage


fun packNecklace(item: Necklace, storage: JuwelleryStorage) {
    when {
        item.stone == Juwel.Diamond ->
            storage.safe.add(item)
        !item.isLarge ->
            storage.box.topShelf.add(item)
        item is PendantNecklace -> {
            storage.tree.add(item.chain)
            storage.box.topShelf.add(item.pendant)
        }
        else ->
            storage.tree.add(item)
    }
}
