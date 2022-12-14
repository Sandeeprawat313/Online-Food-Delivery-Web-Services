package com.foodexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodexpress.exception.RestaurantException;
import com.foodexpress.model.Items;
import com.foodexpress.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService iService;

	@PostMapping("/items/{cname}")
	public ResponseEntity<Items> addItemInList(@PathVariable("cname") String restaurantName, @RequestBody Items item)
			throws RestaurantException {
		Items NewItem = iService.addItemToRestaurant(restaurantName, item);

		return new ResponseEntity<>(NewItem, HttpStatus.CREATED);

	}
}
