package com.test.biz.impl;

import java.util.List;

import com.test.biz.UserInfoService;
import com.test.dao.UserInfoDao;
import com.test.dao.jdbcimpl.UserInfoDaoImpl;
import com.test.domain.po.UserInfo;

public class UserInfoServiceImpl implements UserInfoService{
	private UserInfoDao userInfoDao=new UserInfoDaoImpl();

	 /*
	  * ÓÃ»§×¢²á
	  */
	@Override
	public boolean register(UserInfo user) {
			boolean result = false;
			int res = userInfoDao.insert(user);
			if (res == 1)
				result = true;
			return result;
		}
	
	@Override
	public UserInfo findById(Integer id) {
		return userInfoDao.findById(id);
	}

	@Override
	public List<UserInfo> findAll() {
		return userInfoDao.findAll();
	}

	@Override
	public boolean remove(UserInfo user) {
		boolean result = false;
		int res = userInfoDao.delete(user);
		if (res == 1)
			result = true;
		return result;
	}

	@Override
	public boolean login(UserInfo user) {
		boolean result = false;
		int res = userInfoDao.findUserByUsernameAndUseerPassword(user);
		if (res == 1)
			result = true;
		return result;
	}
	@Override
	public boolean update(UserInfo user) {
		boolean result = false;
		int res = userInfoDao.update(user);
		if (res == 1)
			result = true;
		return result;
	}
  
	@Override
	public int del(int userId) {
		return userInfoDao.delete(userId);
	}

	@Override
	public int updatestate(int userId) {
		return userInfoDao.updatestate(userId);
	}

	@Override
	public int releasestate(int userId) {
		return userInfoDao.releasestate(userId);
	}

	@Override
	public UserInfo findUser1ByUserNameAndUseerPassword(String username, String password) {
		UserInfo result=userInfoDao.findUser1ByUserNameAndUseerPassword(username,password);
		return result;
	}

}
