let isLoggedIn = false;

function openOnClick(evt) {
  let panel = evt.target.parentElement.querySelector(".panel");

  if (!isLoggedIn && evt.target.innerText !== 'Login') {
    alert("Loggen Sie sich bitte zuerst ein");
    return;
  }

  if (panel.classList.contains("open")) {
    panel.classList.remove("open");
  } else {
    let panels = evt.target.parentElement.parentElement.querySelectorAll(".panel");
    for (let e of panels) {
      e.classList.remove("open");
    }
    panel.classList.add("open");

    if (panel.querySelector("#mapid")) {
      initMap();
    }
  }
}


function init(evt) {
  let openers = document.querySelectorAll(".accordion .opener");
  for (let e of openers) {
    e.onclick = openOnClick;
  }
 if(document.getElementById('loginForm') !== null){
   console.log('the form is here');
   document.getElementById('loginForm').addEventListener('submit', function(event){
     event.preventDefault();
     handleLogin();
   });
 }
}


/*function handleLogin() {
    const form = document.getElementById('loginForm');

    form.onsubmit = (event) => {
        // Verhindert das Standard-Absendeverhalten des Formulars
        event.preventDefault();

        let formData = new FormData(form);

        let req2 = new XMLHttpRequest();
        req2.open('POST', 'https://informatik.hs-bremerhaven.de/docker-tfw-2024-e-web/cgi-bin/cgi/login.old.sh? + email + password');

        // Fehlerbehandlung für den Fall, dass die Anfrage fehlschlägt
        req2.onerror = () => {
            console.error("Request failed");
            alert("Login failed. Please try again.");
        };

        req2.onload = () => {
            if (req2.readyState === 4) {
                if (req2.status === 200) {
                    let answer = req2.responseText;
                    console.log(answer);

                    if (answer.trim() === 'eingeloggt') {
                        isLoggedIn = true;
                        document.getElementById("loginButton").innerHTML = "Status: " + answer;
                        updateUIForLoggedInUser();
                    } else {
                        alert("Login failed. Please check your credentials.");
                    }
                } else {
                    // Fehlerbehandlung für unerwartete HTTP-Statuscodes
                    console.error("Error: " + req2.statusText);
                    alert("Login failed. Server returned status " + req2.status);
                }
            }
        };

        // Sendet die Formulardaten an das Backend
        req2.send(formData);
    };
}*/

function handleLogin(){
        const form = document.getElementById('loginForm')
        let formData = new FormData(form)
        form.onsubmit = (event)=>{
                event.preventDefault();
        };

  let email = document.getElementById('email').value;
  let password = document.getElementById('password').value;

        let req2 = new XMLHttpRequest
        req2.open('GET', 'https://informatik.hs-bremerhaven.de/docker-tfw-2024-e-web/cgi-bin/cgi/login.old.sh?' + email + ";" + password);
  console.log(email);
        req2.onload = () =>{
                if(req2.readyState == 4 && req2.status == 200){
                        let answer = req2.responseText;
      console.log(answer);
                        //setTimeout(function(){window.location.reload()}, 2000)
      if(answer.trim() === 'eingeloggt') {
        isLoggedIn = true;
        document.getElementById("loginButton").innerHTML="Status"+ answer;
        updateUIForLoggedInUser();
      }
                }
        }
        req2.send(formData)
}


/*function handleLogin(evt) {
  evt.preventDefault();
  let formData = new FormData(evt.target);
  fetch(evt.target.action, {
    method: 'POST',
    body: new URLSearchParams(formData),
    credentials: 'same-origin'
  })
  .then(response => response.text())
  .then(text => {
    if (text.includes("Erneut versuchen")) {
      alert("Login fehlgeschlagen");
    } else {
      isLoggedIn = true;
      updateUIForLoggedInUser();
    }
  });
}*/


 /* function handleLogin(event) {
    event.preventDefault();

    let email=document.getElementById('email').value;
    let password=document.getElementById('password').value;

    let queryString='email=' + email + 'password=' + password;

    fetch('https://informatik.hs-bremerhaven.de/docker-tfw-2024-e-web/cgi-bin/cgi/login.old.sh?' + queryString {
      method:'GET'
    })
    .then(function(response){
      return response.text();
    })
    .then(function(result){
      document.write(result);
   })
  }*/


/*function handleLogin(evt) {
  evt.preventDefault();

  let email = document.getElementById('email').value;
  let password = document.getElementById('password').value;

  let req1 = new XMLHttpRequest();
  req1.open('GET', 'https://informatik.hs-bremerhaven.de/docker-tfw-2024-e-web/cgi-bin/cgi/login.old.sh', true);
  req1.onreadystatechange = function() {
    if (req1.readyState == 4 && req1.status == 200) {
      isLoggedIn = true;
      updateUIForLoggedInUser();
    }
  };
  req1.send();
}*/

/*function handleLogin(){
        const form = document.getElementById('loginForm')
        let formData = new FormData(form)
        form.onsubmit = (event)=>{
                event.preventDefault();
        }
        let req1 = new XMLHttpRequest
        req1.open('post', 'https://informatik.hs-bremerhaven.de/docker-tfw-2024-e-web/cgi-bin/cgi/login.old.sh', true);
        req1.onload = () =>{
                if(req1.readyState == 4 && req1.status == 200){
                isLoggedIn = true;
      updateUIForLoggedInUser();
                }
        }
        req1.send(formData)
}*/


function updateUIForLoggedInUser() {
  let loginPanel = document.getElementById('loginPanel');
  loginPanel.innerHTML = `
    <p>Du bist eingeloggt.</p>
    <button id="logoutButton">Ausloggen</button>
  `;

  document.getElementById('logoutButton').onclick = handleLogout;
}

function handleLogout() {
  isLoggedIn = false;
  location.reload();
}


function initMap() {
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
}

window.onload = init;