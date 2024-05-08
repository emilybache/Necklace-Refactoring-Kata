#include "ApprovalTests.hpp"
#include "catch2/catch.hpp"

#include "Necklace.h"
#include "JewelleryStorage.h"
#include "Pendant.h"
#include "Packer.h"
#include "Ring.h"

TEST_CASE("Pack") {
    SECTION("PackEarringStud") {
        // arrange
        auto item = new Earring(EarringType::Stud, Jewel::Amber);
        auto storage = new JewelleryStorage("Storage");

        // act
        Packer::Pack(item, storage);

        // assert
        auto v = storage->Box.TopShelf;

        REQUIRE(std::find(v.begin(), v.end(), item) != v.end());
    }

    SECTION("Pack_Diamond_Pendant_Necklace") {
        // arrange
        auto item = new PendantNecklace(new Necklace(NecklaceType::Chain, Jewel::Plain),
                                        new class Pendant(Jewel::Diamond));
        auto storage = new JewelleryStorage("Storage");

        // act
        Packer::Pack(item, storage);

        // assert
        // TODO: pendant should be in safe but not chain

    }
}

