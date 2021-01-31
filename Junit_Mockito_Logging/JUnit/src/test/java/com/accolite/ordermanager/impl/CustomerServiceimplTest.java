package com.accolite.ordermanager.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.accolite.ordermanager.entity.Customer;
import com.accolite.ordermanager.repo.CustomerRepo;
import com.accolite.ordermanager.service.CustomerService;

@ExtendWith(MockitoExtension.class)
class CustomerServiceimplTest {

	@Mock
	CustomerRepo cRepo;
	
	@InjectMocks
	CustomerServiceImpl csImpl;
	
	@Test
	public void createCustomer() {
		
		Customer customer = new Customer();
		customer.setName("ak");
		customer.setEmailId("a@gmail.com");
		customer.setCity("chennai");
		customer.setCountry("India");
		customer.setHouseNo("10");
		customer.setPincode("601676");
		customer.setStreet("abc street");
		Mockito.when(cRepo.save(customer)).thenReturn(customer);
		
		Customer createCustomer = csImpl.createCustomer(customer);
		Assertions.assertEquals(customer, createCustomer);
	}
	

}
