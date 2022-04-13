
from jewellery_storage import *
from packer import pack_necklace

# Needed for pytest
from test_jewellery_storage import jewellery_storage
from fixtures import print_jewellery_storage


def pack_necklace_item(item: Necklace, storage: JewelleryStorage) -> str:
    "workflow shared by all tests in this file"
    log = f"Packing item {item}"
    pack_necklace(item, storage)
    log += "\n"
    log += print_jewellery_storage(storage)
    return log

def test_pack_pearl_necklace(jewellery_storage):
    item = Necklace(stone=Jewel.Pearl, type=NecklaceType.Beads)
    pack_necklace(item, jewellery_storage)
    # TODO: check it packed it correctly


def test_pack_diamond_pendant_necklace(jewellery_storage):
    item = PendantNecklace(chain=Necklace(Jewel.Plain, NecklaceType.Chain), pendant=Pendant(Jewel.Diamond))
    pack_necklace(item, jewellery_storage)
    # TODO: new feature - only the pendant should be in the safe, not the chain
