import Button from "@mui/material/Button";
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
        <Link to="/contact">Contact</Link>
        <Link to="/about">À propos</Link>
        <Button
          className="start"
          variant="contained"
          color="success"
          size="small"
          disableElevation
          component={Link}
          to="/dashboard"
          sx={{
            textTransform: "inherit",
            fontSize: "calc(10px + 2vmin)",
          }}
        >
          Faire le test
        </Button>
      </div>
    </nav>
  );
};

const Header: React.FC = () => {
  return (
    <header className="App-header" data-testid="header">
      <NavBar />
    </header>
  );
};

export default Header;
