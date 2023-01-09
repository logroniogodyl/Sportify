var giornoSelezionato;

function cambiaOrario()
{
    var calendario=document.getElementById("data_prenotazione")
giornoSelezionato=calendario.value;
    // Trova il div "campi"
  const campi = document.getElementById('campi');

  // Rimuovi tutti i figli del div "campi"
  while (campi.firstChild) {
    campi.removeChild(campi.firstChild);
  }

  // Aggiungi i div con id numerico ordinato
  for (let i = 9; i < 22; i++) {
    const div = document.createElement('div');
    var idSlot = div.id = "H:"+i+"_D:" + giornoSelezionato;
    var giorno2= giornoSelezionato.toString();
    div.innerHTML = "data e ora: " + idSlot;
    campi.appendChild(div);
    }
    var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      // Gestisci la risposta della servlet
      handleResponsePreno(this.responseText);
    }
  };
  xhttp.open("POST", "/checkPrenotazioni", true);
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  xhttp.send("date="+giorno2);
}

function handleResponsePreno(response) {
    // "response" è il valore di "errorelog" inviato dalla servlet
    if (response == "true") {
        // Mostra il messaggio di errore
        console.log(giornoSelezionato)
        document.getElementById("erroreMessage").innerHTML = "Email o Password errati";
    } 
    else
    {
    console.log("Sono nell'else")

    removeOverlay()
location.reload(false)
    }
}