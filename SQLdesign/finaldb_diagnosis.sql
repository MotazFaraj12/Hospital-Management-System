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
-- Table structure for table `diagnosis`
--

DROP TABLE IF EXISTS `diagnosis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diagnosis` (
  `Diagnosis_no` int NOT NULL AUTO_INCREMENT,
  `Diagnosis_Date` varchar(25) NOT NULL,
  `Details` varchar(50) NOT NULL,
  `Severity` varchar(30) NOT NULL,
  `Doctor_id` int NOT NULL,
  PRIMARY KEY (`Diagnosis_no`),
  KEY `FKDiagnosis352334` (`Doctor_id`),
  CONSTRAINT `FKDiagnosis352334` FOREIGN KEY (`Doctor_id`) REFERENCES `doctor` (`Doctor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=727 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagnosis`
--

LOCK TABLES `diagnosis` WRITE;
/*!40000 ALTER TABLE `diagnosis` DISABLE KEYS */;
INSERT INTO `diagnosis` VALUES (701,'20-5-2022','lost leg','mid',101),(702,'15-5-2022','lost arm','mid',101),(703,'17-5-2022','lost finger','hight',101),(704,'15-4-2022','Diarrhea','low',102),(705,'10-3-2022','eye inflammation','low',101),(706,'05-2-2022','infection in the arm','low',122),(707,'15-5-2022','lost leg','low',110),(708,'11-7-2021','lost leg','hight',110),(709,'28-6-2020','lost leg','low',110),(710,'15-5-2022','lost leg','mid',110),(711,'15-5-2022','lost leg','low',110),(712,'22-1-2022','lost leg','hight',111),(713,'12-1-2022','lost leg','low',115),(714,'9-5-2022','lost leg','low',117),(715,'1-6-2022','lost leg','hight',120),(716,'9-6-2022','lost leg','low',113),(717,'17-12-2019','lost leg','low',109),(718,'29-3-2022','lost leg','mid',107),(719,'13-6-2022','lost leg','low',105),(720,'21-11-2019','lost leg','mid',105),(721,'13-9-2019','lost leg','low',103),(722,'15-5-2022','lost leg','low',102),(723,'15-5-2022','lost leg','hight',101),(724,'15-5-2022','lost leg','low',119),(725,'15-5-2022','lost leg','hight',118),(726,'15-5-2022','lost leg','mid',117);
/*!40000 ALTER TABLE `diagnosis` ENABLE KEYS */;
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
