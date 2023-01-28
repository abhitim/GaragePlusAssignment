package com.garagePlus.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String name;
	private String type;
	private String email;
	
	
	
	public Customer(Integer customerId, String name, String type, String email, List<Orders> orderList) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.type = type;
		this.email = email;
		this.orderList = orderList;
	}


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


    @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	List<Orders> orderList = new ArrayList<>();


	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public List<Orders> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Orders> orderList) {
		this.orderList = orderList;
	}
	
	
	

}
