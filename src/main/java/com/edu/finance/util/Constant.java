package com.edu.finance.util;

public class Constant {
	
	//public static final String RISK_CONTEXT="risk";
	//public static final String VALIDATE_CODE="validate-code";

	// 向外提供接口的状态码
	public static final int STATUS_NO_ACCOUNT = 101;//未传账户信息
	public static final int STATUS_NO_ACCESSKEY = 102;//未传校验信息
	public static final int STATUS_ACCOUNT_INVALID = 103;//非法账户
	public static final int STATUS_NO_INFACE_AUTH = 104;//无此接口服务的权限
	public static final int STATUS_TRANSID_INVALID = 105;//流水号不合法
	public static final int STATUS_EXPIRE = 106;//过期
	public static final int STATUS_OVER_LIMIT = 107;//超过最大次数
	public static final int STATUS_PARAM_INVALID = 110;//参数非法
	public static final int STATUS_NO_CUSTOMER_AUTH = 120;//需要客户授权才可以查询
	public static final int STATUS_NO_SERVICE = 121;//服务不能被调用
	public static final int STATUS_OK = 200;//成功
	public static final int STATUS_EMPTY_WITH_ERROR = 201;//调用三方返回权限、次数限制等原因，导致的错误异常需要仔细过滤后给咱们用户返回
	public static final int STATUS_INNER_ERROR = 500;//服务器内部错误,发生异常的情况

	/**
	 * 发送请求的类型
	 */

	public static final String POST_TYPE_HTTP = "http";
	public static final String POST_TYPE_HTTPS = "https";
	
	
	/**
	 * Hbase用户基本信息表
	 */
	public static final String HBASE_PERSON_BASIC_TABLE = "risk_person_basic";
	public static final String HBASE_COMMON_FAMILY = "info";
	public static final String HBASE_COMMON_DATA_COLUMN = "data";
	public static final String ROWKEY_SEPARATER = "_";
	public static final String ROWKEY_HEAD = "head";
	
	
	/**
	 * 存入Hbase的类型
	 */
	
	public static final String HBASE_TYPE_OBJECT = "object";
	public static final String HBASE_TYPE_LIST = "list";
	public static final String HBASE_TYPE_MIXED = "mixed";
	public static final String HBASE_TYPE_MIXED_STRING = "string";
	
}
