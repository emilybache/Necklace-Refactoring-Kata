package necklaceRefactoringKata.jewellery;

import necklaceRefactoringKata.JewelleryStorage;
import necklaceRefactoringKata.Packer;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

class PackNecklaceTests {
    private JewelleryStorage storage = new JewelleryStorage();

    String PackItem(Necklace item, JewelleryStorage storage) {
        var log = "Packing item " + item;
        if (storage.IsInTravelRoll(item))
            log += " (is in travel roll)";
        Packer.packNecklace(item, storage);
        log += "\n";
        log += Printers.PrintJewelleryStorage(storage);
        return log;
    }

    @Test
    public void PackPearlNecklace() {
        var item = new Necklace(NecklaceType.Beads, Jewel.Pearl);
        Approvals.verify(PackItem(item, storage));
    }

    @Test
    public void PackAmberNecklace() {
        var item = new Necklace(NecklaceType.Beads, Jewel.Amber);
        Approvals.verify(PackItem(item, storage));
    }

    @Test
    public void PackAmberChainNecklace() {
        var item = new Necklace(NecklaceType.Chain, Jewel.Amber);
        Approvals.verify(PackItem(item, storage));
    }

    @Test
    public void PackDiamondNecklace() {
        var item = new Necklace(NecklaceType.Chain, Jewel.Diamond);
        Approvals.verify(PackItem(item, storage));
    }

    @Test
    public void PackChain() {
        var item = new Necklace(NecklaceType.Chain, Jewel.Plain);
        Approvals.verify(PackItem(item, storage));
    }

    @Test
    public void PackLongChain() {
        var item = new Necklace(NecklaceType.LongChain, Jewel.Plain);
        Approvals.verify(PackItem(item, storage));
    }


    @Test
    public void PackPendantNecklace() {
        var item = new PendantNecklace(Jewel.Amber, NecklaceType.Chain,
                new Necklace(NecklaceType.Chain, Jewel.Plain),
                new Pendant(Jewel.Amber));
        Approvals.verify(PackItem(item, storage));
    }

    @Test
    public void PackPendantNecklaceLongChain() {
        var item = new PendantNecklace(Jewel.Amber, NecklaceType.LongChain,
                new Necklace(NecklaceType.LongChain, Jewel.Plain),
                new Pendant(Jewel.Amber));
        Approvals.verify(PackItem(item, storage));
    }
}
