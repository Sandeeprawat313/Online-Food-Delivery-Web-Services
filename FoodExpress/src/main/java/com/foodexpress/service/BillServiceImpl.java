package com.foodexpress.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodexpress.exception.BillException;
import com.foodexpress.model.Bill;
import com.foodexpress.repository.BillDao;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	public BillDao bDao;

	@Override
	public Bill addBill(Bill bill) throws BillException {
		Bill savedBill = bDao.save(bill);

		return savedBill;
	}

	@Override
	public Bill removeBill(Bill bill) throws BillException {
		Optional<Bill> opt = bDao.findById(bill.getBillId());

		if (opt.isPresent()) {
			bDao.delete(bill);

		} else {
			throw new BillException("No bill found by " + bill.getBillId() + " id");
		}

		return bill;

	}

	@Override
	public Bill updateBill(Bill bill) throws BillException {
		Optional<Bill> opt = bDao.findById(bill.getBillId());
		Bill uBill = null;
		if (opt.isPresent()) {
			uBill = bDao.save(opt.get());

		} else {
			throw new BillException("No bill found by " + bill.getBillId() + " id");
		}

		return uBill;
	}

	@Override
	public Bill viewBill(Bill bill) throws BillException {
		Optional<Bill> opt = bDao.findById(bill.getBillId());
		Bill existingBill = null;
		if (opt.isPresent()) {

			existingBill = opt.get();

		} else {
			throw new BillException("No bill found by " + bill.getBillId() + " id");
		}

		return existingBill;
	}

	@Override
	public List<Bill> viewBills(Integer custId) throws BillException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bill> viewBills(LocalDate startDate, LocalDate endDate) throws BillException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculateTotalCost(Bill bill) throws BillException {
		// TODO Auto-generated method stub
		return 0;
	}

}
