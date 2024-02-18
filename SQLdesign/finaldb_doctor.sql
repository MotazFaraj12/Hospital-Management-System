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
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `Doctor_id` int NOT NULL AUTO_INCREMENT,
  `Doctor_name` varchar(30) NOT NULL,
  `Address` varchar(30) NOT NULL,
  `Gender` varchar(30) NOT NULL,
  `Specialty` varchar(30) NOT NULL,
  `PhoneNumber` int NOT NULL,
  `Salary` int NOT NULL,
  PRIMARY KEY (`Doctor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (101,'James','albira','male','brain',447456,16000),(102,'Robert','alirsal','male','bones',437456,1700),(103,'Patricia','ramallah','Female','teeth',497456,1800),(104,'Jennifer','ramallah','Female','skin',497456,1900),(105,'William','ramallah','male','Pediatricians',497456,18800),(106,'Joseph','salfit','male','teeth',497456,14400),(107,'Charles','birzait','male','Pathologists',4974565,15500),(109,'Sarah','Bethlehem','Female','Infectious disease',4423492,15000),(110,'Linda','Halhul','Female','Ophthalmologists',4445278,6400),(111,'Sandra','Hebron','Female','gynecologists',2457552,12400),(112,'Daniel','Dura','male','Obstetrician',4543577,9800),(113,'Thomas','Ramleh','male','Cardiologists',4545224,6000),(114,'Joshua','Tulkarm','male','Endocrinologists',4545533,6354),(115,'Paul','Safad','male','Gastroenterologists',4596565,2200),(117,'Ashley','Naserah','Female','Hematologists',4959119,3500),(118,'Ronald','Haifa','male','Internists',4652951,5000),(119,'Edward','Yafa','male','Infectious Disease',4985291,8500),(120,'Jeffrey','Aka','male','Medical Geneticists',4291915,9000),(121,'Amanda','Jericho','Female','Neurologists',4952191,14000),(122,'Kimberly','Salfit','Female','Oncologists',4951951,10000);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
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
