package com.RestAPIAfternoon.rest.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {
	
	public BCryptPasswordEncoder getEncoder(){
		
		return new BCryptPasswordEncoder();
	}

}
