package com.foodexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodexpress.model.OrderDetails;
import com.foodexpress.service.OrderService;

@RestController
public class OrderDetailsController {
	@Autowired
	public OrderService oService;

	@PostMapping("/placeorder/{cartId}/{uniqueId}")
	public ResponseEntity<OrderDetails> addOrder(@PathVariable("cartId") Integer cartId,
			@PathVariable("uniqueId") String uniqueId) {
		OrderDetails orderDetails = oService.addOrder(cartId, uniqueId);

		return new ResponseEntity<OrderDetails>(orderDetails, HttpStatus.OK);

	}

}
