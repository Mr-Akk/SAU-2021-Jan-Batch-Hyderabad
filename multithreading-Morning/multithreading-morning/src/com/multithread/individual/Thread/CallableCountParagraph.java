package com.multithread.individual.Thread;


import java.util.concurrent.Callable;

public class CallableCountParagraph implements Callable<Integer> {

	private String str;
		
	public CallableCountParagraph() {
		super();
	}

	public CallableCountParagraph(String str) {
		super();
		this.str = str;
	}
	

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public Integer call() throws Exception {
		String s[] = str.split("\n");
		return s.length;
	}
			
}
