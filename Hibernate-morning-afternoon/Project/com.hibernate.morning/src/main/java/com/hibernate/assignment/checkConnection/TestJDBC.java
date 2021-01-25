package com.hibernate.assignment.checkConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
	
	public static void main(String[] args) {
		String jdbcurlString = "jdbc:mysql://localhost:3306/ilearn?useSSL=false";
		String userString = "root";
		String passString = "80332719";
		try {
			System.out.println("connecting to db");
			Connection con = DriverManager.getConnection(jdbcurlString , userString , passString);
			System.out.println("connection successfull");
		}
		catch (Exception e) {
System.out.println(e);
		}
	}

}
