package com.foodexpress.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodexpress.exception.CustomerLoginException;
import com.foodexpress.model.Customer;
import com.foodexpress.model.CustomerLoginDTO;
import com.foodexpress.model.CustomerSession;
import com.foodexpress.repository.CustomerDao;
import com.foodexpress.repository.CustomerSessionDao;

import net.bytebuddy.utility.RandomString;


@Service
public class CustomerLoginServiceImpl implements CustomerLoginService{

	@Autowired
	private CustomerDao cDao;
	
	@Autowired
	private CustomerSessionDao cSDao;
	
	@Override
	public String customerLogin(CustomerLoginDTO dto) throws CustomerLoginException {
		
		Customer existingCustomer = cDao.findByMobileNumber(dto.getMobileNumber());
		
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
		
		CustomerSession validCustomer = cSDao.findByUniqueId(uniqueId);
		
		if(validCustomer == null) {
			throw new CustomerLoginException("User not logged in with this number!");
		}
		
		cSDao.delete(validCustomer);
		return "Logged out!";
	}

	

}
