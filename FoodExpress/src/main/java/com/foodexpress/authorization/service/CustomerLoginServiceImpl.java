package com.foodexpress.authorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import com.foodexpress.authorization.exception.CustomerLoginException;
import com.foodexpress.authorization.model.CustomerLoginDTO;
import com.foodexpress.authorization.model.CustomerSession;
import com.foodexpress.authorization.repository.CustomerSessionDao;
import com.foodexpress.model.Customer;
import com.foodexpress.repository.CustomerDao;

import net.bytebuddy.utility.RandomString;


@Service
public class CustomerLoginServiceImpl implements CustomerLoginService{

	@Autowired
	private CustomerDao cDao;
	
	@Autowired
	private CustomerSessionDao cSDao;
	
	@Override
	public String customerLogin(CustomerLoginDTO dto) throws CustomerLoginException {
		
		Customer existingCustomer = cDao.findByMobileNo(dto.getMobileNo());
		
		if(existingCustomer==null) {
			throw new CustomerLoginException("Please enter a valid mobile number!");
		}
		
		Optional<CustomerSession> opt = cSDao.findById(existingCustomer.getCustomerId());
		
		if(opt.isPresent()) {
			throw new CustomerLoginException("Customer already logged in!");
		}
		
		if(existingCustomer.getPassword().equals(dto.getPassword())) {
			
			CustomerSession custSession = new CustomerSession(existingCustomer.getCustomerId(),RandomString.make(8),LocalDateTime.now());
		
		    cSDao.save(custSession);
		    
		    return custSession.toString();
		}else {
			throw new CustomerLoginException("Please enter a valid password!");
		}
		
	}

	@Override
	public String customerLogout(String uniqueId) throws CustomerLoginException {
		
		CustomerSession validCustomer = cSDao.findByUinqueId(uniqueId);
		
		if(validCustomer == null) {
			throw new CustomerLoginException("User not logged in with this number!");
		}
		
		cSDao.delete(validCustomer);
		return "Logged out!";
	}

	

}
