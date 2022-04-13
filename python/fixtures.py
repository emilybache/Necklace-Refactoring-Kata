import pytest

from jewellery_storage import JewelleryStorage


@pytest.fixture
def jewellery_storage():
    return JewelleryStorage()


def print_jewellery_storage(storage: JewelleryStorage):
    contents = f"""\
Jewellery Storage:
    Box:
        Ring Compartment: {storage.box.ring_compartment}
        Top Shelf:        {storage.box.top_shelf}
        Main Section:     {storage.box.main_section}
    Tree:                 {storage.tree}
    Travel Roll:          {storage.travel_roll}
    Safe:                 {storage.safe}
    On top of dresser:    {storage.dresser_top}
"""
    return contents