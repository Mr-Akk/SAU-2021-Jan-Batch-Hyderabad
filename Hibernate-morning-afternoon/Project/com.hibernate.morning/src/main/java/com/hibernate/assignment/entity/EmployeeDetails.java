package com.hibernate.assignment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String phoneNumber;
	
	private String email;

	public EmployeeDetails() {
		super();
	}

	public EmployeeDetails(String phoneNumber, String email) {
		super();
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}

	
}
