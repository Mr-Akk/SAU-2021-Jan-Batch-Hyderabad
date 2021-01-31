package com.accolite.ordermanager.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OrderFinalTest {

	@Test
	public void checkOrder() {
		
		OrderFinal orderFinal2 = new OrderFinal();
		UserCart userCart = new UserCart(1);
		
		orderFinal2.setOrderid(1);
		orderFinal2.getOrderid();
		orderFinal2.setPlacedorder(userCart);
		orderFinal2.getPlacedorder();
		OrderFinal orderFinal1 = new OrderFinal(userCart);
		
		
	}
}
