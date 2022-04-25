package com.OrderCart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OrderCart.entity.OrderEntity;
import com.OrderCart.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/addorder")
	public OrderEntity addOrder(OrderEntity orderEntity) {
		return this.orderService.addOrder(orderEntity);
	}
	
	@GetMapping("/getorders")
	 public ResponseEntity<?>  getAllOrder(){
		 return ResponseEntity.ok(this.orderService.getAllOrders());
	}
	
	@GetMapping("/{id}")
	public OrderEntity getOrderById(@PathVariable int id) {
		return this.orderService.getOrderById(id);
	}
	
	@GetMapping("/ordercustid/{id}")
	public OrderEntity getOrderByCustomerId(@PathVariable int id) {
		return this.orderService.getOrderByCustomerId(id);
	}
	
	@GetMapping("/address/{id}")
	public OrderEntity getAddressByCustomerId(@PathVariable int id) {
		return this.orderService.getAddressByCustomerId(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public int deleteOrderById(@PathVariable int id) {
		this.orderService.deleteOrder(id);
		return id;
	}
	
	
	
	
}
