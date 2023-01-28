package com.garagePlus;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.garagePlus.Repo.CustomerRepo;
import com.garagePlus.Repo.OrderRepo;
import com.garagePlus.exception.CustomerException;
import com.garagePlus.model.Customer;
import com.garagePlus.service.CustomerService;


@RunWith(SpringRunner.class)
@SpringBootTest
class GaragePlusApplicationTests {
     @Autowired
	CustomerService service;
     
     @MockBean
     CustomerRepo cusRepo;
     
     @MockBean
     OrderRepo orderRepo;
	
//     @Test
// 	public void saveUserTest() throws CustomerException {
// 		Customer cus= new Customer(99, "Pranya", "customer", "cus@gmail.com", null);
// 		when(cusRepo.save(cus)).thenReturn(cus);
// 		assertEquals(cus, service.createCustomer(cus));
// 	}

}
