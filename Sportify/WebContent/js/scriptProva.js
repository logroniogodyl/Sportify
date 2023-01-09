/*function darkerScreen() {
  // Crea l'overlay
  overlay = document.createElement("div");
 
  overlay.style.position = "absolute";
  overlay.style.top = 0;
  overlay.style.left = 0;
  overlay.style.width = "100%";
  overlay.style.height = "100%";
  overlay.style.backgroundColor = "rgba(0, 0, 0, 0.5)";
  overlay.style.zIndex = 1000;
  overlay.addEventListener("click", removeOverlay);

  // Mostra il form di login
  showFormProva();

  // Aggiunge l'overlay al documento
  document.body.appendChild(overlay);
}

document.getElementByClass("showProva").addEventListener("click", darkerScreen);


function showFormProva() {
    //FUNZIONE PER FAR APPARIRE IL LOGIN FORM
    document.getElementById("provaform").style.display="flex";}
    /*var vediformprova=document.getElementById("divprova");
    let buttonProva = document.querySelector('.showProva');
	buttonProva.addEventListener('click', function() {
  	let values = this.value.split(',');
  	let nomeASDprova = values[0];
  	let emailASDprova = values[1];
  // Fai qualcosa con nome e email
  var societacontattata= document.getElementById("<%=temp.getEmail()%>")
    vediformprova.innerHTML = "";
    vediformprova.innerHTML += '<div id="provaform">' +
  '<form method="Post" action="/">' +
    '<h3><b>FAI UNA PROVA CON' + nomeASDprova + '</b></h3>' +
    '<textarea name="messageProva" class="messageProva" rows="10" cols="30" placeholder="Inserisci qua il tuo messaggio..."></textarea>' +
    '<input type="submit" id="ProvaButton" value="Invia Richiesta">' +
  '</form>' +
'</div>;'
});
  }*/

/*document.getElementById("ProvaButton").addEventListener("click", function(event) {
  event.preventDefault();
  provaServlet();
});

function provaServlet() {
	var nome = document.getElementByClassName("this.nomeProva").value;
  var nome = document.getElementById("nome").value;
var telefono = document.getElementById("telefono").value;
var email = document.getElementById("emailReg").value;
var regione = document.getElementById("regione").value;
var provincia = document.getElementById("provincia").value;
var citta = document.getElementById("citta").value;
var indirizzo = document.getElementById("indirizzo").value;
var password = document.getElementById("passwordReg").value;
var repassword = document.getElementById("repassword").value;

  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      // Gestisci la risposta della servlet
      handleResponseReg(this.responseText);
    }
  };
  xhttp.open("GET", "Prova", true);
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  xhttp.send("nome=" + nome + "&telefono=" + telefono + "&email=" + email + "&regione=" + regione + "&provincia=" + provincia + "&citta=" + citta + "&indirizzo=" + indirizzo + "&password=" + password + "&repassword=" + repassword);
}*/