package com.RestAPIAfternoon.rest.controller;

import javax.websocket.server.PathParam;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/maths")
public class MathsController {

	@GetMapping("/add")
	public Integer addByQuryParam(@RequestParam("num1")  Integer num1 ,
			@RequestParam("num2") Integer num2 ) {
		return num1+num2;
	}
	
	@GetMapping("/add/{num1}/{num2}")
	public Integer addByPathVariable(@PathVariable("num1") Integer num1,
			@PathVariable("num2") Integer num2) {
		return num1+num2;
	}
	
	@GetMapping("/sub/{num1}/{num2}")
	public Integer subByPathVariable(@PathVariable("num1") Integer num1,
			@PathVariable("num2") Integer num2) {
		return num1-num2;
	}
	
	@GetMapping("/mult")
	public Integer multByQuryParam(@RequestParam("num1")  Integer num1 ,
			@RequestParam("num2") Integer num2 ) {
		return num1*num2;
	}
	
	@PostMapping("/div")
	public Integer divByrequestbody(@RequestBody com.RestAPIAfternoon.rest.dao.Number numObj) {
		return  numObj.getNum1()/numObj.getNum2();
	}
	
	
	
}
