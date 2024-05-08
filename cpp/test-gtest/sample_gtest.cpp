#include <gtest/gtest.h>
#include "ApprovalTests.hpp"
#include "Necklace.h"
#include "JewelleryStorage.h"
#include "Pendant.h"
#include "Packer.h"
#include "Ring.h"

using namespace std;

JewelleryStorage* packNecklaceItem(Necklace* item) {
    auto storage = new JewelleryStorage("Storage");
    Packer::PackNecklace(item, storage);
    return storage;
}
JewelleryStorage* packItem(JewelleryBase* item, bool travelRoll = false) {
    auto storage = new JewelleryStorage("Storage");
    if (travelRoll) {
        storage->TravelRoll.emplace_back(item);
    }
    Packer::Pack(item, storage);
    return storage;
}

TEST(PackNecklaceTests, PackPearlNecklace) {
    auto item = new Necklace(NecklaceType::Beads, Jewel::Pearl);
    ApprovalTests::Approvals::verify(*packNecklaceItem(item));
}

TEST(PackNecklaceTests, PackAmberNecklace)
{
    auto item = new Necklace(NecklaceType::Beads, Jewel::Amber);
    ApprovalTests::Approvals::verify(*packNecklaceItem(item));
}

TEST(PackNecklaceTests, PackAmberChainNecklace)
{
    auto item = new Necklace(NecklaceType::Chain, Jewel::Amber);
    ApprovalTests::Approvals::verify(*packNecklaceItem(item));
}

TEST(PackNecklaceTests, PackDiamondNecklace)
{
    auto item = new Necklace(NecklaceType::Chain, Jewel::Diamond);
    ApprovalTests::Approvals::verify(*packNecklaceItem(item));
}

TEST(PackNecklaceTests, PackChain)
{
    auto item = new Necklace(NecklaceType::Chain, Jewel::Plain);
    ApprovalTests::Approvals::verify(*packNecklaceItem(item));
}

TEST(PackNecklaceTests, PackLongChain)
{
    auto item = new Necklace(NecklaceType::LongChain, Jewel::Plain);
    ApprovalTests::Approvals::verify(*packNecklaceItem(item));
}


TEST(PackNecklaceTests, PackPendantNecklace)
{
    auto item = new PendantNecklace(
            new Necklace(NecklaceType::Chain, Jewel::Plain),
            new class Pendant(Jewel::Amber));
    ApprovalTests::Approvals::verify(*packNecklaceItem(item));
}

TEST(PackNecklaceTests, PackPendantNecklaceLongChain)
{
    auto item = new PendantNecklace(
            new Necklace(NecklaceType::LongChain, Jewel::Plain),
            new class Pendant(Jewel::Amber));
    ApprovalTests::Approvals::verify(*packNecklaceItem(item));
}

TEST(PackTests, Pack_Earring_Stud)
{
    auto item = new Earring(EarringType::Stud,  Jewel::Amber);
    ApprovalTests::Approvals::verify(*packItem(item));
}

TEST(PackTests, Pack_Diamond_Earring_Stud)
{
    auto item = new Earring(EarringType::Stud,  Jewel::Diamond);
    ApprovalTests::Approvals::verify(*packItem(item));
}

TEST(PackTests, Pack_Earring_Hoop)
{
    auto item = new Earring(EarringType::Hoop,  Jewel::Plain);
    ApprovalTests::Approvals::verify(*packItem(item));
}

TEST(PackTests, Pack_Earring_Drop)
{
    auto item = new Earring(EarringType::Drop,  Jewel::Plain);
    ApprovalTests::Approvals::verify(*packItem(item));
}

TEST(PackTests, Pack_Earring_Drop_with_Stone)
{
    auto item = new Earring(EarringType::Drop,  Jewel::Amber);
    ApprovalTests::Approvals::verify(*packItem(item));
}

TEST(PackTests, Pack_Earring_From_Travel_roll)
{
    auto item = new Earring(EarringType::Drop,  Jewel::Plain);
    bool travelRoll = true;
    ApprovalTests::Approvals::verify(*packItem(item, travelRoll));
}

TEST(PackTests, Pack_Necklace_From_Travel_roll)
{
    auto item = new Necklace(NecklaceType::Beads,  Jewel::Pearl);
    bool travelRoll = true;
    ApprovalTests::Approvals::verify(*packItem(item, travelRoll));
}

TEST(PackTests, Pack_Amber_Necklace)
{
    auto item = new Necklace(NecklaceType::Beads,  Jewel::Amber);
    ApprovalTests::Approvals::verify(*packItem(item));
}

TEST(PackTests, PackAmberChainNecklace)
{
    auto item = new Necklace(NecklaceType::Chain,  Jewel::Amber);
    ApprovalTests::Approvals::verify(*packItem(item));
}

TEST(PackTests, Pack_Long_Chain_Necklace)
{
    auto item = new Necklace(NecklaceType::LongChain,  Jewel::Plain);
    ApprovalTests::Approvals::verify(*packItem(item));
}

TEST(PackTests, Pack_Pendant_Necklace)
{
    auto item = new PendantNecklace(new Necklace(NecklaceType::Chain, Jewel::Plain),
                                   new class Pendant(Jewel::Amber));
    ApprovalTests::Approvals::verify(*packItem(item));
}

TEST(PackTests, Pack_Pendant)
{
    auto item = new class Pendant(Jewel::Amber);
    ApprovalTests::Approvals::verify(*packItem(item));
}

TEST(PackTests, Pack_Diamond_Pendant_Necklace)
{
    auto item = new PendantNecklace(new Necklace(NecklaceType::Chain, Jewel::Plain),
                                   new class Pendant(Jewel::Diamond));
    ApprovalTests::Approvals::verify(*packItem(item));
}

TEST(PackTests, Pack_UnknownItem)
{
    auto item = new Ring(Jewel::Plain);
    ApprovalTests::Approvals::verify(*packItem(item));
}