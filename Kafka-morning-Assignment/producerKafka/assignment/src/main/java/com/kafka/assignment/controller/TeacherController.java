package com.kafka.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.assignment.dao.Teacher;
import com.kafka.assignment.producer.ProducerKafka;
import com.kafka.assignment.producer.ProducerTeacher;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	ProducerTeacher pTeacher;
	
	@PostMapping("/create")
	public void createTeacher(@RequestBody Teacher teacher) {
		pTeacher.publishMessage(teacher);
	}

}
