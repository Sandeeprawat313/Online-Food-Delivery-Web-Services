package com.foodexpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodexpress.model.Items;

public interface ItemsDao extends JpaRepository<Items, Integer> {
	
	
	
}
