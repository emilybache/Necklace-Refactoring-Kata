package necklaceRefactoringKata.jewellery;

import java.util.Objects;

public sealed class Necklace extends Jewellery permits PendantNecklace {

    public NecklaceType type;

    public Necklace(Jewel stone, NecklaceType type) {
        super(stone);
        this.type = type;
    }

    @Override
    public boolean isLarge() {
        return this.type == NecklaceType.Beads || this.type == NecklaceType.LongChain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Necklace that = (Necklace) o;
        return this.type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }

    @Override
    public String toString() {
        return "Necklace{" +
                "type=" + type +
                ", stone=" + stone +
                '}';
    }
}
