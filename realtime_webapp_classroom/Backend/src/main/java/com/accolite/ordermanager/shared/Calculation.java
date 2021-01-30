package com.accolite.ordermanager.shared;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.ordermanager.entity.Product;
import com.accolite.ordermanager.impl.ProductServiceImpl;
import com.accolite.ordermanager.service.CalculationService;

@Service
public class Calculation implements CalculationService {
	
	@Autowired
	ProductServiceImpl psimpl;
	
	public long calculatePrice(Product prod, Integer quantity) {	
		return quantity*prod.getPrice();	
	}
}
