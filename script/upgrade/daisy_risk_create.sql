-- 2017-08-31迭代
alter table daisy_user add column s_pre_concern varchar(400) COMMENT '预置关注的企业逗号分隔';

CREATE TABLE `risk_service_package` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `api_code` varchar(100) NOT NULL COMMENT '对应的api_code',
  `name` varchar(100) NOT NULL COMMENT '套餐名称',
  `desc` varchar(1000) DEFAULT NULL COMMENT '描述',
  `money` int(11) NOT NULL COMMENT '套餐价格(元)',
  `type` tinyint(4) NOT NULL COMMENT '种类 1是api  2是风险评估',
  `expiry_months` int(11) NOT NULL COMMENT '有效期：月',
  `query_upper` int(11) NOT NULL COMMENT '查询次数上限',
  `concern_upper` int(11) DEFAULT NULL COMMENT '关注上限 type=2即风控报告才有',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

CREATE TABLE `risk_user_package_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_no` char(16) NOT NULL COMMENT '订单号',
  `user_code` varchar(100) NOT NULL COMMENT '用户编码',
  `package_id` bigint(20) NOT NULL COMMENT '套餐id',
  `order_type` tinyint(4) NOT NULL COMMENT '购买类型0试用  1新购  2续费',
  `order_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `expire_time` char(19) DEFAULT NULL COMMENT '有效期至',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;