package com.accolite.ordermanager.controller;



import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.accolite.ordermanager.impl.CartServiceimpl;
import com.accolite.ordermanager.impl.OrderServiceImpl;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

	@Mock
	OrderServiceImpl osimpl;
	
	@InjectMocks
	OrderController oController;
	
	@Mock
	CartServiceimpl csimpl;
	
	@Test
	public void placeOrder() {
		OngoingStubbing<Optional> thenReturn = Mockito.when(osimpl.placeOrder(Mockito.anyInt())).
		thenReturn(Optional.of("yes"));
ResponseEntity<Object> placeorder = oController.placeorder(1);
		
		Assertions.assertEquals(ResponseEntity.ok("Order Placed!!"),
					placeorder);	
		
	}
	
	@Test
	public void placeOrder_Invalid() {
		Mockito.when(osimpl.placeOrder(Mockito.anyInt())).thenReturn(Optional.empty());
		ResponseEntity<Object> placeorder = oController.placeorder(1);
		Assertions.assertEquals(new ResponseEntity<Object>("Invalid order!!" , HttpStatus.NOT_FOUND),
				placeorder);		
	}
}
