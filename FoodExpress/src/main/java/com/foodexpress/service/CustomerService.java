package com.foodexpress.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.foodexpress.model.Customer;

@Service
public interface CustomerService
{

	// @Query("select c.email from Customer c")
	public Customer customerRegistration(Customer customer);

	public List<Customer> getAllCustomerDetails();
}
