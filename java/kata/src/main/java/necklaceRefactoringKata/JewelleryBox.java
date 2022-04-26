package necklaceRefactoringKata;

import necklaceRefactoringKata.jewellery.Jewellery;
import necklaceRefactoringKata.jewellery.Ring;

import java.util.ArrayList;
import java.util.List;

public class JewelleryBox {
    public final List<Ring> ringCompartment;
    public final List<Jewellery> topShelf;
    public final List<Jewellery> mainSection;

    public JewelleryBox() {
        this.ringCompartment = new ArrayList<>();
        this.topShelf = new ArrayList<>();
        this.mainSection = new ArrayList<>();
    }
}
