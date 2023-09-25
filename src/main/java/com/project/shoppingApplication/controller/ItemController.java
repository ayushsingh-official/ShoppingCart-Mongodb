package com.project.shoppingApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.shoppingApplication.dto.ItemRequest;
import com.project.shoppingApplication.model.Item;
import com.project.shoppingApplication.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/items")
	private ResponseEntity<?> items() {
		try {
			List<Item> items = itemService.findAll();
			return new ResponseEntity<>(items, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	@GetMapping("/itembyname/{name}")
//	private ResponseEntity<?> getItemByName(@PathVariable(value = "name") String name) {
//		try {
//			Item item = itemService.findByName(name);
//			return new ResponseEntity<>(item, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	@GetMapping("/itembyid/{id}")
//	private ResponseEntity<?> getItemById(@PathVariable(value = "id") String id) {
//		try {
//			Item item = itemService.findItemById(id);
//			return new ResponseEntity<>(item, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	@PostMapping(value = "/create")
	private ResponseEntity<?> create(@RequestBody ItemRequest itemRequest) {
		try {
			Item item = itemService.saveOrUpdate(itemRequest);
			return new ResponseEntity<>(item, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/update")
	private ResponseEntity<?> update(@RequestBody ItemRequest itemRequest) {
		try {
			Item item = itemService.saveOrUpdate(itemRequest);
			return new ResponseEntity<>(item, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value = "/deleteItem/{id}")
	private ResponseEntity<?> delete(@PathVariable(value = "id") String id) {
		try {
			itemService.delete(id);
			return new ResponseEntity<>("Success to remove Item!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
