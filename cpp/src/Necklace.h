

#ifndef NECKLACE_REFACTORING_KATA_NECKLACE_H
#define NECKLACE_REFACTORING_KATA_NECKLACE_H

#include <utility>

#include "Jewellery.h"

using namespace std;

enum NecklaceType {
    Beads,
    Chain,
    LongChain,
    Pendant
};

class Necklace : public JewelleryBase {
public:
    Necklace(NecklaceType type, Jewel stone) : JewelleryBase(stone), _type(type) {}

    bool IsHeavy() override {
        return _type == NecklaceType::Beads || _type == NecklaceType::LongChain;
    }

    virtual string title() const { return "Necklace"; }

    virtual vector<string> attributes() const {
        vector<string> a;
        switch (_type) {
            case Beads:
                a.emplace_back("Beads");
                break;
            case LongChain:
                a.emplace_back("Long Chain");
                break;

            case Chain:
                a.emplace_back("Chain");
                break;

            case Pendant:
                a.emplace_back("Pendant");
                break;
                
        }
        return a;
    }

private:
    NecklaceType _type;
};

class PendantNecklace : public Necklace {
public:
    PendantNecklace(Necklace *chain, JewelleryBase *pendant) :
            Necklace(NecklaceType::Pendant, pendant->Stone()), _chain(chain), _pendant(pendant) {};

    bool IsHeavy() override {
        return _chain->IsHeavy() || _pendant->IsHeavy();
    }

    virtual string title() const { return "PendantNecklace"; }

    Necklace *Chain() { return _chain; }

    JewelleryBase *Pendant() { return _pendant; }

    virtual vector<string> attributes() const {
        vector<string> a;
        vector<string> b = _chain->attributes();
        a.insert(a.end(), b.begin(), b.end());
        vector<string> c = _pendant->attributes();
        a.insert(a.end(), c.begin(), c.end());

        return a;
    }

private:
    Necklace *_chain;
    JewelleryBase *_pendant;
};

#endif //NECKLACE_REFACTORING_KATA_NECKLACE_H
