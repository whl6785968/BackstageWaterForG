-- MySQL dump 10.13  Distrib 5.7.23, for Win64 (x86_64)
--
-- Host: localhost    Database: watermoni
-- ------------------------------------------------------
-- Server version	5.7.23-log

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
-- Table structure for table `backendresources`
--

DROP TABLE IF EXISTS `backendresources`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `backendresources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(32) DEFAULT NULL,
  `resource_url` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `backendresources`
--

LOCK TABLES `backendresources` WRITE;
/*!40000 ALTER TABLE `backendresources` DISABLE KEYS */;
INSERT INTO `backendresources` VALUES (1,'用户相关','/user/*'),(2,'用户管理','/sys/user/*'),(3,'菜单相关','/sys/menu/*');
/*!40000 ALTER TABLE `backendresources` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `district`
--

DROP TABLE IF EXISTS `district`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `district` (
  `id` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district`
--

LOCK TABLES `district` WRITE;
/*!40000 ALTER TABLE `district` DISABLE KEYS */;
INSERT INTO `district` VALUES ('001','长江流域'),('002','黄河流域'),('003','珠江流域'),('004','松花江流域'),('005','淮河流域'),('006','海河流域'),('007','辽河流域'),('008','浙闽片流域'),('009','西南诸河'),('010','西北诸河'),('011','太湖流域'),('012','滇池流域'),('013','巢湖流域');
/*!40000 ALTER TABLE `district` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enp`
--

DROP TABLE IF EXISTS `enp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enp` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `contacts` varchar(200) NOT NULL,
  `contacts_number` varchar(200) NOT NULL,
  `main_pollutions` varchar(200) DEFAULT NULL,
  `pollutions_num` double DEFAULT NULL,
  `is_exceed` int(11) NOT NULL,
  `exceed_factor` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enp`
--

LOCK TABLES `enp` WRITE;
/*!40000 ALTER TABLE `enp` DISABLE KEYS */;
INSERT INTO `enp` VALUES (20001,'南京A化工企业','小张','18245808888','totalp',50,1,'totap'),(20002,'南京B化工企业','小王','136836802556','nh',10,0,'无');
/*!40000 ALTER TABLE `enp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equip_sta`
--

DROP TABLE IF EXISTS `equip_sta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equip_sta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` varchar(200) NOT NULL,
  `sid` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `eid` (`eid`),
  KEY `sid` (`sid`),
  CONSTRAINT `equip_sta_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `equipment` (`id`),
  CONSTRAINT `equip_sta_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `station` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equip_sta`
--

LOCK TABLES `equip_sta` WRITE;
/*!40000 ALTER TABLE `equip_sta` DISABLE KEYS */;
INSERT INTO `equip_sta` VALUES (1,'00202440000000010','4001'),(2,'00202440000000001','4002'),(3,'00202440000000002','4003'),(4,'00202440000000003','4004'),(5,'00202440000000004','4005'),(6,'00202440000000005','4006'),(7,'00202440000000006','4007'),(8,'00202440000000007','4008'),(9,'00202440000000008','4009'),(10,'00202440000000009','4010'),(11,'00202440000000011','4011'),(12,'00202440000000012','4012'),(13,'00202440000000013','4016'),(14,'00202440000000014','4013'),(15,'00202440000000015','4014'),(16,'00202440000000016','4015'),(17,'00202440000000018','4017'),(18,'00202440000000017','4018'),(19,'00202440000000019','4019'),(20,'00202440000000020','4020');
/*!40000 ALTER TABLE `equip_sta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipment`
--

DROP TABLE IF EXISTS `equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipment` (
  `id` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `model` varchar(200) NOT NULL,
  `productionTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `availableTime` int(11) DEFAULT NULL,
  `productionPlace` varchar(32) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment`
--

LOCK TABLES `equipment` WRITE;
/*!40000 ALTER TABLE `equipment` DISABLE KEYS */;
INSERT INTO `equipment` VALUES ('00202440000000001','高级水质检测仪','GPRS232-734','2020-10-30 22:20:33',7,'波思图智能有效股份公司',1),('00202440000000002','高级水质检测仪','GPRS232-734','2020-10-30 22:21:11',7,'波思图智能有效股份公司',1),('00202440000000003','高级水质检测仪','GPRS232-734','2020-10-30 22:21:33',7,'波思图智能有效股份公司',1),('00202440000000004','高级水质检测仪','GPRS232-734','2020-10-30 22:22:03',7,'波思图智能有效股份公司',1),('00202440000000005','高级水质检测仪','GPRS232-734','2020-10-30 22:22:49',7,'波思图智能有效股份公司',1),('00202440000000006','高级水质检测仪','GPRS232-734','2020-10-30 22:23:44',7,'波思图智能有效股份公司',1),('00202440000000007','高级水质检测仪','GPRS232-734','2020-10-30 22:24:14',7,'波思图智能有效股份公司',1),('00202440000000008','高级水质检测仪','GPRS232-734','2020-10-30 22:25:01',7,'波思图智能有效股份公司',1),('00202440000000009','高级水质检测仪','GPRS232-734','2020-10-30 22:25:46',7,'波思图智能有效股份公司',1),('00202440000000010','高级水质检测仪','GPRS232-734','2020-10-30 22:17:28',7,'波思图智能有效股份公司',1),('00202440000000011','高级水质检测仪','GPRS232-734','2020-10-30 22:26:24',7,'波思图智能有效股份公司',1),('00202440000000012','高级水质检测仪','GPRS232-734','2020-10-30 22:27:00',7,'波思图智能有效股份公司',1),('00202440000000013','高级水质检测仪','GPRS232-734','2020-10-30 22:27:20',7,'波思图智能有效股份公司',1),('00202440000000014','高级水质检测仪','GPRS232-734','2020-10-30 22:28:06',7,'波思图智能有效股份公司',1),('00202440000000015','高级水质检测仪','GPRS232-734','2020-10-30 22:28:30',7,'波思图智能有效股份公司',1),('00202440000000016','高级水质检测仪','GPRS232-734','2020-10-30 22:29:03',7,'波思图智能有效股份公司',1),('00202440000000017','高级水质检测仪','GPRS232-734','2020-11-01 23:55:00',7,'波思图智能有效股份公司',1),('00202440000000018','高级水质检测仪','GPRS232-734','2020-11-01 23:54:31',7,'波思图智能有效股份公司',1),('00202440000000019','高级水质检测仪','GPRS232-734','2020-11-02 00:00:12',7,'波思图智能有效股份公司',1),('00202440000000020','高级水质检测仪','GPRS232-734','2020-11-02 00:00:35',7,'波思图智能有效股份公司',1);
/*!40000 ALTER TABLE `equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `err_record`
--

DROP TABLE IF EXISTS `err_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `err_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `record_id` varchar(200) NOT NULL,
  `title` varchar(200) NOT NULL,
  `emergency` int(11) NOT NULL,
  `charger_id` varchar(32) NOT NULL,
  `charger_name` varchar(32) DEFAULT NULL,
  `charger_numger` varchar(32) DEFAULT NULL,
  `origin` int(11) NOT NULL,
  `serious_factor` varchar(32) DEFAULT NULL,
  `is_solve` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `sid` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `record_id` (`record_id`),
  KEY `charger_id` (`charger_id`),
  KEY `sid` (`sid`),
  CONSTRAINT `err_record_ibfk_1` FOREIGN KEY (`charger_id`) REFERENCES `user` (`userId`),
  CONSTRAINT `err_record_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `station` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `err_record`
--

LOCK TABLES `err_record` WRITE;
/*!40000 ALTER TABLE `err_record` DISABLE KEYS */;
INSERT INTO `err_record` VALUES (12,'cd8151a51f634be8a5091f014db3f8081605529250768','站点：急水港桥指标kmno等严重超标',2,'test1','sandalen','18245803818',4,'kmno',0,'2020-11-16 04:20:51','4001'),(13,'14a64181998e4b6786ad1db57bdca4081605529252705','站点：蛤蟆石指标kmno等严重超标',2,'test3','alex','18245803818',4,'kmno',0,'2020-11-16 04:20:53','4005'),(14,'49da1ef319794e869f6b2ccba6815a361605529253705','站点：城陵矶指标kmno等严重超标',2,'test2','张亮','18245803818',4,'kmno',0,'2020-11-16 04:20:54','4007'),(15,'a88cac3d82e343a98ef984f0cae486341605529255039','站点：新城桥指标dis等严重超标',3,'test3','alex','18245803818',4,'dis',0,'2020-11-16 04:20:55','4010'),(16,'527096c1fb6846d4b12954752517a3671605529255307','站点：中卫下河该站点最近20条数据中，异常数据比例超过10%',3,'test3','alex','18245803818',2,'dis',0,'2020-11-16 04:20:55','4011'),(17,'f0e91ae2f944453abf0f34e11b95c13b1605529255823','站点：画匠营子该站点最近20条数据中，异常数据比例超过10%',2,'test3','alex','18245803818',2,'kmno',0,'2020-11-16 04:20:56','4012'),(18,'f393219c39af4180a3c447c7b3f851721605529256714','站点：河津大桥该站点最近20条数据中，异常数据比例超过10%',3,'test3','alex','18245803818',2,'totalp',0,'2020-11-16 04:20:57','4013'),(19,'7abbfe39cff34f0abf39b42c5a89f1071605529257141','站点：潼关吊桥该站点最近20条数据中，异常数据比例超过10%',3,'test3','alex','18245803818',2,'totalp',0,'2020-11-16 04:20:57','4014'),(20,'eb979791d50349acb4c261edf8279d951605529257663','站点：小浪底该站点最近20条数据中，异常数据比例超过10%',2,'test3','alex','18245803818',2,'kmno',0,'2020-11-16 04:20:58','4015'),(21,'3bb7a325c4944d478081c81a903613d91605529258260','站点：界首该站点最近20条数据中，异常数据比例超过10%',2,'test2','张亮','18245803818',2,'dis',0,'2020-11-16 04:20:58','4017');
/*!40000 ALTER TABLE `err_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `err_report`
--

DROP TABLE IF EXISTS `err_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `err_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `report_id` varchar(200) NOT NULL,
  `result` varchar(200) NOT NULL,
  `basin_error` varchar(2000) DEFAULT NULL,
  `enterprise_error` varchar(2000) DEFAULT NULL,
  `factor_result` varchar(2000) DEFAULT NULL,
  `factor_solution` varchar(2000) DEFAULT NULL,
  `sid` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `report_id` (`report_id`),
  KEY `sid` (`sid`),
  CONSTRAINT `err_report_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `station` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `err_report`
--

LOCK TABLES `err_report` WRITE;
/*!40000 ALTER TABLE `err_report` DISABLE KEYS */;
INSERT INTO `err_report` VALUES (2,'03bd8c357bc342079264fc7d494b09411605529259806','站点：急水港桥指标kmno等严重超标','上下游皆为出现异常，考虑当前站点自身原因。',NULL,'高锰酸盐指数，代表水样中可被高锰酸钾氧化的还原性物质（主要是有机污染物版）的总量，用权O2的mg/L数来表示，非常类似于化学需氧量（CODCr）。高锰酸盐指数越高，说明水体受到有机物污染的程度越严重。 这是水体中含氮有机物进一步氧化，在变成硝酸盐过程中的中间产物。水中存在亚硝酸盐时表明有机物的分解过程还在继续进行，亚硝酸盐的含量如太高，即说明水中有机物的无机化过程进行的相当强烈，表示污染的危险性仍然存在。','[首先，如果是取的浅层地下水，且地下水补给主要是降水补给，则浅层地下水受地面农业灌溉的影响（施氮肥等）、或生活污染的可能性较大，另外，如果在勘察孔取水，地下水取水过程中应进行抽水，待抽水孔重新注水后及时取水样方具代表性，如果取的是勘察孔滞水，则很可能超标。其次，如果取的是深层地下水，且取水层上部有良好的隔水层，则因该分析该层水的补给源 ，分析其补给情况，给出超标原因。]','4001'),(3,'6efd742678604a2f89b248bf14732a9d1605529259845','站点：蛤蟆石指标kmno等严重超标','上下游皆为出现异常，考虑当前站点自身原因。',NULL,'高锰酸盐指数，代表水样中可被高锰酸钾氧化的还原性物质（主要是有机污染物版）的总量，用权O2的mg/L数来表示，非常类似于化学需氧量（CODCr）。高锰酸盐指数越高，说明水体受到有机物污染的程度越严重。 这是水体中含氮有机物进一步氧化，在变成硝酸盐过程中的中间产物。水中存在亚硝酸盐时表明有机物的分解过程还在继续进行，亚硝酸盐的含量如太高，即说明水中有机物的无机化过程进行的相当强烈，表示污染的危险性仍然存在。','[首先，如果是取的浅层地下水，且地下水补给主要是降水补给，则浅层地下水受地面农业灌溉的影响（施氮肥等）、或生活污染的可能性较大，另外，如果在勘察孔取水，地下水取水过程中应进行抽水，待抽水孔重新注水后及时取水样方具代表性，如果取的是勘察孔滞水，则很可能超标。其次，如果取的是深层地下水，且取水层上部有良好的隔水层，则因该分析该层水的补给源 ，分析其补给情况，给出超标原因。]','4005'),(4,'d7ee2f7c91574f049668fd5c66d58f571605529259872','站点：城陵矶指标kmno等严重超标','上下游皆为出现异常，考虑当前站点自身原因。',NULL,'高锰酸盐指数，代表水样中可被高锰酸钾氧化的还原性物质（主要是有机污染物版）的总量，用权O2的mg/L数来表示，非常类似于化学需氧量（CODCr）。高锰酸盐指数越高，说明水体受到有机物污染的程度越严重。 这是水体中含氮有机物进一步氧化，在变成硝酸盐过程中的中间产物。水中存在亚硝酸盐时表明有机物的分解过程还在继续进行，亚硝酸盐的含量如太高，即说明水中有机物的无机化过程进行的相当强烈，表示污染的危险性仍然存在。','[首先，如果是取的浅层地下水，且地下水补给主要是降水补给，则浅层地下水受地面农业灌溉的影响（施氮肥等）、或生活污染的可能性较大，另外，如果在勘察孔取水，地下水取水过程中应进行抽水，待抽水孔重新注水后及时取水样方具代表性，如果取的是勘察孔滞水，则很可能超标。其次，如果取的是深层地下水，且取水层上部有良好的隔水层，则因该分析该层水的补给源 ，分析其补给情况，给出超标原因。]','4007'),(5,'c1f998719f5e4029a01d4ede449412321605529259894','站点：新城桥指标dis等严重超标','上游站点未发生异常，由当前站点新城桥出发的下游流域新城桥->中卫下河中各站点出现溶解氧有关异常，判断当前站点存在问题。',NULL,'1.氧气在水中的溶解度随水温升高而降低,高温会引起水体中溶解氧降低。\n2.养殖密度过大。水体中众多生物的呼吸作用增加,生物耗氧量也增大。\n3.池塘中含有大量的有机物。有机物越多,细菌就越话跃,这种有机物的分解过程通常要消耗大量的氧才能进行,因此,容易造成缺氧。\n4.无机物的氧化作用。水中存在如硫化氢亚硝酸盐等无机物时,会发生氧化作用消耗大量的溶解氧。','[1.经常注入新水,并使用增氧机。\n2.经常泼洒微生物水质改良剂(如增氧底保净、光合细菌、水好等)。\n3.缺氧浮头时泼洒增氧剂(富氧、久久氧)。\n4.控制池塘里浮游动植物的数量。使用鑫铜、克藻抑制浮游植物的繁殖,使用鑫洋混杀威、鑫洋水蛛威、鑫洋双爱威等杀灭浮游动物。]','4010'),(6,'4f87bf30eb9d495b834693f3ffc5c6251605529259916','站点：中卫下河该站点最近20条数据中，异常数据比例超过10%','从站点新城桥为起点至当前站点中卫下河的流域皆发生与指标溶解氧相关异常，沿途流域为新城桥->中卫下河。',NULL,'1.氧气在水中的溶解度随水温升高而降低,高温会引起水体中溶解氧降低。\n2.养殖密度过大。水体中众多生物的呼吸作用增加,生物耗氧量也增大。\n3.池塘中含有大量的有机物。有机物越多,细菌就越话跃,这种有机物的分解过程通常要消耗大量的氧才能进行,因此,容易造成缺氧。\n4.无机物的氧化作用。水中存在如硫化氢亚硝酸盐等无机物时,会发生氧化作用消耗大量的溶解氧。','[1.经常注入新水,并使用增氧机。\n2.经常泼洒微生物水质改良剂(如增氧底保净、光合细菌、水好等)。\n3.缺氧浮头时泼洒增氧剂(富氧、久久氧)。\n4.控制池塘里浮游动植物的数量。使用鑫铜、克藻抑制浮游植物的繁殖,使用鑫洋混杀威、鑫洋水蛛威、鑫洋双爱威等杀灭浮游动物。]','4011'),(7,'8ec72a86ca9c400c8ac7d221293ce0a71605529259935','站点：画匠营子该站点最近20条数据中，异常数据比例超过10%','上下游皆为出现异常，考虑当前站点自身原因。',NULL,'高锰酸盐指数，代表水样中可被高锰酸钾氧化的还原性物质（主要是有机污染物版）的总量，用权O2的mg/L数来表示，非常类似于化学需氧量（CODCr）。高锰酸盐指数越高，说明水体受到有机物污染的程度越严重。 这是水体中含氮有机物进一步氧化，在变成硝酸盐过程中的中间产物。水中存在亚硝酸盐时表明有机物的分解过程还在继续进行，亚硝酸盐的含量如太高，即说明水中有机物的无机化过程进行的相当强烈，表示污染的危险性仍然存在。','[首先，如果是取的浅层地下水，且地下水补给主要是降水补给，则浅层地下水受地面农业灌溉的影响（施氮肥等）、或生活污染的可能性较大，另外，如果在勘察孔取水，地下水取水过程中应进行抽水，待抽水孔重新注水后及时取水样方具代表性，如果取的是勘察孔滞水，则很可能超标。其次，如果取的是深层地下水，且取水层上部有良好的隔水层，则因该分析该层水的补给源 ，分析其补给情况，给出超标原因。]','4012'),(8,'6a49de7e332b48e3a5e3d98f9b0011321605529259956','站点：河津大桥该站点最近20条数据中，异常数据比例超过10%','上游站点未发生异常，由当前站点河津大桥出发的下游流域河津大桥->潼关吊桥中各站点出现总磷有关异常，判断当前站点存在问题。','临近企业南京A化工企业等排污总磷超标，请联系相关负责人','一、煤化工废水磷超标：煤化工废水中的磷主要来自于原料煤和水处理药剂的带入，一般煤炭中的有机磷含量很低，主要是无机磷，但由于原料煤用量巨大，远远超过水处理药剂带入的磷，最终会导致总磷超标，而无机磷超标投加除磷剂即可解决。\n二、生活污水磷超标:生活污水中的磷来源广泛，种类复杂，其中的合成洗涤剂、含磷洗衣粉、人类排泄物、废弃食物中都含有大量的磷。现在的生活污水排放量越来越大，是导致生活污水磷超标的主要原因。目前，对生活污水的总磷去除方法有生物除磷法和化学除磷法。\n三、化学镀镍废水磷超标:化学镀镍是用还原剂把溶液中的镍离子还原沉积在金属表面，而这种工艺常用的还原剂是次磷酸钠，这种工艺最终会导致废水中的次亚磷超标，这种磷的去除方法比较特殊，引起不能与传统除磷剂发生反应，从而无法去除。对于次亚磷废水，比较有效的办法是使用次亚磷去除剂HMC-P3进行处理，通过催化剂进行催化，次亚磷去除剂能够与次亚磷结合，形成均相共沉淀。\n四、磷化工废水磷超标:无机磷化工废水中含有一定量磷、氟、砷等杂质，其对环境影响较大，必须严格控制后达标排放。这也是磷化工生产企业废水处理最困难的地方。无机磷化工废水的处理一般要投加如铁盐、铝盐、钙盐等金属沉淀剂去除','[1、生物除磷通过聚磷菌过量的吸附游离的磷，然后通过排泥（剩余污泥）的方式排出系统，达到除磷的目的。\n2、化学除磷就是添加含铁或铝的混凝剂如聚合氯化铝达到除磷的目的。]','4013'),(9,'1ada398e9f1948ec86f6d04a8a1fd2d41605529259985','站点：潼关吊桥该站点最近20条数据中，异常数据比例超过10%','从站点河津大桥为起点至当前站点潼关吊桥的流域皆发生与指标总磷相关异常，沿途流域为河津大桥->潼关吊桥。','临近企业南京A化工企业等排污totalp超标，请联系相关负责人','一、煤化工废水磷超标：煤化工废水中的磷主要来自于原料煤和水处理药剂的带入，一般煤炭中的有机磷含量很低，主要是无机磷，但由于原料煤用量巨大，远远超过水处理药剂带入的磷，最终会导致总磷超标，而无机磷超标投加除磷剂即可解决。\n二、生活污水磷超标:生活污水中的磷来源广泛，种类复杂，其中的合成洗涤剂、含磷洗衣粉、人类排泄物、废弃食物中都含有大量的磷。现在的生活污水排放量越来越大，是导致生活污水磷超标的主要原因。目前，对生活污水的总磷去除方法有生物除磷法和化学除磷法。\n三、化学镀镍废水磷超标:化学镀镍是用还原剂把溶液中的镍离子还原沉积在金属表面，而这种工艺常用的还原剂是次磷酸钠，这种工艺最终会导致废水中的次亚磷超标，这种磷的去除方法比较特殊，引起不能与传统除磷剂发生反应，从而无法去除。对于次亚磷废水，比较有效的办法是使用次亚磷去除剂HMC-P3进行处理，通过催化剂进行催化，次亚磷去除剂能够与次亚磷结合，形成均相共沉淀。\n四、磷化工废水磷超标:无机磷化工废水中含有一定量磷、氟、砷等杂质，其对环境影响较大，必须严格控制后达标排放。这也是磷化工生产企业废水处理最困难的地方。无机磷化工废水的处理一般要投加如铁盐、铝盐、钙盐等金属沉淀剂去除','[1、生物除磷通过聚磷菌过量的吸附游离的磷，然后通过排泥（剩余污泥）的方式排出系统，达到除磷的目的。\n2、化学除磷就是添加含铁或铝的混凝剂如聚合氯化铝达到除磷的目的。]','4014'),(10,'f79832f13d1644d48d4b44c843d957831605529260004','站点：小浪底该站点最近20条数据中，异常数据比例超过10%','上下游皆为出现异常，考虑当前站点自身原因。',NULL,'高锰酸盐指数，代表水样中可被高锰酸钾氧化的还原性物质（主要是有机污染物版）的总量，用权O2的mg/L数来表示，非常类似于化学需氧量（CODCr）。高锰酸盐指数越高，说明水体受到有机物污染的程度越严重。 这是水体中含氮有机物进一步氧化，在变成硝酸盐过程中的中间产物。水中存在亚硝酸盐时表明有机物的分解过程还在继续进行，亚硝酸盐的含量如太高，即说明水中有机物的无机化过程进行的相当强烈，表示污染的危险性仍然存在。','[首先，如果是取的浅层地下水，且地下水补给主要是降水补给，则浅层地下水受地面农业灌溉的影响（施氮肥等）、或生活污染的可能性较大，另外，如果在勘察孔取水，地下水取水过程中应进行抽水，待抽水孔重新注水后及时取水样方具代表性，如果取的是勘察孔滞水，则很可能超标。其次，如果取的是深层地下水，且取水层上部有良好的隔水层，则因该分析该层水的补给源 ，分析其补给情况，给出超标原因。]','4015'),(11,'621733c7a35c4a44b131778c892ce0271605529260024','站点：界首该站点最近20条数据中，异常数据比例超过10%','上下游皆为出现异常，考虑当前站点自身原因。',NULL,'1.氧气在水中的溶解度随水温升高而降低,高温会引起水体中溶解氧降低。\n2.养殖密度过大。水体中众多生物的呼吸作用增加,生物耗氧量也增大。\n3.池塘中含有大量的有机物。有机物越多,细菌就越话跃,这种有机物的分解过程通常要消耗大量的氧才能进行,因此,容易造成缺氧。\n4.无机物的氧化作用。水中存在如硫化氢亚硝酸盐等无机物时,会发生氧化作用消耗大量的溶解氧。','[1.经常注入新水,并使用增氧机。\n2.经常泼洒微生物水质改良剂(如增氧底保净、光合细菌、水好等)。\n3.缺氧浮头时泼洒增氧剂(富氧、久久氧)。\n4.控制池塘里浮游动植物的数量。使用鑫铜、克藻抑制浮游植物的繁殖,使用鑫洋混杀威、鑫洋水蛛威、鑫洋双爱威等杀灭浮游动物。]','4017');
/*!40000 ALTER TABLE `err_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ets_sta`
--

DROP TABLE IF EXISTS `ets_sta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ets_sta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(32) NOT NULL,
  `eid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `sid` (`sid`),
  KEY `eid` (`eid`),
  CONSTRAINT `ets_sta_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `station` (`id`),
  CONSTRAINT `ets_sta_ibfk_2` FOREIGN KEY (`eid`) REFERENCES `enp` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ets_sta`
--

LOCK TABLES `ets_sta` WRITE;
/*!40000 ALTER TABLE `ets_sta` DISABLE KEYS */;
INSERT INTO `ets_sta` VALUES (4,'4013',20001),(5,'4014',20002);
/*!40000 ALTER TABLE `ets_sta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flow_direction`
--

DROP TABLE IF EXISTS `flow_direction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flow_direction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `upstream_id` varchar(32) NOT NULL,
  `downstream_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flow_direction`
--

LOCK TABLES `flow_direction` WRITE;
/*!40000 ALTER TABLE `flow_direction` DISABLE KEYS */;
/*!40000 ALTER TABLE `flow_direction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history_list`
--

DROP TABLE IF EXISTS `history_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `history_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `create_time` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history_list`
--

LOCK TABLES `history_list` WRITE;
/*!40000 ALTER TABLE `history_list` DISABLE KEYS */;
INSERT INTO `history_list` VALUES (1,'2019-11-29水质自动监测周报','2019-11-29');
/*!40000 ALTER TABLE `history_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history_record`
--

DROP TABLE IF EXISTS `history_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `history_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `curr_level` int(11) NOT NULL,
  `pre_level` int(11) NOT NULL,
  `responsible` varchar(32) NOT NULL,
  `did` varchar(32) NOT NULL,
  `dname` varchar(32) NOT NULL,
  `create_time` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history_record`
--

LOCK TABLES `history_record` WRITE;
/*!40000 ALTER TABLE `history_record` DISABLE KEYS */;
INSERT INTO `history_record` VALUES (1,'001','玄武湖菱州',2,3,'test1','001','玄武湖片区','2019-11-29'),(2,'003','玄武湖东湖',4,3,'test1','001','玄武湖片区','2019-11-29'),(3,'004','玄武湖北湖',3,2,'test1','001','玄武湖片区','2019-11-29'),(4,'005','玄武湖牡丹岛',2,3,'test1','001','玄武湖片区','2019-11-29'),(5,'002','石臼湖',1,2,'test2','002','石臼湖片区','2019-11-29'),(6,'006','石臼湖2',3,3,'test2','002','石臼湖片区','2019-11-29');
/*!40000 ALTER TABLE `history_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `knowledge`
--

DROP TABLE IF EXISTS `knowledge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `knowledge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `entity` varchar(32) NOT NULL,
  `entity_type` varchar(32) NOT NULL,
  `relation` varchar(32) NOT NULL,
  `entity_value` varchar(2000) NOT NULL,
  `node_desc` varchar(2000) DEFAULT NULL,
  `entity_index` varchar(2000) DEFAULT NULL,
  `ambiguous` varchar(200) DEFAULT NULL,
  `entity_id` int(32) DEFAULT NULL,
  `value_id` int(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knowledge`
--

LOCK TABLES `knowledge` WRITE;
/*!40000 ALTER TABLE `knowledge` DISABLE KEYS */;
INSERT INTO `knowledge` VALUES (1,'中国地表水水质标准','knowledge','内容','Ⅰ类水',NULL,NULL,NULL,1,2),(2,'Ⅰ类水','knowledge','溶解氧','≥7.5',NULL,NULL,NULL,2,3);
/*!40000 ALTER TABLE `knowledge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `url` varchar(200) NOT NULL,
  `path` varchar(200) NOT NULL,
  `component` varchar(200) NOT NULL,
  `title` varchar(200) NOT NULL,
  `iconCls` varchar(200) DEFAULT NULL,
  `keepAlive` tinyint(1) NOT NULL,
  `parentId` int(11) DEFAULT NULL,
  `requireAuth` int(11) NOT NULL,
  `enable` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (0,'/','/dashboard','dashboard','all',NULL,1,NULL,1,1),(1,'/','/dashboard','dashboard','用户管理',NULL,1,0,1,1),(2,'/','/dashboard','dashboard','数据展示',NULL,1,0,1,1),(3,'/sys/user/**','/userManager/authContol','authControl','权限控制',NULL,1,1,1,1),(4,'/data/basic/**','/dataRelated/equipList','checkData','数据详情',NULL,1,2,1,1),(5,'/sys/menu/**','/userManager/menuConfig','menuConfig','菜单配置',NULL,1,1,1,1),(6,'/user/basic/**','/dashboard','dashboard','userbasic',NULL,1,0,0,0),(7,'/data/basic/**','/dataRelated/equipList/dataDetails/:id','dataDetails','dataDetails',NULL,1,2,1,0),(8,'/data/basic/**','/dataRelated/map','map','站点地图',NULL,1,2,1,1),(9,'/','dashboard','dashboard','消息',NULL,1,0,1,1),(10,'/msg/basic/**','/msg/posting','posting','发送消息',NULL,1,9,1,1),(11,'/msg/basic/**','/msg/readablePost','readablePost','消息列表',NULL,1,9,1,1),(12,'/sys/msg/**','/msg/review','review','消息审查',NULL,1,9,1,1),(13,'/msg/basic/**','/msg/postDetail/:id','postDetail','postDetail',NULL,1,9,1,0),(14,'/','dashboard','dashboard','报告',NULL,1,0,1,1),(15,'/report/basic/**','/report/reportList','reportList','报告列表',NULL,1,14,1,1),(16,'/report/basic/**','/report/reportDeatils/:createTime','reportDetails','reportDetails',NULL,1,14,1,0),(17,'/','/dashboard','dashboard','异常处理',NULL,1,0,1,1),(18,'/algo/basic/**','/algo/anomalyMonitoring','isoForest','异常监控',NULL,1,17,1,1),(19,'/','/dashboard','dashboard','非用户管理',NULL,1,0,1,1),(20,'/sys/data/**','/manager/stationManager','stationManager','站点管理',NULL,1,19,1,1),(21,'/sys/data/**','/manager/districtManager','districtManager','区域管理',NULL,1,19,1,1),(22,'/sys/data/**','/manager/equipManager','equipManager','设备管理',NULL,1,19,1,1),(23,'/','/dashboard','dashboard','知识图谱',NULL,1,0,1,1),(24,'/kg/**','/kg/showKg','showKg','知识图谱展示',NULL,1,23,1,1),(25,'/algo/basic/**','/algo/errRecord','errRecord','异常记录',NULL,1,17,1,1),(26,'/sys/data/**','/manager/provinceManager','provinceManager','省市管理',NULL,1,19,1,1),(27,'/sys/data/**','/manager/enterpriseManager','enterpriseManager','企业管理',NULL,1,19,1,1),(28,'/kg/**','/kg/ner','ner','实体识别',NULL,1,23,1,1),(29,'/kg/**','/kg/qa','qa','知识问答',NULL,1,23,1,1),(30,'/kg/**','/kg/relationExtract','relationExtract','关系抽取',NULL,1,23,1,1),(31,'/kg/**','/kg/kgManager','kgManager','知识图谱管理',NULL,1,23,1,1);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `msg`
--

DROP TABLE IF EXISTS `msg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `msg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `postId` varchar(200) NOT NULL,
  `title` varchar(50) NOT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `imgList` varchar(2000) DEFAULT NULL,
  `isEmergency` int(11) NOT NULL,
  `isReviewd` int(11) NOT NULL,
  `postTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `type` varchar(32) NOT NULL,
  `uid` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `postId` (`postId`),
  KEY `uid` (`uid`),
  CONSTRAINT `msg_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `msg`
--

LOCK TABLES `msg` WRITE;
/*!40000 ALTER TABLE `msg` DISABLE KEYS */;
INSERT INTO `msg` VALUES (48,'7a328021afbc446e87bfe7c4487f76271574669482776','111','111','',0,1,'2019-11-25 00:11:23','','test1'),(49,'34e0870d173c42b3ac1d28fd91ff87951574669874599','client test','client test','',0,1,'2019-11-25 00:17:55','','test2'),(50,'89d70fdab63648d6a20104647d7ffcbd1574670154709','admin test','admin test','',0,1,'2019-11-25 00:22:35','','test1'),(51,'37415f0d443c43b1b8907ab15fc4d0261574672157752','珂朵莉祈求无BUG','我是珂学家，BUG全没啦','/static/d1148cebb5804b46b4e1eaa163fb44c5.jpg',0,1,'2019-11-25 00:55:58','','test2'),(52,'a988b5947e6e4c2cb9b87e576fa9a1181574672321609','这是一条永远的not review 消息','谁也发现不了我~','/static/8de7933c92e64ba69ba04e90aea7aa6e.jpg',0,0,'2019-11-25 00:58:42','其他','test1'),(53,'ecbbe95e8943440c820b57e5100b155c1582005063949','测试','没啥形式','/static/7745050b1fca46d19ace94fbfb6fc48e.png,/static/39df9e677675444e92c6e9a679296d7c.jpg',1,1,'2020-02-17 21:51:04','设备故障','test1'),(54,'3d21d1ccd00545528ed54cd02c60920d1582007648532','XXX站点水质出现严重问题，如何解决？','如题，求解','',0,1,'2020-02-17 22:34:09','水质异常','test1'),(55,'0c3abfa4b1af4e37994e1af9c6dc79d71582007949881','水质富营养化','水质富营养化如何解决？？','/static/aaa20b518eea4e43af38746df269ccde.png',0,1,'2020-02-17 22:39:10','水质异常','test1'),(56,'18afe2f904d84ea185064633152440651582346061942','loadrunner tst','loadrunner  tst','',0,1,'2020-02-21 20:34:22','其他','test1'),(57,'154bbe90473a4342861149e1bf9f48ef1582346395787','哈哈哈哈','垃圾load rununer','',0,1,'2020-02-21 20:39:56','其他','test1'),(58,'8ec042cf49b04b25a59c4cb3dddb43d41582346889739','发一个贴子吧，求审核通过','管理员大大网开一面','',0,1,'2020-02-21 20:48:10','其他','test2'),(59,'e0ed0782e0c84eed94629d029d98d2dd1589183679289','我胡汉三又回来了','一身败绩的归来','/static/f79008d650d542b58b8fe3a4b854c47e.jpg',1,1,'2020-05-10 23:54:39','其他','test1'),(60,'05def1a58fdf49ccacf072ef13a65c3b1592721809246','目前，连挂三家！','越挫越勇~永远不灰心','',0,1,'2020-06-20 22:43:29','其他','test1'),(61,'198d84a514d9486390a80d88541a7c701593768405064','张子豪：这是我爸爸','我爸爸帅不帅','/static/2d030644ef9b4f649510937dee826020.JPG',1,1,'2020-07-03 01:26:45','其他','test1'),(62,'6e9809775322421b926d7afce537ea4c1597204130124','彪哥，你好帅','真的帅','',1,1,'2020-08-11 19:48:50','','test2'),(63,'8887dfd00b424e659acb4cbf606d25bf1602644207412','王彦，吃屎了吧','屎王，王彦','',1,1,'2020-10-13 18:56:47','水质异常','test1'),(64,'d371c1cb2f324fd8b33bf8b630432b511604280285449','测试','测试','',1,1,'2020-11-01 17:24:45','设备故障','test1'),(65,'f45e9b0937b24af897d5267e5b3553cb1604280606509','测试1','测试','',1,0,'2020-11-01 17:30:07','设备故障','test1'),(66,'8f2791c7b8cc4c17a6469058990441451604738804563','老葛  摸摸几把','摸摸','',0,1,'2020-11-07 00:46:45','设备故障','test1');
/*!40000 ALTER TABLE `msg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `msg_user`
--

DROP TABLE IF EXISTS `msg_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `msg_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` varchar(200) NOT NULL,
  `uid` varchar(32) NOT NULL,
  `is_read` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mid` (`mid`),
  KEY `uid` (`uid`),
  CONSTRAINT `msg_user_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `msg` (`postId`),
  CONSTRAINT `msg_user_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `msg_user`
--

LOCK TABLES `msg_user` WRITE;
/*!40000 ALTER TABLE `msg_user` DISABLE KEYS */;
INSERT INTO `msg_user` VALUES (39,'34e0870d173c42b3ac1d28fd91ff87951574669874599','test2',1),(40,'89d70fdab63648d6a20104647d7ffcbd1574670154709','test1',1),(41,'89d70fdab63648d6a20104647d7ffcbd1574670154709','test2',1),(43,'37415f0d443c43b1b8907ab15fc4d0261574672157752','test2',1),(44,'a988b5947e6e4c2cb9b87e576fa9a1181574672321609','test1',1),(45,'ecbbe95e8943440c820b57e5100b155c1582005063949','admin',0),(48,'3d21d1ccd00545528ed54cd02c60920d1582007648532','admin',0),(49,'3d21d1ccd00545528ed54cd02c60920d1582007648532','test1',1),(51,'0c3abfa4b1af4e37994e1af9c6dc79d71582007949881','admin',0),(52,'0c3abfa4b1af4e37994e1af9c6dc79d71582007949881','test1',1),(54,'18afe2f904d84ea185064633152440651582346061942','admin',0),(57,'154bbe90473a4342861149e1bf9f48ef1582346395787','admin',0),(60,'8ec042cf49b04b25a59c4cb3dddb43d41582346889739','admin',1),(63,'e0ed0782e0c84eed94629d029d98d2dd1589183679289','admin',0),(66,'e0ed0782e0c84eed94629d029d98d2dd1589183679289','test3',0),(67,'05def1a58fdf49ccacf072ef13a65c3b1592721809246','admin',0),(70,'05def1a58fdf49ccacf072ef13a65c3b1592721809246','test3',0),(71,'198d84a514d9486390a80d88541a7c701593768405064','admin',0),(73,'198d84a514d9486390a80d88541a7c701593768405064','test3',0),(75,'6e9809775322421b926d7afce537ea4c1597204130124','admin',0),(77,'6e9809775322421b926d7afce537ea4c1597204130124','test3',0),(78,'6e9809775322421b926d7afce537ea4c1597204130124','test2',1),(79,'8887dfd00b424e659acb4cbf606d25bf1602644207412','admin',0),(81,'8887dfd00b424e659acb4cbf606d25bf1602644207412','test3',0),(83,'d371c1cb2f324fd8b33bf8b630432b511604280285449','admin',0),(84,'d371c1cb2f324fd8b33bf8b630432b511604280285449','test1',1),(85,'d371c1cb2f324fd8b33bf8b630432b511604280285449','test3',0),(87,'f45e9b0937b24af897d5267e5b3553cb1604280606509','admin',0),(88,'f45e9b0937b24af897d5267e5b3553cb1604280606509','test1',1),(89,'f45e9b0937b24af897d5267e5b3553cb1604280606509','test3',0),(90,'8f2791c7b8cc4c17a6469058990441451604738804563','admin',0),(92,'8f2791c7b8cc4c17a6469058990441451604738804563','test3',0);
/*!40000 ALTER TABLE `msg_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `province`
--

DROP TABLE IF EXISTS `province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `province` (
  `id` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `province`
--

LOCK TABLES `province` WRITE;
/*!40000 ALTER TABLE `province` DISABLE KEYS */;
INSERT INTO `province` VALUES (8601,'北京市'),(8602,'上海市'),(8603,'天津市'),(8604,'重庆市'),(8605,'河北省'),(8606,'山西省'),(8607,'内蒙古自治区'),(8608,'辽宁省'),(8609,'吉林省'),(8610,'黑龙江省'),(8611,'江苏省'),(8612,'浙江省'),(8613,'安徽省'),(8614,'江西省'),(8615,'山东省'),(8616,'河南省'),(8617,'湖北省'),(8618,'广西壮族自治区'),(8619,'四川省'),(8620,'云南省'),(8621,'陕西省'),(8622,'甘肃省'),(8623,'宁夏回族自治区'),(8624,'湖南省'),(8625,'广东省');
/*!40000 ALTER TABLE `province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record_report`
--

DROP TABLE IF EXISTS `record_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `record_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `record_id` varchar(200) NOT NULL,
  `report_id` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `record_id` (`record_id`),
  KEY `report_id` (`report_id`),
  CONSTRAINT `record_report_ibfk_1` FOREIGN KEY (`record_id`) REFERENCES `err_record` (`record_id`),
  CONSTRAINT `record_report_ibfk_2` FOREIGN KEY (`report_id`) REFERENCES `err_report` (`report_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record_report`
--

LOCK TABLES `record_report` WRITE;
/*!40000 ALTER TABLE `record_report` DISABLE KEYS */;
INSERT INTO `record_report` VALUES (3,'cd8151a51f634be8a5091f014db3f8081605529250768','03bd8c357bc342079264fc7d494b09411605529259806'),(4,'14a64181998e4b6786ad1db57bdca4081605529252705','6efd742678604a2f89b248bf14732a9d1605529259845'),(5,'49da1ef319794e869f6b2ccba6815a361605529253705','d7ee2f7c91574f049668fd5c66d58f571605529259872'),(6,'a88cac3d82e343a98ef984f0cae486341605529255039','c1f998719f5e4029a01d4ede449412321605529259894'),(7,'527096c1fb6846d4b12954752517a3671605529255307','4f87bf30eb9d495b834693f3ffc5c6251605529259916'),(8,'f0e91ae2f944453abf0f34e11b95c13b1605529255823','8ec72a86ca9c400c8ac7d221293ce0a71605529259935'),(9,'f393219c39af4180a3c447c7b3f851721605529256714','6a49de7e332b48e3a5e3d98f9b0011321605529259956'),(10,'7abbfe39cff34f0abf39b42c5a89f1071605529257141','1ada398e9f1948ec86f6d04a8a1fd2d41605529259985'),(11,'eb979791d50349acb4c261edf8279d951605529257663','f79832f13d1644d48d4b44c843d957831605529260004'),(12,'3bb7a325c4944d478081c81a903613d91605529258260','621733c7a35c4a44b131778c892ce0271605529260024');
/*!40000 ALTER TABLE `record_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reply_id` varchar(200) NOT NULL,
  `content` varchar(10000) NOT NULL,
  `img_list` varchar(2000) DEFAULT NULL,
  `reply_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `uid` varchar(32) NOT NULL,
  `post_id` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `reply_id` (`reply_id`),
  KEY `uid` (`uid`),
  KEY `post_id` (`post_id`),
  CONSTRAINT `reply_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`userId`),
  CONSTRAINT `reply_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `msg` (`postId`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
INSERT INTO `reply` VALUES (1,'f319106afb12466bbeccdf6f683abf981582001669266','<h2><span style=\"font-weight: bold;\">reply test</span></h2>',NULL,'2020-02-17 20:54:29','test1','89d70fdab63648d6a20104647d7ffcbd1574670154709'),(2,'2d299d566e6146dbacf1b680fd08f3771582007735575','<p>你可从以下几点分析：</p><ol><li>查看设备是否异常</li><li>查看上下游水质是否异常</li><li>可以查看附近工厂最近的废水排放量</li></ol>',NULL,'2020-02-17 22:35:36','test1','3d21d1ccd00545528ed54cd02c60920d1582007648532'),(3,'517174e0388f44dda07cbc9bb9c609731582008140379','<p><span style=\"font-size: 1rem;\">水体富营养化的防治对策</span><br></p><p><br>一、控制外源性营养物质输入<br><br>二、减少内源性营养物质负荷<br><br>★ 投放水生动物：螺、蚌等<a href=\"https://www.baidu.com/s?wd=%E5%BA%95%E6%A0%96%E5%8A%A8%E7%89%A9&amp;tn=SE_PcZhidaonwhc_ngpagmjz&amp;rsv_dl=gh_pc_zhidao\" target=\"_blank\">底栖动物</a>可过滤悬浮物质，摄食生物碎屑，其分泌物有絮凝作用，螺有刮食着生藻类功能，虾和若干种类鱼类可摄食藻类、碎屑、<a href=\"https://www.baidu.com/s?wd=%E6%B5%AE%E6%B8%B8%E5%8A%A8%E7%89%A9&amp;tn=SE_PcZhidaonwhc_ngpagmjz&amp;rsv_dl=gh_pc_zhidao\" target=\"_blank\">浮游动物</a>等。这些动物，作为健康水生态系统的补充组成，也有重要作用。 根据水体的特定环境，投放相适应的水生动物，如鱼类、<a href=\"https://www.baidu.com/s?wd=%E5%BA%95%E6%A0%96%E5%8A%A8%E7%89%A9&amp;tn=SE_PcZhidaonwhc_ngpagmjz&amp;rsv_dl=gh_pc_zhidao\" target=\"_blank\">底栖动物</a>。<br><br>★ 建立人工生态体系：人工生态系统利用种植水生植物、养鱼、养鸭、养鹅等形成多条食物链。其中不仅有分解者生物、生产者生物、还有消费者生物，三者分工协作，对污水中的污染物进行更有效的处理与利用，并由此可形成许多条食物链，构成纵横交错的食物网生态系统。如果在各营养级之间保持适宜的数量比和能量比，就可建立良好的生态平衡系统。当一定量的污水进入这种生态塘中，其中的有机污染物不仅被细菌和真菌降解净化，而其降解的最终产物，一些无机化合物作为碳源、氮源和磷源，以太阳能为初始能源，参与食物网中的新陈代谢过程，并从低营养级到高营养级逐级迁移转化，最后转变成水生作物、鱼、虾、蚌、鹅、鸭等产物,人们不仅可以不断的取走这些增殖的产品，而且通过人们的不断的取走和加入的措施来保持水体的综合生态平衡，达到防治水体的富营养化的目的。&nbsp;&nbsp;<br></p>',NULL,'2020-02-17 22:42:20','test1','0c3abfa4b1af4e37994e1af9c6dc79d71582007949881'),(4,'2c4d17714a6d404ea63c716ea518db9d1582346425612','<p>楼主，是load runner把 ，不过我也觉得垃圾</p>',NULL,'2020-02-21 20:40:26','test1','154bbe90473a4342861149e1bf9f48ef1582346395787'),(5,'9cb74455f13c4e53a7d2d4e4d60e2a2b1582346435788','',NULL,'2020-02-21 20:40:36','test1','154bbe90473a4342861149e1bf9f48ef1582346395787'),(6,'4890d0b25d524d3d8a3594ab526761731582346476363','<p>3L，你说的什么</p>',NULL,'2020-02-21 20:41:16','test2','154bbe90473a4342861149e1bf9f48ef1582346395787'),(7,'17410b6293254ae99692fc36b3f8ade41582346505369','<p>不文明的字会被过滤吗</p>',NULL,'2020-02-21 20:41:45','test2','18afe2f904d84ea185064633152440651582346061942'),(8,'4950ce61144840bda8d382f53b57e0db1582346510694','<p>草泥马</p>',NULL,'2020-02-21 20:41:51','test2','18afe2f904d84ea185064633152440651582346061942'),(9,'b55afb232097426a83324b0135805c5b1582346517426','<p>奇了怪了</p>',NULL,'2020-02-21 20:41:57','test2','18afe2f904d84ea185064633152440651582346061942'),(10,'cc425a61fa6a47b19bf2766768c745f91582346951946','<p><span style=\"font-weight: bold;\">38张亮，有脸发帖子？？？</span></p>',NULL,'2020-02-21 20:49:12','admin','8ec042cf49b04b25a59c4cb3dddb43d41582346889739'),(11,'5480640a3b254ffabd21e6e1530968ad1582347141042','<p>hehe<br></p>',NULL,'2020-02-21 20:52:21','test1','8ec042cf49b04b25a59c4cb3dddb43d41582346889739'),(12,'04259b6b00cf45fd9fddfde979b19d111582347154506','<p>qiguai<br></p>',NULL,'2020-02-21 20:52:35','test1','8ec042cf49b04b25a59c4cb3dddb43d41582346889739'),(13,'a7e98b63e02b4dbe9b996ff80d527af51589183717485','<p>图挂了？</p>',NULL,'2020-05-10 23:55:17','test1','e0ed0782e0c84eed94629d029d98d2dd1589183679289'),(14,'671f7bbd857d49e29393df90d611619d1592188584412','<p>sb</p>',NULL,'2020-06-14 18:36:24','test1','0c3abfa4b1af4e37994e1af9c6dc79d71582007949881'),(15,'ea08ba8be37b4f2fba68c9e8cfeca76e1592721835327','<p>努力努力，越努力越幸运！</p>',NULL,'2020-06-20 22:43:55','test1','05def1a58fdf49ccacf072ef13a65c3b1592721809246'),(16,'e1facce949c44a00a15cd0f4fb226bc81593768433033','<p>帅</p>',NULL,'2020-07-03 01:27:13','test1','198d84a514d9486390a80d88541a7c701593768405064'),(17,'1b8fdd2f70444eae929dffef4b7ec7dd1593768462897','<p>张子豪是</p>',NULL,'2020-07-03 01:27:43','test1','0c3abfa4b1af4e37994e1af9c6dc79d71582007949881'),(18,'573df795bfc449dca62fbbb4b46dbd101593768472642','<p>SB</p>',NULL,'2020-07-03 01:27:53','test1','0c3abfa4b1af4e37994e1af9c6dc79d71582007949881'),(19,'a17e339f4c934b5ab64f109615d0f6321593768484106','<p>张子豪是SB</p>',NULL,'2020-07-03 01:28:04','test1','0c3abfa4b1af4e37994e1af9c6dc79d71582007949881'),(20,'c36ca429b3e14258adec06490ac002881597204172809','<p>k</p>',NULL,'2020-08-11 19:49:33','test1','6e9809775322421b926d7afce537ea4c1597204130124'),(21,'3354def93f424c08a3a39501aa10dee81597204178872','<p>？？？</p>',NULL,'2020-08-11 19:49:39','test1','6e9809775322421b926d7afce537ea4c1597204130124'),(22,'177caefbbc8e48a5a0240436c9e8d3f41602644223133','<p>真恶心</p>',NULL,'2020-10-13 18:57:03','test1','8887dfd00b424e659acb4cbf606d25bf1602644207412'),(23,'b208c3b9f43b48af9a049964971cc1111604738821726','<p>不给摸</p>',NULL,'2020-11-07 00:47:02','test1','8f2791c7b8cc4c17a6469058990441451604738804563');
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `roleId` varchar(32) NOT NULL,
  `role_name` varchar(32) NOT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('001','ROLE_CLIENT'),('002','ROLE_VISITOR'),('777','ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_back`
--

DROP TABLE IF EXISTS `role_back`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_back` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(32) NOT NULL,
  `back_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `back_id` (`back_id`),
  CONSTRAINT `role_back_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`roleId`),
  CONSTRAINT `role_back_ibfk_2` FOREIGN KEY (`back_id`) REFERENCES `backendresources` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_back`
--

LOCK TABLES `role_back` WRITE;
/*!40000 ALTER TABLE `role_back` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_back` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_menu`
--

DROP TABLE IF EXISTS `role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(32) NOT NULL,
  `menu_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `menu_id` (`menu_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `role_menu_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`),
  CONSTRAINT `role_menu_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=484 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_menu`
--

LOCK TABLES `role_menu` WRITE;
/*!40000 ALTER TABLE `role_menu` DISABLE KEYS */;
INSERT INTO `role_menu` VALUES (184,'001',4),(185,'001',7),(186,'001',8),(187,'001',10),(188,'001',11),(189,'001',13),(190,'001',15),(191,'001',16),(195,'001',18),(461,'777',3),(462,'777',5),(463,'777',4),(464,'777',7),(465,'777',8),(466,'777',10),(467,'777',11),(468,'777',12),(469,'777',13),(470,'777',15),(471,'777',16),(472,'777',18),(473,'777',25),(474,'777',20),(475,'777',21),(476,'777',22),(477,'777',26),(478,'777',27),(479,'777',24),(480,'777',28),(481,'777',29),(482,'777',30),(483,'777',31);
/*!40000 ALTER TABLE `role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station`
--

DROP TABLE IF EXISTS `station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `station` (
  `id` varchar(32) NOT NULL,
  `name` varchar(200) NOT NULL,
  `longtitude` double NOT NULL,
  `latitude` double NOT NULL,
  `currLevel` int(11) DEFAULT NULL,
  `preLevel` int(11) DEFAULT NULL,
  `responsible` varchar(32) DEFAULT NULL,
  `upstream_id` varchar(32) DEFAULT NULL,
  `downstream_id` varchar(32) DEFAULT NULL,
  `is_alert` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station`
--

LOCK TABLES `station` WRITE;
/*!40000 ALTER TABLE `station` DISABLE KEYS */;
INSERT INTO `station` VALUES ('4001','急水港桥',120.728387,31.065884,2,3,'test1','','',1),('4002','林山',118.53752,31.924712,2,3,'test1','null','4001',0),('4003','三江营',119.716451,32.326611,2,3,'test1','4002','4001',0),('4004','皖河口',117.007032,30.514094,1,3,'test2','null','4002',0),('4005','蛤蟆石',116.141209,29.613241,4,4,'test3','','',1),('4006','宗关',114.230694,30.586636,3,5,'test2','null','4005',0),('4007','城陵矶',113.155362,29.441517,3,3,'test2','null','4006',1),('4008','朱沱',105.85829,29.018593,2,1,'test2','null','4007',0),('4009','沱江大桥',105.423024,28.90261,2,3,'test2','null','4008',0),('4010','新城桥',103.491814,36.176026,3,3,'test3','null','null',1),('4011','中卫下河',105.067334,37.458789,1,1,'test3','4010','null',1),('4012','画匠营子',109.93993,40.541363,2,2,'test3','4011','null',1),('4013','河津大桥',110.611575,35.665753,5,3,'test3','','',1),('4014','潼关吊桥',110.230557,34.616997,3,5,'test3','4013','null',1),('4015','小浪底',112.391851,34.926958,2,3,'test3','4014','null',1),('4016','泺口',117.000769,36.725994,5,3,'test3','','',0),('4017','界首',110.777503,25.725741,4,3,'test2','','',1),('4018','七星岗',113.342904,23.099618,4,2,'test2','','',0),('4019','松花江村',126.169509,44.748468,2,1,'test1','null','null',0),('4020','乌苏镇',134.688019,48.267263,1,1,'test1','null','4019',0);
/*!40000 ALTER TABLE `station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station_district`
--

DROP TABLE IF EXISTS `station_district`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `station_district` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(32) NOT NULL,
  `did` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `sid` (`sid`),
  KEY `did` (`did`),
  CONSTRAINT `station_district_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `station` (`id`),
  CONSTRAINT `station_district_ibfk_2` FOREIGN KEY (`did`) REFERENCES `district` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station_district`
--

LOCK TABLES `station_district` WRITE;
/*!40000 ALTER TABLE `station_district` DISABLE KEYS */;
INSERT INTO `station_district` VALUES (6,'4001','001'),(7,'4002','001'),(8,'4003','001'),(9,'4004','001'),(10,'4005','001'),(11,'4006','001'),(12,'4007','001'),(13,'4008','001'),(14,'4009','001'),(15,'4010','002'),(16,'4011','002'),(17,'4012','002'),(18,'4013','002'),(19,'4014','002'),(20,'4015','002'),(21,'4016','002'),(22,'4017','003'),(23,'4018','003'),(24,'4019','004'),(25,'4020','004');
/*!40000 ALTER TABLE `station_district` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station_province`
--

DROP TABLE IF EXISTS `station_province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `station_province` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(32) NOT NULL,
  `pid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `sid` (`sid`),
  KEY `pid` (`pid`),
  CONSTRAINT `station_province_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `station` (`id`),
  CONSTRAINT `station_province_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `province` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station_province`
--

LOCK TABLES `station_province` WRITE;
/*!40000 ALTER TABLE `station_province` DISABLE KEYS */;
INSERT INTO `station_province` VALUES (6,'4001',8602),(7,'4002',8611),(8,'4003',8611),(9,'4004',8613),(10,'4005',8614),(11,'4006',8617),(12,'4007',8624),(13,'4008',8604),(14,'4009',8619),(15,'4010',8622),(16,'4011',8623),(17,'4012',8607),(18,'4013',8606),(19,'4014',8621),(20,'4015',8616),(21,'4016',8615),(22,'4017',8618),(23,'4018',8625),(24,'4019',8609),(25,'4020',8610);
/*!40000 ALTER TABLE `station_province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` varchar(32) NOT NULL,
  `pwd` varchar(32) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin','whl6785968'),('test1','666'),('test2','456'),('test3','789');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL,
  `user_id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`userId`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (0,'test1','777'),(1,'test2','001'),(2,'test3','777'),(4,'admin','777');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_station`
--

DROP TABLE IF EXISTS `user_station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_station` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(32) NOT NULL,
  `sid` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `sid` (`sid`),
  CONSTRAINT `user_station_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`userId`),
  CONSTRAINT `user_station_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `station` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_station`
--

LOCK TABLES `user_station` WRITE;
/*!40000 ALTER TABLE `user_station` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `sex` varchar(32) NOT NULL,
  `age` int(11) NOT NULL,
  `avatar` varchar(2000) DEFAULT NULL,
  `link` varchar(32) NOT NULL,
  `salt` varchar(2000) DEFAULT NULL,
  `descr` varchar(2000) DEFAULT NULL,
  `token` varchar(2000) DEFAULT NULL,
  `uid` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `userinfo_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (1,'sandalen','男',23,'','18245803818','','管理员','eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJ0ZXN0MSJ9.zGd9L-2XBTqoLguVWBLJ6vVWCHc87-5GWMOCgzAQhPg','test1'),(2,'张亮','女',23,'','18245803818','','38','eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJ0ZXN0MiJ9.5TLb7DPdlxoohVjiWfgLXXGqVJhbG2_FMA6PBRVVHoI','test2'),(3,'alex','男',22,'','18245803818','','visitor','eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJ0ZXN0MyJ9.SVav238wwQmnXEwuUmj7B2ZERA9iS0EYSEq67lf_GFM','test3'),(4,'系统','女',0,NULL,'18245803818',NULL,'系统','eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhZG1pbiJ9.VCNbPfR9_uzwkLRV-JLpysxfM47683wv1lf8tcfrNjU','admin');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usersecurityinfo`
--

DROP TABLE IF EXISTS `usersecurityinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usersecurityinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `locked` int(11) NOT NULL,
  `enabled` int(11) NOT NULL,
  `attemped` int(11) DEFAULT '0',
  `isAccountExpired` int(11) DEFAULT NULL,
  `createdTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `uid` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `usersecurityinfo_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usersecurityinfo`
--

LOCK TABLES `usersecurityinfo` WRITE;
/*!40000 ALTER TABLE `usersecurityinfo` DISABLE KEYS */;
INSERT INTO `usersecurityinfo` VALUES (1,0,1,0,0,'2019-11-15 01:56:45','test1'),(2,0,1,0,0,'2019-11-15 01:56:45','test2'),(3,0,1,0,0,'2020-02-16 03:14:50','admin');
/*!40000 ALTER TABLE `usersecurityinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `waterdata`
--

DROP TABLE IF EXISTS `waterdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `waterdata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ph` double DEFAULT '0',
  `disslove` double DEFAULT '0',
  `nh` double DEFAULT '0',
  `kmno` double DEFAULT '0',
  `totalp` double DEFAULT '0',
  `create_tame` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `eid` varchar(200) NOT NULL,
  `level` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `eid` (`eid`),
  CONSTRAINT `waterdata_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `equipment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waterdata`
--

LOCK TABLES `waterdata` WRITE;
/*!40000 ALTER TABLE `waterdata` DISABLE KEYS */;
INSERT INTO `waterdata` VALUES (1,8.3,8.67,0.037,2.76,0.018,'2020-11-09 10:55:02','00202440000000001',2),(2,7.86,10.53,0.067,4.66,0.072,'2020-11-09 10:56:02','00202440000000001',3),(4,7.65,5.2,0.085,2.63,0.074,'2020-11-09 10:58:02','00202440000000001',3),(5,8.51,10.94,0.025,4.94,0.034,'2020-11-09 10:59:02','00202440000000001',3),(6,7.53,6.52,0.025,2.7,0.052,'2020-11-09 11:00:02','00202440000000001',2),(7,7.48,9.08,0.025,2.86,0.084,'2020-11-09 11:01:02','00202440000000001',2),(8,8,9.17,0.027,1.96,0.009,'2020-11-09 11:02:02','00202440000000001',1),(9,8.2,10.99,0.22,2.2,0.022,'2020-11-09 11:03:02','00202440000000001',2),(10,7.81,8.48,0.025,0.95,0.005,'2020-11-09 11:04:02','00202440000000001',1),(11,7.7,8.63,0.025,5.91,0.099,'2020-11-09 11:05:02','00202440000000001',3),(12,8.09,10.22,0.025,2.13,0.005,'2020-11-09 11:06:02','00202440000000001',2),(13,8.05,11.69,0.12,1.16,0.005,'2020-11-09 11:07:02','00202440000000001',1),(14,8.22,9.18,0.025,2.62,0.005,'2020-11-09 11:08:02','00202440000000001',2),(15,8.39,10.18,0.025,2.67,0.005,'2020-11-09 11:09:02','00202440000000001',2),(16,8.01,8.84,0.025,1.18,0.005,'2020-11-09 11:10:02','00202440000000001',1),(17,8.39,11.03,0.349,5.15,0.071,'2020-11-09 11:11:02','00202440000000001',3),(18,7.74,9.74,0.116,1.31,0.047,'2020-11-09 11:12:02','00202440000000001',2),(19,7.94,9.43,0.15,1.37,0.007,'2020-11-09 11:13:02','00202440000000001',1),(20,8.1,7.73,0.033,3.49,0.031,'2020-11-09 11:14:02','00202440000000001',2),(21,7.97,8.27,0.117,2.71,0.037,'2020-11-09 11:15:02','00202440000000001',2),(22,8.12,9.35,0.025,1.63,0.005,'2020-11-09 11:16:02','00202440000000001',1),(23,8.41,10.62,0.037,1.71,0.005,'2020-11-09 11:17:02','00202440000000001',1),(24,8.37,9.53,0.025,3.81,0.056,'2020-11-09 11:18:02','00202440000000001',2),(26,8.42,10.24,0.166,5.97,0.08,'2020-11-09 11:20:02','00202440000000001',3),(27,8.14,7.16,0.244,5.65,0.122,'2020-11-09 11:21:02','00202440000000001',3),(39,8.24,8.76,0.302,5.78,0.042,'2020-11-09 11:33:02','00202440000000001',3),(40,8.05,8.77,0.248,3.81,0.049,'2020-11-09 11:34:02','00202440000000001',2),(41,7.85,9.92,0.046,3.11,0.053,'2020-11-09 11:35:02','00202440000000001',2),(42,7.51,10.14,0.025,1.8,0.032,'2020-11-09 11:36:02','00202440000000001',2),(43,8.27,10.49,0.29,2.25,0.063,'2020-11-09 11:37:02','00202440000000001',2),(45,8.56,9.12,0.06,2.31,0.022,'2020-11-09 11:39:02','00202440000000001',2),(46,8.43,11.05,0.026,1.49,0.023,'2020-11-09 11:40:02','00202440000000001',2),(47,8.3,9.48,0.04,0.96,0.055,'2020-11-09 11:41:02','00202440000000001',2),(48,8.58,10.5,0.025,1.68,0.008,'2020-11-09 11:42:02','00202440000000001',1),(49,8.22,6.38,0.377,4.19,0.108,'2020-11-09 11:43:02','00202440000000001',3),(50,7.74,5.82,0.081,2.66,0.048,'2020-11-09 11:44:02','00202440000000002',3),(52,8,6.88,0.025,5.42,0.173,'2020-11-09 11:46:02','00202440000000002',3),(53,7.9,8.47,0.025,1.68,0.005,'2020-11-09 11:47:02','00202440000000002',1),(54,8.21,11.74,0.025,4.65,0.04,'2020-11-09 11:48:02','00202440000000002',3),(55,7.99,10.77,0.025,0.86,0.005,'2020-11-09 11:49:02','00202440000000002',1),(56,8.68,10.52,0.025,5.29,0.067,'2020-11-09 11:50:02','00202440000000002',3),(57,8.11,11.68,0.025,3.99,0.046,'2020-11-09 11:51:02','00202440000000002',2),(58,8.19,10.5,0.025,4.48,0.037,'2020-11-09 11:52:02','00202440000000002',3),(59,7.73,7.28,0.714,4.06,0.113,'2020-11-09 11:53:02','00202440000000002',3),(60,6.62,7.85,0.545,3.45,0.043,'2020-11-09 11:54:02','00202440000000002',3),(61,7.73,10.52,0.025,0.93,0.007,'2020-11-09 11:55:02','00202440000000002',1),(62,7.96,8.3,0.028,2.87,0.005,'2020-11-09 11:56:02','00202440000000002',2),(63,7.96,9.62,0.068,2.29,0.042,'2020-11-09 11:57:02','00202440000000002',2),(64,8.53,11.02,0.232,4.64,0.077,'2020-11-09 11:58:02','00202440000000002',3),(65,8.08,10.55,0.184,3.09,0.16,'2020-11-09 11:59:02','00202440000000002',3),(66,7.78,8.46,0.266,3.49,0.094,'2020-11-09 12:00:02','00202440000000002',2),(67,8.21,12.07,0.025,2.23,0.025,'2020-11-09 12:01:02','00202440000000002',2),(68,8.09,9.93,0.025,0.78,0.018,'2020-11-09 12:02:02','00202440000000002',1),(69,8.26,12.28,0.025,1.75,0.014,'2020-11-09 12:03:02','00202440000000002',1),(70,8.26,11.56,0.191,2.2,0.091,'2020-11-09 12:04:02','00202440000000002',2),(71,8.56,13.04,0.025,2.42,0.055,'2020-11-09 12:05:02','00202440000000002',2),(72,8.42,10.83,0.025,5.03,0.046,'2020-11-09 12:06:02','00202440000000002',3),(73,8.51,12.91,0.025,2.87,0.091,'2020-11-09 12:07:02','00202440000000002',2),(74,7.35,10.43,0.102,4.71,0.11,'2020-11-09 12:08:02','00202440000000002',3),(75,8.42,10.88,0.025,1.77,0.005,'2020-11-09 12:09:02','00202440000000002',1),(76,8.42,10.82,0.025,0.97,0.005,'2020-11-09 12:10:02','00202440000000002',1),(77,7.76,8.33,0.025,1.1,0.005,'2020-11-09 12:11:02','00202440000000002',1),(79,8.3,8.97,0.025,2.16,0.005,'2020-11-09 12:13:02','00202440000000002',2),(82,8.39,11.66,0.025,1.16,0.005,'2020-11-09 12:16:02','00202440000000002',1),(83,8.29,10.45,0.025,1.63,0.005,'2020-11-09 12:17:02','00202440000000002',1),(84,8.19,10.66,0.025,3.98,0.033,'2020-11-09 12:18:02','00202440000000002',2),(85,8.44,11.12,0.025,3.38,0.057,'2020-11-09 12:19:02','00202440000000002',2),(86,7.51,10.06,0.025,1.26,0.01,'2020-11-09 12:20:02','00202440000000002',1),(89,8.39,9.88,0.103,3.74,0.047,'2020-11-09 12:23:02','00202440000000002',2),(91,7.97,9.83,0.191,3.94,0,'2020-11-09 12:25:02','00202440000000002',2),(92,8.36,10.44,0.025,2.93,0.005,'2020-11-09 12:26:02','00202440000000002',2),(97,7.89,6.77,0.095,3.43,0.005,'2020-11-09 12:31:02','00202440000000002',2),(98,8.51,10.73,0.191,3.87,0.112,'2020-11-09 12:32:02','00202440000000002',3),(99,8.42,13.21,0.025,4.4,0.049,'2020-11-09 12:33:02','00202440000000002',3),(101,8.47,9.05,0.108,4.43,0.031,'2020-11-09 12:35:02','00202440000000003',3),(103,8.16,7.31,0.025,3.48,0.025,'2020-11-09 12:37:02','00202440000000003',2),(105,8.03,6.55,0.027,4.19,0.046,'2020-11-09 12:39:02','00202440000000003',3),(107,7.79,7.76,0.417,4.84,0.191,'2020-11-09 12:41:02','00202440000000003',3),(108,8.3,9.54,0.025,1.53,0.005,'2020-11-09 12:42:02','00202440000000003',1),(109,8.35,8.46,0.025,2.07,0.005,'2020-11-09 12:43:02','00202440000000003',2),(110,7.8,8.03,0.025,2.24,0.082,'2020-11-09 12:44:02','00202440000000003',2),(111,8.38,10.33,0.242,2.04,0.075,'2020-11-09 12:45:02','00202440000000003',2),(112,8.75,11.22,0.287,5.79,0.055,'2020-11-09 12:46:02','00202440000000003',3),(113,8.44,11.27,0.025,3.83,0.118,'2020-11-09 12:47:02','00202440000000003',3),(114,8.34,9.83,0.108,5.51,0.099,'2020-11-09 12:48:02','00202440000000003',3),(115,8.32,11.58,0.025,1.33,0.013,'2020-11-09 12:49:02','00202440000000003',1),(116,7.49,9.85,0.052,3.06,0.119,'2020-11-09 12:50:02','00202440000000003',3),(117,8.04,10.36,0.025,2.55,0.043,'2020-11-09 12:51:02','00202440000000003',2),(118,7.63,7.32,0.18,3.5,0.16,'2020-11-09 12:52:02','00202440000000003',3),(119,8.2,9.9,0.025,3.78,0.028,'2020-11-09 12:53:02','00202440000000003',2),(120,8.15,10.89,0.074,3.55,0.073,'2020-11-09 12:54:02','00202440000000003',2),(121,8.05,11.09,0.025,1.32,0.018,'2020-11-09 12:55:02','00202440000000003',1),(122,8.51,13.54,0.025,2.49,0.013,'2020-11-09 12:56:02','00202440000000003',2),(123,7.81,9.24,0.035,1.09,0.024,'2020-11-09 12:57:02','00202440000000003',2),(124,8.24,8.89,0.408,5.09,0.076,'2020-11-09 12:58:02','00202440000000003',3),(125,8,10.12,0.025,1.62,0.005,'2020-11-09 12:59:02','00202440000000003',1),(126,8.17,9.74,0.129,4.44,0.054,'2020-11-09 13:00:02','00202440000000003',3),(128,8.24,8.26,0.031,2.72,0.027,'2020-11-09 13:02:02','00202440000000003',2),(131,8.02,9.1,0.025,1.08,0.016,'2020-11-09 13:05:02','00202440000000003',1),(133,7.8,10.62,0.45,4.68,0.017,'2020-11-09 13:07:02','00202440000000003',3),(134,8.33,11.02,0.234,2.47,0.161,'2020-11-09 13:08:02','00202440000000003',3),(135,8.26,10,0.27,1.57,0.039,'2020-11-09 13:09:02','00202440000000003',2),(136,7.87,9.48,0.025,0.86,0.005,'2020-11-09 13:10:02','00202440000000003',1),(137,8.03,8.89,0.025,1,0.005,'2020-11-09 13:11:02','00202440000000003',1),(139,8.37,9.58,0.253,5.28,0.149,'2020-11-09 13:13:02','00202440000000003',3),(140,8.62,10.53,0.057,1.77,0.027,'2020-11-09 13:14:02','00202440000000003',2),(141,8.24,9.82,0.355,1.74,0.077,'2020-11-09 13:15:02','00202440000000003',2),(142,8.29,11.35,0.025,1.19,0.005,'2020-11-09 13:16:02','00202440000000003',1),(143,8.47,9.76,0.702,3.41,0.04,'2020-11-09 13:17:02','00202440000000003',3),(144,8.68,10.58,0.025,1.63,0.086,'2020-11-09 13:18:02','00202440000000003',2),(146,8.29,10.44,0.025,1.97,0.036,'2020-11-09 13:20:02','00202440000000003',2),(147,8.2,9.73,0.025,1.7,0.005,'2020-11-09 13:21:02','00202440000000003',1),(148,8.17,9.1,0.487,4.18,0.05,'2020-11-09 13:22:02','00202440000000003',3),(149,8.26,8.56,0.699,3.12,0.007,'2020-11-09 13:23:02','00202440000000003',3),(150,8.25,11.65,0.168,9.41,0.246,'2020-11-09 13:24:02','00202440000000004',4),(151,8.26,9.77,0.061,4.17,0,'2020-11-09 13:25:02','00202440000000004',3),(152,8.19,9.16,0.025,4.13,0.121,'2020-11-09 13:26:02','00202440000000004',3),(153,8.66,8.99,0.21,1.89,0,'2020-11-09 13:27:02','00202440000000004',2),(154,8.31,10.6,0.025,5.15,0.034,'2020-11-09 13:28:02','00202440000000004',3),(155,7.2,13.36,0.057,3.11,0.038,'2020-11-09 13:29:02','00202440000000004',2),(156,7.01,12.21,0.025,1.43,0.047,'2020-11-09 13:30:02','00202440000000004',2),(157,8.02,11.86,0.126,1.75,0.013,'2020-11-09 13:31:02','00202440000000004',1),(158,8.24,8.64,0.059,6.58,0.008,'2020-11-09 13:32:02','00202440000000004',4),(159,8.45,11.27,0.12,2.12,0.024,'2020-11-09 13:33:02','00202440000000004',2),(160,8.39,9.37,0.025,1.54,0.006,'2020-11-09 13:34:02','00202440000000004',1),(161,7.71,12.51,0.025,2.62,0.051,'2020-11-09 13:35:02','00202440000000004',2),(162,8.35,10.88,0.025,12.66,0.015,'2020-11-09 13:36:02','00202440000000004',5),(163,8.58,10.7,0.073,13.04,0.165,'2020-11-09 13:37:02','00202440000000004',5),(164,7.44,8.06,0.331,4.9,0.061,'2020-11-09 13:38:02','00202440000000004',3),(165,7.71,11.66,0.025,3.4,0.025,'2020-11-09 13:39:02','00202440000000004',2),(166,7.79,7.99,0.062,5.31,0.143,'2020-11-09 13:40:02','00202440000000004',3),(167,8.23,13.43,0.025,7.83,0.078,'2020-11-09 13:41:02','00202440000000004',4),(168,8.29,13,0.025,8.12,0.092,'2020-11-09 13:42:02','00202440000000004',4),(169,7.91,9.88,0.025,2.44,0.01,'2020-11-09 13:43:02','00202440000000004',2),(170,8.09,10.67,0.025,2.62,0.044,'2020-11-09 13:44:02','00202440000000004',2),(171,8.18,10.99,0.026,4.67,0.052,'2020-11-09 13:45:02','00202440000000004',3),(172,8.41,10.84,0.058,3.81,0.055,'2020-11-09 13:46:02','00202440000000004',2),(173,8.26,13.69,0.047,5.37,0.174,'2020-11-09 13:47:02','00202440000000004',3),(174,7.9,10.87,0.155,1.99,0.06,'2020-11-09 13:48:02','00202440000000004',2),(175,7.92,8.37,0.754,3.31,0.06,'2020-11-09 13:49:02','00202440000000004',3),(176,7.88,10.88,0.025,0.25,0.005,'2020-11-09 13:50:02','00202440000000004',1),(177,8.29,11.1,0.143,3.67,0.012,'2020-11-09 13:51:02','00202440000000004',2),(178,7.23,9.14,0.044,1.39,0.022,'2020-11-09 13:52:02','00202440000000004',2),(179,7.19,5.19,0.025,1.92,0.022,'2020-11-09 13:53:02','00202440000000004',3),(180,8.06,9.79,0.076,2.56,0.026,'2020-11-09 13:54:02','00202440000000004',2),(181,6.6,10.59,0.025,2.3,0.012,'2020-11-09 13:55:02','00202440000000004',2),(182,7.62,9.01,0.025,0.97,0.008,'2020-11-09 13:56:02','00202440000000004',1),(183,8.14,10.2,0.025,2.52,0.013,'2020-11-09 13:57:02','00202440000000004',2),(184,7.99,7.88,0.025,3.26,0.024,'2020-11-09 13:58:02','00202440000000004',2),(185,7.98,13.74,0.025,2.47,0.023,'2020-11-09 13:59:02','00202440000000004',2),(186,7.41,11.24,0.04,0.8,0.005,'2020-11-09 14:00:02','00202440000000004',1),(187,6.76,8.55,0.096,0.96,0.026,'2020-11-09 14:01:02','00202440000000004',2),(188,7.29,10.49,0.025,0.87,0.007,'2020-11-09 14:02:02','00202440000000004',1),(189,8.1,11.52,0.025,0.82,0.013,'2020-11-09 14:03:02','00202440000000004',1),(190,8.09,11.3,0.025,3.11,0.067,'2020-11-09 14:04:02','00202440000000004',2),(191,7.55,11.41,0.294,5.13,0.071,'2020-11-09 14:05:02','00202440000000004',3),(192,8.01,10.3,0.025,1.62,0.008,'2020-11-09 14:06:02','00202440000000004',1),(193,8.32,9.96,0.206,4.04,0.079,'2020-11-09 14:07:02','00202440000000004',3),(194,7.41,5.58,0.025,4.99,0.152,'2020-11-09 14:08:02','00202440000000004',3),(195,7.81,8.64,0.199,7.99,0.214,'2020-11-09 14:09:02','00202440000000004',4),(196,8.74,11.99,0.025,1.38,0.008,'2020-11-09 14:10:02','00202440000000004',1),(197,8.17,11.48,0.062,2.11,0.024,'2020-11-09 14:11:02','00202440000000004',2),(198,8.37,6.68,0.07,4.04,0.059,'2020-11-09 14:12:02','00202440000000004',3),(199,8.01,10.59,0.025,2.11,0.035,'2020-11-09 14:13:02','00202440000000004',2),(200,8.65,11.65,0.846,3.97,0.146,'2020-11-09 14:14:02','00202440000000005',3),(201,7.85,8.93,0.025,1.04,0.009,'2020-11-09 14:15:02','00202440000000005',1),(202,7.79,8.68,0.081,1.38,0.029,'2020-11-09 14:16:02','00202440000000005',2),(203,7.64,9.18,0.257,2.59,0.052,'2020-11-09 14:17:02','00202440000000005',2),(204,8.5,11.09,0.045,0.25,0.006,'2020-11-09 14:18:02','00202440000000005',1),(205,8.59,11.52,0.026,10.35,0.169,'2020-11-09 14:19:02','00202440000000005',5),(206,8.58,13.28,0.025,7.9,0.134,'2020-11-09 14:20:02','00202440000000005',4),(207,8.39,12.96,0.07,3.86,0,'2020-11-09 14:21:02','00202440000000005',2),(208,7.88,9.77,0.22,3.9,0.057,'2020-11-09 14:22:02','00202440000000005',2),(209,7.95,11.03,0.274,4.1,0.285,'2020-11-09 14:23:02','00202440000000005',4),(210,8.27,15.05,0.14,4.33,0.112,'2020-11-09 14:24:02','00202440000000005',3),(211,7.82,10.57,0.025,1.85,0.034,'2020-11-09 14:25:02','00202440000000005',2),(212,7.99,10.31,0.025,3.32,0.039,'2020-11-09 14:26:02','00202440000000005',2),(213,8.57,12.12,0.03,4.45,0.032,'2020-11-09 14:27:02','00202440000000005',3),(214,7.82,11.22,0.025,2.14,0.028,'2020-11-09 14:28:02','00202440000000005',2),(215,7.74,11.26,0.025,8.63,0.15,'2020-11-09 14:29:02','00202440000000005',4),(216,8.26,10.14,0.082,4.69,0.172,'2020-11-09 14:30:02','00202440000000005',3),(217,7.47,10.83,0.026,1.54,0.053,'2020-11-09 14:31:02','00202440000000005',2),(218,9.03,15.74,0.12,4.3,0.026,'2020-11-09 14:32:02','00202440000000005',6),(219,8.41,11.67,0.395,3.52,0.052,'2020-11-09 14:33:02','00202440000000005',2),(220,8.19,11.89,0.025,0.94,0.025,'2020-11-09 14:34:02','00202440000000005',2),(221,7.77,9.65,0.025,0.55,0.02,'2020-11-09 14:35:02','00202440000000005',1),(222,8.22,11.58,0.025,0.59,0.006,'2020-11-09 14:36:02','00202440000000005',1),(223,8,9.62,0.09,2.16,0.018,'2020-11-09 14:37:02','00202440000000005',2),(224,8.03,10.1,0.025,1.22,0.013,'2020-11-09 14:38:02','00202440000000005',1),(225,8.17,10.86,0.025,2.78,0.024,'2020-11-09 14:39:02','00202440000000005',2),(226,7.87,10.87,0.833,3.37,0.112,'2020-11-09 14:40:02','00202440000000005',3),(227,7.67,9.52,0.084,4.22,0.092,'2020-11-09 14:41:02','00202440000000005',3),(228,7.72,11.56,0.025,3.83,0.069,'2020-11-09 14:42:02','00202440000000005',2),(229,7.39,10.53,0.084,3.46,0.074,'2020-11-09 14:43:02','00202440000000005',2),(230,6.91,7.72,0.084,5.43,0.024,'2020-11-09 14:44:02','00202440000000005',3),(231,7.78,10.5,0.05,2.76,0.038,'2020-11-09 14:45:02','00202440000000005',2),(232,7.4,9,0.025,2.85,0.042,'2020-11-09 14:46:02','00202440000000005',2),(233,7.14,11.6,0.146,3.19,0.071,'2020-11-09 14:47:02','00202440000000005',2),(234,7.86,7.27,0.091,2.94,0.052,'2020-11-09 14:48:02','00202440000000005',2),(235,7.99,11.64,0.175,3.81,0.138,'2020-11-09 14:49:02','00202440000000005',3),(236,7.65,11.75,0.209,2.89,0.078,'2020-11-09 14:50:02','00202440000000005',2),(237,7.51,10.54,0.276,4.14,0.164,'2020-11-09 14:51:02','00202440000000005',3),(238,7.55,11.53,0.133,4.03,0.228,'2020-11-09 14:52:02','00202440000000005',4),(239,7.73,11.56,0.134,3.87,0.066,'2020-11-09 14:53:02','00202440000000005',2),(240,7.06,10.25,0.15,3.35,0,'2020-11-09 14:54:02','00202440000000005',2),(241,7.32,7.98,0.025,2.52,0.014,'2020-11-09 14:55:02','00202440000000005',2),(242,8.08,14.19,0.53,2.33,0,'2020-11-09 14:56:02','00202440000000005',3),(243,8.46,11.04,0.025,0.25,0.012,'2020-11-09 14:57:02','00202440000000005',1),(244,8.22,10.77,0.025,7.67,0.063,'2020-11-09 14:58:02','00202440000000005',4),(245,7.56,11.4,0.068,3.67,0.083,'2020-11-09 14:59:02','00202440000000005',2),(246,7.68,10.38,0.111,2.6,0,'2020-11-09 15:00:02','00202440000000005',2),(247,7.58,8.63,0.066,2.88,0.053,'2020-11-09 15:01:02','00202440000000005',2),(248,7.31,10.96,0.025,4.64,0.085,'2020-11-09 15:02:02','00202440000000005',3),(249,7.51,11.59,0.057,1.62,0.149,'2020-11-09 15:03:02','00202440000000005',3),(250,7.45,10,0.04,2.4,0.045,'2020-11-09 15:04:02','00202440000000006',2),(251,7.64,12.16,0.214,4.07,0.22,'2020-11-09 15:05:02','00202440000000006',4),(252,7.13,10.76,0.388,3.45,0.055,'2020-11-09 15:06:02','00202440000000006',2),(253,7.53,9.82,0.025,1.68,0.059,'2020-11-09 15:07:02','00202440000000006',2),(254,6.88,8.3,0.025,4.43,0.019,'2020-11-09 15:08:02','00202440000000006',3),(255,7.77,11.65,0.054,5.27,0.124,'2020-11-09 15:09:02','00202440000000006',3),(256,7.54,11.4,0.025,5.36,0.023,'2020-11-09 15:10:02','00202440000000006',3),(257,7.47,10.69,0.418,5.13,0.112,'2020-11-09 15:11:02','00202440000000006',5),(258,7.07,7.68,0.098,8.56,0.058,'2020-11-09 15:12:02','00202440000000006',4),(259,7.11,12.54,0.025,5.12,0.051,'2020-11-09 15:13:02','00202440000000006',3),(260,7.65,11.68,0.025,5.49,0.073,'2020-11-09 15:14:02','00202440000000006',3),(261,7.27,8.75,0.193,5.8,0,'2020-11-09 15:15:02','00202440000000006',3),(262,7.92,11.75,0.025,7.23,0.112,'2020-11-09 15:16:02','00202440000000006',4),(263,7.27,12.44,0.025,4.08,0.029,'2020-11-09 15:17:02','00202440000000006',3),(264,7.77,11.88,0.082,5.22,0.126,'2020-11-09 15:18:02','00202440000000006',3),(265,7.84,12.63,0.194,6.98,0.104,'2020-11-09 15:19:02','00202440000000006',4),(266,6.92,11.15,0.072,3.93,0.079,'2020-11-09 15:20:02','00202440000000006',2),(267,7.37,9.26,0.039,5.54,0.087,'2020-11-09 15:21:02','00202440000000006',4),(268,6.79,9.18,0.025,7.08,0.099,'2020-11-09 15:22:02','00202440000000006',4),(269,7.43,12.08,0.111,3.1,0.056,'2020-11-09 15:23:02','00202440000000006',2),(270,7.21,10.53,0.025,6.09,0.023,'2020-11-09 15:24:02','00202440000000006',4),(271,7.11,11.04,0.053,4.64,0.017,'2020-11-09 15:25:02','00202440000000006',3),(272,7.08,11.86,0.025,1.95,0.069,'2020-11-09 15:26:02','00202440000000006',2),(273,7.19,7.8,0.13,4.89,0.076,'2020-11-09 15:27:02','00202440000000006',3),(274,7.38,7.33,0.28,3.37,0.077,'2020-11-09 15:28:02','00202440000000006',2),(275,7.79,5.7,0.136,3.6,0.128,'2020-11-09 15:29:02','00202440000000006',3),(276,7.77,9.11,0.027,1.39,0.032,'2020-11-09 15:30:02','00202440000000006',2),(277,7.43,7.89,0.025,2.54,0.052,'2020-11-09 15:31:02','00202440000000006',2),(278,8.23,9.04,0.132,3.51,0.092,'2020-11-09 15:32:02','00202440000000006',2),(279,8.45,4.7,0.172,3.86,0.135,'2020-11-09 15:33:02','00202440000000006',4),(280,8.55,9.02,0.053,3.77,0.064,'2020-11-09 15:34:02','00202440000000006',2),(281,7.68,7.5,0.196,3.25,0.046,'2020-11-09 15:35:02','00202440000000006',2),(282,7.45,8.21,0.025,2.42,0.063,'2020-11-09 15:36:02','00202440000000006',2),(283,7.45,6.97,0.039,4.59,0.113,'2020-11-09 15:37:02','00202440000000006',3),(284,7.47,7.64,0.054,4.49,0.058,'2020-11-09 15:38:02','00202440000000006',3),(285,7.79,7.53,0.025,3.06,0.051,'2020-11-09 15:39:02','00202440000000006',2),(286,8.14,8.08,0.04,2.29,0.053,'2020-11-09 15:40:02','00202440000000006',2),(287,8.09,8.74,0.108,1.58,0.068,'2020-11-09 15:41:02','00202440000000006',2),(288,7.25,7.76,0.193,1.9,0.035,'2020-11-09 15:42:02','00202440000000006',2),(289,7.54,6.84,0.446,2.73,0.1,'2020-11-09 15:43:02','00202440000000006',2),(290,7.86,7.48,0.03,2,0.068,'2020-11-09 15:44:02','00202440000000006',2),(291,8.34,8.9,0.18,21.78,0.052,'2020-11-09 15:45:02','00202440000000006',6),(292,8.2,7.85,0.132,3.7,0.141,'2020-11-09 15:46:02','00202440000000006',3),(293,8.9,7.27,0.19,3.22,0.168,'2020-11-09 15:47:02','00202440000000006',3),(294,8.35,8.06,0.05,4.48,0.082,'2020-11-09 15:48:02','00202440000000006',4),(295,7.71,8.99,0.039,3.28,0.054,'2020-11-09 15:49:02','00202440000000006',4),(296,8.44,6.86,0.042,4.49,0.073,'2020-11-09 15:50:02','00202440000000006',3),(297,7.38,6.47,0.079,3.27,0.099,'2020-11-09 15:51:02','00202440000000006',2),(298,7.65,5.7,0.186,4.2,0.126,'2020-11-09 15:52:02','00202440000000006',3),(299,7.93,7.18,0.296,2.85,0.198,'2020-11-09 15:53:02','00202440000000006',3),(301,7.92,7.69,0.044,3.42,0.048,'2020-11-09 15:55:02','00202440000000007',3),(302,7.72,8.5,0.061,1.82,0.071,'2020-11-09 15:56:02','00202440000000007',2),(304,7.6,8.26,0.109,3.78,0.144,'2020-11-09 15:58:02','00202440000000007',3),(305,7.31,6.99,0.078,2.15,0.065,'2020-11-09 15:59:02','00202440000000007',2),(306,7.56,5.4,0.279,2,0.099,'2020-11-09 16:00:02','00202440000000007',3),(307,7.79,7.22,0.025,2.57,0.072,'2020-11-09 16:01:02','00202440000000007',2),(308,7.66,13.78,0.069,2.31,0,'2020-11-09 16:02:02','00202440000000007',2),(309,8.55,10.94,0.074,4.05,0.041,'2020-11-09 16:03:02','00202440000000007',3),(310,8.3,8.56,0.12,2.1,0.103,'2020-11-09 16:04:02','00202440000000007',3),(311,7.89,6.5,0.153,4.54,0.075,'2020-11-09 16:05:02','00202440000000007',3),(312,7.48,6.7,0.6,5.13,0.198,'2020-11-09 16:06:02','00202440000000007',3),(313,7.72,6.79,0.091,4.33,0.055,'2020-11-09 16:07:02','00202440000000007',3),(315,7.69,5.66,0.053,5.93,0.098,'2020-11-09 16:09:02','00202440000000007',3),(316,7.74,6.92,0.102,2.42,0.099,'2020-11-09 16:10:02','00202440000000007',2),(317,7.66,5.25,0.126,3.37,0.1,'2020-11-09 16:11:02','00202440000000007',3),(318,8.42,11.68,0.1,2.7,0.022,'2020-11-09 16:12:02','00202440000000007',2),(319,7.81,5.56,0.025,3.04,0.024,'2020-11-09 16:13:02','00202440000000007',3),(320,7.44,7.88,0.025,1.38,0.07,'2020-11-09 16:14:02','00202440000000007',2),(321,7.29,6.17,0.124,1.87,0.109,'2020-11-09 16:15:02','00202440000000007',3),(322,7.88,7.86,0.235,3.26,0.152,'2020-11-09 16:16:02','00202440000000007',3),(323,7.74,7.6,0.025,1.77,0.069,'2020-11-09 16:17:02','00202440000000007',2),(324,7.39,7.26,0.118,3.68,0.062,'2020-11-09 16:18:02','00202440000000007',2),(325,7.68,7.93,0.63,3.37,0.076,'2020-11-09 16:19:02','00202440000000007',3),(329,7.3,6.58,0.146,4.2,0.098,'2020-11-09 16:23:02','00202440000000007',3),(330,7.16,6.61,0.396,3.95,0.055,'2020-11-09 16:24:02','00202440000000007',2),(331,7.57,7.4,0.198,2.7,0.117,'2020-11-09 16:25:02','00202440000000007',3),(332,7.39,7.11,0.025,2.23,0.096,'2020-11-09 16:26:02','00202440000000007',2),(333,8.21,9.2,0.025,2.93,0.02,'2020-11-09 16:27:02','00202440000000007',2),(334,7.34,5.42,0.369,3.5,0.06,'2020-11-09 16:28:02','00202440000000007',3),(335,8.14,8.15,0.025,3.96,0.023,'2020-11-09 16:29:02','00202440000000007',2),(336,6.74,7.37,0.025,4.8,0.042,'2020-11-09 16:30:02','00202440000000007',3),(337,7.2,5.82,0.083,4.49,0.185,'2020-11-09 16:31:02','00202440000000007',3),(338,7.76,5.12,0.16,2.75,0.147,'2020-11-09 16:32:02','00202440000000007',3),(339,7.97,7.27,0.025,1.85,0.072,'2020-11-09 16:33:02','00202440000000007',2),(340,7.86,7.52,0.032,1.7,0.084,'2020-11-09 16:34:02','00202440000000007',2),(342,7.68,6.66,0.17,1.94,0.106,'2020-11-09 16:36:02','00202440000000007',3),(344,7.85,6.38,0.053,5.51,0.19,'2020-11-09 16:38:02','00202440000000007',3),(345,7.4,5.89,0.042,5.91,0.174,'2020-11-09 16:39:02','00202440000000007',3),(348,7.31,5.66,0.091,3.66,0.077,'2020-11-09 16:42:02','00202440000000007',3),(349,7.68,6.87,0.124,3.73,0.075,'2020-11-09 16:43:02','00202440000000007',2),(350,7.7,7.04,0.094,4.36,0.123,'2020-11-09 16:44:02','00202440000000008',3),(351,7.45,5.15,0.165,5.21,0.082,'2020-11-09 16:45:02','00202440000000008',3),(352,7.76,7.05,0.053,3.84,0.079,'2020-11-09 16:46:02','00202440000000008',2),(353,7.76,7.54,0.033,3.88,0.079,'2020-11-09 16:47:02','00202440000000008',2),(354,7.4,6.4,0.064,4.22,0.041,'2020-11-09 16:48:02','00202440000000008',3),(355,7.93,8.57,0.054,6.73,0.127,'2020-11-09 16:49:02','00202440000000008',4),(356,7.07,11.9,0.026,4.95,0.085,'2020-11-09 16:50:02','00202440000000008',3),(357,7.57,9.23,0.028,4.28,0.078,'2020-11-09 16:51:02','00202440000000008',3),(358,8.02,7.2,0.044,5.52,0.056,'2020-11-09 16:52:02','00202440000000008',3),(359,7.31,6.3,0.224,4.81,0.088,'2020-11-09 16:53:02','00202440000000008',3),(360,7.3,5.4,0.764,4.28,0.149,'2020-11-09 16:54:02','00202440000000008',3),(361,7.55,6.75,0.241,5.1,0.284,'2020-11-09 16:55:02','00202440000000008',4),(362,7.36,4,0.423,4.52,0.102,'2020-11-09 16:56:02','00202440000000008',4),(363,7.81,11.36,0.064,5.92,0.064,'2020-11-09 16:57:02','00202440000000008',3),(364,8.24,9.02,0.025,3.36,0.112,'2020-11-09 16:58:02','00202440000000008',5),(365,8.09,8.1,0.42,4,0.138,'2020-11-09 16:59:02','00202440000000008',3),(366,8.45,8.73,0.025,1.86,0.068,'2020-11-09 17:00:02','00202440000000008',4),(367,8.43,9.88,0.025,3.42,0.083,'2020-11-09 17:01:02','00202440000000008',4),(368,7.61,7.49,0.045,6.3,0.044,'2020-11-09 17:02:02','00202440000000008',4),(369,8.45,8.47,0.17,3.4,0.043,'2020-11-09 17:03:02','00202440000000008',2),(370,7.97,8.72,0.09,3.35,0.066,'2020-11-09 17:04:02','00202440000000008',2),(371,8.61,7.86,0.113,3,0.068,'2020-11-09 17:05:02','00202440000000008',2),(372,7.85,7.23,0.362,4.38,0.15,'2020-11-09 17:06:02','00202440000000008',3),(373,7.82,8.11,0.044,5.13,0.103,'2020-11-09 17:07:02','00202440000000008',3),(374,7.54,6.42,0.065,3.37,0.074,'2020-11-09 17:08:02','00202440000000008',2),(375,7.8,6.77,0.129,3.19,0.08,'2020-11-09 17:09:02','00202440000000008',2),(376,7.15,6.64,0.106,4.22,0.072,'2020-11-09 17:10:02','00202440000000008',3),(377,7.38,9.44,0.045,3.24,0.044,'2020-11-09 17:11:02','00202440000000008',2),(378,8,7.19,0.076,1.54,0.045,'2020-11-09 17:12:02','00202440000000008',2),(379,8.08,7.31,0.144,5.23,0.1,'2020-11-09 17:13:02','00202440000000008',3),(380,7.79,6.18,0.227,3.26,0.087,'2020-11-09 17:14:02','00202440000000008',2),(381,7.53,9.53,0.1,4.75,0.07,'2020-11-09 17:15:02','00202440000000008',3),(382,7.63,5.24,0.17,5.16,0.083,'2020-11-09 17:16:02','00202440000000008',3),(383,7.88,6.48,0.069,4.11,0.057,'2020-11-09 17:17:02','00202440000000008',3),(384,7.46,7.13,0.071,3.85,0.131,'2020-11-09 17:18:02','00202440000000008',3),(385,7.86,8.1,0.066,3.92,0.051,'2020-11-09 17:19:02','00202440000000008',2),(386,7.71,8.79,0.129,4.57,0.098,'2020-11-09 17:20:02','00202440000000008',3),(387,7.86,7.17,0.038,1.48,0.056,'2020-11-09 17:21:02','00202440000000008',2),(388,8.24,10,0.057,5.12,0.065,'2020-11-09 17:22:02','00202440000000008',4),(389,8.09,8.31,0.041,3.15,0.057,'2020-11-09 17:23:02','00202440000000008',2),(390,7.59,8.57,0.09,2.7,0.072,'2020-11-09 17:24:02','00202440000000008',2),(391,7.58,6.4,0.4,4.77,0.164,'2020-11-09 17:25:02','00202440000000008',3),(392,7.7,8.99,0.1,2.6,0.099,'2020-11-09 17:26:02','00202440000000008',2),(393,7.83,6.78,0.628,5.18,0.127,'2020-11-09 17:27:02','00202440000000008',3),(394,7.77,7.59,0.068,2.31,0.083,'2020-11-09 17:28:02','00202440000000008',2),(395,7.85,8.28,0.025,1.68,0.054,'2020-11-09 17:29:02','00202440000000008',2),(396,8.18,8.33,0.086,2.8,0.084,'2020-11-09 17:30:02','00202440000000008',2),(397,7.82,8.22,0.155,2.39,0.132,'2020-11-09 17:31:02','00202440000000008',3),(398,7.95,7.63,0.07,2.08,0.068,'2020-11-09 17:32:02','00202440000000008',2),(399,7.87,8.95,0.032,1.86,0.061,'2020-11-09 17:33:02','00202440000000008',2),(400,7.89,6.91,0.056,2.44,0.057,'2020-11-09 17:34:02','00202440000000009',2),(401,7.8,7.18,0.312,2.64,0.101,'2020-11-09 17:35:02','00202440000000009',3),(402,7.58,6.5,0.155,2.5,0.074,'2020-11-09 17:36:02','00202440000000009',2),(403,8.26,9.68,0.113,3.1,0.016,'2020-11-09 17:37:02','00202440000000009',2),(404,7.59,5.58,0.098,4.55,0,'2020-11-09 17:38:02','00202440000000009',3),(405,8.83,9.18,0.085,4.15,0.014,'2020-11-09 17:39:02','00202440000000009',3),(406,8.5,9.85,0.025,4.86,0.054,'2020-11-09 17:40:02','00202440000000009',4),(407,8.36,9.67,0.025,4.07,0.067,'2020-11-09 17:41:02','00202440000000009',4),(408,8.4,9.41,0.027,5.27,0.037,'2020-11-09 17:42:02','00202440000000009',3),(409,8.56,9.56,0.025,4.09,0.044,'2020-11-09 17:43:02','00202440000000009',3),(410,8.42,9.56,0.146,3.35,0.024,'2020-11-09 17:44:02','00202440000000009',2),(411,8.05,9.06,0.27,2.92,0.055,'2020-11-09 17:45:02','00202440000000009',2),(412,8.1,8.48,0.092,4.71,0.059,'2020-11-09 17:46:02','00202440000000009',3),(413,7.52,5.82,0.455,4.84,0.107,'2020-11-09 17:47:02','00202440000000009',3),(414,7.71,6.49,0.25,5.54,0.122,'2020-11-09 17:48:02','00202440000000009',3),(415,8.42,8.99,0.12,6.81,0.043,'2020-11-09 17:49:02','00202440000000009',4),(416,8.11,8.87,0.05,4.07,0.051,'2020-11-09 17:50:02','00202440000000009',3),(417,7.52,12.29,0.05,0.84,0.011,'2020-11-09 17:51:02','00202440000000009',2),(418,7.84,8.58,0.06,0.98,0.102,'2020-11-09 17:52:02','00202440000000009',3),(419,6.71,7.86,0.1,0.82,0.009,'2020-11-09 17:53:02','00202440000000009',1),(420,7.84,6.29,0.125,0.82,0.056,'2020-11-09 17:54:02','00202440000000009',2),(421,7.71,7.08,0.078,0.72,0.092,'2020-11-09 17:55:02','00202440000000009',2),(422,7.73,8,0.056,1.62,0.062,'2020-11-09 17:56:02','00202440000000009',2),(423,8.41,10.3,0.039,2.2,0.05,'2020-11-09 17:57:02','00202440000000009',2),(424,7.82,9.07,0.16,3.98,0.318,'2020-11-09 17:58:02','00202440000000009',5),(425,7.32,6.11,0.025,1.72,0.054,'2020-11-09 17:59:02','00202440000000009',2),(426,6.93,6.31,0.025,1.19,0.016,'2020-11-09 18:00:02','00202440000000009',2),(427,7.36,7.27,0.11,3.4,0.079,'2020-11-09 18:01:02','00202440000000009',2),(428,8.8,11.34,0.116,1.24,0.028,'2020-11-09 18:02:02','00202440000000009',2),(429,6.78,6.78,0.092,2.42,0.04,'2020-11-09 18:03:02','00202440000000009',2),(430,8.4,8.88,0.096,4.95,0.135,'2020-11-09 18:04:02','00202440000000009',3),(431,7.14,7.68,0.044,1.22,0.028,'2020-11-09 18:05:02','00202440000000009',2),(432,7.14,6.21,0.087,3.1,0.066,'2020-11-09 18:06:02','00202440000000009',2),(433,8.84,10.09,0.025,0.82,0.032,'2020-11-09 18:07:02','00202440000000009',2),(434,8.5,8.6,0.082,5.4,0.119,'2020-11-09 18:08:02','00202440000000009',3),(435,7.62,8.98,0.032,1.44,0.036,'2020-11-09 18:09:02','00202440000000009',2),(436,8.31,7.74,0.168,3.26,0.087,'2020-11-09 18:10:02','00202440000000009',2),(437,7.2,5.02,0.027,0.74,0.008,'2020-11-09 18:11:02','00202440000000009',3),(438,7.88,9.41,0.142,1.22,0.073,'2020-11-09 18:12:02','00202440000000009',2),(439,7.48,8.01,0.129,2.38,0.053,'2020-11-09 18:13:02','00202440000000009',2),(440,7.36,3.4,0.134,6.6,0.063,'2020-11-09 18:14:02','00202440000000009',4),(441,7.04,5.04,0.059,4.98,0.071,'2020-11-09 18:15:02','00202440000000009',3),(442,7.63,7.12,0.065,4.09,0.099,'2020-11-09 18:16:02','00202440000000009',3),(443,8.79,7.68,0.057,4.26,0.061,'2020-11-09 18:17:02','00202440000000009',3),(444,7.98,5.76,0.104,3.5,0.116,'2020-11-09 18:18:02','00202440000000009',3),(445,7.96,7.83,0.045,3.4,0.084,'2020-11-09 18:19:02','00202440000000009',2),(446,7.23,6.64,0.181,3.5,0.11,'2020-11-09 18:20:02','00202440000000009',3),(447,7.27,5.08,0.052,3.56,0.091,'2020-11-09 18:21:02','00202440000000009',3),(448,7.67,7.19,0.048,3.16,0.084,'2020-11-09 18:22:02','00202440000000009',2),(449,7.08,5.15,0.138,4.52,0.076,'2020-11-09 18:23:02','00202440000000009',3),(450,7.49,8.26,0.338,3.76,0.166,'2020-11-09 18:24:02','00202440000000010',3),(451,6.73,7.96,0.159,3.98,0.083,'2020-11-09 18:25:02','00202440000000010',2),(452,7.63,5.32,0.045,3.52,0.109,'2020-11-09 18:26:02','00202440000000010',3),(453,8.42,9.31,0.206,2.55,0.056,'2020-11-09 18:27:02','00202440000000010',2),(454,7.8,9.35,0.037,3.01,0.034,'2020-11-09 18:28:02','00202440000000010',2),(455,7.22,7.96,0.146,2.7,0.147,'2020-11-09 18:29:02','00202440000000010',3),(456,7.59,7.47,0.066,3.08,0.069,'2020-11-09 18:30:02','00202440000000010',2),(457,7.29,8.02,0.133,3.45,0.134,'2020-11-09 18:31:02','00202440000000010',3),(458,7.67,8.8,0.025,2.1,0.043,'2020-11-09 18:32:02','00202440000000010',2),(459,7.61,8.21,0.031,1.78,0.021,'2020-11-09 18:33:02','00202440000000010',2),(460,7.24,7.78,0.141,2.31,0.099,'2020-11-09 18:34:02','00202440000000010',2),(461,7.81,8.33,0.037,1.74,0.049,'2020-11-09 18:35:02','00202440000000010',2),(462,7.53,7.75,0.035,2.68,0.057,'2020-11-09 18:36:02','00202440000000010',2),(463,7.56,5.84,0.58,4.7,0.062,'2020-11-09 18:37:02','00202440000000010',3),(464,7.17,5.75,0.133,3.91,0.044,'2020-11-09 18:38:02','00202440000000010',3),(465,6.9,6.52,0.086,4.99,0.062,'2020-11-09 18:39:02','00202440000000010',3),(466,8.83,10.39,0.058,2.3,0.009,'2020-11-09 18:40:02','00202440000000010',2),(467,7.28,5.06,0.164,2.7,0.056,'2020-11-09 18:41:02','00202440000000010',3),(468,7.21,7.62,0.16,2.6,0.05,'2020-11-09 18:42:02','00202440000000010',2),(469,7.44,9.14,0.384,3.74,0.135,'2020-11-09 18:43:02','00202440000000010',3),(470,7.64,7.52,0.124,2.02,0.02,'2020-11-09 18:44:02','00202440000000010',2),(471,7.36,7.78,0.18,3.56,0.114,'2020-11-09 18:45:02','00202440000000010',3),(472,8.26,10.35,0.216,3.79,0.119,'2020-11-09 18:46:02','00202440000000010',3),(473,7.8,8.26,0.21,3.48,0.138,'2020-11-09 18:47:02','00202440000000010',3),(474,8.5,9.82,0.136,3.72,0.163,'2020-11-09 18:48:02','00202440000000010',3),(475,7.75,8.38,0.06,2.16,0.065,'2020-11-09 18:49:02','00202440000000010',2),(476,8.57,7.46,0.076,3.59,0.054,'2020-11-09 18:50:02','00202440000000010',2),(477,8.45,12.11,0.179,6.13,0.079,'2020-11-09 18:51:02','00202440000000010',4),(478,8.63,6.72,0.141,2.19,0.038,'2020-11-09 18:52:02','00202440000000010',2),(479,7.75,7.55,0.18,2.78,0.123,'2020-11-09 18:53:02','00202440000000010',3),(480,6.64,6.99,0.224,3.75,0.142,'2020-11-09 18:54:02','00202440000000010',3),(481,7.5,8.8,0.025,4.7,0.005,'2020-11-09 18:55:02','00202440000000010',3),(482,8.46,8.89,0.134,1.56,0.045,'2020-11-09 18:56:02','00202440000000010',2),(483,7.21,7.23,0.025,1.31,0.006,'2020-11-09 18:57:02','00202440000000010',2),(484,8.79,10.04,0.025,0.75,0.021,'2020-11-09 18:58:02','00202440000000010',2),(485,7.81,8.26,0.175,1.72,0.055,'2020-11-09 18:59:02','00202440000000010',2),(486,8.25,8.06,0.025,1.5,0.033,'2020-11-09 19:00:02','00202440000000010',2),(487,8.51,9.04,0.04,0.74,0.01,'2020-11-09 19:01:02','00202440000000010',1),(488,7.38,8,0.044,1.88,0.031,'2020-11-09 19:02:02','00202440000000010',2),(489,8.47,9.76,0.025,1.23,0.019,'2020-11-09 19:03:02','00202440000000010',2),(490,7.82,7.79,0.029,1.3,0.046,'2020-11-09 19:04:02','00202440000000010',2),(491,8.33,12.13,0.061,5.94,0.084,'2020-11-09 19:05:02','00202440000000010',3),(492,6.81,6.13,0.03,0.5,0.014,'2020-11-09 19:06:02','00202440000000010',2),(493,8.78,8.89,0.65,8.79,0.035,'2020-11-09 19:07:02','00202440000000010',4),(494,6.65,7.53,0.025,2.42,0.008,'2020-11-09 19:08:02','00202440000000010',2),(495,7.5,6.04,0.786,4.24,0.103,'2020-11-09 19:09:02','00202440000000010',3),(496,7.61,6.9,0.074,2.99,0.059,'2020-11-09 19:10:02','00202440000000010',2),(497,6.77,8.09,0.084,2.44,0.048,'2020-11-09 19:11:02','00202440000000010',2),(498,7.44,8.52,0.053,2.21,0.035,'2020-11-09 19:12:02','00202440000000010',2),(499,6.93,8.64,0.042,1.3,0.02,'2020-11-09 19:13:02','00202440000000010',1),(500,7.54,9.33,0.174,1,0.026,'2020-11-09 19:14:02','00202440000000011',2),(501,7.46,7.03,0.088,1.74,0.037,'2020-11-09 19:15:02','00202440000000011',2),(502,9.19,11.82,0.036,1.6,0.02,'2020-11-09 19:16:02','00202440000000011',6),(503,6.46,9.39,0.048,0.84,0.009,'2020-11-09 19:17:02','00202440000000011',1),(504,7.39,8.12,0.06,1.25,0.033,'2020-11-09 19:18:02','00202440000000011',2),(505,7.32,9.6,0.14,6.42,0.108,'2020-11-09 19:19:02','00202440000000011',5),(506,7.32,7.03,0.3,6.74,0.119,'2020-11-09 19:20:02','00202440000000011',4),(507,7.41,6.22,0.636,7.27,0.102,'2020-11-09 19:21:02','00202440000000011',4),(508,7.04,5.44,0.288,5.33,0.128,'2020-11-09 19:22:02','00202440000000011',3),(509,7.14,4.81,0.118,3.12,0.01,'2020-11-09 19:23:02','00202440000000011',4),(510,7.11,6.05,0.039,3.74,0.047,'2020-11-09 19:24:02','00202440000000011',2),(511,7.57,3.81,1.904,1.02,0.129,'2020-11-09 19:25:02','00202440000000011',5),(512,7.37,8.94,0.13,3.53,0.043,'2020-11-09 19:26:02','00202440000000011',2),(513,7.27,7.22,0.238,5.78,0.119,'2020-11-09 19:27:02','00202440000000011',3),(514,7.58,5.42,0.559,5.33,0.088,'2020-11-09 19:28:02','00202440000000011',3),(515,7.12,6.22,0.516,3.65,0.085,'2020-11-09 19:29:02','00202440000000011',3),(516,7.55,8.23,0.025,4.52,0.065,'2020-11-09 19:30:02','00202440000000011',4),(517,7.9,8.88,0.025,3.18,0.051,'2020-11-09 19:31:02','00202440000000011',4),(518,6.98,6.27,0.651,4.22,0.072,'2020-11-09 19:32:02','00202440000000011',3),(519,7.21,8.3,0.25,2.53,0.051,'2020-11-09 19:33:02','00202440000000011',2),(520,7.19,5.35,1.792,5.05,0.22,'2020-11-09 19:34:02','00202440000000011',5),(521,7.53,7.26,0.025,4.88,0.111,'2020-11-09 19:35:02','00202440000000011',5),(522,7.86,8.86,0.025,4.62,0.07,'2020-11-09 19:36:02','00202440000000011',4),(523,7.88,7.94,0.025,3.55,0.066,'2020-11-09 19:37:02','00202440000000011',4),(524,7.9,9.05,0.025,3.18,0.052,'2020-11-09 19:38:02','00202440000000011',4),(525,6.86,7.98,0.025,4.32,0.065,'2020-11-09 19:39:02','00202440000000011',4),(526,7.84,8.71,0.025,4.05,0.055,'2020-11-09 19:40:02','00202440000000011',4),(527,7.4,5.83,0.042,3.56,0.072,'2020-11-09 19:41:02','00202440000000011',3),(528,7.89,4.47,0.762,5.2,0.085,'2020-11-09 19:42:02','00202440000000011',4),(529,8.16,8.18,0.108,1.97,0.077,'2020-11-09 19:43:02','00202440000000011',2),(530,7.89,8.25,0.359,1.85,0.053,'2020-11-09 19:44:02','00202440000000011',2),(531,7.51,6.98,0.403,3.04,0.06,'2020-11-09 19:45:02','00202440000000011',2),(532,7.41,5.72,0.249,2.91,0.065,'2020-11-09 19:46:02','00202440000000011',3),(533,7.81,7.74,0.301,1.98,0.061,'2020-11-09 19:47:02','00202440000000011',2),(534,7.9,9.21,0.088,3.86,0.08,'2020-11-09 19:48:02','00202440000000011',2),(535,8.02,6.77,0.08,2.87,0.063,'2020-11-09 19:49:02','00202440000000011',2),(536,7.64,5.12,0.025,3.95,0.049,'2020-11-09 19:50:02','00202440000000011',3),(537,7.98,6.52,0.11,5.64,0.093,'2020-11-09 19:51:02','00202440000000011',3),(538,7.81,3.67,0.146,4.89,0.204,'2020-11-09 19:52:02','00202440000000011',4),(539,7.64,8.92,0.025,3.66,0.12,'2020-11-09 19:53:02','00202440000000011',3),(540,7.73,4.98,0.093,3.88,0.082,'2020-11-09 19:54:02','00202440000000011',4),(541,7.19,3.53,0.16,3.89,0,'2020-11-09 19:55:02','00202440000000011',4),(542,7.58,6.36,0.04,3.16,0.082,'2020-11-09 19:56:02','00202440000000011',2),(543,7.74,7.25,0.038,2.84,0.082,'2020-11-09 19:57:02','00202440000000011',2),(544,7.49,7.13,0.042,4.46,0.042,'2020-11-09 19:58:02','00202440000000011',3),(545,7.9,8.76,0.025,4.79,0.045,'2020-11-09 19:59:02','00202440000000011',3),(546,7.59,6.56,0.034,3.5,0.075,'2020-11-09 20:00:02','00202440000000011',2),(547,7.46,6.6,0.244,7.61,0.085,'2020-11-09 20:01:02','00202440000000011',4),(548,7.12,9.39,0.111,2.73,0.08,'2020-11-09 20:02:02','00202440000000011',2),(549,8,7.78,0.153,4.49,0.039,'2020-11-09 20:03:02','00202440000000011',3),(550,7.37,7.31,0.345,4.53,0.048,'2020-11-09 20:04:02','00202440000000012',3),(551,7.6,8.05,0.052,2.06,0.058,'2020-11-09 20:05:02','00202440000000012',2),(552,7.83,8.38,0.298,2.74,0.101,'2020-11-09 20:06:02','00202440000000012',3),(553,7.33,5.41,0.6,3.74,0.066,'2020-11-09 20:07:02','00202440000000012',3),(554,7.2,7.57,0.106,3.39,0.049,'2020-11-09 20:08:02','00202440000000012',2),(555,8.1,7.42,0.076,2.01,0.068,'2020-11-09 20:09:02','00202440000000012',2),(556,8.24,8.33,0.025,8,0.174,'2020-11-09 20:10:02','00202440000000012',4),(557,7.99,5.79,0.115,8.93,0.294,'2020-11-09 20:11:02','00202440000000012',4),(558,8.18,5.23,0.052,3.53,0.097,'2020-11-09 20:12:02','00202440000000012',3),(559,7.82,10.48,0.025,1.63,0.049,'2020-11-09 20:13:02','00202440000000012',2),(560,7.56,8.52,0.025,3.4,0.035,'2020-11-09 20:14:02','00202440000000012',3),(561,7.16,9.47,0.063,4.9,0.054,'2020-11-09 20:15:02','00202440000000012',3),(562,9.01,8.9,0.025,3.35,0.028,'2020-11-09 20:16:02','00202440000000012',6),(563,7.5,8.28,0.039,3.47,0.031,'2020-11-09 20:17:02','00202440000000012',3),(564,7.46,7.3,0.025,1.6,0.054,'2020-11-09 20:18:02','00202440000000012',2),(565,6.69,7.03,0.025,2.04,0.011,'2020-11-09 20:19:02','00202440000000012',2),(566,7.64,8.14,0.025,2.71,0.016,'2020-11-09 20:20:02','00202440000000012',2),(567,7.54,8.8,0.025,3.13,0.029,'2020-11-09 20:21:02','00202440000000012',3),(568,7.83,8.81,0.025,3.21,0.022,'2020-11-09 20:22:02','00202440000000012',2),(569,6.92,10.74,0.025,1.2,0.013,'2020-11-09 20:23:02','00202440000000012',1),(570,6.55,7.84,0.025,2.71,0.025,'2020-11-09 20:24:02','00202440000000012',2),(571,7.27,10.69,0.025,1.28,0.02,'2020-11-09 20:25:02','00202440000000012',2),(572,6.7,7.11,0.025,2.41,0.024,'2020-11-09 20:26:02','00202440000000012',2),(573,8.62,12.02,0.117,1.7,0.041,'2020-11-09 20:27:02','00202440000000012',2),(574,8.73,12.79,0.025,2.13,0.022,'2020-11-09 20:28:02','00202440000000012',2),(575,7.36,6.74,0.088,3.53,0.071,'2020-11-09 20:29:02','00202440000000012',2),(576,7.43,7.47,0.025,1.34,0.007,'2020-11-09 20:30:02','00202440000000012',2),(577,8.75,10.18,0.025,3.04,0.021,'2020-11-09 20:31:02','00202440000000012',2),(578,7.48,6.06,0.341,4.03,0.157,'2020-11-09 20:32:02','00202440000000012',3),(579,7.72,5.77,0.27,4.51,0.11,'2020-11-09 20:33:02','00202440000000012',3),(580,7.77,8.5,0.062,2.89,0.127,'2020-11-09 20:34:02','00202440000000012',3),(581,7.66,7.89,0.308,7.55,0.081,'2020-11-09 20:35:02','00202440000000012',4),(582,7.61,8.64,0.326,5.54,0.104,'2020-11-09 20:36:02','00202440000000012',3),(583,7.58,6.92,0.23,5.06,0.094,'2020-11-09 20:37:02','00202440000000012',3),(584,7.92,8.5,0.056,3,0.115,'2020-11-09 20:38:02','00202440000000012',3),(585,7.1,7.54,0.276,3.07,0.09,'2020-11-09 20:39:02','00202440000000012',2),(586,6.83,3.92,0.25,3.9,0.106,'2020-11-09 20:40:02','00202440000000012',4),(587,7.78,6.53,0.03,3.16,0.047,'2020-11-09 20:41:02','00202440000000012',2),(588,8.26,7.58,0.037,3.58,0.114,'2020-11-09 20:42:02','00202440000000012',3),(589,7.28,4.86,0.036,2.99,0.095,'2020-11-09 20:43:02','00202440000000012',4),(590,7.9,8.73,0.378,3.85,0,'2020-11-09 20:44:02','00202440000000012',2),(591,8.27,8.28,0.08,6.13,0.108,'2020-11-09 20:45:02','00202440000000012',4),(592,7.93,7.57,0.025,5.72,0.063,'2020-11-09 20:46:02','00202440000000012',3),(593,8.04,6.24,0.297,5.84,0.098,'2020-11-09 20:47:02','00202440000000012',3),(594,7.79,7.37,0.514,7.08,0.146,'2020-11-09 20:48:02','00202440000000012',4),(595,7.29,7.04,0.176,4.99,0.088,'2020-11-09 20:49:02','00202440000000012',3),(596,6.96,9.13,0.025,2.88,0.03,'2020-11-09 20:50:02','00202440000000012',2),(597,7.13,9.4,0.025,2.7,0.032,'2020-11-09 20:51:02','00202440000000012',2),(598,7.13,6.66,0.104,3.7,0.025,'2020-11-09 20:52:02','00202440000000012',2),(599,7.11,6.6,0.137,3.45,0.037,'2020-11-09 20:53:02','00202440000000012',2),(600,6.95,6.91,0.025,2.47,0.01,'2020-11-09 20:54:02','00202440000000013',2),(601,8.61,11.44,0.025,2.39,0.02,'2020-11-09 20:55:02','00202440000000013',2),(602,7.27,9.46,0.025,1.79,0.023,'2020-11-09 20:56:02','00202440000000013',2),(603,7.76,1.98,0.343,3.73,0.108,'2020-11-09 20:57:02','00202440000000013',6),(604,8.17,8.29,0.2,6.01,0.169,'2020-11-09 20:58:02','00202440000000013',4),(605,7.48,5.25,0.696,6.41,0.098,'2020-11-09 20:59:02','00202440000000013',4),(606,8.28,4.24,0.427,2.88,0.072,'2020-11-09 21:00:02','00202440000000013',4),(607,7.81,4.76,0.288,4.56,0.093,'2020-11-09 21:01:02','00202440000000013',4),(608,7.2,6.79,0.041,1.5,0.067,'2020-11-09 21:02:02','00202440000000013',2),(609,7.83,7.93,0.125,1.85,0.056,'2020-11-09 21:03:02','00202440000000013',2),(610,7.48,7.9,0.091,0.79,0.021,'2020-11-09 21:04:02','00202440000000013',2),(611,7.34,5.58,0.025,3.72,0.059,'2020-11-09 21:05:02','00202440000000013',3),(612,6.71,8.27,0.042,3.53,0.039,'2020-11-09 21:06:02','00202440000000013',3),(613,8.61,10.06,0.025,1.06,0.009,'2020-11-09 21:07:02','00202440000000013',1),(614,7.27,8.42,0.187,3.5,0.056,'2020-11-09 21:08:02','00202440000000013',2),(615,6.94,6.65,0.145,2.73,0,'2020-11-09 21:09:02','00202440000000013',2),(616,7.4,8.37,0.063,2.51,0.04,'2020-11-09 21:10:02','00202440000000013',3),(617,7.35,7.25,0.248,2.39,0.086,'2020-11-09 21:11:02','00202440000000013',2),(618,6.59,6.15,0.059,5.63,0.115,'2020-11-09 21:12:02','00202440000000013',3),(619,7.33,7.42,0.025,1.3,0.008,'2020-11-09 21:13:02','00202440000000013',2),(620,7.74,8.63,0.118,1.68,0.128,'2020-11-09 21:14:02','00202440000000013',3),(621,6.84,5.16,0.692,4.36,0.12,'2020-11-09 21:15:02','00202440000000013',3),(622,7.2,6.89,0.127,4.24,0,'2020-11-09 21:16:02','00202440000000013',3),(623,6.78,5.98,0.056,2.21,0.074,'2020-11-09 21:17:02','00202440000000013',3),(624,7.44,7.11,0.17,1.71,0.066,'2020-11-09 21:18:02','00202440000000013',2),(625,7.04,5.84,0.052,1.57,0.108,'2020-11-09 21:19:02','00202440000000013',3),(626,7.62,6,0.21,5.17,0.269,'2020-11-09 21:20:02','00202440000000013',4),(627,7.15,5.45,0.036,0.7,0.011,'2020-11-09 21:21:02','00202440000000013',3),(628,6.53,2.6,0.095,1.81,0.045,'2020-11-09 21:22:02','00202440000000013',5),(629,7.27,6.06,0.117,2,0.126,'2020-11-09 21:23:02','00202440000000013',3),(630,7.83,6.29,0.078,2.53,0.174,'2020-11-09 21:24:02','00202440000000013',3),(631,8.07,7.2,0.516,2.04,0.121,'2020-11-09 21:25:02','00202440000000013',3),(632,7.03,6.87,0.05,0.94,0.011,'2020-11-09 21:26:02','00202440000000013',2),(633,7.08,5.55,0.147,0.57,0.043,'2020-11-09 21:27:02','00202440000000013',3),(634,7.28,7.34,0.066,1.22,0.016,'2020-11-09 21:28:02','00202440000000013',2),(635,7.32,6.39,0.23,1.53,0.035,'2020-11-09 21:29:02','00202440000000013',2),(636,7.13,6.17,0.317,1.2,0.061,'2020-11-09 21:30:02','00202440000000013',2),(637,7.24,8.74,0.025,0.51,0.024,'2020-11-09 21:31:02','00202440000000013',2),(638,7.46,7.57,0.058,1.17,0.011,'2020-11-09 21:32:02','00202440000000013',1),(639,7.06,5.3,0.025,2.32,0.016,'2020-11-09 21:33:02','00202440000000013',3),(640,6.9,6.94,0.045,2.22,0.063,'2020-11-09 21:34:02','00202440000000013',2),(641,6.85,6.34,0.025,1.08,0.02,'2020-11-09 21:35:02','00202440000000013',2),(642,7.79,8.56,0.09,1.73,0.042,'2020-11-09 21:36:02','00202440000000013',2),(643,7.14,5.94,0.444,1.67,0.084,'2020-11-09 21:37:02','00202440000000013',3),(644,7.01,6.11,0.171,1.7,0.118,'2020-11-09 21:38:02','00202440000000013',3),(645,7.11,8.34,0.025,1.11,0.056,'2020-11-09 21:39:02','00202440000000013',2),(646,7.62,6.99,0.045,1.89,0.089,'2020-11-09 21:40:02','00202440000000013',2),(647,6.83,6.91,0.117,1.78,0.12,'2020-11-09 21:41:02','00202440000000013',3),(648,7.37,6.98,0.199,2.69,0.033,'2020-11-09 21:42:02','00202440000000013',2),(649,6.95,5.39,0.083,2.65,0.014,'2020-11-09 21:43:02','00202440000000013',3),(650,7.24,5.05,0.343,7.32,0.097,'2020-11-09 21:44:02','00202440000000014',4),(651,6.49,5.11,0.446,2.71,0.1,'2020-11-09 21:45:02','00202440000000014',3),(652,6.81,8.23,0.215,3.38,0.046,'2020-11-09 21:46:02','00202440000000014',2),(653,6.77,5.91,0.115,2.23,0.067,'2020-11-09 21:47:02','00202440000000014',3),(654,7.06,6.79,0.08,2.39,0.079,'2020-11-09 21:48:02','00202440000000014',2),(655,6.8,7.93,0.054,2.44,0.104,'2020-11-09 21:49:02','00202440000000014',3),(656,7.5,7.52,0.134,0.96,0.035,'2020-11-09 21:50:02','00202440000000014',2),(657,6.6,7.73,0.151,1.15,0.025,'2020-11-09 21:51:02','00202440000000014',2),(658,6.64,7.16,0.031,1.17,0.022,'2020-11-09 21:52:02','00202440000000014',2),(659,7.4,8.19,0.025,1.55,0.041,'2020-11-09 21:53:02','00202440000000014',2),(660,7.32,6.46,0.118,1.92,0.058,'2020-11-09 21:54:02','00202440000000014',2),(661,7.22,8.5,0.13,2.82,0.048,'2020-11-09 21:55:02','00202440000000014',2),(662,7.01,7.29,0.128,1.68,0.087,'2020-11-09 21:56:02','00202440000000014',2),(663,6.96,8.89,0.054,1.84,0.061,'2020-11-09 21:57:02','00202440000000014',2),(664,7.19,7.06,0.039,1.43,0.052,'2020-11-09 21:58:02','00202440000000014',2),(665,7.8,8.22,1.016,2.15,0,'2020-11-09 21:59:02','00202440000000014',4),(666,7.68,5.92,0.124,1.92,0.068,'2020-11-09 22:00:02','00202440000000014',3),(667,7.15,8.3,0.154,1.42,0.054,'2020-11-09 22:01:02','00202440000000014',2),(668,7.57,8.35,0.028,1.73,0.044,'2020-11-09 22:02:02','00202440000000014',2),(669,6.22,4.48,0.101,2.12,0.05,'2020-11-09 22:03:02','00202440000000014',4),(670,6.91,7.78,0.065,2.9,0.06,'2020-11-09 22:04:02','00202440000000014',2),(671,7.36,8.63,0.025,2.13,0.033,'2020-11-09 22:05:02','00202440000000014',2),(672,7.13,9.41,0.025,1.68,0.047,'2020-11-09 22:06:02','00202440000000014',2),(673,6.73,5.89,0.081,2.47,0.042,'2020-11-09 22:07:02','00202440000000014',3),(674,7.16,7.05,0.051,5.84,0.016,'2020-11-09 22:08:02','00202440000000014',3),(675,7.43,9.18,0.025,1.5,0.049,'2020-11-09 22:09:02','00202440000000014',2),(676,7.8,7.99,0.45,4.1,0.06,'2020-11-09 22:10:02','00202440000000014',3),(677,8,9.11,0.025,1.58,0.007,'2020-11-09 22:11:02','00202440000000014',1),(678,6.79,10.89,0.111,2.07,0.072,'2020-11-09 22:12:02','00202440000000014',2),(679,6.47,7.11,0.074,1.47,0.042,'2020-11-09 22:13:02','00202440000000014',2),(680,7.15,7.94,0.318,2.47,0.019,'2020-11-09 22:14:02','00202440000000014',2),(681,6.77,8.28,0.165,1.05,0.005,'2020-11-09 22:15:02','00202440000000014',2),(682,6.28,3.73,0.058,1.53,0.093,'2020-11-09 22:16:02','00202440000000014',4),(683,6.74,8.04,0.025,0.94,0.014,'2020-11-09 22:17:02','00202440000000014',1),(684,7.81,7.33,0.546,1.96,0.223,'2020-11-09 22:18:02','00202440000000014',4),(685,7.57,7.51,0.479,2.64,0.11,'2020-11-09 22:19:02','00202440000000014',3),(686,7.46,8.5,0.072,1.99,0.062,'2020-11-09 22:20:02','00202440000000014',2),(687,7.47,8.37,0.025,1.13,0.069,'2020-11-09 22:21:02','00202440000000014',2),(688,7.45,7.9,0.025,1.89,0.076,'2020-11-09 22:22:02','00202440000000014',2),(689,8.06,7.41,0.025,3.43,0.046,'2020-11-09 22:23:02','00202440000000014',2),(690,7.28,8.8,0.025,2.38,0.048,'2020-11-09 22:24:02','00202440000000014',3),(691,6.47,8.97,0.095,2.18,0.08,'2020-11-09 22:25:02','00202440000000014',2),(692,7.33,9.13,0.09,0.58,0.021,'2020-11-09 22:26:02','00202440000000014',2),(693,6.71,6.37,0.025,2.42,0.014,'2020-11-09 22:27:02','00202440000000014',2),(694,7.57,8.83,0.04,3.12,0.048,'2020-11-09 22:28:02','00202440000000014',2),(695,7.32,8.57,1.657,3.19,0.125,'2020-11-09 22:29:02','00202440000000014',5),(696,8.5,11.88,0.217,3.87,0.056,'2020-11-09 22:30:02','00202440000000014',4),(697,7.16,7.49,0.081,3.11,0.042,'2020-11-09 22:31:02','00202440000000014',2),(698,7.19,8.92,0.123,1.68,0.079,'2020-11-09 22:32:02','00202440000000014',2),(699,6.85,8.74,0.097,2.35,0.047,'2020-11-09 22:33:02','00202440000000014',2),(700,7.4,7.34,0.066,1.82,0.06,'2020-11-09 22:34:02','00202440000000015',2),(701,6.71,6.38,0.262,1.73,0.05,'2020-11-09 22:35:02','00202440000000015',2),(702,7.5,8.36,0.289,0.88,0.042,'2020-11-09 22:36:02','00202440000000015',2),(703,7.42,6.16,0.036,1.7,0.042,'2020-11-09 22:37:02','00202440000000015',2),(704,7.97,9.87,0.055,0.84,0.036,'2020-11-09 22:38:02','00202440000000015',2),(705,7.64,8.53,0.069,0.38,0.12,'2020-11-09 22:39:02','00202440000000015',3),(706,7.47,8.1,0.135,1.16,0.026,'2020-11-09 22:40:02','00202440000000015',2),(707,7.59,7.02,0.127,2.06,0.036,'2020-11-09 22:41:02','00202440000000015',2),(708,6.94,10.9,0.064,0.41,0.024,'2020-11-09 22:42:02','00202440000000015',2),(709,6.69,7.89,1.686,4.39,0.208,'2020-11-09 22:43:02','00202440000000015',5),(710,7.22,6.66,0.025,1.16,0.015,'2020-11-09 22:44:02','00202440000000015',2),(711,6.86,8.06,0.105,1.76,0.021,'2020-11-09 22:45:02','00202440000000015',2),(712,7.95,8.75,0.112,1.62,0.024,'2020-11-09 22:46:02','00202440000000015',2),(713,6.64,8.33,0.119,1.43,0.029,'2020-11-09 22:47:02','00202440000000015',2),(714,7.32,9.62,0.259,1.38,0.075,'2020-11-09 22:48:02','00202440000000015',2),(715,7.48,8.31,0.098,1.89,0.115,'2020-11-09 22:49:02','00202440000000015',3),(716,7.2,8.9,0.04,1.3,0.06,'2020-11-09 22:50:02','00202440000000015',2),(717,7.72,8.91,0.047,2.61,0.046,'2020-11-09 22:51:02','00202440000000015',2),(718,7.84,8.82,0.025,0.66,0.005,'2020-11-09 22:52:02','00202440000000015',1),(719,7.35,8.2,0.114,2.15,0.05,'2020-11-09 22:53:02','00202440000000015',2),(720,7.63,8.65,0.095,1.84,0.093,'2020-11-09 22:54:02','00202440000000015',2),(721,6.73,7.72,0.158,1.1,0.05,'2020-11-09 22:55:02','00202440000000015',2),(722,7.03,6.98,0.141,2.62,0.109,'2020-11-09 22:56:02','00202440000000015',3),(723,7.85,9.07,0.037,2.18,0.058,'2020-11-09 22:57:02','00202440000000015',2),(724,7.08,3.88,0.025,2.66,0.031,'2020-11-09 22:58:02','00202440000000015',4),(725,7.11,8.51,0.029,2.48,0.065,'2020-11-09 22:59:02','00202440000000015',2),(726,7.08,6.3,0.199,1.61,0.012,'2020-11-09 23:00:02','00202440000000015',2),(727,7.19,6.63,0.338,2.52,0.049,'2020-11-09 23:01:02','00202440000000015',2),(728,6.95,8.55,0.048,2.26,0.07,'2020-11-09 23:02:02','00202440000000015',2),(729,7.17,8.66,0.056,1.68,0.109,'2020-11-09 23:03:02','00202440000000015',3),(730,7.07,7.85,0.076,1.44,0.079,'2020-11-09 23:04:02','00202440000000015',2),(731,7.27,8.52,0.528,1.43,0.101,'2020-11-09 23:05:02','00202440000000015',3),(732,7.98,8.83,0.674,3.95,0.192,'2020-11-09 23:06:02','00202440000000015',3),(733,8.18,8.91,0.152,4.52,0.087,'2020-11-09 23:07:02','00202440000000015',3),(734,8.36,10.18,0.093,2.4,0.017,'2020-11-09 23:08:02','00202440000000015',2),(735,7.68,6.72,0.063,0.36,0.039,'2020-11-09 23:09:02','00202440000000015',2),(736,7.68,7.33,0.272,1.49,0.021,'2020-11-09 23:10:02','00202440000000015',2),(737,7.56,4.98,0.025,5.18,0.094,'2020-11-09 23:11:02','00202440000000015',4),(738,7.36,6.27,0.025,3.36,0.022,'2020-11-09 23:12:02','00202440000000015',2),(739,7.69,9.69,0.025,2.52,0.009,'2020-11-09 23:13:02','00202440000000015',2),(740,7.6,9.88,0.026,4.05,0.025,'2020-11-09 23:14:02','00202440000000015',3),(741,7.66,8.39,0.025,2.76,0.018,'2020-11-09 23:15:02','00202440000000015',2),(742,7.82,8.35,0.12,2.87,0.06,'2020-11-09 23:16:02','00202440000000015',2),(743,7.99,7.28,0.281,6.33,0.092,'2020-11-09 23:17:02','00202440000000015',4),(744,7.8,7.91,0.09,3.55,0.245,'2020-11-09 23:18:02','00202440000000015',4),(745,7.76,7.16,0.12,4.95,0.033,'2020-11-09 23:19:02','00202440000000015',3),(746,8.26,9.37,0.64,5.21,0.081,'2020-11-09 23:20:02','00202440000000015',3),(747,8.78,20.03,0.754,15.7,0.224,'2020-11-09 23:21:02','00202440000000015',6),(748,8.34,7.93,0.11,5.7,0.032,'2020-11-09 23:22:02','00202440000000015',3),(749,8.61,8.54,0.495,26.15,0.411,'2020-11-09 23:23:02','00202440000000015',6),(750,8.98,12.27,0.072,10.19,0.1,'2020-11-09 23:24:02','00202440000000016',5),(751,8.23,9.6,0.034,8.33,0.102,'2020-11-09 23:25:02','00202440000000016',4),(752,8.36,9.44,0.056,3.63,0.035,'2020-11-09 23:26:02','00202440000000016',2),(753,7.87,8.09,0.328,7.23,0.107,'2020-11-09 23:27:02','00202440000000016',4),(754,8.15,8.74,0.059,4.57,0.038,'2020-11-09 23:28:02','00202440000000016',3),(755,7.55,9.34,0.038,3.2,0.04,'2020-11-09 23:29:02','00202440000000016',2),(756,7.87,8.64,0.029,3.83,0.038,'2020-11-09 23:30:02','00202440000000016',2),(757,8.25,9.65,0.426,7.94,0.117,'2020-11-09 23:31:02','00202440000000016',4),(758,7.95,7.3,0.15,4.84,0.131,'2020-11-09 23:32:02','00202440000000016',3),(759,8.01,7.55,0.08,5.64,0.107,'2020-11-09 23:33:02','00202440000000016',3),(760,7.53,6.93,0.46,4.76,0.048,'2020-11-09 23:34:02','00202440000000016',3),(761,7.9,8.89,0.05,2.75,0.072,'2020-11-09 23:35:02','00202440000000016',2),(762,8.5,8.84,0.07,3.28,0.035,'2020-11-09 23:36:02','00202440000000016',2),(763,7.74,6.83,0.1,5.08,0.075,'2020-11-09 23:37:02','00202440000000016',3),(764,7.82,12.19,0.1,5.76,0.083,'2020-11-09 23:38:02','00202440000000016',3),(765,8.76,9.61,0.123,5.66,0.05,'2020-11-09 23:39:02','00202440000000016',3),(766,7.89,7.4,0.1,6.68,0.005,'2020-11-09 23:40:02','00202440000000016',4),(767,8.2,6.56,0.05,3.46,0.038,'2020-11-09 23:41:02','00202440000000016',3),(768,8.47,8.64,0.07,3.91,0.037,'2020-11-09 23:42:02','00202440000000016',2),(769,8.38,8.92,0.039,5.71,0.058,'2020-11-09 23:43:02','00202440000000016',3),(770,7.56,8.65,0.14,3.94,0.041,'2020-11-09 23:44:02','00202440000000016',2),(771,8.05,9.22,0.025,3.68,0.055,'2020-11-09 23:45:02','00202440000000016',2),(772,8.49,15.78,0.067,9.75,0.198,'2020-11-09 23:46:02','00202440000000016',4),(773,8.54,18.07,0.04,6.17,0.128,'2020-11-09 23:47:02','00202440000000016',4),(774,7.89,9.94,0.057,2.95,0.022,'2020-11-09 23:48:02','00202440000000016',2),(775,8.35,9.54,0.29,7.05,0,'2020-11-09 23:49:02','00202440000000016',4),(776,7.83,8.96,0.21,2.66,0,'2020-11-09 23:50:02','00202440000000016',2),(777,8.62,11.28,0.025,4.24,0.057,'2020-11-09 23:51:02','00202440000000016',3),(778,8.26,11.71,0.044,4.72,0.077,'2020-11-09 23:52:02','00202440000000016',3),(779,8.75,10.7,0.08,5.17,0.131,'2020-11-09 23:53:02','00202440000000016',3),(780,8.01,8.35,0.12,5.45,0.181,'2020-11-09 23:54:02','00202440000000016',3),(781,7.85,6.81,0.05,2.16,0.034,'2020-11-09 23:55:02','00202440000000016',3),(782,8.41,17.53,0.062,9.7,0.122,'2020-11-09 23:56:02','00202440000000016',4),(783,8.51,11.28,0.026,8.81,0.126,'2020-11-09 23:57:02','00202440000000016',4),(784,8.34,10.31,0.127,4.31,0.051,'2020-11-09 23:58:02','00202440000000016',3),(785,8.85,10.5,0.025,2.71,0.012,'2020-11-09 23:59:02','00202440000000016',2),(786,8.7,20,0.042,6.11,0.062,'2020-11-10 00:00:02','00202440000000016',4),(787,7.95,8.46,0.045,4.98,0.104,'2020-11-10 00:01:02','00202440000000016',3),(788,8.62,10.16,0.035,6.18,0.036,'2020-11-10 00:02:02','00202440000000016',4),(789,8.58,10.42,0.042,3.73,0.061,'2020-11-10 00:03:02','00202440000000016',2),(790,8.42,9.76,0.062,2.05,0.073,'2020-11-10 00:04:02','00202440000000016',2),(791,7.83,8.54,0.227,4.93,0.09,'2020-11-10 00:05:02','00202440000000016',3),(792,8.69,12.03,0.099,7.48,0.101,'2020-11-10 00:06:02','00202440000000016',4),(793,7.44,7.16,1.785,8.36,0.091,'2020-11-10 00:07:02','00202440000000016',5),(794,7.89,11.27,0.246,4.76,0.09,'2020-11-10 00:08:02','00202440000000016',3),(795,8.1,8.97,0.154,2.26,0.019,'2020-11-10 00:09:02','00202440000000016',2),(796,7.92,7.43,0.36,5.48,0.065,'2020-11-10 00:10:02','00202440000000016',3),(797,7.69,6.83,0.126,8.11,0.076,'2020-11-10 00:11:02','00202440000000016',4),(798,7.8,9.09,0.286,6.7,0.13,'2020-11-10 00:12:02','00202440000000016',4),(799,8.14,10.07,0.031,1.84,0.048,'2020-11-10 00:13:02','00202440000000016',2),(800,8.02,10.8,0.034,2.49,0.045,'2020-11-10 00:14:02','00202440000000017',2),(801,7.32,7.26,0.025,1.63,0.038,'2020-11-10 00:15:02','00202440000000017',2),(802,7.66,9.55,0.26,4.13,0.169,'2020-11-10 00:16:02','00202440000000017',3),(803,8.09,8.76,0.025,2.36,0.012,'2020-11-10 00:17:02','00202440000000017',2),(804,7.99,9.11,0.078,2,0.019,'2020-11-10 00:18:02','00202440000000017',1),(805,8.18,8.78,0.025,2.95,0.014,'2020-11-10 00:19:02','00202440000000017',2),(806,8.13,8.54,0.025,2.55,0.012,'2020-11-10 00:20:02','00202440000000017',2),(807,7.35,3.15,0.025,4.2,0.022,'2020-11-10 00:21:02','00202440000000017',4),(808,8.25,10.57,0.025,3.99,0.01,'2020-11-10 00:22:02','00202440000000017',2),(809,7.94,10.04,0.16,1.69,0.04,'2020-11-10 00:23:02','00202440000000017',2),(810,7.77,8.56,0.044,3.43,0.049,'2020-11-10 00:24:02','00202440000000017',2),(811,8.1,8.7,0.031,1.06,0.005,'2020-11-10 00:25:02','00202440000000017',1),(812,7.48,8.76,0.025,0.74,0.006,'2020-11-10 00:26:02','00202440000000017',1),(813,8.1,9.12,0.025,0.56,0.005,'2020-11-10 00:27:02','00202440000000017',1),(814,7.75,8.1,0.18,4.56,0.298,'2020-11-10 00:28:02','00202440000000017',4),(815,8.08,7.81,0.16,3.83,0.022,'2020-11-10 00:29:02','00202440000000017',2),(816,7.72,7.1,0.674,3.9,0.174,'2020-11-10 00:30:02','00202440000000017',3),(817,7.94,5.85,0.56,5.41,0.156,'2020-11-10 00:31:02','00202440000000017',3),(818,7.78,6.54,0.21,4.32,0.089,'2020-11-10 00:32:02','00202440000000017',3),(819,7.79,7.41,0.101,3.81,0.032,'2020-11-10 00:33:02','00202440000000017',2),(820,7.99,4.8,0.025,4,0.019,'2020-11-10 00:34:02','00202440000000017',4),(821,8.43,9.83,0.025,2.76,0.142,'2020-11-10 00:35:02','00202440000000017',3),(822,8.36,9.44,0.15,1.48,0.062,'2020-11-10 00:36:02','00202440000000017',2),(823,8.35,12.04,0.054,3.35,0.039,'2020-11-10 00:37:02','00202440000000017',2),(824,8.27,2.94,0.19,4.63,0.048,'2020-11-10 00:38:02','00202440000000017',5),(825,8.14,8.86,0.025,2.28,0.005,'2020-11-10 00:39:02','00202440000000017',2),(826,8.17,6.67,0.194,5.13,0.069,'2020-11-10 00:40:02','00202440000000017',3),(827,8.2,8.81,0.86,3.52,0.083,'2020-11-10 00:41:02','00202440000000017',3),(828,7.95,7.94,0.08,3.99,0.008,'2020-11-10 00:42:02','00202440000000017',2),(829,8.13,8.56,0.06,3.66,0.037,'2020-11-10 00:43:02','00202440000000017',2),(830,7.71,7.93,0.025,3.48,0.31,'2020-11-10 00:44:02','00202440000000017',5),(831,8.06,10.57,0.12,3.08,0.015,'2020-11-10 00:45:02','00202440000000017',2),(832,8.23,6.21,0.29,4.25,0.071,'2020-11-10 00:46:02','00202440000000017',3),(833,8.08,6.66,0.21,4.18,0.045,'2020-11-10 00:47:02','00202440000000017',3),(834,8.09,8.42,0.025,2.16,0.009,'2020-11-10 00:48:02','00202440000000017',2),(835,8.36,9.07,0.025,1.69,0.012,'2020-11-10 00:49:02','00202440000000017',2),(836,8.15,9.04,0.058,2.29,0.031,'2020-11-10 00:50:02','00202440000000017',2),(837,7.9,9.44,0.059,1.93,0.025,'2020-11-10 00:51:02','00202440000000017',2),(838,7.77,9.59,0.083,1.57,0.012,'2020-11-10 00:52:02','00202440000000017',1),(839,7.42,7.86,0.056,1.88,0.012,'2020-11-10 00:53:02','00202440000000017',1),(840,7.89,8.26,0.103,2.08,0.013,'2020-11-10 00:54:02','00202440000000017',2),(841,7.84,7.66,0.025,1.94,0.01,'2020-11-10 00:55:02','00202440000000017',2),(842,7.76,8.23,0.066,1.94,0.007,'2020-11-10 00:56:02','00202440000000017',1),(843,8.48,12.07,0.025,4.13,0.031,'2020-11-10 00:57:02','00202440000000017',3),(844,7.99,9.08,0.025,0.96,0.021,'2020-11-10 00:58:02','00202440000000017',2),(845,8.23,10.83,0.025,1.82,0.005,'2020-11-10 00:59:02','00202440000000017',1),(846,8.06,8.12,0.025,2.7,0.028,'2020-11-10 01:00:02','00202440000000017',2),(847,7.69,9.92,0.025,1.91,0.019,'2020-11-10 01:01:02','00202440000000017',1),(848,8.23,7.24,0.13,6.74,0.098,'2020-11-10 01:02:02','00202440000000017',4),(849,7.46,9.42,0.025,3.69,0.055,'2020-11-10 01:03:02','00202440000000017',2),(850,8.04,8.22,2.09,8.27,2.193,'2020-11-10 01:04:02','00202440000000018',6),(851,8.4,12.6,0.28,8.03,0.101,'2020-11-10 01:05:02','00202440000000018',4),(852,6.91,7.07,0.064,4.06,0,'2020-11-10 01:06:02','00202440000000018',3),(853,7.71,7.69,0.025,3.94,0.034,'2020-11-10 01:07:02','00202440000000018',2),(854,7.15,8.58,0.025,4.9,0.09,'2020-11-10 01:08:02','00202440000000018',3),(855,7.47,8.61,0.025,3.33,0.067,'2020-11-10 01:09:02','00202440000000018',2),(856,7,5.32,0.111,4.01,0.008,'2020-11-10 01:10:02','00202440000000018',3),(857,7.13,5.68,0.025,2.59,0.008,'2020-11-10 01:11:02','00202440000000018',3),(858,7.6,8.53,0.042,2.27,0.116,'2020-11-10 01:12:02','00202440000000018',3),(859,7.73,7.58,0.025,3.59,0.025,'2020-11-10 01:13:02','00202440000000018',2),(860,7.46,6.04,0.59,4.39,0,'2020-11-10 01:14:02','00202440000000018',3),(861,7.61,5.71,0.771,3.37,0.152,'2020-11-10 01:15:02','00202440000000018',3),(862,8.04,10.17,0.079,2.4,0.032,'2020-11-10 01:16:02','00202440000000018',2),(863,8.13,8.58,0.13,4.01,0.081,'2020-11-10 01:17:02','00202440000000018',3),(864,8.57,11.09,0.04,6.69,0.049,'2020-11-10 01:18:02','00202440000000018',4),(865,7.97,10.54,0.06,5.43,0.095,'2020-11-10 01:19:02','00202440000000018',3),(866,7.61,10.06,0.17,2.62,0.133,'2020-11-10 01:20:02','00202440000000018',3),(867,7.7,8.23,0.186,2.85,0.077,'2020-11-10 01:21:02','00202440000000018',2),(868,7.25,6.24,0.298,3.86,0.05,'2020-11-10 01:22:02','00202440000000018',2),(869,7.79,7.1,0.025,1.77,0.014,'2020-11-10 01:23:02','00202440000000018',2),(870,8.03,7.58,0.025,2.58,0.105,'2020-11-10 01:24:02','00202440000000018',3),(871,8.1,6.21,0.14,1.28,0.013,'2020-11-10 01:25:02','00202440000000018',2),(872,8.11,9.96,0.025,2.17,0.018,'2020-11-10 01:26:02','00202440000000018',2),(873,7.86,7.64,0.512,5.96,0.225,'2020-11-10 01:27:02','00202440000000018',4),(874,6.77,6.15,0.11,3.1,0.11,'2020-11-10 01:28:02','00202440000000018',3),(875,8.83,13.11,0.025,4.97,0.038,'2020-11-10 01:29:02','00202440000000018',3),(876,8.08,8.82,0.025,4.95,0.021,'2020-11-10 01:30:02','00202440000000018',3),(877,7.81,8.65,0.025,4.05,0.022,'2020-11-10 01:31:02','00202440000000018',3),(878,8.35,9.21,0.025,4.92,0.04,'2020-11-10 01:32:02','00202440000000018',3),(879,7.83,8.03,0.118,4.86,0.005,'2020-11-10 01:33:02','00202440000000018',3),(880,7.94,7.95,0.025,2.37,0.059,'2020-11-10 01:34:02','00202440000000018',2),(881,8.48,11.16,0.333,4.04,0.049,'2020-11-10 01:35:02','00202440000000018',3),(882,7.74,8.34,0.344,5.08,0.015,'2020-11-10 01:36:02','00202440000000018',3),(883,7.01,4.32,0.792,5.99,0.194,'2020-11-10 01:37:02','00202440000000018',4),(884,6.7,5.7,0.685,3.06,0.094,'2020-11-10 01:38:02','00202440000000018',3),(885,7.08,3.97,0.872,4.67,0.073,'2020-11-10 01:39:02','00202440000000018',4),(886,8.32,3.19,0.546,6.76,0.073,'2020-11-10 01:40:02','00202440000000018',4),(887,7.3,3.07,0.248,6.53,0.094,'2020-11-10 01:41:02','00202440000000018',4),(888,7.3,7.72,0.73,4.66,0.124,'2020-11-10 01:42:02','00202440000000018',3),(889,7.59,8.27,0.025,1.66,0.072,'2020-11-10 01:43:02','00202440000000018',2),(890,7.78,6.89,0.025,2.53,0.058,'2020-11-10 01:44:02','00202440000000018',2),(891,8.21,9.06,0.315,3.13,0.08,'2020-11-10 01:45:02','00202440000000018',2),(892,8.11,13.65,0.029,0.94,0.01,'2020-11-10 01:46:02','00202440000000018',1),(893,7.79,9.89,0.108,1.81,0.044,'2020-11-10 01:47:02','00202440000000018',2),(894,8.1,10.13,0.04,5.22,0.117,'2020-11-10 01:48:02','00202440000000018',3),(895,8,10.09,0.065,3.58,0.024,'2020-11-10 01:49:02','00202440000000018',2),(896,7.88,7.56,0.111,1.79,0.013,'2020-11-10 01:50:02','00202440000000018',2),(897,7.98,7.98,0.039,1.7,0.005,'2020-11-10 01:51:02','00202440000000018',1),(898,7.83,8.42,0.072,2.01,0.04,'2020-11-10 01:52:02','00202440000000018',2),(899,7.9,8.08,0.12,1.49,0.075,'2020-11-10 01:53:02','00202440000000018',2),(900,7.53,10.25,0.06,0.97,0.007,'2020-11-10 01:54:02','00202440000000019',1),(901,7.65,8.62,0.035,1.74,0.005,'2020-11-10 01:55:02','00202440000000019',1),(902,7.39,6.92,0.047,2.46,0.019,'2020-11-10 01:56:02','00202440000000019',2),(903,8,9.47,0.054,1.69,0.016,'2020-11-10 01:57:02','00202440000000019',1),(905,7.95,7.42,0.276,3.4,0.078,'2020-11-10 01:59:02','00202440000000019',2),(906,7.54,7.05,0.142,1.63,0.059,'2020-11-10 02:00:02','00202440000000019',2),(907,7.34,7.59,0.025,0.59,0.007,'2020-11-10 02:01:02','00202440000000019',1),(908,8.35,8.07,0.025,1.1,0.06,'2020-11-10 02:02:02','00202440000000019',2),(909,7.47,8.49,0.025,1.09,0.013,'2020-11-10 02:03:02','00202440000000019',1),(910,7.92,8.58,0.025,1.32,0.043,'2020-11-10 02:04:02','00202440000000019',2),(911,7.82,11.28,0.031,2.13,0.01,'2020-11-10 02:05:02','00202440000000019',2),(912,7.91,9.09,0.025,1.03,0.03,'2020-11-10 02:06:02','00202440000000019',2),(913,7.42,8.39,0.054,2.78,0.035,'2020-11-10 02:07:02','00202440000000019',2),(914,7.37,7.55,0.025,0.47,0.018,'2020-11-10 02:08:02','00202440000000019',1),(915,7.63,7.95,0.025,2.12,0.006,'2020-11-10 02:09:02','00202440000000019',2),(916,7.7,8.36,0.049,1.02,0.044,'2020-11-10 02:10:02','00202440000000019',2),(917,7.83,7.83,0.125,2.78,0.089,'2020-11-10 02:11:02','00202440000000019',2),(918,8.03,8.88,0.025,2.76,0.115,'2020-11-10 02:12:02','00202440000000019',3),(919,7.74,7.41,0.362,2.83,0.106,'2020-11-10 02:13:02','00202440000000019',3),(920,8.02,8.72,0.025,1.62,0.054,'2020-11-10 02:14:02','00202440000000019',2),(921,7.53,6.98,0.123,2.37,0.036,'2020-11-10 02:15:02','00202440000000019',2),(922,7.26,8.23,0.057,2.31,0.032,'2020-11-10 02:16:02','00202440000000019',2),(923,7.59,7.69,0.247,3.11,0.07,'2020-11-10 02:17:02','00202440000000019',2),(924,7.57,7.82,0.056,2.01,0.008,'2020-11-10 02:18:02','00202440000000019',2),(925,7.86,9.04,0.157,1.54,0.056,'2020-11-10 02:19:02','00202440000000019',2),(926,8.06,10.84,0.045,1.26,0.008,'2020-11-10 02:20:02','00202440000000019',1),(927,7.66,8.11,0.07,2.01,0.012,'2020-11-10 02:21:02','00202440000000019',2),(928,7.69,8.03,0.291,2.11,0.086,'2020-11-10 02:22:02','00202440000000019',2),(929,8.26,9.22,0.025,3.54,0.005,'2020-11-10 02:23:02','00202440000000019',2),(930,7.51,8.75,0.058,3.15,0.046,'2020-11-10 02:24:02','00202440000000019',2),(931,7.41,8.41,0.025,2.45,0.065,'2020-11-10 02:25:02','00202440000000019',2),(932,7.56,7.39,0.183,4.21,0.119,'2020-11-10 02:26:02','00202440000000019',3),(933,8.07,8.83,0.025,2.23,0.047,'2020-11-10 02:27:02','00202440000000019',2),(934,8.02,9.17,0.025,2.19,0.024,'2020-11-10 02:28:02','00202440000000019',2),(935,7.53,7.53,0.134,3.3,0.134,'2020-11-10 02:29:02','00202440000000019',3),(936,7.66,7.65,0.025,4.6,0.198,'2020-11-10 02:30:02','00202440000000019',3),(937,7.55,8.06,0.025,1.91,0.086,'2020-11-10 02:31:02','00202440000000019',2),(938,7.47,10.01,0.025,4.65,0.038,'2020-11-10 02:32:02','00202440000000019',3),(940,7.31,9.35,0.025,2.58,0.039,'2020-11-10 02:34:02','00202440000000019',2),(941,7.92,8.61,0.025,2.82,0.028,'2020-11-10 02:35:02','00202440000000019',2),(942,7.21,8.75,0.047,4.37,0.074,'2020-11-10 02:36:02','00202440000000019',3),(943,7.82,9.58,0.025,3.35,0.076,'2020-11-10 02:37:02','00202440000000019',2),(944,7.79,8.83,0.08,1.87,0,'2020-11-10 02:38:02','00202440000000019',1),(946,8.44,8.99,0.044,1.22,0.052,'2020-11-10 02:40:02','00202440000000019',2),(947,7.7,8.1,0.161,2.95,0.075,'2020-11-10 02:41:02','00202440000000019',2),(948,7.71,9.71,0.072,1.29,0.058,'2020-11-10 02:42:02','00202440000000019',2),(950,8.16,9.51,0.025,2.1,0.045,'2020-11-10 02:44:02','00202440000000020',2),(951,7.95,8.87,0.025,1.8,0.065,'2020-11-10 02:45:02','00202440000000020',2),(952,8.26,8.83,0.091,1.22,0.104,'2020-11-10 02:46:02','00202440000000020',3),(953,8.18,8.93,0.025,1.24,0.075,'2020-11-10 02:47:02','00202440000000020',2),(954,7.54,8.33,0.059,1.21,0.073,'2020-11-10 02:48:02','00202440000000020',2),(955,6.87,10.31,0.059,1.71,0,'2020-11-10 02:49:02','00202440000000020',1),(956,6.52,8.62,0.049,3.55,0.043,'2020-11-10 02:50:02','00202440000000020',3),(957,6.79,7.68,0.025,2.34,0.041,'2020-11-10 02:51:02','00202440000000020',2),(958,7.11,6.88,0.043,1.59,0.04,'2020-11-10 02:52:02','00202440000000020',2),(959,6.66,6.61,0.025,3.8,0.081,'2020-11-10 02:53:02','00202440000000020',2),(960,7.81,7.69,0.025,1.81,0.072,'2020-11-10 02:54:02','00202440000000020',2),(962,7.6,7.91,0.033,1.43,0.014,'2020-11-10 02:56:02','00202440000000020',2),(963,7.54,7.05,0.6,1.16,0.1,'2020-11-10 02:57:02','00202440000000020',3),(964,7.02,6.44,0.048,1.75,0.036,'2020-11-10 02:58:02','00202440000000020',2),(965,7.4,7.76,0.295,1.5,0.036,'2020-11-10 02:59:02','00202440000000020',2),(966,7.45,8.75,0.159,2.86,0.048,'2020-11-10 03:00:02','00202440000000020',2),(967,7.9,9.65,0.073,4.21,0.038,'2020-11-10 03:01:02','00202440000000020',3),(968,7.44,8.76,0.128,3.07,0.039,'2020-11-10 03:02:02','00202440000000020',2),(969,7.98,9.18,0.087,1.74,0.045,'2020-11-10 03:03:02','00202440000000020',2),(970,7.58,7.8,0.025,0.91,0.022,'2020-11-10 03:04:02','00202440000000020',2),(971,7.74,7.52,0.142,1.45,0.092,'2020-11-10 03:05:02','00202440000000020',2),(972,8.17,10.77,0.025,1.57,0.048,'2020-11-10 03:06:02','00202440000000020',2),(973,7.72,9.26,0.025,1.14,0.017,'2020-11-10 03:07:02','00202440000000020',1),(974,7.46,6.64,0.149,0.25,0.026,'2020-11-10 03:08:02','00202440000000020',2),(975,7.66,9.23,0.032,1.01,0.022,'2020-11-10 03:09:02','00202440000000020',2),(976,7.7,8.85,0.132,2.14,0.059,'2020-11-10 03:10:02','00202440000000020',2),(977,7.84,8.69,0.048,3.79,0.051,'2020-11-10 03:11:02','00202440000000020',2),(979,7.68,8.07,0.187,2.77,0.072,'2020-11-10 03:13:02','00202440000000020',2),(981,7.99,10.45,0.185,3.38,0.041,'2020-11-10 03:15:02','00202440000000020',2),(982,6.65,8.78,0.07,1.49,0.045,'2020-11-10 03:16:02','00202440000000020',2),(983,6.9,7.56,0.15,2.61,0.077,'2020-11-10 03:17:02','00202440000000020',2),(984,7.09,8.58,0.35,2.26,0.075,'2020-11-10 03:18:02','00202440000000020',2),(985,7.57,8.71,0.124,3.2,0.056,'2020-11-10 03:19:02','00202440000000020',2),(986,7.73,7.53,0.128,2.48,0.036,'2020-11-10 03:20:02','00202440000000020',2),(987,7.43,7.03,0.493,1.88,0.117,'2020-11-10 03:21:02','00202440000000020',3),(988,7.08,7.69,0.026,1.96,0.049,'2020-11-10 03:22:02','00202440000000020',2),(989,7.8,7.68,0.087,1.77,0.024,'2020-11-10 03:23:02','00202440000000020',2),(990,7.8,7.99,0.048,1.01,0.011,'2020-11-10 03:24:02','00202440000000020',1),(991,7.85,8.29,0.025,2.74,0.029,'2020-11-10 03:25:02','00202440000000020',2),(992,8.05,9.48,0.068,0.95,0.03,'2020-11-10 03:26:02','00202440000000020',2),(993,7.38,7.68,0.081,2.3,0.063,'2020-11-10 03:27:02','00202440000000020',2),(994,7.33,7.43,0.034,1.55,0.033,'2020-11-10 03:28:02','00202440000000020',2),(995,7.8,7.86,0.037,1.01,0.03,'2020-11-10 03:29:02','00202440000000020',2),(996,7.46,5.94,0.075,1.49,0.053,'2020-11-10 03:30:02','00202440000000020',3),(997,7.53,9.42,0.058,0.72,0.029,'2020-11-10 03:31:02','00202440000000020',2),(998,7.67,7.97,0.071,1.11,0.035,'2020-11-10 03:32:02','00202440000000020',2),(999,7.61,7.93,0.087,1.48,0.037,'2020-11-10 03:33:02','00202440000000020',2);
/*!40000 ALTER TABLE `waterdata` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-05  9:20:14
