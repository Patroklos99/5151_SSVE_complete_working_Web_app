import React, { useState } from 'react';
import { render, screen, fireEvent, waitFor } from '@testing-library/react';
import AddCar from './example2';
import '@testing-library/jest-dom'
import { MemoryRouter } from 'react-router-dom';

// This approach is a bit more complex, here we setup the component and test it afterwards
const setup = () => {
  const utils = render(
    // Be carefull component with links or routing in them have to be wrapped in a memoryRouter otherwise
    // you will get context errors see: https://v5.reactrouter.com/web/guides/testing
    <MemoryRouter>
      <AddCar/>
    </MemoryRouter>
    )
  // We target input to be able to modify it easily inside of our unit tests
  // Note that we cast input as an HTMLInputElement to respect type restrictions
  const input = utils.getByLabelText('Model') as HTMLInputElement
  return {
    input,
    ...utils,
  }
}

test('making sure we have the right input value', async () => {
  const { input } = setup()
  fireEvent.change(input, { target: { value: '1' }})
  expect(input.value).toBe('1')
})

test('making post to api', async () => {
  const utils = setup()
  fireEvent.click(utils.getByLabelText('post-button'))
  await waitFor(() => expect(utils.getByLabelText('post-success')).toHaveTextContent('You submitted successfully!'))
})
