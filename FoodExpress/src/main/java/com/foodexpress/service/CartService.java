package com.foodexpress.service;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import com.foodexpress.exception.CartNotFoundException;
import com.foodexpress.exception.ItemException;
import com.foodexpress.model.FoodCart;
import com.foodexpress.model.Items;

public interface CartService {
	public FoodCart saveCart(FoodCart cart)throws CartNotFoundException;
	
	public FoodCart addItemToCart(Integer cartId,Integer itemId) throws CartNotFoundException ,ItemException;
	
    public FoodCart increaseQuantity(Integer cart_id,Integer quantity,Integer item_Id)throws CartNotFoundException ,ItemException;
	
    public FoodCart reduceQuantity(Integer cart_id,Integer quantity,Integer item_Id)throws CartNotFoundException ,ItemException;
	
    public FoodCart removeItem(Integer cartId,Integer itemId)throws CartNotFoundException ,ItemException;
    
	public FoodCart clearCart(Integer cartId) throws CartNotFoundException;
	

}
