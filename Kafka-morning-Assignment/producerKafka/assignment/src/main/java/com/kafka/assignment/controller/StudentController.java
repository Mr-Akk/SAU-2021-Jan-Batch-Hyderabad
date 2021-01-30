package com.kafka.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.assignment.dao.Student;
import com.kafka.assignment.producer.ProducerKafka;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	ProducerKafka pKafka;
	
	@PostMapping("/create")
	public void postStudentData(@RequestBody Student student) {
		pKafka.publishMessage(student);
	}

}
