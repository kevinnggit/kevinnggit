const map = L.map('map', { zoomDelta: 0.25, zoomSnap: 0 }).setView([53.55021,8.57673], 18);
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {maxZoom: 18,}).addTo(map);

const shipIcon = L.icon({
  iconUrl: 'https://pngimg.com/uploads/ship/ship_PNG5415.png',
  iconSize: [25, 25],
  iconAnchor: [12, 12],
  popupAnchor: [0, -10]
});

const currentShipIcon = L.icon({
  iconUrl: 'https://pngimg.com/uploads/ship/ship_PNG5415.png',
  iconSize: [35, 35],
  iconAnchor: [17, 17],
  popupAnchor: [0, -15]
});

const markerArray = {};

function generateColor() {
  return '#' + Math.floor(Math.random()*16777215).toString(16);
}

function loadMap() {
  const xhr = new XMLHttpRequest();
  xhr.open('GET', 'https://informatik.hs-bremerhaven.de/docker-tfw-2024-e-web/cgi-bin/cgi/positionen.sh', true);
  xhr.onload = function() {
    if (xhr.status === 200) {
      const schiffe = JSON.parse(xhr.responseText);
      const schiffTable = document.getElementById('shipTable').getElementsByTagName('tbody')[0];
      schiffTable.innerHTML = "";

      map.eachLayer(function(layer) {
        if (layer instanceof L.Marker || layer instanceof L.Polyline) {
          map.removeLayer(layer);
        }
      });

      let count = 0;
      const shipPositions = {};

      schiffe.forEach(function(schiff) {
        const latitude = parseFloat(schiff.latitude);
        const longitude = parseFloat(schiff.longitude);
        const mmsi = schiff.mmsi;
        const datum = new Date(schiff.datum);
        const name = schiff.shipname || "Unbekannter Name";

        if (!shipPositions[mmsi]) {
          shipPositions[mmsi] = [];
        }
        shipPositions[mmsi].push({lat: longitude, lng: latitude, time: datum});
      });

      Object.keys(shipPositions).forEach(function(mmsi) {
        count += 1;
        const positions = shipPositions[mmsi].sort((a, b) => a.time - b.time);
        const mmsiColor = generateColor();

        positions.forEach((pos, index) => {
          const marker = L.circleMarker([pos.lat, pos.lng], {
            radius: 3,
            fillColor: mmsiColor,
            color: mmsiColor,
            weight: 1,
            opacity: 0.7,
            fillOpacity: 0.5
          }).addTo(map);

          marker.bindPopup(`
            <div>
              <strong>MMSI:</strong> ${mmsi}<br>
              <small><strong>Latitude:</strong> ${pos.lng}</small><br>
              <small><strong>Longitude:</strong> ${pos.lat}</small><br>
              <small><strong>Datum:</strong> ${pos.time.toLocaleString()}</small>
            </div>
          `);
        });

        const latlngs = positions.map(pos => [pos.lat, pos.lng]);
        const polyline = L.polyline(latlngs, {color: mmsiColor, weight: 2}).addTo(map);

        const currentPos = positions[positions.length - 1];
        const currentMarker = L.marker([currentPos.lat, currentPos.lng], {icon: currentShipIcon}).addTo(map);
        currentMarker.bindPopup(`
          <div>
            <strong>MMSI:</strong> ${mmsi}<br>
            <small><strong>Latitude:</strong> ${currentPos.lng}</small><br>
            <small><strong>Longitude:</strong> ${currentPos.lat}</small><br>
            <small><strong>Datum:</strong> ${currentPos.time.toLocaleString()}</small><br>
            <small><strong>Name:</strong> ${name}</small>
          </div>
        `);

        if (positions.length > 1) {
          const startPos = positions[0];
          const endPos = positions[positions.length - 1];
          const arrowLine = L.polyline([[startPos.lat, startPos.lng], [endPos.lat, endPos.lng]], {
            color: mmsiColor,
            weight: 3,
            opacity: 0.7,
            dashArray: '10, 10',
            arrow: true
          }).addTo(map);
        }

        const row = schiffTable.insertRow();
        const cells = Array.from({length: 5}, () => row.insertCell());
        cells[0].innerHTML = count;
        cells[1].innerHTML = mmsi;
        cells[2].innerHTML = currentPos.lng.toFixed(6);
        cells[3].innerHTML = currentPos.lat.toFixed(6);
        cells[4].innerHTML = name;
      });
    }
  };
  xhr.send();
}

setInterval(loadMap, 5000);
loadMap(); 

setTimeout(function () {
   window.dispatchEvent(new Event("resize"));
}, 500);
