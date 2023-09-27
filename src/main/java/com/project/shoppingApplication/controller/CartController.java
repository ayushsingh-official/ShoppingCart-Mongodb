package com.project.shoppingApplication.controller;

//import lombok.extern.slf4j.Slf4j;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.shoppingApplication.dto.CartRequest;
import com.project.shoppingApplication.model.Cart;
import com.project.shoppingApplication.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping(value = "/createCart")
	private ResponseEntity<?> create(@RequestBody CartRequest cartRequest) {
		try {
			Cart cart = cartService.saveOrUpdate(cartRequest);
			return new ResponseEntity<>(cart, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/cartbycustomerid")
	private ResponseEntity<?> getCartByCustomerId(@PathVariable(value = "id") String id) {
		try {
			Cart cart = cartService.findCartByCustomerId(id);
			return new ResponseEntity<>(cart, HttpStatus.OK);
		} catch (Exception e) {
//			ResponseEntity.status(null)
			System.out.println(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	}

	@GetMapping(value = "/carts")
	private ResponseEntity<?> getCarts() {
		try {
			List<Cart> carts = cartService.findAllCarts();
			return new ResponseEntity<>(carts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}