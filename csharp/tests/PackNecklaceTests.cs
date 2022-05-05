using System.Collections.Generic;
using ApprovalTests;
using ApprovalTests.Reporters;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using NecklaceRefactoringKata.Enums;
using NecklaceRefactoringKata.JewelleryTypes;

namespace NecklaceRefactoringKata.Tests
{
    [UseReporter(typeof(DiffReporter))]
    [TestClass()]
    public class PackNecklaceTests
    {
        private JewelleryStorage storage = new JewelleryStorage();

        string PackItem(Necklace item, JewelleryStorage storage)
        {
            var log = $"Packing item {item}";
            if (storage.IsInTravelRoll(item))
                log += $" (is in travel roll)";
            Packer.PackNecklace(item, storage);
            log += "\n";
            log += Printers.PrintJewelleryStorage(storage);
            return log;
        }


        [TestMethod()]
        public void PackPearlNecklace()
        {
            var item = new Necklace(Type: NecklaceType.Beads, Stone: Jewel.Pearl);
            Approvals.Verify(PackItem(item, storage));
        }

        [TestMethod()]
        public void PackAmberNecklace()
        {
            var item = new Necklace(Type: NecklaceType.Beads, Stone: Jewel.Amber);
            Approvals.Verify(PackItem(item, storage));
        }
        
        [TestMethod()]
        public void PackAmberChainNecklace()
        {
            var item = new Necklace(Type: NecklaceType.Chain, Stone: Jewel.Amber);
            Approvals.Verify(PackItem(item, storage));
        }

        [TestMethod()]
        public void PackDiamondNecklace()
        {
            var item = new Necklace(Type: NecklaceType.Chain, Stone: Jewel.Diamond);
            Approvals.Verify(PackItem(item, storage));
        }

        [TestMethod()]
        public void PackChain()
        {
            var item = new Necklace(Type: NecklaceType.Chain, Stone: Jewel.Plain);
            Approvals.Verify(PackItem(item, storage));
        }

        [TestMethod()]
        public void PackLongChain()
        {
            var item = new Necklace(Type: NecklaceType.LongChain, Stone: Jewel.Plain);
            Approvals.Verify(PackItem(item, storage));
        }


        [TestMethod()]
        public void PackPendantNecklace()
        {
            var item = new PendantNecklace(
                new Necklace(NecklaceType.Chain, Jewel.Plain),
                new Pendant(Jewel.Amber));
            Approvals.Verify(PackItem(item, storage));
        }
        
        [TestMethod()]
        public void PackPendantNecklaceLongChain()
        {
            var item = new PendantNecklace(
                new Necklace(NecklaceType.LongChain, Jewel.Plain),
                new Pendant(Jewel.Amber));
            Approvals.Verify(PackItem(item, storage));
        }
    }
}