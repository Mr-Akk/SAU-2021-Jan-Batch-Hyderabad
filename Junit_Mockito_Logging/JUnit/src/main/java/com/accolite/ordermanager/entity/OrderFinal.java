package com.accolite.ordermanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OrderFinal {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	
	@OneToOne
	private UserCart placedorder;
	
	

	public OrderFinal() {
		super();
	}



	public OrderFinal(UserCart placedorder) {
		super();
		this.placedorder = placedorder;
	}



	public int getOrderid() {
		return orderid;
	}



	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}



	public UserCart getPlacedorder() {
		return placedorder;
	}



	public void setPlacedorder(UserCart placedorder) {
		this.placedorder = placedorder;
	}
	
	
	
	
	
}
