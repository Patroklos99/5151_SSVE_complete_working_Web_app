import { Container, Button } from "@mui/material";
import React from "react";
import { Link } from "react-router-dom";
import "./HomePage.css";
import demoImg1 from "../../assets/demo-img01.png";
import demoImg2 from "../../assets/demo-img02.png";
import demoImg3 from "../../assets/demo-img03.png";

const HomePage: React.FC = () => {
  return (
    <section className="homePage">
      <div className="ellipse"></div>
      <div className="content">
        <div className="text">
          <h1 className="text-header">
            Système de
            <br />
            Suggestions de
            <br />
            Véhicules Électriques.
          </h1>
          <h2>
            Trouver la meilleure auto <br /> électrique pour vous!
          </h2>
          <p className="description">
            Avec un algorithme spécialement développé pour ce projet, nous
            analysons vos <br /> déplacements afin de vous suggérer le véhicule
            électrique qui vous conviendrait <br /> le mieux. essence est un
            meilleur choix, <br />
            Nous nous engageons à vous trouver le meilleur rapport-qualité prix
            !
          </p>
        </div>
        <div className="demo">
          <img src={demoImg1} alt="" />
          <img src={demoImg2} alt="" />
          <img src={demoImg3} alt="" />
        </div>

        <Button
          sx={{
            "&:hover": {
              background: "#41d38aef",
            },
            justifyContent: "center",
            alignItems: "center",
            gap: "15px",

            width: "15rem",
            marginLeft: "17em",
            marginTop: "4em",
            padding: "0.5em",

            background: "#65E4A3",
            borderRadius: "56px",
            fontStyle: "medium",
            fontWeight: "700",
            fontSize: "20px",
            lineHeight: "28px",
            textTransform: "initial",
            color: "#000204",
          }}
          component={Link}
          to="/dashboard"
        >
          Je fais le test !
        </Button>
      </div>
    </section>
  );
};

export default HomePage;
