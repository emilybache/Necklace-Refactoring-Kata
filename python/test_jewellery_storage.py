import pytest

from jewellery_storage import *
from packer import pack


@pytest.fixture
def jewellery_storage():
    return JewelleryStorage()


def test_pack_earring_stud(jewellery_storage):
    item = Earring(type=EarringType.Stud, stone=Jewel.Amber)
    pack(item, jewellery_storage)
    # TODO: check it packed it correctly

