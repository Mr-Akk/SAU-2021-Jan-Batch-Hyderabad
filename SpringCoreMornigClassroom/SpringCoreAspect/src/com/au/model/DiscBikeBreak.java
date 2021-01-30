package com.au.model;

import org.springframework.stereotype.Component;

@Component
public class DiscBikeBreak implements BikeBreak {

	@Override
	public void applyBreak() {
		// TODO Auto-generated method stub
		System.out.println("disc applieddddd!!!");
	}
}
