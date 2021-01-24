package com.accolite.ordermanager.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.ordermanager.entity.OrderFinal;
import com.accolite.ordermanager.entity.UserCart;
import com.accolite.ordermanager.repo.OrderRepo;
import com.accolite.ordermanager.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	CartServiceimpl csimpl;
	
	@Autowired
	OrderRepo oRepo;
	
	public Optional placeOrder(Integer cartId) {
		
		UserCart placedOrder = csimpl.getCartById(cartId);
		
		if(placedOrder == null) {return Optional.empty();}
			
			OrderFinal orderFinal = new OrderFinal(placedOrder);
			oRepo.save(orderFinal);
			
			return Optional.of("Order Placed!");
		
		
	}

}
