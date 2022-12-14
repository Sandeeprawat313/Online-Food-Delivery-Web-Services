package com.foodexpress.service;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import com.foodexpress.exception.CartNotFoundException;
import com.foodexpress.model.FoodCart;
import com.foodexpress.model.Items;

public interface CartService {
	
	public FoodCart addItemToCart(FoodCart cart,Items item) throws CartNotFoundException;

}
