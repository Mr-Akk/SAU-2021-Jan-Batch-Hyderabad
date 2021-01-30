package com.kafka.assignment.dao;

public class Teacher {
	
	static int idCount = 0;
	
	private int id;
	private String name;
	private String subject;
	
	
	public Teacher() {
		super();
	}


	public Teacher( String name, String subject) {
		super();
		this.id = idCount++;
		this.name = name;
		this.subject = subject;
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


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", subject=" + subject + "]";
	}
	
	
	

}
