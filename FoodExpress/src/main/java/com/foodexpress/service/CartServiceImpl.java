package com.foodexpress.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodexpress.authorization.repository.CustomerSessionDao;
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
			
			throw new CartNotFoundException("No Cart found with ID: "+cartId);
//			FoodCart cart=new FoodCart();
//			Optional<Items> iOpt = itemDao.findById(itemId);
//			
//			Optional<Customer> cus=cDao.findById(itemId);
//			
//			
//			
//			cart.setCustomer(cus.get());
//			
//			cart.getItemList().add(iOpt.get());
//			
//			 return cartDao.save(cart);
			
		}
	}
	
	@Override
	public FoodCart saveCart(FoodCart cart) throws CartNotFoundException {
		
		
	
		Optional<FoodCart> opt = cartDao.findById(cart.getCartId());
		if(opt.isPresent()) {
			throw new CartNotFoundException("Cart already exists..");
		}else {
			 return cartDao.save(cart);
		}
	}
	
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

	@Override
	public FoodCart increaseQuantity(Integer cart_id,Integer item_id, Integer quantity)throws CartNotFoundException,ItemException {
		Optional<FoodCart> fc=cartDao.findById(cart_id);
		
		
		if(fc.isPresent())
		{
			
			Optional<Items> items=itemDao.findById(item_id);
			
			if(items.isPresent()) {
			FoodCart cart = fc.get();
			Items item = items.get();
			
			item.setQuantity(item.getQuantity()+quantity);
			
			cart.getItemList().add(item);
			
			return cart;
		}
		else {
			throw new ItemException("No Item found with ID: "+item_id);
		}
		
		}
		else
		{
			throw  new CartNotFoundException("no cart is there ");
		}
	}

	@Override
	public FoodCart reduceQuantity(Integer cart_id, Integer quantity, Integer item_Id) throws CartNotFoundException, ItemException {
		
      Optional<FoodCart> fc=cartDao.findById(cart_id);
		
		
		if(fc.isPresent())
		{
			
			Optional<Items> items=itemDao.findById(item_Id);
			
			if(items.isPresent()) {
			FoodCart cart = fc.get();
			Items item = items.get();
			
			item.setQuantity(item.getQuantity()-quantity);
			
			cart.getItemList().add(item);
			
			return cart;
		}
		else {
			throw new ItemException("No Item found with ID: "+item_Id);
		}
		
		}
		else
		{
			throw  new CartNotFoundException("no cart is there ");
		}
	}

	@Override
	public FoodCart removeItem(Integer cartId, Integer itemId) throws CartNotFoundException, ItemException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
