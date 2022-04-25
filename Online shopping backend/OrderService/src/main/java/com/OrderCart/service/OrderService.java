package com.OrderCart.service;

import java.util.List;
import com.OrderCart.entity.OrderEntity;

public interface OrderService {
	public OrderEntity addOrder(OrderEntity orderEntity);
	public List<OrderEntity> getAllOrders();
//	public Cart placeOrder(Cart cart);
	public void deleteOrder(int orderId);
	public OrderEntity getOrderByCustomerId(int customerId);
//	public void storeAddress(Address address);
	public OrderEntity getAddressByCustomerId(int customerId);
//	public Address getAllAddress();
	public OrderEntity getOrderById(int orderId);
	
}
