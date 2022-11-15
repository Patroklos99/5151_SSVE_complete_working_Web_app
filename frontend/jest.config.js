/** @type {import('ts-jest').JestConfigWithTsJest} */
module.exports = {
  preset: 'ts-jest',
  testEnvironment: 'jsdom',
  moduleDirectories: ["node_modules", "src", "config"],
  moduleFileExtensions: ["js", "jsx", "ts", "tsx"],
  moduleNameMapper: {
    '^axios$': require.resolve('axios'),
    '\\.(jpg|jpeg|png|gif|eot|otf|webp|svg|ttf|woff|woff2|mp4|webm|wav|mp3|m4a|aac|oga)$':
      '<rootDir>/__mocks__/fileMock.js',
    '\\.(css|less)$': 'identity-obj-proxy',
  },
  transform: {
    '^.+\\.ts?$': 'ts-jest',
    "^.+\\.(js|jsx)$": "ts-jest",
    "^(axios).+\\.js$": "ts-jest"
  },
  transformIgnorePatterns: ['./node_modules/',"node_modules/(?!axios)"],
  setupFilesAfterEnv: ['./src/setupTests.ts'],
  "coveragePathIgnorePatterns": [
    'tests',
    'setupTests.ts',
    'reportWebVitals.ts',
  ]
};