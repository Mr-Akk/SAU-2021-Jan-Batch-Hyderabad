package com.accolite.ordermanager.service;

import java.util.Optional;

public interface OrderService {

	public Optional placeOrder(Integer cartId);
}
