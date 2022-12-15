package com.foodexpress.authorization.service;

import com.foodexpress.authorization.exception.RestaurantLoginException;
import com.foodexpress.authorization.model.RestaurantLoginDTO;

public interface RestaurantLoginService {
	public String restaurantLogin(RestaurantLoginDTO dto) throws RestaurantLoginException;

    public String restaurantLogout(String uniqueId) throws RestaurantLoginException;
}
