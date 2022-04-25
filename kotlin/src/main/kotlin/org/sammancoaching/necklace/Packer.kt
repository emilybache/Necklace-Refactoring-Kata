package org.sammancoaching.necklace

fun packNecklace(item: Necklace, storage: JewelleryStorage) {
  if (item.stone == Jewel.Diamond) {
    storage.safe.add(item)
  } else if (item.isLarge().not()) {
    storage.box.topShelf.add(item)
  } else if (item is PendantNecklace) {
    storage.tree.add(item.chain)
    storage.box.topShelf.add(item.pendant)
  } else {
    storage.tree.add(item)
  }
}

fun pack(item: Jewellery, storage: JewelleryStorage) {
  if (storage.isInTravelRoll(item) and item.isLarge().not()) {
    storage.box.topShelf.add(item)
  } else if (item.stone == Jewel.Diamond) {
    storage.safe.add(item)
  } else if (item.isSmall()) {
    storage.box.topShelf.add(item)
  } else if (item is Earring && item.type == EarringType.Hoop) {
    storage.tree.add(item)
  } else if (item is Earring && item.type == EarringType.Drop && item.stone != Jewel.Plain) {
    storage.box.topShelf.add(item)
  } else if (item is Earring && item.type == EarringType.Drop) {
    storage.box.mainSection.add(item)
  } else if (item is PendantNecklace && item.type == NecklaceType.Pendant) {
    storage.tree.add(item.chain)
    storage.box.topShelf.add(item.pendant)
  } else if (item.isNecklace()) {
    storage.tree.add(item)
  } else {
    storage.dresserTop.add(item)
  }

  if (storage.isInTravelRoll(item)) {
    storage.travelRoll.remove(item)
  }
}
