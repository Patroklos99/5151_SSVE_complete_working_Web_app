import { Container, Button } from "@mui/material";
import React from "react";
import { Link } from "react-router-dom";
import "./HomePage.css";
import Image from '../../assets/logo.png'


const HomePage = () => {
  return (
    <Container maxWidth="xl">
      <section className='homePage'>
            <ellipse className='ellipse' />
            <Link className='textEllipse' to='/about'>À propos</Link>
            <img className='logo' src={Image} alt='not-found'/>
            <p className='title1'>SSVE</p>
            <div className='content'>
                <p className='title2'>Trouver la meilleure auto <br /> électrique pour vous!</p>
                <p className='description'>
                        Avec un algorithme spécialement développé pour ce projet, 
                        on analyse vos <br /> déplacements pour vous suggérer quelle 
                        auto électrique vous conviendrait <br /> le mieux. Dans le cas ou 
                        la voiture à essence est un meilleur choix, <br /> 
                        nous vous le dirons aussi.
                </p>
                <Button
                sx={{
                  justifyContent: "center",
                  alignItems: "center",
                  gap: "15px",
              
                  position: "absolute",
                  width: "280px",
                  height: "55px",
                  marginLeft: "230px",
                  top: "528px",
              
                  background: "#65E4A3",
                  border: "2px solid #69E6A6",
                  borderRadius: "56px",
              
                  flex: "none",
                  order: "2",
                  flexGrow: "0",
                  zIndex: "2"
                }}
                component={Link}
                to="/dashboard"
              >
                <span className="textButton">Je fais le test!</span>
              </Button>

            </div>
       </section>
    </Container>
  );
};

export default HomePage;
