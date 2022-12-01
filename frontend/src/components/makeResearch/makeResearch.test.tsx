import React from 'react';
import ReactDOM from 'react-dom';
import MakeResearch from './makeResearch';

it('It should mount', () => {
  const div = document.createElement('div');
  ReactDOM.render(<MakeResearch />, div);
  ReactDOM.unmountComponentAtNode(div);
});