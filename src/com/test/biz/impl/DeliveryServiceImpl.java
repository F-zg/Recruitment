package com.test.biz.impl;

import java.util.List;

import com.test.biz.DeliveryService;
import com.test.dao.DeliveryDao;
import com.test.dao.jdbcimpl.DeliveryDaoImpl;
import com.test.domain.po.Delivery;

public class DeliveryServiceImpl implements DeliveryService {
   private DeliveryDao deliveryDao=new DeliveryDaoImpl();
	@Override
	public boolean register(Delivery delivery) {
		boolean flag=false;
		int res= deliveryDao.insert(delivery);
		if(res==1)
			flag=true;
		return flag;
	}

	@Override
	public Delivery findById(Integer id) {
		return deliveryDao.findById(id);
	}

	@Override
	public List<Delivery> findAll() {
	return deliveryDao.findAll();
	}

	@Override
	public boolean remove(Delivery delivery) {
		boolean flag=false;
		int res= deliveryDao.delete(delivery);
		if(res==1)
			flag=true;
		return flag;
	}

	@Override
	public boolean update(Delivery delivery) {
		boolean flag=false;
		int res= deliveryDao.update(delivery);
		if(res==1)
			flag=true;
		return flag;
	}

	@Override
	public boolean remove(Integer id) {
		boolean flag=false;
		int res= deliveryDao.delete(id);
		if(res==1)
			flag=true;
		return flag;
	}


@Override
public Delivery findDeliveryByUserId(int userid) {
	return deliveryDao.findDeliveryByUserId(userid);
}
}
