package com.edu.finance.framework.context;

/**
 * 
 * 访问接口的上下文
 *
 */
public class ApiContext {
	/**
	 * 来访账户
	 */
	private String visitAccout;
	
	/**
	 * 流水号
	 */
	private String transactionId;
	
	
	private String providerCode;
	
	/**
	 * 接口编码(方法名)
	 */
	private String apiCode;
	
	private String[] subItems;
	
	/**
	 * 调用类型
	 */
	private int callType;//0:(默认)接口调用 1:调试调用
	
	
	private long beginTime;
	
	private String sType;
	
	private boolean subQuery;//是企业报告的子选项
	
	private String queryCondition;//查询条件
	
	public ApiContext() {
	}
	
	public ApiContext(String visitAccout, String transactionId, String apiCode, String providerCode, int callType,String queryCondition) {
		super();
		this.visitAccout = visitAccout;
		this.transactionId = transactionId;
		this.apiCode = apiCode;
		this.providerCode = providerCode;
		this.callType = callType;
		this.queryCondition = queryCondition;
		this.beginTime = System.currentTimeMillis();
	}


	public String getVisitAccout() {
		return visitAccout;
	}

	public void setVisitAccout(String visitAccout) {
		this.visitAccout = visitAccout;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	public String getProviderCode() {
		return providerCode;
	}

	public void setProviderCode(String providerCode) {
		this.providerCode = providerCode;
	}

	public String getApiCode() {
		return apiCode;
	}

	public void setApiCode(String apiCode) {
		this.apiCode = apiCode;
	}


	public int getCallType() {
		return callType;
	}


	public void setCallType(int callType) {
		this.callType = callType;
	}

	public long getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(long beginTime) {
		this.beginTime = beginTime;
	}

	public String getsType() {
		return sType;
	}

	public void setsType(String sType) {
		this.sType = sType;
	}

	public boolean isSubQuery() {
		return subQuery;
	}

	public void setSubQuery(boolean subQuery) {
		this.subQuery = subQuery;
	}

	public String getQueryCondition() {
		return queryCondition;
	}

	public void setQueryCondition(String queryCondition) {
		this.queryCondition = queryCondition;
	}

	public String[] getSubItems() {
		return subItems;
	}

	public void setSubItems(String... subItems) {
		this.subItems = subItems;
	}
	
	
}
