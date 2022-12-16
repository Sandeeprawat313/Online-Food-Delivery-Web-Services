package com.foodexpress.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.foodexpress.model.Customer;

@Service
public interface CustomerService {

	// 1. Add customer
	public Customer customerRegistration(Customer customer);

	// 2 update customer details
	public Customer updateCustomerDetails(String uniqueId, Customer updatedcustomer);

	// 3remove customer (BY ADMIN ONLY)(admin uniqueId)
	public Customer removeCustomer(String uniqueId, String userNameCustomer);

	// 4 view customer (customer checking his own details)(Customers uniqueId)
	public Customer showCustomerDetails(String uniqueId);

	// 5 get list of all customers (only by admin)(admin uniqueId)
	public List<Customer> getAllCustomerDetails(String uniqueId);
}
