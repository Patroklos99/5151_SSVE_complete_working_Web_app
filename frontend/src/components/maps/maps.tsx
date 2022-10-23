import React, { FC } from 'react';
import './maps.css';
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet'
import "leaflet/dist/leaflet.css"
import L from "leaflet"


const position:any = [51.505, -0.09]
const icon1 = L.icon({
    iconUrl: "./../src/assets/placeholder.png",
    iconSize: [38, 38]
})

export default function Maps(){

    return(
        <MapContainer center={position} zoom={13} style={{width:'100%', height:'100%' }}>
            <TileLayer
                attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
                url="https://api.maptiler.com/maps/basic-v2/256/{z}/{x}/{y}.png?key=FcdiIhcFOHH9jFhVCc3L"
            />
            <Marker position={position} icon={icon1} >
                <Popup>
                    A pretty CSS3 popup. <br /> Easily customizable.
                </Popup>
            </Marker>
        </MapContainer>
    )

}