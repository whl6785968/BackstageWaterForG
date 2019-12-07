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
INSERT INTO `district` VALUES ('001','玄武湖片区'),('002','石臼湖片区'),('003','秦淮河流域'),('004','长江南京流域');
/*!40000 ALTER TABLE `district` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equip_sta`
--

LOCK TABLES `equip_sta` WRITE;
/*!40000 ALTER TABLE `equip_sta` DISABLE KEYS */;
INSERT INTO `equip_sta` VALUES (1,'00202440000000003','001'),(2,'00202440000000004','002'),(3,'00202440000000005','001'),(5,'00202440000000006','003'),(6,'00202440000000007','004'),(7,'00202440000000008','005'),(9,'00202440000000009','006');
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
INSERT INTO `equipment` VALUES ('00202440000000003','便携式水质检测仪','G781 SN051201711000128','2019-11-15 06:41:55',7,'波思途智能有效股份公司',1),('00202440000000004','高级水质检测仪','GPRS232-734','2019-11-16 02:12:48',7,'波思途智能有效股份公司',3),('00202440000000005','便携式水质检测仪','G781 SN051201711000128','2019-11-16 02:12:31',7,'波思途智能有效股份公司',2),('00202440000000006','高级水质检测仪','GPRS232-734','2019-11-15 17:08:00',7,'波思途智能有效股份公司',1),('00202440000000007','便携式水质检测仪','G781 SN051201711000128','2019-11-15 17:08:56',7,'波思途智能有效股份公司',3),('00202440000000008','便携式水质检测仪','G781 SN051201711000128','2019-11-28 17:09:49',7,'波思途智能有效股份公司',2),('00202440000000009','高级水质检测仪','GPRS232-734','2019-11-28 17:14:09',7,'波思途智能有效股份公司',1);
/*!40000 ALTER TABLE `equipment` ENABLE KEYS */;
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
INSERT INTO `menu` VALUES (0,'/','/dashboard','dashboard','all',NULL,1,NULL,1,1),(1,'/','/dashboard','dashboard','userManager',NULL,1,0,1,1),(2,'/','/dashboard','dashboard','Data',NULL,1,0,1,1),(3,'/sys/user/**','/userManager/authContol','authControl','authControl',NULL,1,1,1,1),(4,'/data/basic/**','/dataRelated/equipList','checkData','checkData',NULL,1,2,1,1),(5,'/sys/menu/**','/userManager/menuConfig','menuConfig','menuConfig',NULL,1,1,1,1),(6,'/user/basic/**','/dashboard','dashboard','userbasic',NULL,1,0,0,0),(7,'/data/basic/**','/dataRelated/equipList/dataDetails/:id','dataDetails','dataDetails',NULL,1,2,1,0),(8,'/data/basic/**','/dataRelated/map','map','map',NULL,1,2,1,1),(9,'/','dashboard','dashboard','message',NULL,1,0,1,1),(10,'/msg/basic/**','/msg/posting','posting','posting',NULL,1,9,1,1),(11,'/msg/basic/**','/msg/readablePost','readablePost','readablePost',NULL,1,9,1,1),(12,'/sys/msg/**','/msg/review','review','review',NULL,1,9,1,1),(13,'/msg/basic/**','/msg/postDetail/:id','postDetail','postDetail',NULL,1,9,1,0),(14,'/','dashboard','dashboard','report',NULL,1,0,1,1),(15,'/report/basic/**','/report/reportList','reportList','reportList',NULL,1,14,1,1),(16,'/report/basic/**','/report/reportDeatils/:createTime','reportDetails','reportDetails',NULL,1,14,1,0),(17,'/','/dashboard','dashboard','algo',NULL,1,0,1,1),(18,'/algo/basic/**','/algo/anomalyMonitoring','isoForest','anomalyMonitoring',NULL,1,17,1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `msg`
--

LOCK TABLES `msg` WRITE;
/*!40000 ALTER TABLE `msg` DISABLE KEYS */;
INSERT INTO `msg` VALUES (48,'7a328021afbc446e87bfe7c4487f76271574669482776','111','111','',0,1,'2019-11-25 00:11:23','','test1'),(49,'34e0870d173c42b3ac1d28fd91ff87951574669874599','client test','client test','',0,1,'2019-11-25 00:17:55','','test2'),(50,'89d70fdab63648d6a20104647d7ffcbd1574670154709','admin test','admin test','',0,1,'2019-11-25 00:22:35','','test1'),(51,'37415f0d443c43b1b8907ab15fc4d0261574672157752','珂朵莉祈求无BUG','我是珂学家，BUG全没啦','/static/d1148cebb5804b46b4e1eaa163fb44c5.jpg',0,1,'2019-11-25 00:55:58','','test2'),(52,'a988b5947e6e4c2cb9b87e576fa9a1181574672321609','这是一条永远的not review 消息','谁也发现不了我~','/static/8de7933c92e64ba69ba04e90aea7aa6e.jpg',0,0,'2019-11-25 00:58:42','其他','test1');
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
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `msg_user`
--

LOCK TABLES `msg_user` WRITE;
/*!40000 ALTER TABLE `msg_user` DISABLE KEYS */;
INSERT INTO `msg_user` VALUES (39,'34e0870d173c42b3ac1d28fd91ff87951574669874599','test2',1),(40,'89d70fdab63648d6a20104647d7ffcbd1574670154709','test1',1),(41,'89d70fdab63648d6a20104647d7ffcbd1574670154709','test2',1),(42,'37415f0d443c43b1b8907ab15fc4d0261574672157752','test1',1),(43,'37415f0d443c43b1b8907ab15fc4d0261574672157752','test2',1),(44,'a988b5947e6e4c2cb9b87e576fa9a1181574672321609','test1',1);
/*!40000 ALTER TABLE `msg_user` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=196 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_menu`
--

LOCK TABLES `role_menu` WRITE;
/*!40000 ALTER TABLE `role_menu` DISABLE KEYS */;
INSERT INTO `role_menu` VALUES (173,'777',3),(174,'777',5),(175,'777',4),(176,'777',7),(177,'777',8),(178,'777',10),(179,'777',11),(180,'777',12),(181,'777',13),(182,'777',15),(183,'777',16),(184,'001',4),(185,'001',7),(186,'001',8),(187,'001',10),(188,'001',11),(189,'001',13),(190,'001',15),(191,'001',16),(193,'777',18),(195,'001',18);
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station`
--

LOCK TABLES `station` WRITE;
/*!40000 ALTER TABLE `station` DISABLE KEYS */;
INSERT INTO `station` VALUES ('001','玄武湖菱州',118.805263,32.076485,2,3,'test1'),('002','石臼湖',118.960993,31.507898,1,2,'test2'),('003','玄武湖东湖',118.806053,32.074526,4,3,'test1'),('004','玄武湖北湖',118.802352,32.08704,3,2,'test1'),('005','玄武湖牡丹岛',118.815081,32.076309,2,3,'test1'),('006','石臼湖2',118.3,37.0025,3,3,'test2');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station_district`
--

LOCK TABLES `station_district` WRITE;
/*!40000 ALTER TABLE `station_district` DISABLE KEYS */;
INSERT INTO `station_district` VALUES (1,'001','001'),(2,'002','002'),(3,'003','001'),(4,'004','001'),(5,'005','001'),(6,'006','002');
/*!40000 ALTER TABLE `station_district` ENABLE KEYS */;
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
INSERT INTO `user` VALUES ('test1','123'),('test2','456'),('test3','789');
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
INSERT INTO `user_role` VALUES (0,'test1','777'),(1,'test2','001'),(2,'test3','002');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_station`
--

LOCK TABLES `user_station` WRITE;
/*!40000 ALTER TABLE `user_station` DISABLE KEYS */;
INSERT INTO `user_station` VALUES (1,'test2','001'),(2,'test2','002');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (1,'sandalen','男',23,'','18245803818','','创作者','eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJ0ZXN0MSJ9.YMSVk5QQSEaELA3q1LKWRa7MIoCrRcdCXoQsDMB-0cc','test1'),(2,'张亮','女',23,'','13843854438','','38','eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJ0ZXN0MiJ9.J6Cl14aQYEBbfTBTxl0koMLnO4cGxEYJw0XSnXTnHUY','test2'),(3,'alex','男',22,'','002','','visitor','eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJ0ZXN0MyJ9.43LPVz9a8_jQDJtkSBANf0yCOCWlGd_3_jBc2Dv_hyE','test3');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usersecurityinfo`
--

LOCK TABLES `usersecurityinfo` WRITE;
/*!40000 ALTER TABLE `usersecurityinfo` DISABLE KEYS */;
INSERT INTO `usersecurityinfo` VALUES (1,0,1,0,0,'2019-11-15 01:56:45','test1'),(2,0,1,0,0,'2019-11-15 01:56:45','test2');
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
  PRIMARY KEY (`id`),
  KEY `eid` (`eid`),
  CONSTRAINT `waterdata_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `equipment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waterdata`
--

LOCK TABLES `waterdata` WRITE;
/*!40000 ALTER TABLE `waterdata` DISABLE KEYS */;
INSERT INTO `waterdata` VALUES (7,7.2,0.33,0.25,0.57,0.89,'2019-11-18 01:04:44','00202440000000003'),(8,6.25,0.57,0.63,0.28,0.79,'2019-11-18 01:05:47','00202440000000003'),(9,7.2,0.33,0.25,0.57,0.89,'2019-11-18 01:05:52','00202440000000004'),(10,6.25,0.57,0.63,0.28,0.79,'2019-11-18 01:05:52','00202440000000004'),(11,7.2,0.33,0.25,0.57,0.89,'2019-11-18 01:05:58','00202440000000005'),(12,6.25,0.57,0.63,0.28,0.79,'2019-11-18 01:05:58','00202440000000005'),(13,6.44,7.96,0.84,3.4,2.37292,'2019-11-29 01:22:40','00202440000000009'),(14,8.05,10.82,0.06,3.19,0,'2019-11-29 01:22:40','00202440000000008'),(15,8.06,11.01,0.95,5.15,2.5,'2019-11-29 01:22:40','00202440000000007'),(16,8.68,13.17,0.07,8.33,0,'2019-11-29 01:22:40','00202440000000006'),(17,7.78,7.44,0,2.24,0,'2019-12-06 02:20:00','00202440000000003'),(21,7.78,7.44,0,2.24,0,'2019-12-06 02:20:00','00202440000000003'),(22,8.53,15.07,0.06,5.28,0,'2019-12-06 02:20:00','00202440000000003'),(23,8.28,10.1,0.08,2.67,0,'2019-12-06 02:20:00','00202440000000003'),(24,7.7,10.38,0.19,2.1,0,'2019-12-06 02:20:00','00202440000000003'),(25,8.94,10.77,0.23,4.79,0,'2019-12-06 02:20:00','00202440000000003'),(26,7.71,11.43,0.14,3.94,0,'2019-12-06 02:20:00','00202440000000003'),(27,7,8.57,0.27,2.65,0,'2019-12-06 02:20:00','00202440000000003'),(28,8.17,12.64,0.19,2.4,0,'2019-12-06 02:20:00','00202440000000003'),(29,7.09,11.54,0.53,9.47,0,'2019-12-06 02:20:00','00202440000000003'),(30,7.29,3.87,0.67,5,0,'2019-12-06 02:20:00','00202440000000003'),(31,7.52,10.18,0.16,2.87,0,'2019-12-06 02:20:00','00202440000000004'),(32,7.7,12.58,0,1.88,0,'2019-12-06 02:20:00','00202440000000004'),(33,7.11,11.1,0.25,5.36,0,'2019-12-06 02:20:00','00202440000000004'),(34,7.75,11.66,0.15,2.96,0,'2019-12-06 02:20:00','00202440000000004'),(35,6.37,9.05,0.79,2.9,2.465,'2019-12-06 02:20:00','00202440000000004'),(36,8.66,16.21,0.02,4.73,0,'2019-12-06 02:20:00','00202440000000004'),(37,7.98,9.05,0.13,0,0,'2019-12-06 02:20:00','00202440000000004'),(38,7.37,8.65,0.06,1.1,0,'2019-12-06 02:20:00','00202440000000004'),(39,7.67,8.28,0,4.57,0,'2019-12-06 02:20:00','00202440000000004'),(40,8.42,10.6,0.52,0,0,'2019-12-06 02:20:00','00202440000000004'),(41,8.15,10.97,0.17,2.68,0,'2019-12-06 02:20:00','00202440000000005'),(42,7.47,8.64,0.26,2.47,0,'2019-12-06 02:20:00','00202440000000005'),(43,7.17,10.5,0,4.12,0,'2019-12-06 02:20:00','00202440000000005'),(44,7.46,8.73,0.46,1.2,0,'2019-12-06 02:20:00','00202440000000005'),(45,7.93,9.58,0.17,0.86,0,'2019-12-06 02:20:00','00202440000000005'),(46,7.91,9.47,0.08,1.62,0,'2019-12-06 02:20:00','00202440000000005'),(47,8.37,5.97,0.2,3.1,0,'2019-12-06 02:20:00','00202440000000005'),(48,7.2,4.22,0.5,4.75,0,'2019-12-06 02:20:00','00202440000000005'),(49,8.04,2.38,0.13,4.15,0,'2019-12-06 02:20:00','00202440000000005'),(50,7.74,10.06,0.27,4.49,0,'2019-12-06 02:20:00','00202440000000005'),(51,8.22,11.3,0,2.61,0,'2019-12-06 02:20:00','00202440000000006'),(52,6.96,8.27,0.26,2.64,0,'2019-12-06 02:20:00','00202440000000006'),(53,7.87,8.55,0.12,1.45,0,'2019-12-06 02:20:00','00202440000000006'),(54,7.95,9.75,0,1.66,0,'2019-12-06 02:20:00','00202440000000006'),(55,7.9,7.76,0.12,1.23,0,'2019-12-06 02:20:00','00202440000000006'),(56,8.67,14.25,0,9.43,0,'2019-12-06 02:20:00','00202440000000006'),(57,7.7,10.38,0.19,2.1,0,'2019-12-06 02:20:00','00202440000000006'),(58,8.09,9.38,0.24,2.02,0,'2019-12-06 02:20:00','00202440000000006'),(59,8.5,15.56,0.08,5.66,0,'2019-12-06 02:20:00','00202440000000006'),(60,7.75,10.52,0.21,0,0,'2019-12-06 02:20:00','00202440000000006'),(61,8.5,9.3,0.57,2.2,0,'2019-12-06 02:20:00','00202440000000007'),(62,8.62,10.37,0.06,6.14,0,'2019-12-06 02:20:00','00202440000000007'),(63,7.65,8.58,0.06,2.32,0,'2019-12-06 02:20:00','00202440000000007'),(64,8.91,8.85,0.32,3.24,0,'2019-12-06 02:20:00','00202440000000007'),(65,8,10.88,0.19,4.18,0,'2019-12-06 02:20:00','00202440000000007'),(66,8.12,12.63,0.25,3.71,0.9,'2019-12-06 02:20:00','00202440000000007'),(67,7.67,12.77,0,1.91,0,'2019-12-06 02:20:00','00202440000000007'),(68,7.78,8.22,0.22,4.19,0,'2019-12-06 02:20:00','00202440000000007'),(69,8.24,7.56,0.26,4.66,0,'2019-12-06 02:20:00','00202440000000007'),(70,8.36,12.18,0.2,3.54,0,'2019-12-06 02:20:00','00202440000000007'),(71,7.52,9.63,0.19,1.88,0,'2019-12-06 02:20:00','00202440000000008'),(72,8.16,9.69,0,3.99,0,'2019-12-06 02:20:00','00202440000000008'),(73,8.52,8.5,0.09,2.29,20,'2019-12-06 02:20:00','00202440000000008'),(74,8.85,10.37,0.08,3.37,0,'2019-12-06 02:20:00','00202440000000008'),(75,7.39,13.8,1.55,5.21,0,'2019-12-06 02:20:00','00202440000000008'),(76,7.69,10.64,0.32,3.37,0,'2019-12-06 02:20:00','00202440000000008'),(77,8.1,9.75,0.47,1.75,0,'2019-12-06 02:20:00','00202440000000008'),(78,7.2,7.76,0,1.16,0,'2019-12-06 02:20:00','00202440000000008'),(79,8.28,10.1,0.08,2.67,0,'2019-12-06 02:20:00','00202440000000009'),(80,7.47,6.73,0.62,4.64,0,'2019-12-06 02:20:00','00202440000000009'),(81,7.75,7.58,0,1.4,0,'2019-12-06 02:20:00','00202440000000009'),(82,7.7,11.45,0.13,3.78,0,'2019-12-06 02:20:00','00202440000000009'),(83,8.19,12.52,0.16,2.26,0,'2019-12-06 02:20:00','00202440000000009'),(84,7.57,12.73,0.61,9.29,0,'2019-12-06 02:20:00','00202440000000009'),(85,7.7,10.06,0.15,5.25,0,'2019-12-06 02:20:00','00202440000000009');
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

-- Dump completed on 2019-12-07 20:17:27
