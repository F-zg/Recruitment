package com.test.biz;

import java.util.List;

import com.test.domain.po.EnterpriseUser;

public interface EnterpriseUserService {
	boolean register(EnterpriseUser enterpriseUser);
	EnterpriseUser findById(Integer id);
	List<EnterpriseUser> findAll();
	boolean remove(EnterpriseUser enterpriseUser);
	boolean remove(Integer euid);
	boolean update(EnterpriseUser enterpriseUser);
	EnterpriseUser findByName(String euname);
}
