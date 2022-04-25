using ApprovalTests;
using ApprovalTests.Reporters;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using NecklaceRefactoringKata.Enums;
using NecklaceRefactoringKata.JewelleryTypes;

namespace NecklaceRefactoringKata.Tests
{
    [UseReporter(typeof(DiffReporter))]
    [TestClass()]
    public class PackTests
    {
        private JewelleryStorage storage = new JewelleryStorage();

        string PackItem(JewelleryBase item, JewelleryStorage storage)
        {
            var log = $"Packing item {item}";
            if (storage.IsInTravelRoll(item))
                log += $" (is in travel roll)";
            Packer.Pack(item, storage);
            log += "\n";
            log += Printers.PrintJewelleryStorage(storage);
            return log;
        }

        [TestMethod()]
        public void Pack_Earring_Stud()
        {
            var item = new Earring(Type: EarringType.Stud, Stone: Jewel.Amber);
            Approvals.Verify(PackItem(item, storage));
        }

        [TestMethod()]
        public void Pack_Diamond_Earring_Stud()
        {
            var item = new Earring(Type: EarringType.Stud, Stone: Jewel.Diamond);
            Approvals.Verify(PackItem(item, storage));
        }

        [TestMethod()]
        public void Pack_Earring_Hoop()
        {
            var item = new Earring(Type: EarringType.Hoop, Stone: Jewel.Plain);
            Approvals.Verify(PackItem(item, storage));
        }

        [TestMethod()]
        public void Pack_Earring_Drop()
        {
            var item = new Earring(Type: EarringType.Drop, Stone: Jewel.Plain);
            Approvals.Verify(PackItem(item, storage));
        }

        [TestMethod()]
        public void Pack_Earring_Drop_with_Stone()
        {
            var item = new Earring(Type: EarringType.Drop, Stone: Jewel.Amber);
            Approvals.Verify(PackItem(item, storage));
        }

        [TestMethod()]
        public void Pack_Earring_From_Travel_roll()
        {
            var item = new Earring(Type: EarringType.Drop, Stone: Jewel.Plain);
            storage.TravelRoll.Add(item);
            Approvals.Verify(PackItem(item, storage));
        }

        [TestMethod()]
        public void Pack_Necklace_From_Travel_roll()
        {
            var item = new Necklace(Type: NecklaceType.Beads, Stone: Jewel.Pearl);
            storage.TravelRoll.Add(item);
            Approvals.Verify(PackItem(item, storage));
        }

        [TestMethod()]
        public void Pack_Amber_Necklace()
        {
            var item = new Necklace(Type: NecklaceType.Beads, Stone: Jewel.Amber);
            Approvals.Verify(PackItem(item, storage));
        }     [TestMethod()]
        public void Pack_Long_Chain_Necklace()
        {
            var item = new Necklace(Type: NecklaceType.LongChain, Stone: Jewel.Plain);
            Approvals.Verify(PackItem(item, storage));
        }

        [TestMethod()]
        public void Pack_Pendant_Necklace()
        {
            var item = new PendantNecklace(Stone: Jewel.Amber, new Necklace(NecklaceType.Chain, Jewel.Plain),
                new Pendant(Jewel.Amber));
            Approvals.Verify(PackItem(item, storage));
        }      [TestMethod()]
        public void Pack_Pendant()
        {
            var item = new Pendant(Jewel.Amber);
            Approvals.Verify(PackItem(item, storage));
        }
        [TestMethod()]
        public void Pack_Diamond_Pendant_Necklace()
        {
            var item = new PendantNecklace(Stone: Jewel.Diamond, new Necklace(NecklaceType.Chain, Jewel.Plain),
                new Pendant(Jewel.Diamond));
            Approvals.Verify(PackItem(item, storage));
        }
        
        [TestMethod()]
        public void Pack_UnknownItem()
        {
            var item = new JewelleryBase(Jewel.Plain);
            Approvals.Verify(PackItem(item, storage));
        }
    }
}
