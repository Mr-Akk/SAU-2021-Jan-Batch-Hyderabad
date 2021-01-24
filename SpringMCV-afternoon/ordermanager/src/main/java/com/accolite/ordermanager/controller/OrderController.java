package com.accolite.ordermanager.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.ordermanager.impl.OrderServiceImpl;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderServiceImpl osimpl;
	
	@GetMapping("/{cartId}")
	public ResponseEntity<Object> placeorder(@PathVariable("cartId") Integer cartId) {
		
		Optional placeOrder = osimpl.placeOrder(cartId);
		if(placeOrder.isPresent()) {
			return ResponseEntity.ok("Order Placed!!");
		}
		return new ResponseEntity<Object>("Invalid order!!" , HttpStatus.NOT_FOUND);
		
	}

}
