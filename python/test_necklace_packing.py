
from jewellery_storage import *
from packer import pack_necklace

# Needed for pytest
from test_jewellery_storage import jewellery_storage
from fixtures import print_jewellery_storage

from fixtures import jewellery_storage, print_jewellery_storage
from doc_as_test_pytest import DocAsTest, doc, doc_module


from fixtures import jewellery_storage, print_jewellery_storage, print_jewellery
from doc_as_test_pytest import DocAsTest, doc, doc_module

def pack_necklace_item(item: Necklace, storage: JewelleryStorage) -> str:
    "workflow shared by all tests in this file"
    log = ""
    log += f"Packing item *{print_jewellery(item)}*"
    log += "\n\n"
    pack_necklace(item, storage)
    log += print_jewellery_storage(storage)
    return log

def test_pack_pearl_necklace(doc, jewellery_storage):
    item = Necklace(stone=Jewel.Pearl, type=NecklaceType.Beads)
    log = pack_necklace_item(item, jewellery_storage)
    doc.write(log)

def test_pack_amber_necklace(doc, jewellery_storage):
    item = Necklace(stone=Jewel.Amber, type=NecklaceType.Beads)
    log = pack_necklace_item(item, jewellery_storage)
    doc.write(log)

def test_pack_diamond_necklace(doc, jewellery_storage):
    item = Necklace(stone=Jewel.Diamond, type=NecklaceType.Chain)
    log = pack_necklace_item(item, jewellery_storage)
    doc.write(log)

def test_pack_chain(doc, jewellery_storage):
    item = Necklace(stone=Jewel.Plain, type=NecklaceType.Chain)
    log = pack_necklace_item(item, jewellery_storage)
    doc.write(log)


def test_pack_pendant_necklace(doc, jewellery_storage):
    item = PendantNecklace(stone=Jewel.Amber,
                           chain=Necklace(stone=Jewel.Plain, type=NecklaceType.Chain),
                           pendant=Jewellery(stone=Jewel.Amber), type=NecklaceType.Pendant)
    log = pack_necklace_item(item, jewellery_storage)
    doc.write(log)

def test_pack_pendant_necklace_large_chain(doc, jewellery_storage):
    item = PendantNecklace(stone=Jewel.Amber,
                           chain=Necklace(stone=Jewel.Plain, type=NecklaceType.LongChain),
                           pendant=Jewellery(stone=Jewel.Amber), type=NecklaceType.Pendant)
    log = pack_necklace_item(item, jewellery_storage)
    doc.write(log)
