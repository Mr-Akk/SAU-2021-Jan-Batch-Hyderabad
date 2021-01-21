package com.java.schema;

import java.io.Serializable;

public class StudentSchema implements Serializable,Comparable<StudentSchema>{
	
	public int roll;
	public int mark;
	
	
	public StudentSchema() {
		super();
	}


	public StudentSchema(int roll, int mark) {
		super();
		this.roll = roll;
		this.mark = mark;
	}


	public int getRoll() {
		return roll;
	}


	public void setRoll(int roll) {
		this.roll = roll;
	}


	public int getMark() {
		return mark;
	}


	public void setMark(int mark) {
		this.mark = mark;
	}


	@Override
	public String toString() {
		return "StudentSchema [roll=" + roll + ", mark=" + mark + "]";
	}


	@Override
	public int compareTo(StudentSchema o) {
		
		if (this.mark == o.mark) {
			return 0;
			
		}
		else if(this.mark>o.mark) {
			return -1;
		}
		return 1;
	}
	
	
	

}
