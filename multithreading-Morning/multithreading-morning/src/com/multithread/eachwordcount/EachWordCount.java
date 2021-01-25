package com.multithread.eachwordcount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class EachWordCount {

	public static void main(String[] args) throws IOException {
		
		Path path = Path.of("/Users/akashm/Desktop/Book.txt");
		String textBook = Files.readString(path);
		String s[] = textBook.split("\\s+");
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		for (int i = 0; i < s.length; i++) {
			if(hashMap.containsKey(s[i])) {
				hashMap.put(s[i], hashMap.get(s[i])+1);
			}
			else {
				hashMap.put(s[i],1);
			}
		}
		
//		for(String strKey : hashMap.keySet() ) {
//			System.out.println(strKey +" "+hashMap.get(strKey));
//		}
		
	}
}
