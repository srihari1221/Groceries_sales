package com.hari.service.order;

import java.util.List;

import com.hari.entity.Orders;

public interface IOrdersService {
	
	public Orders getById(Integer id);
	public List<Orders> getAllOrdersByCustId(Integer id);
	public List<Orders> getAllOrders();
	
}
