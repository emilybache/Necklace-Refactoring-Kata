using Microsoft.VisualStudio.TestTools.UnitTesting;
using NecklaceRefactoringKata.Enums;
using NecklaceRefactoringKata.JewelleryTypes;

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
        
        [TestMethod()]
        public void Test_Diamond_Pendant_Necklace()
        {
            //arrange
            var jewelleryStorage = new JewelleryStorage();
            var item = new PendantNecklace(new Necklace(NecklaceType.Chain, Jewel.Plain), new Pendant(Jewel.Diamond));
            
            //act
            Packer.PackNecklace(item, jewelleryStorage);

            //assert
            // TODO: pendant should be in safe but not chain
        }
    }
}