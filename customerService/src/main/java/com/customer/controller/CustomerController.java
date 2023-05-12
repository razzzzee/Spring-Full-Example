package com.customer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.repository.CustomerRepository;
import com.customer.exception.ResourceNotFoundException;
import com.customer.model.*;
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	@GetMapping("/getall")
	public List<Customer> getAllCustomers() {
	    return customerRepository.findAll();
	}

	@PostMapping("/add")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
	    return customerRepository.save(customer);
	}
	@GetMapping("/getbyid/{id}")
	public Customer getCustomerById(@PathVariable(value = "id") Integer customerId) {
	    return customerRepository.findById(customerId)
	            .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
	}
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") Integer customerId) {
	    Customer customer = customerRepository.findById(customerId)
	            .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));

	    customerRepository.delete(customer);

	    return ResponseEntity.ok().build();
	}
}
