package necklace

import io.kotest.matchers.collections.shouldContain
import necklace.enums.Juwel
import necklace.enums.NecklaseType
import necklace.juwellery.SimpleNecklace
import necklace.storage.JuwelleryStorage
import org.junit.jupiter.api.Test


class PackNecklaceTests {

    @Test
    internal fun `amber beads necklace is packed in tree`() {
        val storage = JuwelleryStorage()
        val necklace = SimpleNecklace(NecklaseType.Beads, Juwel.Amber)

        packNecklace(necklace, storage)

        storage.tree shouldContain necklace
    }

    // To devs: Write more tests here before you refactor

    // note: Jewellery types are data classes, so they automatically have value-based equality checks
    // and can be used with e.g. Kotest shoudBe and shouldContain assertions.
}
