package com.RestAPIAfternoon.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RestAPIAfternoon.rest.entity.PrivateMessage;

public interface PrivateMessageRepository extends JpaRepository<PrivateMessage, Integer>{

   

}
