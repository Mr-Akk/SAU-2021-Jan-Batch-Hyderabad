package com.multithread.individual;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.multithread.individual.Thread.CallableCountParagraph;
import com.multithread.individual.Thread.CallableCountSentence;
import com.multithread.individual.Thread.CallableCountWords;

public class Main{
	
	static String textBook;
	public Main() {
		super();
	}

	static void countSentence(int chunk) throws IOException, InterruptedException, ExecutionException {
		ExecutorService ex = Executors.newFixedThreadPool(10);
		long startTime = System.currentTimeMillis();
		int start = 0;
		int end = chunk;
		int incSize = chunk;
		int result = 0;
		for (int i = 0; i < 10; i++) {			
			Future<Integer> submit = ex.submit(new CallableCountSentence(textBook.substring(start , end)));
			Integer ans = submit.get();
			result+=ans;
			start =end;
			end+=incSize;
		}		
		long endTime = System.currentTimeMillis();
		System.out.println("total senetences counted in " + (endTime - startTime) + " millis");
	}
	
	private static void CountParagraph(int chunk) throws IOException, InterruptedException, ExecutionException {

		ExecutorService ex = Executors.newFixedThreadPool(10);
		long startTime = System.currentTimeMillis();
		int start = 0;
		int end = chunk;
		int incSize = chunk;
		int result = 0;
		for (int i = 0; i < 10; i++) {			
			Future<Integer> submit = ex.submit(new CallableCountParagraph(textBook.substring(start , end)));
			Integer ans = submit.get();
			result+=ans;
			start =end;
			end+=incSize;
		}		
		long endTime = System.currentTimeMillis();
		System.out.println("total paragraphs counted in " + (endTime - startTime) + " millis");
	}
	
	static void countWords(int chunk) throws IOException, InterruptedException, ExecutionException{
		int result = 0;	
		ExecutorService ex = Executors.newFixedThreadPool(10);
		long startTime = System.currentTimeMillis();
		int start = 0;
		int end = chunk;
		int incSize = chunk;
		for (int i = 0; i < 10; i++) {		
			Future<Integer> submit = ex.submit(new CallableCountWords(textBook.substring(start , end)));
			Integer ans = submit.get();
			result+=ans;
			start =end;
			end+=incSize;
		}		
		ex.shutdown();
		long endTime = System.currentTimeMillis();		
		System.out.println("Total number of words calculated in ");
		System.out.println(endTime - startTime + " millis");
	}

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		
		Path path = Path.of("/Users/akashm/Desktop/Book.txt");
		textBook = Files.readString(path);
		//similarly n chunks can be made for n threads.
		int chunk = textBook.length()/10;
		countWords(chunk);
		countSentence(chunk);
		CountParagraph(chunk);		
	}
}

