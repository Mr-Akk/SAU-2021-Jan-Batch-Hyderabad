package com.au.model;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	
//	@Before("execution (public String com.au.model.ShapeHolder.getShape1())")
//	public void logMessage() {
//		System.out.println("getter has been called");
//	}
	
	@Before("execution (public * com.au.model.*.*())")
	public void logMessage1() {
		System.out.println("getter has been called");
	}
	
	
	

}

