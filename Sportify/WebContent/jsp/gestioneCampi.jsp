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
<link rel="stylesheet" href="/Sportify/css/gestioneCampi.css">

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
							<input type="text" id="data_prenotazione" name="data_prenotazione" placeholder="&nbsp Ricerca campo per nome...">
						</form>
					</div>
					
					<div class="spazioFiltriCampi">
					
						<% List<String> FieldsType = (List<String>) request.getAttribute("MieTipologie");%>
						<h5><b>TIPOLOGIA CAMPO</b></h5>
						<form>
						<% for (String temp:FieldsType)
						{%>
							<input class="checkTipologia" onchange="" type="checkbox" id="tipologia<%=temp%>" name="<%=temp%>" value="<%=temp%>">
							<label for="tipologia<%=temp%>"><%=temp%></label><br>
						<%}%>
							<input class="checkTipologia" onchange="" type="checkbox" id="tipologiaNuova" name="NuovoCampo" value="Nuvo campo">
							<label for="tipologiaNuova">Nuovo campo</label><br>
						</form><br>	
						
						<p>- Rome was not built in a day</p>
					
					</div>
					
				</div>
				<!-- CHIUDE LA PARTE A SINISTRA -->
	
				<div class="col-md-9" id="risultatoRicercaCampi">
				
					<div class="risultatoCampi">
					
						<div class="headerRisultati">
								<div>
	
									<img src="/Sportify/img/CampoIgnoto.png" class="tipologiaCampoDaGioco">
	
								</div>
								
								<div>
									
									<h1 style="color:rgb(255,200,0); font-size: 50px; align-items: center"><b>INSERISCI NUOVO CAMPO</b></h1>
									
								</div>
								
						</div>
						
						<div class="minidivsGabrielperCalendario">
									
									<%int idsocietaeditante;
									ASD societaeditante = (ASD) session.getAttribute("Utente");
									idsocietaeditante = societaeditante.getIdsocieta();
									%>
									
									<form action="InserisciCampo" method="post">
											<input required type="text" class="editCampo" style="display:none" name="IdSocieta" value="<%=idsocietaeditante%>">
											<label class="labelPerEdit" for="editCampoNuovo">INSERISCI NOME:</label>
											<input required type="text" class="editCampo" id="editCampoNuovo" name="NomeNuovoCampo" placeholder="Nome nuovo campo...">
											<label class="labelPerEdit" for="editPrezzoNuovo">INSERISCI PREZZO:</label>
											<input required type="number" class="editPrezzoCampo" id="editPrezzoNuovo" name="PrezzoNuovoCampo" placeholder="0">
											<label class="labelPerEdit" for="editTipoNuovoCampo">DEFINISCI TIPO DI CAMPO:</label>
											<select required id="editTipoNuovoCampo" class="editCampoSelect" name="tipologiaCampoInEdit">
											<% List<String> tipologie = (List<String>)request.getAttribute("AllTipologie"); %>
												<%for (String tipo:tipologie)
												{%>
													<option value="<%=tipo%>"><%=tipo%></option>
												<%}%>
											</select>
											<button type="submit" class="bottoneInserisciCampo">INSERISCI NUOVO CAMPO</button>
										</form>
									
						</div>
					
					</div>
				
					<% List<Campo> ElencoCampi = (List<Campo>) request.getAttribute("MieiCampi");%>
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
									
									<h1 style="color:#D4EF99; font-size: 50px; align-items: center"><b><%=temp.getNome().toUpperCase()%></b></h1>
									
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
							
									<form action="AggiornaCampo" method="post">
											<input required type="text" class="editCampo" style="display:none" name="IdCampo" value="<%=temp.getIdcampo()%>">
											<input required type="text" class="editCampo" style="display:none" name="IdSocieta" value="<%=temp.getCodiceSoc()%>">
											<label class="labelPerEdit" for="editCampo<%=temp.getNome()%>">MODIFICA NOME:</label>
											<input required type="text" class="editCampo" id="editCampo<%=temp.getNome()%>" name="NomeCampo" value="<%=temp.getNome()%>">
											<label class="labelPerEdit" for="editPrezzo<%=temp.getNome()%>">MODIFICA PREZZO:</label>
											<input required type="number" class="editPrezzoCampo" id="editPrezzo<%=temp.getNome()%>" name="PrezzoCampo" value="<%=temp.getPrezzOrari()%>">
											<label class="labelPerEdit" for="editTipo<%=temp.getNome()%>">MODIFICA TIPO DI CAMPO:</label>
											<select required id="editTipo<%=temp.getNome()%>" class="editCampoSelect" name="tipologiaCampoInEdit">
												<%for (String tipo:FieldsType)
												{%>
													<option value="<%=tipo%>"><%=tipo%></option>
												<%}%>
											</select>
											<br>
											<button type="submit" class="bottoneAggiornaCampo">AGGIORNA DATI</button>
											<div class="bottoneCancellaCampo"">
												<a class="linkCancella" href="/Sportify/Delete?id=<%=temp.getIdcampo()%>&codSoc=<%=temp.getCodiceSoc()%>">
												&nbsp&nbspELIMINA&nbsp&nbsp</a>
											</div>
											
											
										</form>
	
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

	<script src="/Sportify/js/script.js"></script>
	<script src="/Sportify/js/scriptLoginLogout.js"></script>
	<script src="/Sportify/js/scriptFiltroCampi.js"></script>
	<script src="/Sportify/js/scriptProva.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>

</html>