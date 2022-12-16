package com.foodexpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodexpress.model.OrderDetails;

public interface OrderDao extends JpaRepository<OrderDetails, Integer> {

}
