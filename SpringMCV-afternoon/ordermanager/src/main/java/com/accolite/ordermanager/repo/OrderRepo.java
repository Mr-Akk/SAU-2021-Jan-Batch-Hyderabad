package com.accolite.ordermanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accolite.ordermanager.entity.OrderFinal;

public interface OrderRepo extends JpaRepository<OrderFinal, Integer>{

}
