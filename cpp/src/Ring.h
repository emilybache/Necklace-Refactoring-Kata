

#ifndef NECKLACE_REFACTORING_KATA_RING_H
#define NECKLACE_REFACTORING_KATA_RING_H


#include "Jewellery.h"

class Ring : public JewelleryBase {
public:
    Ring(Jewel stone) : JewelleryBase(stone) {}
    virtual string title() const { return "Ring"; }

};


#endif //NECKLACE_REFACTORING_KATA_RING_H
