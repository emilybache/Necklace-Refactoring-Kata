package org.sammancoaching.necklace

import org.junit.jupiter.api.Test

internal class JewelleryStorageTest {
  @Test
  internal fun `pack earring stud`() {
    val storage = JewelleryStorage()
    val earring = Earring(EarringType.Stud, Jewel.Amber)
    pack(earring, storage)
    TODO("check it packed it correctly")
  }
}
