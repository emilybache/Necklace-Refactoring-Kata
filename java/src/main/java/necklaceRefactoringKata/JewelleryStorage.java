package necklaceRefactoringKata;

import necklaceRefactoringKata.jewellery.Jewellery;

import java.util.ArrayList;
import java.util.List;

public class JewelleryStorage {

    public final JewelleryBox box;
    public final List<Jewellery> tree;
    public final List<Jewellery> travelRoll;
    public final List<Jewellery> safe;
    public final List<Jewellery> dresserTop;

    public JewelleryStorage() {
        this.box = new JewelleryBox();
        this.tree = new ArrayList<>();
        this.travelRoll = new ArrayList<>();
        this.safe = new ArrayList<>();
        this.dresserTop = new ArrayList<>();
    }

    public boolean IsInTravelRoll(Jewellery item) {
        return this.travelRoll.contains(item);
    }
}
