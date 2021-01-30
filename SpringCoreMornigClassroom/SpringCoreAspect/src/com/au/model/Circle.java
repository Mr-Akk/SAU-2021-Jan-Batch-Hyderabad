package com.au.model;

public class Circle implements Shape{
	
	private String shapeName;
	
	

	public String getShapeName() {
		return shapeName;
	}



	public void setShapeName(String shapeName) {
		this.shapeName = shapeName;
	}



	@Override
	public void printShapeName() {
		// TODO Auto-generated method stub
		System.out.println("i am " + shapeName);
	}

}
