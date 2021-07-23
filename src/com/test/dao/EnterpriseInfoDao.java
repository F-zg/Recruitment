package com.test.dao;

import com.test.domain.po.EnterpriseInfo;
import com.test.domain.vo.Page;

public interface EnterpriseInfoDao extends GenericDao<EnterpriseInfo, Integer> {

	Page selectEnterpriseinfoByPage(int currentPage);

}
