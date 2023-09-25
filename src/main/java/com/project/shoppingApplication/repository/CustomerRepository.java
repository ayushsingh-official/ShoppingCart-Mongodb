package com.project.shoppingApplication.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.shoppingApplication.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
	
	List<Customer> findAll();

//	Customer findCustomerByName(String name);
//
//	Customer findCustomerByEmail(String email);
}

