package com.au.model;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



@Component

public class Bike implements InitializingBean {
	
	@Autowired
//	@Qualifier("drum")
	@Qualifier("disc")
	BikeBreak bikeBreak;
	
//	public Bike() {
//		this.bikeBreak = new BikeBreak();
//		
//	}
	
	

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

@Override
public void afterPropertiesSet() throws Exception {
	// TODO Auto-generated method stub
	System.out.println("initttt");
}	
	
	
	

}
