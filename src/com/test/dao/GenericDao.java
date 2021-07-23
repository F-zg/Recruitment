package com.test.dao;

import java.io.Serializable;
import java.util.List;

/*
 * 	 ͨ�õĻ��ڷ��͵ĸ��ӿ�
 *  Entity
 */
public interface GenericDao<Entity extends Serializable, ID extends Object> {
	// ����ʵ�������͡������Ƕ�����������
	Entity findById(ID id);
	List<Entity> findAll();
	List<Entity> findBySQL(String sql, Object... params);
	
	int insert(Entity entity);
	int delete(Entity entity);
	int delete(ID id);
	int update(Entity entity);

}
