package com.foodexpress.service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodexpress.exception.CustomerException;
import com.foodexpress.model.Customer;
import com.foodexpress.model.CustomerSession;
import com.foodexpress.model.RestaurantSession;
import com.foodexpress.model.Restaurants;
import com.foodexpress.repository.CustomerDao;
import com.foodexpress.repository.CustomerSessionDao;
import com.foodexpress.repository.RestaurantDao;
import com.foodexpress.repository.RestaurantSessionDao;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao cDao;

	@Autowired
	private RestaurantDao rDao;

	@Autowired
	private CustomerSessionDao cSDao;

	@Autowired
	private RestaurantSessionDao rSDao;

	// 1. add customer
	@Override
	public Customer customerRegistration(Customer customer) {
		// check if the customer is already registered or not
		Customer customerExist = cDao.findByMobileNumber(customer.getMobileNumber());
		if (customerExist == null) {
			// register if not
			Customer newCustomer = cDao.save(customer);
			return newCustomer;
		} else {
			throw new CustomerException("You are already registered");
		}

	}

	// 2 update customer details
	@Override
	public Customer updateCustomerDetails(String uniqueId, Customer updatedcustomer) {
		// check login or not
		CustomerSession customerSession = cSDao.findByUniqueId(uniqueId);
		if (customerSession == null) {
			throw new CustomerException("Customer is not logged in");
		} else {
			Optional<Customer> opt = cDao.findById(customerSession.getCustomerId());
			Customer eixtingCustomer = opt.get();
			if (eixtingCustomer.getCustomerId() == customerSession.getCustomerId()) {
				Customer updated = cDao.save(updatedcustomer);
				return updated;
			} else {
				throw new CustomerException("You can not change details of other users");
			}
		}
	}

	// 3remove customer (BY ADMIN ONLY)
	String username = "8777686325";
	String password = "8777686325";

	@Override
	public Customer removeCustomer(String uniqueId, String userNameCustomer) {

		RestaurantSession ResSession = rSDao.findByUniqueId(uniqueId);
		// Customer Admin = cDao.findByMobileNumber(userNameCustomer);

		if (ResSession != null) {
			Optional<Restaurants> opt = rDao.findById(ResSession.getRestaurantId());
			Restaurants admin = opt.get();
			if (admin.getContactNumber().equals(username)) {
				Customer targetCustomer = cDao.findByMobileNumber(userNameCustomer);
				if (targetCustomer != null) {
					cDao.delete(targetCustomer);
					return targetCustomer;
				} else {
					throw new CustomerException("No Customer found with this Username");
				}
			} else {
				throw new CustomerException("Admin must be logged in");
			}

		} else {
			throw new CustomerException("Please login first");
		}

	}

	// 4 view customer (customer checking his own details)(Customers uniqueId)
	@Override
	public Customer showCustomerDetails(String uniqueId) {
		// check login or not
		CustomerSession customerSession = cSDao.findByUniqueId(uniqueId);
		if (customerSession == null) {
			throw new CustomerException("Customer is not logged in");
		} else {
			Optional<Customer> opt = cDao.findById(customerSession.getCustomerId());
			Customer eixtingCustomer = opt.get();
			if (eixtingCustomer.getCustomerId() == customerSession.getCustomerId()) {
				return eixtingCustomer;
			} else {
				throw new CustomerException("You can not authorised to see the details");
			}
		}

	}

	// 5 get list of all customers (only by admin)
	@Override
	public List<Customer> getAllCustomerDetails(String uniqueId) {
		RestaurantSession ResSession = rSDao.findByUniqueId(uniqueId);
		if (ResSession != null) {
			Optional<Restaurants> opt = rDao.findById(ResSession.getRestaurantId());
			Restaurants admin = opt.get();
			if (admin.getContactNumber().equals(username)) {
				List<Customer> list = cDao.findAll();
				return list;
			} else {
				throw new CustomerException("Admin must be logged in");
			}

		} else {
			throw new CustomerException("Please login first");
		}

	}

}
