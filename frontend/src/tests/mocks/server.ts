import { setupServer } from 'msw/node';
import { handlers } from './exampleHandlers';

// Here we configure the request mocking server using the handlers defined in exampleHandlers.ts
export const server = setupServer(...handlers)