package com.edu.finance.service.impl;

import org.springframework.stereotype.Service;

import com.edu.finance.mapper.DaisyUserMapper;
import com.edu.finance.model.DaisyUserVO;
import com.edu.finance.service.BaseService;
import com.edu.finance.service.IDaisyUserService;

@Service
public class DaisyUserServiceImpl extends BaseService implements IDaisyUserService {

	@Override
	public DaisyUserVO findUserByCode(String sUserCode) {
		DaisyUserMapper mapper = getMapper(DaisyUserMapper.class);
		return mapper.selectUserByCode(sUserCode);
	}

}
