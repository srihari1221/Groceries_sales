package com.hari.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hari.entity.Customer;

public interface ICustomerRepo extends JpaRepository<Customer, Integer> {

}
