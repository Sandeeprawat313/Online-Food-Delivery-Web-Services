package com.foodexpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.service.CustomerService;

@RestController
public class CustomerControll {

	@Autowired
	private CustomerService cService;

	@PostMapping("/customers")
	public ResponseEntity<Customer> customerRegistration(@RequestBody Customer customer) {
		Customer NewCustomer = cService.customerRegistration(customer);
		return new ResponseEntity<Customer>(NewCustomer, HttpStatus.CREATED);

	}

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomerDetails() {
		List<Customer> list = cService.getAllCustomerDetails();

		return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}

}
