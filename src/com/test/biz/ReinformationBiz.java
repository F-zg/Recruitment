package com.test.biz;

import java.util.List;

import com.test.domain.po.Reinformation;
import com.test.domain.vo.Page;

public interface ReinformationBiz {
	Reinformation findById(Integer id);
	List<Reinformation> findAll();
	List<Reinformation> selectBySQL(String sql,Object... params);
	boolean add(Reinformation entity);
	boolean remove(Reinformation entity);
	boolean remove(Integer id);
	boolean modify(Reinformation entity);
	Page selectReinByPage(int currentPage);

}
