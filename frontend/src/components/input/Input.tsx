import { Container } from "@mui/material";
import { useNavigate } from "react-router-dom";
import React from "react";
import "./Input.css";

const Input: React.FC = () => {
  const navigate = useNavigate();

  return (
    <Container maxWidth="xl">
      <h1>Utilisation</h1>
      <button onClick={() => navigate("/Dashboard")}>Afficher Dashboard</button>
    </Container>
  );
};

export default Input;
