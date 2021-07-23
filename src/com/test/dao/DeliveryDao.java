package com.test.dao;

import com.test.domain.po.Delivery;

public interface DeliveryDao extends GenericDao<Delivery, Integer>{

	Delivery findDeliveryByUserId(Integer userid);

}
