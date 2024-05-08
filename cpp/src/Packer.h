

#ifndef NECKLACE_REFACTORING_KATA_PACKER_H
#define NECKLACE_REFACTORING_KATA_PACKER_H

#include "JewelleryStorage.h"
#include "Necklace.h"

using namespace std;

class Packer {
public:
    static void Pack(JewelleryBase* item, JewelleryStorage* storage);
    static void PackNecklace(Necklace* item, JewelleryStorage* storage);

};


#endif //NECKLACE_REFACTORING_KATA_PACKER_H
