import React from 'react';
import ReactDOM from 'react-dom';
import DataForm from './dataForm';

it('It should mount', () => {
  const div = document.createElement('div');
  ReactDOM.render(<DataForm />, div);
  ReactDOM.unmountComponentAtNode(div);
});