package org.sammancoaching.necklace

class JewelleryStorage(
  val box: JewelleryBox = JewelleryBox(),
  val tree: MutableList<Jewellery> = mutableListOf(),
  val travelRoll: MutableList<Jewellery> = mutableListOf(),
  val safe: MutableList<Jewellery> = mutableListOf(),
  val dresserTop: MutableList<Jewellery> = mutableListOf(),
) {
  fun isInTravelRoll(item: Jewellery): Boolean =
    item in travelRoll
}
