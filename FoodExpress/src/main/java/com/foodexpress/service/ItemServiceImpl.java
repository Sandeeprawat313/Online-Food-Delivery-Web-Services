package com.foodexpress.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodexpress.exception.ItemException;
import com.foodexpress.exception.RestaurantException;
import com.foodexpress.model.CustomerSession;
import com.foodexpress.model.Items;
import com.foodexpress.model.RestaurantSession;
import com.foodexpress.model.Restaurants;
import com.foodexpress.repository.CustomerSessionDao;
import com.foodexpress.repository.ItemsDao;
import com.foodexpress.repository.RestaurantDao;
import com.foodexpress.repository.RestaurantSessionDao;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsDao iDao;

	@Autowired
	private RestaurantDao rDao;

	@Autowired
	private RestaurantSessionDao sDao;

	@Autowired
	private CustomerSessionDao cSDao;

	@Override
	public Items createItem(String restaurantName, Items item) throws ItemException {

		Restaurants existResturant = rDao.findByRestaurantName(restaurantName);

		if (existResturant == null) {
			throw new ItemException(restaurantName + " Resturant Not found with this name");
		}

		existResturant.getItemList().add(item);

		return iDao.save(item);

	}

	@Override
	public Items updateItem(String restaurantName, Items item) throws ItemException {

		Restaurants existResturant = rDao.findByRestaurantName(restaurantName);

		if (existResturant == null) {
			throw new ItemException(restaurantName + " Resturant Not found");
		}

		List<Items> itemsList = iDao.findAll();

		Items updatedItem = null;
		int flag = 0;
		for (Items elemitems : itemsList) {
			if ((elemitems.getItemId() == item.getItemId())) {
				elemitems.setItemName(item.getItemName());
				elemitems.setCategory(item.getCategory());
				elemitems.setCostPerUnit(item.getCostPerUnit());
				elemitems.setQuantity(item.getQuantity());
				updatedItem = elemitems;
				flag = 1;
			}
		}

		if (flag == 0) {
			throw new ItemException("Irem Not FOund with provided item ID");
		} else {
			iDao.save(updatedItem);
		}

		return updatedItem;
	}

	@Override
	public Items viewItem(String restaurantName, Integer itemid) throws ItemException {
		// TODO Auto-generated method stub
		Restaurants existResturant = rDao.findByRestaurantName(restaurantName);

		if (existResturant == null) {
			throw new ItemException(restaurantName + " Resturant Not found with this name");
		}

		Optional<Items> opt = iDao.findById(itemid);

		if (opt.isEmpty()) {
			throw new ItemException("Invalid id==>" + itemid);
		}

		return opt.get();

	}

//	@Override
//	public Items removeItem(String restaurantName, Items item) throws ItemException
//	{

//		Restaurants existResturant = rDao.findByRestaurantName(restaurantName);
//
//		if (existResturant == null)
//		{
//			throw new ItemException(restaurantName + " Resturant Not found with this name");
//		}
//
//		List<Items> existItem = existResturant.getItemList();
//
//		Items targetItem = null;

//		boolean flag = false;

	// System.out.println(existItem);

//		for (Items items : existItem)
//		{
//			if (items.getItemName().equals(item.getItemName()))
//			{
//				System.out.println(items.getItemName());
//				
//			}
//		}

//		for (Items elemitems : existItem)
//		{
//			if (elemitems.getItemName().equalsIgnoreCase(item.getItemName()))
//			{
//				System.out.println(elemitems.toString());
//				flag = true;
//				// targetItem = elemitems;
//				iDao.delete(item);
//				// iDao.deleteById(item.getItemId());
//				break;
//			}
//
//		}
//
//		for (int i = 0; i < existItem.size(); i++)
//		{
//			if (existItem.get(i).getItemName().equals(item.getItemName()))
//			{
//				targetItem = existItem.get(i);
//				System.out.println(existItem.get(i).getItemName());
//				existItem.remove(i);
//				iDao.delete(item);
//				break;
//			}
//		}
//
//		List<Restaurants> restListXX = targetItem.getListOfRestaurants();
//
//		for (int i = 0; i < restListXX.size(); i++)
//		{
//			if (restListXX.get(i).equals(existResturant))
//			{
//				restListXX.remove(i);
//				break;
//			}
//		}
//
//		rDao.save(existResturant);
//		return targetItem;

//		if (flag)
//		{
//
//			return item;
//		}
//		else
//		{
//			throw new ItemException("Not found Item in Given RFesturant");
//		}
//		System.out.println(targetItem.getItemName());
//
//		for (int i = 0; i < existItem.size(); i++)
//		{
//			if (existItem.get(i) == targetItem)
//			{
//				existItem.remove(i);
//			}
//		}
//
//		rDao.save(existResturant);
//
//		return targetItem;
//	}

	@Override
	public Items removeItem(Integer restaurantId, String uniqueId, Items item)
			throws ItemException, RestaurantException {

		RestaurantSession loggedInRestaurant = sDao.findByUniqueId(uniqueId);

		if (loggedInRestaurant == null) {
			throw new RestaurantException("Invalid unique id..!!");
		}

		Items itemfind = null;
		Optional<Items> opt = iDao.findById(item.getItemId());
		if (opt.isEmpty()) {
			throw new ItemException("NoOpThreadContextMap found");
		} else {
			itemfind = opt.get();

			if (restaurantId == loggedInRestaurant.getRestaurantId()) {
				iDao.delete(item);
				return item;

			} else {
				throw new RestaurantException("Invalid restaurant details");
			}
		}

	}

	// 4 ..
	@Override
	public List<Items> viewAllItemsOfRestaurent(Integer restaurantId, String uniqueId) {

		CustomerSession cS = cSDao.findByUniqueId(uniqueId);

		if (cS != null) {
			Optional<Restaurants> opt = rDao.findById(restaurantId);
			if (opt.isPresent()) {
				List<Items> listOfItems = opt.get().getItemList();
				return listOfItems;

			} else {
				throw new RestaurantException("Restuarent not exsit");
			}
		}
		{
			throw new RestaurantException("Customer is not logged in");
		}

	}

	@Override
	public List<Items> viewAllItemsByName(String name) throws ItemException {
		// TODO Auto-generated method stub
		List<Items> listallItem = iDao.findAll();

		if (listallItem.size() == 0) {
			throw new ItemException("Item Table is full Emptry");
		}

		List<Items> particularItemList = new ArrayList<>();

		int flag = 0;

		for (Items elemItem : listallItem) {
			if (elemItem.getItemName().equalsIgnoreCase(name)) {
				particularItemList.add(elemItem);
				flag = 1;
			}
		}

		if (flag == 0) {
			throw new ItemException("No Item Found with name");
		} else {
			return particularItemList;
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Items addItemToRestaurant(String restaurantName, Items item) throws ItemException {
		Restaurants restaurant = rDao.getResByName(restaurantName);

		if (restaurant == null) {
			throw new ItemException("Restaurant not found");
		} else {
			// associate item in restaurent
			restaurant.getItemList().add(item);
			// associate Restaurant with item
			item.getListOfRestaurants().add(restaurant);
			Items NewItem = iDao.save(item);// save bhi karo new hai dono cascading hai ek save hoga to dono ho jaynge
			return NewItem;

		}
	}

}
