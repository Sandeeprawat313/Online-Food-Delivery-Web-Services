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

//	@PostMapping("/FoodCartRegister")
//	public ResponseEntity<FoodCart> FoodCartRegistration(  @RequestParam String key,@RequestBody FoodCart cart) throws CartNotFoundException
//	{
//		
//		CustomerSession cs=csDao.findByUniqueId(key);
//		if(cs.getUniqueId()!=null && cart!=null) {
//		
//		FoodCart carts= cartServices.saveCart(cart);
//		return new ResponseEntity<FoodCart>(carts, HttpStatus.CREATED);
//
//	}
//		else
//		{
//			throw new CartNotFoundException();
//		}
//	}

	@GetMapping("/viewcart/{id}")
	public ResponseEntity<FoodCart> viewcart(@PathVariable("id") Integer id) throws CartNotFoundException {
		FoodCart cart = cartServices.viewCart(id);
		return new ResponseEntity<FoodCart>(cart, HttpStatus.OK);

	}

	@PostMapping("/registerCart/{key}")
	public ResponseEntity<FoodCart> saveCartDetails(@PathVariable("key") String key) throws CartNotFoundException {

		FoodCart f = cartServices.saveCart(key);
		return new ResponseEntity<FoodCart>(f, HttpStatus.CREATED);

	}

	// original
//	@PutMapping("/addItemToFoodCart/{cartId}/{itemId}")
//	public ResponseEntity<FoodCart> addItemToCart(@PathVariable("cartId") Integer cartId, @PathVariable("itemId") Integer itemId) throws CartNotFoundException, ItemException{
//		FoodCart updatedCart = cartServices.addItemToCart(cartId, itemId);
//		return new ResponseEntity<FoodCart>(updatedCart, HttpStatus.ACCEPTED);
//	}

	// 5 customer ===>
	@PostMapping("/addItemToFoodCart/{itemId}/{uniqueId}")
	public ResponseEntity<FoodCart> addItemToCart(@PathVariable("itemId") Integer itemId,
			@PathVariable("uniqueId") String uniqueId) {
		FoodCart updatedCart = cartServices.addItemToCart(itemId, uniqueId);
		return new ResponseEntity<FoodCart>(updatedCart, HttpStatus.ACCEPTED);
	}

	@PutMapping("/increaseQuantity/{cartId}/{itemId}/{quantity}")
	public ResponseEntity<FoodCart> increaseQuantity(@PathVariable("cartId") Integer cartId,
			@PathVariable("itemId") Integer itemId, @PathVariable("quantity") Integer quantity)
			throws CartNotFoundException, ItemException {

		FoodCart updatedQuantity = cartServices.increaseQuantity(cartId, quantity, itemId);

		return new ResponseEntity<FoodCart>(updatedQuantity, HttpStatus.ACCEPTED);
	}

	@PutMapping("/reduceQuantity/{cartId}/{itemId}/{quantity}")
	public ResponseEntity<FoodCart> reduceQuantity(@PathVariable("cartId") Integer cartId,
			@PathVariable("itemId") Integer itemId, @PathVariable("quantity") Integer quantity)
			throws CartNotFoundException, ItemException {

		FoodCart updatedQuantity = cartServices.increaseQuantity(cartId, quantity, itemId);

		return new ResponseEntity<FoodCart>(updatedQuantity, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/ClearCart/{id}")
	public ResponseEntity<FoodCart> CartRegistration(@PathVariable("id") Integer cart_id) throws CartNotFoundException {
//		
		FoodCart carts = cartServices.clearCart(cart_id);
		return new ResponseEntity<FoodCart>(carts, HttpStatus.OK);
//
	}

}
