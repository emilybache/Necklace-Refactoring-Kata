package necklaceRefactoringKata.jewellery;

public final class Pendant extends Jewellery {

    public Pendant(Jewel stone) {
        super(stone);
    }

    @Override
    public boolean isSmall() {
        return true;
    }

    @Override
    public String toString() {
        return "Pendant{" +
                "stone=" + stone +
                '}';
    }
}
