package com.RestAPIAfternoon.rest.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestAPIAfternoon.rest.entity.PrivateMessage;
import com.RestAPIAfternoon.rest.entity.User;
import com.RestAPIAfternoon.rest.repository.PrivateMessageRepository;
import com.RestAPIAfternoon.rest.repository.UserRepository;
import com.RestAPIAfternoon.rest.service.PrivateMessageService;


@Service
public class PrivateMessageServiceImpl implements PrivateMessageService {

	@Autowired
	PrivateMessageRepository privateMessageRepository;
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public PrivateMessage add(PrivateMessage privateMessage) {
		
		return privateMessageRepository.save(privateMessage);
	}

	@Override
	public PrivateMessage addMessage(PrivateMessage privateMessage , Integer id) {
		
		User user = userServiceImpl.getUserById(id);
		privateMessage.setReceivedOn(new Date());
		privateMessage.setUser(user);
		PrivateMessage addedMessage = privateMessageRepository.save(privateMessage);
		user.getMessageList().add(addedMessage);
		User save = userRepo.save(user);		
		return addedMessage;
		
	}
	
	
}
