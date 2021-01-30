package com.accolite.ordermanager.service;

import com.accolite.ordermanager.entity.Product;

public interface CalculationService {
	public long calculatePrice(Product prod , Integer quantity);
}
