package necklaceRefactoringKata;

import necklaceRefactoringKata.jewellery.Earring;
import necklaceRefactoringKata.jewellery.EarringType;
import necklaceRefactoringKata.jewellery.Jewel;
import necklaceRefactoringKata.jewellery.Necklace;
import necklaceRefactoringKata.jewellery.NecklaceType;
import necklaceRefactoringKata.jewellery.Pendant;
import necklaceRefactoringKata.jewellery.PendantNecklace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PackJewelleryStorageTests {

    JewelleryStorage storage;

    @BeforeEach
    void setUp() {
        storage = new JewelleryStorage();
    }

    @Test
    void test_pack_earring_stud() {
        var item = new Earring(Jewel.Amber, EarringType.Stud);
        Packer.pack(item, storage);
        // TODO: check it packed it correctly
    }

    @Test
    void test_pack_diamond_pendant_necklace() {
        var item = new PendantNecklace(new Necklace(Jewel.Plain, NecklaceType.Chain), new Pendant(Jewel.Diamond));
        Packer.pack(item, storage);
        // TODO: new feature - only the pendant should be in the safe, not the chain
    }
}
