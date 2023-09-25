package com.project.shoppingApplication.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.shoppingApplication.dto.CartRequest;
import com.project.shoppingApplication.model.Cart;
import com.project.shoppingApplication.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	

	@Override
	public Cart saveOrUpdate(CartRequest cartRequest) {
		
		ModelMapper modelMapper = new ModelMapper();
		Cart cart = modelMapper.map(cartRequest, Cart.class);
		
		return cartRepository.save(cart);
	}

//	@Override
//	public Cart findCartByCustomerId(CartRequest cartRequest) {	
//		
//		return cartRepository.findCartByCustomerId(cartRequest.getCustomerId());
//	}

	@Override
	public List<Cart> findAllCarts() {
		return cartRepository.findAll();
	}

	
}
