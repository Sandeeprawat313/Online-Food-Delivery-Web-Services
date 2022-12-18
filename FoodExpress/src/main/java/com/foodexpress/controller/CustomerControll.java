package com.foodexpress.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodexpress.model.Customer;
import com.foodexpress.service.CustomerService;

@RestController
public class CustomerControll
{

	@Autowired
	private CustomerService cService;


	// 1. add customer ==> registration
	@PostMapping("/customersRegistration")
	public ResponseEntity<Customer> customerRegistration(@Valid @RequestBody Customer customer)
	{
		Customer NewCustomer = cService.customerRegistration(customer);
		return new ResponseEntity<Customer>(NewCustomer, HttpStatus.CREATED);
	}

	// 2 update customer details
	@PutMapping("/customersupdate/{key}")
	public ResponseEntity<Customer> updateCustomerDetails(@PathVariable("key") String uniqueId,
			@Valid @RequestBody Customer updatedcustomer)
	{

		Customer updatedCustomer = cService.updateCustomerDetails(uniqueId, updatedcustomer);

		return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
	}

	// check 
	// 3remove customer (BY ADMIN ONLY)
	@DeleteMapping("/customers/{uid}/{userNameCustomer}") // remove it from session also(pending)
	public ResponseEntity<Customer> removeCustomer(@PathVariable("uid") String uniqueId,
			@PathVariable("userNameCustomer") String userNameCustomer)
	{
		Customer removedCustomer = cService.removeCustomer(uniqueId, userNameCustomer);
		return new ResponseEntity<Customer>(removedCustomer, HttpStatus.OK);
	}

	// 4 view customer (customer checking his own details)(Customers uniqueId)
	@GetMapping("/customerOwnDetails/{key}")
	public ResponseEntity<Customer> showCustomerDetails(@PathVariable("key") String uniqueId)
	{

		Customer updatedCustomer = cService.showCustomerDetails(uniqueId);

		return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
	}

	// 5 get list of all customers (only by admin)==>hardcode admin details
	@GetMapping("/viewAllcustomers/{uid}")
	public ResponseEntity<List<Customer>> getAllCustomerDetails(@PathVariable("uid") String uniqueId)
	{
		List<Customer> list = cService.getAllCustomerDetails(uniqueId);

		return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}

}
