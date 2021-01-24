package com.RestAPIAfternoon.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RestAPIAfternoon.rest.entity.PrivateMessage;
import com.RestAPIAfternoon.rest.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	

}
