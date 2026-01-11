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
  }
}


function init(evt) {
  let openers = document.querySelectorAll(".accordion .opener");
  for (let e of openers) {
    e.onclick = openOnClick;
  }
 if(document.getElementById('loginForm') !== null){
   
   document.getElementById('loginForm').addEventListener('submit', function(event){
     event.preventDefault();
     handleLogin();
   });
 }
}

function handleLogin() {
  const form = document.getElementById('loginForm');
  let formData = new FormData(form);
  form.onsubmit = function(event) {
    event.preventDefault();
  };

  let email = document.getElementById('email').value;
  let password = document.getElementById('password').value;

  let req = new XMLHttpRequest();
  req.open('GET', 'https://informatik.hs-bremerhaven.de/docker-tfw-2024-e-web/cgi-bin/cgi/create_session1.sh?' + email + ";" + password);

  req.onreadystatechange = function() {
    if(req.readyState == 4 && req.status == 200){
      console.log(document.cookie);
      
      let cookieValue = req.responseText;
      if(cookieValue !== "") {
        isLoggedIn = true;
        document.getElementById("loginButton").innerHTML="Status: Eingeloggt";
        updateUIForLoggedInUser();
      } else {
        isLoggedIn = false;
        alert("email oder passwort falsch");
        updateUIForLoggedInUser();
      }
    }
    
  };

  req.send(formData);
}

function handleLogout() {
  let req = new XMLHttpRequest();
  req.open('GET', 'https://informatik.hs-bremerhaven.de/docker-tfw-2024-e-web/cgi-bin/cgi/delete_session.sh', true);

  req.onreadystatechange = function() {
    if (req.readyState === 4 && req.status === 200) {
      isLoggedIn = false;
      location.reload();
    }
  };

  req.send();
}

function updateUIForLoggedInUser() {
  let loginPanel = document.getElementById('loginPanel');
  loginPanel.innerHTML = 
   '<div class="form-control"><p>Du bist eingeloggt.</p></div><div class="form-control"><button id="logoutButton">Ausloggen</button></div>';
  document.getElementById('logoutButton').onclick = handleLogout;
}

window.onload = init;
