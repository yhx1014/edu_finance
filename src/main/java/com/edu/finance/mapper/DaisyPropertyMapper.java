package com.edu.finance.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.edu.finance.model.DaisyPropertyVO;

/**
 * 获取全局数据(mapper)
 *
 */
public interface DaisyPropertyMapper {
	
	/**
	 * 获取全局配置数据
	 * @return
	 */
	@Select("select id,s_name as sName,s_value as sValue from daisy_property where s_context in (${contexts})")
	List<DaisyPropertyVO> selectAll(@Param("contexts") String contexts);
}