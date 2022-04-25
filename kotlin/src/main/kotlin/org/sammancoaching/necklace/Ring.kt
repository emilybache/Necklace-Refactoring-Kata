package org.sammancoaching.necklace

data class Ring(override val stone: Jewel) : Jewellery(stone) {
  override fun isRing(): Boolean = true
}
