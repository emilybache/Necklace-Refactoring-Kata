package org.sammancoaching.necklace

data class Pendant(override val stone: Jewel) : Jewellery(stone) {
  override fun isSmall(): Boolean = true
}
