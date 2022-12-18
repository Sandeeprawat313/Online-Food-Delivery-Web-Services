package com.foodexpress.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodexpress.exception.CustomerException;
import com.foodexpress.exception.RestaurantException;
import com.foodexpress.model.Customer;
import com.foodexpress.model.CustomerSession;
import com.foodexpress.model.Items;
import com.foodexpress.model.RestaurantSession;
import com.foodexpress.model.Restaurants;
import com.foodexpress.repository.CustomerSessionDao;
import com.foodexpress.repository.ItemsDao;
import com.foodexpress.repository.RestaurantDao;
import com.foodexpress.repository.RestaurantSessionDao;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantDao rDao;

	@Autowired
	private ItemsDao iDao;

	@Autowired
	private CustomerSessionDao cSDao;

	@Autowired
	private RestaurantSessionDao rSDao;

	@Override
	public Restaurants createRestaurant(Restaurants restaurants) throws RestaurantException {
		Restaurants existrestaurants = rDao.findByRestaurantName(restaurants.getRestaurantName());

		if (existrestaurants != null) {
			throw new RestaurantException(restaurants.getRestaurantName() + " Resturant is Already Registerd with Us");
		}

		List<Items> itemslist = restaurants.getItemList();

		for (Items items : itemslist) {
			items.getListOfRestaurants().add(restaurants);
		}

		return rDao.save(restaurants);

	}

	String username = "8777686325";
	String password = "8777686325";

	// 1000 check with
	@Override
	public Restaurants updateRestaurant(String uniqueId, Restaurants restaurants) throws RestaurantException {
		RestaurantSession ResSession = rSDao.findByUniqueId(uniqueId);
		// Customer Admin = cDao.findByMobileNumber(userNameCustomer);

		if (ResSession != null) {
			Optional<Restaurants> opt = rDao.findById(ResSession.getRestaurantId());
			Restaurants admin = opt.get();
			if (admin.getContactNumber().equals(username)) {

				admin.setAddress(restaurants.getAddress());
				admin.setContactNumber(restaurants.getContactNumber());
				admin.setManagerName(restaurants.getManagerName());
				admin.setRestaurantName(restaurants.getRestaurantName());

				List<Items> listofItemsCommingfrombody = restaurants.getItemList();

				for (Items items : listofItemsCommingfrombody) {
					admin.getItemList().add(items);
					// items.getListOfRestaurants().add(existrestaurants);
				}

				return rDao.save(admin);

			} else {
				throw new CustomerException("Admin must be logged in");
			}

		} else {
			throw new CustomerException("Please login first");
		}

//		Optional<Restaurants> idverifedresturantOPT = rDao.findById(restaurants.getRestaurantId());
//		if (idverifedresturantOPT.isEmpty()) {
//			throw new RestaurantException("Worng ID " + idverifedresturantOPT.get().getRestaurantId());
//		}
//
//		Restaurants existrestaurants = idverifedresturantOPT.get();
//
//		existrestaurants.setAddress(restaurants.getAddress());
//		existrestaurants.setContactNumber(restaurants.getContactNumber());
//		existrestaurants.setManagerName(restaurants.getManagerName());
//		existrestaurants.setRestaurantName(restaurants.getRestaurantName());
//
//		List<Items> listofItemsCommingfrombody = restaurants.getItemList();
//
//		for (Items items : listofItemsCommingfrombody) {
//			existrestaurants.getItemList().add(items);
//			// items.getListOfRestaurants().add(existrestaurants);
//		}
//
//		return rDao.save(existrestaurants);

	}

	@Override
	public Restaurants removeRestaurant(Integer resturantid) throws RestaurantException {
		// TODO Auto-generated method stub
		Optional<Restaurants> idverifedresturantOPT = rDao.findById(resturantid);

		if (idverifedresturantOPT.isEmpty()) {
			throw new RestaurantException("Worng ID " + idverifedresturantOPT.get().getRestaurantId());
		}

		Restaurants existrestaurants = idverifedresturantOPT.get();

		List<Items> itemslist = existrestaurants.getItemList();

		itemslist = null;

//		for (int i = 0; i < itemslist.size(); i++)
//		{
//			itemslist.remove(i + 1);
//		}

		rDao.delete(existrestaurants);

		return existrestaurants;
	}

	// 3. customer
	@Override
	public List<Restaurants> viewRestaurant(String uniqueId) throws RestaurantException {
		CustomerSession cS = cSDao.findByUniqueId(uniqueId);

		if (cS != null) {
			List<Restaurants> list = rDao.findAll();
			return list;
		}
		{
			throw new RestaurantException("Customer is not logged in");
		}

//		Optional<Restaurants> opt = rDao.findById(restaurants.getRestaurantId());
//
//		if (opt.isEmpty())
//		{
//			throw new RestaurantException("No resturant Found with this ID");
//		}
//
//		Restaurants existrestaurants = opt.get();
//
//		if (existrestaurants.getRestaurantName().equals(restaurants.getRestaurantName())
//				&& existrestaurants.getContactNumber().equals(restaurants.getContactNumber()))
//		{
//			return existrestaurants;
//		}
//
//		else
//		{
//			throw new RestaurantException("Name or Phone Number missmatch with ID");
//		}

	}

	@Override
	public List<Restaurants> viewNearByRestaurant(String location) throws RestaurantException {

		List<Restaurants> allbyResturantList = rDao.getRestByLocation();

		// allbyResturantList.forEach(s -> System.out.println(s.getRestaurantName()));

		List<Restaurants> filteredResturant = new ArrayList<>();

		for (Restaurants restaurants : allbyResturantList) {
			if (restaurants.getAddress().getCity().equalsIgnoreCase(location)) {
				filteredResturant.add(restaurants);

			}
		}

		return filteredResturant;
	}

	@Override
	public List<Restaurants> viewRestaurantByItemname(String itemname) throws RestaurantException {
		// TODO Auto-generated method stub
		List<Items> itemList_jaha_pe_yea_milta_hai = iDao.findByItemName(itemname);

		List<Restaurants> allResturant = new ArrayList<>();

		itemList_jaha_pe_yea_milta_hai
				.forEach(s -> System.out.println(s.getItemName() + "==>" + s.getItemId() + "==++ "));

		for (Items items : itemList_jaha_pe_yea_milta_hai) {
			allResturant.add(items.getListOfRestaurants().get(0));
		}

		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		for (Restaurants restaurants : allResturant) {
			System.out.println(restaurants.getRestaurantName());
		}

		return allResturant;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override // MOST IMPORTANT
	public Restaurants addRestaurant(Restaurants restaurant) {
		List<Items> items = restaurant.getItemList();

		for (Items item : items) {
			// associating each items with restaurant
			item.getListOfRestaurants().add(restaurant);
		}
		return rDao.save(restaurant);
	}

}
