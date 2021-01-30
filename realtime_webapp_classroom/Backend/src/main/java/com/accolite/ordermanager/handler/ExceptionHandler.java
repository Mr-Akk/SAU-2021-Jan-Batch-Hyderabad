package com.accolite.ordermanager.handler;

import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionHandler {
	
	Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
	public String globalExceptionHandler(HttpServletRequest request , Exception ex) {
		
		System.out.println("Exception handling!!!!");
		logger.error("Request " + request.getRequestURL() + " created an exception " + ex);
		
		return "Something Occurred .Please try again!";
		
	}
}
