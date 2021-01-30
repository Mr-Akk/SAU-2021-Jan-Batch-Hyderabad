package com.kafka.assignment.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.assignment.dao.AssignmentSubmission;
import com.kafka.assignment.producer.ProducerRank;

@RestController
@RequestMapping("/rank")
public class RankController {
	
	@Autowired
	ProducerRank pRank;

	@PostMapping("/submit")
	public void submitAssignment(@RequestBody AssignmentSubmission as1) {
		
			pRank.publishMessage(as1);
	}
}
