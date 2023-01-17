<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Random"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="Model.ASD"%>
<%@ page import="java.util.Date"%>

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
	
<!-- ALL CSS -->
<link rel="stylesheet" href="/Sportify/css/style.css">
<link rel="stylesheet" href="/Sportify/css/login&register.css">
<link rel="stylesheet" href="/Sportify/css/profilo.css">

</head>

<body>

	<%
	if (session.getAttribute("Utente") == null) {response.sendRedirect("Home");}
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
				
			<div class="containerEdit">
			
				<% ASD asdsessione = (ASD) session.getAttribute("Utente");
				String address = asdsessione.getIndirizzo();%>
				               <form method="Post" action="">
				               
									<div class="row">	
									
										<div class="row">
											<div class="col-md-12 headerEdit">
												<h2> AGGIORNA IL TUO PROFILO</h2>
											</div>
										</div>
									
										<div class="col-md-6 EditSx">
										
											<input required type="text" style="display:none" id="nomeASD" value="<%=asdsessione.getNome()%>">
										
											<label for="indirizzoASD">MODIFICA INDIRIZZO:</label><br>		                
						                	<input type="text" name="indirizzoASD" value="<%=address%>" id="indirizzoASD"><br>
						                	
						                	<label for="regione">MODIFICA REGIONE:</label><br>
					  							<select id="regione" onchange="caricaProvince()" name="regioneASD">
					    							<option value="<%=asdsessione.getRegione()%>"><%=asdsessione.getRegione()%></option>
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
						                	
						                	 <label for="provincia"><b>MODIFICA PROVINCIA:</b></label><br>
				  								<select id="provincia" name="provinciaASD">
				    								<option value="<%=asdsessione.getProvincia()%>"><%=asdsessione.getProvincia()%></option>
				  								</select><br>
						                	
						                	<label for="cittaASD">MODIFICA CITTÁ:</label><br>
						                	<input type="text" name="cittaASD" value="<%=asdsessione.getCitta()%>" id="cittaASD"><br>
					                	
					                	</div>
					                	
					                	<div class="col-md-6 EditDx">
					                	
						                	<label for="telefonoASD">MOFDIFICA TELEFONO:</label><br>
						                	<input type="text" name="telefonoASD" value="<%=asdsessione.getTelefono()%>" id="telefonoASD"><br>
						                	
						                	<label for="emailASD">MODIFICA EMAIL:</label><br>
						                	<input type="text" name="emailASD" value="<%=asdsessione.getEmail()%>" id="emailASD"><br>
						                	
						                	<label for="passASD">MODIFICA PASSWORD:</label><br>
						                	<input type="password" name="passASD" value="" placeholder="INSERISCI NUOVA PASSWORD..."
						                	id="passASD"><br>
						                	
						                	<label for="repassASD">REINSERISCI NUOVA PASSWORD:</label><br>
						                	<input type="password" name="repassASD" value="" placeholder="RE-INSERISCI NUOVA PASSWORD..."
						                	id="repassASD"><br>
						                	<div id="erroreMessageEdit"></div>
						                	<div id="succesfulEdit"></div>
						                
					                	</div>
					                	
					                	<div class="row">
					                	
					                		<div class="col-md-9">
					                		</div>
					                		
					                		<div class="col-md-3">
					                		<button id="buttonAggiornaASD" class="bottoneAggiornaASD">AGGIORNA DATI</button>
					                		</div>
					                	
					                	</div>
					                	
				                	</div>
				                		
				                </form>
				
				<div class="col-md-6 cta">
					                
				</div>
				
			</div>
			<!-- CHIUDE CONTAINER CONTENUTI-->

		</div>
		<!-- CHIUDE CONTAINER PRINCIPALE -->

	</div>
	<!-- CHIUDE DIV SUPREMO -->

	<script src="/Sportify/js/script.js"></script>
	<!-- <script src="/Sportify/js/scriptLoginLogout.js"></script> -->
	<script src="/Sportify/js/scriptProfilo.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>

</html>