package com.test.biz.impl;

import java.util.List;

import com.test.biz.ReinformationBiz;
import com.test.dao.ReinformationDao;
import com.test.dao.jdbcimpl.ReinformationDaoImpl;
import com.test.domain.po.Reinformation;
import com.test.domain.vo.Page;

public class ReinformationBizImpl implements ReinformationBiz {
	private ReinformationDao reinformationDao = new ReinformationDaoImpl();

	@Override
	public Reinformation findById(Integer id) {
		return reinformationDao.findById(id);
	}

	@Override
	public List<Reinformation> findAll() {
		return reinformationDao.findAll();
	}
	
	@Override
	public List<Reinformation> selectBySQL(String sql, Object... params) {
		return reinformationDao.findBySQL(sql, params);
	}

	@Override
	public boolean add(Reinformation entity) {
		boolean result=false;
		int res = reinformationDao.insert(entity);
		if(res==1)
		{
			result = true;
		}
		
		return result;
	}

	@Override
	public boolean remove(Reinformation entity) {
		boolean result=false;
		int res = reinformationDao.delete(entity);
		if(res==1)
		{
			result = true;
		}
		
		return result;
	}

	@Override
	public boolean remove(Integer id) {
		boolean result=false;
		int res = reinformationDao.delete(id);
		if(res==1)
		{
			result = true;
		}
		
		return result;
	}

	@Override
	public boolean modify(Reinformation entity) {
		boolean result=false;
		int res = reinformationDao.update(entity);
		if(res==1)
		{
			result = true;
		}
		
		return result;
	}

	@Override
	public Page selectReinByPage(int currentPage) {
		return reinformationDao.findByPage(currentPage);
	}

}
