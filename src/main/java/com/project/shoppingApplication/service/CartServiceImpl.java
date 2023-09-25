package com.project.shoppingApplication.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.project.shoppingApplication.dto.CartRequest;
import com.project.shoppingApplication.model.Cart;
import com.project.shoppingApplication.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Cart saveOrUpdate(CartRequest cartRequest) {

		ModelMapper modelMapper = new ModelMapper();
		Cart cart = modelMapper.map(cartRequest, Cart.class);

		return cartRepository.save(cart);
	}

	@Override
	public Cart findCartByCustomerId(String id) {

		Query query = new Query();
		query.addCriteria(Criteria.where("customerId").is("id"));
		Cart cart = mongoTemplate.findOne(query, Cart.class);

		return cart;
	}

	@Override
	public List<Cart> findAllCarts() {
		return cartRepository.findAll();
	}

}
