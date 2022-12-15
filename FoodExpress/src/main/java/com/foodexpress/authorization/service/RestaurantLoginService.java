package com.foodexpress.authorization.service;

import org.springframework.stereotype.Service;

import com.foodexpress.authorization.exception.RestaurantLoginException;
import com.foodexpress.authorization.model.RestaurantLoginDTO;

@Service
public interface RestaurantLoginService {
	public String restaurantLogin(RestaurantLoginDTO dto) throws RestaurantLoginException;

    public String restaurantLogout(String uniqueId) throws RestaurantLoginException;
}
