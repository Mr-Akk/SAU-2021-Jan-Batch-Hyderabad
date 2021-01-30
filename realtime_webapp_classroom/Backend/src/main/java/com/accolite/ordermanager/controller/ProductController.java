package com.accolite.ordermanager.controller;

import java.util.List;

import javax.validation.Valid;


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
	
	@PostMapping("/add")
	public ResponseEntity<Object> addProduct(@Valid @RequestBody Product product) {		
		System.out.println("add called");
		Product newProduct = psimpl.addNewProduct(product);		
		return ResponseEntity.ok(newProduct);		
	}
	
	@GetMapping("get/{prodId}")
	public ResponseEntity<Object> getProduct(@PathVariable("prodId") Integer prodId){
		Product prod = psimpl.getProductById(prodId);
		if(prod==null) {return new ResponseEntity<Object>("Product not found!!" , HttpStatus.NOT_FOUND);}
		return ResponseEntity.ok(prod);
	}
	
	@GetMapping("get/all")
	public ResponseEntity<Object> getAllProducts(){
		System.out.println("called");
		List<Product> allProduct = psimpl.getAllProduct();
		return ResponseEntity.ok(allProduct);
	}
	//Product should not be deleted or updated

}
