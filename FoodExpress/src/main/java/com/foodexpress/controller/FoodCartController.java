package com.foodexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodexpress.exception.CartNotFoundException;
import com.foodexpress.exception.ItemException;
import com.foodexpress.model.Customer;
import com.foodexpress.model.FoodCart;
import com.foodexpress.service.CartService;

@RestController
public class FoodCartController {
	
	@Autowired
	public CartService cartServices;
	
	
//	@PostMapping("/FoodCart")
//	public ResponseEntity<FoodCart> FoodCartRegistration(@RequestBody FoodCart cart) throws CartNotFoundException
//	{
//		FoodCart carts= cartServices.saveCart(cart);
//		return new ResponseEntity<FoodCart>(carts, HttpStatus.CREATED);
//
//	}

	@PutMapping("/add/{cartId}/{itemId}")
	public ResponseEntity<FoodCart> addItemToCart(@PathVariable("cartId") Integer cartId, @PathVariable("itemId") Integer itemId) throws CartNotFoundException, ItemException{
		FoodCart updatedCart = cartServices.addItemToCart(cartId, itemId);
		return new ResponseEntity<FoodCart>(updatedCart, HttpStatus.ACCEPTED);
	}
	

}
