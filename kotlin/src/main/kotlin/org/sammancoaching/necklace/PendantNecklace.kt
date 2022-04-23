package org.sammancoaching.necklace

data class PendantNecklace(
  val chain: Necklace,
  val pendant: Jewellery,
  override val type: NecklaceType,
  override val stone: Jewel,
) : Necklace(type, stone) {
  override fun isLarge(): Boolean =
    chain.isLarge() || pendant.isLarge()
}
