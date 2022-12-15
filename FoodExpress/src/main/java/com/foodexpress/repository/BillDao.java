package com.foodexpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodexpress.model.Bill;

public interface BillDao extends JpaRepository<Bill, Integer> {

}
