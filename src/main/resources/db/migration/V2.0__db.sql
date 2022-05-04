
-- Host: localhost    Database: medicare
-- ------------------------------------------------------
-- Server version	8.0.24

--
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `medicarecard`
-- 创建医保卡表
--

DROP TABLE IF EXISTS `medicarecard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicarecard` (
  `medicare_card_num` varchar(16) NOT NULL UNIQUE,/*医保号*/
  `identity_card_num` varchar(18) NOT NULL UNIQUE,/*身份证号*/
  `medicare_type` int(1) not null default 0,/*医保类别 0:未参保 1:城镇职工 2:城镇居民 3:新农合*/
  `name` varchar(15) NOT NULL,/*姓名*/
  `sex` int(1) NOT NULL,/*性别 0:男 1：女*/
  `nation` varchar(20),/*民族*/
  `insurance_time` date,/*参保时间*/
  `account_balance` int default 0,/*账户余额*/
  PRIMARY KEY (`medicare_card_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

/*插入原始医保卡数据*/
INSERT INTO `medicarecard`(`medicare_card_num`, `identity_card_num`, `medicare_type`, `name`, `sex` ) VALUES ( 1234512345123456, '130421197603309432', 1, '东方红', 0);
INSERT INTO `medicarecard`(`medicare_card_num`, `identity_card_num`, `medicare_type`, `name`, `sex` ) VALUES ( 2345623456234567, '370827199303149792', 0, '宋炯辉', 0);
INSERT INTO `medicarecard`(`medicare_card_num`, `identity_card_num`, `medicare_type`, `name`, `sex` ) VALUES ( 3456734567345678, '230127197701109595', 2, '李学年', 0);
INSERT INTO `medicarecard`(`medicare_card_num`, `identity_card_num`, `medicare_type`, `name`, `sex` ) VALUES ( 4567845678456789, '371082197306296977', 3, '佟国华', 0);
INSERT INTO `medicarecard`(`medicare_card_num`, `identity_card_num`, `medicare_type`, `name`, `sex` ) VALUES ( 5678956789567890, '150428198706252232', 3, '郑奕忠', 0);
INSERT INTO `medicarecard`(`medicare_card_num`, `identity_card_num`, `medicare_type`, `name`, `sex` ) VALUES ( 6789067890678901, '220283199001228191', 2, '张东岳', 0);
INSERT INTO `medicarecard`(`medicare_card_num`, `identity_card_num`, `medicare_type`, `name`, `sex` ) VALUES ( 7890178901789012, '410422197404186082', 0, '牛怡聪', 1);
INSERT INTO `medicarecard`(`medicare_card_num`, `identity_card_num`, `medicare_type`, `name`, `sex` ) VALUES ( 8901289012890123, '330902198503152909', 1, '钱雪娣', 1);
INSERT INTO `medicarecard`(`medicare_card_num`, `identity_card_num`, `medicare_type`, `name`, `sex` ) VALUES ( 9012390123901234, '13032419910203770X', 2, '贺思嘉', 1);
INSERT INTO `medicarecard`(`medicare_card_num`, `identity_card_num`, `medicare_type`, `name`, `sex` ) VALUES ( 1111122222333334, '230125197605034420', 3, '徐蕙莉', 1);
INSERT INTO `medicarecard`(`medicare_card_num`, `identity_card_num`, `medicare_type`, `name`, `sex` ) VALUES ( 2222233333444445, '340403199104114548', 1, '谢郭艳', 1);
INSERT INTO `medicarecard`(`medicare_card_num`, `identity_card_num`, `medicare_type`, `name`, `sex` ) VALUES ( 3333344444555556, '62092219900331160X', 1, '柯冬梅', 1);

--
-- Table structure for table `user`
-- 创建用户表
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `medicare_card_num` varchar(16) NOT NULL UNIQUE,/*医保号*/
  `password` varchar(20) NOT NULL,
  `user_role` int(1) NOT NULL default 2,/*用户角色 0:管理员 1:工作人员 2:普通用户*/
  PRIMARY KEY (`medicare_card_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

/*插入原始用户数据（包括管理员和工作人员）*/
INSERT INTO `user` VALUES ( 0, 00000000, 0);
INSERT INTO `user` VALUES ( 11, 11111111, 1);
INSERT INTO `user` VALUES ( 22, 22222222, 1);
INSERT INTO `user` VALUES ( 1234512345123456, 12345678, 2);
INSERT INTO `user` VALUES ( 3333344444555556, 12345678, 2);

--
-- Table structure for table `person`
-- 创建个人信息表
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `medicare_card_num` varchar(16) NOT NULL UNIQUE,/*医保号*/
  `bank_account` varchar(20) NOT NULL,/*银行卡号*/
  `telephone` varchar(11),/*手机号*/
  `address` varchar(40),/*家庭住址*/
  PRIMARY KEY (`medicare_card_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `medicine`
-- 创建药物表
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicine` (
  `medicine_num` varchar(15) NOT NULL UNIQUE,/*药品编号*/
  `medicine_name` varchar(20) NOT NULL,/*药品名*/
  `medicine_type` int(1) NOT NULL,/*药品类别 0:A类药品 1:B类药品 2:C类药品*/
  `medicine_price` decimal(10,2) NOT NULL default 0,/*药品价格*/
  `medicine_producer` varchar(40) NOT NULL,/*药品产商*/
  PRIMARY KEY (`medicine_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

/*插入原始药品数据*/
INSERT INTO `medicine` VALUES ('M00000000000001', '感冒清热颗粒', 0, 22.0, '制药厂1');
INSERT INTO `medicine` VALUES ('M00000000000002', '葛根汤片', 1, 15.2, '制药厂2');
INSERT INTO `medicine` VALUES ('M00000000000003', '银翘解毒丸', 1, 65.3, '制药厂4');
INSERT INTO `medicine` VALUES ('M00000000000004', '复方硼砂', 0, 41.0, '制药厂3');
INSERT INTO `medicine` VALUES ('M00000000000005', '氯己定', 1, 10.2, '制药厂5');
INSERT INTO `medicine` VALUES ('M00000000000006', '大枣', 2, 13.0, '制药厂6');

--
-- Table structure for table `treatment_project`
-- 创建诊疗项目表
--

DROP TABLE IF EXISTS `treatment_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treatment_project` (
  `treatment_project_num` varchar(15) NOT NULL UNIQUE ,/*诊疗项目编号*/
  `treatment_project_name` varchar(30) NOT NULL,/*诊疗项目名称*/
  `treatment_project_type` int(1) NOT NULL default 2,/*诊疗项目类别 0:全部统筹 1:部分统筹 2:不统筹*/
  `treatment_project_price` decimal (10,2) DEFAULT 0 NOT NULL,/*诊疗项目价格*/
  `treatment_project_percentage` double DEFAULT 1.0,/*个人自费的比例 全部统筹为0， 不统筹为1*/
  PRIMARY KEY (`treatment_project_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

/*插入原始诊疗项目数据*/
INSERT INTO `treatment_project` VALUES ('P00000000000001', '普通挂号费', 2, 10, 1);
INSERT INTO `treatment_project` VALUES ('P00000000000002', '专家挂号费', 2, 40, 1);
INSERT INTO `treatment_project` VALUES ('P00000000000003', '核磁共振成像装置(MRI)', 1, 380, 0.15);
INSERT INTO `treatment_project` VALUES ('P00000000000004', '伽玛刀(γ-刀)', 1, 23000, 0.4);
INSERT INTO `treatment_project` VALUES ('P00000000000005', '全额报销项目1', 0, 100, 0);
INSERT INTO `treatment_project` VALUES ('P00000000000006', '全额报销项目2', 0, 2233, 0);

--
-- Table structure for table `service_facility`
-- 创建服务设施表
--

DROP TABLE IF EXISTS `service_facility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_facility` (
  `service_facility_num` varchar(15) NOT NULL UNIQUE ,/*服务设施编号*/
  `service_facility_name` varchar(20) NOT NULL,/*服务设施名称*/
  `service_facility_price` decimal (10,2) NOT NULL,/*服务设施价格*/
  `service_facility_type` int(1) NOT NULL default 1,/*报销类型 0：可报销 1：不可报销*/
  PRIMARY KEY (`service_facility_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

/*插入原始服务设施数据*/
INSERT INTO `service_facility` VALUES ('F00000000000001', '急救车车费', 200, 1);
INSERT INTO `service_facility` VALUES ('F00000000000002', '住院陪护费', 180, 1);
INSERT INTO `service_facility` VALUES ('F00000000000003', '普通床位费', 30, 0);
INSERT INTO `service_facility` VALUES ('F00000000000004', '高级床位费', 80, 0);

--
-- Table structure for table `hospital_institution`
-- 创建医院机构表
--

DROP TABLE IF EXISTS `hospital_institution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hospital_institution` (
  `hospital_institution_num` varchar(15) NOT NULL UNIQUE ,/*医院编号*/
  `hospital_institution_name` varchar(36) NOT NULL,/*医院名称*/
  `hospital_institution_type` int(1) NOT NULL,/*医院级别  1:一级医院 2:二级医院 3:三甲医院*/
  `hospital_institution_telephone` varchar(11),/*医院电话*/
  `hospital_institution_address` varchar(50),/*医院地址*/
  PRIMARY KEY (`hospital_institution_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

/*插入原始医院机构数据*/
INSERT INTO `hospital_institution` VALUES ('I00000000000001', '哈尔滨市第一医院', 3, 15612458841, '黑龙江省哈尔滨市香坊区某街道3号');
INSERT INTO `hospital_institution` VALUES ('I00000000000002', '哈尔滨市第二医院', 3, 18596214574, '黑龙江省哈尔滨市松北区某街道5号');
INSERT INTO `hospital_institution` VALUES ('I00000000000003', '哈尔滨市第三医院', 2, 17946158421, '黑龙江省哈尔滨市道里区某街道7号');
INSERT INTO `hospital_institution` VALUES ('I00000000000004', '哈尔滨市第四医院', 2, 19461873526, '黑龙江省哈尔滨市道外区某街道2号');
INSERT INTO `hospital_institution` VALUES ('I00000000000005', '哈尔滨市第五医院', 1, 14152365235, '黑龙江省哈尔滨市某某区某街道6号');

--
-- Table structure for table `reimbursement_record`
-- 创建报销记录表
--

DROP TABLE IF EXISTS `reimbursement_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reimbursement_record` (
  `reimbursement_record_num` varchar(15) NOT NULL UNIQUE ,/*记录编号*/
  `reimbursement_record_user_medicare_card_num` varchar(16) NOT NULL,/*报销人员医保卡号*/
  `reimbursement_record_user_name` varchar(15) NOT NULL,/*报销人员名称*/
  `reimbursement_record_amount` decimal(10,2) NOT NULL,/*报销金额*/
  `reimbursement_record_time` date,/*报销日期*/
  PRIMARY KEY (`reimbursement_record_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

