-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: lms
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `addbooks`
--

DROP TABLE IF EXISTS `addbooks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addbooks` (
  `BookID` decimal(20,0) DEFAULT NULL,
  `Name` varchar(250) DEFAULT NULL,
  `Author` varchar(250) DEFAULT NULL,
  `ReleaseDate` varchar(50) DEFAULT NULL,
  `Type` varchar(250) DEFAULT NULL,
  `Regulations` decimal(10,0) DEFAULT NULL,
  `Publications` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addbooks`
--

LOCK TABLES `addbooks` WRITE;
/*!40000 ALTER TABLE `addbooks` DISABLE KEYS */;
INSERT INTO `addbooks` VALUES (101,'MOBILE COMPUTING','RAJESHWARI','Sat Mar 14 23:16:31 IST 2020','University Books',2017,'TECHNICAL '),(102,'ARTIFICIAL INTELLIGENCE','DEEPAK SHAH','Wed Mar 08 23:16:31 IST 2017','University Books',2017,'LAKSHMI '),(103,'COMPILER DESIGN','RAJENDRA PRASAD','Thu Mar 15 23:16:31 IST 2018','University Books',2017,'TECHNICAL'),(104,'SOFTWARE TESTING','RAJESH','Thu Mar 15 23:16:31 IST 2018','University Books',2017,'RAJESH'),(105,'COMPUTER NETWORKS','DEVI','Thu Mar 01 23:16:31 IST 2018','University Books',2017,'TECHNICAL'),(8211,'Circuit Theory','Dr.Radhakrishnan','Wed Mar 11 16:42:14 IST 2020','University Books',2017,'SR Publications'),(1,'Mystery of Magic','Harry Potter','Wed Jan 01 00:00:00 IST 2020','Magazines',2020,'Howards Publications');
/*!40000 ALTER TABLE `addbooks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blacklist`
--

DROP TABLE IF EXISTS `blacklist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blacklist` (
  `LMSNo` decimal(20,0) DEFAULT NULL,
  `Student_Name` varchar(55) DEFAULT NULL,
  `RegNo` decimal(20,0) DEFAULT NULL,
  `Department` varchar(55) DEFAULT NULL,
  `BookID` decimal(20,0) DEFAULT NULL,
  `BookName` varchar(55) DEFAULT NULL,
  `Author` varchar(55) DEFAULT NULL,
  `Type` varchar(55) DEFAULT NULL,
  `Regulations` decimal(20,0) DEFAULT NULL,
  `Publications` varchar(55) DEFAULT NULL,
  `IssueDate` date DEFAULT NULL,
  `ReturnDate` date DEFAULT NULL,
  `Student_MobNo` decimal(20,0) DEFAULT NULL,
  `ActualReturnDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blacklist`
--

LOCK TABLES `blacklist` WRITE;
/*!40000 ALTER TABLE `blacklist` DISABLE KEYS */;
INSERT INTO `blacklist` VALUES (17302,'T.RAJKUMAR',952617104302,'CSE',8211,'Circuit Theory','Dr.Radhakrishnan','University Books',2017,'SR Publications','2020-03-01','2020-03-11',8105988333,NULL),(17303,'S.NITYA',952617104303,'CSE',101,'MOBILE COMPUTING','RAJESHWARI','University Books',2017,'TECHNICAL ','2020-02-01','2020-03-01',9148266333,NULL),(17018,'SILFA',952617104018,'CSE',102,'ARTIFICIAL INTELLIGENCE','DEEPAK SHAH','University Books',2017,'LAKSHMI ','2020-02-01','2020-03-01',7395875268,NULL);
/*!40000 ALTER TABLE `blacklist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fine`
--

DROP TABLE IF EXISTS `fine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fine` (
  `LMSNo` decimal(20,0) DEFAULT NULL,
  `BookID` decimal(20,0) DEFAULT NULL,
  `FineAmount` decimal(20,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fine`
--

LOCK TABLES `fine` WRITE;
/*!40000 ALTER TABLE `fine` DISABLE KEYS */;
/*!40000 ALTER TABLE `fine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `finedetails`
--

DROP TABLE IF EXISTS `finedetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `finedetails` (
  `LMSNo` decimal(20,0) DEFAULT NULL,
  `BookID` decimal(20,0) DEFAULT NULL,
  `IssueDate` date DEFAULT NULL,
  `ReturnDate` date DEFAULT NULL,
  `ActualReturnDate` date DEFAULT NULL,
  `FineAmount` decimal(20,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `finedetails`
--

LOCK TABLES `finedetails` WRITE;
/*!40000 ALTER TABLE `finedetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `finedetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `greylist`
--

DROP TABLE IF EXISTS `greylist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `greylist` (
  `LMSNo` decimal(10,0) DEFAULT NULL,
  `Student_Name` varchar(20) DEFAULT NULL,
  `BookID` decimal(10,0) DEFAULT NULL,
  `BookName` varchar(20) DEFAULT NULL,
  `ReturnDate` varchar(50) DEFAULT NULL,
  `Student_MobNo` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `greylist`
--

LOCK TABLES `greylist` WRITE;
/*!40000 ALTER TABLE `greylist` DISABLE KEYS */;
INSERT INTO `greylist` VALUES (1,'SAIKUMAR',101,'Software Testing','13/03/2020',9987218730),(2,'SUBASH',102,'Compiler Design','10/03/2020',7977645323),(3,'SOMU',103,'Mobile Computing ','14/03/2020',485746464),(1,'SAIKUMAR',101,'Software Testing','13/03/2020',9987218730),(2,'SUBASH',102,'Compiler Design','10/03/2020',7977645323),(3,'SOMU',103,'Mobile Computing ','14/03/2020',485746464);
/*!40000 ALTER TABLE `greylist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issuebooks`
--

DROP TABLE IF EXISTS `issuebooks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `issuebooks` (
  `LMSNo` decimal(20,0) DEFAULT NULL,
  `Student_Name` varchar(250) DEFAULT NULL,
  `RegNo` decimal(20,0) DEFAULT NULL,
  `Department` varchar(250) DEFAULT NULL,
  `BookID` decimal(20,0) DEFAULT NULL,
  `BookName` varchar(250) DEFAULT NULL,
  `Author` varchar(250) DEFAULT NULL,
  `Type` varchar(250) DEFAULT NULL,
  `Regulations` varchar(250) DEFAULT NULL,
  `Publications` varchar(20) DEFAULT NULL,
  `IssueDate` date DEFAULT NULL,
  `ReturnDate` date DEFAULT NULL,
  `Student_MobNo` decimal(20,0) DEFAULT NULL,
  `ActualReturnDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issuebooks`
--

LOCK TABLES `issuebooks` WRITE;
/*!40000 ALTER TABLE `issuebooks` DISABLE KEYS */;
INSERT INTO `issuebooks` VALUES (17019,'C.SUBASH',952617104019,'CSE',104,'SOFTWARE TESTING','RAJESH','University Books','2017','RAJESH','2020-03-01','2020-03-18',9999999999,NULL);
/*!40000 ALTER TABLE `issuebooks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `returnbooks`
--

DROP TABLE IF EXISTS `returnbooks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `returnbooks` (
  `LMSNo` decimal(20,0) DEFAULT NULL,
  `Student_Name` varchar(250) DEFAULT NULL,
  `RegNo` decimal(20,0) DEFAULT NULL,
  `Department` varchar(250) DEFAULT NULL,
  `BookID` decimal(20,0) DEFAULT NULL,
  `BookName` varchar(250) DEFAULT NULL,
  `Author` varchar(250) DEFAULT NULL,
  `Type` varchar(250) DEFAULT NULL,
  `Regulations` varchar(250) DEFAULT NULL,
  `Publications` varchar(250) DEFAULT NULL,
  `IssueDate` varchar(50) DEFAULT NULL,
  `ReturnDate` varchar(50) DEFAULT NULL,
  `Student_MobNo` decimal(20,0) DEFAULT NULL,
  `ActualReturnDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `returnbooks`
--

LOCK TABLES `returnbooks` WRITE;
/*!40000 ALTER TABLE `returnbooks` DISABLE KEYS */;
INSERT INTO `returnbooks` VALUES (19,'SUBASH',952617104019,'CSE',104,'SOFTWARE TESTING','RAJESH','University Books','2017','RAJESH','2020-02-12','2020-03-05',7010190225,'2020-03-18'),(15,'BASARIYA',952617104015,'CSE',102,'ARTIFICIAL INTELLIGENCE','DEEPAK SHAH','University Books','2017','LAKSHMI ','2020-03-15','2020-03-30',6379642339,'2020-03-16'),(15,'BASARIYA',952617104015,'CSE',102,'ARTIFICIAL INTELLIGENCE','DEEPAK SHAH','University Books','2017','LAKSHMI ','2020-03-04','2020-03-11',6379642339,'2020-03-16'),(301,'SAIKUMAR',952617104301,'CSE',101,'MOBILE COMPUTING','RAJESHWARI','University Books','2017','TECHNICAL ','2020-03-01','2020-03-10',9987218730,'2020-03-18'),(19,'SUBASH',952617104019,'CSE',101,'MOBILE COMPUTING','RAJESHWARI','University Books','2017','TECHNICAL ','2020-03-01','2020-03-13',7010190225,'2020-03-18'),(5009,'K.MANOKARAN',952617105009,'EEE',8211,'Circuit Theory','Dr.Radhakrishnan','University Books','2017','SR Publications','2020-03-01','2020-03-13',7358821508,'2020-03-16'),(303,'SUBASH',952617104019,'CSE',104,'SOFTWARE TESTING','RAJESH','University Books','2017','RAJESH','2020-03-01','2020-03-10',8903059622,'2020-03-18'),(12,'Revathi',952617104012,'Mech',101,'MOBILE COMPUTING','RAJESHWARI','University Books','2017','TECHNICAL ','2020-03-01','2020-03-17',8754212915,'2020-03-18'),(15,'BASARIYA',952617104015,'CSE',103,'COMPILER DESIGN','RAJENDRA PRASAD','University Books','2017','TECHNICAL','2020-03-04','2020-03-15',6379642339,'2020-03-18'),(301,'SAIKUMAR',952617104301,'CSE',104,'SOFTWARE TESTING','RAJESH','University Books','2017','RAJESH','2020-03-15','2020-03-30',9987218730,'2020-03-18'),(17022,'S.NAGARAJAN',952617104022,'CSE',103,'COMPILER DESIGN','RAJENDRA PRASAD','University Books','2017','TECHNICAL','2020-03-01','2020-03-25',7777777777,'2020-03-18');
/*!40000 ALTER TABLE `returnbooks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rough`
--

DROP TABLE IF EXISTS `rough`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rough` (
  `SrNo` decimal(10,0) DEFAULT NULL,
  `IssueDate` date DEFAULT NULL,
  `ReturnDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rough`
--

LOCK TABLES `rough` WRITE;
/*!40000 ALTER TABLE `rough` DISABLE KEYS */;
INSERT INTO `rough` VALUES (1,'2020-03-03','2020-03-18'),(2,'2020-03-21','2020-03-03'),(11,'2020-05-03','2020-05-20');
/*!40000 ALTER TABLE `rough` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sregister`
--

DROP TABLE IF EXISTS `sregister`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sregister` (
  `LMSNo` decimal(20,0) DEFAULT NULL,
  `Name` varchar(250) DEFAULT NULL,
  `RegNo` decimal(50,0) DEFAULT NULL,
  `Department` varchar(250) DEFAULT NULL,
  `ContactNo` decimal(50,0) DEFAULT NULL,
  `Place` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sregister`
--

LOCK TABLES `sregister` WRITE;
/*!40000 ALTER TABLE `sregister` DISABLE KEYS */;
INSERT INTO `sregister` VALUES (17019,'C.SUBASH',952617104019,'CSE',9999999999,'IDAIKAL'),(17015,'S.R BASARIYA',952617104015,'CSE',8888888888,'KADYANALLUR'),(17022,'S.NAGARAJAN',952617104022,'CSE',7777777777,'TENKASI'),(17301,'M.SAIKUMAR',952617104301,'CSE',9987218730,'TENKASI'),(17302,'T.RAJKUMAR',952617104302,'CSE',8105988333,'BANGALORE'),(17303,'S.NITYA',952617104303,'CSE',9148266333,'BANGALORE'),(17018,'SILFA',952617104018,'CSE',7395875268,'TENKASI');
/*!40000 ALTER TABLE `sregister` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-18 19:22:27
