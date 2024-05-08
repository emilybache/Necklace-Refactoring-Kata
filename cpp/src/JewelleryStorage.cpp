#include <utility>
#include <sstream>
#include <iostream>
#include <vector>
#include <string>


#include "JewelleryStorage.h"

using namespace std;


string PrintList(const vector<JewelleryBase*> items)
{
    std::stringstream ss;
    for (const auto& item : items)
    {
        if (!ss.str().empty())
            ss << ", ";
        ss << *item;
    }
    return ss.str();
}

ostream &operator<<(ostream &os, const JewelleryStorage& storage) {
    os << "Jewellery Storage:\n";
    os << "Box:\n";
    os << "    Ring Compartment: " << PrintList(storage.Box.RingCompartment) << "\n";
    os << "    Top Shelf:        " << PrintList(storage.Box.TopShelf) << "\n";
    os << "    Main Section:     " << PrintList(storage.Box.MainSection) << "\n";
    os << "Tree:                 " << PrintList(storage.Tree) << "\n";
    os << "Travel Roll:          " << PrintList(storage.TravelRoll) << "\n";
    os << "Safe:                 " << PrintList(storage.Safe) << "\n";
    os << "On top of dresser:    " << PrintList(storage.DresserTop) << "\n";
    return os;
}



