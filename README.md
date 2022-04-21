Necklace Refactoring Kata
=========================

When you take off your jewellery at the end of the day, you have a little program that helps you to store it in the right place. Recently, you aquired a diamond pendant that you wear with one of your existing chains. (Lucky you!) Your packing program however suggests storing both the new pendant and its chain in the safe. You'd rather the chain was handled separately, although the safe is still the best place for your diamond.

Note: there is both a 'pack' and a 'pack_necklace' function. The reason for this is to offer a slightly simpler example for you to try first. Begin with 'pack_necklace' and get that one sorted before attempting 'pack'.

The conditional logic in either case is getting a little complex. Before adding the new feature to handle diamond pendants, convert the big if-else statement into a Chain of Responsibility pattern. 

Before that, you will probably want to write unit tests. If you prefer to begin with the refactoring, there are tests on the 'with_tests' branch.
