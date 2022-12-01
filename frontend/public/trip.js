


    var map = L.map('map', {
        center: [52.4760892,-71.8258668], // Map loads with this location as center
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
        fillSearch("search",e.feature.feature.display_name, e.latlng.lat, e.latlng.lng);
        displayLatLon(e.feature.feature.display_name, e.latlng.lat, e.latlng.lng);
    });

    //Get the "search-box" div
    var searchBoxControl = document.getElementById("search-box");

    //Get the geocoder container from the leaflet map
    var geocoderContainer = geocoderControl.getContainer();

    //Append the geocoder container to the "search-box" div
    searchBoxControl.appendChild(geocoderContainer);

    //Displays the geocoding response in the "result" div
    function displayLatLon(display_name, lat, lng) {
        var resultString = "You have selected " + display_name + "<br/>Lat: " + lat + "<br/>Lon: " + lng;
        document.getElementById("result").innerHTML = resultString;
    }

    function fillSearch(searchid, display_name, lat, lng) {
        var result = "" + display_name +"\\" + lat + "\\" + lng;
        document.getElementById(searchid).setAttribute("value", result);
    }