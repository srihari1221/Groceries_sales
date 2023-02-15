package com.hari.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hari.entity.Orders;

public interface IOrdersRepo extends JpaRepository<Orders, Integer> {
	
	public List<Orders> findByCustomerId(Integer customerId);
	

}
