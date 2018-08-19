-- ----------------------------
-- Table structure for `daisy_tenant`
-- ----------------------------
DROP TABLE IF EXISTS `daisy_tenant`;
CREATE TABLE `daisy_tenant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `s_code` varchar(50) NOT NULL COMMENT '租户编码',
  `s_name` varchar(100) DEFAULT NULL COMMENT '租户名称',
  `s_desc` varchar(200) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `daisy_user`
-- ----------------------------
DROP TABLE IF EXISTS `daisy_user`;
CREATE TABLE `daisy_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `s_code` varchar(50) NOT NULL COMMENT '用户编码',
  `s_name` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `s_pwd` varchar(50) NOT NULL COMMENT '密码',
  `s_access_key` varchar(100) DEFAULT NULL COMMENT '访问api的accessKey',
  `s_email` varchar(50) DEFAULT NULL COMMENT '邮件',
  `s_phone` varchar(15) DEFAULT NULL COMMENT '电话号码',
  `s_tenant_code` varchar(30) DEFAULT NULL COMMENT '所属租户编码',
  `i_type` tinyint(4) NOT NULL COMMENT '1:企业 2：个人',
  `i_status` tinyint(4) NOT NULL COMMENT '1:正常 2：账号异常 3:账户欠费',
  `s_create_time` char(19) DEFAULT NULL COMMENT '创建及修改时间',
  `s_update_time` char(19) DEFAULT NULL,
  `s_open_time` char(19) DEFAULT NULL COMMENT '开通生效时间',
  `i_concern_limit` int(11) NOT NULL DEFAULT '5' COMMENT '关注上限',
  `i_query_limit` int(11) NOT NULL DEFAULT '5' COMMENT '查询的企业个数限制',
  `s_alt_email` text COMMENT '变更接收邮件',
  `i_access_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1:测试账户 2:正式账户',
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_unique_code_ctx` (`s_code`) USING BTREE,
  UNIQUE KEY `i_unique_mail_ctx` (`s_email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `risk_api_invoke`
-- ----------------------------
DROP TABLE IF EXISTS `risk_api_invoke`;
CREATE TABLE `risk_api_invoke` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `s_user_code` varchar(50) NOT NULL COMMENT '用户编码',
  `s_api_code` varchar(100) NOT NULL COMMENT 'api服务名',
  `s_open_time` char(19) NOT NULL DEFAULT '' COMMENT '服务开通时间',
  `i_call_num` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户调用此接口的次数',
  `s_last_call_time` char(19) DEFAULT NULL COMMENT '最后调用时间',
  PRIMARY KEY (`id`),
  KEY `i_api_invoke_code` (`s_user_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `risk_api_document`
-- ----------------------------
DROP TABLE IF EXISTS `risk_api_document`;
CREATE TABLE `risk_api_document` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `s_api_code` varchar(100) NOT NULL,
  `s_api_content` longtext NOT NULL,
  `s_update_time` char(19) NOT NULL DEFAULT '' COMMENT '文档更新时间',
  `i_order` int(11) NOT NULL COMMENT '排序',
  `i_call_num` bigint(20) NOT NULL DEFAULT '0' COMMENT '调用次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=235 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `risk_api_invoke_log`
-- ----------------------------
alter table risk_api_invoke_log add column i_call_type TINYINT(4) not null default 0 COMMENT '0:接口调用 1:调试调用';
alter table risk_api_invoke_log add column i_cost_mills int not null default 100 COMMENT '接口调用花费时长:毫秒';
alter table risk_api_invoke_log add column s_query_condition varchar(3000) COMMENT '查询条件';
alter table risk_api_invoke_log add index i_log_user_api (s_visit_code,s_api_code) USING BTREE;



-- ----------------------------
-- Table structure for `risk_api_invoke_mapping`
-- ----------------------------
DROP TABLE IF EXISTS `risk_api_invoke_mapping`;
CREATE TABLE `risk_api_invoke_mapping` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(100) NOT NULL COMMENT '字段名称',
  `s_yonyou_code` varchar(100) NOT NULL COMMENT '用友对外提供的编码',
  `s_other_code` varchar(100) NOT NULL COMMENT '提供商提供的编码',
  `s_provider_code` varchar(50) NOT NULL COMMENT '提供商编码',
  `s_api_code` varchar(100) NOT NULL COMMENT '接口编码',
  `s_desc` varchar(200) DEFAULT NULL COMMENT '字段描述',
  `i_as_source` tinyint(1) NOT NULL DEFAULT '0' COMMENT '1:生效 0:不生效  生效的直接作为数据来源',
  `i_resove_level` tinyint(4) NOT NULL DEFAULT '1' COMMENT '级别，1：字段级别解析 2.VO级别解析',
  PRIMARY KEY (`id`),
  KEY `i_api_code_src_level` (`s_api_code`,`i_as_source`,`i_resove_level`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=698 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `risk_api_provide`
-- ----------------------------
DROP TABLE IF EXISTS `risk_api_provide`;
CREATE TABLE `risk_api_provide` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `s_api_code` varchar(100) NOT NULL COMMENT '方法编码',
  `s_api_name` varchar(100) NOT NULL COMMENT '接口名称',
  `s_api_desc` varchar(2000) DEFAULT NULL COMMENT '接口描述',
  `s_persist_table` varchar(50) DEFAULT NULL COMMENT 'api返回数据持久化到hbase表名',
  `i_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1:企业接口2：个人接口',
  `i_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '0:不可用 1:可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `risk_enterprise`
-- ----------------------------
DROP TABLE IF EXISTS `risk_enterprise`;
CREATE TABLE `risk_enterprise` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `s_name` varchar(50) NOT NULL COMMENT '公司名称',
  `s_legal_person_name` varchar(20) DEFAULT NULL COMMENT '法人名字',
  `s_legal_person_id` varchar(19) DEFAULT NULL COMMENT '法人身份证号',
  `s_industry` varchar(30) DEFAULT NULL COMMENT '社会统一编码',
  `i_isValid` tinyint(2) DEFAULT NULL COMMENT '是否可用',
  `updateTime` varchar(50) DEFAULT NULL COMMENT '更新时间',
  `sRegCap` varchar(20) DEFAULT NULL COMMENT '注册资本',
  `sLitigationNum` varchar(20) DEFAULT NULL COMMENT '涉诉数量',
  `sRegDate` varchar(50) DEFAULT NULL COMMENT '成立时间',
  `sCaseInfoNum` varchar(20) DEFAULT NULL COMMENT '行政监管数量',
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_unique_indsutry` (`s_industry`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=502 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `risk_enterprise_group`
-- ----------------------------
DROP TABLE IF EXISTS `risk_enterprise_group`;
CREATE TABLE `risk_enterprise_group` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `i_ent_id` bigint(11) NOT NULL COMMENT '公司名称',
  `i_user_group_id` bigint(11) NOT NULL COMMENT '法人名字',
  `create_time` char(19) NOT NULL DEFAULT '' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=409 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `risk_person_metadata`
-- ----------------------------
DROP TABLE IF EXISTS `risk_person_metadata`;
CREATE TABLE `risk_person_metadata` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `s_id_card` varchar(18) NOT NULL COMMENT '身份证号',
  `s_provider_code` varchar(50) NOT NULL COMMENT '提供商编码',
  `s_api_code` varchar(100) NOT NULL COMMENT '接口编码',
  `s_update_time` char(19) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_provider_api_id` (`s_id_card`,`s_provider_code`,`s_api_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `risk_provider`
-- ----------------------------
DROP TABLE IF EXISTS `risk_provider`;
CREATE TABLE `risk_provider` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `s_code` varchar(50) NOT NULL COMMENT '提供商编码',
  `s_name` varchar(100) NOT NULL COMMENT '公司名称',
  `i_period` int(11) NOT NULL COMMENT '有效期，单位：天',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `risk_provider_invoke`
-- ----------------------------
DROP TABLE IF EXISTS `risk_provider_invoke`;
CREATE TABLE `risk_provider_invoke` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `s_provider_code` varchar(50) NOT NULL COMMENT '提供商编码',
  `s_api_code` varchar(100) NOT NULL COMMENT '接口编码',
  `i_priority` int(11) NOT NULL COMMENT '优先级，数字越小，优先级越高',
  `s_type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `risk_provider_invoke_meta`
-- ----------------------------
DROP TABLE IF EXISTS `risk_provider_invoke_meta`;
CREATE TABLE `risk_provider_invoke_meta` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `s_provider_code` varchar(50) NOT NULL COMMENT '接口提供者',
  `s_api_code` varchar(100) NOT NULL COMMENT '接口',
  `s_par_api_code` varchar(100) NOT NULL DEFAULT '' COMMENT '父接口',
  `s_type` varchar(20) NOT NULL DEFAULT '' COMMENT '构造类型  object,list',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `risk_user_ent_queried`
-- ----------------------------
DROP TABLE IF EXISTS `risk_user_ent_queried`;
CREATE TABLE `risk_user_ent_queried` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `s_user_code` varchar(50) NOT NULL COMMENT '用户编码',
  `i_ent_id` bigint(20) NOT NULL COMMENT '企业表主键',
  `update_time` char(19) NOT NULL DEFAULT '' COMMENT '最后查询时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `risk_user_group`
-- ----------------------------
DROP TABLE IF EXISTS `risk_user_group`;
CREATE TABLE `risk_user_group` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `s_user_code` varchar(50) DEFAULT NULL COMMENT '用户编码',
  `s_name` varchar(50) NOT NULL COMMENT '分组名字',
  `i_is_edit` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否可以编辑',
  `s_update_time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `risk_ent_metadata`
-- ----------------------------
DROP TABLE IF EXISTS `risk_ent_metadata`;
CREATE TABLE `risk_ent_metadata` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `s_key` varchar(50) NOT NULL COMMENT '注册号或公司名称',
  `s_provider_code` varchar(50) NOT NULL COMMENT '提供商编码',
  `s_api_code` varchar(100) NOT NULL COMMENT '接口编码',
  `s_update_time` char(19) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_provider_api_key` (`s_key`,`s_provider_code`,`s_api_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `risk_enterprise_push`
-- ----------------------------
DROP TABLE IF EXISTS `risk_enterprise_push`;
CREATE TABLE `risk_enterprise_push` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ent_name` varchar(300) NOT NULL COMMENT '企业名称',
  `credit_code` varchar(50) DEFAULT NULL,
  `request_time` char(19) DEFAULT NULL,
  `response_time` char(19) DEFAULT NULL,
  `persist_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0:未保存到hbase 1:成功保存到hbase中',
  `message` longtext,
  `is_available` tinyint(4) DEFAULT '0' COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5072 DEFAULT CHARSET=utf8;

