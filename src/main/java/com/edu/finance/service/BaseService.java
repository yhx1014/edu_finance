package com.edu.finance.service;

import com.edu.finance.util.mybatis.SqlSessionUtil;

/**
 * 
 * 基础服务
 *
 */
public abstract class BaseService{
	 /**
	 * 获取mapper
	 * @param clazz
	 * @return
	 */
	protected  <T> T getMapper(Class<T> clazz){
		 return SqlSessionUtil.getMapper(clazz);
	 }
}
