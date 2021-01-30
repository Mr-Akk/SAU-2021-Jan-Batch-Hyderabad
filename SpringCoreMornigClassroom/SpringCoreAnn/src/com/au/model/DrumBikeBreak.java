package com.au.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
@Component
@Qualifier("drum")
public class DrumBikeBreak implements BikeBreak{

	@Override
	public void applyBreak() {
		// TODO Auto-generated method stub
		System.out.println("drum break applied successfully!!");
	}

}
