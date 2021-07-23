package com.test.biz;

import java.util.List;

import com.test.domain.po.Delivery;


public interface DeliveryService {
	boolean register(Delivery delivery);
	Delivery findById(Integer id);
	List<Delivery> findAll();
	boolean remove(Delivery delivery);
	boolean update(Delivery delivery);
	boolean remove(Integer id);
	Delivery findDeliveryByUserId(int userid) ;
}
