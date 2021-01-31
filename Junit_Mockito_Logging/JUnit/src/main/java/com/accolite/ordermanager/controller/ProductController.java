package com.accolite.ordermanager.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.ordermanager.entity.Product;
import com.accolite.ordermanager.impl.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	
	@Autowired
	ProductServiceImpl psimpl;
	
	private Logger logger = LoggerFactory.getLogger(ProductController.class);
 	
	@PostMapping("/add")
	public ResponseEntity<Object> addProduct(@Valid @RequestBody Product product) {		
		Product newProduct = psimpl.addNewProduct(product);		
		logger.info("Prodcut added successfully");
		return ResponseEntity.ok(newProduct);		
	}
	
	@GetMapping("get/{prodId}")
	public ResponseEntity<Object> getProduct(@PathVariable("prodId") Integer prodId){
		Product prod = psimpl.getProductById(prodId);
		if(prod==null) {return new ResponseEntity<Object>("Product not found!!" , HttpStatus.NOT_FOUND);}
		logger.info("Product was sent successfully");
		return ResponseEntity.ok(prod);
	}
	
	//Product should not be deleted or updated

}
