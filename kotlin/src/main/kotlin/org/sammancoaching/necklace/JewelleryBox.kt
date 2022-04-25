package org.sammancoaching.necklace

data class JewelleryBox(
  val ringCompartment: MutableList<Ring> = mutableListOf(),
  val topShelf: MutableList<Jewellery> = mutableListOf(),
  val mainSection: MutableList<Jewellery> = mutableListOf(),
)
