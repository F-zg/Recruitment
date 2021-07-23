package com.test.dao;

import com.test.domain.po.AdminInfo;


public interface AdminInfoDao extends GenericDao<AdminInfo, Integer>{

	int findUserByUsernameAndUseerPassword(AdminInfo adminInfo);

	int update(int userId);

}
