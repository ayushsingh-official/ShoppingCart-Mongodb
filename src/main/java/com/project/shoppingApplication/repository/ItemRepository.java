package com.project.shoppingApplication.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.shoppingApplication.model.Item;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
	List<Item> findAll();

//	Item findByName(String name);
//
//	Item findItemById(String id);
}