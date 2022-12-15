package com.foodexpress.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodexpress.authorization.model.RestaurantSession;

@Repository
public interface RestaurantSessionDao extends JpaRepository<RestaurantSession, Integer>{
	public RestaurantSession findByUniqueId(String uniqueId);
}
