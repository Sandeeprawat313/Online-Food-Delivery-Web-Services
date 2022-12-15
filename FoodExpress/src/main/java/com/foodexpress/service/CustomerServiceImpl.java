package com.foodexpress.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodexpress.authorization.model.CustomerSession;
import com.foodexpress.authorization.repository.CustomerSessionDao;
import com.foodexpress.exception.CustomerException;
import com.foodexpress.model.Customer;
import com.foodexpress.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao cDao;

	@Autowired
	private CustomerSessionDao cSDao;

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
	String username = "12345";
	String password = "12345";
	String uniqueId = "Kq6O1WIv";

	@Override
	public Customer removeCustomer(String uniqueId, String userNameCustomer) {
		// if admin is logged in
		if (true) {
			Customer targetCustomer = cDao.findByMobileNumber(userNameCustomer);
			if (targetCustomer != null) {
				cDao.delete(targetCustomer);
				return targetCustomer;
			} else {
				throw new CustomerException("No customer found with this Username");
			}
		} else {
			throw new CustomerException("Admin must be logged in");
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
		// if admin is logged in
		if (true) {
			List<Customer> list = cDao.findAll();
			return list;
		}
		{
			throw new CustomerException("Only Amin can checkoutout all the customer details");
		}

	}

}
