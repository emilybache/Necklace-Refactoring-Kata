import pytest

from jewellery_storage import JewelleryStorage


@pytest.fixture
def jewellery_storage():
    return JewelleryStorage()


def print_jewellery_storage(storage: JewelleryStorage):
    contents = f"""\
Jewellery Storage:

[%autowidth]
|====
.3+| Box | Ring Compartment |   {storage.box.ring_compartment}
| Top Shelf |                   {storage.box.top_shelf}
| Main Section |                {storage.box.main_section}
2+| Tree |                      {storage.tree}
2+| Travel Roll |               {storage.travel_roll}
2+| Safe |                      {storage.safe}
2+| On top of dresser |         {storage.dresser_top}
|====
"""
    return contents