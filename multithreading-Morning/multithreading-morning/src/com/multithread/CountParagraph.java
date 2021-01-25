package com.multithread;

import java.io.BufferedReader;
import java.io.FileReader;

public class CountParagraph extends Thread{

	@Override
	public void run() {
		try {
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
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Exception from count paragraph ");
		}
	}
}
