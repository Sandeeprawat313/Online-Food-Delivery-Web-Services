package com.foodexpress.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodexpress.exception.RestaurantException;
import com.foodexpress.model.Restaurants;
import com.foodexpress.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurentController {
	@Autowired
	private RestaurantService rService;

	// 1. ADMIN ++> create customer
	@PostMapping("/create")
	public ResponseEntity<Restaurants> createRestaurantsHandler(@Valid @RequestBody Restaurants restaurant)
			throws RestaurantException {
		Restaurants newRestaurant = rService.createRestaurant(restaurant);

		return new ResponseEntity<Restaurants>(newRestaurant, HttpStatus.CREATED);

	}

	@PutMapping("/update/{uniqueId}")
	public ResponseEntity<Restaurants> updateRestaurantsHandler(@PathVariable("uniqueId") String uniqueId,
			@Valid @RequestBody Restaurants restaurant) throws RestaurantException {
		Restaurants updatedRestaurant = rService.updateRestaurant(uniqueId, restaurant);

		return new ResponseEntity<Restaurants>(updatedRestaurant, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Restaurants> deleteRestaurantsHandler(@PathVariable("id") Integer restaurantID)
			throws RestaurantException {
		Restaurants updatedRestaurant = rService.removeRestaurant(restaurantID);

		return new ResponseEntity<Restaurants>(updatedRestaurant, HttpStatus.OK);

	}

	// 3 find restuarants>>>
	@GetMapping("/find/{uid}")
	public ResponseEntity<List<Restaurants>> viewRestaurantHandler(@PathVariable("uid") String uniqueId)
			throws RestaurantException {
		List<Restaurants> listOfRestaurants = rService.viewRestaurant(uniqueId);

		return new ResponseEntity<List<Restaurants>>(listOfRestaurants, HttpStatus.OK);

	}

	@GetMapping("/findbylocation/{location}")
	public ResponseEntity<List<Restaurants>> findRestaurantsByLocationHandler(@PathVariable("location") String location)
			throws RestaurantException {
		List<Restaurants> nearbyRestaurant = rService.viewNearByRestaurant(location);

		return new ResponseEntity<List<Restaurants>>(nearbyRestaurant, HttpStatus.OK);

	}

	@GetMapping("/findallbyitemname/{itemname}")
	public ResponseEntity<List<Restaurants>> findRestaurantByItemNameHandler(@PathVariable("itemname") String itemName)
			throws RestaurantException {
		List<Restaurants> nearbyRestaurant = rService.viewRestaurantByItemname(itemName);

		// List<Restaurants> restaurants = null;

		return new ResponseEntity<List<Restaurants>>(nearbyRestaurant, HttpStatus.OK);

	}

	//

	/////////////////////////////////////////////////////////////////////////////////////////////////
//	@PostMapping("/restaurants")
//	public ResponseEntity<Restaurants> listRestaurants(@RequestBody Restaurants restaurant) throws RestaurantException
//	{
//		Restaurants newRestaurant = rService.addRestaurant(restaurant);
//
//
//		return new ResponseEntity<Restaurants>(newRestaurant, HttpStatus.CREATED);
//
//	}

	@GetMapping("/restaurants")
	public String listRestaurants1() {

		return "Hello";

	}

}
