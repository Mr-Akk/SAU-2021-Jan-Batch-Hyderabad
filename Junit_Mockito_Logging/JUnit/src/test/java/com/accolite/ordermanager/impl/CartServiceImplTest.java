package com.accolite.ordermanager.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import com.accolite.ordermanager.dao.PurchasedProduct;
import com.accolite.ordermanager.entity.Product;
import com.accolite.ordermanager.entity.UserCart;
import com.accolite.ordermanager.repo.CartRepo;
import com.accolite.ordermanager.shared.Calculation;

@ExtendWith(MockitoExtension.class)
class CartServiceImplTest {

	@Mock
	CartRepo cRepo;
	
	@Mock
	ProductServiceImpl psimpl;
	
	@Mock
	Calculation calc;
	
	@InjectMocks
	CartServiceimpl csimpl;
	
	@Test
	public void createCart() {		
		UserCart userCart = new UserCart(1);
		Mockito.when(cRepo.save(Mockito.any())).thenReturn(userCart);		
		UserCart createCart = csimpl.createCart(1);
		Assertions.assertEquals(userCart, createCart);
	}
	
	@Test
	public void getCartById_null() {
		Optional<UserCart> empty = Optional.empty();
		Mockito.when(cRepo.findById(Mockito.anyInt())).thenReturn(empty);
		UserCart cartById = csimpl.getCartById(1);
		Assertions.assertEquals(null, cartById);
}
	
	@Test
	public void getCartById() {
		UserCart userCart = new UserCart(1);				
		Optional<UserCart> uOptional = Optional.of(userCart);
		Mockito.when(cRepo.findById(Mockito.anyInt())).thenReturn(uOptional);
		UserCart cartById = csimpl.getCartById(1);
		Assertions.assertEquals(uOptional.get(), cartById);
}
	
	@Test
	public void getAllProducts() {	
		UserCart userCart = new UserCart(1);				
		Optional<UserCart> uOptional = Optional.of(userCart);
		Mockito.when(cRepo.findById(Mockito.anyInt())).thenReturn(uOptional);
		List<PurchasedProduct> allProducts = csimpl.getAllProducts(1);
		Assertions.assertEquals(userCart.getPurchasedProductList(), allProducts);
	}
	
	@Test
	public void deleteProdFromCart_null() {
		Mockito.when(cRepo.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		Optional<Object> deletedProd = csimpl.deleteProdFromCart(1, 1);
		Assertions.assertEquals(null, deletedProd);
	}
	
	@Test
	public void deleteProdFromCart() {
		UserCart uCart = new UserCart(1);
		List<PurchasedProduct> purchasedProductList
				= new ArrayList<PurchasedProduct>();
		purchasedProductList.add(new PurchasedProduct(1,10,100));
		purchasedProductList.add(new PurchasedProduct(2,10,100));
		uCart.setPurchasedProductList(purchasedProductList);
		Mockito.when(cRepo.findById(Mockito.anyInt())).thenReturn(Optional.of(uCart));
		Optional<Object> deletedProd = csimpl.deleteProdFromCart(1, 1);
		Assertions.assertEquals(Optional.of("deleted"), deletedProd);
	}
	
	@Test
	public void addProduct_usernull() {
		Mockito.when(cRepo.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		Mockito.when(psimpl.getProductById(Mockito.anyInt())).thenReturn(new Product("cookie" , 10));
		PurchasedProduct addedProduct = csimpl.addProduct(1, 1, 10);
		Assertions.assertEquals(null, addedProduct);		
	}
	
	@Test
	public void addProduct_productnull() {
		Mockito.when(cRepo.findById(Mockito.anyInt())).thenReturn(Optional.of(new UserCart(1)));
		Mockito.when(psimpl.getProductById(Mockito.anyInt())).thenReturn(null);
		PurchasedProduct addedProduct = csimpl.addProduct(1, 1, 10);
		Assertions.assertEquals(null, addedProduct);		
	}
	
	@Test
	public void addProduct() {
		Product prod = new Product("cookie" , 10);	
		Mockito.when(cRepo.findById(Mockito.anyInt())).thenReturn(Optional.of(new UserCart(1)));
		Mockito.when(psimpl.getProductById(Mockito.anyInt())).thenReturn(prod);
		Mockito.when(calc.calculatePrice(Mockito.any(), Mockito.anyInt())).thenReturn(100L);
		PurchasedProduct addedProduct = csimpl.addProduct(1, 1, 10);
		PurchasedProduct answer = new PurchasedProduct(1,10,100);
		//check here
//		Assertions.assertTrue(addedProduct.getId() == (answer.getId()-1));
	}
	
	@Test
	public void updateQuantity_null() {
		
		Mockito.when(cRepo.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		PurchasedProduct updateQuantity = csimpl.updateQuantity(1, 1, 5);
		Assertions.assertEquals(null, updateQuantity);
	}
	
	@Test
	public void updateQuantity_itemnull() {
		UserCart uCart = new UserCart(1);
		PurchasedProduct purchasedProduct  = new PurchasedProduct(1,10,100);
		List<PurchasedProduct> purchasedProductList
				= new ArrayList<PurchasedProduct>();
		purchasedProductList.add(purchasedProduct);
		uCart.setPurchasedProductList(purchasedProductList);
		Mockito.when(cRepo.findById(Mockito.anyInt())).thenReturn(Optional.of(uCart));
		PurchasedProduct updateQuantity = csimpl.updateQuantity(1, 1, 5);
		Assertions.assertEquals(null, updateQuantity);
	}
	
	@Test
	public void updateQuantity() {
		UserCart uCart = new UserCart(1);
		PurchasedProduct purchasedProduct  = new PurchasedProduct(1,10,100);
		List<PurchasedProduct> purchasedProductList
				= new ArrayList<PurchasedProduct>();
		purchasedProductList.add(purchasedProduct);
		uCart.setPurchasedProductList(purchasedProductList);
		Mockito.when(cRepo.findById(Mockito.anyInt())).thenReturn(Optional.of(uCart));
		PurchasedProduct updateQuantity = csimpl.updateQuantity(1, 0, 5);
//		Assertions.assertTrue(updateQuantity.getQuantity() == 5);
	}
}
