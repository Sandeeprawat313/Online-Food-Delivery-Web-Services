package com.foodexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodexpress.model.Restaurants;
import com.foodexpress.service.RestaurantService;

@RestController
public class RestaurentController {
	@Autowired
	private RestaurantService rService;

	@PostMapping("/restaurants")
	public ResponseEntity<Restaurants> listRestaurants(@RequestBody Restaurants restaurant) {
		Restaurants newRestaurant = rService.listRestaurant(restaurant);

		return new ResponseEntity<Restaurants>(newRestaurant, HttpStatus.CREATED);

	}

	@GetMapping("restaurants")
	public String listRestaurants1() {

		return "Hello";

	}

}
