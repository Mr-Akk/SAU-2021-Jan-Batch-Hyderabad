package com.accolite.main;

import java.sql.SQLException;

import com.accolite.dao.ShowRoom;

public class Main {
	
		public static void main(String[] args) throws SQLException, CloneNotSupportedException {
			
			ShowRoom appleShowRoom1 = new ShowRoom();
			appleShowRoom1.setId(1);
			appleShowRoom1.setProductList(appleShowRoom1.getDataFromDatabase());
			System.out.println(appleShowRoom1.getProductList());
			System.out.println("products fetched from database!!");
			//Now if another showroom to be created,we can fetch the data from
			//the database.But the better approach is Prototype design pattern.
			//appleshowroom1 object going to act as a Prototype
			
			ShowRoom appleShowRoom2 = new ShowRoom();
			appleShowRoom2.setId(2);
			appleShowRoom2.setProductList(appleShowRoom1.clone());
			System.out.println(appleShowRoom2.getProductList());
			System.out.println("Products got by using prototype design pattern");
			
		}
}
