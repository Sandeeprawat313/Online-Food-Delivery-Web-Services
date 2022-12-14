package com.foodexpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foodexpress.model.Restaurants;

public interface RestaurantDao extends JpaRepository<Restaurants, Integer> {

	//public Restaurants findByrestaurantName(String restaurantName);
	
	@Query("select r from Restaurants r where r.restaurantName=?1")
	public Restaurants getResByName(String restaurantName);
}
