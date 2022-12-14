package com.foodexpress.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.stereotype.Service;

import com.foodexpress.exception.CartNotFoundException;
import com.foodexpress.model.FoodCart;
import com.foodexpress.model.Items;
import com.foodexpress.repository.CartDao;
@Service
public class CartServiceImpl implements CartService{
	
	
	
	public CartDao cDao;

	@Override
	public FoodCart addItemToCart(FoodCart cart, Items item) throws CartNotFoundException {
	
//	       List<Items>items=new ArrayList<>();
//	       items.add(item);
	       
	       cart.getItemList().add(item);
	       
	       
	       
	       
		
		
		
	return cart;
	}
	

}
