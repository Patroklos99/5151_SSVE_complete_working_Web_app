import React from 'react';

import DataForm from "../dataForm/dataForm";

import Maps from "../maps/maps";

function userData1() {
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
                <Maps/>
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

export default userData1;
