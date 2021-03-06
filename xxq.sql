-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: 45.77.202.213    Database: xxq
-- ------------------------------------------------------
-- Server version	5.5.57-log

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
-- Table structure for table `Depart`
--

DROP TABLE IF EXISTS `Depart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Depart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `departname` varchar(20) DEFAULT NULL,
  `staffid` int(11) DEFAULT NULL,
  `describ` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Depart`
--

LOCK TABLES `Depart` WRITE;
/*!40000 ALTER TABLE `Depart` DISABLE KEYS */;
INSERT INTO `Depart` VALUES (1,'人事部',1,'1111111111'),(2,'财务部',19,'1111111111'),(3,'出纳部',21,'1111111111'),(4,'市场部',23,'111111111'),(5,'公关部',25,'111111'),(6,'销售部',27,'22222222'),(7,'后勤部',29,'33333333'),(8,'设计部',31,'444444');
/*!40000 ALTER TABLE `Depart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Office`
--

DROP TABLE IF EXISTS `Office`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Office` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `staff` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Office`
--

LOCK TABLES `Office` WRITE;
/*!40000 ALTER TABLE `Office` DISABLE KEYS */;
INSERT INTO `Office` VALUES (7,'2018-01-15',0,19),(8,'2018-01-15',0,21),(9,'2018-01-15',0,23),(10,'2018-01-15',0,25),(11,'2018-01-15',0,27),(12,'2018-01-15',0,29),(13,'2018-01-15',0,31),(14,'2018-02-15',0,33),(15,'2017-02-15',0,37),(16,'2018-02-15',0,39),(17,'2018-03-15',0,41),(18,'2018-03-15',0,43),(19,'2018-03-15',0,45),(20,'2018-04-15',0,47),(21,'2018-04-15',0,49),(22,'2018-05-15',0,51),(23,'2018-05-15',0,53),(24,'2018-05-15',0,55),(25,'2018-06-15',0,57),(26,'2018-06-15',0,59),(27,'2018-06-15',0,61),(28,'2018-06-15',0,63),(29,'2018-06-15',0,65),(30,'2018-02-15',0,67),(31,'2018-02-15',0,69),(32,'2018-02-15',0,71),(33,'2018-02-15',0,73),(34,'2018-02-15',0,75),(35,'2018-03-15',0,77),(36,'2018-03-15',0,79),(37,'2018-03-15',0,81),(38,'2017-03-15',0,83),(39,'2018-02-15',0,85),(40,'2018-02-15',0,87),(41,'2018-04-15',0,89),(42,'2018-04-15',0,91),(43,'2018-04-15',0,93),(44,'2018-04-15',0,95),(45,'2018-06-16',0,97),(46,'2018-02-15',0,99),(47,'2018-02-15',0,101),(48,'2018-02-15',0,103),(49,'2018-01-15',0,105),(50,'2018-01-15',0,107),(51,'2018-01-15',0,109),(52,'2018-01-15',0,113),(53,'2018-02-15',0,115),(54,'2018-03-15',0,117),(55,'2018-04-15',0,119),(56,'2018-05-15',0,121),(57,'2018-06-15',0,123),(58,'2018-01-15',0,125),(59,'2018-02-15',0,127),(60,'2018-03-15',0,129),(61,'2018-01-15',2,115),(62,'2018-02-15',2,117),(63,'2018-03-15',2,119),(64,'2018-04-15',2,121),(65,'2018-05-15',2,123),(66,'2017-06-15',2,125),(67,'2018-01-15',2,127),(68,'2018-02-15',2,129),(69,'2018-03-15',1,105),(70,'2018-04-15',1,37),(71,'2018-05-15',1,45),(72,'2018-06-15',1,65),(73,'2018-01-15',1,73),(74,'2018-02-15',1,81),(75,'2018-03-15',1,87),(76,'2018-04-15',1,97),(77,'2018-07-16',0,131),(78,'2018-07-22',2,61),(79,'2018-07-22',2,61),(80,'2018-07-22',2,61);
/*!40000 ALTER TABLE `Office` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Performance`
--

DROP TABLE IF EXISTS `Performance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Performance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mouth` date DEFAULT NULL,
  `score` float DEFAULT NULL,
  `present` int(11) DEFAULT NULL,
  `staff` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=293 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Performance`
--

LOCK TABLES `Performance` WRITE;
/*!40000 ALTER TABLE `Performance` DISABLE KEYS */;
INSERT INTO `Performance` VALUES (14,'2018-01-15',90,26,1),(15,'2018-01-15',85,27,19),(16,'2018-01-15',90,30,21),(17,'2018-01-15',83,27,23),(18,'2018-01-15',90,25,25),(19,'2018-01-15',91,29,27),(20,'2018-01-15',82,30,29),(21,'2018-01-15',88,27,31),(22,'2018-01-15',90,26,37),(23,'2018-01-15',87,27,39),(24,'2018-01-15',90,28,41),(25,'2018-01-15',90,25,43),(26,'2018-01-15',86,26,45),(27,'2018-01-15',90,27,47),(28,'2018-01-15',90,28,49),(29,'2018-01-15',86,27,51),(30,'2018-01-15',84,27,53),(31,'2018-01-15',90,25,55),(32,'2018-01-15',82,30,57),(33,'2018-01-15',83,27,59),(34,'2018-01-15',90,27,61),(35,'2018-01-15',85,25,63),(36,'2018-01-15',87,27,65),(37,'2018-01-15',90,26,67),(38,'2018-01-15',85,27,69),(39,'2018-01-15',90,30,71),(40,'2018-01-15',82,27,73),(41,'2018-01-15',90,28,75),(42,'2018-01-15',83,26,77),(43,'2018-01-15',90,27,79),(44,'2018-01-15',90,20,81),(45,'2018-01-15',85,27,85),(46,'2018-01-15',87,23,87),(47,'2018-01-15',90,27,89),(48,'2018-01-15',90,25,91),(49,'2018-01-15',73,27,93),(50,'2018-01-15',88,28,95),(51,'2018-01-15',91,29,97),(52,'2018-01-15',90,27,99),(53,'2018-01-15',92,25,101),(54,'2018-01-15',90,22,103),(55,'2018-01-15',81,27,105),(56,'2018-01-15',90,29,107),(57,'2018-01-15',90,25,109),(58,'2018-01-15',83,27,113),(59,'2018-01-15',87,28,83),(60,'2018-02-15',90,27,1),(61,'2018-02-15',89,26,19),(62,'2018-02-15',85,26,21),(63,'2018-02-15',91,25,23),(64,'2018-02-15',82,26,25),(65,'2018-02-15',84,26,27),(66,'2018-02-15',89,24,29),(67,'2018-02-15',83,26,31),(68,'2018-02-15',89,23,37),(69,'2018-02-15',82,26,39),(70,'2018-02-15',81,26,41),(71,'2018-02-15',89,26,43),(72,'2018-02-15',83,26,45),(73,'2018-02-15',91,26,47),(74,'2018-02-15',89,22,49),(75,'2018-02-15',82,26,51),(76,'2018-02-15',89,28,53),(77,'2018-02-15',83,26,55),(78,'2018-02-15',89,26,57),(79,'2018-02-15',81,26,59),(80,'2018-02-15',89,26,61),(81,'2018-02-15',86,24,63),(82,'2018-02-15',89,26,65),(83,'2018-02-15',89,23,67),(84,'2018-02-15',85,26,69),(85,'2018-02-15',89,26,71),(86,'2018-02-15',84,23,73),(87,'2018-02-15',89,25,75),(88,'2018-02-15',82,25,77),(89,'2018-02-15',89,26,79),(90,'2018-02-15',80,26,81),(91,'2018-02-15',89,26,83),(92,'2018-02-15',83,28,85),(93,'2018-02-15',89,24,87),(94,'2018-02-15',81,24,89),(95,'2018-02-15',89,25,91),(96,'2018-02-15',85,26,93),(97,'2018-02-15',86,26,95),(98,'2018-02-15',89,26,97),(99,'2018-02-15',82,27,99),(100,'2018-02-15',89,26,101),(101,'2018-02-15',84,26,103),(102,'2018-02-15',89,23,105),(103,'2018-02-15',83,23,107),(104,'2018-02-15',82,26,109),(105,'2018-02-15',89,26,113),(106,'2018-03-15',90,27,1),(107,'2018-03-15',83,28,19),(108,'2018-03-15',91,26,21),(109,'2018-03-15',82,29,23),(110,'2018-03-15',89,26,25),(111,'2018-03-15',83,26,27),(112,'2018-03-15',89,30,29),(113,'2018-03-15',89,26,31),(114,'2018-03-15',89,30,37),(115,'2018-03-15',85,30,39),(116,'2018-03-15',89,26,41),(117,'2018-03-15',86,28,43),(118,'2018-03-15',89,28,45),(119,'2018-03-15',89,26,47),(120,'2018-03-15',81,26,49),(121,'2018-03-15',89,26,51),(122,'2018-03-15',83,28,53),(123,'2018-03-15',91,26,55),(124,'2018-03-15',89,28,57),(125,'2018-03-15',89,26,59),(126,'2018-03-15',82,26,61),(127,'2018-03-15',89,27,63),(128,'2018-03-15',89,26,65),(129,'2018-03-15',83,27,67),(130,'2018-03-15',89,26,69),(131,'2018-03-15',86,27,71),(132,'2018-03-15',89,26,73),(133,'2018-03-15',91,25,75),(134,'2018-03-15',89,25,77),(135,'2018-03-15',89,26,79),(136,'2018-03-15',86,26,81),(137,'2018-03-15',72,27,83),(138,'2018-03-15',89,27,85),(139,'2018-03-15',92,26,87),(140,'2018-03-15',89,27,89),(141,'2018-03-15',94,26,91),(142,'2018-03-15',89,25,93),(143,'2018-03-15',89,25,95),(144,'2018-03-15',85,26,97),(145,'2018-03-15',89,27,99),(146,'2018-03-15',86,26,101),(147,'2018-03-15',81,27,103),(148,'2018-03-15',89,26,105),(149,'2018-03-15',82,27,107),(150,'2018-03-15',89,26,109),(151,'2018-03-15',89,22,113),(152,'2018-04-15',89,27,1),(153,'2018-04-15',86,28,19),(154,'2018-04-15',84,27,21),(155,'2018-04-15',81,29,23),(156,'2018-04-15',83,26,25),(157,'2018-04-15',91,26,27),(158,'2018-04-15',82,28,29),(159,'2018-04-15',82,26,31),(160,'2018-04-15',89,30,37),(161,'2018-04-15',85,30,39),(162,'2018-04-15',89,26,41),(163,'2018-04-15',86,28,43),(164,'2018-04-15',89,28,45),(165,'2018-04-15',89,26,47),(166,'2018-04-15',81,25,49),(167,'2018-04-15',89,26,51),(168,'2018-04-15',83,28,53),(169,'2018-04-15',91,25,55),(170,'2018-04-15',89,28,57),(171,'2018-04-15',89,29,59),(172,'2018-04-15',82,26,61),(173,'2018-04-15',89,27,63),(174,'2018-04-15',89,30,65),(175,'2018-04-15',83,27,67),(176,'2018-04-15',89,26,69),(177,'2018-04-15',86,28,71),(178,'2018-04-15',89,26,73),(179,'2018-04-15',91,25,75),(180,'2018-04-15',89,25,77),(181,'2018-04-15',89,26,79),(182,'2018-04-15',86,25,81),(183,'2018-04-15',72,27,83),(184,'2018-04-15',89,27,85),(185,'2018-04-15',92,25,87),(186,'2018-04-15',89,27,89),(187,'2018-04-15',94,26,91),(188,'2018-04-15',89,26,93),(189,'2018-04-15',89,25,95),(190,'2018-04-15',85,26,97),(191,'2018-04-15',89,27,99),(192,'2018-04-15',86,26,101),(193,'2018-04-15',81,27,103),(194,'2018-04-15',89,26,105),(195,'2018-04-15',82,27,107),(196,'2018-04-15',89,26,109),(197,'2018-04-15',89,22,113),(198,'2018-05-15',85,27,1),(199,'2018-05-15',89,28,19),(200,'2018-05-15',84,27,21),(201,'2018-05-15',82,29,23),(202,'2018-05-15',83,26,25),(203,'2018-05-15',82,26,27),(204,'2018-05-15',93,28,29),(205,'2018-05-15',81,26,31),(206,'2018-05-15',82,30,37),(207,'2018-05-15',85,30,39),(208,'2018-05-15',83,26,41),(209,'2018-05-15',86,28,43),(210,'2018-05-15',83,28,45),(211,'2018-05-15',89,26,47),(212,'2018-05-15',82,25,49),(213,'2018-05-15',89,26,51),(214,'2018-05-15',86,28,53),(215,'2018-05-15',82,25,55),(216,'2018-05-15',83,28,57),(217,'2018-05-15',89,29,59),(218,'2018-05-15',84,26,61),(219,'2018-05-15',89,27,63),(220,'2018-05-15',91,30,65),(221,'2018-05-15',83,27,67),(222,'2018-05-15',89,26,69),(223,'2018-05-15',82,28,71),(224,'2018-05-15',89,26,73),(225,'2018-05-15',82,25,75),(226,'2018-05-15',89,25,77),(227,'2018-05-15',83,26,79),(228,'2018-05-15',86,25,81),(229,'2018-05-15',79,27,83),(230,'2018-05-15',82,27,85),(231,'2018-05-15',92,25,87),(232,'2018-05-15',91,27,89),(233,'2018-05-15',82,26,91),(234,'2018-05-15',89,26,93),(235,'2018-05-15',89,25,95),(236,'2018-05-15',83,26,97),(237,'2018-05-15',89,27,99),(238,'2018-05-15',86,26,101),(239,'2018-05-15',80,27,103),(240,'2018-05-15',89,26,105),(241,'2018-05-15',81,27,107),(242,'2018-05-15',89,26,109),(243,'2018-05-15',86,22,113),(244,'2018-06-15',85,27,1),(245,'2018-06-15',89,28,19),(246,'2018-06-15',84,27,21),(247,'2018-06-15',82,29,23),(248,'2018-06-15',83,26,25),(249,'2018-06-15',82,26,27),(250,'2018-06-15',93,28,29),(251,'2018-06-15',81,26,31),(252,'2018-06-15',82,30,37),(253,'2018-06-15',85,30,39),(254,'2018-06-15',83,26,41),(255,'2018-06-15',86,28,43),(256,'2018-06-15',83,28,45),(257,'2018-06-15',89,26,47),(258,'2018-06-15',82,25,49),(259,'2018-06-15',89,26,51),(260,'2018-06-15',86,28,53),(261,'2018-06-15',82,25,55),(262,'2018-06-15',83,28,57),(263,'2018-06-15',89,29,59),(264,'2018-06-15',84,26,61),(265,'2018-06-15',89,27,63),(266,'2018-06-15',91,30,65),(267,'2018-06-15',83,27,67),(268,'2018-06-15',89,26,69),(269,'2018-06-15',82,28,71),(270,'2018-06-15',89,26,73),(271,'2018-06-15',82,25,75),(272,'2018-06-15',89,25,77),(273,'2018-06-15',83,26,79),(274,'2018-06-15',86,25,81),(275,'2018-06-15',79,27,83),(276,'2018-06-15',82,27,85),(277,'2018-06-15',92,25,87),(278,'2018-06-15',91,27,89),(279,'2018-06-15',82,26,91),(280,'2018-06-15',89,26,93),(281,'2018-06-15',89,25,95),(282,'2018-06-15',83,26,97),(283,'2018-06-15',89,27,99),(284,'2018-06-15',86,26,101),(285,'2018-06-15',80,27,103),(286,'2018-06-15',89,26,105),(287,'2018-06-15',81,27,107),(288,'2018-06-15',89,26,109),(289,'2018-06-15',86,22,113),(290,'2018-08-15',86,22,1),(291,'2018-08-15',86,22,19),(292,'2018-08-15',80,25,21);
/*!40000 ALTER TABLE `Performance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Record`
--

DROP TABLE IF EXISTS `Record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mark` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `staff` int(11) DEFAULT NULL,
  `src_station` int(11) DEFAULT NULL,
  `res_station` int(11) DEFAULT NULL,
  `src_depart` int(11) DEFAULT NULL,
  `res_depart` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Record`
--

LOCK TABLES `Record` WRITE;
/*!40000 ALTER TABLE `Record` DISABLE KEYS */;
INSERT INTO `Record` VALUES (6,1,'2018-05-15',37,2,2,1,2),(7,2,'2018-05-15',39,4,3,1,1),(8,3,'2018-05-15',41,4,3,1,2),(9,1,'2018-01-15',43,4,4,1,3),(10,2,'2018-01-15',45,6,7,2,2),(11,3,'2018-01-15',47,7,6,2,4),(12,1,'2018-02-15',49,8,8,2,5),(13,2,'2018-02-15',51,8,7,2,2),(14,3,'2018-02-15',53,4,2,1,6),(15,1,'2018-03-15',55,4,4,1,7),(16,2,'2018-03-15',57,4,3,1,1),(17,3,'2018-03-15',59,4,2,1,5),(18,1,'2018-04-15',61,4,4,1,2),(19,2,'2018-04-15',63,4,3,1,1),(20,3,'2018-04-15',65,10,11,3,4),(21,1,'2018-06-15',67,11,11,3,8),(22,2,'2018-06-15',69,12,11,3,3),(23,3,'2018-06-15',71,12,11,3,8);
/*!40000 ALTER TABLE `Record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Staff`
--

DROP TABLE IF EXISTS `Staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(10) NOT NULL,
  `staffName` varchar(20) DEFAULT NULL,
  `phonenum` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `idcard` varchar(20) DEFAULT NULL,
  `wages` int(11) DEFAULT NULL,
  `iswork` tinyint(1) DEFAULT NULL,
  `department` int(11) DEFAULT NULL,
  `station` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Staff`
--

LOCK TABLES `Staff` WRITE;
/*!40000 ALTER TABLE `Staff` DISABLE KEYS */;
INSERT INTO `Staff` VALUES (1,'1502010401','白振宇','17865423351',22,'371083199610101010',8000,1,1,1,0,'1111111','11111111'),(19,'1502010402','韦时斌','17865423351',21,'371083199710101010',8100,1,2,5,0,NULL,NULL),(21,'1502010403','孙相鹏','17865423351',21,'371083199710101011',8200,1,3,9,0,NULL,NULL),(23,'1502010404','黄会凌','17865423351',21,'371083199710101012',8300,1,4,13,0,NULL,NULL),(25,'1502010405','胡元杰','17865423351',22,'371083199611101010',8400,1,5,17,0,NULL,NULL),(27,'1502010406','时正非','17865423351',28,'37108319961110146',8000,1,6,21,0,NULL,NULL),(29,'1502010407','李天一','17865423351',26,'371083196625253636',8000,1,7,25,0,NULL,NULL),(31,'1502010408','孙子冰','17865423351',25,'371083196625253638',7200,1,8,29,0,NULL,NULL),(33,'123456789','admin','11',11,'371083199710101011',11,1,8,31,0,NULL,NULL),(37,'1502010409','韦为他','17865423351',22,'371083199710101011',5000,1,1,2,0,NULL,NULL),(39,'1502010410','吴天','17865423351',22,'371083199710101011',4000,1,1,3,0,NULL,NULL),(41,'1502010411','张子成','17865423351',22,'371083199710101011',3000,1,1,4,0,NULL,NULL),(43,'1502010412','张忠','17865423351',22,'371083199710101011',3000,1,1,4,0,NULL,NULL),(45,'1502010413','张凯','17865423351',22,'371083199710101011',7000,1,2,6,0,NULL,NULL),(47,'1502010414','上官雷鸣','17865423351',22,'371083196625253636',5000,1,2,7,0,NULL,NULL),(49,'1502010415','莫已成','17865423351',22,'371083199710101011',3000,1,2,8,0,NULL,NULL),(51,'1502010416','徐睿','17865423351',22,'371083199710101011',3000,1,2,8,0,NULL,NULL),(53,'1502010417','吴永波','17865423351',22,'371083199710101011',3000,1,1,4,0,NULL,NULL),(55,'1502010418','刘星','17865423351',22,'371083199710101011',3000,0,1,4,0,NULL,NULL),(57,'1502010419','胡汉三','17865423351',22,'371083199710101011',3000,1,1,4,0,NULL,NULL),(59,'1502010420','何霞','17865423351',22,'371083199710101011',3000,1,1,4,1,NULL,NULL),(61,'1502010421','油浩','17865423351',22,'371083199710101011',3000,0,1,4,1,NULL,NULL),(63,'1502010422','石原','17865423351',22,'371083199710101011',3000,1,1,4,1,NULL,NULL),(65,'1502010423','张一凡','17865423351',22,'371083199710101011',7000,1,3,10,1,NULL,NULL),(67,'1502010424','胡丽亚','17865423351',22,'371083199710101011',7000,1,3,11,1,NULL,NULL),(69,'1502010425','翁志山','17865423351',22,'371083199710101011',7000,1,3,12,0,NULL,NULL),(71,'1502010426','李时珍','17865423351',22,'371083199710101011',3000,1,3,12,0,NULL,NULL),(73,'1502010427','黄庆','17865423351',22,'371083199710101011',7000,1,4,14,0,NULL,NULL),(75,'1502010428','任由','17865423351',22,'371083199710101011',5000,1,4,15,0,NULL,NULL),(77,'1502010429','梁红','17865423351',22,'371083199710101011',3000,1,4,16,0,NULL,NULL),(79,'1502010430','马菲菲','17865423351',22,'371083199710101011',3000,1,4,16,1,NULL,NULL),(81,'1502010431','马德草','17865423351',22,'371083199710101011',7000,1,5,18,0,NULL,NULL),(83,'1502010432','张舞答','17865423351',22,'371083199710101011',5000,1,5,19,0,NULL,NULL),(85,'1502010433','李卫国','17865423351',28,'371083199710101011',3000,1,5,20,0,NULL,NULL),(87,'1502010434','石洞','17865423351',28,'371083199710101011',7000,1,6,22,0,NULL,NULL),(89,'1502010435','姚天成','17865423351',28,'371083199710101011',5000,1,6,23,0,NULL,NULL),(91,'1502010436','王浩','17865423351',28,'371083199710101011',3000,1,6,24,0,NULL,NULL),(93,'1502010437','苏陌瑾','17865423351',28,'371083199710101011',3000,1,6,24,0,NULL,NULL),(95,'1502010438','白一帆','17865423351',28,'371083199710101011',3000,1,6,24,0,NULL,NULL),(97,'1502010439','孙佩琪','17865423351',28,'371083199710101011',7000,1,7,26,0,NULL,NULL),(99,'1502010440','白决定','17865423351',28,'371083199710101011',5000,1,7,27,0,NULL,NULL),(101,'1502010441','黄击穿','17865423351',28,'371083199710101011',5000,1,7,28,0,NULL,NULL),(103,'1502010442','胡济川','17865423351',28,'371083199710101011',3000,1,7,28,0,NULL,NULL),(105,'1502010443','欧阳自强','17865423351',28,'371083199710101011',7000,1,8,30,0,NULL,NULL),(107,'1502010444','王帅','17865423351',28,'371083199710101011',5000,1,8,31,0,NULL,NULL),(109,'1502010445','李茂林','17865423351',28,'371083199710101011',3000,1,8,32,0,NULL,NULL),(113,'1502010446','韩金瑞','17865423351',28,'371083199710101011',3000,1,8,32,0,NULL,NULL),(115,'1502010447','崔新龙','17865423351',28,'371083199710101011',3000,0,1,4,0,NULL,NULL),(117,'1502010448','王卫东','17865423351',28,'371083199710101011',3000,0,2,8,0,NULL,NULL),(119,'1502010449','叶文祥','17865423351',28,'371083199710101011',3000,0,3,8,0,NULL,NULL),(121,'1502010450','林尘枪','17865423351',28,'371083199710101011',3000,0,4,8,0,NULL,NULL),(123,'1502010451','徐文明','17865423351',28,'371083199710101011',3000,0,5,8,0,NULL,NULL),(125,'1502010452','王永苏','17865423351',28,'371083199710101011',3000,0,6,8,0,NULL,NULL),(127,'1502010453','卢小兵','17865423351',28,'371083199710101011',3000,0,7,8,0,NULL,NULL),(129,'1502010454','吴尔肯','17865423351',28,'371083199710101011',3000,0,8,8,0,NULL,NULL),(131,'72872872','14525','2547275527',12,'428572572',728572,1,1,1,0,NULL,NULL);
/*!40000 ALTER TABLE `Staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Station`
--

DROP TABLE IF EXISTS `Station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Station` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stationname` varchar(20) DEFAULT NULL,
  `depart` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Station`
--

LOCK TABLES `Station` WRITE;
/*!40000 ALTER TABLE `Station` DISABLE KEYS */;
INSERT INTO `Station` VALUES (1,'经理',1),(2,'副经理',1),(3,'主管',1),(4,'职工',1),(5,'保安',1),(6,'副经理',2),(7,'主管',2),(8,'职工',2),(9,'经理',2),(10,'副经理',3),(11,'主管',3),(12,'职工',3),(13,'经理',3),(14,'副经理',4),(15,'主管',4),(16,'职工',4),(17,'经理',4),(18,'副经理',5),(19,'主管',5),(20,'职工',5),(21,'经理',5),(22,'副经理',6),(23,'主管',6),(24,'职工',6),(25,'经理',6),(26,'副经理',7),(27,'主管',7),(28,'职工',7),(29,'经理',7),(30,'副经理',8),(31,'主管',8),(32,'职工',8);
/*!40000 ALTER TABLE `Station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(10) DEFAULT NULL,
  `passWd` varchar(500) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  `staff` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (14,'1502010401','$2a$10$kAX4Shl6Dh/Ocb1ohTrdL.Ihl5xBaPWJ6xjtstCFUtYGAv47o.1m6',1,1),(27,'1502010402','$2a$10$UTjqXWmAPhl47eKwcYmnhuEQyFpcZEB9ehWpZWdTwCzTNG/4iKO4e',1,19),(28,'1502010403','$2a$10$hIX8G45nfVtovAwWrKimq.2D5Pm2mSo82lPwAFd3y0mbzX7P7II2W',1,21),(29,'1502010404','$2a$10$V/c/ERYikwDJgRf6YFakneQCwUs7ldjcgPoTG/ZqEH3TnIaPHxZ0G',1,23),(30,'1502010405','$2a$10$IdR3kt9HsZb.FEbo1keCzeeOwksp1Fz7u.yWiACvPTgDOCQv8Xlsi',1,25),(31,'1502010406','$2a$10$RveaUwgycX399JcWas/Vd.0Wdbwn7tSnKv5XCY1vO.dgAI1WwBPJO',1,27),(32,'1502010407','$2a$10$Y39lN.VUJJ3sxL.IVx8D5eziLSQUABN/g.brcesf4p2Gk.6Z5Y2FW',1,29),(33,'1502010408','$2a$10$6oVJHWkH0Z1y/xoHMxoCveamF3xSeiIZtk2k0DtFobWIhX.WSOeB6',1,31),(34,'123456789','$2a$10$VAPt2bKCt0mCrYiOubt/xekWstoaq8LdAuaz6K3taamJ8z2dqKT3m',0,33),(36,'1502010409','$2a$10$.bAGO8Pg2YOfAirDWyAVie/ASYz/QTwkEJedFnb.EjPvpK0fhIyDu',1,37),(37,'1502010410','$2a$10$0SrIP7Qh21rfWGyMAMun.eg4Cz/DxHY9VcwwiWXnP8beD2w3FZYDC',1,39),(38,'1502010411','$2a$10$VabNNepGjFQMJCrprFb.Q.uYdixSNzv.iQJJr/VVouhSfpZd2QErC',1,41),(39,'1502010412','$2a$10$o3fYTr4BGOl06DCtk4wFxewBF.Thclp4owbccibr9Un6ovxXgAy4C',1,43),(40,'1502010413','$2a$10$yZf3ipLK6gxu23Jhg3vSP.il/giNKnKURBgMxXq2TMdD18JH0zWxi',1,45),(41,'1502010414','$2a$10$mSxQfeB4gRL9nYSecpBoZuDObWKhMWPOxADmzz9mcA5kTsFrJgyym',1,47),(42,'1502010415','$2a$10$yf4LZKLlqgR/gvlKaSyc7OyWKeAwUH7dxxbS1NtdLSn7uHun1k6we',1,49),(43,'1502010416','$2a$10$W5FZcOrYtnP1k52js6mn/O8EgnO7J5WZ48zBMOt2NVvtOPSzO93Ki',1,51),(44,'1502010417','$2a$10$a244RM2aJQM9aRdQr9xSiuMmammUv0xc.IjjWqIwDzo3UC8i6cF1G',1,53),(45,'1502010418','$2a$10$m0KQcowYdtTAs26VW..QlepQYko3F7MJEOd5dT8xiQIkFe2CCmasm',1,55),(46,'1502010419','$2a$10$gr4cnj.R5OnKuD0iLX47...jps71s9262jkPLuaemaXVOaIfAdfYW',1,57),(47,'1502010420','$2a$10$dhlxVXECI6XRTiUhdubkXOQLPlgo/cdBa/5qaF/MQP//TL7/WK/ZC',1,59),(48,'1502010421','$2a$10$TrkvK6xeUp9cckSH3QNUUOM6zSiS6l4mNUN2b2/G0hrKVzSx/spCu',1,61),(49,'1502010422','$2a$10$cGNPQcNbGPOUdKonrVz.5eIxGNPiJBc6u4/JUnxe3.AYg6l3PQ/i6',1,63),(50,'1502010423','$2a$10$bcoOE57VhDdLL1onYeF2nOpOdhB9ALrZggwnAAuqM99644g9Jm4Ba',1,65),(51,'1502010424','$2a$10$xefN7ItIUKf1Npu9VP/oEu32WEE9Zxz82dEwq0CO7KTIFceoEUkHC',1,67),(52,'1502010425','$2a$10$SGfqpd8gq65x.7besSr54O71ftnqGex2AJMCo4Xc20iioKofEx30y',1,69),(53,'1502010426','$2a$10$QSCmOysxatMD/CJmfRYr0eHVAqCTVRFAhRKcJekLguq1nL89w4ZJW',1,71),(54,'1502010427','$2a$10$hCVg5OQN/tx8Vx/3fg1CMeVJpqFGqsOm31otWnLs/tsScZmxsSFFe',1,73),(55,'1502010428','$2a$10$22Dwsw4aASs5mXvMnBgareXG0RCg0x3ZfDCJj6.8HOc.CRgYfcwl.',1,75),(56,'1502010429','$2a$10$CeDk2Z7fzKNLyzii5DtqrOwUHxVzxe3gMt/aRw9HaLCyImrFnn1Ra',1,77),(57,'1502010430','$2a$10$LduzPqMgLHuciuoZM18aCO4Q7mv105wVBHfWIANe7MvPG6bdoEZ9a',1,79),(58,'1502010431','$2a$10$V6NCefBx2WJtqI8j0xg.XONrxLZCMRZ1B6i/G0rwYz0IQL6h/nwk6',1,81),(59,'1502010432','$2a$10$9mVKaBs6uKPYoifkgmdkfejgDsjL/yj0pRK19yc2HZBkzRJ82D.V2',1,83),(60,'1502010433','$2a$10$Y7q6PolBZvUWzl0Cg.Vr2Odb2VGbVD3UoWi4bH83m3RTB.qwG7eEq',1,85),(61,'1502010434','$2a$10$XXIF1s5IGBwaEC/O1xCtc.JnrCDCjnx2cioYDuWPsTg1lskF0hBpe',1,87),(62,'1502010435','$2a$10$LE.5ES9Ms97WupWgqwNBh.oqGLN7LvfBb0daEZsDkJDwAZE3EdDvC',1,89),(63,'1502010436','$2a$10$KyoKYogbhNQFjON.4vE1weCGQ6VITC17gFbtj9XlGky3wgEsu4Wma',1,91),(64,'1502010437','$2a$10$SOJAlV7pC9bni94/V4JMyOfIsuoXsJsdJLBthUULato9TItQywxi6',1,93),(65,'1502010438','$2a$10$0Aa/XwR/H.0hD5s8nNMGYeu6LCOzP03r6dqaMNH6Pb3EAlqZvFJfC',1,95),(66,'1502010439','$2a$10$7i9S6Ie5STpOAeAR53BYnenENPl8zscvidN.VX.pAwcS3oqvpsUCi',1,97),(67,'1502010440','$2a$10$AfYu/jZ16//6/7xC2kZSy.9/bldGypuTAWbqhz61I8B13r.AF6e4S',1,99),(68,'1502010441','$2a$10$v6avjqNa72Yal.U.NX5Yt.KW0pRUw2Wj07Yh75V091G.UvEprCbuW',1,101),(69,'1502010442','$2a$10$991o31ub7IMFUSymiaPWweybwFMq4qhPK7Y3LOiv2shJCfv3kbQi6',1,103),(70,'1502010443','$2a$10$FHT4mCqmqf7AQe7Qe0Z1FuKHE7WgyRHs95asFUWVtopNa3j/yBU2i',1,105),(71,'1502010444','$2a$10$f2icXUgkaG.UzNI.u8C9TOsUYJAgSEocAjf4B8webbuoz8C252VTe',1,107),(72,'1502010445','$2a$10$MKv.BXZHYMfxuIlyxcEBzecQriL1I9NwKGKmK8KId4T6h.54fwGTy',1,109),(74,'1502010446','$2a$10$ZXMDxrRJxam2F6X4lgle1eicuaV9VkLUL4V.UG1f5RjLkAFMzuVcS',1,113),(75,'1502010447','$2a$10$PrPnm6NKMK/QRPCE/1u02Og8i.av1V7YZoF6ykS8.SfbKms3BDDPu',1,115),(76,'1502010448','$2a$10$BpG2crlx0vyQqhG4wtbuSef3zF.5a7qQSpQpMR.olo2/Dx.NkOaNy',1,117),(77,'1502010449','$2a$10$1nh9UXsv3n/bW4DcO72GC.N.iFOm2PQeBVPSm5tRHlR1fI3mVil8C',1,119),(78,'1502010450','$2a$10$lIIxYU4jamLatrU1NTt3oeltF12fI/8pK0w37flWpFSeTGHfv8f8.',1,121),(79,'1502010451','$2a$10$uxGd6.YFuow5QmQzN.Ef8uqQfCRXD2RAJAxPnib9vHzxlzeUdzyXO',1,123),(80,'1502010452','$2a$10$T4H6ZzYEjqUJm9nIAakpg.iHnhhb2JLTZqGujSz9xoCIAJLHt0pWC',1,125),(81,'1502010453','$2a$10$g5I0nV/MMW3g9z9WVGMazeUAQxElIX4Qs0ALtLSe1ptD.JgkJMdrq',1,127),(82,'1502010454','$2a$10$s50GxHbjybzOBIxrt17Fgu4nET/EdViqwfPhGEHynMzg0JNRS8vxC',1,129),(83,'72872872','$2a$10$Jq9lIXBhd0qNaaPmEzyR0eGNny5IBlxVG8SgYuvXcSePzBeKpenmC',1,131);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'xxq'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-10 17:13:52
