package com.project.shoppingApplication.service;

import java.util.List;

import com.project.shoppingApplication.dto.CartRequest;
import com.project.shoppingApplication.model.Cart;

public interface CartService {

	Cart saveOrUpdate(CartRequest cartRequest);

	Cart findCartByCustomerId(String id);

	List<Cart> findAllCarts();
}