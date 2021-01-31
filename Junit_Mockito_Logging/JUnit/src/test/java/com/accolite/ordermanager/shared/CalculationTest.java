package com.accolite.ordermanager.shared;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.accolite.ordermanager.entity.Product;
import com.accolite.ordermanager.impl.ProductServiceImpl;
import com.accolite.ordermanager.service.CalculationService;

@ExtendWith(MockitoExtension.class)
class CalculationTest {
	
	@Mock
	ProductServiceImpl psimpl;
	
	@InjectMocks
	Calculation cService;
	

	@Test
	public void calculatePrice() {
		Product prod = new Product("cookie" , 10);
		int quantity = 10;
		long calculatedPrice = cService.calculatePrice(prod, quantity);
		org.junit.jupiter.api.Assertions.assertEquals(100, calculatedPrice);
}

}