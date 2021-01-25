package com.normal;

import java.io.BufferedReader;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	//BufferReader is used to calculate the counts
	
	static int countWords() throws IOException {
		BufferedReader reader = null;
		File file = new File("/Users/akashm/Desktop/Book.txt");		
		FileInputStream fileStream = new FileInputStream(file);
	      InputStreamReader input = new InputStreamReader(fileStream);
	      reader = new BufferedReader(input);		     
	     int wordCount = 0;
	     String data;
	     while((data = reader.readLine()) != null){
	    	 String[] words = data.split("\\s+");
	         wordCount += words.length;
	      }
	     return wordCount;     
	}
	
	static int countSentences() throws IOException{
		BufferedReader reader = null;
		File file = new File("/Users/akashm/Desktop/Book.txt");	
		FileInputStream fileStream = new FileInputStream(file);
	      InputStreamReader input = new InputStreamReader(fileStream);
	     reader = new BufferedReader(input);	
	     int wordCount = 0;
	     String data;
	     while((data = reader.readLine()) != null){
	    	 String[] words = data.split("[!?.:]+");
	    	 if (words[0].equals("")) {
					continue;
				}
	         wordCount += words.length;
	      }
	     return wordCount;	
	}
	
	static int countParagh() throws IOException {
		 BufferedReader in = new BufferedReader(new FileReader("/Users/akashm/Desktop/Book.txt"));
		    String line = in.readLine();
		    int count = 0;
		    StringBuilder paragraph = new StringBuilder();
		    while (true) {
		        if (line==null || line.trim().length() == 0) {
		            count++;
		            paragraph.setLength(0);
		            if(line == null)
		                break;
		        } else {
		            paragraph.append(" ");
		            paragraph.append(line);
		        }
		        line = in.readLine();
		    }
		    in.close();
		   return count;	
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		System.out.println("Using single Thread to calculate count of words,sentence paragraphs at once");
		long startTime = System.currentTimeMillis();	
		 int totalWords = countWords();
		 int totalSentences = countSentences();	 
		 int totalParagraph = countParagh();		 
		 long stopTime = System.currentTimeMillis();
		 long elapsedTime = stopTime - startTime;
		 System.out.println("total time take is");
	      System.out.println(elapsedTime + " millis");	
	      System.out.println();
	      System.out.println("Number of words found to be : " + totalWords);
	}	
	}