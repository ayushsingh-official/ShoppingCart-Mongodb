package com.project.shoppingApplication.service;

import java.util.List;

import com.project.shoppingApplication.dto.ItemRequest;
import com.project.shoppingApplication.model.Item;

public interface ItemService {
	
	List<Item> findAll();

//	Item findByName(String name);
//
//	Item findItemById(String id);

	Item saveOrUpdate(ItemRequest itemRequest);

	void delete(String id);
}