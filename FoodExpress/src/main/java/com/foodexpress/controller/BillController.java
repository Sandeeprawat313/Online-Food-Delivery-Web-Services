package com.foodexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodexpress.exception.BillException;
import com.foodexpress.model.Bill;
import com.foodexpress.service.BillService;

@RestController
public class BillController {

	@Autowired
	public BillService bService;

	@PostMapping("/addBill")
	public ResponseEntity<Bill> addBill(@RequestBody Bill bill) throws BillException {

		Bill savedBill = bService.addBill(bill);

		return new ResponseEntity<Bill>(savedBill, HttpStatus.CREATED);

	}

	@PutMapping("/removeBill")
	public ResponseEntity<Bill> removeBill(@RequestBody Bill bill) throws BillException {

		Bill removedBill = bService.removeBill(bill);

		return new ResponseEntity<Bill>(removedBill, HttpStatus.ACCEPTED);

	}

}
