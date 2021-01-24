package com.RestAPIAfternoon.rest.service;

import com.RestAPIAfternoon.rest.entity.PrivateMessage;

public interface PrivateMessageService {

	PrivateMessage add(PrivateMessage privateMessage);
	
	public PrivateMessage addMessage(PrivateMessage privateMessage , Integer id);
}
