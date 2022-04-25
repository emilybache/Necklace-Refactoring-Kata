from approvaltests import verify

from jewellery_storage import *
from packer import pack
from fixtures import jewellery_storage, print_jewellery_storage


def pack_item(item: Jewellery, storage: JewelleryStorage) -> str:
    "workflow shared by all tests in this file"
    log = f"Packing item {item}"
    if storage.is_in_travel_roll(item):
        log += f" (is in travel roll)"
    pack(item, storage)
    log += "\n"
    log += print_jewellery_storage(storage)
    return log


def test_pack_earring_stud(jewellery_storage):
    item = Earring(type=EarringType.Stud, stone=Jewel.Amber)
    log = pack_item(item, jewellery_storage)
    verify(log)


def test_pack_diamond_earring_stud(jewellery_storage):
    item = Earring(type=EarringType.Stud, stone=Jewel.Diamond)
    log = pack_item(item, jewellery_storage)
    verify(log)


def test_pack_earring_hoop(jewellery_storage):
    item = Earring(type=EarringType.Hoop, stone=Jewel.Plain)
    log = pack_item(item, jewellery_storage)
    verify(log)


def test_pack_earring_drop(jewellery_storage):
    item = Earring(type=EarringType.Drop, stone=Jewel.Plain)
    log = pack_item(item, jewellery_storage)
    verify(log)


def test_pack_earring_drop_with_stone(jewellery_storage):
    item = Earring(type=EarringType.Drop, stone=Jewel.Pearl)
    log = pack_item(item, jewellery_storage)
    verify(log)


def test_pack_earring_from_travel_roll(jewellery_storage):
    item = Earring(type=EarringType.Drop, stone=Jewel.Plain)
    jewellery_storage.travel_roll.append(item)
    log = pack_item(item, jewellery_storage)
    verify(log)

def test_pack_necklace_from_travel_roll(jewellery_storage):
    item = Necklace(stone=Jewel.Pearl, type=NecklaceType.Beads)
    jewellery_storage.travel_roll.append(item)
    log = pack_item(item, jewellery_storage)
    verify(log)


def test_pack_amber_necklace(jewellery_storage):
    item = Necklace(stone=Jewel.Amber, type=NecklaceType.Beads)
    log = pack_item(item, jewellery_storage)
    verify(log)

def test_pack_pendant(jewellery_storage):
    item = Pendant(stone=Jewel.Amber)
    log = pack_item(item, jewellery_storage)
    verify(log)

def test_pack_pendant_necklace(jewellery_storage):
    item = PendantNecklace(stone=Jewel.Amber,
                           chain=Necklace(stone=Jewel.Plain, type=NecklaceType.Chain),
                           pendant=Jewellery(stone=Jewel.Amber), type=NecklaceType.Pendant)
    log = pack_item(item, jewellery_storage)
    verify(log)


def test_pack_unknown_item(jewellery_storage):
    item = Jewellery(stone=Jewel.Plain)
    log = pack_item(item, jewellery_storage)
    verify(log)

def test_pack_long_chain(jewellery_storage):
    item = Necklace(stone=Jewel.Plain, type=NecklaceType.LongChain)
    log = pack_item(item, jewellery_storage)
    verify(log)

def test_pack_diamond_pendant_necklace(jewellery_storage):
    item = PendantNecklace(stone=Jewel.Diamond,
                           chain=Necklace(stone=Jewel.Plain, type=NecklaceType.Chain),
                           pendant=Jewellery(stone=Jewel.Diamond), type=NecklaceType.Pendant)
    log = pack_item(item, jewellery_storage)
    verify(log)
