package com.accolite.ordermanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(min = 2,message = "First name should be minimum of two letters")
	private String name;
	
	@NotNull
	@Email
	private String emailId;
	
	@NotNull
	private String houseNo;
	
	@NotNull
	private String street;
	
	@NotNull
	private String city;
	
	@NotNull
	private String country;
	
	@NotNull
	private String pincode;
	
	

	public Customer() {
		super();
	}

	
	


	public Customer(String name, String emailId, String houseNo, String street, String city, String country,
			String pincode) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.country = country;
		this.pincode = pincode;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}





	public String getHouseNo() {
		return houseNo;
	}





	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}





	public String getStreet() {
		return street;
	}





	public void setStreet(String street) {
		this.street = street;
	}





	public String getCity() {
		return city;
	}





	public void setCity(String city) {
		this.city = city;
	}





	public String getCountry() {
		return country;
	}





	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}



	

	
	
	

}
