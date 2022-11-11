import L from "leaflet";

export default function whatever(index) {

    console.log(index);
    var map = L.map('map' + index, {
        center: [40.7259, -73.9805], // Map loads with this location as center
        zoom: 12,
        scrollWheelZoom: true,
        zoomControl: false,
        attributionControl: false,
    });
    var map2 = L.map('map2'+index, {
        center: [40.7259, -73.9805], // Map loads with this location as center
        zoom: 12,
        scrollWheelZoom: true,
        zoomControl: false,
        attributionControl: false,
    });

    //Geocoder options
    var geocoderControlOptions = {
        bounds: false,          //To not send viewbox
        markers: false,         //To not add markers when we geocoder
        attribution: null,      //No need of attribution since we are not using maps
        expanded: true,         //The geocoder search box will be initialized in expanded mode
        panToPoint: false,       //Since no maps, no need to pan the map to the geocoded-selected location
        params: {               //Set dedupe parameter to remove duplicate results from Autocomplete
            dedupe: 1,
        }
    }

    //Initialize the geocoder
    var geocoderControl = new L.control.geocoder('pk.4714636617564cdace4967f9ee10772d', geocoderControlOptions).addTo(map).on('select', function (e) {
        displayLatLon(e.feature.feature.display_name, e.latlng.lat, e.latlng.lng);
    });
    var geocoderControl2 = new L.control.geocoder('pk.4714636617564cdace4967f9ee10772d', geocoderControlOptions).addTo(map2).on('select', function (e) {
        displayLatLon2(e.feature.feature.display_name, e.latlng.lat, e.latlng.lng);
    });

    //Get the "search-box" div
    var searchBoxControl = document.getElementById("search-box"+index);
    var searchBoxControl2 = document.getElementById("search-box2"+index);

    //Get the geocoder container from the leaflet map
    var geocoderContainer = geocoderControl.getContainer();
    var geocoderContainer2 = geocoderControl2.getContainer();
    //Append the geocoder container to the "search-box" div
    searchBoxControl.appendChild(geocoderContainer);
    searchBoxControl2.appendChild(geocoderContainer2);

    //Displays the geocoding response in the "result" div
    function displayLatLon(display_name, lat, lng) {
        var resultString = "You have selected " + display_name + "<br/>Lat: " + lat + "<br/>Lon: " + lng;
        document.getElementById("result"+index).innerHTML = resultString;
    }
    function displayLatLon2(display_name, lat, lng) {
        var resultString = "You have selected " + display_name + "<br/>Lat: " + lat + "<br/>Lon: " + lng;
        document.getElementById("result2"+index).innerHTML = resultString;
    }
    return;
}
