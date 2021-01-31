package com.accolite.ordermanager.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CustomerTest {
	
	
	@Test
	public void checkEnity() {
			Customer customer1 = new Customer();
			Customer customer2 = new Customer("akash",
					"ak@gmail.com",
					"1",
					"abc street",
					"chennai","India","678765");
			customer2.getCity();
			customer2.getCountry();
			customer2.getEmailId();
			customer2.getHouseNo();
			customer2.getName();
			customer2.getPincode();
			customer2.getStreet();
			customer1.setName("ak");
			customer1.setHouseNo("1");
			customer1.setEmailId("akm@gmail.com");
			customer1.setCountry("India");
			customer1.setPincode("678765");
			customer1.setStreet("msd street");
			customer1.setCountry("India");
			customer1.setId(1);
			customer1.getId();
			customer1.setCity("chennai");
			customer1.getCity();
	}
	

}
