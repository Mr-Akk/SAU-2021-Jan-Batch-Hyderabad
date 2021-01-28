package com.accolite.ordermanager.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.ordermanager.dao.PurchasedProduct;
import com.accolite.ordermanager.entity.UserCart;
import com.accolite.ordermanager.impl.CartServiceimpl;
import com.accolite.ordermanager.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartService csimpl;
	
	@GetMapping("/create/{cusId}")
	public int createCart(@PathVariable("cusId") Integer cusId) {
		
		UserCart createdCart = csimpl.createCart(cusId);
		return createdCart.getId();
	}

	@GetMapping("/{cartId}")
	public List<PurchasedProduct> getAllProducts(@PathVariable("cartId") Integer cartId) {
		
		return csimpl.getAllProducts(cartId);
		
	}
	
	@GetMapping("/{cartId}/{prodId}/{quantity}")
	public ResponseEntity<Object> addProduct(@PathVariable("cartId") Integer cartId , 
			@PathVariable("prodId") Integer prodId , 
			@PathVariable("quantity") Integer quantity) {
		
		PurchasedProduct addedProduct = csimpl.addProduct(cartId , prodId , quantity);
		
		if(addedProduct==null) {
			return new ResponseEntity<Object>("Invalid details!!" , HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(addedProduct);
	}
	
	@DeleteMapping("/delete/{cartId}/{purchaedProdId}")
	public ResponseEntity<Object> deletePurchasedProd(@PathVariable("purchaedProdId") Integer purchaedProdId , 
			@PathVariable("cartId") Integer cartId ) {
		
				csimpl.deleteProdFromCart(cartId , purchaedProdId);
				return ResponseEntity.ok("Product Successfully deleted from your cart");
				
	}
	
	@PutMapping("update/{cartId}/{pProdId}/{quantity}")
	public ResponseEntity<Object> updateQuantity(@PathVariable("cartId") Integer cartId,
			@PathVariable("pProdId") Integer pProdId,
			@PathVariable("quantity") Integer quantity) {
		
		PurchasedProduct updatedProd = csimpl.updateQuantity(cartId , pProdId , quantity);
		
		if(updatedProd == null) {
			return new ResponseEntity<Object>( "Invalid details!!" , HttpStatus.NOT_FOUND );
		}
		return ResponseEntity.ok(updatedProd);
		
	}
}
