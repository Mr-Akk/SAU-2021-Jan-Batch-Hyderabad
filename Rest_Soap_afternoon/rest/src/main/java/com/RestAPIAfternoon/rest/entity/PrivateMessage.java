package com.RestAPIAfternoon.rest.entity;

import java.security.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class PrivateMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String message;
	
	private Date receivedOn;
	
	@ManyToOne
	@JsonIgnore
	private User user;

	public PrivateMessage() {
		super();
	}

	

	public PrivateMessage(String message, Date receivedOn, User user) {
		super();
		this.message = message;
		this.receivedOn = receivedOn;
		this.user = user;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
	

	public Date getReceivedOn() {
		return receivedOn;
	}



	public void setReceivedOn(Date receivedOn) {
		this.receivedOn = receivedOn;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	
	
	
	
	
}
