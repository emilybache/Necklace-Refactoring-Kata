import pytest

from jewellery_storage import JewelleryStorage, Jewellery, Necklace, Earring, PendantNecklace
from packer import pack_necklace


@pytest.fixture
def jewellery_storage():
    return JewelleryStorage()


def print_jewelleries(items):
    return " +\n".join([print_jewellery(j) for j in items])

def print_jewellery(item: Jewellery):
    if isinstance(item, PendantNecklace):
        return f"{print_jewellery(item.chain)} with pendant {print_jewellery(item.pendant)}"
    elif isinstance(item, (Earring, Necklace)):
        return f"{item.type.name} {item.__class__.__name__} of {item.stone.name}"
    else:
        return f"{item.__class__.__name__} of {item.stone.name}"

def print_jewellery_storage(storage: JewelleryStorage):
    
    contents = f"""\
Jewellery Storage:

[%autowidth]
|====
.3+| Box | Ring Compartment |   {print_jewelleries(storage.box.ring_compartment)}
| Top Shelf |                   {print_jewelleries(storage.box.top_shelf)}
| Main Section |                {print_jewelleries(storage.box.main_section)}
2+| Tree |                      {print_jewelleries(storage.tree)}
2+| Travel Roll |               {print_jewelleries(storage.travel_roll)}
2+| Safe |                      {print_jewelleries(storage.safe)}
2+| On top of dresser |         {print_jewelleries(storage.dresser_top)}
|====
"""
    return contents

def print_jewellery_storages(storages):
    
    def format_storage(getter):
        return "\n".join(["* " + print_jewelleries(getter(storage)) for storage in storages if len(getter(storage))>0])
        
    contents = f"""\
Jewellery Storage:

[%autowidth]
|====
.3+| Box | Ring Compartment a|   {format_storage(lambda x: x.box.ring_compartment )}
| Top Shelf a|                   {format_storage(lambda x: x.box.top_shelf )}
| Main Section a|                {format_storage(lambda x: x.box.main_section )}
2+| Tree a|                      {format_storage(lambda x: x.tree )}
2+| Travel Roll a|               {format_storage(lambda x: x.travel_roll)}
2+| Safe a|                      {format_storage(lambda x: x.safe)}
2+| On top of dresser a|         {format_storage(lambda x: x.dresser_top)}
|====
"""
    return contents