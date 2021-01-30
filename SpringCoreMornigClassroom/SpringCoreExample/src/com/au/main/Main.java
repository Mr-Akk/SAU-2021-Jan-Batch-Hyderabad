package com.au.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.au.model.Bike;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context = new 
				ClassPathXmlApplicationContext("spring.xml");
		Bike bike = context.getBean("bike" , Bike.class);
		bike.getBikeBreak().applyBreak();
		context.close();
	}

}
