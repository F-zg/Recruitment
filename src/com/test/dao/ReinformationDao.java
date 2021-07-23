package com.test.dao;

import com.test.domain.po.Reinformation;
import com.test.domain.vo.Page;

public interface ReinformationDao extends GenericDao<Reinformation, Integer>{
	int getTotalRows(String sql);
	Page findByPage(int currentPage);
}
