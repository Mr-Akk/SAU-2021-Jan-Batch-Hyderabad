package com.accolite.service;

import java.util.List;

import com.accolite.dao.Product;

public interface ShowRoomPrototype extends Cloneable{

	 List<Product> clone() throws CloneNotSupportedException;
		
}
