package com.au.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bike {
	
	
@Autowired
BikeBreak bikeBreak;
	
//	public Bike() {
//		this.bikeBreak = new BikeBreak();
//		
//	}
	
	

	public Bike(BikeBreak bikeBreak) {
	
	this.bikeBreak = bikeBreak;
}

	public Bike() {
	super();
}

	public void setBikeBreak(BikeBreak bikeBreak) {
		this.bikeBreak = bikeBreak;
	}

	public BikeBreak getBikeBreak() {
		return bikeBreak;
	}
	
	public void initBean() {
		System.out.println("init initalised");
		
	}
	
public void destroyBean() {
		
	System.out.println("destroyed");
	}


	
	
}
