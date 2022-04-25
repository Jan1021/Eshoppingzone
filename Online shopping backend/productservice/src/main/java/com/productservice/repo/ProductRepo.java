package com.productservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.productservice.entity.Product;


public interface ProductRepo extends MongoRepository<Product, Integer>{
	
	

}
