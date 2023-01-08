<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Random"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="Model.ASD"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SPORTIFY</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link href="/Sportify/css/style.css" rel="stylesheet">

</head>

<body>

	<%
	if (session.getAttribute("Utente") != null) {response.sendRedirect("Home");}
	%>

	<div id="supremo">
	
		<video id="background-video" autoplay muted poster="/Sportify/img/BackgroundFinale.png">
			<source src="" type="video/mp4">
		</video>

		<div class="container-fluid" id="header">	
			<div class="row">
			
				<div class="col-md-4" id="spazioLogo">
					<a href="Home"><img src="/Sportify/img/TextLogo.png" id="logo" class="HomeLogo"></a>
				</div>
						
				<div class="col-md-5"></div>
						
				<div class="col-md-3" id="login">

					<%
					if (session.getAttribute("Utente") == null) {
					%>
						<img src="/Sportify/img/IconaLogin.png" class="IconaLogin" id="loginbottone">
					<%
					} else {
					%>
					<a href="logout">
					LOGOUT
						<!-- <img src="/Sportify/img/IconaLogin.png" class="IconaLogin" id="logoutbottone"> -->
					</a>
					<%
					}
					%>
					
				</div>
				<!-- CHIUDE LOGIN -->
				
			</div>
		</div>
		<!-- CHIUDE HEADER -->
		
		<div class="container-principale">
		
			<div class="row">
				<div class="col-md-12">
					<ul class="col-md-6 nav">
						<li class="nav-item"><a class="nav-link active" href="Home">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="RicercaASD">Cerca ASD</a></li>						
						<li class="nav-item"><a class="nav-link" href="">Prenota un campo</a></li>
						<li class="nav-item"><a class="nav-link" href="">Contatti</a></li>
					</ul>
				</div>
			</div>
				<!-- CHIUDE NAVBAR -->
				
			<div class="row containerContenuti">
				<div class="col-md-3" id="ricercaASD">
					
					<div class="spazioRicercaASD">
						<form>
							<input type="text" id="barraRicercaASD" name="barraRicercaASD"
							placeholder="&nbsp Ricerca una Società Sportiva...">
						</form>
					</div>
					
					<div class="spazioFiltriASD">
						<% List<String> ASDRegioni = (List<String>) request.getAttribute("ASDregioni");%>
						<h5><b>REGIONI</b></h5>
						<form>
						<% for (String temp:ASDRegioni)
						{%>
							<input class="checkRegioni" onchange="RicercaCampiServlet()" type="checkbox"  id="regione<%=temp%>" name="<%=temp%>" value="<%=temp%>">
							 <label for="regione<%=temp%>"><%=temp%></label><br>
						<%}%>
						</form><br>
						
						<% List<String> ASDCitta = (List<String>) request.getAttribute("ASDcitta");%>
						<h5><b>CITTÁ</b></h5>
						<form id="sceltaCitta">
							<label for="scelta">Scegli un opzione:</label><br>
							<select id="sceltaASDcitta" name="scelta">
						<% for (String temp:ASDCitta)
						{%>
							<option value="opzione<%=temp%>"><%=temp%></option>
						<%}%>
							</select>
						</form><br>
						
						<p>- Rome was not built in a day</p>
					
					</div>
					
					
				</div>
				<!-- CHIUDE LA PARTE A SINISTRA -->
	
				<div class="col-md-9" id="risultatoRicercaASD">
	
					<% List<ASD> ElencoASD = (List<ASD>) request.getAttribute("AllASD"); %>
					<%for (ASD temp:ElencoASD)
					{%>
						<div class="row risultatoASD">
							
							<div class="col-md-3 sezioneSinistraASD">
							<img src="/Sportify/img/LucchettoProvvisorio.png" class="immagineRisultatoASD">
							<h2><%=temp.getNome()%></h2>
							</div>
							
							<div class="col-md-6 sezioneCentraleASD">
							<p>Indirizzo: <%=temp.getIndirizzo()%> (<%=temp.getCitta()%>)</p><br>
							<p>Email: <%=temp.getEmail()%></p>
							</div>
							
							<div class="col-md-3 sezioneDestraASD">
							<button type="button"><p>FAI UNA PROVA</p></button>
							</div>
							
						</div>
					
					<%}%>
	
				</div>
				<!-- CHIUDE PARTE DESTRA -->

			</div>
			<!-- CHIUDE CONTAINER CONTENUTI-->

		</div>
		<!-- CHIUDE CONTAINER PRINCIPALE -->






	<div id="loginform" style="display: none;" class="logreg">
  <form method="Post" action="">
    <h3>LOGIN</h3>
    <label>Email:</label><br>
    <input id="email" type="email" name="email" required><br>
    <label>Password:</label><br>
    <input id="password" type="password" name="password" required><br><br>
    <div id="erroreMessage"></div>
    <input type="submit" id="submitbutton" value="Accedi">
  </form>
  <hr style="height:100px;width:2px;border:solid;color:black;margin:2%">
  <div>Non hai un account? <a id="regbutton" href="javascript:showRegisterForm()">Registrati</a></div>
