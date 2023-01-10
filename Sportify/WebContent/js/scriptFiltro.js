const ArrayFiltro = document.getElementsByClassName('filtro');
for (const element of ArrayFiltro) {
  if (element.checked) {
    console.log(`L'elemento con l'ID ${element.value} è selezionato`);
  } else {
	element.
    console.log(`L'elemento con l'ID ${element.value} non è selezionato`);
  }
}




function RicercaCampiServlet() {
	
	var risultato=document.getElementById("risultatoRicercaASD");
var ArrayRegioni=document.getElementsByClassName("checkRegioni");
risultato.innerHTML="";
var sendFiltroRegioni="";


for (var i = 0; i < ArrayRegioni.length; i++) {
  var checkbox = ArrayRegioni[i];
  if (checkbox.checked) {
    sendFiltroRegioni += checkbox.value + '=true&';
  } else {
    sendFiltroRegioni += checkbox.value + '=false&';
  }
}

// rimuovi l'ultimo carattere '&' dalla stringa
sendFiltroRegioni = sendFiltroRegioni.slice(0, -1);

  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      // Gestisci la risposta della servlet
      handleResponseFiltro(this.responseText);
    }
  };
  xhttp.open("POST", "RicercaASD", true);
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  xhttp.send("Filtro=true&"+ sendFiltroRegioni);
 

function handleResponseFiltro(response) {
  console.log("funziono ancora");
  // response contiene il JSON inviato dal server
  var list = JSON.parse(response);

  // Aggiorna il contenuto dell'elemento HTML
  risultato.innerHTML = ""; // cancella il contenuto attuale
  for (var i = 0; i < list.length; i++) {
    var asd = list[i];
    risultato.innerHTML += '<div class="row risultatoASD">' +
      '<div class="col-md-3 sezioneSinistraASD">' +
        '<img src="/Sportify/img/logoCalcio.png" class="immagineRisultatoASD">' +
        '<h2>' + asd.nome.toUpperCase() + '</h2>' +
      '</div>' +
      '<div class="col-md-9 sezioneDestraGrande">' +					
		'<div class="row geolocation">' +
		asd.geolocalizzazione +
		'</div>' +
		'<div class="row">' +
			'<div class="col-md-5 sezioneCentraleASD">' +
				'<p><b>INDIRIZZO:</b> ' + asd.indirizzo + ' ('+ asd.citta + ')</p>' +
				'<p><b>EMAIL:</b> ' + asd.email + '</p>' +
				'<p><b>TELEFONO:</b> ' + asd.telefono + '</p>' +
			'</div>' +
			'<div class="col-md-7 sezioneDestraASD">' +
				'<form action="Prova">' +
					'<div class="row nomecognome">' +
						'<input type="text" name="nomeProva" placeholder="Inserisci Nome...">' +
						'<input type="text" name="cognomeProva" placeholder="Inserisci Cognome..."><br>' +
					'</div>' +
					'<div class="row telefonofono">' +
						'<input type="tel" name="telefonoProva" placeholder="Inserisci numero di telefono...">' +
					'</div>' +
					'<div class="row provaprova">' +
						'<input type="hidden" name="emailProva" value="' + asd.email +'" class="hiddenmail">' +
						'<button type="submit" class="showProva" name="nomeASDProva" value="' + asd.nome + '">' +
						'<h5><b>FAI UNA PROVA</b></h5></button>' +
					'</div>'+
				'</form>' +
			'</div>' +
		'</div>' +
	'</div>' +
'</div>'
  }
}
}

//FINE FILTRO