package com.realtime.morning_demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realtime.morning_demo.controller.dto.UserDetail;

@RestController
@RequestMapping("/userdetail")
public class UserDetailController {
	
	@GetMapping("/getdata")
	public List<UserDetail> getData(){
		List<UserDetail> userDetails = new ArrayList<UserDetail>();
		userDetails.add(new UserDetail( " msd"));
		userDetails.add(new UserDetail( " kohli"));
		userDetails.add(new UserDetail( " sachin"));
		userDetails.add(new UserDetail( " warner"));
		userDetails.add(new UserDetail( " williamson"));
		return userDetails;
	}

}
