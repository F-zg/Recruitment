package com.test.dao.jdbcimpl;

import com.test.dao.UserInfoDao;
import com.test.domain.po.UserInfo;

public class TestJDBC {

	public static void main(String[] args) {
		UserInfoDao userInfoDao = new UserInfoDaoImpl();
		UserInfo userInfo = userInfoDao.findById(1);
		System.out.println(userInfo);
	}

}
