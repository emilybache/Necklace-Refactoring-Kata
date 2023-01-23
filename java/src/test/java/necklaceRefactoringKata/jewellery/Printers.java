package necklaceRefactoringKata.jewellery;

import necklaceRefactoringKata.JewelleryStorage;
import necklaceRefactoringKata.jewellery.Jewellery;
import necklaceRefactoringKata.jewellery.Ring;

import java.util.List;

public class Printers {
    public static String PrintJewelleryStorage(JewelleryStorage storage)
    {
        return "Jewellery Storage: " + "\n" +
        "Box:" + "\n" +
        "    Ring Compartment: " + PrintRings(storage.box.ringCompartment) + "\n" +
        "    Top Shelf:        " + PrintList(storage.box.topShelf) + "\n" +
        "    Main Section:     " + PrintList(storage.box.mainSection) + "\n" +
        "Tree:                 " + PrintList(storage.tree) + "\n" +
        "Travel Roll:          " + PrintList(storage.travelRoll) + "\n" +
        "Safe:                 " + PrintList(storage.safe) + "\n" +
        "On top of dresser:    " + PrintList(storage.dresserTop) + "\n"
        ;
    }
    public static String PrintRings(List<Ring> items)
    {
        return items.toString();
    }
    public static String PrintList(List<Jewellery> items)
    {
        return items.toString();
    }

}
