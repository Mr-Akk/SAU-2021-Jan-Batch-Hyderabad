package com.accolite.ordermanager.controller;



import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.accolite.ordermanager.dao.PurchasedProduct;
import com.accolite.ordermanager.entity.UserCart;
import com.accolite.ordermanager.impl.CartServiceimpl;

@ExtendWith(MockitoExtension.class)
class CartControllerTest {


	@InjectMocks
	CartController cController;
	
	@Mock
	CartServiceimpl csimpl;

	@Test
	public void createCart() {
		UserCart cart = new UserCart();
		cart.setId(1);
		cart.setCusId(1);
		Mockito.when(csimpl.createCart(Mockito.anyInt())).thenReturn(cart);
		int createCart = cController.createCart(1);
		Assertions.assertEquals(1, createCart);
	}
	
	@Test
	public  void addProducts() {
		PurchasedProduct purchasedProduct = new PurchasedProduct(1,10,100);
		Mockito.when(csimpl.addProduct(1,1,10)).thenReturn(purchasedProduct);
		ResponseEntity<Object> response = cController.addProduct(1, 1, 10);
		Assertions.assertEquals(ResponseEntity.ok(purchasedProduct), response);
	}
	
	@Test
	public  void addProducts_null() {
		PurchasedProduct purchasedProduct = new PurchasedProduct(1,10,100);
		Mockito.when(csimpl.addProduct(1,1,10)).thenReturn(null);
		ResponseEntity<Object> response = cController.addProduct(1, 1, 10);
		Assertions.assertEquals(new ResponseEntity<Object>("Invalid details!!" , HttpStatus.NOT_FOUND), response);
	}
	
	//To modify
	
	@Test
	public void deletePurchasedProd() {
		ResponseEntity<Object> deletePurchasedProd = cController.deletePurchasedProd(1,1);
		Assertions.assertEquals(ResponseEntity.ok("Product Successfully deleted from your cart"),
				deletePurchasedProd);
	}
	
	@Test
	public void updateQuantity() {
		PurchasedProduct purchasedProduct = new PurchasedProduct(1,10,100);
		Mockito.when(csimpl.updateQuantity(1, 1, 10)).thenReturn(purchasedProduct);
		ResponseEntity<Object> updateQuantity = cController.updateQuantity(1, 1, 10);
		Assertions.assertEquals(ResponseEntity.ok(purchasedProduct), 
				updateQuantity);				
	}
	
	@Test
	public void updateQuantity_withNull() {
		PurchasedProduct purchasedProduct = new PurchasedProduct(1,10,100);
		Mockito.when(csimpl.updateQuantity(1, 1, 10)).thenReturn(null);
		ResponseEntity<Object> updateQuantity = cController.updateQuantity(1, 1, 10);
		Assertions.assertEquals(new ResponseEntity<Object>( "Invalid details!!" , HttpStatus.NOT_FOUND ), 
				updateQuantity);				
	}
	
	@Test
	public void getAllProducts() {
		List<PurchasedProduct> purchasedProducts = new ArrayList<PurchasedProduct>();
		PurchasedProduct product = new PurchasedProduct(1,10,100);
		purchasedProducts.add(product);
		Mockito.when(csimpl.getAllProducts(1)).thenReturn(purchasedProducts);
		ResponseEntity<Object> response = cController.getAllProducts(1);
		Assertions.assertEquals(ResponseEntity.ok(purchasedProducts), response);
	}
}
