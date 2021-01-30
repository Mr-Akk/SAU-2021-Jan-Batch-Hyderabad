package com.au.aspect;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.au.model.ShapeHolder;


//@ComponentScan(basePackages = "com.au")
public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext context = new 
				ClassPathXmlApplicationContext("spring.xml");
		ShapeHolder shapeHolder = context.getBean("shapeHolder",ShapeHolder.class);
		shapeHolder.getShape1().printShapeName();
		shapeHolder.getShape2().printShapeName();

		context.close();
	}
}
