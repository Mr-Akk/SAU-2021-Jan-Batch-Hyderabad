package com.multithread.individual.Thread;

import java.util.concurrent.Callable;


public class CallableCountSentence implements Callable<Integer>{

	public String str;
	
	public CallableCountSentence() {
		super();
	}

	public CallableCountSentence(String str) {
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
		String s[] = str.split("(?<=[a-z])\\.\\s+");
		return s.length;		
	}
}
