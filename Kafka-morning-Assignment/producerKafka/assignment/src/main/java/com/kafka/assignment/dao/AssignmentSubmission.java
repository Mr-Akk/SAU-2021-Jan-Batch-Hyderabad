package com.kafka.assignment.dao;

import java.sql.Timestamp;

public class AssignmentSubmission {
	
	private static int rankCount = 1;
	
		private int rank;
		private int studentId;
		private String name;
		private Timestamp timestamp;
		
		
		public AssignmentSubmission() {
			super();
		}


		public AssignmentSubmission( int studentId,String name, Timestamp timestamp) {
			super();
			this.rank = rankCount++;
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
