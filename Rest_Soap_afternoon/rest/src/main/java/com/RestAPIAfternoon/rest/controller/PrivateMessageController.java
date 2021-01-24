package com.RestAPIAfternoon.rest.controller;

import java.security.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestAPIAfternoon.rest.entity.PrivateMessage;
import com.RestAPIAfternoon.rest.entity.User;
import com.RestAPIAfternoon.rest.impl.PrivateMessageServiceImpl;
import com.RestAPIAfternoon.rest.impl.UserServiceImpl;
import com.RestAPIAfternoon.rest.repository.PrivateMessageRepository;
import com.RestAPIAfternoon.rest.repository.UserRepository;
import com.RestAPIAfternoon.rest.service.UserService;

@RestController
@RequestMapping("/api/message")
public class PrivateMessageController {
	

	
	@Autowired
	PrivateMessageServiceImpl privateMessageImpl;
	
	@Autowired
	PrivateMessageRepository re;
	
	@PostMapping("/add/{userid}")
	public ResponseEntity<Object> postMessage(@RequestBody PrivateMessage privateMessage,
			@PathVariable("userid") Integer userid) {
		
		PrivateMessage addMessage = privateMessageImpl.addMessage(privateMessage, userid);
				
		return ResponseEntity.ok(addMessage);
		
	}
	
	//Once the message is posted it should not be updated or deleted . 
	
	
}
