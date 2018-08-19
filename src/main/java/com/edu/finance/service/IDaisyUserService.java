package com.edu.finance.service;

import com.edu.finance.model.DaisyUserVO;

/**
 * 
 * 用户(租户)服务
 *
 */
public interface IDaisyUserService {
	/**
	 * 根据用户编码查询用户
	 * @param sUserCode
	 * @return
	 */
	DaisyUserVO findUserByCode(String sUserCode);
}
