package necklace.juwellery

import necklace.enums.EarringType
import necklace.enums.Juwel
import necklace.enums.NecklaseType


sealed class Juwellery(open val stone: Juwel) {
    open val isSmall = false
    open val isLarge = false
}

data class Earring(val type: EarringType, override val stone: Juwel) : Juwellery(stone) {
    override val isSmall: Boolean
        get() = type == EarringType.Stud
}

data class Pendant(override val stone: Juwel) : Juwellery(stone) {
    override val isSmall: Boolean
        get() = true
}

data class Ring(override val stone: Juwel): Juwellery(stone)

sealed class Necklace(open val type: NecklaseType, override val stone: Juwel): Juwellery(stone)

data class SimpleNecklace(override val type: NecklaseType, override val stone: Juwel) : Necklace(type, stone) {
    override val isLarge: Boolean
        get() = type in listOf(NecklaseType.Beads, NecklaseType.LongChain)
}

data class PendantNecklace(
    override val type: NecklaseType,
    override val stone: Juwel,
    val chain: SimpleNecklace,
    val pendant: Juwellery
) : Necklace(type, stone) {
    override val isLarge: Boolean
        get() = chain.isLarge || pendant.isLarge
}
