type Jewel = "Plain" | "Diamond" | "Pearl" | "Amber"
type EarringType = "Stud" | "Hoop" | "Drop"
type NecklaceType = "Beads" | "Chain" | "LongChain"
type JewelleryType = "Ring" | "Earring" | "Necklace" | "Pendant"
type JewllerySize = "Small" | "Large"

interface BaseJewellery<TKind extends JewelleryType> {
    _kind: TKind,
    size(): JewllerySize
    stone: Jewel
}

export interface Earring extends BaseJewellery<"Earring"> {
    type: EarringType
}
export interface Ring extends BaseJewellery<"Ring"> { }
export interface Pendant extends BaseJewellery<"Pendant"> { }
export interface Necklace extends BaseJewellery<"Necklace"> {
    type: NecklaceType
}

export interface PendantNecklace extends BaseJewellery<"Necklace"> {
    _kind: "Necklace"
    type: "Pendant"
    chain: Necklace
    pendant: Pendant
}

export type Jewellery = Earring | Ring | Pendant | Necklace | PendantNecklace

export const makeEarring = (stone: Jewel, type: EarringType): Earring => ({
    _kind: "Earring",
    size() { return this.type === "Stud" ? "Small" : "Large" },
    type,
    stone
})

export const makeNecklace = (stone: Jewel, type: NecklaceType): Necklace => ({
    _kind: "Necklace",
    size() { return ["Beads", "LongChain"].includes(this.type) ? "Large" : "Small" },
    type,
    stone
})

export const makePendantNecklace = (pendant: Pendant, chain: NexklaceType): PendantNecklace => ({
    _kind: "Necklace",
    stone: "Plain",
    chain,
    pendant,
    size() {
        if (this.chain.size() === "Large" || this.pendant.size() == "Large")
            return "Large"
        return "Small"
    }
})

export const makePendant = (stone: Jewel): Pendant =>
    ({ _kind: "Pendant", stone, size: () => "Small" })

export const makeRing = (stone: Jewel) =>
    ({_kind: "Ring",size: ()=> "Small", stone});

export interface JewelleryBox {
    ringCompartment: Array<Jewellery>,
    topShelf: Array<Jewellery>,
    mainSection: Array<Jewellery>,
}

export interface JewelleryStorage {
    box: JewelleryBox,
    tree: Array<Jewellery>,
    travelRoll: Array<Jewellery>,
    safe: Array<Jewellery>,
    dresserTop: Array<Jewellery>,
}
