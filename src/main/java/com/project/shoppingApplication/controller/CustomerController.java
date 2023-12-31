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

import com.project.shoppingApplication.dto.CustomerRequest;
import com.project.shoppingApplication.exception.GlobalExceptionCustomized;
import com.project.shoppingApplication.model.Customer;
import com.project.shoppingApplication.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private GlobalExceptionCustomized exception;

	@GetMapping("/customers")
	private ResponseEntity<?> customers() {
		try {
			List<Customer> customers = customerService.findAll();
			return new ResponseEntity<>(customers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/customerbyname/{name}")
	private ResponseEntity<?> getCustomerByName(@PathVariable(value = "name") String name) {

		Customer customer = customerService.findCustomerByName(name);
		System.out.println("customer : " + customer);

//		GlobalExceptionCustomized exception = new GlobalExceptionCustomized();   // Autowired by using @component annotation in class

		// Return type of exception has to be the same as all controller. 
		// which creates a tightly bound code , not a good practice.
		// That is a issue which is not when we throw Exception classes directly
		if (customer == null) {
			return exception.resourceNotFoundException();
		}

		return new ResponseEntity<>(customer, HttpStatus.OK);

	}

	@GetMapping("/customerbyemail/{email}")
	private ResponseEntity<?> getCustomerByEmail(@PathVariable(value = "email") String email) {
		try {
			Customer customer = customerService.findCustomerByEmail(email);
			return new ResponseEntity<>(customer, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/createCustomer")
	private ResponseEntity<?> create(@RequestBody CustomerRequest customerRequest) {
		try {
			Customer customer = customerService.saveOrUpdate(customerRequest);
			return new ResponseEntity<>(customer, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/updateCustomer")
	private ResponseEntity<?> updateCustomer(@RequestBody CustomerRequest customerRequest) {
		try {
			Customer customer = customerService.saveOrUpdate(customerRequest);
			return new ResponseEntity<>(customer, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value = "/deleteCustomer/{id}")
	private ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") String id) {
		try {
			customerService.deleteById(id);
			return new ResponseEntity<>("Success to remove Customer!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}