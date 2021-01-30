package com.kafka.assignment.dao;

public class Student {
	
	static int idCount = 0;
	
		private int id;
		private String name;
		private String className;
		
		
		public Student() {
			super();
		}


		public Student(String name, String className) {
			super();
			this.id = idCount++;
			this.name = name;
			this.className = className;
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


		public String getClassName() {
			return className;
		}


		public void setClassName(String className) {
			this.className = className;
		}


		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", className=" + className + "]";
		}
		
		
		
}
