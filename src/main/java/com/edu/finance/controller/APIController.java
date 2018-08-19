package com.edu.finance.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.edu.finance.framework.context.ApiContext;
import com.edu.finance.framework.context.SpringContextHolder;
import com.edu.finance.model.DaisyUserVO;
import com.edu.finance.service.IDaisyUserService;
import com.edu.finance.util.Constant;
import com.edu.finance.util.Toolkit;

/**
 * 向外提供的api父类
 * 
 *
 */
public class APIController {

	final Logger logger = LogManager.getLogger(APIController.class);

	/**
	 * 返回成功信息处理
	 * 
	 * @param dataMap
	 * @return
	 */
	public Map<String, Object> callSuccessMessage(Object data, ApiContext apiContext) {
		return callSuccessMessage(data, true, apiContext);
	}

	/**
	 * 返回信息处理
	 * 
	 * @param dataMap
	 * @return
	 */
	public Map<String, Object> callSuccessMessage(Object data, boolean hasValidData, ApiContext apiContext) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		if (hasValidData) {
			returnMap.put("code", Constant.STATUS_OK);
			returnMap.put("msg", "success");
			returnMap.put("data", data);
			if (apiContext != null){
				returnMap.put("transId", apiContext.getTransactionId());
			}
		} else {
			returnMap.put("code", Constant.STATUS_OK);
			returnMap.put("msg", "data is null");
			returnMap.put("data", null);
			if (apiContext != null){
				returnMap.put("transId", apiContext.getTransactionId());
			}
		}
		logger.info("返回结果：" + JSONObject.toJSONString(returnMap));
		return returnMap;
	}
	
	/**
	 * 返回失败信息处理
	 * 
	 * @param dataMap
	 * @return
	 */
	public Map<String, Object> failMessage(String errorMsg, ApiContext apiContext) {
		return failMessage(errorMsg, Constant.STATUS_INNER_ERROR, apiContext);
	}

	/**
	 * 返回失败信息处理
	 * 
	 * @param dataMap
	 * @return
	 */
	public Map<String, Object> failMessage(String errorMsg, int errorCode,ApiContext apiContext) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		if (errorCode > 0) {
			returnMap.put("code", errorCode);
		}
		returnMap.put("msg", errorMsg);
		if (apiContext != null){
			returnMap.put("transId", apiContext.getTransactionId());
		}
		return returnMap;
	}

	/**
	 * 获取提供方
	 * 
	 * @param request
	 * @param sApiCode
	 * @return
	 */
	public ApiContext getApiContext(HttpServletRequest request, String sApiCode, String condition) {
		return getApiContext(request, sApiCode, null, condition);
	}

	/**
	 * 获取提供方
	 * 
	 * @param request
	 * @param sApiCode
	 * @return
	 */
	public ApiContext getApiContext(HttpServletRequest request, String sApiCode, String providerCode,
			String condition) {
		// 流水号自动生成
		String transId = Toolkit.createTransId();
		int callType = 0;
		if (request.getAttribute("callType") != null && "1".equals(request.getAttribute("callType").toString())) {
			// 测试调用
			callType = 1;
		}
		String account = request.getParameter("account");
		if (Toolkit.isEmpty(account)) {
			IDaisyUserService daisyUserService = SpringContextHolder.getBean(IDaisyUserService.class);
			DaisyUserVO user = daisyUserService.findUserByCode(account);
			if (user != null) {
				account = user.getsCode();
			}
		}
		return new ApiContext(account, transId, sApiCode, providerCode, callType, condition);
	}
}
