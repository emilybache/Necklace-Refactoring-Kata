package necklace.storage

import necklace.juwellery.Juwellery
import necklace.juwellery.Ring

class JuwelleryBox {
    val ringCompartment = mutableListOf<Ring>()
    val topShelf = mutableListOf<Juwellery>()
    val mainSection = mutableListOf<Juwellery>()
}

class JuwelleryStorage {
    val box = JuwelleryBox()
    val tree = mutableListOf<Juwellery>()
    val travelRoll = mutableListOf<Juwellery>()
    val safe = mutableListOf<Juwellery>()
    val dresserTrop = mutableListOf<Juwellery>()

    fun isInTravelRoll(item: Juwellery): Boolean =
        item in travelRoll
}
