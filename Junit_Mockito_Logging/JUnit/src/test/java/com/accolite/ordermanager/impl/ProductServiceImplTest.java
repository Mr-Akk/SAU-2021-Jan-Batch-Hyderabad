package com.accolite.ordermanager.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.accolite.ordermanager.entity.Product;
import com.accolite.ordermanager.repo.ProductRepo;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

	
	@Mock
	ProductRepo pRepo;
	
	@InjectMocks
	ProductServiceImpl psimpl;
	
	@Test
	public void addNewProduct() {
		Product product = new Product("cookie" , 10);
		Mockito.when(pRepo.save(Mockito.any())).thenReturn(product);
		Product addNewProduct = psimpl.addNewProduct(product);
		Assertions.assertEquals(product, addNewProduct);
	}
	
	@Test
	public void getProdById() {
		Product product = new Product();
		product.setId(1);
		product.setName("cookie");
		product.setPrice(10);
		Optional<Product> of = Optional.of(product);
		Mockito.when(pRepo.findById(Mockito.anyInt())).thenReturn(of);
		Product productById = psimpl.getProductById(1);
		Assertions.assertEquals(product, productById);
	}

}
