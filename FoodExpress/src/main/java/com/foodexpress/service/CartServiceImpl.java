package com.foodexpress.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodexpress.exception.CartNotFoundException;
import com.foodexpress.exception.ItemException;
import com.foodexpress.model.CustomerSession;
import com.foodexpress.model.FoodCart;
import com.foodexpress.model.Items;
import com.foodexpress.repository.CartDao;
import com.foodexpress.repository.CustomerDao;
import com.foodexpress.repository.CustomerSessionDao;
import com.foodexpress.repository.ItemsDao;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	public CustomerDao cDao;
	@Autowired
	public CartDao cartDao;

	@Autowired
	public ItemsDao itemDao;

	@Autowired
	public CustomerSessionDao csDao;

//	@Override
	// public FoodCart addItemToCart(Integer cartId, Integer itemId) throws
	// CartNotFoundException, ItemException ,CustomerLoginException{
//	
////		CustomerSession loggedincustomer=csDao.findByUniqueId(key);
////		
////		if(loggedincustomer==null)
////		{
////			throw new CustomerLoginException("Please enter valid unique id");
////		}
//		
//		
//
////	       items.add(item);
//		Optional<FoodCart> cOpt = cartDao.findById(cartId);
//		if(cOpt.isPresent()) {
//			FoodCart cart = cOpt.get();
//			Optional<Items> iOpt = itemDao.findById(itemId);
//			if(iOpt.isPresent()) {
//				
//				//FoodCart cart = cOpt.get();
//				Items item = iOpt.get();
//			
//				cart.getItemList().add(item);
//				
//				
//				return cart;
//				
//			}else {
//				throw new ItemException("No Item found with ID: "+itemId);
//			}
//			
//		}
//		else {
//			
//			
//		FoodCart cart=new FoodCart();
//		Optional<Items> iOpt = itemDao.findById(itemId);
////			
////		        loggedincustomer.getCustomerId();
////			
//		//	Optional<Customer> cus=cDao.findById(itemId);
////			
////			
////			
//			//cart.setCustomer(cus.get());
////			
//			cart.getItemList().add(iOpt.get());
////			
//			 return cartDao.save(cart);
//			
//		}
//	}

	@Override
	public FoodCart saveCart(String key) throws CartNotFoundException {

		CustomerSession css = csDao.findByUniqueId(key);
		// Optional<FoodCart> opt = cartDao.findById(cart.getCartId());
//		if(opt.isPresent()) {
//			throw new CartNotFoundException("Cart already exists..");
//		}else {
//			 return cartDao.save(cart);

		if (css != null) {
			FoodCart cart = new FoodCart();
			cart.setCustumerId(css.getCustomerId());
			return cartDao.save(cart);

		} else {
			throw new CartNotFoundException("please login first");
		}

	}

	@Override
	public FoodCart clearCart(Integer cartId) throws CartNotFoundException {
		Optional<FoodCart> opt = cartDao.findById(cartId);
		if (opt.isPresent()) {
			FoodCart cart = opt.get();
			cartDao.delete(cart);
			return cart;
		} else {
			throw new CartNotFoundException("No Cart found with ID: " + cartId);
		}
	}

	@Override
	public FoodCart increaseQuantity(Integer cart_id, Integer item_id, Integer quantity)
			throws CartNotFoundException, ItemException {
		Optional<FoodCart> fc = cartDao.findById(cart_id);

		if (fc.isPresent()) {

			Optional<Items> items = itemDao.findById(item_id);

			if (items.isPresent()) {
				FoodCart cart = fc.get();
				Items item = items.get();

				item.setQuantity(item.getQuantity() + quantity);

				cart.getItemList().add(item);

				return cart;
			} else {
				throw new ItemException("No Item found with ID: " + item_id);
			}

		} else {
			throw new CartNotFoundException("no cart is there ");
		}
	}

	@Override
	public FoodCart reduceQuantity(Integer cart_id, Integer quantity, Integer item_Id)
			throws CartNotFoundException, ItemException {

		Optional<FoodCart> fc = cartDao.findById(cart_id);

		if (fc.isPresent()) {

			Optional<Items> items = itemDao.findById(item_Id);

			if (items.isPresent()) {
				FoodCart cart = fc.get();
				Items item = items.get();

				item.setQuantity(item.getQuantity() - quantity);

				cart.getItemList().add(item);

				return cart;
			} else {
				throw new ItemException("No Item found with ID: " + item_Id);
			}

		} else {
			throw new CartNotFoundException("no cart is there ");
		}
	}

	@Override
	public FoodCart removeItem(Integer cartId, Integer itemId) throws CartNotFoundException, ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodCart viewCart(Integer cartid) throws CartNotFoundException {
		Optional<FoodCart> cart = cartDao.findById(cartid);
		if (cart.isPresent()) {
			throw new CartNotFoundException(" empty cart");
		} else {

			return cart.get();
		}

	}

	// 5 =======Customer
	@Override
	public FoodCart addItemToCart(Integer itemId, String uniueId) {
		FoodCart foodCart = null;

		CustomerSession cs = csDao.findByUniqueId(uniueId);
		if (cs != null) {
			foodCart = cartDao.findByCustumerId(cs.getCustomerId());
			if (foodCart != null) {
				Optional<Items> opt = itemDao.findById(itemId);
				if (opt.isPresent()) {
					foodCart.getItemList().add(opt.get());
					// foodCart = cartDao.save(foodCart);
					return cartDao.save(foodCart);

				} else {
					throw new ItemException("No item found with this itemId");
				}

			} else {
				foodCart = new FoodCart();
				foodCart.setCustumerId(cs.getCustomerId());
				Optional<Items> opt = itemDao.findById(itemId);
				if (opt.isPresent()) {
					foodCart.getItemList().add(opt.get());
					foodCart = cartDao.save(foodCart);
					return cartDao.save(foodCart);
				} else {
					throw new ItemException("No item found with this itemId");
				}

			}
		}
		return foodCart;

	}

	// original
//	@Override
//	public FoodCart addItemToCart(Integer cartId, Integer itemId)
//			throws CartNotFoundException, ItemException, CustomerLoginException {
//
//		Optional<FoodCart> cOpt = cartDao.findById(cartId);
//		if (cOpt.isPresent()) {
//			FoodCart cart = cOpt.get();
//			Optional<Items> iOpt = itemDao.findById(itemId);
//			if (iOpt.isPresent()) {
//				Items item = iOpt.get();
//				cart.getItemList().add(item);
//
//				cartDao.save(cart);
//
//				return cart;
//
//			} else {
//				throw new ItemException("No Item found with ID: " + itemId);
//			}
//
//		} else {
//			throw new CartNotFoundException("No Cart found with ID: " + cartId);
//		}
//	}

}
