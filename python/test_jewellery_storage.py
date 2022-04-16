import pytest

from approvaltests import verify

from jewellery_storage import *
from packer import pack


@pytest.fixture
def jewellery_storage():
    return JewelleryStorage()

from packer import pack
from fixtures import jewellery_storage, print_jewellery_storage
from doc_as_test_pytest import DocAsTest, doc, doc_module


def pack_item(item: Jewellery, storage: JewelleryStorage) -> str:
    "workflow shared by all tests in this file"
    log = "----\n"
    log += f"Packing item {item}"
    if storage.is_in_travel_roll(item):
        log += f" (is in travel roll)"
    pack(item, storage)
    log += "\n"
    log += print_jewellery_storage(storage)
    log += "----"
    return log


def test_pack_earring_stud(doc, jewellery_storage):
    item = Earring(type=EarringType.Stud, stone=Jewel.Amber)
    log = pack_item(item, jewellery_storage)
    doc.write(log)


def test_pack_diamond_earring_stud(doc, jewellery_storage):
    item = Earring(type=EarringType.Stud, stone=Jewel.Diamond)
    log = pack_item(item, jewellery_storage)
    doc.write(log)


def test_pack_earring_hoop(doc, jewellery_storage):
    item = Earring(type=EarringType.Hoop, stone=Jewel.Plain)
    log = pack_item(item, jewellery_storage)
    doc.write(log)


def test_pack_earring_drop(doc, jewellery_storage):
    item = Earring(type=EarringType.Drop, stone=Jewel.Plain)
    log = pack_item(item, jewellery_storage)
    doc.write(log)


def test_pack_earring_drop_with_stone(doc, jewellery_storage):
    item = Earring(type=EarringType.Drop, stone=Jewel.Pearl)
    log = pack_item(item, jewellery_storage)
    doc.write(log)


def test_pack_earring_from_travel_roll(doc, jewellery_storage):
    item = Earring(type=EarringType.Drop, stone=Jewel.Plain)
    jewellery_storage.travel_roll.append(item)
    log = pack_item(item, jewellery_storage)
    doc.write(log)

def test_pack_necklace_from_travel_roll(doc, jewellery_storage):
    item = Necklace(stone=Jewel.Pearl, type=NecklaceType.Beads)
    jewellery_storage.travel_roll.append(item)
    log = pack_item(item, jewellery_storage)
    doc.write(log)


def test_pack_amber_necklace(doc, jewellery_storage):
    item = Necklace(stone=Jewel.Amber, type=NecklaceType.Beads)
    log = pack_item(item, jewellery_storage)
    doc.write(log)

def test_pack_pendant(doc, jewellery_storage):
    item = Pendant(stone=Jewel.Amber)
    log = pack_item(item, jewellery_storage)
    doc.write(log)

def test_pack_pendant_necklace(doc, jewellery_storage):
    item = PendantNecklace(stone=Jewel.Amber,
                           chain=Necklace(stone=Jewel.Plain, type=NecklaceType.Chain),
                           pendant=Jewellery(stone=Jewel.Amber), type=NecklaceType.Pendant)
    log = pack_item(item, jewellery_storage)
    doc.write(log)


def test_pack_diamond_ring(doc, jewellery_storage):
    item = Ring(stone=Jewel.Diamond)
    log = pack_item(item, jewellery_storage)
    doc.write(log)


def test_pack_favourite_diamond_ring(doc, jewellery_storage):
    item = Ring(stone=Jewel.Diamond)
    jewellery_storage.travel_roll.append(item)
    log = pack_item(item, jewellery_storage)
    doc.write(log)


def test_pack_ring(doc, jewellery_storage):
    item = Ring(stone=Jewel.Amber)
    log = pack_item(item, jewellery_storage)
    doc.write(log)


def test_pack_unknown_item(doc, jewellery_storage):
    item = Jewellery(stone=Jewel.Plain)
    log = pack_item(item, jewellery_storage)
    doc.write(log)
