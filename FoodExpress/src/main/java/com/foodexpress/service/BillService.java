package com.foodexpress.service;

import java.time.LocalDate;
import java.util.List;

import com.foodexpress.exception.BillException;
import com.foodexpress.model.Bill;

public interface BillService {

	public Bill addBill(Bill bill) throws BillException;

	public Bill removeBill(Bill bill) throws BillException;

	public Bill updateBill(Bill bill) throws BillException;

	public Bill viewBill(Bill bill) throws BillException;

	public List<Bill> viewBills(Integer custId) throws BillException;

	public List<Bill> viewBills(LocalDate startDate, LocalDate endDate) throws BillException;

	public double calculateTotalCost(Bill bill) throws BillException;

}
