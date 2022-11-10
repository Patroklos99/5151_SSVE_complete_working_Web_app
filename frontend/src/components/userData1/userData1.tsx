import React, { useEffect } from 'react';
import DataForm from "../dataForm/dataForm";

const UserData1 = () => {
    useEffect(() => {
        const script = document.createElement('script');
      
        script.src = "maps.js";
        script.async = true;
      
        document.body.appendChild(script);
      
        return () => {
          document.body.removeChild(script);
        }
      }, []);

    return (
        <div style={{
            border: "2px solid #009978",
            display: "flex",
            flexDirection: "row",
            width: "100vw",
            height: "100vh"
        }}>

            <div style={{
                border: "2px solid #009978",
                width: "50vw",
                height: "100vh"
            }}>



            <div id="map" style={{ width: "500px", height: "500px" }}></div>
            <div id="search-box"></div>
            <div id="result"></div>

            </div>

            <div style={{
                border: "2px solid #009978",
                width: "50vw",
            }}>
                <DataForm/>
            </div>

        </div>
    );
}

export default UserData1;
