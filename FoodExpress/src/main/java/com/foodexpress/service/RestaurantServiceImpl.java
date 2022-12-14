package com.foodexpress.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodexpress.model.Items;
import com.foodexpress.model.Restaurants;
import com.foodexpress.repository.RestaurantDao;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantDao rDao;

	@Override // MOST IMPORTANT
	public Restaurants listRestaurant(Restaurants restaurant) {
		List<Items> items = restaurant.getItemList();

		for (Items item : items) {
			// associating each items with restaurant
			item.getListOfRestaurants().add(restaurant);
		}
		return rDao.save(restaurant);
	}

}
