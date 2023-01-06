var overlay = null;
var errore=null;


function showLoginForm() {
    //FUNZIONE PER FAR APPARIRE IL LOGIN FORM
    document.getElementById("loginform").style.display="flex";
    document.getElementById("registerform").style.display="none";
  }
  
  
  
  
  function showRegisterForm()
  {
    document.getElementById("registerform").style.display="flex";
    removeLoginForm();
  }

 function darkenScreen() {
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
  showLoginForm();

  // Aggiunge l'overlay al documento
  document.body.appendChild(overlay);
}

function removeLoginForm() {
  // Rimuove il form di login dal documento
  var container = document.getElementById("loginform");
  container.style.display="none";
  
}



function removeOverlay() {
  // Rimuove l'overlay dal documento
  overlay.parentNode.removeChild(overlay);
  // Rimuove il form di login
  document.getElementById("registerform").style.display="none";
  removeLoginForm();
  document.getElementById("erroreMessage").innerHTML = ""
  document.getElementById("email").value = "";
document.getElementById("password").value = "";
document.getElementById("codiceinsert").style.display="none";

const inputSlots = document.getElementsByClassName("input-slot");
for (let i = 0; i < inputSlots.length; i++) {
  inputSlots[i].value = "";
}
}


document.getElementById("loginbottone").addEventListener("click", darkenScreen);




//FUNZIONE PER CARICARE TUTTE LE PROVINCE A SECONDA DELLLA REGIONE SELEZIONATA
function caricaProvince() {
  // Seleziona gli elementi delle select
  var province = document.getElementById("provincia");
  var regione = document.getElementById("regione").value;

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




function loginServlet() {
  var email = document.getElementById("email").value;
  var password = document.getElementById("password").value;

  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      // Gestisci la risposta della servlet
      handleResponseLogin(this.responseText);
    }
  };
  xhttp.open("POST", "login", true);
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  xhttp.send("email=" + email + "&password=" + password);
}

function handleResponseLogin(response) {
    // "response" è il valore di "errorelog" inviato dalla servlet
    if (response == "true") {
        // Mostra il messaggio di errore
        document.getElementById("erroreMessage").innerHTML = "Email o Password errati";
    } 
    else
    {
	removeOverlay()

  const inputSlots = document.getElementsByClassName("input-slot");
for (let i = 0; i < inputSlots.length; i++) {
  inputSlots[i].value = "";
}	
}
}

function showCodiceForm()
{
	document.getElementById("registerform").style.display="none";
	document.getElementById("codiceinsert").style.display="flex";
}

function registerServlet() {
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
  xhttp.open("POST", "registrazione", true);
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  xhttp.send("nome=" + nome + "&telefono=" + telefono + "&email=" + email + "&regione=" + regione + "&provincia=" + provincia + "&citta=" + citta + "&indirizzo=" + indirizzo + "&password=" + password + "&repassword=" + repassword);
}

function handleResponseReg(response) {
    
    if (response === "Errore Mail") {
        // Mostra il messaggio di errore
        document.getElementById("erroreMessageReg").innerHTML = "Email già presente, provane un'altra";
    } 
    else if(response === "Errore nome")
    {
	document.getElementById("erroreMessageReg").innerHTML = "Società già presente, prova un altro nome";
	}
	 else if(response === "Password diversa")
    {
	document.getElementById("erroreMessageReg").innerHTML = "Password diversa dalla precedente, riprova";
	}
	
    else
    {
	showCodiceForm()
}
}

document.addEventListener("keydown", function(event) {
  if (event.key === "Backspace") {
    var focusedElement = document.activeElement;
    var inputElements = document.getElementsByClassName("input-slot");
    var currentIndex = Array.prototype.indexOf.call(inputElements, focusedElement);
    if (currentIndex > 0) {
      inputElements[currentIndex - 1].focus();
    }
  }
});

document.getElementById("submitbutton").addEventListener("click", function(event) {
  event.preventDefault();
  loginServlet();
});


document.getElementById("submitbuttonReg").addEventListener("click", function(event) {
  event.preventDefault();
  registerServlet();
});
