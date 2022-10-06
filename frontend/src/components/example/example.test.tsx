import React from 'react';
import { render, screen } from '@testing-library/react';
import { Card } from './example';

test('renders learn react link', () => {
  render(<Card title={'Titre exemple'} paragraph={'Ceci est un exemple'} />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});
