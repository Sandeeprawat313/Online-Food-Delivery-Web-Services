package com.foodexpress.service;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import com.foodexpress.exception.CartNotFoundException;
import com.foodexpress.exception.ItemException;
import com.foodexpress.model.FoodCart;
import com.foodexpress.model.Items;

public interface CartService {
	
	public FoodCart addItemToCart(Integer cart,Integer item) throws CartNotFoundException ,ItemException;
	
//public FoodCart saveCart(FoodCart cart)throws CartNotFoundException;
	
	
	public FoodCart clearCart(Integer cartId) throws CartNotFoundException;

}
