var giornoSelezionato;
const campi = document.getElementById('campi');
var calendario = document.getElementById("data_prenotazione")
const oggi = new Date();
const dataOdierna = oggi.toISOString().slice(0, 10);
var idCampo;
var nome
var div;
var dataSelezionata;
var orario;
var idCampoPadre;
var formPren = document.getElementById("prenotaCampo")


function caricamento() {
	calendario.value = dataOdierna;
	checkPren()
}

function checkPren() {
	var campi = document.getElementsByClassName("campi");

	for (var c = 0; c < campi.length; c++) {

		while (campi[c].firstChild) {
			campi[c].removeChild(campi[c].firstChild);

		}
		for (let i = 9; i < 22; i++) {

			idCampo = campi[c].id
			div = document.createElement('button');
			/*div.style.backgroundColor = "#D4EF99"
			div.style.width = "75px"
			div.style.heigth = "70px"
			div.style.margin = "5px"
			div.style.borderRadius = "10px"*/
			div.disabled = false;
			div.id = idCampo + "_H:" + i + "_D:" + calendario.value;
			div.innerHTML = i + ":00";
			div.addEventListener("click", darkScreen)
			div.className = "slotOrari";

			campi[c].appendChild(div)
		}
	}

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			// Gestisci la risposta della servlet
			handleResponsePren(this.responseText);
		}
	}
	xhttp.open("POST", "checkPren", true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("date=" + calendario.value);
}

function handleResponsePren(response) {

	const oggi = new Date();
	dataSelezionata = new Date(calendario.value)

	const dataOdierna = oggi.toISOString().slice(0, 10);
	const dataSel = dataSelezionata.toISOString().slice(0, 10);

	const dataSelected = new Date(dataSel)
	const dataOggi = new Date(dataOdierna);

	console.log("data odierna " + dataOdierna); // stamperà la data odierna nel formato "aaaa-mm-gg" (ad esempio "2023-01-08")
	console.log("data selezionata " + dataSel)
	var pren = JSON.parse(response);
	console.log(pren)


	var slot = document.getElementsByClassName("slotOrari")

	for (var i = 0; i < pren.length; i++) {

		var prenotazione = pren[i]
		var idSlot = "campo:" + prenotazione.idcampo + "_H:" + prenotazione.ora_prenotazione + "_D:" + prenotazione.data_prenotazione;

		for (var s = 0; s < slot.length; s++) {

			if (slot[s].id == idSlot) {

				slot[s].style.backgroundColor = "rgb(165, 42, 42)"
				
				slot[s].addEventListener("mouseover", mouseSopra)
						nome=prenotazione.nome
						slot[s].addEventListener("mouseout", mouseOut)		
				
			}


		}

	}
	if (dataSelected.getTime() < dataOggi.getTime()) {
		for (var s = 0; s < slot.length; s++) {

			if (slot[s].style.backgroundColor == "rgb(212, 239, 153)") {
				slot[s].disabled = true;
				slot[s].style.backgroundColor = "grey";

			}
			else {
				if (slot[s].style.backgroundColor == "rgb(165, 42, 42)"){ 
				slot[s].style.backgroundColor = "rgb(128, 64, 64)";
				}
				else{
					slot[s].style.backgroundColor = "grey";
				}
			}

		}
	}
}


var testoOrari
function mouseSopra(){
	
if(event.target.style.backgroundColor =="rgb(165, 42, 42)")
{
testoOrari=event.target.innerHTML;
event.target.innerHTML=nome;

	 event.target.removeEventListener('click', darkScreen);

}
}

function mouseOut(){
	event.target.innerHTML=testoOrari;
}






function formPrenotazione() {

	console.log("appare form")

	formPren.style.display = "flex"
	orario = event.target.innerHTML
	orario = orario.slice(0, -3);
	console.log(orario)
	idCampoPadre = event.target.parentElement.id
	idCampoPadre = idCampoPadre.substring(6)
}


function darkScreen() {
	// Crea l'overlay
	overlay = document.createElement("div");

	overlay.style.position = "absolute";
	overlay.style.top = 0;
	overlay.style.left = 0;
	overlay.style.width = "100%";
	overlay.style.height = "100%";
	overlay.style.backgroundColor = "rgba(0, 0, 0, 0.5)";
	overlay.style.zIndex = 1000;
	overlay.addEventListener("click", remOverlay);

	// Mostra il form
	formPrenotazione();

	// Aggiunge l'overlay al documento
	document.body.appendChild(overlay);
}

function remOverlay() {
	// Rimuove l'overlay dal documento
	overlay.parentNode.removeChild(overlay);
	// Rimuove il form di login

	document.getElementById("nomePren").value = "";
	document.getElementById("telefonoPren").value = "";
	document.getElementById("emailPren").value = "";
	document.getElementById("prenotaCampo").style.display = "none"
	document.getElementById("erroreMessagePren").innerHTML = "";
	document.getElementById("redirectPren").style.display = "none"
}


document.getElementById("submitPrenota").addEventListener("click", function(event) {
	event.preventDefault();
	prenotaCampoServlet();
});

function prenotaCampoServlet() {

	var email = document.getElementById("emailPren").value;
	var nome = document.getElementById("nomePren").value;


	var tel = document.getElementById("telefonoPren").value;
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			// Gestisci la risposta della servlet
			handleResponsePrenServlet(this.responseText);
		}
	}
	xhttp.open("POST", "prenota", true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("date=" + calendario.value + "&orario=" + orario + "&idCampo=" + idCampoPadre + "&email=" + email + "&nome=" + nome + "&telefono=" + tel);
}

function handleResponsePrenServlet(response) {
	if (response == "errore") {
		document.getElementById("erroreMessagePren").innerHTML = "Compila tutti i campi";
	}
	else {
		formPren.style.display = "none";
		console.log("sono nella funzione")
		document.getElementById("redirectPren").style.display = "flex";
		console.log(nome)
		document.getElementById("redirectPren").innerHTML = "Registrazione a nome di " + nome + "<br> effettuata. <br> Controlla la tua email per i dettagli della prenotazione!<br><button onclick=\"remOverlay()\">SIUM<button>";
		checkPren()
	}

}