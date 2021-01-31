package com.accolite.ordermanager.controller;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.accolite.ordermanager.entity.Customer;
import com.accolite.ordermanager.impl.CustomerServiceImpl;


@ExtendWith(MockitoExtension.class)
class CustomercontrollerTest {

	@InjectMocks
	Customercontroller cController;
	
	@Mock
	CustomerServiceImpl csimpl;
	
	@Test
	public void addCustomer() {
		Customer customer = new Customer();
		customer.setName("ak");
		customer.setEmailId("ak@gmail.com");
		customer.setHouseNo("1");
		customer.setStreet("MSD street");
		customer.setCountry("India");
		customer.setCity("chennai");
		customer.setPincode("600026");
		Mockito.when(csimpl.createCustomer(customer)).thenReturn(customer);
		ResponseEntity<Object> addCustomer = cController.addCustomer(customer);
		Assertions.assertEquals(HttpStatus.OK, addCustomer.getStatusCode());
	}
	
	@Test
	public void addCustomer_withInvalidData() {
		Customer customer = new Customer();
		//Name was not present
		customer.setEmailId("ak@gmail.com");
		customer.setHouseNo("1");
		customer.setStreet("MSD street");
		customer.setCountry("India");
		customer.setCity("chennai");
		customer.setPincode("600026");
		Assertions.assertThrows(Exception.class,()-> Mockito.when(csimpl.createCustomer(customer)).thenThrow(Exception.class));
	}
}
