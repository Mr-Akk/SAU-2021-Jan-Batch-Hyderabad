package com.accolite.ordermanager.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartServiceimpl csimpl;
	
	private Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@GetMapping("/create/{cusId}")
	public int createCart(@PathVariable("cusId") Integer cusId) {
		
		UserCart createdCart = csimpl.createCart(cusId);
		logger.info("Cart created successfully");
		return createdCart.getId();
	}

	@GetMapping("/{cartId}")
	public ResponseEntity<Object> getAllProducts(@PathVariable("cartId") Integer cartId) {
		
		List<PurchasedProduct> allProducts = csimpl.getAllProducts(cartId);
		logger.info("All products were sent");
		return ResponseEntity.ok(allProducts); 
		
	}
	
	@GetMapping("/{cartId}/{prodId}/{quantity}")
	public ResponseEntity<Object> addProduct(@PathVariable("cartId") Integer cartId , 
			@PathVariable("prodId") Integer prodId , 
			@PathVariable("quantity") Integer quantity) {
		
		PurchasedProduct addedProduct = csimpl.addProduct(cartId , prodId , quantity);
		
		if(addedProduct==null) {
			logger.warn("make sure that correct product details were provided");
			logger.error("Error happened while adding product");
			return new ResponseEntity<Object>("Invalid details!!" , HttpStatus.NOT_FOUND);
		}
		logger.info("Product added");
		return ResponseEntity.ok(addedProduct);
	}
	
	@DeleteMapping("/delete/{cartId}/{purchaedProdId}")
	public ResponseEntity<Object> deletePurchasedProd(@PathVariable("purchaedProdId") Integer purchaedProdId , 
			@PathVariable("cartId") Integer cartId ) {
		
				csimpl.deleteProdFromCart(cartId , purchaedProdId);
				logger.info("Product deleted");
				return ResponseEntity.ok("Product Successfully deleted from your cart");
				
	}
	
	@PutMapping("update/{cartId}/{pProdId}/{quantity}")
	public ResponseEntity<Object> updateQuantity(@PathVariable("cartId") Integer cartId,
			@PathVariable("pProdId") Integer pProdId,
			@PathVariable("quantity") Integer quantity) {
		
		PurchasedProduct updatedProd = csimpl.updateQuantity(cartId , pProdId , quantity);
		
		if(updatedProd == null) {
			logger.warn("Makes sure that product is not null");
			logger.error("Error happened while updating product");
			logger.trace("traccing");
			return new ResponseEntity<Object>( "Invalid details!!" , HttpStatus.NOT_FOUND );
		}
		logger.info("Product updated successfully");
		return ResponseEntity.ok(updatedProd);
		
	}
}
