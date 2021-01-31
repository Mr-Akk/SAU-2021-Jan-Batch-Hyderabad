package com.accolite.ordermanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accolite.ordermanager.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
