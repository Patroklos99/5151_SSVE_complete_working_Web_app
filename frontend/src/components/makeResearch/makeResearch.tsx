import React, {FC} from 'react';
import {Link} from 'react-router-dom';
import './makeResearch.css';
import icone1 from "../../assets/developpementIcone.png";
import formIcone from "../../assets/former.png"
import mapIcone from "../../assets/emplacement-de-la-carte.png"
import jsonIcone from "../../assets/fichier-json.png"


interface MakeResearchProps {
}

const MakeResearch: FC<MakeResearchProps> = () => (
        <div className="makeResearch">
            <div>
                <h2>Effectuer une recherche de véhicules:</h2>
            </div>


            {/*** 3 columns **/}
            <div className="row">
                <div className="column column1">
                    <div className="card-overlay2">
                        <img src={formIcone} className="filter-image"/>

                        <Link to="/researchMan">
                            <button
                                style={{width: "auto", position: "relative"}}>Manuellement
                            </button>
                        </Link>


                    </div>
                </div>

                <div className=" column column2">
                    <div className=" card-overlay2">
                        <img src={mapIcone} alt=" formation-icone" className=" filter-image"/>
                        <button
                            style={{width: "auto", position: "relative"}}>Par Google Maps Timeline
                        </button>
                    </div>
                </div>

                <div className="column column3">
                    <div className="card-overlay2">
                        <img src={jsonIcone} alt="inventaire-icone" className="filter-image"/>
                        <button style={{width: "auto", position: "relative"}}>Par liste préformatée
                        </button>

                    </div>
                </div>

            </div>
            {/*** 3 columns -->***/
            }
        </div>
    )
;

export default MakeResearch;