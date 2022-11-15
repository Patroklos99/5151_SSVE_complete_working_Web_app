import React from 'react';
import ReactDOM from 'react-dom';
import Form from './form';

it('It should mount', () => {
  const div = document.createElement('div');
  ReactDOM.render(<Form />, div);
  ReactDOM.unmountComponentAtNode(div);
});