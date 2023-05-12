package com.order.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.exception.ResourceNotFoundException;
import com.order.model.SalesOrder;
import com.order.repository.SalesOrderRepository;
@RestController
@RequestMapping("/order")
public class SalesOrderController {
	@Autowired
	private SalesOrderRepository orderRepository;
	@GetMapping("/getall")
	public List<SalesOrder> getAllSalesOrders() {
	    return orderRepository.findAll();
	}

	@PostMapping("/add")
	public SalesOrder createSalesOrder(@Valid @RequestBody SalesOrder order) {
	    return orderRepository.save(order);
	}
	@GetMapping("/getbyid/{id}")
	public SalesOrder getSalesOrderById(@PathVariable(value = "id") Long orderId) {
	    return orderRepository.findById(orderId)
	            .orElseThrow(() -> new ResourceNotFoundException("SalesOrder", "id", orderId));
	}
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<?> deleteSalesOrder(@PathVariable(value = "id")  Long orderId) {
	    SalesOrder order = orderRepository.findById(orderId)
	            .orElseThrow(() -> new ResourceNotFoundException("SalesOrder", "id", orderId));

	    orderRepository.delete(order);

	    return ResponseEntity.ok().build();
	}

}
