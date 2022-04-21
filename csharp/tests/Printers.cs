using System.Collections.Generic;
using NecklaceRefactoringKata.JewelleryTypes;

namespace NecklaceRefactoringKata.Tests;

public class Printers
{
    public static string PrintJewelleryStorage(JewelleryStorage storage)
    {
        return $@"Jewellery Storage:
Box:
    Ring Compartment: {PrintList(storage.Box.RingCompartment)}
    Top Shelf:        {PrintList(storage.Box.TopShelf)}
    Main Section:     {PrintList(storage.Box.MainSection)}
Tree:                 {PrintList(storage.Tree)}
Travel Roll:          {PrintList(storage.TravelRoll)}
Safe:                 {PrintList(storage.Safe)}
On top of dresser:    {PrintList(storage.DresserTop)}
";
    }
    public static string PrintList(List<JewelleryBase> items)
    {
        return string.Join(", ", items);
    }
}