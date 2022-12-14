package com.foodexpress.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodexpress.model.Customer;
import com.foodexpress.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService
{

	@Autowired
	private CustomerDao cDao;

	@Override
	public Customer customerRegistration(Customer customer)
	{
		Customer newCustomer = cDao.save(customer);

		return newCustomer;
	}

	@Override
	public List<Customer> getAllCustomerDetails()
	{
		List<Customer> list = cDao.findAll();

		return list;

	}

}
