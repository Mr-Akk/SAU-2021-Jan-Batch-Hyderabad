package com.java.fundamentals;


public class Singleton {

private static Singleton instance;
	
	private String s;
	private Singleton() {
		this.s = "I am the string from singleton class";
		
	}
	
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	public void printString() {
		System.out.println(this.s);
	}
	
	
}
