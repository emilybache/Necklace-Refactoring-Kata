package necklaceRefactoringKata.jewellery;

import necklaceRefactoringKata.JewelleryStorage;
import necklaceRefactoringKata.Packer;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

public class PackTests {
    private JewelleryStorage storage = new JewelleryStorage();
    String PackItem(Jewellery item, JewelleryStorage storage)
    {
        var log = "Packing item " + item;
        if (storage.IsInTravelRoll(item))
            log += " (is in travel roll)";
        Packer.pack(item, storage);
        log += "\n";
        log += Printers.PrintJewelleryStorage(storage);
        return log;
    }

    @Test
    public void Pack_Earring_Stud()
    {
        var item = new Earring(EarringType.Stud, Jewel.Amber);
        Approvals.verify(PackItem(item, storage));
    }

        @Test
    public void Pack_Diamond_Earring_Stud()
    {
        var item = new Earring(EarringType.Stud, Jewel.Diamond);
        Approvals.verify(PackItem(item, storage));
    }

        @Test
    public void Pack_Earring_Hoop()
    {
        var item = new Earring(EarringType.Hoop, Jewel.Plain);
        Approvals.verify(PackItem(item, storage));
    }

        @Test
    public void Pack_Earring_Drop()
    {
        var item = new Earring(EarringType.Drop, Jewel.Plain);
        Approvals.verify(PackItem(item, storage));
    }

        @Test
    public void Pack_Earring_Drop_with_Stone()
    {
        var item = new Earring(EarringType.Drop, Jewel.Amber);
        Approvals.verify(PackItem(item, storage));
    }

        @Test
    public void Pack_Earring_From_Travel_roll()
    {
        var item = new Earring(EarringType.Drop, Jewel.Plain);
        storage.travelRoll.add(item);
        Approvals.verify(PackItem(item, storage));
    }

        @Test
    public void Pack_Necklace_From_Travel_roll()
    {
        var item = new Necklace(NecklaceType.Beads, Jewel.Pearl);
        storage.travelRoll.add(item);
        Approvals.verify(PackItem(item, storage));
    }

        @Test
    public void Pack_Amber_Necklace()
    {
        var item = new Necklace(NecklaceType.Beads, Jewel.Amber);
        Approvals.verify(PackItem(item, storage));
    }

        @Test
    public void PackAmberChainNecklace()
    {
        var item = new Necklace(NecklaceType.Chain, Jewel.Amber);
        Approvals.verify(PackItem(item, storage));
    }

        @Test
    public void Pack_Long_Chain_Necklace()
    {
        var item = new Necklace(NecklaceType.LongChain, Jewel.Plain);
        Approvals.verify(PackItem(item, storage));
    }

        @Test
    public void Pack_Pendant_Necklace()
    {
        var item = new PendantNecklace(Jewel.Amber, NecklaceType.Chain,
                new Necklace(NecklaceType.Chain, Jewel.Plain),
                new Pendant(Jewel.Amber));
        Approvals.verify(PackItem(item, storage));
    }

        @Test
    public void Pack_Pendant()
    {
        var item = new Pendant(Jewel.Amber);
        Approvals.verify(PackItem(item, storage));
    }

        @Test
    public void Pack_Diamond_Pendant_Necklace()
    {
        var item = new PendantNecklace(Jewel.Diamond, NecklaceType.Chain,
                new Necklace(NecklaceType.Chain, Jewel.Plain),
                new Pendant(Jewel.Diamond));
        Approvals.verify(PackItem(item, storage));
    }

        @Test
    public void Pack_UnknownItem()
    {
        var item = new Ring(Jewel.Plain);
        Approvals.verify(PackItem(item, storage));
    }
}
