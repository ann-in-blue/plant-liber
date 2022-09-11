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
-- Table structure for table `IstitutoDiRicerca`
--

DROP TABLE IF EXISTS `IstitutoDiRicerca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `IstitutoDiRicerca` (
  `cod` int NOT NULL,
  `via` varchar(45) DEFAULT NULL,
  `numeroCivico` int DEFAULT NULL,
  `CAP` int DEFAULT NULL,
  `denominazione` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `IstitutoDiRicerca`
--

LOCK TABLES `IstitutoDiRicerca` WRITE;
/*!40000 ALTER TABLE `IstitutoDiRicerca` DISABLE KEYS */;
INSERT INTO `IstitutoDiRicerca` VALUES (0,'via_325',405,73946,'denom_0'),(1,'via_353',754,28498,'denom_1'),(2,'via_33',684,38519,'denom_2'),(3,'via_152',882,67993,'denom_3'),(4,'via_321',971,85451,'denom_4'),(5,'via_309',755,91103,'denom_5'),(6,'via_103',159,89307,'denom_6'),(7,'via_3',555,46210,'denom_7'),(8,'via_186',92,95874,'denom_8'),(9,'via_214',114,56011,'denom_9'),(10,'via_125',887,735,'denom_10'),(11,'via_74',136,93625,'denom_11'),(12,'via_123',784,78630,'denom_12'),(13,'via_132',136,28224,'denom_13'),(14,'via_107',795,6904,'denom_14'),(15,'via_273',428,52795,'denom_15'),(16,'via_278',640,85696,'denom_16'),(17,'via_217',333,38435,'denom_17'),(18,'via_53',672,1767,'denom_18'),(19,'via_330',588,85586,'denom_19'),(20,'via_10',678,53939,'denom_20'),(21,'via_47',712,67188,'denom_21'),(22,'via_299',101,28354,'denom_22'),(23,'via_366',699,77670,'denom_23'),(24,'via_364',351,7533,'denom_24'),(25,'via_57',306,28659,'denom_25'),(26,'via_351',592,25057,'denom_26'),(27,'via_144',994,22744,'denom_27'),(28,'via_203',842,48531,'denom_28'),(29,'via_199',154,13285,'denom_29'),(30,'via_78',35,28116,'denom_30'),(31,'via_151',27,36149,'denom_31'),(32,'via_300',173,81677,'denom_32'),(33,'via_255',846,10455,'denom_33'),(34,'via_314',31,75666,'denom_34'),(35,'via_230',657,24220,'denom_35'),(36,'via_81',464,82923,'denom_36'),(37,'via_341',280,88790,'denom_37'),(38,'via_128',28,64245,'denom_38'),(39,'via_148',401,96723,'denom_39'),(40,'via_49',788,93837,'denom_40'),(41,'via_100',401,2303,'denom_41'),(42,'via_194',327,73621,'denom_42'),(43,'via_54',538,55161,'denom_43'),(44,'via_40',556,6281,'denom_44'),(45,'via_151',390,15786,'denom_45'),(46,'via_130',82,113,'denom_46'),(47,'via_305',187,19489,'denom_47'),(48,'via_50',154,93157,'denom_48'),(49,'via_350',98,2290,'denom_49'),(50,'via_261',225,22259,'denom_50'),(51,'via_233',593,69981,'denom_51'),(52,'via_107',744,41998,'denom_52'),(53,'via_275',391,59366,'denom_53'),(54,'via_118',999,65771,'denom_54'),(55,'via_185',902,79484,'denom_55'),(56,'via_140',601,58318,'denom_56'),(57,'via_68',598,18992,'denom_57'),(58,'via_123',311,37132,'denom_58'),(59,'via_37',894,94224,'denom_59'),(60,'via_214',247,25386,'denom_60'),(61,'via_176',311,88683,'denom_61'),(62,'via_18',493,57029,'denom_62'),(63,'via_166',376,88626,'denom_63'),(64,'via_109',796,35995,'denom_64'),(65,'via_348',486,58282,'denom_65'),(66,'via_309',321,46008,'denom_66'),(67,'via_365',318,71234,'denom_67'),(68,'via_75',474,50235,'denom_68'),(69,'via_49',61,38241,'denom_69'),(70,'via_193',212,95269,'denom_70'),(71,'via_28',231,54903,'denom_71'),(72,'via_265',152,80996,'denom_72'),(73,'via_62',177,60965,'denom_73'),(74,'via_72',432,95520,'denom_74'),(75,'via_113',856,24790,'denom_75'),(76,'via_57',945,66089,'denom_76'),(77,'via_99',545,76854,'denom_77'),(78,'via_292',921,96060,'denom_78'),(79,'via_280',840,42502,'denom_79'),(80,'via_109',500,52350,'denom_80'),(81,'via_257',571,11175,'denom_81'),(82,'via_264',963,25009,'denom_82'),(83,'via_207',823,13894,'denom_83'),(84,'via_76',491,92986,'denom_84'),(85,'via_202',479,16715,'denom_85'),(86,'via_146',357,19619,'denom_86'),(87,'via_180',175,21546,'denom_87'),(88,'via_340',113,44665,'denom_88'),(89,'via_310',940,60449,'denom_89'),(90,'via_236',80,93102,'denom_90'),(91,'via_57',521,80874,'denom_91'),(92,'via_299',926,45496,'denom_92'),(93,'via_74',526,19960,'denom_93'),(94,'via_214',524,1150,'denom_94'),(95,'via_222',235,21102,'denom_95'),(96,'via_174',387,59034,'denom_96'),(97,'via_59',768,37414,'denom_97'),(98,'via_38',432,67589,'denom_98'),(99,'via_163',147,18972,'denom_99'),(100,'via_132',635,82831,'denom_100'),(101,'via_212',591,85187,'denom_101'),(102,'via_312',439,84129,'denom_102'),(103,'via_263',941,24144,'denom_103'),(104,'via_197',768,42807,'denom_104'),(105,'via_75',537,37977,'denom_105'),(106,'via_365',822,14123,'denom_106'),(107,'via_249',980,10592,'denom_107'),(108,'via_211',793,26840,'denom_108'),(109,'via_199',398,21327,'denom_109'),(110,'via_231',582,4572,'denom_110'),(111,'via_128',697,68135,'denom_111'),(112,'via_341',745,52498,'denom_112'),(113,'via_71',676,15980,'denom_113'),(114,'via_253',317,44304,'denom_114'),(115,'via_185',161,12385,'denom_115'),(116,'via_343',150,14668,'denom_116'),(117,'via_8',692,41294,'denom_117'),(118,'via_61',577,99315,'denom_118'),(119,'via_357',10,39904,'denom_119'),(120,'via_40',976,19155,'denom_120'),(121,'via_347',167,19213,'denom_121'),(122,'via_330',431,8696,'denom_122'),(123,'via_277',579,88336,'denom_123'),(124,'via_162',586,77894,'denom_124'),(125,'via_353',672,32846,'denom_125'),(126,'via_312',848,36403,'denom_126'),(127,'via_116',853,78484,'denom_127'),(128,'via_347',884,20463,'denom_128'),(129,'via_187',528,40718,'denom_129'),(130,'via_320',268,45313,'denom_130'),(131,'via_239',682,17029,'denom_131'),(132,'via_71',884,64935,'denom_132'),(133,'via_121',523,89064,'denom_133'),(134,'via_190',277,90563,'denom_134'),(135,'via_120',681,24591,'denom_135'),(136,'via_74',290,88892,'denom_136'),(137,'via_137',159,80303,'denom_137'),(138,'via_297',755,19128,'denom_138'),(139,'via_279',246,24248,'denom_139'),(140,'via_158',428,48513,'denom_140'),(141,'via_73',133,5884,'denom_141'),(142,'via_248',115,11887,'denom_142'),(143,'via_364',273,80409,'denom_143'),(144,'via_347',900,10190,'denom_144'),(145,'via_31',277,36196,'denom_145'),(146,'via_103',363,13156,'denom_146'),(147,'via_75',389,17119,'denom_147'),(148,'via_39',759,84985,'denom_148'),(149,'via_309',368,79089,'denom_149'),(150,'via_160',669,60693,'denom_150'),(151,'via_333',810,68364,'denom_151'),(152,'via_223',742,91495,'denom_152'),(153,'via_264',929,71737,'denom_153'),(154,'via_326',940,56640,'denom_154'),(155,'via_29',386,20926,'denom_155'),(156,'via_82',208,17330,'denom_156'),(157,'via_127',504,58208,'denom_157'),(158,'via_258',509,6685,'denom_158'),(159,'via_185',869,2534,'denom_159'),(160,'via_143',850,3397,'denom_160'),(161,'via_213',804,27072,'denom_161'),(162,'via_183',560,916,'denom_162'),(163,'via_361',66,44797,'denom_163'),(164,'via_121',37,38591,'denom_164'),(165,'via_156',661,39708,'denom_165'),(166,'via_355',229,15401,'denom_166'),(167,'via_17',236,11397,'denom_167'),(168,'via_133',788,25212,'denom_168'),(169,'via_368',824,70720,'denom_169'),(170,'via_320',498,78472,'denom_170'),(171,'via_36',842,27427,'denom_171'),(172,'via_365',800,57576,'denom_172'),(173,'via_57',366,6937,'denom_173'),(174,'via_230',3,70023,'denom_174'),(175,'via_354',724,75576,'denom_175'),(176,'via_94',836,47800,'denom_176'),(177,'via_56',760,10982,'denom_177'),(178,'via_148',754,5775,'denom_178'),(179,'via_170',659,39002,'denom_179'),(180,'via_63',866,33597,'denom_180'),(181,'via_352',585,49212,'denom_181'),(182,'via_300',463,1604,'denom_182'),(183,'via_34',397,69244,'denom_183'),(184,'via_4',904,13188,'denom_184'),(185,'via_81',331,12073,'denom_185'),(186,'via_130',722,15389,'denom_186'),(187,'via_2',416,40512,'denom_187'),(188,'via_292',309,72062,'denom_188'),(189,'via_12',828,17494,'denom_189'),(190,'via_7',653,25723,'denom_190'),(191,'via_360',877,18872,'denom_191'),(192,'via_163',504,95320,'denom_192'),(193,'via_131',536,84937,'denom_193'),(194,'via_291',928,27956,'denom_194'),(195,'via_268',642,26606,'denom_195'),(196,'via_327',610,97709,'denom_196'),(197,'via_36',194,99056,'denom_197'),(198,'via_37',71,8667,'denom_198'),(199,'via_47',649,17989,'denom_199');
/*!40000 ALTER TABLE `IstitutoDiRicerca` ENABLE KEYS */;
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
