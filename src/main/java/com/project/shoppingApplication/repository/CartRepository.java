package com.project.shoppingApplication.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.shoppingApplication.model.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {

	
//	Cart findCartByCustomerId(String customerId);

}