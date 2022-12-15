package com.foodexpress.authorization.service;

import org.springframework.stereotype.Service;

import com.foodexpress.authorization.exception.CustomerLoginException;
import com.foodexpress.authorization.model.CustomerLoginDTO;

@Service
public interface CustomerLoginService {
	public String customerLogin(CustomerLoginDTO dto) throws CustomerLoginException;
	
	public String customerLogout(String uniqueId) throws CustomerLoginException;
}
