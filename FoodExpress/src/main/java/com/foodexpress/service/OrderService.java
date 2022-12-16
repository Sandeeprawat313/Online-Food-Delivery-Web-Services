package com.foodexpress.service;

import java.util.List;

import com.foodexpress.exception.OrderException;
import com.foodexpress.model.Customer;
import com.foodexpress.model.OrderDetails;
import com.foodexpress.model.Restaurants;

public interface OrderService {
	public OrderDetails addOrder(OrderDetails order) throws OrderException;

	public OrderDetails removeOrder(OrderDetails order) throws OrderException;

	public OrderDetails updateOrder(OrderDetails order) throws OrderException;

	public OrderDetails viewOrder(OrderDetails order) throws OrderException;

	public List<OrderDetails> viewAllOrders(Restaurants res) throws OrderException;

	public List<OrderDetails> viewAllOrders(Customer customer) throws OrderException;

}
