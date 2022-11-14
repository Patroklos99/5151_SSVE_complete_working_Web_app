import React from 'react';
import { render, screen } from '@testing-library/react';
import { Card } from './example';
import '@testing-library/jest-dom'
import { MemoryRouter } from 'react-router-dom';

test('verification render Card', async () => {
  render(

  // Be carefull component with links or routing in them have to be wrapped in a memoryRouter otherwise
  // you will get context errors see: https://v5.reactrouter.com/web/guides/testing
  <MemoryRouter>
    <Card title={'Titre exemple'} paragraph={'Ceci est un exemple'} />
  </MemoryRouter>
  );

  // There is multiple test matching options see:
  // https://testing-library.com/docs/dom-testing-library/cheatsheet#text-match-options
  const titleElement = screen.getByText(/Titre exemple/);
  const paragraphElement = screen.getByText(/Ceci est un exemple/)
  expect(titleElement).toBeInTheDocument();
  expect(paragraphElement).toBeInTheDocument();
})
