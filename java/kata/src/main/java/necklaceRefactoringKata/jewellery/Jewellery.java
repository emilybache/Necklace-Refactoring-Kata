package necklaceRefactoringKata.jewellery;

import java.util.Objects;

public abstract sealed class Jewellery permits Bracelet, Earring, Necklace, Pendant, Ring {
    public Jewel stone;

    public Jewellery(Jewel stone) {
        this.stone = stone;
    }

    public boolean isSmall() {
        return false;
    }

    public boolean isHeavy() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jewellery that = (Jewellery) o;
        return this.stone == that.stone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.stone);
    }
}
