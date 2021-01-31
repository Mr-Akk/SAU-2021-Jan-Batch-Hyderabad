package com.accolite.ordermanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accolite.ordermanager.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
