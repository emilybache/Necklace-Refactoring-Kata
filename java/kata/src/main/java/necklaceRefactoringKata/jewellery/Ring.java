package necklaceRefactoringKata.jewellery;

public final class Ring extends Jewellery {
    public Ring(Jewel stone) {
        super(stone);
    }

    @Override
    public String toString() {
        return "Ring{" +
                "stone=" + stone +
                '}';
    }
}
