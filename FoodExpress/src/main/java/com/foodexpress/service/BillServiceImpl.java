package com.foodexpress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodexpress.exception.BillException;
import com.foodexpress.model.Bill;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	public BillService bDao;

	@Override
	public Bill addBill(Bill bill) throws BillException {
		// TODO Auto-generated method stub
		return null;
	}

}
