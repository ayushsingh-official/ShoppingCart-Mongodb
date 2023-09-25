package com.project.shoppingApplication.service;

import java.util.List;

import com.project.shoppingApplication.dto.CustomerRequest;
import com.project.shoppingApplication.model.Customer;

public interface CustomerService {

	List<Customer> findAll();

	Customer saveOrUpdate(CustomerRequest customerRequest);

//	Customer findCustomerByName(String name);
//
//	Customer findCustomerByEmail(String email);

	void deleteById(String id);
}