package com.foodexpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodexpress.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>
{

}
