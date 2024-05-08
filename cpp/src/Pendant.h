

#ifndef NECKLACE_REFACTORING_KATA_PENDANT_H
#define NECKLACE_REFACTORING_KATA_PENDANT_H

#include "Jewellery.h"

class Pendant : public JewelleryBase {
public:
    explicit Pendant(Jewel stone) : JewelleryBase(stone) {}

    bool IsSmall() override {
        return true;
    }
    
    virtual string title() const { return "Pendant"; }

};


#endif //NECKLACE_REFACTORING_KATA_PENDANT_H
