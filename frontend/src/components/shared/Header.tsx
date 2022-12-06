import React from "react";
import { Link } from "react-router-dom";
import "./Header.css";
import Logo from "./Logo";

const NavBar: React.FC = () => {
  return (
    <nav data-testid="nav">
      <div className="nav-left">
        <Link to="/" data-testid="test">
          <Logo />
        </Link>
      </div>
      <div className="nav-right">
        <a href="/dashboard">Faire le test</a>
        <Link to="/contact">Contact</Link>
        <Link to="/about">À propos</Link>
      </div>
    </nav>
  );
};

const Header: React.FC = () => {
  return (
    <header className="app-header" data-testid="header">
      <NavBar />
    </header>
  );
};

export default Header;
