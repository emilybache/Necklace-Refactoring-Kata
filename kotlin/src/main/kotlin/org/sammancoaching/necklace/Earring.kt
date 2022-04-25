package org.sammancoaching.necklace

data class Earring(
  val type: EarringType,
  override val stone: Jewel,
) : Jewellery(stone) {
  override fun isSmall(): Boolean = true

  override fun isEarring(): Boolean = true
}
