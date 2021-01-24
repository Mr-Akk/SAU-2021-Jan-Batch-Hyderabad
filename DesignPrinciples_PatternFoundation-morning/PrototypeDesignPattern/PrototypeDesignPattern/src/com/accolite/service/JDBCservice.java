package com.accolite.service;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.accolite.dao.Product;

public interface JDBCservice {
	
	public void createConnection();
	
	public void fetchFromDatabase(Statement stm) throws SQLException;
	
	public List<Product> getData() throws SQLException;

}
