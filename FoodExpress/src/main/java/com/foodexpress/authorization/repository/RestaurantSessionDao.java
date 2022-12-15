package com.foodexpress.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodexpress.authorization.model.RestaurantSession;

public interface RestaurantSessionDao extends JpaRepository<RestaurantSession, Integer>{
	public RestaurantSession findByUinqueId(String uniqueId);
}
