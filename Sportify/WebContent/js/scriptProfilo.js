var errore=null;

//FUNZIONE PER CARICARE TUTTE LE PROVINCE A SECONDA DELLLA REGIONE SELEZIONATA
function caricaProvince() {
  
  // Seleziona gli elementi delle select
  var province = document.getElementById("provincia");
  var regione = document.getElementById("regione").value;
  //var regioneSelezionata = document.getElementById("regione").value;
  //var listaregioni = ["Piemonte", "Valle d'Aosta", "Lombardia", "Trentino-Alto Adige", "Veneto", "Friuli-Venezia Giulia", "Liguria", "Emilia-Romagna", "Toscana", "Umbria", "Marche", "Lazio", "Abruzzo", "Sardegna", "Sicilia", "Molise", "Campania", "Puglia", "Basilicata", "Calabria"]

  // Svuota il contenuto della select delle province
  province.innerHTML = "";

  // Array con le province di ogni regione
  var provincePiemonte = ["Torino", "Vercelli", "Novara", "Cuneo", "Asti", "Alessandria"];
  var provinceValleDAosta = ["Aosta"];
  var provinceLombardia = ["Milano", "Brescia", "Como", "Lecco", "Lodi", "Monza e della Brianza", "Pavia", "Sondrio", "Varese"];
  var provinceTrentinoAltoAdige = ["Trento", "Bolzano"];
  var provinceVeneto = ["Venezia", "Verona", "Padova", "Vicenza", "Treviso", "Belluno", "Rovigo"];
  var provinceFriuliVeneziaGiulia = ["Udine", "Gorizia", "Pordenone", "Trieste"];
  var provinceLiguria = ["Genova", "La Spezia", "Savona"];
  var provinceEmiliaRomagna = ["Bologna", "Ferrara", "Modena", "Parma", "Piacenza", "Ravenna", "Reggio nell'Emilia", "Rimini"];
  var provinceToscana = ["Firenze", "Arezzo", "Grosseto", "Livorno", "Lucca", "Massa-Carrara", "Pisa", "Pistoia", "Prato", "Siena"];
  var provinceUmbria = ["Perugia", "Terni"];
  var provinceMarche = ["Ancona", "Ascoli Piceno", "Fermo", "Macerata", "Pesaro e Urbino"];
  var provinceLazio = ["Roma", "Frosinone", "Latina", "Rieti", "Viterbo"];
  var provinceAbruzzo = ["L'Aquila", "Teramo", "Pescara", "Chieti"];
  var provinceMolise = ["Campobasso", "Isernia"];
  var provinceCampania = ["Napoli", "Avellino", "Benevento", "Caserta", "Salerno"];
  var provincePuglia = ["Bari", "Barletta-Andria-Trani", "Brindisi", "Foggia", "Lecce", "Taranto"];
  var provinceBasilicata = ["Matera", "Potenza"];
  var provinceCalabria = ["Catanzaro", "Cosenza", "Crotone", "Reggio di Calabria", "Vibo Valentia"];
  var provinceSicilia = ["Palermo", "Agrigento", "Caltanissetta", "Catania", "Enna", "Messina", "Ragusa", "Siracusa", "Trapani"];
  var provinceSardegna = ["Cagliari", "Nuoro", "Oristano", "Sassari", "Carbonia-Iglesias", "Medio Campidano", "Ogliastra", "Olbia-Tempio", "Oristano", "Sud Sardegna"];

  // Svuota il contenuto della select delle province
  province.innerHTML = "";

  if (regione == "Piemonte") {
    for (var i = 0; i < provincePiemonte.length; i++) {
      var opt = provincePiemonte[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      province.appendChild(el);
    }
  } else if (regione == "Valle d'Aosta") {
    for (var i = 0; i < provinceValleDAosta.length; i++) {
      var opt = provinceValleDAosta[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      province.appendChild(el);
    }
  } else if (regione == "Lombardia") {
    for (var i = 0; i < provinceLombardia.length; i++) {
      var opt = provinceLombardia[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      province.appendChild(el);
    }
  } else if (regione == "Trentino-Alto Adige") {
    for (var i = 0; i < provinceTrentinoAltoAdige.length; i++) {
    var opt = provinceTrentinoAltoAdige[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      province.appendChild(el);
    }
  } else if (regione == "Veneto") {
    for (var i = 0; i < provinceVeneto.length; i++) {
      var opt = provinceVeneto[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      province.appendChild(el);
    }
  } else if (regione == "Friuli-Venezia Giulia") {
    for (var i = 0; i < provinceFriuliVeneziaGiulia.length; i++) {
      var opt = provinceFriuliVeneziaGiulia[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      province.appendChild(el);
    }
  } else if (regione == "Liguria") {
    for (var i = 0; i < provinceLiguria.length; i++) {
      var opt = provinceLiguria[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      province.appendChild(el);
    }
  } else if (regione == "Emilia-Romagna") {
    for (var i = 0; i < provinceEmiliaRomagna.length; i++) {
      var opt = provinceEmiliaRomagna[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      province.appendChild(el);
    }
  } else if (regione == "Toscana") {
    for (var i = 0; i < provinceToscana.length; i++) {
      var opt = provinceToscana[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      province.appendChild(el);
    }
  } else if (regione == "Umbria") {
    for (var i = 0; i < provinceUmbria.length; i++) {
      var opt = provinceUmbria[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      province.appendChild(el);
    }
  } else if (regione == "Marche") {
    for (var i = 0; i < provinceMarche.length; i++) {
      var opt = provinceMarche[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      province.appendChild(el);
    }
  } else if (regione == "Lazio") {
    for (var i = 0; i < provinceLazio.length; i++) {
      var opt = provinceLazio[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      province.appendChild(el);
    }
  } else if (regione == "Abruzzo") {
    for (var i = 0; i < provinceAbruzzo.length; i++) {
      var opt = provinceAbruzzo[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      province.appendChild(el);
    }
  } else if (regione == "Molise") {
    for (var i = 0; i < provinceMolise.length; i++) {
      var opt = provinceMolise[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      province.appendChild(el);
    }
  } else if (regione == "Campania") {
    for (var i = 0; i < provinceCampania.length; i++) {
      var opt = provinceCampania[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      province.appendChild(el);
    }
  } else if (regione == "Puglia") {
    for (var i = 0; i < provincePuglia.length; i++) {
      var opt = provincePuglia[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      province.appendChild(el);
    }
  } else if (regione == "Basilicata") {
    for (var i = 0; i < provinceBasilicata.length; i++) {
      var opt = provinceBasilicata[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      province.appendChild(el);
    }
  } else if (regione == "Calabria") {
    for (var i = 0; i < provinceCalabria.length; i++) {
      var opt = provinceCalabria[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      province.appendChild(el);
    }
  } else if (regione == "Sicilia") {
    for (var i = 0; i < provinceSicilia.length; i++) {
      var opt = provinceSicilia[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      province.appendChild(el);
    }
  } else if (regione == "Sardegna") {
    for (var i = 0; i < provinceSardegna.length; i++) {
      var opt = provinceSardegna[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      province.appendChild(el);
    }
  }
}

document.getElementById("buttonAggiornaASD").addEventListener("click", function(event) {
	event.preventDefault();
	updateProfiloServlet();
	console.log("Sono nello script");
});

function updateProfiloServlet() {
	var indirizzo = document.getElementById("indirizzoASD").value;
	var telefono = document.getElementById("telefonoASD").value;
	var email = document.getElementById("emailASD").value;
	var regione = document.getElementById("regione").value;
	var provincia = document.getElementById("provincia").value;
	var citta = document.getElementById("cittaASD").value;
	var nome = document.getElementById("nomeASD").value;

	var password = document.getElementById("passASD").value;
	var repassword = document.getElementById("repassASD").value;
	
	console.log("Sono nella funzione e ho preso il valore della password: " + password);

  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      // Gestisci la risposta della servlet
      handleResponseEdit(this.responseText);
      console.log("Sono nell'IF dell'UPDATE");
    }
  };
  xhttp.open("POST", "AggiornaProfilo", true);
  console.log("Ho mandato questi dati alla Servlet: " + indirizzo + telefono + email + regione + provincia + citta + nome + password + repassword);
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  xhttp.send("telefonoASD=" + telefono + "&nomeASD=" + nome + "&emailASD=" + email + "&regione=" + regione + "&provincia=" + provincia + "&cittaASD=" + citta + "&indirizzoASD=" + indirizzo + "&passwordASD=" + password + "&repasswordASD=" + repassword);
}

function handleResponseEdit(response) {
    console.log("Sono nell'handleResponse");
    if (response === "Password diversa")
    {
		document.getElementById("erroreMessageEdit").innerHTML = "Password diversa dalla precedente, riprova";
		document.getElementById("succesfulEdit").innerHTML= "";
		console.log("Sono nell'handleResponse della password diversa");
	}
	else if(response === "Password corta")
    {
		document.getElementById("erroreMessageEdit").innerHTML = "La password deve avere minimo 8 caratteri";
		document.getElementById("succesfulEdit").innerHTML= "";
		console.log("Sono nell'handleResponse della password corta");
	}
	else
	{
		console.log("Sono nell'handleResponse della Edit andato a buon fine");
    	document.getElementById("erroreMessageEdit").innerHTML = ""; // svuota il contenuto del div
    	document.getElementById("succesfulEdit").innerHTML= "Modifiche effetuate! Il tuo profilo \u00E8 stato aggiornato";
    	
    	document.getElementById("passASD").value = "";
		document.getElementById("passASD").setAttribute("placeholder",document.getElementById("passASD").getAttribute("placeholder"));

		document.getElementById("repassASD").value = "";
		document.getElementById("repassASD").setAttribute("placeholder",document.getElementById("repassASD").getAttribute("placeholder"));

	}
}