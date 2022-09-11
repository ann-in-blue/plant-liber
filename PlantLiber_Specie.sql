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
-- Table structure for table `Specie`
--

DROP TABLE IF EXISTS `Specie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Specie` (
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Specie`
--

LOCK TABLES `Specie` WRITE;
/*!40000 ALTER TABLE `Specie` DISABLE KEYS */;
INSERT INTO `Specie` VALUES ('Dicot'),('specie_1'),('specie_10'),('specie_100'),('specie_101'),('specie_102'),('specie_103'),('specie_104'),('specie_105'),('specie_106'),('specie_107'),('specie_108'),('specie_109'),('specie_11'),('specie_110'),('specie_111'),('specie_112'),('specie_113'),('specie_114'),('specie_115'),('specie_116'),('specie_117'),('specie_118'),('specie_119'),('specie_12'),('specie_120'),('specie_121'),('specie_122'),('specie_123'),('specie_124'),('specie_125'),('specie_126'),('specie_127'),('specie_128'),('specie_129'),('specie_13'),('specie_130'),('specie_131'),('specie_132'),('specie_133'),('specie_134'),('specie_135'),('specie_136'),('specie_137'),('specie_138'),('specie_139'),('specie_14'),('specie_140'),('specie_141'),('specie_142'),('specie_143'),('specie_144'),('specie_145'),('specie_146'),('specie_147'),('specie_148'),('specie_149'),('specie_15'),('specie_150'),('specie_151'),('specie_152'),('specie_153'),('specie_154'),('specie_155'),('specie_156'),('specie_157'),('specie_158'),('specie_159'),('specie_16'),('specie_160'),('specie_161'),('specie_162'),('specie_163'),('specie_164'),('specie_165'),('specie_166'),('specie_167'),('specie_168'),('specie_169'),('specie_17'),('specie_170'),('specie_171'),('specie_172'),('specie_173'),('specie_174'),('specie_175'),('specie_176'),('specie_177'),('specie_178'),('specie_179'),('specie_18'),('specie_180'),('specie_181'),('specie_182'),('specie_183'),('specie_184'),('specie_185'),('specie_186'),('specie_187'),('specie_188'),('specie_189'),('specie_19'),('specie_190'),('specie_191'),('specie_192'),('specie_193'),('specie_194'),('specie_195'),('specie_196'),('specie_197'),('specie_198'),('specie_199'),('specie_2'),('specie_20'),('specie_200'),('specie_201'),('specie_202'),('specie_203'),('specie_204'),('specie_205'),('specie_206'),('specie_207'),('specie_208'),('specie_209'),('specie_21'),('specie_210'),('specie_211'),('specie_212'),('specie_213'),('specie_214'),('specie_215'),('specie_216'),('specie_217'),('specie_218'),('specie_219'),('specie_22'),('specie_220'),('specie_221'),('specie_222'),('specie_223'),('specie_224'),('specie_225'),('specie_226'),('specie_227'),('specie_228'),('specie_229'),('specie_23'),('specie_230'),('specie_231'),('specie_232'),('specie_233'),('specie_234'),('specie_235'),('specie_236'),('specie_237'),('specie_238'),('specie_239'),('specie_24'),('specie_240'),('specie_241'),('specie_242'),('specie_243'),('specie_244'),('specie_245'),('specie_246'),('specie_247'),('specie_248'),('specie_249'),('specie_25'),('specie_250'),('specie_251'),('specie_252'),('specie_253'),('specie_254'),('specie_255'),('specie_256'),('specie_257'),('specie_258'),('specie_259'),('specie_26'),('specie_260'),('specie_261'),('specie_262'),('specie_263'),('specie_264'),('specie_265'),('specie_266'),('specie_267'),('specie_268'),('specie_269'),('specie_27'),('specie_270'),('specie_271'),('specie_272'),('specie_273'),('specie_274'),('specie_275'),('specie_276'),('specie_277'),('specie_278'),('specie_279'),('specie_28'),('specie_280'),('specie_281'),('specie_282'),('specie_283'),('specie_284'),('specie_285'),('specie_286'),('specie_287'),('specie_288'),('specie_289'),('specie_29'),('specie_290'),('specie_291'),('specie_292'),('specie_293'),('specie_294'),('specie_295'),('specie_296'),('specie_297'),('specie_298'),('specie_299'),('specie_3'),('specie_30'),('specie_300'),('specie_301'),('specie_302'),('specie_303'),('specie_304'),('specie_305'),('specie_306'),('specie_307'),('specie_308'),('specie_309'),('specie_31'),('specie_310'),('specie_311'),('specie_312'),('specie_313'),('specie_314'),('specie_315'),('specie_316'),('specie_317'),('specie_318'),('specie_319'),('specie_32'),('specie_320'),('specie_321'),('specie_322'),('specie_323'),('specie_324'),('specie_325'),('specie_326'),('specie_327'),('specie_328'),('specie_329'),('specie_33'),('specie_330'),('specie_331'),('specie_332'),('specie_333'),('specie_334'),('specie_335'),('specie_336'),('specie_337'),('specie_338'),('specie_339'),('specie_34'),('specie_340'),('specie_341'),('specie_342'),('specie_343'),('specie_344'),('specie_345'),('specie_346'),('specie_347'),('specie_348'),('specie_349'),('specie_35'),('specie_350'),('specie_351'),('specie_352'),('specie_353'),('specie_354'),('specie_355'),('specie_356'),('specie_357'),('specie_358'),('specie_359'),('specie_36'),('specie_360'),('specie_361'),('specie_362'),('specie_363'),('specie_364'),('specie_365'),('specie_366'),('specie_367'),('specie_368'),('specie_369'),('specie_37'),('specie_370'),('specie_371'),('specie_372'),('specie_373'),('specie_374'),('specie_375'),('specie_376'),('specie_377'),('specie_378'),('specie_379'),('specie_38'),('specie_380'),('specie_381'),('specie_382'),('specie_383'),('specie_384'),('specie_385'),('specie_386'),('specie_387'),('specie_388'),('specie_389'),('specie_39'),('specie_390'),('specie_391'),('specie_392'),('specie_393'),('specie_394'),('specie_395'),('specie_396'),('specie_397'),('specie_398'),('specie_399'),('specie_4'),('specie_40'),('specie_400'),('specie_401'),('specie_402'),('specie_403'),('specie_404'),('specie_405'),('specie_406'),('specie_407'),('specie_408'),('specie_409'),('specie_41'),('specie_410'),('specie_411'),('specie_412'),('specie_413'),('specie_414'),('specie_415'),('specie_416'),('specie_417'),('specie_418'),('specie_419'),('specie_42'),('specie_420'),('specie_421'),('specie_422'),('specie_423'),('specie_424'),('specie_425'),('specie_426'),('specie_427'),('specie_428'),('specie_429'),('specie_43'),('specie_430'),('specie_431'),('specie_432'),('specie_433'),('specie_434'),('specie_435'),('specie_436'),('specie_437'),('specie_438'),('specie_439'),('specie_44'),('specie_440'),('specie_441'),('specie_442'),('specie_443'),('specie_444'),('specie_445'),('specie_446'),('specie_447'),('specie_448'),('specie_449'),('specie_45'),('specie_450'),('specie_451'),('specie_452'),('specie_453'),('specie_454'),('specie_455'),('specie_456'),('specie_457'),('specie_458'),('specie_459'),('specie_46'),('specie_460'),('specie_461'),('specie_462'),('specie_463'),('specie_464'),('specie_465'),('specie_466'),('specie_467'),('specie_468'),('specie_469'),('specie_47'),('specie_470'),('specie_471'),('specie_472'),('specie_473'),('specie_474'),('specie_475'),('specie_476'),('specie_477'),('specie_478'),('specie_479'),('specie_48'),('specie_480'),('specie_481'),('specie_482'),('specie_483'),('specie_484'),('specie_485'),('specie_486'),('specie_487'),('specie_488'),('specie_489'),('specie_49'),('specie_490'),('specie_491'),('specie_492'),('specie_493'),('specie_494'),('specie_495'),('specie_496'),('specie_497'),('specie_498'),('specie_499'),('specie_5'),('specie_50'),('specie_51'),('specie_52'),('specie_53'),('specie_54'),('specie_55'),('specie_56'),('specie_57'),('specie_58'),('specie_59'),('specie_6'),('specie_60'),('specie_61'),('specie_62'),('specie_63'),('specie_64'),('specie_65'),('specie_66'),('specie_67'),('specie_68'),('specie_69'),('specie_7'),('specie_70'),('specie_71'),('specie_72'),('specie_73'),('specie_74'),('specie_75'),('specie_76'),('specie_77'),('specie_78'),('specie_79'),('specie_8'),('specie_80'),('specie_81'),('specie_82'),('specie_83'),('specie_84'),('specie_85'),('specie_86'),('specie_87'),('specie_88'),('specie_89'),('specie_9'),('specie_90'),('specie_91'),('specie_92'),('specie_93'),('specie_94'),('specie_95'),('specie_96'),('specie_97'),('specie_98'),('specie_99');
/*!40000 ALTER TABLE `Specie` ENABLE KEYS */;
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
