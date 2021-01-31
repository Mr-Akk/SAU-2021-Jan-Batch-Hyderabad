package com.accolite.ordermanager.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PurchasedProductTest {

	@Test
	public void checkDao() {
		PurchasedProduct product = new PurchasedProduct(1,1,10,100);
		PurchasedProduct product2 = new PurchasedProduct();
		product2.setId(1);
		product2.setProdId(1);
		product2.setQuantity(10);
		product2.setTotalPrice(10);
		product2.getTotalPrice();
		product2.getQuantity();
	}

}
