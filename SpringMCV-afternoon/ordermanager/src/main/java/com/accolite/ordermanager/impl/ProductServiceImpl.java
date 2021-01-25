package com.accolite.ordermanager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.ordermanager.entity.Product;
import com.accolite.ordermanager.repo.ProductRepo;
import com.accolite.ordermanager.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo pRepo;

	public Product addNewProduct(Product p) {
		
		return pRepo.save(p);
	}
	
	public Product getProductById(int id) {
		return pRepo.findById(id).get();
	}	
}
