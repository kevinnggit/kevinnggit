 function regFormHaendler (event) {
    event.preventDefault();

    let vorname=document.getElementById('firstname').value;
    let nachname=document.getElementById('lastname').value;
    let gbdate=document.getElementById('gbdate').value;
    let benutzername=document.getElementById('username').value;
    let emailAd=document.getElementById('email').value;
    let passwort=document.getElementById('enterpass').value;
    let confirmPass=document.getElementById('confirmpass').value;


      let queryString='vorname' + vorname + 'nachname=' + nachname + 'gbdate=' + gbdate + 'benutzername=' + benutzername + 'emailAd=' + emailAd + 'passwort=' + passwort;


  fetch('https://informatik.hs-bremerhaven.de/docker-swe2-2024-team17-web/cgi-bin/register.sh?' + queryString {
      method:'GET'
    })
    .then(function(response){
      return response.text();
    })
    .then(function(result){
      document.write(result);
    })
  }


  function logHaendler(event) {
    event.preventDefault();

    let benutzername=document.getElementById('username').value;
    let passwort=document.getElementById('enterpass').value;

    let queryString='benutzername=' + benutzername + 'passwort=' + passwort;

    fetch('https://informatik.hs-bremerhaven.de/docker-swe2-2024-team17-web/cgi-bin/login.sh?' + queryString {
      method:'GET'
    })
    .then(function(response){
      return response.text();
    })
    .then(function(result){
      document.write(result);
   })
  }

    if (document.getElementById('registerFormular')) {
      document.getElementById('registerFormular').addEventListener('submit',regFormHaendler);
    }

    if (document.getElementById('loginFormular')){
      document.getElementById('loginFormular').addEventListener('submit',logHaendler);
    }
