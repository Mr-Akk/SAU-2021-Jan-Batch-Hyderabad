package com.accolite.ordermanager.entity;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.accolite.ordermanager.dao.PurchasedProduct;

@ExtendWith(MockitoExtension.class)
public class UserCartTest {

	@Test
	public void checkUsercart() {
		UserCart u1 = new UserCart();
		UserCart u2 = new UserCart(2);
		u1.setId(1);
		u1.getId();
		u1.setCusId(1);
		u1.getCusId();
		List<PurchasedProduct> productsList = new ArrayList<PurchasedProduct>();
		productsList.add(new PurchasedProduct());
		u1.setPurchasedProductList(productsList);
		u1.getPurchasedProductList();
		
	}
}
