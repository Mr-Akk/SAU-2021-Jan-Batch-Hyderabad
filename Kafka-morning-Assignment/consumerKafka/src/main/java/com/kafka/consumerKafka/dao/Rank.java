package com.kafka.consumerKafka.dao;

import java.sql.Timestamp;

public class Rank {
	
	private int rank;
	private int studentId;
	private String name;
	private Timestamp timestamp;
	
	public Rank() {
		super();
	}


	public Rank(int rank , int studentId,String name, Timestamp timestamp) {
		super();
		this.rank = rank;
		this.studentId = studentId;
		this.name = name;
		this.timestamp = timestamp;
	}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Timestamp getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}


	@Override
	public String toString() {
		return "AssignmentSubmission [rank=" + rank + ", studentId=" + studentId + ", name=" + name + ", timestamp="
				+ timestamp + "]";
	}
}
