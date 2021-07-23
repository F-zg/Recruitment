package com.test.dao;

import com.test.domain.po.EnterpriseUser;

public interface EnterpriseUserDao extends GenericDao<EnterpriseUser, Integer>{

	public  EnterpriseUser findByName(String euname);

}
