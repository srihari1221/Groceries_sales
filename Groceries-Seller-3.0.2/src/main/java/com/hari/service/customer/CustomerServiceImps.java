package com.hari.service.customer;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hari.entity.Customer;
import com.hari.repo.ICustomerRepo;
@Service
public class CustomerServiceImps implements ICustomerService {
	private static Logger logger;
	static {
		logger =  LoggerFactory.getLogger(CustomerServiceImps.class);
	}

	@Autowired
	private ICustomerRepo customerRepo;
	
	@Override
	public Customer getCustomerById(Integer id) {
		Optional<Customer> optional = customerRepo.findById(id);
		if(optional.isPresent())
			return optional.get();
		logger.debug("Customer is not found with id no ::  "+id);
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return customerRepo.findAll();
	}

	@Override
	public String insertCustomer(Customer customer) {
		logger.debug("customer object is inserting ");
		return "Customer ID Number ::"+customerRepo.save(customer).getId();
	}

}
