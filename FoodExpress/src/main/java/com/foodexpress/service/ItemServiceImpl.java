package com.foodexpress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodexpress.exception.RestaurantException;
import com.foodexpress.model.Items;
import com.foodexpress.model.Restaurants;
import com.foodexpress.repository.ItemsDao;
import com.foodexpress.repository.RestaurantDao;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsDao iDao;

	@Autowired
	private RestaurantDao rDao;

	public Items addItemToRestaurant(String restaurantName, Items item) throws RestaurantException {
		Restaurants restaurant = rDao.getResByName(restaurantName);

		if (restaurant == null) {
			throw new RestaurantException("Restaurant not found");
		} else {
			// associate item in restaurent
			restaurant.getItemList().add(item);
			// associate Restaurant with item
			item.getListOfRestaurants().add(restaurant);
			Items NewItem = iDao.save(item);// save bhi karo new hai dono cascading hai ek save hoga to dono ho jaynge
			return NewItem;

		}
	}

}
