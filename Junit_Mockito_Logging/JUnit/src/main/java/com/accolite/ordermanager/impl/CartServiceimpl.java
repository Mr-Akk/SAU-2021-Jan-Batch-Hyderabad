package com.accolite.ordermanager.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.ordermanager.dao.PurchasedProduct;
import com.accolite.ordermanager.entity.Product;
import com.accolite.ordermanager.entity.UserCart;
import com.accolite.ordermanager.repo.CartRepo;
import com.accolite.ordermanager.service.CartService;
import com.accolite.ordermanager.shared.Calculation;

import net.bytebuddy.asm.Advice.Return;

@Service
public class CartServiceimpl implements CartService{
	
	@Autowired
	CartRepo cRepo;
	
	@Autowired
	ProductServiceImpl psimpl;
	
	@Autowired
	Calculation calc;
	
	public UserCart createCart(Integer id) {
		
		UserCart newCart = new UserCart(id);
		UserCart savedCart = cRepo.save(newCart);
		return savedCart;
	}

	public UserCart getCartById(Integer id) {
			 Optional<UserCart> cart = cRepo.findById(id);
			 if(cart.isPresent()) {	 return cart.get();	 }
			 return null;			
	}

	public List<PurchasedProduct> getAllProducts(Integer cartId) {		
		UserCart userCart = cRepo.findById(cartId).get();		
		List<PurchasedProduct> purchasedProductList = userCart.getPurchasedProductList();		
		return purchasedProductList;
	}


	public PurchasedProduct addProduct(Integer cartId, Integer prodId, Integer quantity) {		
//		UserCart userCart = getCartById(cartId);
		Optional<UserCart> findById = cRepo.findById(cartId);
		UserCart userCart;
		if(findById.isPresent()) {
			userCart = findById.get();
		}
		else {
			userCart = null;
		}
		Product product = psimpl.getProductById(prodId);		
		if(userCart == null || product==null) {return null;}         
		long calculatedPrice = calc.calculatePrice(product, quantity);
			PurchasedProduct p = new PurchasedProduct(cartId , quantity , calculatedPrice );
			userCart.getPurchasedProductList().add(p);
			cRepo.save(userCart);			
			return p;		
	}


	public Optional<Object> deleteProdFromCart(Integer cartId, Integer purchaedProdId) {
		
		UserCart cart = getCartById(cartId);
		if(cart == null) {
			return null;
		}
		List<PurchasedProduct> collect = cart.getPurchasedProductList().stream()
		.filter(pProd -> pProd.getId()!=purchaedProdId)
		.collect(Collectors.toList());	
		cart.setPurchasedProductList(collect);
		cRepo.save(cart);
		return Optional.of("deleted");
	}

	public PurchasedProduct updateQuantity(Integer cartId, Integer pProdId, Integer quantity) {
		
		UserCart cart = getCartById(cartId);
		if (cart == null) {return null;}
		List<PurchasedProduct> p = new ArrayList<PurchasedProduct>();
		List<PurchasedProduct> collect = cart.getPurchasedProductList().stream()
		.map(prod -> {
			if (prod.getId() == pProdId) {
				prod.setQuantity(quantity);
				Product product = psimpl.getProductById(prod.getProdId());
				prod.setTotalPrice(calc.calculatePrice(product, quantity));
				p.add(prod);
			}
			return prod;
		}).collect(Collectors.toList());		
		cart.setPurchasedProductList(collect);
		cRepo.save(cart);	
		if (p.size()>0) { return p.get(0);}
		return  null;		
	}

}
