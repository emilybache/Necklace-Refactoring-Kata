
from jewellery_storage import *
from packer import pack_necklace
# Needed for pytest
from test_jewellery_storage import jewellery_storage

def test_pack_pearl_necklace(jewellery_storage):
    item = Necklace(stone=Jewel.Pearl, type=NecklaceType.Beads)
    pack_necklace(item, jewellery_storage)
    # TODO: check it packed it correctly
