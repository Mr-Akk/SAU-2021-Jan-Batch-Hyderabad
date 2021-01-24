package com.accolite.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accolite.dao.Product;
import com.accolite.service.JDBCservice;

public class JDBCserviceImpl implements JDBCservice {
	
	private  final String user = "root";
	private  final String password = "80332719";
	private final String DB_url = "jdbc:mysql://localhost:3306/appleshowroom";
	private final String driver = "com.mysql.cj.jdbc.Driver";

	private ResultSet rs = null;
	
	
	public void createConnection() {
		try {
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(DB_url , user , password);
			Statement stm = con.createStatement();
			fetchFromDatabase(stm);
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("error while creating a JDBC connection");
		}
		
	}
	
	public void fetchFromDatabase(Statement stm) throws SQLException {
		
		String sql = "select * from products"; 
		 rs = stm.executeQuery(sql);
		
	}
	
	public List<Product> getData() throws SQLException {
		
		createConnection();
		
		List<Product> productList = new ArrayList<Product>();
		
		while(rs.next()) {
			Product p = new Product();
			p.setId(rs.getInt(1));
			p.setProductName(rs.getString(2));
			p.setProductPrice(rs.getString(3));
			productList.add(p);
		}
		
		return productList;
		
	}

}
