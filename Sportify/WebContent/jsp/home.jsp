<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Random"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="Model.ASD"%>

<!doctype html>
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

<!-- ALL CSS -->
<link rel="stylesheet" href="/Sportify/css/style.css">
<link rel="stylesheet" href="/Sportify/css/login&register.css">
<link rel="stylesheet" href="/Sportify/css/home.css">

</head>

<body>



	<div id="supremo">
	
		<video id="background-video" autoplay muted poster="/Sportify/img/BackgroundFinale.png">
			<source src="/Sportify/img/BackgroundNuovo.mp4" type="video/mp4">
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
						<img src="/Sportify/img/IconaLogout.png" class="IconaLogout" id="logoutbottone">
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
			<% if (session.getAttribute("Utente") == null) {%>
			<div class="row">
				<div class="col-md-12">
					<ul class="col-md-6 nav">
						<li class="nav-item"><a class="nav-link active" href="Home">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="RicercaASD">Cerca ASD</a></li>
						<li class="nav-item"><a class="nav-link" href="Prenota">Prenota un campo</a></li>
						<li class="nav-item"><a class="nav-link" href="Contatti">Contatti</a></li>
					</ul>
				</div>
			</div>
			<!-- CHIUDE NAVBAR -->
			<%} else { %>
			<div class="row">
				<div class="col-md-12">
					<ul class="col-md-6 nav">
						<li class="nav-item"><a class="nav-link active" href="Home">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="Calendario">Calendario</a></li>
						<li class="nav-item"><a class="nav-link" href="GestioneCampi">Gestione Campi</a></li>
						<li class="nav-item"><a class="nav-link" href="Profilo">Profilo</a></li>
					</ul>
				</div>
			</div>
			<!-- CHIUDE NAVBAR -->
			<%} %>
					
					
			<div class="row containerContenuti">
				<div class="col-md-6" id="sinistra">



					<!-- CAROSELLO-->
					<% List<ASD> ASDrandom = (List<ASD>) request.getAttribute("ASDlistRandomica");
						if (ASDrandom != null)
							{%>
					<div id="carouselExampleCaptions" class="carousel slide pointer-event CaroselloASD">
							<%Random random = new Random();
							int casuale1;
							int casuale2;
							int casuale3;
							casuale1=1 + random.nextInt(9);
							do{
								casuale2 = 1 + random.nextInt(9);
							} while (casuale2 == casuale1 || casuale2 == 0);
							do{
								casuale3 = 1+random.nextInt(9);
							} while (casuale3 == casuale2 || casuale3==casuale1 || casuale3==0);
							%>
							
							<div class="carousel-indicators">
								<button type="button" data-bs-target="#carouselExampleCaptions"
									data-bs-slide-to="0" class="active" aria-label="Slide 1"
									aria-current="true"></button>
								<button type="button" data-bs-target="#carouselExampleCaptions"
									data-bs-slide-to="1" aria-label="Slide 2" class=""></button>
								<button type="button" data-bs-target="#carouselExampleCaptions"
									data-bs-slide-to="2" aria-label="Slide 3" class=""></button>
							</div>
							<!-- CHIUDE CAROUSEL-INDICATORS -->
							
							<div class="carousel-inner CaroselloInterno">
							
								<div class="carousel-item active">
									
									<img class="immagineCarosello" src="/Sportify/img/Campo<%=casuale1%>.png">
									
									<div class="carousel-caption d-md-block">
										<%
										ASD primaASD = ASDrandom.get(0);
										String nomePrimaASD = primaASD.getNome();
										String cittaPrimaASD = primaASD.getCitta();
										String indirizzoPrimaASD = primaASD.getIndirizzo();
										String emailPrimaASD = primaASD.getEmail();
										%><h4><%=nomePrimaASD%></h4>
										<p>
											Ci troviamo in
											<%=indirizzoPrimaASD%>,
											<%=cittaPrimaASD%>.
										</p>
									</div>
								</div>
								<!-- CHIUDE CAROUSEL-ITEM ACTIVE -->
								
								<div class="carousel-item">
								
									<img class="immagineCarosello" src="/Sportify/img/Campo<%=casuale2%>.png">
									
									<div class="carousel-caption d-md-block">
										<%
										ASD secondaASD = ASDrandom.get(1);
										String nomeSecondaASD = secondaASD.getNome();
										String cittaSecondaASD = secondaASD.getCitta();
										String indirizzoSecondaASD = secondaASD.getIndirizzo();
										String emailSecondaASD = secondaASD.getEmail();
										%>
										<h4><%=nomeSecondaASD%></h4>
										<p>
											Ci troviamo in
											<%=indirizzoSecondaASD%>,
											<%=cittaSecondaASD%>.
										</p>
									</div>
								</div>
								<!-- CHIUDE CAROUSEL-item -->
								
								<div class="carousel-item">
								
									<img class="immagineCarosello" src="/Sportify/img/Campo<%=casuale3%>.png">
									
									<div class="carousel-caption d-md-block">
										<%
										ASD terzaASD = ASDrandom.get(2);
										String nomeTerzaASD = terzaASD.getNome();
										String cittaTerzaASD = terzaASD.getCitta();
										String indirizzoTerzaASD = terzaASD.getIndirizzo();
										String emailTerzaASD = terzaASD.getEmail();
										%>
										<h4><%=nomeTerzaASD%></h4>
										<p>
											Ci troviamo in
											<%=indirizzoTerzaASD%>,
											<%=cittaTerzaASD%>.
										</p>
									</div>
									
								</div>
								<!-- CHIUDE CAROUSEL-ITEM-->

						</div>
						<!-- CHIUDE INNER CAROSELLO -->
						
						
						<button class="carousel-control-prev" type="button"
							data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
							<span class="carousel-control-prev-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Previous</span>
						</button>
						<button class="carousel-control-next" type="button"
							data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Next</span>
						</button>

					</div>
					<%}
					else
					{%>
						<div id="carouselExampleCaptions" class="carousel slide pointer-event CaroselloASD">
						 
						
							<div class="carousel-indicators">
								<button type="button" data-bs-target="#carouselExampleCaptions"
									data-bs-slide-to="0" class="active" aria-label="Slide 1"
									aria-current="true"></button>
								<button type="button" data-bs-target="#carouselExampleCaptions"
									data-bs-slide-to="1" aria-label="Slide 2" class=""></button>
								<button type="button" data-bs-target="#carouselExampleCaptions"
									data-bs-slide-to="2" aria-label="Slide 3" class=""></button>
							</div>
							<!-- CHIUDE CAROUSEL-INDICATORS -->
						
							<div class="carousel-inner CaroselloInterno">
							
								<div class="carousel-item active">
									
									<img class="immagineCarosello" src="/Sportify/img/Campo1.png">
									
									<div class="carousel-caption d-md-block">
										<h4>Masseroni</h4>
										<p> Ci troviamo in Viale Tunisia 37, Milano.</p>
									</div>
								</div>
								<!-- CHIUDE CAROUSEL-ITEM ACTIVE -->
								
								<div class="carousel-item">
									<img class="immagineCarosello" src="/Sportify/img/Campo9.png">
									<div class="carousel-caption d-md-block">
										<h4>Juventus Accademy</h4>
										<p>Ci troviamo in Via Roma 8, Torino.</p>
									</div>
								</div>
								<!-- CHIUDE CAROUSEL-item -->
								
								<div class="carousel-item">
									<img class="immagineCarosello" src="/Sportify/img/Campo6.png">
									<div class="carousel-caption d-md-block">
										<h4>CUS</h4>
										<p>Ci troviamo in Piazza Napoli 2, Milano.</p>
									</div>
								</div>
								<!-- CHIUDE CAROUSEL-ITEM-->
								
							</div>
							<!-- CHIUDE INNER CAROSELLO -->
						
						
							<button class="carousel-control-prev" type="button"
								data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
								<span class="carousel-control-prev-icon" aria-hidden="true"></span>
								<span class="visually-hidden">Previous</span>
							</button>
							<button class="carousel-control-next" type="button"
								data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
								<span class="carousel-control-next-icon" aria-hidden="true"></span>
								<span class="visually-hidden">Next</span>
							</button>
							 
						</div>
						<!-- CHIUDE CAROSELLO -->
					<%}%>
					<!-- CHIUDE CAROSELLO -->



					<div id="risultati">
						<iframe src='https://www.tuttocampo.it/WidgetV2/Risultati/570ce2a7-5474-11e4-b2c1-448a5b2c3468'
						scrolling='yes' frameborder='0' id="calendarioSerieA"></iframe>
					</div>
					<!-- CHIUDE RISULTATI PARTITA -->

				</div>
				<!-- CHIUDE LA PARTE A SINISTRA -->

				<% if (session.getAttribute("Utente") == null) {%>
				<div class="col-md-6" id="destra">
					<img src="/Sportify/img/Lucchetto.png" id="lucchettoBacheca"><br>
					<h4><b>REGISTRATI PER VEDERE LA BACHECA</b></h4>
				</div>
				<!-- CHIUDE PARTE DESTRA -->
				<%}
				else
				{%>
				<div class="col-md-6" id="destraUtente">
					<img src="/Sportify/img/WorkInProgress.png">
					<h4><b>COMING SOON</b></h4><br>
					<h5>CI STIAMO LAVORANDO</h5>
				</div>
				<%} %>

			</div>
			<!-- CHIUDE CONTAINER CONTENUTI -->

		</div>
		<!-- CHIUDE CONTAINER PRINCIPALE -->

	</div>
	<!-- CHIUDE DIV SUPREMO -->





	<div id="loginform" style="display: none;" class="logreg">
	  <form method="Post" action="/">
	    <h3><b>LOGIN</b></h3>
	    <label><b>Email:</b></label><br>
	    <input id="email" type="email" name="email" placeholder="Inserisci e-mail" required><br>
	    <label><b>Password:</b></label><br>
	    <input id="password" type="password" name="password" placeholder="Inserisci password" required><br><br>
	    <div id="erroreMessage"></div>
	    <input type="submit" id="submitbutton" value="Accedi">
	  </form>
	  <hr style="height:100px;width:2px;border:solid;color:black;margin:2%">
	  <div>Non hai un account? <a id="regbutton" href="javascript:showRegisterForm()"><b>Registrati</b></a></div>
	</div>
	<!-- LOGIN -->

	<div id="codiceinsert" class="logreg" style="display:none">
		<label for="form" class="labelCodiceVerifica">Inserisci il codice arrivato per Email:</label>
	  	<form method="Post" action="">
	    	<input class="input-slot" type="text" maxlength="1"  id="codice1" name="codice1" oninput="focusNextOnClick(this)" onkeydown="return allowNumbersOnly(event)">
	    	<input class="input-slot" type="text" maxlength="1" id="codice2" name="codice2" oninput="focusNextOnClick(this)" onkeydown="return allowNumbersOnly(event)">
	    	<input class="input-slot" type="text" maxlength="1" id="codice3" name="codice3" oninput="focusNextOnClick(this)" onkeydown="return allowNumbersOnly(event)">
	    	<input class="input-slot" type="text" maxlength="1" id="codice4" name="codice4" oninput="submitOnLast(this)" onkeydown="return allowNumbersOnly(event)">
	    	<div id="erroreMessageCode"></div>
	    	<input type="submit" id="submitbuttonCode" value="Verifica">
	  	</form>
	  	<a id="invioCode"href=""><b>Invia di nuovo il codice</b></a>
	</div>


	<div class="logreg redirect" id="redirect" style="display:none">
		<div id="timerRedirect"><p>Registrazione effettuata, verrai reindirizzato tra 3...</p></div>
	</div>
	<!-- CODICE VERIFICA -->

	<div class="logreg" id="registerform">
  		<form method="Post" action="">
		    <label for="nome" ><b>Nome Società:</b></label> <br>
		    <input type="text" id="nome" name="nome" maxlength="40"><br>
		    <label for="telefono"><b>Numero di telefono:</b></label><br>
		    <input type="text" id="telefono" name="telefono" maxlength="15"><br>
		    <label for="email"><b>Email</b></label><br>
		    <input type="email" id="emailReg" name="email" maxlength="30"><br>
		    
    		<label for="regione"><b>Regione:</b></label><br>
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
  
		  <label for="provincia"><b>Provincia:</b></label><br>
		  	<select id="provincia">
		    <option value="">Seleziona prima regione</option>
		  	</select><br>
		
		    <label for="citta"><b>Inserisci città:</b></label><br>
		    <input type="text" id="citta" name="citta" maxlength="40"><br>
		
		    <label for="indirizzo"><b>Inserisci indirizzo:</b></label><br>
		    <input type="text" id="indirizzo" name="indirizzo" maxlength="40"><br>
		
		    <label for="password"><b>Password</b></label><br>
		    <input type="password" id="passwordReg" name="password" maxlength="30"><br>
		    <label for="repassword"><b>Reinserisci password</b></label><br>
		    <input type="password" id="repassword" name="repassword" maxlength="30"><br><br>
		    
		    <div id="erroreMessageReg"></div>
		    
		    <button id="submitbuttonReg">Registrati</button>
	  	</form><br>
  		<p>Hai già un account? <a href="javascript:showLoginForm()"><b>Accedi</b></a></p> 
	</div>
	<!-- REGISTRAZIONE -->

	<script src="/Sportify/js/script.js"></script>
	<script src="/Sportify/js/scriptLoginLogout.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>

</html>