package com.multithread;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class CountSentence extends Thread{
	@Override
	public void run() {
			try {
			BufferedReader reader = null;
			File file = new File("/Users/akashm/Desktop/Book.txt");	
			FileInputStream fileStream = new FileInputStream(file);
		      InputStreamReader input = new InputStreamReader(fileStream);
		     reader = new BufferedReader(input);	
		     int wordCount = 0;
		     String data;
		     while((data = reader.readLine()) != null){
		    	 String[] words = data.split("(?<=[a-z])\\.\\s+");
		    	 if (words[0].equals("")) {
						continue;
					}
		         wordCount += words.length;
		      }
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Exception from countSentence thread");
		}
	}

}