</div>
	<!-- LOGIN -->

	<div id="codiceinsert" class="logreg" style="display:none">
<label for="form">Inserisci il codice arrivato per Email:</label>
  <form method="Post" action="">
    <input class="input-slot" type="text" maxlength="1"  id="codice1" name="codice1" oninput="focusNextOnClick(this)" onkeydown="return allowNumbersOnly(event)">
    <input class="input-slot" type="text" maxlength="1" id="codice2" name="codice2" oninput="focusNextOnClick(this)" onkeydown="return allowNumbersOnly(event)">
    <input class="input-slot" type="text" maxlength="1" id="codice3" name="codice3" oninput="focusNextOnClick(this)" onkeydown="return allowNumbersOnly(event)">
    <input class="input-slot" type="text" maxlength="1" id="codice4" name="codice4" oninput="submitOnLast(this)" onkeydown="return allowNumbersOnly(event)">
    <div id="erroreMessageCode"></div>
    <input type="submit" id="submitbuttonCode" value="Verifica">
  </form>
  <a id="invioCode"href="#">Invia di nuovo il codice</a>
</div>


<div class="logreg redirect" id="redirect" style="display:none">
<div>Registrazione effettuata, verrai reindirizzato tra</div>
<div id="timerRedirect">3...</div>
</div>
	<!-- CODICE VERIFICA -->

	<div class="logreg" id="registerform">
  <form method="Post" action="">
    <label for="nome" >Nome Società:</label> <br>
    <input type="text" id="nome" name="nome" maxlength="40"><br>
    <label for="telefono">Numero di telefono:</label><br>
    <input type="text" id="telefono" name="telefono" maxlength="15"><br>
    <label for="email">Email</label><br>
    <input type="email" id="emailReg" name="email" maxlength="30">
    <br>
 
    <label for="regione">Regione:</label><br>
  <select id="regione" onchange="caricaProvince()">
    <option value="">Seleziona una regione</option>
    <option value="Piemonte">Piemonte</option>
    <option value="Valle d'Aosta">Valle d'Aosta</option>
    <option value="Lombardia">Lombardia</option>
    <option value="Trentino-Alto Adige">Trentino-Alto Adige</option>
    <option value="Veneto">Veneto</option>
    <option value="Friuli-Venezia Giulia">Friuli-Venezia Giulia</option>
    <option value="Liguria">Liguria</option>
    <option value="Emilia-Romagna">Emilia-Romagna</option>
    <option value="Toscana">Toscana</option>
    <option value="Umbria">Umbria</option>
    <option value="Marche">Marche</option>
    <option value="Lazio">Lazio</option>
    <option value="Abruzzo">Abruzzo</option>
    <option value="Molise">Molise</option>
    <option value="Campania">Campania</option>
    <option value="Puglia">Puglia</option>
    <option value="Basilicata">Basilicata</option>
    <option value="Calabria">Calabria</option>
    <option value="Sicilia">Sicilia</option>
    <option value="Sardegna">Sardegna</option>
  </select><br>
  
  <label for="provincia">Provincia:</label><br>
  <select id="provincia">
    <option value="">Seleziona prima una regione</option>
  </select><br>

    <label for="citta">Inserisci città:</label><br>
    <input type="text" id="citta" name="citta" maxlength="40"><br>

    <label for="indirizzo">Inserisci indirizzo:</label><br>
    <input type="text" id="indirizzo" name="indirizzo" maxlength="40">
    <br>

    <label for="password">Password</label><br>
    <input type="password" id="passwordReg" name="password" maxlength="30"><br>
    <label for="repassword">Reinserisci password</label><br>
    <input type="password" id="repassword" name="repassword" maxlength="30"><br>
    <br>
    <div id="erroreMessageReg"></div>
    <button id="submitbuttonReg">Registrati</button>
  </form>
  <br>
  <p>Hai già un account? <a href="javascript:showLoginForm()">Accedi</a></p> 
</div>
	<!-- REGISTRAZIONE cambiata gabriel -->

	<script src="/Sportify/js/script.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>

</html>