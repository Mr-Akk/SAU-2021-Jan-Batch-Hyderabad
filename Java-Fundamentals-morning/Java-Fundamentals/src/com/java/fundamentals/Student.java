package com.java.fundamentals;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

	
	@XmlElement(name = "roll")
	public int roll;
	
	@XmlElement(name = "marks")
	public int marks;
	@XmlElement(name = "subject")
	public String subject;
	
	
	
	public int getRoll() {
		return roll;
	}
	
	
	public void setRoll(int roll) {
		this.roll = roll;
	}
	
	
	public int getMarks() {
		return marks;
	}
	
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
	public String getSubject() {
		return subject;
	}
	
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Student [roll=" + roll + ", marks=" + marks + ", subject=" + subject + "]";
	}
	
	
}
