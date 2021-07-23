package com.test.dao;

import com.test.domain.po.UserInfo;

public interface UserInfoDao extends GenericDao<UserInfo, Integer>{
	int findUserByUsernameAndUseerPassword(UserInfo user);

	int updatestate(int userId);
	
	int update(int userId);

	int releasestate(int userId);

	UserInfo findUser1ByUserNameAndUseerPassword(String username, String password);
}
