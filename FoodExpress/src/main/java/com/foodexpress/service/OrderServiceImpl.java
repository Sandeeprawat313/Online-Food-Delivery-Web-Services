package com.foodexpress.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodexpress.exception.OrderException;
import com.foodexpress.model.Customer;
import com.foodexpress.model.OrderDetails;
import com.foodexpress.model.Restaurants;
import com.foodexpress.repository.OrderDao;

public class OrderServiceImpl implements OrderService {

	@Autowired
	public OrderDao oDao;

	@Override
	public OrderDetails addOrder(OrderDetails order) throws OrderException {
		OrderDetails savedOrder = oDao.save(order);

		return savedOrder;

	}

	@Override
	public OrderDetails removeOrder(OrderDetails order) throws OrderException {
		Optional<OrderDetails> opt = oDao.findById(order.getOrderId());

		if (opt.isPresent()) {
			oDao.delete(opt.get());

		} else {
			throw new OrderException("No order found by this order " + order.getOrderId() + " id");
		}

		return order;
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order) throws OrderException {
		Optional<OrderDetails> opt = oDao.findById(order.getOrderId());
		OrderDetails updatedOrder = null;
		if (opt.isPresent()) {
			updatedOrder = oDao.save(opt.get());

		} else {
			throw new OrderException("No order found by this order " + order.getOrderId() + " id");
		}

		return updatedOrder;
	}

	@Override
	public OrderDetails viewOrder(OrderDetails order) throws OrderException {
		Optional<OrderDetails> opt = oDao.findById(order.getOrderId());
		OrderDetails exitstingOrder = null;
		if (opt.isPresent()) {
			exitstingOrder = opt.get();

		} else {
			throw new OrderException("No order found by this order " + order.getOrderId() + " id");
		}

		return exitstingOrder;
	}

	@Override
	public List<OrderDetails> viewAllOrders(Restaurants res) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetails> viewAllOrders(Customer customer) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

}
