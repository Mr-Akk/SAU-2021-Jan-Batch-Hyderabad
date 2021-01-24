package com.accolite.ordermanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accolite.ordermanager.entity.UserCart;

public interface CartRepo extends JpaRepository<UserCart, Integer>{

}
