package com.multithread;

import java.io.BufferedReader;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class CountWords extends Thread {
	
	@Override
	public void run() {
			  int wordCount = 0;
		try {
			BufferedReader reader = null;
			File file = new File("/Users/akashm/Desktop/Book.txt");		
			FileInputStream fileStream = new FileInputStream(file);
		      InputStreamReader input = new InputStreamReader(fileStream);
		     reader = new BufferedReader(input);		     
		     String data;
		     while((data = reader.readLine()) != null){
		    	 String[] words = data.split("\\s+");
		         wordCount += words.length;
		      }	   
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Exception from count words thread");
		}	
	}
}
