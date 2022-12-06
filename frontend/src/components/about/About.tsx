import React from "react";
import "./About.css";

const About = () => {
  return (
    <section className="about">
      <div className="ellipse"></div>
      <div className="about-content">
        <h1>À propos</h1>
        <h2>Historique</h2>
        <p>
          Notre équipe a développé ce programme dans le but de faciliter la
          location d'automobiles pour les usages qui sont fatigués des autres
          systèmes archaiques et peu pratiques.
        </p>
        <h2>Clientèles</h2>
        <p>
          Les clients desservies recherchent à trouver une automobile qui
          corresponde à leurs besoins et qui veulent un service de qualité.
        </p>
        <h2>Modèle d'affaire</h2>
        <p>
          Le programme conçus est le produit que nous offrons à notre clientèle.
        </p>
        <h2>Membres de l'équipe</h2>
        <p>
          Tous les membres de l'équipe sont des étudiants de l'UQAM au
          Baccalauréat en informatique et génie logiciel. Ce projet a été
          effectué dans le cadre des cours INF6150 et INM5151 lors de la session
          d'automne 2022.
        </p>
      </div>
    </section>
  );
};

export default About;
