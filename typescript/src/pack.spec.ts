import { makeStorage, pack, packNecklace } from ".";
import {
  Jewellery,
  makeEarring,
  makeNecklace,
  makePendant,
  makePendantNecklace,
  makeRing,
} from "./jewellery";
import { nameOf, printStorage as print } from "./printer";

const packNecklaceCases = [
  makeNecklace("Diamond", "Chain"),
  makeNecklace("Plain", "LongChain"),
  makeNecklace("Amber", "Chain"),
  makeNecklace("Pearl", "Beads"),
  makePendantNecklace("Pearl", "Beads"),
  makePendantNecklace("Diamond", "Chain"),
  makePendantNecklace("Diamond", "LongChain"),
];

const packItemCases: Array<Jewellery> = [
  makeEarring("Amber", "Stud"),
  makeEarring("Diamond", "Stud"),
  makeEarring("Plain", "Hoop"),
  makeEarring("Plain", "Drop"),
  makeNecklace("Amber", "Beads"),
  makeNecklace("Plain", "Chain"),
  makeNecklace("Amber", "Chain"),
  makeNecklace("Diamond", "Chain"),
  makeNecklace("Pearl", "Beads"),
  makePendantNecklace("Pearl", "Beads"),
  makePendantNecklace("Amber", "LongChain"),
  makeRing("Amber"),
  makeRing("Diamond"),
  makePendant("Plain"),
];

const travelRollCases: Array<Jewellery> = [
  makeEarring("Amber", "Stud"),
  makeEarring("Diamond", "Stud"),
  makeEarring("Plain", "Hoop"),
  makeEarring("Plain", "Drop"),
  makeEarring("Pearl", "Drop"),
  makeNecklace("Amber", "Beads"),
  makeNecklace("Plain", "Chain"),
  makeNecklace("Amber", "Chain"),
  makeNecklace("Diamond", "Chain"),
  makeNecklace("Pearl", "Beads"),
  makePendantNecklace("Pearl", "Beads"),
  makePendantNecklace("Amber", "LongChain"),
  makeRing("Amber"),
  makeRing("Diamond"),
];

for (const item of packItemCases) {
  test(`Pack item: ${nameOf(item)}`, () => {
    const storage = makeStorage();
    pack(item, storage);
    expect(print(storage)).toMatchSnapshot(nameOf(item));
  });
}

for (const item of packNecklaceCases) {
  test(`Pack necklace: ${nameOf(item)}`, () => {
    const storage = makeStorage();
    packNecklace(item, storage);
    expect(print(storage)).toMatchSnapshot(nameOf(item));
  });
}

for (const item of travelRollCases) {
  test(`From travellroll: ${nameOf(item)}`, () => {
    const storage = makeStorage();
    pack(item, storage);
    expect(print(storage)).toMatchSnapshot(nameOf(item));
  });
}
