package com.hari.service.customer;

import java.util.List;

import com.hari.entity.Customer;

public interface ICustomerService {
	
	public Customer getCustomerById(Integer id);
	public List<Customer> getAllCustomers();
	public String insertCustomer(Customer customer);

}
