package com.test.biz;

import java.util.List;

import com.test.domain.po.EnterpriseInfo;
import com.test.domain.vo.Page;

public interface EnterpriseInfoService {

	boolean remove(int eid);

	Page selectEnterpriseinfoByPage(int currentPage);

	boolean remove(EnterpriseInfo enterpriseInfo);

	boolean update(EnterpriseInfo enterpriseInfo);

	boolean add(EnterpriseInfo enterpriseInfo);// ?insert and add?

	EnterpriseInfo findById(int eid);

	List<EnterpriseInfo> findAll();

	List<EnterpriseInfo> findBySQL(String sql, Object... params);

}
