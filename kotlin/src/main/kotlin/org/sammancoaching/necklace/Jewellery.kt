package org.sammancoaching.necklace

open class Jewellery(open val stone: Jewel) {
  open fun isRing(): Boolean = false

  open fun isSmall(): Boolean = false

  open fun isEarring(): Boolean = false

  open fun isNecklace(): Boolean = false

  open fun isLarge(): Boolean = false
}
