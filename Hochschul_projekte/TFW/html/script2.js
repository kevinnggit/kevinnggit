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
     //checkLoginStatus();
   });
 }
}











          /*function checkLoginStatus() {
            const xhr = new XMLHttpRequest();
            xhr.open('GET', 'https://informatik.hs-bremerhaven.de/docker-tfw-2024-e-web/cgi-bin/cgi/check_session.sh', true);
            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    if (xhr.responseText === 'logged_in') {
                        document.getElementById('section2').disabled = false;
                        document.getElementById('section3').disabled = false;

                        // Login-Formular ersetzen
                        const loginForm = document.getElementById('loginForm');
                        loginForm.innerHTML = `
                            <p>Sie sind eingeloggt</p>
                            <button id="logoutButton">Ausloggen</button>
                        `;

                        // Ausloggen-Funktion hinzufügen
                        document.getElementById('logoutButton').addEventListener('click', function() {
                            logout();
                        });
                    }
                }
            };
            xhr.send();
        }

         document.getElementById('loginForm').addEventListener('submit', function(e) {
            e.preventDefault();
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;

            const xhr = new XMLHttpRequest();
            xhr.open('POST', 'https://informatik.hs-bremerhaven.de/docker-tfw-2024-e-web/cgi-bin/cgi/login.sh', true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    if (xhr.responseText === 'success') {
                        checkLoginStatus();
                    } else {
                        alert('Login fehlgeschlagen');
                    }
                }
            };
            xhr.send(`email=${email}&password=${password}`);
        });

      function logout() {
            const xhr = new XMLHttpRequest();
            xhr.open('POST', 'https://informatik.hs-bremerhaven.de/docker-tfw-2024-e-web/cgi-bin/cgi/logout.sh', true);
            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    location.reload();
                }
            };
            xhr.send();
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
        req2.open('GET', 'https://informatik.hs-bremerhaven.de/docker-tfw-2024-e-web/cgi-bin/cgi/create_session1.sh?' + email + ";" + password);
  console.log(email);
        req2.onreadystatechange = function () {
                if(req2.readyState == 4 && req2.status == 200){
                  console.log(document.cookie)

      if(document.cookie) {
        isLoggedIn = true;
       document.getElementById("loginButton").innerHTML="Status: Eingeloggt";
        updateUIForLoggedInUser();
      }
                }
        }

        req2.send(formData)

}



function handleLogout() {
  let req3 = new XMLHttpRequest();
  req3.open('GET', 'https://informatik.hs-bremerhaven.de/docker-tfw-2024-e-web/cgi-bin/cgi/delete_cookies.sh', true);

  req3.onreadystatechange = function() {
    if (req3.readyState === 4 && req3.status === 200) {
      isLoggedIn = false;
      location.reload();
    }
  };

  req3.send();
}




function updateUIForLoggedInUser() {
  let loginPanel = document.getElementById('loginPanel');
  loginPanel.innerHTML = `
    <p>Du bist eingeloggt.</p>
    <button id="logoutButton">Ausloggen</button>
  `;

  document.getElementById('logoutButton').onclick = handleLogout;
}

//function handleLogout() {
  //isLoggedIn = false;
  //location.reload();
//}


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
