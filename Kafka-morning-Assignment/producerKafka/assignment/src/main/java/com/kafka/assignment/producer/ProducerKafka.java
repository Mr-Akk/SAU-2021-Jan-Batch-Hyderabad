package com.kafka.assignment.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.assignment.dao.Student;

@Service
public class ProducerKafka {

	@Autowired
	@Qualifier("student")
	KafkaTemplate<String, Student> kafkaTemplate;
	
	private static final String TOPIC = "student";
	
	public void publishMessage(Student student) {
		Student student2 = new Student(student.getName(),student.getClassName());
		kafkaTemplate.send(TOPIC , student2);
	}
}
