package com.test.biz.impl;

import java.util.List;

import com.test.biz.EnterpriseUserService;
import com.test.dao.EnterpriseUserDao;
import com.test.dao.jdbcimpl.EnterpriseUserDaoImpl;
import com.test.domain.po.EnterpriseUser;

public class EnterpriseUserServiceImpl implements EnterpriseUserService {
    private EnterpriseUserDao euserDao=new EnterpriseUserDaoImpl();
	@Override
	public boolean register(EnterpriseUser enterpriseUser) {
		boolean flag=false;
		int res=euserDao.insert(enterpriseUser);
		if(res==1)
			flag=true;
		return flag;
	}

	@Override
	public EnterpriseUser findById(Integer id) {
		return euserDao.findById(id);
	}

	@Override
	public List<EnterpriseUser> findAll() {
		return euserDao.findAll();
	}

	@Override
	public boolean remove(EnterpriseUser enterpriseUser) {
		boolean flag=false;
		int res=euserDao.delete(enterpriseUser);
		if(res==1)
			flag=true;
		return flag;
	}

	@Override
	public boolean update(EnterpriseUser enterpriseUser) {
		boolean flag=false;
		int res=euserDao.update(enterpriseUser);
		if(res==1)
			flag=true;
		return flag;
	}
	@Override
    public EnterpriseUser findByName(String euname) {
    	return euserDao.findByName(euname);
    }

	@Override
	public boolean remove(Integer euid) {
		boolean flag=false;
		int res=euserDao.delete(euid);
		if(res==1)
			flag=true;
		return flag;
	}
}
