import React, { useEffect, useState } from 'react';
import Trip from '../trip/trip';
import './form.css'
import whatever from '../trip/trip.js';



const Form: React.FC = () => {
    const [serviceList, setServiceList] = useState([{ trip:"" }]);

    useEffect(() => {
        const script = document.createElement('script');
        const index: Number =0;
        script.src = "trip.js";
        script.async = true;
        script.onload = function go() {
            whatever(index);
        }

        document.body.appendChild(script);

        return () => {
            document.body.removeChild(script);
        }
    }, []);

    const handleServiceAdd = () => {
        setServiceList([...serviceList, { trip:"" }])
    }

    const handleServiceRemove = (index: number) => {
        const list = [...serviceList]
        list.splice(index, 1)
        setServiceList(list)
    }

    return (

        <div >
            <h1>Formulaire déplacements</h1>
            <button onClick={handleServiceAdd}>Ajouter déplacement</button>
            {serviceList.map((singleService, index) => (
                <div key={index}>
                    <div style={{
                        "border": "2px solid blue"
                    }}>
                        <input type={"text"} placeholder={"Nom du trajet"}></input>
                        <div id = {"map"+index}></div>
                        <div id={"map2"+index}></div>
                        <div id={"search-box"+index}></div>
                        <div id={"result"+index}></div>
                        <div id={"search-box2"+index}></div>
                        <div id={"result2"+index}></div>
                        <input type={"text"} placeholder={"Fréquence"}></input>
                    </div>
                    {serviceList.length > 1 && (
                        <button onClick={() => handleServiceRemove(index)}>Enlever déplacement</button>)}
                </div>

            ))}
            <button>submit</button>
        </div>
    );
};

export default Form;