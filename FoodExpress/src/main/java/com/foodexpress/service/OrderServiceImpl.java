package com.foodexpress.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodexpress.exception.CartNotFoundException;
import com.foodexpress.exception.OrderException;
import com.foodexpress.model.Customer;
import com.foodexpress.model.CustomerSession;
import com.foodexpress.model.FoodCart;
import com.foodexpress.model.OrderDetails;
import com.foodexpress.model.Restaurants;
import com.foodexpress.repository.CartDao;
import com.foodexpress.repository.CustomerSessionDao;
import com.foodexpress.repository.OrderDao;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	public OrderDao oDao;

	@Autowired
	public CustomerSessionDao cSDao;

	@Autowired
	public CartDao cDao;

	// place your order
	@Override
	public OrderDetails addOrder(Integer cartId, String uniqueId) {

		CustomerSession cs = cSDao.findByUniqueId(uniqueId);
		if (cs != null) {
			FoodCart foodCart = cDao.findByCustumerId(cs.getCustomerId());
			if (foodCart != null) {
				OrderDetails od = new OrderDetails();
				od.setOrderDate(LocalDateTime.now());
				od.setOrderStatus("Placed");
				od.setCart(foodCart);
				oDao.save(od);
				return od;

			} else {
				throw new CartNotFoundException("No item found in your cart");
			}
		} else {
			throw new OrderException("customer is not logged in");
		}

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
