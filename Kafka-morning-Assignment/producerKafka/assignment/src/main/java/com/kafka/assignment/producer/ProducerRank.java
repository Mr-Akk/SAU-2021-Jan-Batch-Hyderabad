package com.kafka.assignment.producer;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.assignment.dao.AssignmentSubmission;

@Service
public class ProducerRank {

	@Autowired
	@Qualifier("rank")
	KafkaTemplate<String, AssignmentSubmission> kafkaTemplate ;
	
	private static final String TOPIC = "rank";
	
	public void publishMessage(AssignmentSubmission as1) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		AssignmentSubmission as2 = new AssignmentSubmission(
				as1.getStudentId() , as1.getName(),timestamp
				);	
		kafkaTemplate.send(TOPIC , as2);
	}
}
