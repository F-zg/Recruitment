package com.test.biz;

import java.util.List;


import com.test.domain.po.UserInfo;

public interface UserInfoService {
	boolean register(UserInfo user);
	UserInfo findById(Integer id);
	List<UserInfo>findAll();
	boolean remove(UserInfo user);
	boolean login(UserInfo user);	
	boolean update(UserInfo user);
	int del(int userId);
	int updatestate(int userId);
	int releasestate(int userId);
	UserInfo findUser1ByUserNameAndUseerPassword(String username, String password);
}
