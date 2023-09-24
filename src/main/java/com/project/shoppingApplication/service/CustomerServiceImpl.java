package com.project.shoppingApplication.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.project.shoppingApplication.dto.CustomerRequest;
import com.project.shoppingApplication.model.Customer;
import com.project.shoppingApplication.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;

//	@Autowired
//	private ModelMapper modelMapper;

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer saveOrUpdate(CustomerRequest customerRequest) {

		ModelMapper modelMapper = new ModelMapper();
		Customer customer = modelMapper.map(customerRequest, Customer.class);

		return customerRepository.save(customer);
	}

	@Override
	public Customer findCustomerByName(String name) {
		return customerRepository.findCustomerByName(name);
	}

	@Override
	public void delete(String id) {
		customerRepository.deleteById(id);
	}

	@Override
	public Customer findCustomerByEmail(String email) {
		return customerRepository.findCustomerByEmail(email);
	}
}
