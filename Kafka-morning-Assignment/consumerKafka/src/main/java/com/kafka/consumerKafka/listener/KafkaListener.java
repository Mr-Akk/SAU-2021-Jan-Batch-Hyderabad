package com.kafka.consumerKafka.listener;

import org.springframework.stereotype.Service;

import com.kafka.consumerKafka.dao.Rank;
import com.kafka.consumerKafka.dao.Student;
import com.kafka.consumerKafka.dao.Teacher;


@Service
public class KafkaListener {

	//listener for Teacher
	@org.springframework.kafka.annotation.KafkaListener(topics = "teacher",
			groupId = "teacher_group" , containerFactory = "userKafkaListenerFactory")
	public void consumerTEACHER(Teacher teacher) {
		System.out.println("Consumed message is "+ teacher );
	}
	
	//listener for student
	@org.springframework.kafka.annotation.KafkaListener(topics = "student",
			groupId = "studentt_group" , containerFactory = "userKafkaListenerFactoryStudent")
	public void consumerStudent(Student student) {
		System.out.println("Consumed message is "+ student );
	} 
	
	//listener for Rank
	@org.springframework.kafka.annotation.KafkaListener(topics = "rank",
			groupId = "rank_group" , containerFactory = "userKafkaListenerFactoryRank")
	public void consumerRank(Rank rank) {
		System.out.println("Consumed message is "+ rank );
	}
		
}
