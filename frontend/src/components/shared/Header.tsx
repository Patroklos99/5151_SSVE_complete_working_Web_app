import Button from "@mui/material/Button";
import React from "react";
import { Link } from "react-router-dom";
import "./Header.css";

const NavBar: React.FC = () => {
  return (
    <nav>
      <div className="nav-left">
        <Link to="/">Logo</Link>
      </div>
      <div className="nav-right">
        <Link to="/Contact">Contact</Link>
        <Link to="#">À propos</Link>
        <Button
          className="start"
          sx={{
            "text-transform": "inherit",
            "font-size": "calc(10px + 2vmin)",
          }}
          variant="contained"
          color="success"
          size="small"
          disableElevation
          component={Link}
          to="/Dashboard"
        >
          Faire le test
        </Button>
      </div>
    </nav>
  );
};

const Header: React.FC = () => {
  return (
    <header className="App-header">
      <NavBar />
    </header>
  );
};

export default Header;
