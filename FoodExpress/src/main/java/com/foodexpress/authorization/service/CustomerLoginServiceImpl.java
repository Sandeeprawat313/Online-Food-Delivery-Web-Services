package com.foodexpress.authorization.service;

import org.springframework.stereotype.Service;

import com.foodexpress.authorization.exception.CustomerLoginException;
import com.foodexpress.authorization.model.CustomerLoginDTO;


@Service
public class CustomerLoginServiceImpl implements CustomerLoginService{

	@Override
	public String customerLogin(CustomerLoginDTO dto) throws CustomerLoginException {
		
		return null;
	}

	@Override
	public String customerLogout(String uniqueId) throws CustomerLoginException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
