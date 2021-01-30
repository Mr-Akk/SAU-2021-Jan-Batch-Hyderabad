package com.au.model;

import org.springframework.stereotype.Component;

@Component
public class ShapeHolder {
	
	private Shape shape1;
	
	private Shape shape2;

	public Shape getShape1() {
		return shape1;
	}

	public void setShape1(Shape shape1) {
		this.shape1 = shape1;
	}

	public Shape getShape2() {
		return shape2;
	}

	public void setShape2(Shape shape2) {
		this.shape2 = shape2;
	}
	
	
	
	

}
