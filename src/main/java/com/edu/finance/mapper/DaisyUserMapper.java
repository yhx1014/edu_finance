package com.edu.finance.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.edu.finance.model.DaisyUserVO;


/**
 * 用户(租户)mapper
 *
 */
public interface DaisyUserMapper {
	
	/**
	 * 根据用户编码查询用户
	 * @param sUserCode
	 * @return
	 */
	@Select("select u.s_code sCode,u.s_name sName,u.s_email sEmail, u.s_phone sPhone, u.i_type iType, u.i_status iStatus, u.s_open_time sOpenTime, u.s_access_key sAccessKey, u.i_status iStatus, t.s_name sTenantName,u.i_access_type accessType from daisy_user u left join daisy_tenant t on u.s_tenant_code = t.s_code where u.s_code=#{sUserCode}")
	DaisyUserVO selectUserByCode(@Param("sUserCode") String sUserCode);
}