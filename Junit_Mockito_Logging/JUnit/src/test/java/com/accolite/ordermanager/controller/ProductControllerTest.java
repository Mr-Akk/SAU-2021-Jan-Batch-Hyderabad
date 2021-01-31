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

import com.accolite.ordermanager.entity.Product;
import com.accolite.ordermanager.impl.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {
	
	@InjectMocks
	ProductController pController;
	
	@Mock
	ProductServiceImpl psimpl;

	@Test
	public void addProduct() {
		Product product = new Product("chocolate" , 10);
		Mockito.when(psimpl.addNewProduct(Mockito.anyObject())).thenReturn(product);		
		ResponseEntity<Object> addProductRes = pController.addProduct(product);		
		Assertions.assertEquals(ResponseEntity.ok(product),addProductRes);
	}
	
	@Test
	public void getPdoduct() {
		Product product = new Product("chocolate" , 10);
		Mockito.when(psimpl.getProductById(Mockito.anyInt())).thenReturn(product);
		ResponseEntity<Object> res = pController.getProduct(Mockito.anyInt());
		Assertions.assertEquals(ResponseEntity.ok(product), res);
	}
	
	@Test
	public void getPdoduct_null() {
		Product product = new Product("chocolate" , 10);
		Mockito.when(psimpl.getProductById(Mockito.anyInt())).thenReturn(null);
		ResponseEntity<Object> res = pController.getProduct(Mockito.anyInt());
		Assertions.assertEquals(new ResponseEntity<Object>("Product not found!!" , HttpStatus.NOT_FOUND), 
				res);
	}
}
