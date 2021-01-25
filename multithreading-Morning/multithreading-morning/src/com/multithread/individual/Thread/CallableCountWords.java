package com.multithread.individual.Thread;

import java.util.concurrent.Callable;

public class CallableCountWords implements Callable<Integer>{

	public String str;
	
	public CallableCountWords(String str) {
		super();
		this.str = str;
	}

	@Override
	public Integer call() throws Exception {
		String s[] = str.split("\\s+");		
		return s.length;
	}

}
