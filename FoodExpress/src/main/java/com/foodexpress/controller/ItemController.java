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

import com.foodexpress.exception.ItemException;
import com.foodexpress.exception.RestaurantException;
import com.foodexpress.model.Items;
import com.foodexpress.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController
{

	@Autowired
	private ItemService iService;

	@PostMapping("/add/{rstname}")
	public ResponseEntity<Items> addItemsHandler(@PathVariable("rstname") String resturantname,
			@Valid @RequestBody Items item) throws ItemException
	{
		Items addeditem = iService.addItemToRestaurant(resturantname, item);

		return new ResponseEntity<Items>(addeditem, HttpStatus.ACCEPTED);
	}

	@PutMapping("/update/{rstname}")
	public ResponseEntity<Items> updateItemsHandler(@PathVariable("rstname") String resturantname,
			@Valid @RequestBody Items item) throws ItemException
	{
		Items updateditem = iService.updateItem(resturantname, item);

		return new ResponseEntity<Items>(updateditem, HttpStatus.OK);
	}

	@GetMapping("/view/{rstname}/{id}")
	public ResponseEntity<Items> viewItemHandler(@PathVariable("rstname") String resturantname,
			@PathVariable("id") Integer itemid) throws ItemException
	{
		Items updateditem = iService.viewItem(resturantname, itemid);

		return new ResponseEntity<Items>(updateditem, HttpStatus.OK);
	}

	// 4 viewAllItems ==>
	@GetMapping("/viewallitemofrestnt/{restaurentId}/{uniqueId}")
	public ResponseEntity<List<Items>> viewAllItemsOfRestaurentHandler(
			@PathVariable("restaurentId") Integer restaurentId, @PathVariable("uniqueId") String uniqueId)
	{

		List<Items> allitem = iService.viewAllItemsOfRestaurent(restaurentId, uniqueId);

		return new ResponseEntity<List<Items>>(allitem, HttpStatus.OK);
	}

	@GetMapping("/viewallitembyname/{itemname}")
	public ResponseEntity<List<Items>> viewAllItemsByNameHandler(@PathVariable("itemname") String itemname)
			throws ItemException
	{
		List<Items> allitem = iService.viewAllItemsByName(itemname);

		return new ResponseEntity<List<Items>>(allitem, HttpStatus.OK);
	}

//	@DeleteMapping("/delete/{restntId}")
//	public ResponseEntity<Items> removeItemHandler(@PathVariable("restntName") String restntName,
//			@RequestBody Items item) throws ItemException
//	{
//		Items allitem = iService.removeItem(restntName, item);
//
//		return new ResponseEntity<Items>(allitem, HttpStatus.OK);
//	}

	@DeleteMapping("/delete/{restntId}/{uniqueId}")
	public ResponseEntity<Items> removeItemHandler(@PathVariable("restntId") Integer restaurantId,
			@PathVariable("uniqueId") String uniqueId, @Valid @RequestBody Items item)
			throws ItemException, RestaurantException
	{
		Items allitem = iService.removeItem(restaurantId, uniqueId, item);

		return new ResponseEntity<Items>(allitem, HttpStatus.OK);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////
	@PostMapping("/items/{cname}")
	public ResponseEntity<Items> addItemInList(@PathVariable("cname") String restaurantName,
			@Valid @RequestBody Items item) throws RestaurantException, ItemException
	{
		Items NewItem = iService.addItemToRestaurant(restaurantName, item);

		return new ResponseEntity<>(NewItem, HttpStatus.CREATED);

	}
}
