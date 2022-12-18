package com.foodexpress.service;

import org.springframework.stereotype.Service;

import com.foodexpress.exception.RestaurantLoginException;
import com.foodexpress.model.RestaurantLoginDTO;

@Service
public interface RestaurantLoginService {
	public String restaurantLogin(RestaurantLoginDTO dto) throws RestaurantLoginException;

    public String restaurantLogout(String uniqueId) throws RestaurantLoginException;
}
