package com.foodexpress.service;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import com.foodexpress.authorization.exception.CustomerLoginException;
import com.foodexpress.exception.CartNotFoundException;
import com.foodexpress.exception.ItemException;
import com.foodexpress.model.FoodCart;
import com.foodexpress.model.Items;

public interface CartService {
	// public FoodCart saveCart(FoodCart cart)throws CartNotFoundException;

	// 5 customer ==> add item
	// public FoodCart addItemToCart( Integer cartId,Integer itemId) throws
	// CartNotFoundException ,ItemException,CustomerLoginException;

	// 5 customer ==> add item
	public FoodCart addItemToCart(Integer itemId, String uniueId)
			throws CartNotFoundException, ItemException, CustomerLoginException;

	public FoodCart increaseQuantity(String unique_id, Integer quantity, Integer item_Id)
			throws CartNotFoundException, ItemException;

	public FoodCart reduceQuantity(String unique_id, Integer quantity, Integer item_Id)
			throws CartNotFoundException, ItemException;

	public FoodCart removeItem(Integer cartId, Integer itemId) throws CartNotFoundException, ItemException;

	public FoodCart clearCart(Integer cartId) throws CartNotFoundException;

	public FoodCart viewCart(Integer cartid) throws CartNotFoundException;

	

}
