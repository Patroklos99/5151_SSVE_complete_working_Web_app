import React from 'react'; // we need this to make JSX compile
import { Link } from 'react-router-dom';

type CardProps = {
  title: string;
  paragraph: string;
};

export const Card = ({ title, paragraph }: CardProps) => <aside>
  <h2>{ title }</h2>
  <p>
    { paragraph }
  </p>
  <ul>
    <li>
        <Link to="/add"> Add a car</Link>
    </li>
    <li>
        <Link to="/get"> Retrieve a car</Link>
    </li>
  </ul>
</aside>