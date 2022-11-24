import React from 'react';
import CheckboxComp from '../../common/CheckboxComp';
import DoorFilter from '../../common/DoorFilter';
import DropDownSelect from '../../common/DropDownSelect';
import FilterToggle from '../../common/FilterToggle';
import SliderComp from '../../common/SliderComp';
import "./style.css";

const FilterPanel = ({
    

}) => (
    
        <div className="filters">
            <h1>Filtres</h1>

            <div className="input-group">
                <p className="label">Type de voiture</p>
                <FilterToggle/>
            </div>

            <div className="input-group">
                <p className="label">Marque</p>
                <CheckboxComp/>
            </div>

            <div className="input-group">
                <p className="label">Modele</p>
                <DropDownSelect/>
                
            </div>

            <div className="input-group">
                <p className="label">Nombre de portes</p>
                <DoorFilter/>
                
            </div>

            <div className="input-group">
                <p className="label">Prix</p>
                <SliderComp/>
            </div>

            <div className="input-group">
                <p className="label">Autonomie</p>
                <SliderComp/>
            </div>

            <div className="input-group">
                <p className="label">Capacite</p>
                <SliderComp/>
            </div>

            <div className="input-group">
                <p className="label">Temps de recharge</p>
                <SliderComp/>
            </div>

            <div className="input-group">
                <p className="label">Score</p>
                <SliderComp/>
            </div>

            <div className="input-group">
                <p className="label">Score de securite</p>
                <SliderComp/>
            </div>
        </div>
);


export default FilterPanel;