package com.edu.finance.framework.job;

import java.util.Map;

import org.apache.log4j.Logger;

import com.edu.finance.framework.context.ApiContext;
import com.edu.finance.framework.logger.FileLogger;
import com.edu.finance.util.Toolkit;

public class PersistenceAsynJob extends Thread{
	
	@SuppressWarnings("unused")
	private Logger persistenceLogger = FileLogger.getFileLogger("persistenceToHBase");

	private String tableName;
	
	//private String jsonData;
	
	private ApiContext apiContext;
	
	private String family;
	
	private String key;
	
	private Map<String, Object> dataMap;
	
	private String multiProviderCode;

	public ApiContext getApiContext() {
		return apiContext;
	}

	public void setApiContext(ApiContext apiContext) {
		this.apiContext = apiContext;
	}

	public String getFamily() {
		return family;
	}


	public void setFamily(String family) {
		this.family = family;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public Map<String, Object> getOldDataMap() {
		return dataMap;
	}


	public void setOldDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	

	public String getTableName() {
		return tableName;
	}


	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * 有数据字典时候调用
	 * dataMap 带apicode
	 */
	public PersistenceAsynJob(String tableName, String key,  String family, ApiContext apiContext, Map<String, Object> dataMap){
		this(tableName, key, family, apiContext, dataMap, null);
	}
	
	/**
	 * 有数据字典时候调用
	 * dataMap 带apicode
	 */
	public PersistenceAsynJob(String tableName, String key,  String family, ApiContext apiContext, Map<String, Object> dataMap,  String multiProviders){
		this.tableName = tableName;
		this.key = key;
		this.apiContext = apiContext;
		this.family = family;
		this.dataMap = dataMap;
		this.multiProviderCode = multiProviders;
		if (Toolkit.isEmpty(multiProviderCode)){
			multiProviderCode = apiContext.getProviderCode();
		}
	}
	
	public void run(){
		
		objectToHbase(dataMap,tableName,key);
		
	}	
	
	public void objectToHbase(Map<String,Object> result,String tableName,String key){
		
	}
}
