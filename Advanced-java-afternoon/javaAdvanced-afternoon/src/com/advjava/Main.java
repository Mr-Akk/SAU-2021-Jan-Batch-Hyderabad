package com.advjava;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.mysql.cj.jdbc.JdbcConnection;


public class Main {

	static AssignmentsParse assigns;	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	//corresponding Databse url can be given
	static final String DB_URL = "jdbc:mysql://localhost:3306/AUadvancejava";
	//Username and password of my MySQL DB
	static final String user = "root";
	static final String pass = "80332719";
	
	
	static void createTable(Statement stm) throws SQLException {
		String sql = "create table if not exists assignments( id integer primary key,"
				+ "name  varchar(30),"
				+ "status varchar(30),"
				+ "language varchar(10))";
		stm.executeUpdate(sql);
	}
	
	static void insertData(Connection con) throws SQLException {
		
		
		
		PreparedStatement pStatement = con.prepareStatement("insert into "
				+ "assignments values(?,?,?,?)");
				
		for(AssignmentParse aParse : assigns.getAssignment()) {
					
			pStatement.setInt(1, aParse.getId());
			pStatement.setString(2, aParse.getName());
			pStatement.setString(3, aParse.getStatus());
			pStatement.setString(4, aParse.getLanguage());
			pStatement.executeUpdate();
		}
				
	}
	
	
	static void JdbcConnection() {
		
		Connection con = null;
		Statement stm = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");		
			con = DriverManager.getConnection(DB_URL , user , pass);
			System.out.println("connection made");
			
			stm = con.createStatement();
			
			createTable(stm);
			System.out.println("table created");
			System.out.println();
			
			insertData(con);	
			System.out.println("all parsed data from XML were added to database");
			System.out.println();
			
			stm.close();
			con.close();
		} catch (Exception e) {
			
			System.out.println(e);
			System.out.println("Error while creating a Database connection!!");
		}
		
		
		
	}
	public static void main(String[] args) throws Exception {
		
		try {
			
			File file = new File("./src/com/advjava/Assignments.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(AssignmentsParse.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			 assigns = (AssignmentsParse) jaxbUnmarshaller.unmarshal(file);
			 
			 //parsed into objects
			 for(AssignmentParse aParse : assigns.getAssignment()) {
				 System.out.println(aParse);
			 }
			
		} catch (Exception e) {
			throw new Exception("Parse failed");		
			}
		
		
		JdbcConnection();	
	}
}
