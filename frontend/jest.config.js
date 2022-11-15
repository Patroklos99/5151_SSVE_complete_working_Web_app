/** @type {import('ts-jest').JestConfigWithTsJest} */
module.exports = {
  preset: 'ts-jest',
  testEnvironment: 'jsdom',
  moduleDirectories: ["node_modules", "src", "config"],
  moduleFileExtensions: ["js", "jsx", "ts", "tsx"],
  moduleNameMapper: {
    '^axios$': require.resolve('axios'),
  },
  transform: {
    '^.+\\.ts?$': 'ts-jest',
    "^.+\\.(js|jsx)$": "ts-jest",
    "^(axios).+\\.js$": "ts-jest"
  },
  transformIgnorePatterns: ['./node_modules/',"node_modules/(?!axios)"],
  setupFilesAfterEnv: ['./src/setupTests.ts'],
};