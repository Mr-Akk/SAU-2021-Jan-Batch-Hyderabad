package com.hibernate.assignment.Main;

import java.util.Date;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.assignment.entity.Address;
import com.hibernate.assignment.entity.Course;
import com.hibernate.assignment.entity.Employee;
import com.hibernate.assignment.entity.EmployeeDetails;

public class EmployeeDemo {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
		.addAnnotatedClass(Employee.class)
		.addAnnotatedClass(EmployeeDetails.class)
		.addAnnotatedClass(Address.class)
		.addAnnotatedClass(Course.class)
		.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		EmployeeDetails employeeDetails = new EmployeeDetails("9442212768" , "ak@gmail.com");
		Employee employee = new Employee("akash" , "mohan" , employeeDetails);
		Address addr1 = new Address("msd street" , "chennai" ,"600026" , employee);
		Address addr2 = new Address("shewag street" , "mumbai" ,"6023050" , employee);
		employee.getAddressList().add(addr1);
		employee.getAddressList().add(addr2);
		
		Course c1 = new Course("java");
		Course c2 = new Course("python");
		
		employee.getCourseList().add(c1);
		employee.getCourseList().add(c2);
		
		
		c1.getEmployeeList().add(employee);
		c2.getEmployeeList().add(employee);
	
		try {
			
			session.beginTransaction();
			session.save(employee);			
			Employee  e = session.get(Employee.class, 1);
			System.out.println("employee details are");
			System.out.println(e.getEmpDetails());
			System.out.println();
			System.out.println("Employee address is");
			System.out.println(e.getAddressList());
			System.out.println();
			System.out.println("Courses taken by employee");
			System.out.println(e.getCourseList());						
			session.getTransaction().commit();
			session.close();			
		} catch (Exception e) {
						System.out.println(e);		
	}
		finally {
			sessionFactory.close();
		}
	}
}
