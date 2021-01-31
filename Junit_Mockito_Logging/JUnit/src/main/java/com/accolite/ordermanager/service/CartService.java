package com.accolite.ordermanager.service;

import java.util.List;
import java.util.Optional;

import com.accolite.ordermanager.dao.PurchasedProduct;
import com.accolite.ordermanager.entity.UserCart;

public interface CartService {

	public UserCart createCart(Integer id);
	
	public UserCart getCartById(Integer id);
	
	public List<PurchasedProduct> getAllProducts(Integer cartId);
	
	public PurchasedProduct addProduct(Integer cartId, Integer prodId, Integer quantity);
	
	public Optional<Object> deleteProdFromCart(Integer cartId, Integer purchaedProdId);
	
	public PurchasedProduct updateQuantity(Integer cartId, Integer pProdId, Integer quantity);
	
	
	
	
}
