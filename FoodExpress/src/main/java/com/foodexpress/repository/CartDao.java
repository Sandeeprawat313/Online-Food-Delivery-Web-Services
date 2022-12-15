package com.foodexpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodexpress.model.FoodCart;

public interface CartDao extends JpaRepository<FoodCart, Integer>{

	
	
}
