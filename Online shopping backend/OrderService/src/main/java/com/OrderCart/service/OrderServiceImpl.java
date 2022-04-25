package com.OrderCart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.OrderCart.entity.OrderEntity;
import com.OrderCart.repo.OrderRepo;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired 
	private OrderRepo orderRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	
	@Override
	public OrderEntity addOrder(OrderEntity orderEntity) {
		return this.orderRepo.save(orderEntity);
	}

	@Override
	public List<OrderEntity> getAllOrders() {
		return this.orderRepo.findAll();
	}

//	@Override
//	public Cart placeOrder(Cart cart) {
//		return this.orderRepo.
//	}

	@Override
	public void deleteOrder(int orderId) {
		this.orderRepo.deleteById(orderId);
	}

	@Override
	public OrderEntity getOrderByCustomerId(int customerId) {
		return this.orderRepo.findById(customerId).get();
	}

//	@Override
//	public void storeAddress(Address address) {
//		this.orderRepo.save(address);
//	}

	@Override
	public OrderEntity getAddressByCustomerId(int customerId) {
		return this.orderRepo.findById(customerId).get();
	}

//	@Override
//	public Address getAllAddress() {
//		return this.orderRepo.findAll();
//	}

	@Override
	public OrderEntity getOrderById(int orderId) {
		return this.orderRepo.findById(orderId).get();
	}

}
