from approvaltests import verify

from jewellery_storage import *
from packer import pack_necklace
from fixtures import jewellery_storage, print_jewellery_storage


def pack_necklace_item(item: Necklace, storage: JewelleryStorage) -> str:
    "workflow shared by all tests in this file"
    log = f"Packing item {item}"
    pack_necklace(item, storage)
    log += "\n"
    log += print_jewellery_storage(storage)
    return log

def test_pack_pearl_necklace(jewellery_storage):
    item = Necklace(stone=Jewel.Pearl, type=NecklaceType.Beads)
    log = pack_necklace_item(item, jewellery_storage)
    verify(log)

def test_pack_amber_necklace(jewellery_storage):
    item = Necklace(stone=Jewel.Amber, type=NecklaceType.Beads)
    log = pack_necklace_item(item, jewellery_storage)
    verify(log)

def test_pack_diamond_necklace(jewellery_storage):
    item = Necklace(stone=Jewel.Diamond, type=NecklaceType.Chain)
    log = pack_necklace_item(item, jewellery_storage)
    verify(log)

def test_pack_chain(jewellery_storage):
    item = Necklace(stone=Jewel.Plain, type=NecklaceType.Chain)
    log = pack_necklace_item(item, jewellery_storage)
    verify(log)


def test_pack_pendant_necklace(jewellery_storage):
    item = PendantNecklace(stone=Jewel.Amber,
                           chain=Necklace(stone=Jewel.Plain, type=NecklaceType.Chain),
                           pendant=Jewellery(stone=Jewel.Amber), type=NecklaceType.Pendant)
    log = pack_necklace_item(item, jewellery_storage)
    verify(log)

def test_pack_pendant_necklace_large_chain(jewellery_storage):
    item = PendantNecklace(stone=Jewel.Amber,
                           chain=Necklace(stone=Jewel.Plain, type=NecklaceType.LongChain),
                           pendant=Jewellery(stone=Jewel.Amber), type=NecklaceType.Pendant)
    log = pack_necklace_item(item, jewellery_storage)
    verify(log)

def test_pack_diamond_pendant_necklace(jewellery_storage):
    item = PendantNecklace(stone=Jewel.Diamond,
                           chain=Necklace(stone=Jewel.Plain, type=NecklaceType.Chain),
                           pendant=Jewellery(stone=Jewel.Diamond), type=NecklaceType.Pendant)
    log = pack_necklace_item(item, jewellery_storage)
    verify(log)


def test_pack_long_chain(jewellery_storage):
    item = Necklace(stone=Jewel.Plain, type=NecklaceType.LongChain)
    log = pack_necklace_item(item, jewellery_storage)
    verify(log)