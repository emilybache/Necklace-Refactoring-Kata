from jewellery_storage import Jewellery, JewelleryStorage, Jewel, EarringType, NecklaceType, Necklace


def pack_necklace(item: Necklace, storage: JewelleryStorage):
    if item.stone == Jewel.Diamond:
        storage.safe.append(item)
    elif not item.is_large():
        storage.box.top_shelf.append(item)
    elif item.type == NecklaceType.Pendant:
        storage.tree.append(item.chain)
        storage.box.top_shelf.append(item.pendant)
    else:
        storage.tree.append(item)


def pack(item: Jewellery, storage: JewelleryStorage):
    if storage.is_in_travel_roll(item) and item.is_ring():
        storage.box.ring_compartment.append(item)
    elif storage.is_in_travel_roll(item) and not item.is_large():
        storage.box.top_shelf.append(item)
    elif item.stone == Jewel.Diamond:
        storage.safe.append(item)
    elif item.is_ring():
        storage.box.ring_compartment.append(item)
    elif item.is_small():
        storage.box.top_shelf.append(item)
    elif item.is_earring() and item.type == EarringType.Hoop:
        storage.tree.append(item)
    elif item.is_earring() and item.type == EarringType.Drop and item.stone is not Jewel.Plain:
        storage.box.top_shelf.append(item)
    elif item.is_earring() and item.type == EarringType.Drop:
        storage.box.main_section.append(item)
    elif item.is_necklace() and item.type == NecklaceType.Pendant:
        storage.tree.append(item.chain)
        storage.box.top_shelf.append(item.pendant)
    elif item.is_necklace():
        storage.tree.append(item)
    else:
        storage.dresser_top.append(item)

    if storage.is_in_travel_roll(item):
        storage.travel_roll.remove(item)