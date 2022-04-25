package org.sammancoaching.necklace

import org.junit.jupiter.api.Test

internal class PackerTest {
  @Test
  internal fun `pack pearl necklace`() {
    val storage = JewelleryStorage()
    val item = Necklace(NecklaceType.Beads, Jewel.Pearl)
    packNecklace(item, storage)
    TODO("check it packed it correctly")
  }
}
