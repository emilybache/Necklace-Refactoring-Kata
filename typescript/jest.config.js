/** @type {import('ts-jest/dist/types').InitialOptionsTsJest} */
module.exports = {
  transform: {
    "^.+\\.tsx?$": "esbuild-jest",
  },
  collectCoverage: true,
  collectCoverageFrom: ["src/**/*.ts", "!**/*.d.ts"],
  testEnvironment: "node",
};
