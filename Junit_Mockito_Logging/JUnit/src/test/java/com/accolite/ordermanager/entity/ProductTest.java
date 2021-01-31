package com.accolite.ordermanager.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductTest {

	
	@Test
	public void checkProduct() {
		Product product1 = new Product();
		Product product2 = new Product("cookie" , 10);
		product1.setId(1);
		product1.getId();
		product1.setName("chocolate");
		product1.getName();
		product1.setPrice(15);
		product1.getPrice();
		
		
	}
}
