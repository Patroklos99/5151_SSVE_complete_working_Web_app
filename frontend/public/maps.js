// Creating map options
var mapOptions = {
    center: [17.385044, 78.486671],
    zoom: 10
}

// Creating a map object
var map = new L.map('map', mapOptions);

// Creating a Layer object
L.tileLayer('https://{s}-tiles.locationiq.com/v2/obk/r/{z}/{x}/{y}.png?key=pk.4714636617564cdace4967f9ee10772d').addTo(map);

L.control.geocoder('pk.4714636617564cdace4967f9ee10772d').addTo(map);