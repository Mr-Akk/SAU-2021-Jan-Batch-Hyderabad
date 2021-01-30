package com.kafka.assignment.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.assignment.dao.Teacher;

@Service
public class ProducerTeacher {
	
	@Autowired
	@Qualifier("teacher")
	KafkaTemplate<String, Teacher> kafkaTemplate;
	
	private static final String TOPIC = "teacher";


	public void publishMessage(Teacher teacher) {
		Teacher teacher2 = new Teacher(teacher.getName() , teacher.getSubject());
		kafkaTemplate.send(TOPIC , teacher2);
		
	}

}
