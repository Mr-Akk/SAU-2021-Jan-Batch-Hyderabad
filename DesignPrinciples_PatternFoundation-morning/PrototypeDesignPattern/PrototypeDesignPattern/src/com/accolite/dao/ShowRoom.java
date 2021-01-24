package com.accolite.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accolite.impl.JDBCserviceImpl;
import com.accolite.service.ShowRoomPrototype;

public class ShowRoom implements ShowRoomPrototype {
	
	private int id;
	
	private List<Product> productList = new ArrayList<Product>();

	public List<Product> getDataFromDatabase;

	
	
	
	public ShowRoom() {
		super();
	}

	public ShowRoom(int id, List<Product> productList) {
		super();
		this.id = id;
		this.productList = productList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	
	
	public List<Product> getDataFromDatabase() throws SQLException{
		
		JDBCserviceImpl jdbc = new JDBCserviceImpl();
		
		
		return jdbc.getData();
		
	}
	
	@Override
	public String toString() {
		return "ShowRoom [id=" + id + ", productList=" + productList + "]";
	}

	@Override
	public List<Product> clone() throws CloneNotSupportedException {
		
		List<Product> cloningList = new ArrayList<Product>();
		for(Product p : this.getProductList()) {
			
			cloningList.add(p);
		}
		
		return cloningList;
	}
	
	
	

}
