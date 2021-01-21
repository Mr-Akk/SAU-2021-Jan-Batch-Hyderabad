package com.java.schema;

public class WithRankSchema {

	public int rank;
	public int roll;
	public int marks;
	
	
	public WithRankSchema() {
		super();
	}


	public WithRankSchema(int rank, int roll, int marks) {
		super();
		this.rank = rank;
		this.roll = roll;
		this.marks = marks;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


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


	@Override
	public String toString() {
		return "WithRankSchema [rank=" + rank + ", roll=" + roll + ", marks=" + marks + "]";
	}
	
	
	
	
}
