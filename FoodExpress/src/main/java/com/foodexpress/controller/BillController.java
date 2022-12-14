package com.foodexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodexpress.exception.BillException;
import com.foodexpress.model.Bill;
import com.foodexpress.service.BillService;

@RestController
public class BillController {

	@Autowired
	public BillService bService;

	@PostMapping("/bill")
	public ResponseEntity<Bill> addBill(@RequestBody Bill bill) throws BillException {

		Bill newBill = bService.addBill(bill);

		return new ResponseEntity<>(newBill, HttpStatus.CREATED);
	}

}
