from approvaltests import verify
import pytest

from jewellery_storage import *
from packer import pack


@pytest.fixture
def jewellery_storage():
    return JewelleryStorage()

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
    pack(item, jewellery_storage)
    # TODO: check it packed it correctly


def test_pack_diamond_pendant_necklace(jewellery_storage):
    item = PendantNecklace(chain=Necklace(Jewel.Plain, NecklaceType.Chain), pendant=Pendant(Jewel.Diamond))
    pack(item, jewellery_storage)
    # TODO: new feature - only the pendant should be in the safe, not the chain
