package com.foodexpress.service;

import org.springframework.stereotype.Service;

import com.foodexpress.model.Restaurants;

@Service
public interface RestaurantService {
	public Restaurants listRestaurant(Restaurants r);
	

}
