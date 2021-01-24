package com.RestAPIAfternoon.rest.entity;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	private String emailId;
	
	private String password;
	
	@OneToMany(mappedBy = "user" , fetch = FetchType.EAGER)
	private List<PrivateMessage> messageList ;

	public User() {
		super();
	}

	public User(String emailId, String password) {
		super();

		this.emailId = emailId;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public List<PrivateMessage> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<PrivateMessage> messageList) {
		this.messageList = messageList;
	}

	@Override
	public String toString() {
		return "User [messageList=" + messageList + "]";
	}

	
	
	
	
	

}
