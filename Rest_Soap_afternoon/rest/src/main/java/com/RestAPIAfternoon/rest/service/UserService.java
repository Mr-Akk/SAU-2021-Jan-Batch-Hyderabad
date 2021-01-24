package com.RestAPIAfternoon.rest.service;

import java.util.Optional;

import com.RestAPIAfternoon.rest.entity.User;

public interface UserService {

	User addUser(User user);
	
	User getUserById(Integer id);
	
	Optional<Object> deleteUserById(Integer id);
	
	User updateUserPasswordById(Integer id , User user);
}

