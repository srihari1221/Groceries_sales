package com.hari.service.order;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hari.entity.Orders;
import com.hari.repo.IOrdersRepo;
@Service
public class OrdersServiceImps implements IOrdersService {

	@Autowired
	IOrdersRepo ordersRepo;
	
	@Override
	public Orders getById(Integer id) {
		Optional<Orders> optional = ordersRepo.findById(id);
		if(optional.isPresent())
			return optional.get();
		else {
			
			return null;
		}
	}

	@Override
	public List<Orders> getAllOrdersByCustId(Integer id) {
		return ordersRepo.findByCustomerId(id);
	}

	@Override
	public List<Orders> getAllOrders() {
		return ordersRepo.findAll();
	}

}
