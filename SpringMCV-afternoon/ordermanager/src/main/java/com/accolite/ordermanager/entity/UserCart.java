package com.accolite.ordermanager.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.accolite.ordermanager.dao.PurchasedProduct;

@Entity
public class UserCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int cusId;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<PurchasedProduct> purchasedProductList = new ArrayList<PurchasedProduct>();

	
	
	public UserCart() {
		super();
	}



	public UserCart(int cusId) {
		super();
		this.cusId = cusId;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getCusId() {
		return cusId;
	}



	public void setCusId(int cusId) {
		this.cusId = cusId;
	}



	public List<PurchasedProduct> getPurchasedProductList() {
		return purchasedProductList;
	}



	public void setPurchasedProductList(List<PurchasedProduct> purchasedProductList) {
		this.purchasedProductList = purchasedProductList;
	}

	
	
}
