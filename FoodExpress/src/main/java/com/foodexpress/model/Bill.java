package com.foodexpress.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Bill {

	@Id
	private Integer billId;
	private LocalDateTime billDate;
	private double totalCost;
	private Integer totalItem;

	@OneToOne(cascade = CascadeType.ALL)
	private OrderDetails order;

	public Bill() {
		// TODO Auto-generated constructor stub
	}

	public Bill(Integer billId, LocalDateTime billDate, double totalCost, Integer totalItem, OrderDetails order) {
		super();
		this.billId = billId;
		this.billDate = billDate;
		this.totalCost = totalCost;
		this.totalItem = totalItem;
		this.order = order;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public LocalDateTime getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDateTime billDate) {
		this.billDate = billDate;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public Integer getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}

	public OrderDetails getOrder() {
		return order;
	}

	public void setOrder(OrderDetails order) {
		this.order = order;
	}

}
