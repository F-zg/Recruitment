package com.test.dao;

import java.io.Serializable;
import java.util.List;

/*
 * 	 通用的基于泛型的父接口
 *  Entity
 */
public interface GenericDao<Entity extends Serializable, ID extends Object> {
	// 返回实体类类型、参数是对象类型主键
	Entity findById(ID id);
	List<Entity> findAll();
	List<Entity> findBySQL(String sql, Object... params);
	
	int insert(Entity entity);
	int delete(Entity entity);
	int delete(ID id);
	int update(Entity entity);

}
