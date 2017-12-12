CREATE DATABASE  IF NOT EXISTS `chabed` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `chabed`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: chabed
-- ------------------------------------------------------
-- Server version	5.7.11-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `pid` varchar(15) NOT NULL,
  `pname` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `marital_status` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES ('501','Md. Chabed Alam','Male','28','Unmarried','01725212124'),('502','Rasidul Hasan','Male ','31','Married','01896325896'),('503','Salma Akter','Female','25','Unmarried','01859632589');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `report` (
  `rid` varchar(15) NOT NULL,
  `repeipt_no` varchar(45) DEFAULT NULL,
  `request_date` varchar(45) DEFAULT NULL,
  `order_no` varchar(45) DEFAULT NULL,
  `doctor` varchar(45) DEFAULT NULL,
  `procedure_no` varchar(45) DEFAULT NULL,
  `position_no` varchar(45) DEFAULT NULL,
  `indication` varchar(45) DEFAULT NULL,
  `diagonosis` varchar(45) DEFAULT NULL,
  `report` varchar(21000) DEFAULT NULL,
  `pid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
INSERT INTO `report` VALUES ('101','1522','08/05/2017','10005207','Dr. Hasan Mahmud','MRI of right Hand','p1',NULL,NULL,'1Sequences: Axial T1WI & T2WI and Sagittal T1WI & T2WI.Findings:	Lumbar lordotic curvature is straightened with normal vertebral alignment.	Disc desiccation is noted at all lumbar levels.	At L4-L5 level: Circumferential disc bulge is causing thecal sac indentation, mild spinal canal stenosis and bilateral neural foraminal narrowing.	At L5-S1 level: Central disc herniation causing anterior thecal sac indentation, spinal canal stenosis, bilateral lateral recess obliteration and bilateral traversing nerve root compression.	Other vertebrae and discs are unremarkable	No signal change is noted in the imaged part of the spinal cord suggesting any pathology.•	Degenerative disc diseases.','501'),('102','1523','08/12/2017','10005208','Dr. Hasan Mahmud Khan','MRI of left Hand','p2',NULL,NULL,'2Sequences: Axial T1WI & T2WI and Sagittal T1WI & T2WI.Findings:	Lumbar lordotic curvature is straightened with normal vertebral alignment.	Disc desiccation is noted at all lumbar levels.	At L4-L5 level: Circumferential disc bulge is causing thecal sac indentation, mild spinal canal stenosis and bilateral neural foraminal narrowing.	At L5-S1 level: Central disc herniation causing anterior thecal sac indentation, spinal canal stenosis, bilateral lateral recess obliteration and bilateral traversing nerve root compression.	Other vertebrae and discs are unremarkable	No signal change is noted in the imaged part of the spinal cord suggesting any pathology.•	Degenerative disc diseases.','502'),('103',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'503');
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `pic` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Rashid','25','Male','01725896325',NULL),(2,'Chabed','24','Male','01789652589',NULL),(3,'Salma','20','Female','1785000000',NULL),(4,'Kamal','45','Male','01825986932',NULL),(5,'Said','30','Male','01689523698',NULL),(6,'Farzana','29','Female','0155963258',NULL);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-12 14:54:38
