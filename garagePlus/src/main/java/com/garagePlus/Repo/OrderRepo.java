package com.garagePlus.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garagePlus.model.Orders;
@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer>{

}
