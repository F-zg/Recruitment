package com.test.biz.impl;

import java.util.List;

import com.test.biz.EnterpriseInfoService;
import com.test.dao.EnterpriseInfoDao;
import com.test.dao.jdbcimpl.EnterpriseInfoDaoImpl;
import com.test.domain.po.EnterpriseInfo;
import com.test.domain.vo.Page;

public class EnterpriseInfoServiceImpl implements EnterpriseInfoService {
	private EnterpriseInfoDao enterpriseInfoDao = new EnterpriseInfoDaoImpl();

	@Override
	public boolean remove(int eid) {
		// TODO Auto-generated method stub
		boolean result = false;
		int res = enterpriseInfoDao.delete(eid);
		if (res == 1)
			result = true;
		return result;
	}

	@Override
	public boolean remove(EnterpriseInfo enterpriseInfo) {
		int eid = enterpriseInfo.getEid();
		return this.remove(eid);
	}

	@Override
	public Page selectEnterpriseinfoByPage(int currentPage) {
		// TODO Auto-generated method stub
		return enterpriseInfoDao.selectEnterpriseinfoByPage(currentPage);
	}

	@Override
	public boolean update(EnterpriseInfo enterpriseInfo) {
		// TODO Auto-generated method stub
		boolean result = false;
		int res = enterpriseInfoDao.update(enterpriseInfo);
		if (res == 1)
			result = true;
		return result;
	}

	@Override
	public boolean add(EnterpriseInfo enterpriseInfo) {
		boolean result = false;
		int res = enterpriseInfoDao.insert(enterpriseInfo);
		if (res == 1)
			result = true;
		return result;
	}

	@Override
	public EnterpriseInfo findById(int eid) {
		// TODO Auto-generated method stub
		return enterpriseInfoDao.findById(eid);
	}

	@Override
	public List<EnterpriseInfo> findAll() {
		// TODO Auto-generated method stub
		return enterpriseInfoDao.findAll();
	}

	@Override
	public List<EnterpriseInfo> findBySQL(String sql, Object... params) {
		// TODO Auto-generated method stub
		return enterpriseInfoDao.findBySQL(sql, params);
	}

}
