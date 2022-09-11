-- MySQL dump 10.13  Distrib 8.0.30, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: PlantLiber
-- ------------------------------------------------------
-- Server version	8.0.30-0ubuntu0.20.04.2

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
-- Table structure for table `Habitat`
--

DROP TABLE IF EXISTS `Habitat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Habitat` (
  `tipoH` int NOT NULL,
  `fasciaClimatica` varchar(45) DEFAULT NULL,
  `latitudine` varchar(45) DEFAULT NULL,
  `altitudine` int DEFAULT NULL,
  `topologia` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tipoH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Habitat`
--

LOCK TABLES `Habitat` WRITE;
/*!40000 ALTER TABLE `Habitat` DISABLE KEYS */;
INSERT INTO `Habitat` VALUES (1,'clima_0','lat_428927',3638,'topol_4','habitat_46'),(2,'clima_5','lat_551733',2523,'topol_4','habitat_60'),(3,'clima_11','lat_344725',1019,'topol_21','habitat_37'),(4,'clima_1','lat_52173',162,'topol_16','habitat_26'),(5,'clima_4','lat_77681',2114,'topol_18','habitat_67'),(6,'clima_0','lat_248471',4955,'topol_8','habitat_43'),(7,'clima_12','lat_410040',3096,'topol_14','habitat_48'),(8,'clima_8','lat_640762',334,'topol_2','habitat_48'),(9,'clima_4','lat_721276',2589,'topol_19','habitat_60'),(10,'clima_9','lat_842786',3447,'topol_1','habitat_32'),(11,'clima_10','lat_933108',1607,'topol_6','habitat_9'),(12,'clima_12','lat_40822',3378,'topol_11','habitat_10'),(13,'clima_13','lat_340148',2050,'topol_19','habitat_61'),(14,'clima_8','lat_478328',2967,'topol_10','habitat_18'),(15,'clima_15','lat_653566',3385,'topol_2','habitat_54'),(16,'clima_4','lat_861931',1244,'topol_8','habitat_25'),(17,'clima_4','lat_929352',3965,'topol_8','habitat_9'),(18,'clima_3','lat_327483',4803,'topol_14','habitat_12'),(19,'clima_9','lat_858001',3054,'topol_19','habitat_48'),(20,'clima_1','lat_723492',1903,'topol_12','habitat_49'),(21,'clima_10','lat_116644',2547,'topol_17','habitat_14'),(22,'clima_10','lat_210505',2490,'topol_11','habitat_69'),(23,'clima_4','lat_976585',1501,'topol_8','habitat_23'),(24,'clima_12','lat_301499',3538,'topol_23','habitat_24'),(25,'clima_5','lat_107896',3980,'topol_7','habitat_17'),(26,'clima_10','lat_508599',4510,'topol_19','habitat_35'),(27,'clima_14','lat_908311',3103,'topol_12','habitat_45'),(28,'clima_13','lat_259119',393,'topol_14','habitat_0'),(29,'clima_6','lat_726512',4970,'topol_18','habitat_15'),(30,'clima_3','lat_8911',4735,'topol_2','habitat_34'),(31,'clima_11','lat_961097',1139,'topol_7','habitat_1'),(32,'clima_3','lat_838194',534,'topol_4','habitat_43'),(33,'clima_16','lat_248021',2158,'topol_5','habitat_60'),(34,'clima_2','lat_855529',521,'topol_13','habitat_41'),(35,'clima_1','lat_243237',2162,'topol_8','habitat_57'),(36,'clima_8','lat_565569',3584,'topol_1','habitat_58'),(37,'clima_8','lat_946878',1710,'topol_23','habitat_3'),(38,'clima_10','lat_847999',1245,'topol_5','habitat_39'),(39,'clima_12','lat_74057',1616,'topol_16','habitat_41'),(40,'clima_16','lat_236134',683,'topol_1','habitat_42'),(41,'clima_5','lat_769571',1877,'topol_16','habitat_6'),(42,'clima_14','lat_927442',1870,'topol_20','habitat_37'),(43,'clima_5','lat_494427',4670,'topol_4','habitat_50'),(44,'clima_16','lat_73730',4552,'topol_3','habitat_68'),(45,'clima_6','lat_326440',2439,'topol_19','habitat_0'),(46,'clima_4','lat_820305',1808,'topol_19','habitat_31'),(47,'clima_8','lat_251623',3024,'topol_9','habitat_31'),(48,'clima_1','lat_741594',4554,'topol_14','habitat_33'),(49,'clima_3','lat_454195',3705,'topol_10','habitat_4'),(50,'clima_5','lat_470862',3928,'topol_2','habitat_4'),(51,'clima_10','lat_708301',448,'topol_20','habitat_5'),(52,'clima_7','lat_675749',47,'topol_19','habitat_16'),(53,'clima_12','lat_941941',4186,'topol_1','habitat_2'),(54,'clima_3','lat_85981',2084,'topol_19','habitat_37'),(55,'clima_11','lat_981768',1944,'topol_23','habitat_55'),(56,'clima_15','lat_47766',178,'topol_18','habitat_5'),(57,'clima_11','lat_635575',146,'topol_21','habitat_57'),(58,'clima_14','lat_339327',2925,'topol_24','habitat_37'),(59,'clima_10','lat_257415',3703,'topol_12','habitat_50'),(60,'clima_12','lat_527594',4504,'topol_9','habitat_31'),(61,'clima_5','lat_38754',1963,'topol_11','habitat_66'),(62,'clima_15','lat_536998',4075,'topol_12','habitat_16'),(63,'clima_3','lat_639141',3482,'topol_10','habitat_2'),(64,'clima_6','lat_912641',1430,'topol_20','habitat_28'),(65,'clima_6','lat_713201',1652,'topol_5','habitat_10'),(66,'clima_6','lat_332799',980,'topol_12','habitat_42'),(67,'clima_8','lat_99796',3627,'topol_6','habitat_17'),(68,'clima_5','lat_616062',555,'topol_18','habitat_34'),(69,'clima_10','lat_246939',2942,'topol_17','habitat_65');
/*!40000 ALTER TABLE `Habitat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-11 17:59:21
