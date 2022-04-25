package com.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cart.model.CartEntity;
import com.cart.service.CartService;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "*")
public class CartController  {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/add")
	@CrossOrigin(origins = "*")
	public CartEntity addCartById(@RequestBody CartEntity cartEntity) {
		return this.cartService.addCart(cartEntity);
	}
	
	@GetMapping("/get")
	@CrossOrigin(origins = "*")
	public ResponseEntity<?> getAllCart(){
		return ResponseEntity.ok(this.cartService.getAllCart());
	}
	
	@GetMapping("/get/user/{userid}")
	public CartEntity getCartByUserId(@PathVariable("userid") int userId) {
		return this.cartService.getCartByUserId(userId);
	}
	
	@GetMapping("/get/{id}")
	public CartEntity getCartById(@PathVariable("id") int id) {
		return this.cartService.getCartByProductId(id);
	}
	
	@DeleteMapping("/del/{id}")
	public int deleteById(@PathVariable("id") int id) {
	this.cartService.deleteById(id);
	return id;
}
}