
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
-- Table structure for table `medicare_card`
-- 创建医保卡表
--

DROP TABLE IF EXISTS `medicare_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicare_card` (
  `medicare_card_num` varchar(16) NOT NULL UNIQUE,/*医保号*/
  `identity_card_num` varchar(18) NOT NULL UNIQUE,/*身份证号*/
  `medicare_type` int(1) not null,/*医保类别 1:城镇职工 2:城镇居民 3:新农合*/
  `medicare_status` int(1) not null default 0,/*医保状态 0：未缴费 1：已缴费 */
  `medicare_name` varchar(15) NOT NULL,/*姓名*/
  `medicare_sex` int(1) NOT NULL,/*性别 0:男 1：女*/
  `medicare_age` int NOT NULL,/*年龄*/
  `medicare_nation` varchar(20),/*民族*/
  `insurance_time` date,/*参保时间*/
  PRIMARY KEY (`medicare_card_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

/*插入原始医保卡数据*/
INSERT INTO `medicare_card` VALUES ( '1234512345123456', '130421197603309432', 1, 1, '东方红', 0,46,'汉族','1999-06-21');
INSERT INTO `medicare_card` VALUES ( '2345623456234567', '370827199303149792', 1, 0, '宋炯辉', 0,29,'蒙古族','2013-04-13');
INSERT INTO `medicare_card` VALUES ( '3456734567345678', '230127197701109595', 2, 1, '李学年', 0,45,'傣族','1998-12-25');
INSERT INTO `medicare_card` VALUES ( '4567845678456789', '371082197306296977', 3, 1, '佟国华', 0,49,'汉族','1994-01-27');
INSERT INTO `medicare_card` VALUES ( '5678956789567890', '150428198706252232', 3, 1, '郑奕忠', 0,35,'独龙族','2004-05-07');
INSERT INTO `medicare_card` VALUES ( '6789067890678901', '220283199001228191', 2, 1, '张东岳', 0,32,'朝鲜族','2009-08-29');
INSERT INTO `medicare_card` VALUES ( '7890178901789012', '410422197404186082', 3, 0, '牛怡聪', 1,48,'藏族','1996-03-19');
INSERT INTO `medicare_card` VALUES ( '8901289012890123', '330902198503152909', 1, 1, '钱雪娣', 1,37,'汉族','2008-07-31');
INSERT INTO `medicare_card` VALUES ( '9012390123901234', '13032419910203770X', 2, 1, '贺思嘉', 1,31,'黎族','2016-10-01');
INSERT INTO `medicare_card` VALUES ( '1111122222333334', '230125197605034420', 3, 1, '徐蕙莉', 1,46,'怒族','1998-01-18');
INSERT INTO `medicare_card` VALUES ( '2222233333444445', '340403199104114548', 1, 1, '谢郭艳', 1,31,'满族','2014-11-04');
INSERT INTO `medicare_card` VALUES ( '3333344444555556', '62092219900331160X', 1, 1, '柯冬梅', 1,32,'汉族','2011-06-18');

--
-- Table structure for table `worker`
-- 创建工作人员表
--

DROP TABLE IF EXISTS `worker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `worker` (
  `worker_num` varchar(6) NOT NULL UNIQUE,/*工号*/
  `worker_name` varchar(20) NOT NULL,/*工作人员姓名*/
  `worker_identity_num` varchar(18) NOT NULL UNIQUE,/*身份证号*/
  `worker_sex` int(1),/*性别 0:男 1：女*/
  `worker_organization` varchar(40),/*工作单位*/
  `worker_address` varchar(60),/*工作地点*/
  PRIMARY KEY (`worker_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

/*插入工作人员数据*/
INSERT INTO `worker` VALUES ('111111','郝帅', '110101199003079972', 0, '东城医保报销中心','北京市东城区某个街某个号');
INSERT INTO `worker` VALUES ('222222','甄美丽', '310112200006123483', 1, '闵行医保报销中心','上海市闵行区某个街某个号');

--
-- Table structure for table `user`
-- 创建用户表
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `account` varchar(16) NOT NULL UNIQUE,/*医保号*/
  `password` varchar(20) NOT NULL,
  `user_role` int(1) NOT NULL default 2,/*用户角色类别 0:管理员 1:工作人员 2:普通用户*/
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

/*插入原始用户数据（包括管理员和工作人员）*/
INSERT INTO `user` VALUES ( '000', '00000000', 0);
INSERT INTO `user` VALUES ( '111111', '11111111', 1);
INSERT INTO `user` VALUES ( '222222', '22222222', 1);
INSERT INTO `user` VALUES ( '1234512345123456', '12345678', 2);
INSERT INTO `user` VALUES ( '3333344444555556', '12345678', 2);

--
-- Table structure for table `person`
-- 创建个人信息表
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `account` varchar(16) NOT NULL UNIQUE,/*账号*/
  `bank_account` varchar(20),/*银行卡号*/
  `telephone` varchar(11),/*手机号*/
  `address` varchar(50),/*家庭住址*/
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO `person` VALUES('111111', '6222025407177968336', '18982541179','北京市东城区某个小区某个楼');
INSERT INTO `person` VALUES('222222', '6217992349280927032', '13383593819','上海市闵行区某个花园某个楼');
INSERT INTO `person` VALUES('1234512345123456', '6222620360011016815', '17325622016','黑龙江省哈尔滨市香坊区某个小区某个楼');
INSERT INTO `person` VALUES('3333344444555556', '6222620360011016815', '15532567372','海南省海口市琼山区云龙村某号楼');

--
-- Table structure for table `medicine`
-- 创建药物表
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicine` (
  `medicine_num` varchar(36) NOT NULL UNIQUE,/*药品编号*/
  `medicine_name` varchar(20) NOT NULL,/*药品名*/
  `medicine_type` int(1) NOT NULL,/*药品类别 0:甲类药品 1:乙类药品 2:丙类药品*/
  `medicine_price` decimal(10,2) NOT NULL default 0,/*药品价格*/
  `medicine_producer` varchar(40),/*药品产商*/
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
  `treatment_project_num` varchar(36) NOT NULL UNIQUE ,/*诊疗项目编号*/
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
  `service_facility_num` varchar(36) NOT NULL UNIQUE ,/*服务设施编号*/
  `service_facility_name` varchar(20) NOT NULL,/*服务设施名称*/
  `service_facility_price` decimal (10,2) NOT NULL,/*服务设施价格*/
  `service_facility_type` int(1) NOT NULL default 1,/*服务设施类别 0：可报销 1：不可报销*/
  `service_facility_percentage` double DEFAULT 1.0,/*个人自费的比例 全部报销为0， 不报销为1*/
  PRIMARY KEY (`service_facility_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

/*插入原始服务设施数据*/
INSERT INTO `service_facility` VALUES ('F00000000000001', '急救车车费', 200, 1, 1);
INSERT INTO `service_facility` VALUES ('F00000000000002', '住院陪护费', 180, 1, 1);
INSERT INTO `service_facility` VALUES ('F00000000000003', '普通床位费', 30, 0, 0.5);
INSERT INTO `service_facility` VALUES ('F00000000000004', '高级床位费', 80, 0, 0.7);

--
-- Table structure for table `institution`
-- 创建定点机构表
--

DROP TABLE IF EXISTS `institution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `institution` (
  `institution_num` varchar(36) NOT NULL UNIQUE ,/*定点机构编号*/
  `institution_name` varchar(40) NOT NULL,/*定点机构名称*/
  `institution_type` int(1) NOT NULL,/*定点机构类别  1:一级医院 2:二级医院 3:三甲医院*/
  `institution_telephone` varchar(11),/*定点机构电话*/
  `institution_address` varchar(60),/*定点机构地址*/
  PRIMARY KEY (`institution_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

/*插入原始医院机构数据*/
INSERT INTO `institution` VALUES ('I00000000000001', '哈尔滨市第一医院', 3, '15612458841', '黑龙江省哈尔滨市香坊区某街道3号');
INSERT INTO `institution` VALUES ('I00000000000002', '哈尔滨市第二医院', 3, '18596214574', '黑龙江省哈尔滨市松北区某街道5号');
INSERT INTO `institution` VALUES ('I00000000000003', '哈尔滨市第三医院', 2, '17946158421', '黑龙江省哈尔滨市道里区某街道7号');
INSERT INTO `institution` VALUES ('I00000000000004', '哈尔滨市第四医院', 2, '19461873526', '黑龙江省哈尔滨市道外区某街道2号');
INSERT INTO `institution` VALUES ('I00000000000005', '哈尔滨市第五医院', 1, '14152365235', '黑龙江省哈尔滨市某某区某街道6号');


-- Table structure for table `request_base`
-- 创建报销请求基础表
--

DROP TABLE IF EXISTS `request_base`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request_base` (
    `rb_id` varchar(36) NOT NULL UNIQUE,/*请求rb编号*/
    `rb_user` varchar(16) NOT NULL ,/*请求的用户 医保号*/
    `rb_worker` varchar(6),/*审批人员工号*/
    `rb_institution` varchar(36) NOT NULL,/*就医的定点机构编号*/
    `rb_type` int(1) NOT NULL,/*就医类别 0：门诊 1：住院*/
    `rb_status` int(1) NOT NULL DEFAULT 0,/*请求的状态 0：申请 1：审核中 2：审核不通过 3：审核通过 4：计算完成 5：支付完成*/
    `rb_money` decimal(10,2),/*报销金额*/
    `rb_start_time` date,/*起始时间*/
    `rb_finish_time` date,/*结束时间*/
    `rb_submit_time` date,/*提交时间*/
    `rb_fail_reason` varchar(100),/*审核不通过的原因*/
    PRIMARY KEY (`rb_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Table structure for table `request_content`
-- 创建报销请求内容表
--

DROP TABLE IF EXISTS `request_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request_content` (
    `rc_id` varchar(36) NOT NULL ,/*请求编号 与request_base表中rb_id相同*/
    `rc_type` int(1) NOT NULL,/*物品类别 0:基本信息 1：药品 2：诊疗项目 3：服务设施*/
    `rc_item_id` varchar(36) NOT NULL ,/*物品编号*/
    `rc_item_quantity` int NOT NULL DEFAULT 1,/*物品数量*/
    PRIMARY KEY (`rc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


-- Table structure for table `request_image`
-- 创建报销请求材料表
--

DROP TABLE IF EXISTS `request_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request_image` (
    `ri_id` varchar(36) NOT NULL ,/*请求编号 与request_base表中rb_id相同*/
    `ri_type` int(1) NOT NULL,/*物品类别 0:基本信息 1：药品 2：诊疗项目 3：服务设施*/
    `ri_path` varchar(100) NOT NULL,/*证明材料路径（图片）*/
    PRIMARY KEY (`ri_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `reimbursement_record`
-- 创建报销记录表
--

DROP TABLE IF EXISTS `reimbursement_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reimbursement_record` (
  `record_num` varchar(36) NOT NULL UNIQUE ,/*记录编号*/
  `record_request_id` varchar(36) NOT NULL, /*请求编号*/
  `record_medicare_card_num` varchar(16) NOT NULL,/*医保人员医保卡号*/
  `record_worker_num` varchar(6) NOT NULL,/*审批人员工号*/
  `record_amount` decimal(10,2) NOT NULL,/*报销金额*/
  `record_time` date NOT NULL,/*报销日期*/
  PRIMARY KEY (`record_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

