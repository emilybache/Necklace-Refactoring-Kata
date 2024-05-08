

#ifndef NECKLACE_REFACTORING_KATA_JEWELLERY_H
#define NECKLACE_REFACTORING_KATA_JEWELLERY_H

#include <vector>
#include <string>

using namespace std;

enum Jewel
{
    Plain,
    Diamond,
    Pearl,
    Amber
};


class JewelleryBase {
private:
    Jewel _stone;

public:
    JewelleryBase(Jewel stone) : _stone(stone) {}

    virtual bool IsSmall() { return false; }

    virtual bool IsHeavy() { return false; }

    virtual string title() const { return "Jewellery"; }
    virtual vector<string> attributes() const { return vector<string>(); }

    Jewel Stone() { return this->_stone; }

    friend ostream &operator<<(ostream &os, const JewelleryBase &jewellery);

};


#endif //NECKLACE_REFACTORING_KATA_JEWELLERY_H
