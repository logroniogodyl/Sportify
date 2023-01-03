<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>SPORTIFY</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <link href="/Sportify/css/style.css" rel="stylesheet">
  
</head>

<body>
  <div id="supremo">
  <video id="background-video" autoplay loop muted poster="/Sportify/img/BackgroundSportify.png">
    <source src="/Sportify/img/BackgroundSportify.mp4" type="video/mp4">
  </video>
  
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-12">
        <div class="row">
          <div class="col-md-2">
            <img src="/Sportify/img/Sportify Logo.png" id="logo">
          </div>
          <div class="col-md-7">
          </div>
          <div class="col-md-3" id="login">
          <%if(session.getAttribute("Utente")==null){ %>
            <button type="button" style="color:white" id="loginbottone">LOGIN</button>
          <%} else{ %>
            <a href="logout"><button type="button" style="color:blue" id="logoutbottone">LOGOUT</button></a>
          <%} %>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="container-principale">
    <div class="row">
      <div class="col-md-12">
        <ul class="col-md-6 nav">
          <li class="nav-item">
            <a class="nav-link active" href="#">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Profile</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Messages</a>
          </li>
          <li class="nav-item dropdown ml-md-auto">
            <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink"
              data-toggle="dropdown">Dropdown link</a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
              <a class="dropdown-item" href="#">Action</a> <a class="dropdown-item" href="#">Another action</a> <a
                class="dropdown-item" href="#">Something else here</a>
              <div class="dropdown-divider">
              </div> <a class="dropdown-item" href="#">Separated link</a>
            </div>
          </li>
        </ul>
        <div class="row">
          <div class="col-md-6">
            
            <!-- Carousel -->
            <div id="demo" class="carousel slide" data-bs-ride="carousel">
  
              <!-- Indicators/dots -->
              <div class="carousel-indicators">
                <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
                <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
                <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
              </div>
  
              <!-- The slideshow/carousel -->
              <div class="carousel-inner">
                <div class="carousel-item active">
                  <img
                    src="https://i0.wp.com/www.giacomocusano.com/wp-content/uploads/2016/07/coastal-wash-web.jpg?fit=1024%2C682&ssl=1"
                    alt="Los Angeles" class="d-block" style="width:100%">
                </div>
                <div class="carousel-item">
                  <img
                    src="https://www.venetoformazione.it/wp-content/uploads/2022/02/ottimizzare-immagini-display-retina.jpg"
                    alt="Chicago" class="d-block" style="width:100%">
                </div>
                <div class="carousel-item">
                  <img src="https://www.frasimania.it/wp-content/uploads/2020/11/immagini-mare.jpg" alt="New York"
                    class="d-block" style="width:100%">
                </div>
              </div>
  
              <!-- Left and right controls/icons -->
              <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
                <span class="carousel-control-prev-icon"></span>
              </button>
              <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
                <span class="carousel-control-next-icon"></span>
              </button>
            </div>
          </div>
          <div class="col-md-6">
            <div class="card">
              <h5 class="card-header">
                BACHECA
              </h5>
              <div class="card-body">
                <p class="card-text">
                  Card content
                </p>
              </div>
              <div class="card-footer">
                Card footer
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    </div>
  </div>


  <div class="logreg" id="registerform">
  <form action="/registrazione">
    <label for="fname">Nome:</label> <br>
    <input type="text" id="fname" name="nome" maxlength="40"><br>
    <label for="tel">Numero di telefono:</label><br>
    <input type="tel" id="tel" name="tel" maxlength="15"><br>
    <label for="email">Email</label><br>
    <input type="email" id="email" email="email" maxlength="30">
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
  
  <label for="province">Provincia:</label><br>
  <select id="province">
    <option value="">Seleziona prima una regione</option>
  </select><br>

    <label for="citta">Inserisci città:</label><br>
    <input type="text" id="citta" name="citta" maxlength="40"><br>

    <label for="indirizzo">Inserisci indirizzo:</label><br>
    <input type="text" id="indirizzo" name="indirizzo" maxlength="40">
    <br>

    <label for="password">Password</label><br>
    <input type="password" id="password" name="password" maxlength="12"><br>
    <label for="repassword">Reinserisci password</label><br>
    <input type="password" id="repassword" name="repassword" maxlength="12"><br>
    <br>
    
    <input type="submit" id="btnInvio" value="INVIO">
  </form>
  <br>
  <p>Hai già un account? <a href="javascript:showLoginForm()">Accedi</a></p> 
</div>

  <script src="/Sportify/js/script.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
    crossorigin="anonymous"></script>
</body>

</html>