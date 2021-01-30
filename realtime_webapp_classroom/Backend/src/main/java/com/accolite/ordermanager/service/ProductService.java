package com.accolite.ordermanager.service;

import com.accolite.ordermanager.entity.Product;

public interface ProductService {
	
	public Product addNewProduct(Product p);
	
	public Product getProductById(int id);

}
