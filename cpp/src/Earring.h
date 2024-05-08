

#ifndef NECKLACE_REFACTORING_KATA_EARRING_H
#define NECKLACE_REFACTORING_KATA_EARRING_H

#include "Jewellery.h"

enum EarringType {
    Stud,
    Hoop,
    Drop
};

class Earring : public JewelleryBase {
    EarringType _type;

public:
    Earring(EarringType type, Jewel stone) : JewelleryBase(stone), _type(type) {}

    bool IsSmall() override {
        return _type == EarringType::Stud;
    }

    EarringType Type() { return _type; }

    virtual string title() const { return "Earring"; }

    virtual vector<string> attributes() const {
        vector<string> a;
        switch (_type) {
            case Stud:
                a.emplace_back("Stud");
                break;
            case Hoop:
                a.emplace_back("Hoop");
                break;
                
            case Drop:
                a.emplace_back("Drop");
                break;
                
        }
        return a;
    }

};


#endif //NECKLACE_REFACTORING_KATA_EARRING_H
