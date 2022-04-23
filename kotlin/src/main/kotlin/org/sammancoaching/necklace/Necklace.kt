package org.sammancoaching.necklace

open class Necklace (
  open val type: NecklaceType,
  override val stone: Jewel,
) : Jewellery(stone) {
  override fun isNecklace(): Boolean = true

  override fun isLarge(): Boolean =
    type == NecklaceType.Beads || type == NecklaceType.LongChain
}
