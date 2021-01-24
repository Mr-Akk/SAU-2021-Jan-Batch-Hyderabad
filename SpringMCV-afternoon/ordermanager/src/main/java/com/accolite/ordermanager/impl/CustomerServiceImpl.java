package com.accolite.ordermanager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.ordermanager.entity.Customer;
import com.accolite.ordermanager.repo.CustomerRepo;
import com.accolite.ordermanager.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepo cRepo;

	public Customer createCustomer(Customer customer) {
		
		return cRepo.save(customer);
		
	}
	
	
	
	

}
