package com.foodexpress.service;

import org.springframework.stereotype.Service;

import com.foodexpress.exception.BillException;
import com.foodexpress.model.Bill;

@Service
public interface BillService {

	public Bill addBill(Bill bill) throws BillException;

}
