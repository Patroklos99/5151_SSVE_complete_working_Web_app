import React from 'react';
import ReactDOM from 'react-dom';
import Maps from './maps';

it('It should mount', () => {
  const div = document.createElement('div');
  ReactDOM.render(<Maps />, div);
  ReactDOM.unmountComponentAtNode(div);
});