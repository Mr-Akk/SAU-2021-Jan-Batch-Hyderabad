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


@RestController
@RequestMapping("/customer")
public class Customercontroller {
	
	@Autowired
	CustomerServiceImpl csimpl;
	
	@PostMapping("/add")
	public ResponseEntity<Object> addCustomer(@Valid @RequestBody Customer customer) {		
		 throw new RuntimeException("Dummy exception");
//		Customer createdCustomer = csimpl.createCustomer(customer);		
//		return ResponseEntity.ok(createdCustomer);		
	}
}
