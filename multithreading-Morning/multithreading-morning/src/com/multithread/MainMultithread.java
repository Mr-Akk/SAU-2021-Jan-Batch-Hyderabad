package com.multithread;


public class MainMultithread {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Using Three thread for three sepearte operation!!");
		System.out.println();	
		CountWords t1 = new CountWords();
		CountSentence t2 = new CountSentence();
		CountParagraph t3 = new CountParagraph();	
		long starttime = System.currentTimeMillis();
		t1.start();
		t2.start();
		t3.start();		
		t1.join();
		t2.join();
		t3.join();
		long stopime = System.currentTimeMillis();
		System.out.println("total time taken by three threads : " + (stopime - starttime) + " mmillis");
	}
}
