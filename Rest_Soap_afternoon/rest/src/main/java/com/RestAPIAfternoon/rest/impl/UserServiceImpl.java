package com.RestAPIAfternoon.rest.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestAPIAfternoon.rest.encoder.PasswordEncoder;
import com.RestAPIAfternoon.rest.entity.User;
import com.RestAPIAfternoon.rest.repository.UserRepository;
import com.RestAPIAfternoon.rest.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder encoder;
	

	@Override
	public User addUser(User user) {
		
		
		 user.setPassword(encoder.getEncoder().encode(user.getPassword()));
		User savedUser = userRepository.save(user);
		System.out.println(savedUser);
		return savedUser;

	}


	@Override
	public User getUserById(Integer id) {
		System.out.println(id);
		Optional<User> user = userRepository.findById(id);
		
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}


	@Override
	public Optional<Object> deleteUserById(Integer id) {
		
		 Optional<User> isUser = userRepository.findById(id);
		 if (isUser.isPresent()) {
			 
			 User user = isUser.get();
			 userRepository.delete(user);
			 return Optional.of("yes");
			
		}
		 
		return Optional.empty();
		
	}


	@Override
	public User updateUserPasswordById(Integer id , User updateUser) {
		
		User user = getUserById(id);
		if (user != null) {
			user.setPassword(encoder.getEncoder().encode(updateUser.getPassword()) );
			
			return userRepository.save(user);
		}
		return null;
		
		
	}

	@Override
	public Object getMyMessage(User user) {
		
		User u = getUserById(user.getId());
		if(encoder.getEncoder().matches(user.getPassword(),u.getPassword())) {
			return u.getMessageList();
		}
		return null;
		
	}
	
	

	
	
	
	
	
	
}
