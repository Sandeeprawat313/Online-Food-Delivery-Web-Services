package com.foodexpress.service;

import org.springframework.stereotype.Service;

import com.foodexpress.exception.RestaurantException;
//import com.foodexpress.exception.RestaurantException;
import com.foodexpress.model.Items;
@Service
public interface ItemService {
	 //1. add item to restuarent
	public Items addItemToRestaurant(String restaurantName, Items item) throws RestaurantException;
}
