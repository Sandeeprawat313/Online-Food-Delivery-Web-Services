package com.foodexpress.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodexpress.exception.CartNotFoundException;
import com.foodexpress.exception.ItemException;
import com.foodexpress.model.Customer;
import com.foodexpress.model.FoodCart;
import com.foodexpress.model.Items;
import com.foodexpress.repository.CartDao;
import com.foodexpress.repository.CustomerDao;
import com.foodexpress.repository.ItemsDao;
@Service
public class CartServiceImpl implements CartService{
	@Autowired
	public CustomerDao cDao;
	@Autowired
	public CartDao cartDao;
	
	@Autowired
	public ItemsDao itemDao;

	@Override
	public FoodCart addItemToCart( Integer cartId, Integer itemId) throws CartNotFoundException, ItemException {
	

//	       items.add(item);
		Optional<FoodCart> cOpt = cartDao.findById(cartId);
		if(cOpt.isPresent()) {
			
			Optional<Items> iOpt = itemDao.findById(itemId);
			if(iOpt.isPresent()) {
				
				FoodCart cart = cOpt.get();
				Items item = iOpt.get();
			
				cart.getItemList().add(item);
				
				
				return cart;
				
			}else {
				throw new ItemException("No Item found with ID: "+itemId);
			}
			
		}
		else {
			FoodCart cart=new FoodCart();
			Optional<Items> iOpt = itemDao.findById(itemId);
			
			Optional<Customer> cus=cDao.findById(itemId);
			
			
			
			cart.setCustomer(cus.get());
			
			cart.getItemList().add(iOpt.get());
			
			 return cartDao.save(cart);
			
		}
	}
	
//	@Override
//	public FoodCart saveCart(FoodCart cart) throws CartNotFoundException {
////		
////		
////		
////		
//		Optional<FoodCart> opt = cartDao.findById(cart.getCartId());
//		if(opt.isPresent()) {
//			throw new CartNotFoundException("Cart already exists..");
//		}else {
//			 return cartDao.save(cart);
//		}
//	}
	
	@Override
	public FoodCart clearCart(Integer cartId) throws CartNotFoundException {
		Optional<FoodCart> opt = cartDao.findById(cartId);
		if(opt.isPresent()) {
			FoodCart cart = opt.get();
			cartDao.delete(cart);
			return cart;
		}else {
			throw new CartNotFoundException("No Cart found with ID: "+cartId);
		}
	}

}
