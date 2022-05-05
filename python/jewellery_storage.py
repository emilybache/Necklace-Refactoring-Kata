import dataclasses
from enum import Enum, auto


class Jewel(Enum):
    Plain = auto()
    Diamond = auto()
    Pearl = auto()
    Amber = auto()


class EarringType(Enum):
    Stud = auto()
    Hoop = auto()
    Drop = auto()


class NecklaceType(Enum):
    Beads = auto()
    Chain = auto()
    Pendant = auto()
    LongChain = auto()


@dataclasses.dataclass
class Jewellery:
    stone: Jewel

    def is_ring(self):
        return False

    def is_small(self):
        return False

    def is_earring(self):
        return False

    def is_necklace(self):
        return False

    def is_large(self):
        return False


@dataclasses.dataclass
class Ring(Jewellery):
    def is_ring(self):
        return True


@dataclasses.dataclass
class Earring(Jewellery):
    type: EarringType

    def is_small(self):
        return self.type is EarringType.Stud

    def is_earring(self):
        return True


@dataclasses.dataclass
class Necklace(Jewellery):
    type: NecklaceType

    def is_necklace(self):
        return True

    def is_large(self):
        return self.type is NecklaceType.Beads or self.type is NecklaceType.LongChain


@dataclasses.dataclass
class PendantNecklace(Jewellery):
    chain: Necklace
    pendant: Jewellery

    def __init__(self, chain: Necklace, pendant: Jewellery):
        Jewellery.__init__(self, pendant.stone)
        assert chain.type in [NecklaceType.Chain, NecklaceType.LongChain]
        self.chain = chain
        self.pendant = pendant
        self.type = NecklaceType.Pendant

    def is_large(self):
        return self.chain.is_large() or self.pendant.is_large()

    def is_necklace(self):
        return True


@dataclasses.dataclass
class Pendant(Jewellery):
    def is_small(self):
        return True


class JewelleryBox:
    def __init__(self):
        self.ring_compartment = []
        self.top_shelf = []
        self.main_section = []


class JewelleryStorage:
    def __init__(self):
        self.box = JewelleryBox()
        self.tree = []
        self.travel_roll = []
        self.safe = []
        self.dresser_top = []

    def is_in_travel_roll(self, item):
        return item in self.travel_roll
