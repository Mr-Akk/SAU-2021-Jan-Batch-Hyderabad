package com.au.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("disc")
public class DiscBikeBreak implements BikeBreak {

	@Override
	public void applyBreak() {
		// TODO Auto-generated method stub
		System.out.println("disc applied successfully");
	}
}
