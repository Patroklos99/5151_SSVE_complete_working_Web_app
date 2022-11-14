import React from 'react';
import { render, screen } from '@testing-library/react';
import { Card } from './example';
import '@testing-library/jest-dom'

test('verification render Card', async () => {
  render(<Card title={'Titre exemple'} paragraph={'Ceci est un exemple'} />);

  // There is multiple test matching options see:
  // https://testing-library.com/docs/dom-testing-library/cheatsheet#text-match-options
  const titleElement = screen.getByText(/Titre exemple/);
  const paragraphElement = screen.getByText(/Ceci est un exemple/)
  expect(titleElement).toBeInTheDocument();
  expect(paragraphElement).toBeInTheDocument();
})
