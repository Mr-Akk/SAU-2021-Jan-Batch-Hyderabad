package com.hibernate.assignment.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String courseName;
	
	@ManyToMany(mappedBy = "courseList")
	private List<Employee> employeeList = new ArrayList<Employee>();
	//Join table name Employee_Course will be created in database.
	//Similarly Join table can also be used.But I went with this method.

	public Course() {
		super();
	}


	public Course(String courseName, List<Employee> employeeList) {
		super();
		this.courseName = courseName;
		this.employeeList = employeeList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public Course(String courseName) {
		super();
		this.courseName = courseName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + "]";
	}
	
}
