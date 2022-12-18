package com.foodexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodexpress.exception.CartNotFoundException;
import com.foodexpress.exception.ItemException;
import com.foodexpress.model.FoodCart;
import com.foodexpress.repository.CustomerSessionDao;
import com.foodexpress.service.CartService;

@RestController
public class FoodCartController {

	@Autowired
	public CartService cartServices;

	@Autowired
	public CustomerSessionDao csDao;
	
	
	
	
	// 5 customer ===>
		@PostMapping("/addItemToFoodCart/{itemId}/{uniqueId}")
		public ResponseEntity<FoodCart> addItemToCart(@PathVariable("itemId") Integer itemId,
				@PathVariable("uniqueId") String uniqueId) {
			FoodCart updatedCart = cartServices.addItemToCart(itemId, uniqueId);
			return new ResponseEntity<FoodCart>(updatedCart, HttpStatus.ACCEPTED);
		}


	@GetMapping("/viewcart/{id}")
	public ResponseEntity<FoodCart> viewcart(@PathVariable("id") Integer id) throws CartNotFoundException {
		FoodCart cart = cartServices.viewCart(id);
		return new ResponseEntity<FoodCart>(cart, HttpStatus.OK);

	}



	

	@PutMapping("/increaseQuantity/{uniqueid}/{itemId}/{quantity}")
	public ResponseEntity<FoodCart> increaseQuantity(@PathVariable("uniqueid") String uniqueid,
			@PathVariable("itemId") Integer itemId, @PathVariable("quantity") Integer quantity)
			throws CartNotFoundException, ItemException {

		FoodCart updatedQuantity = cartServices.increaseQuantity(uniqueid, quantity, itemId);

		return new ResponseEntity<FoodCart>(updatedQuantity, HttpStatus.ACCEPTED);
	}

	@PutMapping("/reduceQuantity/{uniqueid}/{itemId}/{quantity}")
	public ResponseEntity<FoodCart> reduceQuantity(@PathVariable("uniqueid") String uniqueid,
			@PathVariable("itemId") Integer itemId, @PathVariable("quantity") Integer quantity)
			throws CartNotFoundException, ItemException {

		FoodCart updatedQuantity = cartServices.increaseQuantity(uniqueid, quantity, itemId);

		return new ResponseEntity<FoodCart>(updatedQuantity, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/ClearCart/{id}")
	public ResponseEntity<FoodCart> ClearRegistration(@PathVariable("id") Integer cart_id) throws CartNotFoundException {
//		
		FoodCart carts = cartServices.clearCart(cart_id);
		return new ResponseEntity<FoodCart>(carts, HttpStatus.OK);
//
	}

}
