package com.edu.finance.util;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.edu.finance.framework.context.SpringContextHolder;
import com.edu.finance.service.IDaisyPropertyService;

public class SpringPropertiesUtil{
	
	private final static Logger logger = LogManager.getLogger(SpringPropertiesUtil.class);
	private static Map<String,String> properties = new HashMap<String, String>();
	
	static{
		logger.info("init system config(in db) porpertes");
		IDaisyPropertyService daisyPropertyService = SpringContextHolder.getBean(IDaisyPropertyService.class);
		properties = daisyPropertyService.findAll();
	}
	
	
	public static Map<String,String> getProperties(){
		return properties;
	} 

	public static String getProperty(String name) {
		String value = properties.get(name);
		if(!Toolkit.isEmpty(value)){
			value = value.trim();
		}
	    return value;
	}
	 
	public static String getProperty(String name, String defaultValue) {
	     String val = properties.get(name);
	     if (Toolkit.isEmpty(val)){
	    	 return defaultValue;
	     }else{
	    	 return val.trim();
	     }
	} 
}
