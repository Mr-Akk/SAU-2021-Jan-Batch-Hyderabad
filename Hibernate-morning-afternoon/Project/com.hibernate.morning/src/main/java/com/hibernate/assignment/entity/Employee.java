package com.hibernate.assignment.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	
	private String firstName;

	private String lastName;
	
	@OneToOne(cascade = CascadeType.ALL)
	private EmployeeDetails empDetails;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "employee")
	private List<Address> addressList = new ArrayList<Address>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Course> courseList = new ArrayList<Course>();
	

	public Employee() {
		super();
	}
	
	public int getEmpId() {
		return empId;
	}

	public Employee( String firstName, String lastName, EmployeeDetails empDetails) {
	super();

	this.firstName = firstName;
	this.lastName = lastName;
	this.empDetails = empDetails;
}
	
	public Employee(int empId, String firstName, String lastName, EmployeeDetails empDetails,
			List<Address> addressList) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.empDetails = empDetails;
		this.addressList = addressList;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public EmployeeDetails getEmpDetails() {
		return empDetails;
	}

	public void setEmpDetails(EmployeeDetails empDetails) {
		this.empDetails = empDetails;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

}
