package com.project.shoppingApplication.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.project.shoppingApplication.dto.ItemRequest;
import com.project.shoppingApplication.model.Item;
import com.project.shoppingApplication.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Item> findAll() {
		return itemRepository.findAll();
	}

	@Override
	public Item saveOrUpdate(ItemRequest itemRequest) {

		ModelMapper modelMapper = new ModelMapper();
		Item item = modelMapper.map(itemRequest, Item.class);

		return itemRepository.save(item);
	}

	@Override
	public void delete(String id) {
		itemRepository.deleteById(id);
	}

//	@Override
//	public Item findByName(String name) {
//		return itemRepository.findByName(name);
//	}
//
//	@Override
//	public Item findItemById(String id) {
//		return itemRepository.findItemById(id);
//	}
}
