package com.accolite.ordermanager.dao;

import javax.persistence.Embeddable;


@Embeddable
public class PurchasedProduct {
	
	static int idCount = 0;
	
	private int id;
	
	private int prodId;
	
	private int quantity;
	
	private long totalPrice;

	public PurchasedProduct() {
		super();
	}

	public PurchasedProduct( int prodId, int quantity , long totalPrice) {
		super();
		this.id = idCount++;
		this.prodId = prodId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
		
}
