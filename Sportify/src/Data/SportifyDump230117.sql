CREATE DATABASE  IF NOT EXISTS `sportify` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sportify`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: sportify
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `asd`
--

DROP TABLE IF EXISTS `asd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asd` (
  `idsocieta` int NOT NULL AUTO_INCREMENT,
  `citta` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `indirizzo` varchar(45) DEFAULT NULL,
  `provincia` varchar(45) DEFAULT NULL,
  `regione` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `geolocalizzazione` varchar(600) DEFAULT NULL,
  PRIMARY KEY (`idsocieta`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asd`
--

LOCK TABLES `asd` WRITE;
/*!40000 ALTER TABLE `asd` DISABLE KEYS */;
INSERT INTO `asd` VALUES (1,'Milano','Gallaratese','Via Francesco de Lemene 3','Milano','Lombardia','gallaratese@calcio.it','1234wasd','3850049861','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3955.317422452979!2d9.132285040615729!3d45.49333233376257!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4786c1aeec7615bd%3A0x5981f970c58c6aef!2sCentro%20Pavesi%20FIPAV!5e0!3m2!1sit!2sit!4v1673269053369!5m2!1sit!2sit\" class=”geolocalizzazioneASD” allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>'),(2,'Milano','Masseroni','Via Enrico Terzaghi','Milano','Lombardia','info@masseroni.it','wasd1234','3958847205','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2797.138202995691!2d9.129426515820157!3d45.487161639931635!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4786c1bb4c1926ed%3A0x21c9949bac10d93d!2sMasseroni%20Marchese%202!5e0!3m2!1sit!2sit!4v1673269180590!5m2!1sit!2sit\" class=”geolocalizzazioneASD” allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>'),(3,'Gallarate','Scuola Milan','Via Monte Santo 34','Varese','Lombardia','scuolamilan7@figc.org','wasd1234','3395507483','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d89228.47042521708!2d8.669225716406237!3d45.663076499999995!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x478689bebc0cc323%3A0x646d176236ce620c!2sMilan%20Academy%20Scuola%20Calcio!5e0!3m2!1sit!2sit!4v1673269352521!5m2!1sit!2sit\" class=”geolocalizzazioneASD”  allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>'),(4,'Milano','Virtus Scuola Calcio','Piazzale Lotto 15','Milano','Lombardia','scuola@virtus.calcio.it','wasd1234','3385571029','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1663.38923001867!2d9.140126897920098!3d45.480356941464166!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4786c19ffeb5a5f9%3A0x2c0d70387e43b45!2sMilanosport%20-%20Centro%20Sportivo%20Lido!5e0!3m2!1sit!2sit!4v1673269485793!5m2!1sit!2sit\" class=”geolocalizzazioneASD”  allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>'),(5,'Milano','Lancieri','Via Giovanni Celoria 14-18','Milano','Lombardia','lancieri@lancieri.it','wasd1234','3447691627','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d4704.778690955864!2d9.225529152120352!3d45.480315340697146!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xf235c63bfcdb3c1!2sCENTRO%20SERVIZI%20e%20CAMPO%20SPORTIVO%20COPERTO%20-%20Accesso%20da%20Via%20Ponzio!5e0!3m2!1sit!2sit!4v1673269610897!5m2!1sit!2sit\" class=”geolocalizzazioneASD”  allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>'),(6,'Milano','Monzanese','Via Giulio Bechi 2','Milano','Lombardia','giuseppemarasco@monza.it','wasd1234','3362297520','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2796.2423539194747!2d9.220160315820602!3d45.50519973872735!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4786c71605623525%3A0x754614f5c66a434b!2sCampo%20Sportivo%20&#39;Cameroni&#39;%2C%20Via%20Giulio%20Bechi%2C%202%2C%2020126%20Milano%20MI!5e0!3m2!1sit!2sit!4v1673269698602!5m2!1sit!2sit\" class=”geolocalizzazioneASD” allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>'),(7,'Milano','Villapizzone','Via Perin del Vaga 11','Milano','Lombardia','rodorigo@villapizzone.it','wasd1234','3475590021','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2351.628875668831!2d9.133675316578586!3d45.498526842036014!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4786c1b2fd1c68b9%3A0x4b6c7002308cc357!2sCampo%20Sportivo%20Villapizzone!5e0!3m2!1sit!2sit!4v1673269866159!5m2!1sit!2sit\" class=”geolocalizzazioneASD” allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>'),(8,'Milano','Sacrocuore','Via Bartolini 46','Milano','Lombardia','donmatteo@sacrocuore.it','wasd1234','3326617321','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d699.2215488421581!2d9.152191784130997!3d45.49223642772201!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4786c1042ce4fd1f%3A0x842f1347918c4118!2sGruppo%20Scout%20Agesci%20Milano%2020!5e0!3m2!1sit!2sit!4v1673269962668!5m2!1sit!2sit\" class=”geolocalizzazioneASD” allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>'),(9,'Milano','CUS Pro Patria','Viale Sarca 205','Milano','Lombardia','calcio@cusmilano.it','wasd1234','3416620911','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2795.565557437176!2d9.2054288335232!3d45.518823470982205!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4786c74f2657b941%3A0x7d8664f3f7ceeda2!2sBicocca%20Stadium!5e0!3m2!1sit!2sit!4v1673270157600!5m2!1sit!2sit\" class=”geolocalizzazioneASD” allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>'),(10,'Monza','Monzanese Reale','Via Tognini 4','Monza Brianza','Lombardia','andreafuso@monza.it','wasd1234','3409931099','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d22340.318939897745!2d9.25847713589881!3d45.57969094988279!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4786b9e70fab9617%3A0x7323d454f66c0ae9!2sU-Power%20Stadium!5e0!3m2!1sit!2sit!4v1673270226353!5m2!1sit!2sit\" class=”geolocalizzazioneASD” allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>'),(11,'Settimo Milanese','Riccardi Accademy','Via di Vittorio 16','Milano','Lombardia','info@calcioriccardi.it','wasd1234','3987110900','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d699.3077500675683!2d9.055794921931382!3d45.485292829309714!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4786eb4f32bfaaf5%3A0xb81c0b6f6e1b7ed!2sRiccardi%20Academy!5e0!3m2!1sit!2sit!4v1673270313873!5m2!1sit!2sit\" class=”geolocalizzazioneASD” allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>'),(12,'Trezzano sul Naviglio','Real Trezzano Scuola Milan','Via Casaleggi 4','Milano','Lombardia','scuolamilan19@figc.org','wasd1234','3928711238','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1665.1535250071133!2d9.07143951440644!3d45.420565297330405!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4786e828a294156b%3A0x7f55c7a456fe81e3!2sReal%20Trezzano%20Scuola%20Calcio%20Milan!5e0!3m2!1sit!2sit!4v1673270470692!5m2!1sit!2sit\" class=”geolocalizzazioneASD” allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>'),(13,'Ancona','Ancona Calcio','Str. della Grotta 19','Ancona','Marche','anconacalcio@info.it','wasd1234','3221157165','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d5778.525245484715!2d13.474443153773805!3d43.601073187583395!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x132d7f6050aadd25%3A0x9647d4eab622e3d5!2sCUS%20Ancona%20-%20Centro%20Universitario%20Sportivo!5e0!3m2!1sit!2sit!4v1673270533804!5m2!1sit!2sit\" class=”geolocalizzazioneASD” allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>'),(14,'Torino','Juventus Accademy','Corso Moncalieri 346','Torino','Piemonte','sigrbuglione@juventus.it','wasd1234','3154401962','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2819.807361239062!2d7.670988333415519!3d45.02883590356194!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x478812bb3770f613%3A0xddbbab3bed10b6cf!2sScuola%20Calcio%20Sisport-Juventus!5e0!3m2!1sit!2sit!4v1673270661497!5m2!1sit!2sit\" class=”geolocalizzazioneASD” allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>'),(15,'Baranzate','Heroes Milano','Via Merano 6','Milano','Lombardia','logroniogodyl@gmail.com','wasd1234','3475507951','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d960.173513931296!2d9.118242348180742!3d45.52297587219196!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4786c018f71dedcf%3A0x73dcc790bfc1c03f!2sPALARIALDO!5e0!3m2!1sit!2sit!4v1673355286114!5m2!1sit!2sit\" class=”geolocalizzazioneASD” allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>'),(32,'Roma','Franchini Boyz','vdafaddfa','Roma','Lazio','filippouxoricidi90@gmail.com','wasd1234','432424243',NULL);
/*!40000 ALTER TABLE `asd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `campi`
--

DROP TABLE IF EXISTS `campi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `campi` (
  `idcampo` int NOT NULL AUTO_INCREMENT,
  `codiceSoc` int NOT NULL,
  `prezzOrari` float DEFAULT NULL,
  `tipologia` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcampo`,`codiceSoc`),
  KEY `campi_FK_ASD` (`codiceSoc`),
  CONSTRAINT `campi_FK_ASD` FOREIGN KEY (`codiceSoc`) REFERENCES `asd` (`idsocieta`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campi`
--

LOCK TABLES `campi` WRITE;
/*!40000 ALTER TABLE `campi` DISABLE KEYS */;
INSERT INTO `campi` VALUES (1,1,60,'Calcio a 11','Centro Pavesi Campone Superone'),(2,1,30,'Calcio a 5','Centro Pavesi Indoor'),(3,2,60,'Calcio a 11','Marchese'),(4,3,20,'Calcio a 5','Monte Santo'),(5,4,20,'Calcio a 5','Centro Sportivo Lido'),(6,5,40,'Calcio a 11','Via Ponzio'),(7,6,35,'Calcio a 5','Cameroni'),(8,7,50,'Calcio a 11','Campo Sportivo Villapizzone'),(9,8,25,'Calcio a 5','Oratorio Sacrocuore'),(10,9,80,'Calcio a 11','Bicocca Stadium'),(11,10,500,'Calcio a 11','U-Power Stadium'),(12,11,20,'Calcio a 5','Campo Betulle'),(13,11,25,'Calcio a 5','Campo Ciliegi'),(14,12,45,'Calcio a 11','Scuola Calcio Trezzano'),(15,13,30,'Calcio a 5','Centro Sportivo Universitario'),(16,14,120,'Calcio a 11','SSD Country Campo Senior'),(17,14,75,'Calcio a 11','SSD Country Campo Juniores'),(18,15,25,'Calcio a 5','Heroes Field'),(19,1,95,'Calcio a 11','Indoor sintetico Palladini'),(20,1,45,'Calcio a 11','Indoor tappeto rosso Cesaroni');
/*!40000 ALTER TABLE `campi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prenotazione`
--

DROP TABLE IF EXISTS `prenotazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prenotazione` (
  `id_prenotazione` int NOT NULL AUTO_INCREMENT,
  `data_prenotazione` varchar(10) NOT NULL,
  `ora_prenotazione` int NOT NULL,
  `email_nonRegistrato` varchar(45) DEFAULT NULL,
  `codiceSoc` int DEFAULT NULL,
  `idcampo` int NOT NULL,
  `numeroTelefono` varchar(45) DEFAULT NULL,
  `tipologia` varchar(45) DEFAULT 'Normale',
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_prenotazione`,`data_prenotazione`,`ora_prenotazione`,`idcampo`),
  KEY `prenotazione_FK_ASD` (`codiceSoc`),
  KEY `prenotazione_FK_campi` (`idcampo`,`codiceSoc`),
  CONSTRAINT `prenotazione_FK_ASD` FOREIGN KEY (`codiceSoc`) REFERENCES `asd` (`idsocieta`) ON DELETE CASCADE,
  CONSTRAINT `prenotazione_FK_campi` FOREIGN KEY (`idcampo`, `codiceSoc`) REFERENCES `campi` (`idcampo`, `codiceSoc`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazione`
--

LOCK TABLES `prenotazione` WRITE;
/*!40000 ALTER TABLE `prenotazione` DISABLE KEYS */;
INSERT INTO `prenotazione` VALUES (1,'2023-01-11',14,'logroniogodyl@gmail.com',NULL,1,'42424324','Normale','godyl'),(2,'2023-01-11',18,'logroniogodyl@gmail.com',NULL,1,'41121','Normale','sdasda'),(3,'2023-01-11',17,'logroniogodyl@gmail.com',NULL,1,'432424','Normale','Antonio'),(4,'2023-01-11',12,'logroniogodyl@gmail.com',NULL,2,'123','Normale','Antony'),(5,'2023-01-20',12,'logroniogodyl@gmail.com',NULL,5,'123131','Normale','Luigi'),(6,'2023-01-11',15,'logroniogodyl@gmail.com',NULL,1,'313213','Normale','Susanna'),(7,'2023-01-12',15,'logroniogodyl@gmail.com',NULL,4,'43244242','Normale','JAMI70'),(8,'2023-01-09',14,NULL,NULL,1,'','',''),(9,'2023-01-18',10,'logroniogodyl@gmail.com',NULL,3,'123','Normale','Giulio'),(10,'2023-01-12',17,'prova@prova.it',NULL,1,'Mattei','Normale','Matteo'),(11,'2023-01-10',16,'logroniogodyl@gmail.com',NULL,1,'312313','Normale','Gigi'),(12,'2023-01-10',15,'sdassadsa@gmail.com',NULL,18,'1213123312','Normale','Giovanni'),(13,'2023-01-10',20,'jie95@hotmail.it',NULL,18,'321321213','Normale','Jie'),(14,'2023-01-10',18,'logroniogodyl@gmail.com',NULL,1,'13321','Normale','Godyl'),(15,'2023-01-10',16,'logroniogodyl@gmail.com',NULL,3,'31321','Normale','Luigi'),(16,'2023-01-11',17,'cliff0rd@live.it',NULL,2,'321231','Normale','Gigio'),(17,'2023-01-11',16,'cliff0rd@live.it',NULL,2,'21321','Normale','dsasda'),(18,'2023-01-12',18,'cliff0rd@live.it',NULL,1,'123132','Normale','Kay'),(19,'2023-01-11',20,'cliff0rd@live.it',NULL,2,'321321','Normale','Antonino'),(20,'2023-01-11',18,'cliff0rd@live.it',NULL,2,'32131','Normale','gigi'),(21,'2023-01-10',17,'cliff0rd@live.it',NULL,2,'3321','Normale','dsasda'),(22,'2023-01-10',17,'cliff0rd@live.it',NULL,1,'31321','Normale','ciao'),(23,'2023-01-10',19,'cliff0rd@live.it',NULL,1,'32321','Normale','dsads'),(24,'2023-01-10',18,'cliff0rd@live.it',NULL,2,'1231','Normale','sd'),(25,'2023-01-10',20,'cliff0rd@live.it',NULL,1,'3132','Normale','cac'),(26,'2023-01-10',15,'cliff0rd@live.it',NULL,1,'321132','Normale','dasdas'),(27,'2023-01-10',21,'cliff0rd@live.it',NULL,1,'3123','Normale','dasasdda'),(28,'2023-01-10',20,'cliff0rd@live.it',NULL,2,'21312','Normale','dasd'),(29,'2023-01-10',19,'cliff0rd@live.it',NULL,2,'31331','Normale','dasddas'),(30,'3',18,'gallaratese@calcio.it',NULL,1,'3850049861','allenamento','Gallaratese'),(31,'2023-01-28',18,'gallaratese@calcio.it',NULL,1,'3850049861','partita','Gallaratese'),(32,'2023-01-28',17,'gallaratese@calcio.it',NULL,1,'3850049861','allenamentoEXTRA','Gallaratese'),(33,'2023-01-11',19,'gallaratese@calcio.it',NULL,1,'3850049861','allenamentoEXTRA','Gallaratese'),(34,'2023-01-22',14,'cliff0rd@live.it',NULL,4,'3123123','Normale','Maicol'),(35,'2023-01-11',15,'cliff0rd@live.it',NULL,2,'312','Normale','dsa'),(36,'2023-01-15',16,'gallaratese@calcio.it',NULL,1,'3850049861','partita','Gallaratese'),(37,'5',19,'gallaratese@calcio.it',NULL,1,'3850049861','allenamento','Gallaratese'),(38,'2023-01-11',20,'cliff0rd@live.it',NULL,1,'323121213','Normale','Gianluigi'),(39,'2023-01-20',16,'cliff0rd@live.it',NULL,7,'321323231','Normale','Mathias'),(40,'2023-01-11',18,'cliff0rd@live.it',NULL,17,'321231','Normale','Yoyo'),(41,'2023-01-11',18,'cliff0rd@live.it',NULL,4,'321312','Normale','Kali'),(42,'2023-01-11',17,'logroniogodyl@gmail.com',NULL,3,'32311','Normale','Timbro'),(43,'2023-01-11',20,'damu.fitness99@gmail.com',NULL,3,'4342342423','Normale','Dario'),(44,'2023-01-11',17,'gallaratese@calcio.it',NULL,19,'3850049861','allenamentoEXTRA','Gallaratese'),(45,'2023-01-11',17,'gallaratese@calcio.it',NULL,20,'3850049861','inagibilita','Gallaratese'),(46,'2023-01-11',13,'gallaratese@calcio.it',NULL,19,'3850049861','partita','Gallaratese'),(47,'1',17,'gallaratese@calcio.it',NULL,19,'3850049861','allenamento','Gallaratese');
/*!40000 ALTER TABLE `prenotazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utente` (
  `idutente` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  `indirizzo` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `codiceSoc` int DEFAULT NULL,
  `data_nascita` date DEFAULT NULL,
  PRIMARY KEY (`idutente`),
  KEY `Utente_FK_ASD` (`codiceSoc`),
  CONSTRAINT `Utente_FK_ASD` FOREIGN KEY (`codiceSoc`) REFERENCES `asd` (`idsocieta`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-17 14:41:45
