package com.kafka.assignment.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.kafka.assignment.dao.AssignmentSubmission;
import com.kafka.assignment.dao.Student;
import com.kafka.assignment.dao.Teacher;

@Configuration
public class KafkaConfig {

	//producer config for student
	@Bean
	public ProducerFactory<String,Student> producerFactory() {		
		Map<String, Object> configMap = new HashMap<>();
		configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);		
		return new DefaultKafkaProducerFactory<>(configMap);		
	}
	
	@Bean(name = "student")
	public KafkaTemplate<String, Student> kafkaTemplate(){
		return new KafkaTemplate<String, Student>(producerFactory());
	}
	
	//producer config for Teacher
	@Bean
	public ProducerFactory<String,Teacher> producerFactoryTeacher() {		
		Map<String, Object> configMap = new HashMap<>();
		configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);		
		return new DefaultKafkaProducerFactory<>(configMap);		
	}
	
	@Bean(name = "teacher")
	public KafkaTemplate<String, Teacher> kafkaTemplate2(){
		return new KafkaTemplate<String, Teacher>(producerFactoryTeacher());
	}
	
	
	//producer config for Rank
	@Bean
	public ProducerFactory<String,AssignmentSubmission> producerFactoryRank() {		
		Map<String, Object> configMap = new HashMap<>();
		configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);		
		return new DefaultKafkaProducerFactory<>(configMap);		
	}
	
	@Bean(name = "rank")
	public KafkaTemplate<String, AssignmentSubmission> kafkaTemplate3(){
		return new KafkaTemplate<String, AssignmentSubmission>(producerFactoryRank());
	}
}
