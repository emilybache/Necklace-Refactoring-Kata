using Microsoft.VisualStudio.TestTools.UnitTesting;
using NecklaceRefactoringKata;
using NecklaceRefactoringKata.Enums;
using NecklaceRefactoringKata.JewelleryTypes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NecklaceRefactoringKata.Tests
{
    [TestClass()]
    public class PackNecklaceTests
    {
        [TestMethod()]
        public void Test_AmberBeadsNecklace_IsPackedInTree()
        {
            //arrange
            var jewelleryStorage = new JewelleryStorage();
            var item = new Necklace(Type: NecklaceType.Beads, Stone: Jewel.Amber);
            
            //act
            Packer.PackNecklace(item, jewelleryStorage);

            //assert
            CollectionAssert.Contains(jewelleryStorage.Tree, item);
        }

        //To devs: Write more tests here before you refactor
        
        //note: JewelleryBase types are records, so they automatically have value-based equality checks
        //and can be used with CollectionAssert
    }
}