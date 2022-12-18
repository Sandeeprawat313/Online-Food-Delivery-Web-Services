package com.foodexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodexpress.model.CustomerLoginDTO;
import com.foodexpress.service.CustomerLoginService;

@RestController
public class CustomerLoginController {
	
	@Autowired
	private CustomerLoginService cLService;
	
	//2 customer login 
	@PostMapping("/customerLogin")
	public String customerLogin(@RequestBody CustomerLoginDTO dto) {
		return cLService.customerLogin(dto);
	}
	
	@PatchMapping("/customerLogout")
	public String customerLogout(@RequestParam String uniqueId) {
		return cLService.customerLogout(uniqueId);
	}

}
