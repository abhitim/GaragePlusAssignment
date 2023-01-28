package com.garagePlus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garagePlus.Repo.CustomerRepo;
import com.garagePlus.Repo.OrderRepo;
import com.garagePlus.exception.CustomerException;
import com.garagePlus.exception.OrderException;
import com.garagePlus.model.Customer;
import com.garagePlus.model.Orders;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo cRepo;

	@Autowired
	OrderRepo oRepo;

	@Override
	public Customer createCustomer(Customer c) throws CustomerException {
//		System.out.println(c);


		Customer cust = new Customer();
		cust.setEmail(c.getEmail());
		cust.setName(c.getName());
		cust.setType(c.getType());
		
		
		c.getOrderList();
		

		cust.setOrderList(c.getOrderList());

		return cRepo.save(cust);
	}

	@Override
	public Orders makeOrder(Orders o, String email) throws OrderException, CustomerException {

		if (email == null) {
			throw new CustomerException("No customer found with this email");
		}
		if (o == null) {
			throw new OrderException("order details cant be null");
		}

		Customer cust = cRepo.findByEmail(email);

		cust.getOrderList().add(o);

		System.out.println(cust.getOrderList().size() + "***********************************");
		if (cust.getOrderList().size() >= 10 && cust.getOrderList().size() <= 20) {
			cust.setType("Gold");
		} else if (cust.getOrderList().size() > 20) {
			cust.setType("platinum");
		}

		
		if(cust.getType().equals("Gold")) {
			o.setDiscountPercentage(10);
		}else if (cust.getType().equals("platinum")) {
			o.setDiscountPercentage(20);
		}
		o.setCustomer(cust);

		cRepo.save(cust);
		return o;

	}

}
