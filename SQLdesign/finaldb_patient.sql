-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: finaldb
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `Patient_id` int NOT NULL AUTO_INCREMENT,
  `Patient_name` varchar(255) NOT NULL,
  `address` varchar(30) NOT NULL,
  `Phone_number` int NOT NULL,
  `Nurse_id` int NOT NULL,
  `Room_no` int NOT NULL,
  PRIMARY KEY (`Patient_id`),
  KEY `FKPatient789131` (`Room_no`),
  KEY `FKPatient869526` (`Nurse_id`),
  CONSTRAINT `FKPatient789131` FOREIGN KEY (`Room_no`) REFERENCES `room` (`Room_no`),
  CONSTRAINT `FKPatient869526` FOREIGN KEY (`Nurse_id`) REFERENCES `nurse` (`Nurse_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10531 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (10500,'Ryan','asfsf',15994191,1,222),(10501,'Jason','asfsf',19561296,2,210),(10502,'Ronald','asfsf',65651651,3,225),(10503,'Joshua','asfsf',51651651,2,211),(10504,'Donna','asfsf',91616984,5,211),(10506,'Samuel','asfsf',65165166,8,215),(10507,'Catherine','asfsf',65165854,9,216),(10508,'Alexander the Grate','asfsf',65416516,10,213),(10509,'Cheryl','asfsf',65165165,10,214),(10510,'Amanda','asfsf',65686321,10,218),(10511,'Raymond','asfsf',63564565,8,219),(10512,'Jesse','asfsf',65465465,9,220),(10513,'Batman','asfsf',32103519,7,219),(10514,'Carol','asfsf',6549846,6,218),(10516,'Frances','asfsf',65160984,5,217),(10517,'Lawrence','asfsf',65165198,6,216),(10518,'Laura','asfsf',5651894,5,215),(10519,'Superman','asfsf',9654119,4,214),(10520,'Flash','asfsf',19818911,3,213),(10521,'Michelle','asfsf',9849849,2,212),(10522,'IronMan','asfsf',9841984,1,211),(10523,'Black Widow','asfsf',98419844,2,210),(10524,'Roy','asfsf',91819841,1,225),(10525,'Pamela','asfsf',98498498,7,224),(10526,'Candy','Ramallah',9848949,6,223),(10527,'Philip','asfsf',9844894,5,222),(10528,'Abigail','asfsf',98198498,10,221),(10529,'Alexis','asfsf',91898494,9,219),(10530,'Samantha','asfsf',98498498,9,220);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-10 20:55:20
