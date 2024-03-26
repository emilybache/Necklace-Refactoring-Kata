package necklaceRefactoringKata.jewellery;

import java.util.Objects;

public final class PendantNecklace extends Necklace {

    public Necklace chain;
    public Jewellery pendant;

    public PendantNecklace(Necklace chain, Jewellery pendant) {
        super(pendant.stone, NecklaceType.Pendant);
        this.chain = chain;
        this.pendant = pendant;
    }

    @Override
    public boolean isHeavy() {
        return this.chain.isHeavy() || this.pendant.isHeavy();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PendantNecklace that = (PendantNecklace) o;
        return Objects.equals(this.chain, that.chain) && Objects.equals(this.pendant, that.pendant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.chain, this.pendant);
    }

    @Override
    public String toString() {
        return "PendantNecklace{" +
                "chain=" + chain +
                ", pendant=" + pendant +
                ", type=" + type +
                ", stone=" + stone +
                '}';
    }
}
