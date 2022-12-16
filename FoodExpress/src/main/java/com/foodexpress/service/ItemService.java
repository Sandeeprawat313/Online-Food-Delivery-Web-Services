package com.foodexpress.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.foodexpress.exception.ItemException;
import com.foodexpress.exception.RestaurantException;
//import com.foodexpress.exception.RestaurantException;
import com.foodexpress.model.Items;

@Service
public interface ItemService
{
	public Items createItem(String restaurantName, Items item) throws ItemException;

	public Items updateItem(String restaurantName, Items item) throws ItemException;

	public Items viewItem(String restaurantName, Integer itemid) throws ItemException;

	public Items removeItem(Integer restaurantId, String uniqueId, Items item)
			throws ItemException, RestaurantException;

	// public List<Items> viewAllItems(Category category ) throws
	// RestaurantException;

	// 4
	public List<Items> viewAllItemsOfRestaurent(Integer restaurentId,String uniqueId) throws ItemException;

	public List<Items> viewAllItemsByName(String name) throws ItemException;

	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 1. add item to restaurant
	public Items addItemToRestaurant(String restaurantName, Items item) throws ItemException;

}
