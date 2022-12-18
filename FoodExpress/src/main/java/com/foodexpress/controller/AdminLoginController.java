package com.foodexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodexpress.model.RestaurantLoginDTO;
import com.foodexpress.service.RestaurantLoginService;

@RestController
public class AdminLoginController {

	@Autowired
	private RestaurantLoginService rLService;

	@PostMapping("/AdminLogin")
	public String restaurantLogin(@RequestBody RestaurantLoginDTO dto) {
		return rLService.restaurantLogin(dto);
	}

	@PatchMapping("/AdminLoginLogout/{uniqueId}")
	public String restaurantLogout(@PathVariable("uniqueId") String uniqueId) {
		return rLService.restaurantLogout(uniqueId);
	}

}
