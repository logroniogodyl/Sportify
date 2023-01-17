var giornoSelezionato;
const campi = document.getElementById('campi');
var calendario = document.getElementById("data_prenotazione")
const oggi = new Date();
const dataOdierna = oggi.toISOString().slice(0, 10);
var idCampo;
var nome
var pren;
var div;
var dataSelezionata;
var orario;
var idCampoPadre;
var formPren = document.getElementById("prenotaCampo")


function caricamento() {
	calendario.value = dataOdierna;
	checkPren()
}

function showSelect() {
	var giornoOraPren = document.getElementById("giornoOraPren");
	giornoOraPren.style.display = "flex";
}
function noSelect() {
	var giornoOraPren = document.getElementById("giornoOraPren");
	giornoOraPren.style.display = "none";
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
			div.style.backgroundColor = "#D4EF99"
			/*div.style.width = "50px"
			div.style.heigth = "50px"
			div.style.margin = "5px"*/
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

	var dataSelezionata2 = new Date(calendario.value)
	var giornoSelezionato = dataSelezionata2.getDay();
	console.log(giornoSelezionato)
	xhttp.open("POST", "checkPren", true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("date=" + calendario.value + "&day=" + giornoSelezionato);
}

function handleResponsePren(response) {


	dataSelezionata = new Date(calendario.value)

	const dataOdierna = oggi.toISOString().slice(0, 10);
	const dataSel = dataSelezionata.toISOString().slice(0, 10);
	var giornoSelected = new Date(dataSel)

	console.log("selezionato : " + giornoSelected.getDay())

	const dataSelected = new Date(dataSel)
	const dataOggi = new Date(dataOdierna);

	console.log("data odierna " + dataOdierna); // stamperà la data odierna nel formato "aaaa-mm-gg" (ad esempio "2023-01-08")
	console.log("data selezionata " + dataSel)
	pren = JSON.parse(response);
	console.log(pren)


	var slot = document.getElementsByClassName("slotOrari")

	for (var i = 0; i < pren.length; i++) {

		var prenotazione = pren[i]
		var idCheck = "campo:" + prenotazione.idcampo + "_H:" + prenotazione.ora_prenotazione + "_D:" + prenotazione.data_prenotazione;

		console.log("data selezionata gionro :" + giornoSelected.getDay())
		console.log("data prenotazione : " + prenotazione.data_prenotazione)
		if (giornoSelected.getDay() == prenotazione.data_prenotazione) {
			var idCheckAllenamento = "campo:" + prenotazione.idcampo + "_H:" + prenotazione.ora_prenotazione + "_D:" + dataSel;

			for (var s = 0; s < slot.length; s++) {
				
				var idSlot = slot[s].id
				
				if (idSlot == idCheckAllenamento){
					slot[s].style.backgroundColor = "rgb(240,130,0)"
					slot[s].removeEventListener('click', darkScreen);
				}
				
			}
		}

		for (var s = 0; s < slot.length; s++) {
			var idSlot = slot[s].id

			if (idCheck == idSlot) {
				
				let [campoSlot, HSlot, DSlot] = idSlot.split('_').map(item => item.split(':')[1]);
				let element = findElement(pren, DSlot, HSlot, campoSlot);
				
				if(element.tipologia=="Normale")
				{
					slot[s].style.backgroundColor = "red"
					slot[s].removeEventListener('click', darkScreen);
				}
				else if(element.tipologia=="allenamentoEXTRA")
				{
					slot[s].style.backgroundColor = "rgb(255,200,0)"
					slot[s].removeEventListener('click', darkScreen);
				}
				else if(element.tipologia=="partita")
				{
					slot[s].style.backgroundColor = "rgb(170,0,0)"
					slot[s].removeEventListener('click', darkScreen);
				}
				else if(element.tipologia=="inagibilita")
				{
					slot[s].style.backgroundColor = "rgb(35,35,35)"
					slot[s].removeEventListener('click', darkScreen);
				}

			}
		}
	}
	if (dataSelected.getTime() < dataOggi.getTime()) {
		for (var s = 0; s < slot.length; s++) {
			slot[s].disabled = true;


			if (slot[s].style.backgroundColor == "rgb(212, 239, 153)") {
				slot[s].style.filter = "grayscale(100%) brightness(40%)";
			}
			else {
				slot[s].style.filter = "grayscale(60%) brightness(60%)";
			}
		}
	}
}




function findElement(array, DSlot, HSlot, campoSlot) {
	console.log(`Cercando elemento con data: ${DSlot}, ora: ${HSlot} e id del campo: ${campoSlot}`);
	let element = array.find(item => {
		console.log(`Verificando elemento:`, item);
		let result = item.data_prenotazione == DSlot && item.ora_prenotazione == HSlot && item.idcampo == campoSlot;
		console.log(`Risultato:`, result);
		return result;
	});
	console.log(`Elemento trovato:`, element);
	return element;
}


var testoOrari
function mouseSopra() {

	if (event.target.style.backgroundColor == "red") {
		let idOver = event.target.id;
		console.log(idOver)

		let [campoSlot, HSlot, DSlot] = idOver.split('_').map(item => item.split(':')[1]);

		let element = findElement(pren, DSlot, HSlot, campoSlot);
		console.log(pren)
		console.log(campoSlot)
		console.log(HSlot)
		console.log(DSlot)
		console.log(element)


		testoOrari = event.target.innerHTML;
		event.target.innerHTML = element.nome;

		event.target.removeEventListener('click', darkScreen);

	}
}

function mouseOut() {
	event.target.innerHTML = testoOrari;
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
	nome = document.getElementById("nomePren").value;
	var email = document.getElementById("emailPren").value;
	var tel = document.getElementById("telefonoPren").value;

	if (idSoc == "0") {

		var tipo = "Normale"
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				// Gestisci la risposta della servlet
				handleResponsePrenServlet(this.responseText);
			}
		}
		xhttp.open("POST", "prenota", true);
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.send("date=" + calendario.value + "&orario=" + orario + "&idCampo=" + idCampoPadre + "&email=" + email + "&nome=" + nome + "&telefono=" + tel + "&tipo=" + tipo);

		function handleResponsePrenServlet(response) {
			if (response == "errore") {
				document.getElementById("erroreMessagePren").innerHTML = "Compila tutti i campi";
			}
			else {
				formPren.style.display = "none";
				document.getElementById("redirectPren").style.display = "flex";
				document.getElementById("redirectPren").innerHTML = "Prenotazione a nome di " + nome + "<br> effettuata. <br> Controlla la tua email per i dettagli della prenotazione!<button onclick=\"remOverlay()\" style=\'height:30px; background-color: #225FE3; color: white; border-radius: 10px; margin-top: 10px;\'>SIUM</button>";
				checkPren()
			}
		}
	}



	else {


		var tipo = document.querySelector('input[name="tipoPren"]:checked').value;
		var giornoSettimana = document.getElementById("giornoPren").value;
		var oraSelezionata = document.getElementById("oraPren").value;
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				// Gestisci la risposta della servlet
				handleResponsePrenServlet(this.responseText);
			}
		}

		if (tipo == "allenamento") {

			xhttp.open("POST", "prenota", true);
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhttp.send("date=" + giornoSettimana + "&orario=" + oraSelezionata + "&idCampo=" + idCampoPadre + "&email=" + emailSoc + "&nome=" + nomeSoc + "&telefono=" + telSoc + "&tipo=" + tipo + "&codiceSoc=" + idSoc);
		}
		else {
			console.log("sono in tipo " + tipo)
			xhttp.open("POST", "prenota", true);
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhttp.send("date=" + calendario.value + "&orario=" + orario + "&idCampo=" + idCampoPadre + "&email=" + emailSoc + "&nome=" + nomeSoc + "&telefono=" + telSoc + "&tipo=" + tipo + "&codiceSoc=" + idSoc);
		}


		function handleResponsePrenServlet(response) {
			if (response == "errore") {
				document.getElementById("erroreMessagePren").innerHTML = "Compila tutti i campi";
			}
			else {
				formPren.style.display = "none";
				document.getElementById("redirectPren").style.display = "flex"
				document.getElementById("redirectPren").innerHTML = "Prenotazione effettuata!<br><button onclick=\"remOverlay()\" style=\'height:30px; background-color: #225FE3; color: white; border-radius: 10px; margin-top: 10px;\'>SIUM</button>";
				checkPren()
			}
		}
	}
}