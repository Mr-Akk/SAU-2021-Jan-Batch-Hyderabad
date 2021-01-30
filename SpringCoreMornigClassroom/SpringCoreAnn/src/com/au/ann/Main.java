package com.au.ann;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.au.model.Bike;



@ComponentScan(basePackages = "com.au")
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context = new 
				AnnotationConfigApplicationContext(Main.class);
		Bike bike = context.getBean(Bike.class);
		bike.getBikeBreak().applyBreak();
		context.close();
	}

}
