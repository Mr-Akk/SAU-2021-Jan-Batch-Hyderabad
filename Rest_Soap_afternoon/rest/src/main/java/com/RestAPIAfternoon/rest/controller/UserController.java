package com.RestAPIAfternoon.rest.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestAPIAfternoon.rest.encoder.PasswordEncoder;
import com.RestAPIAfternoon.rest.entity.PrivateMessage;
import com.RestAPIAfternoon.rest.entity.User;
import com.RestAPIAfternoon.rest.impl.UserServiceImpl;
import com.RestAPIAfternoon.rest.repository.UserRepository;
import com.RestAPIAfternoon.rest.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	
	
	@PostMapping("/signup")
	public ResponseEntity<Object> signUp(@RequestBody Map<String, String> userDetails) {
		
		String emailId = userDetails.get("emailId");
		String password = userDetails.get("password");
		
		User user1 = new User(emailId , password);
		userServiceImpl.addUser(user1);
		return ResponseEntity.ok(user1);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable("id") Integer id) {
		
		Optional<Object> isDeleted = userServiceImpl.deleteUserById(id);
		if (isDeleted.isPresent()) {
			return ResponseEntity.ok("deleted");
		}
		return new ResponseEntity<>("User not dound" , HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateUserById(@PathVariable("id") Integer id,
			@RequestBody User userToUpdate){
		
		User updatedUser = userServiceImpl.updateUserPasswordById(id , userToUpdate);
		
		if (updatedUser != null) {
			return ResponseEntity.ok(updatedUser);
		}
		return new ResponseEntity<>("User not found" , HttpStatus.NOT_FOUND);
	}
	
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getUser(@PathVariable("id") Integer id) {
		
		User user = userServiceImpl.getUserById(id);
		
		if(user!=null) {
		return 	ResponseEntity.ok(user);
		}
		return new ResponseEntity<>("User not dound" , HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/get/privatemessage")
	public ResponseEntity<Object> getMyMessages(@RequestBody User user){
		
		Object myMessage = userServiceImpl.getMyMessage(user);
		
		if(myMessage == null) {return new ResponseEntity<Object>("Access Denied!!" , HttpStatus.UNAUTHORIZED);}
		
		
	return ResponseEntity.ok(myMessage);
	}
	
	
	
	
	

}
