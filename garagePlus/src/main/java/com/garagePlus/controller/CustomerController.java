package com.garagePlus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.garagePlus.exception.CustomerException;
import com.garagePlus.exception.OrderException;
import com.garagePlus.model.Customer;
import com.garagePlus.model.Orders;
import com.garagePlus.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService cService;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> createCusHandler(@RequestBody Customer c) throws CustomerException{
		return new ResponseEntity<Customer>(cService.createCustomer(c),HttpStatus.OK);
	}
	@PostMapping("/order/{email}")
	public ResponseEntity<Orders> makeOrderHandler(@RequestBody Orders o,@PathVariable String email) throws OrderException, CustomerException{
		return new ResponseEntity<Orders>(cService.makeOrder(o, email),HttpStatus.OK);
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hellooooo";
	}

}
