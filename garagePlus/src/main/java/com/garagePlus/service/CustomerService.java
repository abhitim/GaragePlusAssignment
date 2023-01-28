package com.garagePlus.service;

import com.garagePlus.exception.CustomerException;
import com.garagePlus.exception.OrderException;
import com.garagePlus.model.Customer;
import com.garagePlus.model.Orders;

public interface CustomerService {

	public Customer createCustomer(Customer c) throws CustomerException;
	public Orders makeOrder(Orders o,String email ) throws OrderException,CustomerException;
	
	
	
}
