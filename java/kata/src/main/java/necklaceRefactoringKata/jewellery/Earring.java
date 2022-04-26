package necklaceRefactoringKata.jewellery;

import java.util.Objects;

public final class Earring extends Jewellery {
    public final EarringType type;

    public Earring(Jewel stone, EarringType type) {
        super(stone);
        this.type = type;
    }

    @Override
    public boolean isSmall() {
        return this.type == EarringType.Stud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Earring that = (Earring) o;
        return this.type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type);
    }

    @Override
    public String toString() {
        return "Earring{" +
                "type=" + type +
                ", stone=" + stone +
                '}';
    }
}
