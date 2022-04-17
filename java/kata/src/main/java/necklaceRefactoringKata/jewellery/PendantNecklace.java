package necklaceRefactoringKata.jewellery;

import java.util.Objects;

public final class PendantNecklace extends Necklace {

    public Necklace chain;
    public Jewellery pendant;

    public PendantNecklace(Jewel stone, NecklaceType type, Necklace chain, Jewellery pendant) {
        super(stone, type);
        this.chain = chain;
        this.pendant = pendant;
    }

    @Override
    public boolean isLarge() {
        return this.chain.isLarge() || this.pendant.isLarge();
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
                "pendant=" + pendant +
                ", type=" + type +
                ", stone=" + stone +
                '}';
    }
}
