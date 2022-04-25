package com.OrderCart.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.OrderCart.entity.OrderEntity;

public interface OrderRepo extends MongoRepository<OrderEntity, Integer> {

}
