import { makeRing } from "./jewellery";

describe("The packer", () => {
  it("When packing a ring", () => {
    const ring = makeRing("Amber");
    expect(ring.size()).toBe("Small");
  });
});
