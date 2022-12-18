package com.foodexpress.service;

import org.springframework.stereotype.Service;

import com.foodexpress.exception.CustomerLoginException;
import com.foodexpress.model.CustomerLoginDTO;

@Service
public interface CustomerLoginService {
	public String customerLogin(CustomerLoginDTO dto) throws CustomerLoginException;
	
	public String customerLogout(String uniqueId) throws CustomerLoginException;
}
