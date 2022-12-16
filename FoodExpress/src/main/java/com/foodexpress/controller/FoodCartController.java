package com.foodexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodexpress.authorization.model.CustomerSession;
import com.foodexpress.authorization.repository.CustomerSessionDao;
import com.foodexpress.exception.CartNotFoundException;
import com.foodexpress.exception.ItemException;
import com.foodexpress.model.Customer;
import com.foodexpress.model.FoodCart;
import com.foodexpress.service.CartService;

@RestController
public class FoodCartController {
	
	@Autowired
	public CartService cartServices;
	
	@Autowired
	public CustomerSessionDao csDao;

	
	
	@PostMapping("/FoodCartRegister")
	public ResponseEntity<FoodCart> FoodCartRegistration(  @RequestParam String key,@RequestBody FoodCart cart) throws CartNotFoundException
	{
		
		CustomerSession cs=csDao.findByUniqueId(key);
		if(cs.getUniqueId()!=null && cart!=null) {
		
		FoodCart carts= cartServices.saveCart(cart);
		return new ResponseEntity<FoodCart>(carts, HttpStatus.CREATED);

	}
		else
		{
			throw new CartNotFoundException();
		}
	}

	@PutMapping("/addItemToFoodCart/{cartId}/{itemId}")
	public ResponseEntity<FoodCart> addItemToCart(@PathVariable("cartId") Integer cartId, @PathVariable("itemId") Integer itemId) throws CartNotFoundException, ItemException{
		FoodCart updatedCart = cartServices.addItemToCart(cartId, itemId);
		return new ResponseEntity<FoodCart>(updatedCart, HttpStatus.ACCEPTED);
	}
	@PutMapping("/increaseQuantity/{cartId}/{itemId}/{quantity}")
	public ResponseEntity<FoodCart>increaseQuantity(@PathVariable("cartId")Integer cartId,@PathVariable("itemId")Integer itemId,@PathVariable("quantity")Integer quantity) throws CartNotFoundException, ItemException{
		
		
		FoodCart updatedQuantity=cartServices.increaseQuantity(cartId, quantity, itemId);
		
		return new ResponseEntity<FoodCart>(updatedQuantity,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/reduceQuantity/{cartId}/{itemId}/{quantity}")
	public ResponseEntity<FoodCart>reduceQuantity(@PathVariable("cartId")Integer cartId,@PathVariable("itemId")Integer itemId,@PathVariable("quantity")Integer quantity) throws CartNotFoundException, ItemException{
		
		
		FoodCart updatedQuantity=cartServices.increaseQuantity(cartId, quantity, itemId);
		
		return new ResponseEntity<FoodCart>(updatedQuantity,HttpStatus.ACCEPTED);
	}
	
	

}
