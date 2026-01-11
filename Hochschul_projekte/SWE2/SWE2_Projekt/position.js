let osmUrl = 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png';
let osmAtt = '<a href="https://openstreetmap.org">OpenStreetMap</a>';
let args = {
    minZoom: 4,
    maxZoom: 20,
    attribution: osmAtt
}
let osm = new L.TileLayer(osmUrl, args);

let mymap = new L.Map('mapid');
mymap.setView([53.54, 8.5835], 17);
mymap.addLayer(osm);