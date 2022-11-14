// jest-dom adds custom jest matchers for asserting on DOM nodes.
// allows you to do things like:
// expect(element).toHaveTextContent(/react/i)
// learn more: https://github.com/testing-library/jest-dom
import '@testing-library/jest-dom';
import { server } from './tests/mocks/server'

// Here we establish the API mocking before all tests
beforeAll(() => server.listen())

// Here we reset any handlers that might be added during the tests so they don't affect other tests
afterEach(() => server.resetHandlers())

// Once all the test have ran we cleanup the server
afterAll(() => server.close())