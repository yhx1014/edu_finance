package com.edu.finance.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.edu.finance.mapper.DaisyPropertyMapper;
import com.edu.finance.model.DaisyPropertyVO;
import com.edu.finance.service.BaseService;
import com.edu.finance.service.IDaisyPropertyService;

@Service
public class DaisyPropertyServiceImpl extends BaseService implements IDaisyPropertyService {

	@Override
	public Map<String, String> findAll() {
		DaisyPropertyMapper mapper = getMapper(DaisyPropertyMapper.class);
		List<DaisyPropertyVO> list = mapper.selectAll("'common','risk'");
		return list.stream().collect(Collectors.toMap(DaisyPropertyVO::getsName, DaisyPropertyVO::getsValue));
	}

}
