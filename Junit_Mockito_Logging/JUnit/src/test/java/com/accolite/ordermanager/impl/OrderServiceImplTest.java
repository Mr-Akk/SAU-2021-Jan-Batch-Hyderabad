package com.accolite.ordermanager.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.accolite.ordermanager.dao.PurchasedProduct;
import com.accolite.ordermanager.entity.OrderFinal;
import com.accolite.ordermanager.entity.UserCart;
import com.accolite.ordermanager.repo.OrderRepo;
import com.accolite.ordermanager.service.OrderService;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

	@Mock
	CartServiceimpl csimpl;
	
	@Mock
	OrderRepo oRepo;
	
	@InjectMocks
	OrderServiceImpl osimpl;
	
	@Test
	public void placeOrder_null() {
		Mockito.when(csimpl.getCartById(Mockito.anyInt())).thenReturn(null);
		Optional placeOrder = osimpl.placeOrder(1);
		Assertions.assertEquals(Optional.empty(), placeOrder);	
	}
	
	@Test
	public void placeOrder() {
		List<PurchasedProduct> purchasedProductList = new ArrayList<PurchasedProduct>();	
		UserCart userCart = new UserCart();
		
		userCart.setCusId(1);
		userCart.setPurchasedProductList(purchasedProductList);
		OrderFinal orderFinal = new OrderFinal(userCart);
		Mockito.when(csimpl.getCartById(Mockito.anyInt())).thenReturn(userCart);
		Mockito.when(oRepo.save(Mockito.any())).thenReturn(null);
		Optional placeOrder = osimpl.placeOrder(1);
		Assertions.assertEquals(Optional.of("Order Placed!"), placeOrder);
	}
	

}
