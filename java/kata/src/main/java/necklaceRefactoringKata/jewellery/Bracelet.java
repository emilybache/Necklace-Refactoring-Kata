package necklaceRefactoringKata.jewellery;

import java.util.Objects;

public final class Bracelet extends Jewellery {

    public BraceletType type;

    public Bracelet(Jewel stone, BraceletType type) {
        super(stone);
        this.type = type;
    }

    @Override
    public boolean isLarge() {
        return type == BraceletType.Cuff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bracelet bracelet = (Bracelet) o;
        return type == bracelet.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }
}
