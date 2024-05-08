#include <gtest/gtest.h>
#include <gmock/gmock.h>
#include "ApprovalTests.hpp"
#include "Necklace.h"
#include "JewelleryStorage.h"
#include "Pendant.h"
#include "Packer.h"
#include "Ring.h"

using namespace std;

TEST(PackTests, PackEarringStud) {
    // arrange
    auto item = new Earring(EarringType::Stud, Jewel::Amber);
    auto storage = new JewelleryStorage("Storage");
    
    // act
    Packer::Pack(item, storage);
    
    // assert
    ASSERT_THAT(storage->Box.TopShelf, testing::Contains(item));
}

TEST(PackTests, Pack_Diamond_Pendant_Necklace)
{
    // arrange
    auto item = new PendantNecklace(new Necklace(NecklaceType::Chain, Jewel::Plain), 
                                    new class Pendant(Jewel::Diamond));
    auto storage = new JewelleryStorage("Storage");

    // act
    Packer::Pack(item, storage);
    
    // assert
    // TODO: pendant should be in safe but not chain
    
}