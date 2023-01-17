<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Random"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="Model.ASD"%>
<%@ page import="Model.Campo"%>
<%@ page import="Data.CampoDAO"%>

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
<link rel="stylesheet" href="/Sportify/css/calendario.css">

</head>

<body onLoad="caricamento()">

	<%
	if (session.getAttribute("Utente") == null) {response.sendRedirect("Home");}
	ASD utente =(ASD)session.getAttribute("Utente");
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

					<a href="logout">
						<img src="/Sportify/img/IconaLogout.png" class="IconaLogout" id="logoutbottone">
						<!-- <img src="/Sportify/img/IconaLogin.png" class="IconaLogin" id="logoutbottone"> -->
					</a>
					
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
				

		<div class="row containerContenuti">
			<!-- DA SOSTITUIRE GLI ID E LE LISTE CHE ARRIVANO -->
			<div class="col-md-3" id="ricercaCampi">
			
					 <div class="calendarioPerCampi" id="calendario">
						<form id="calendar">
							<input onchange="checkPren()" type="date"
							id="data_prenotazione" name="data_prenotazione">
						</form>
					</div>
					
					<div class="spazioFiltriCampi">
					
						<% List<String> FieldsType = (List<String>) request.getAttribute("TypoCampi");%>
						<h5><b>TIPOLOGIA CAMPO</b></h5>
						<form>
						<% for (String temp:FieldsType)
						{%>
							<input class="checkTipologia" onchange="" type="checkbox" id="tipologia<%=temp%>" name="<%=temp%>" value="<%=temp%>">
							<label for="tipologia<%=temp%>"><%=temp%></label><br>
						<%}%>
						</form><br>	
						
						<p>- Rome was not built in a day</p>
					
					</div>
					
				</div>
				<!-- CHIUDE LA PARTE A SINISTRA -->
	
				<div class="col-md-9" id="risultatoRicercaCampi">
				
					<% List<Campo> ElencoCampi = (List<Campo>) request.getAttribute("MyCampi");%>
					<%for (Campo temp:ElencoCampi)
					{%>
						<div class="risultatoCampi">
							
							<div class="headerRisultati">
								<div>
								<%if (temp.getTipologia().equals("Calcio a 11")) 
									{%>
									<img src="/Sportify/img/CampoA11.png" class="tipologiaCampoDaGioco">
									<%}
									else
									{%>
									<img src="/Sportify/img/CampoA5.png" class="tipologiaCampoDaGioco">
									<%}%>
								</div>
								
								<div>
									
									<div>
									<h1 style="color:#D4EF99; font-size: 50px; align-items: center"><b><%=temp.getNome().toUpperCase()%></b></h1>
									</div>
									
									<div class="nomeASDANDindirizzo">
									<h2 style="color: white"><%=CampoDAO.selectNomeASDbyCampoId(temp.getIdcampo()).toUpperCase()%></h2>
									<p style="color: white">&nbsp&nbsp&nbsp<%=CampoDAO.selectIndirizzoASDbyCampoId(temp.getIdcampo())%> (<%=CampoDAO.selectCittaASDbyCampoId(temp.getIdcampo()).toUpperCase()%>)</p>
									</div>
								</div>
								
							</div>
							
							
							<!-- <div class="nomeANDtipologia">
							
									< %if (temp.getTipologia().equals("Calcio a 11")) 
									{%>
									<img src="/Sportify/img/CampoA11.png" class="tipologiaCampoDaGioco">
									< %}
									else
									{%>
									<img src="/Sportify/img/CampoA5.png" class="tipologiaCampoDaGioco">
									< %}%>
									<h1 style="color:#D4EF99; font-size: 50px; align-items: center"><b>< %=temp.getNome().toUpperCase()%></b></h1>
							
							</div>
							
							<div class="ASDANDindirizzo" style="align-items: baseline">
								
									<h2 style="color: white">< %=CampoDAO.selectNomeASDbyCampoId(temp.getIdcampo())%></h2>
									<p style="color: white">&nbsp&nbsp&nbsp< %=CampoDAO.selectIndirizzoASDbyCampoId(temp.getIdcampo())%>(< %=CampoDAO.selectCittaASDbyCampoId(temp.getIdcampo()).toUpperCase()%>)</p>
								
							</div> -->
							
							<div class="minidivsGabrielperCalendario">
							
									<div style="display:flex; color:white;" id="campo:<%=temp.getIdcampo() %>" class="campi" style="color: white;">
	             					</div>
							
									<p class="outputData" style="color:white; margin-left: 5px; font-size: 15px"><b>LEGENDA:</b>&nbsp</p>
									<p style="background-color: #D4EF99">&nbspDISPONIBILE&nbsp</p>
									<p style="background-color: red">&nbspPRENOTATO&nbsp</p>
									<p style="background-color: rgb(240,130,0)">ALLENAMENTO</p>
									<p style="background-color: rgb(255,200,0)">ALLENAMENTO EXTRA</p>
									<p style="background-color: rgb(170,0,0)">&nbsp&nbsp&nbsp&nbspPARTITA&nbsp&nbsp&nbsp&nbsp</p>
									<p style="background-color: grey">&nbsp&nbspDATA PASSATA&nbsp&nbsp</p>
									<p style="background-color: rgb(35,35,35); color: white;">&nbsp&nbsp&nbspINAGIBILITÁ&nbsp&nbsp&nbsp</p>
									
							</div>
							
						</div>
					<%} %>
				
				</div>
				<!-- CHIUDE PARTE DESTRA -->

			</div>
			<!-- CHIUDE CONTAINER CONTENUTI-->

		</div>
		<!-- CHIUDE CONTAINER PRINCIPALE -->

	</div>
	<!-- CHIUDE DIV SUPREMO -->


	
	<!-- PRENOTA CAMPI -->
	<div class="logreg" id="prenotaCampo" style="display:none">
  		<form method="Post" action="">
    
    		 <script>
			    var nomeSoc = "<%=utente.getNome()%>";
			    var emailSoc = "<%=utente.getEmail()%>";
			    var telSoc = "<%=utente.getTelefono()%>";
			    var idSoc = "<%=utente.getIdsocieta()%>";
			</script>
			
    		<input style="display:none" type="text" id="nomePren" name="nomePren" value="<%utente.getNome(); %>">
    		<input style="display:none" type="text" id="telefonoPren" name="telefonoPren" maxlength="15" value="<%utente.getTelefono() ; %>">
    		<input style="display:none" type="text" id="codSocPren" name="codSocPren" value="<%utente.getIdsocieta();%>">
    		<input style="display:none" type="email" id="emailPren" name="emailPren" value="<%utente.getEmail(); %>">
    		
    		<label for="tipoPren" style="color:#D4EF99; margin-bottom: 10px;"><b>TIPO DI PRENOTAZIONE:</b></label><br>
    		<div style="text-align: left;">
	    		<input type="radio" id="allenamentoStaordinarioPren" onclick="noSelect()"
	    			name="tipoPren" value="allenamentoEXTRA" style="margin-bottom: 5px;">
	    				<label for="allenamentoStaordinarioPren" style="margin-bottom: 5px;">Allenamento Straordinario</label><br>
	    		<input type="radio" id="inagibilitaPren" name="tipoPren"
	    			onclick="noSelect()" value="inagibilita">
	    			<label for="inagibilitaPren" style="margin-bottom: 5px;">Inagibilità dei campi</label><br>
	    		<input type="radio" id="partitaPren" name="tipoPren" onclick="noSelect()" value="partita">
	    			<label for="partitaPren" style="margin-bottom: 5px;">Partita di campionato o torneo</label><br>
	    		<input type="radio" id="allenamentiPren" name="tipoPren" value="allenamento" onclick="showSelect()">
	    			<label for="allenamentiPren" style="margin-bottom: 5px;">Allenamenti Settimanali</label>
    		</div>
    		
    		
    		<div id="giornoOraPren" style="display:none; flex-direction: column; align-items: center;">
    		
			    <label for="giornoPren">Giorno:</label>
			    <select id="giornoPren" name="giornoPren">
			        <option value="1">Lunedì</option>
			        <option value="2">Martedì</option>
			        <option value="3">Mercoledì</option>
			        <option value="4">Giovedì</option>
			        <option value="5">Venerdì</option>
			        <option value="6">Sabato</option>
			        <option value="0">Domenica</option>
			    </select>

    			
    			<label for="oraPren">Ora:</label>
    			<select id="oraPren" name="oraPren">
    				<option value="9">9:00</option>
    				<option value="10">10:00</option>
    				<option value="11">11:00</option>
    				<option value="12">12:00</option>
    				<option value="13">13:00</option>
    				<option value="14">14:00</option>
    				<option value="15">15:00</option>
    				<option value="16">16:00</option>
				    <option value="17">17:00</option>
				    <option value="18">18:00</option>
				    <option value="19">19:00</option>
				    <option value="20">20:00</option>
				    <option value="21">21:00</option>
				</select>
			</div>
    
    		<div id="erroreMessagePren"></div> <br>
    		
    		<button id="submitPrenota">Prenota</button>
  		</form>
	</div>
	<!-- FINE PRENOTA CAMPI -->
	
	<div class="logreg redirectPren" id="redirectPren" style="display:none; align-items: center; justify-content: center; flex-direction: column">
	</div>
	<!-- QUESTO DEVE ESSERE FATTO PER ALLENAMENTI E PARTITE -->
	

	<script src="/Sportify/js/script.js"></script>
	<script src="/Sportify/js/scriptLoginLogout.js"></script>
	<script src="/Sportify/js/scriptFiltro.js"></script>
	<script src="/Sportify/js/scriptCalendarioASD.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>

</html>