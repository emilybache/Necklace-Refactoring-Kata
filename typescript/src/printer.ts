import { Jewellery, JewelleryStorage } from "./jewellery";

export const nameOf = (item: Jewellery) => {
  switch (item._kind) {
    case "Ring":
      return `${item.stone} ring`;
    case "Earring":
      return `${item.stone} ${item.type} earrings`;
    case "Necklace":
      if (item.type === "Pendant") {
        return `${item.chain.type} necklace with ${item.pendant.stone} pendant`;
      }
      return `${item.stone} ${item.type} necklace`;
  }
  return `${item.stone} ${item._kind}`;
};

const printStore = (store: Array<Jewellery>) =>
  store.map((x) => nameOf(x)).toString();

export const printStorage = (storage: JewelleryStorage) => `
Jewellery Storage:
  Box:
      Ring Compartment: ${printStore(storage.box.ringCompartment)}
      Top Shelf:        ${printStore(storage.box.ringCompartment)}
      Main Section:     ${printStore(storage.box.ringCompartment)}
  Tree:                 ${printStore(storage.tree)}
  Travel Roll:          ${printStore(storage.travelRoll)}
  Safe:                 ${printStore(storage.safe)}
  On top of dresser:    ${printStore(storage.dresserTop)}
`;
