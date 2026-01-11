let markerShop = L.marker([53.560745, 8.578176]).addTo(mymap);

let circelShop = L.circle([53.560745, 8.578176],{
  radius: 100,
  color: 'green',
  fillColor: '#f04',
  fillOpacity: '0.5'
}).addTo(mymap).bindPopup("ASIA&AFRIKA <b>Besuchen sie uns</br>.");