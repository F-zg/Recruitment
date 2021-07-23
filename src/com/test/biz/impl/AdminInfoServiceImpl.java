package com.test.biz.impl;

import com.test.biz.AdminInfoService;
import com.test.dao.AdminInfoDao;
import com.test.dao.jdbcimpl.AdminInfoDaoImpl;
import com.test.domain.po.AdminInfo;

public class AdminInfoServiceImpl implements AdminInfoService{
    private AdminInfoDao adminInfodao=new AdminInfoDaoImpl();
	@Override
	public boolean login(AdminInfo adminInfo) {
		boolean result = false;
		int res = adminInfodao.findUserByUsernameAndUseerPassword(adminInfo);
		if (res == 1)
			result = true;
		return result;
	}

}
