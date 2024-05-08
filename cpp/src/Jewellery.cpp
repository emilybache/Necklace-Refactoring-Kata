
#include <utility>
#include <sstream>
#include <iostream>
#include <vector>
#include <string>
#include "Jewellery.h"

string PrintAttributes(const vector<string> attributes)
{
    std::stringstream ss;
    for (const auto& item : attributes)
    {
        ss << ", ";
        ss << item;
    }
    return ss.str();
}

ostream &operator<<(ostream &os, const JewelleryBase& jewellery){
    os << jewellery.title() << "(";
    switch (jewellery._stone) {
        case Plain:
            os << "Plain";
            break;
        case Diamond:
            os << "Diamond";
            break;
        case Pearl:
            os << "Pearl";
            break;
        case Amber:
            os << "Amber";
            break;
    }
    os << PrintAttributes(jewellery.attributes());
    os << ")";

    return os;
}