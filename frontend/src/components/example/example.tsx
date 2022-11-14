import React from 'react'; // we need this to make JSX compile
import { Link, Route, Routes } from 'react-router-dom';
import AddCar from '../example2/example2';

type CardProps = {
  title: string;
  paragraph: string;
};

export const Card = ({ title, paragraph }: CardProps) => <aside>
  <h2>{ title }</h2>
  <p>
    { paragraph }
  </p>
  <Link to="/add">add</Link>
  <Link to="/get">get</Link>
</aside>