

#ifndef NECKLACE_REFACTORING_KATA_JEWELLERYSTORAGE_H
#define NECKLACE_REFACTORING_KATA_JEWELLERYSTORAGE_H

#include <utility>
#include <string>
#include <vector>
#include <algorithm>
#include "Jewellery.h"
#include "Necklace.h"
#include "Earring.h"

using namespace std;

class JewelleryBox {
public:
    vector<JewelleryBase*> RingCompartment;
    vector<JewelleryBase*> TopShelf;
    vector<JewelleryBase*> MainSection;

    JewelleryBox() {
        // Vectors are automatically initialized
    }
};

class JewelleryStorage {
private:
    string _name;

public:
    explicit JewelleryStorage(string name): _name(std::move(name)), Box(JewelleryBox()) {};
    friend ostream& operator<<(ostream& os, const JewelleryStorage& storage);

    vector<JewelleryBase*> Safe;
    JewelleryBox Box;
    vector<JewelleryBase*> Tree;
    vector<JewelleryBase*> TravelRoll;
    vector<JewelleryBase*> DresserTop;

    JewelleryStorage() : Box(JewelleryBox()) {
        // Vectors are automatically initialized
    }

    bool IsInTravelRoll(JewelleryBase* item) {
        return std::find(TravelRoll.begin(), TravelRoll.end(), item) != TravelRoll.end();
    }
};


#endif //NECKLACE_REFACTORING_KATA_JEWELLERYSTORAGE_H
