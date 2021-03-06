package com.accolite.ordermanager.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.ordermanager.entity.Customer;
import com.accolite.ordermanager.impl.CustomerServiceImpl;
import com.accolite.ordermanager.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class Customercontroller {
	
	@Autowired
	CustomerService csimpl;
	
	@PostMapping("/add")
	public ResponseEntity<Object> addCustomer(@Valid @RequestBody Customer customer) {		
		 Customer createdCustomer = csimpl.createCustomer(customer);		
		return ResponseEntity.ok(createdCustomer);		
	}
}
