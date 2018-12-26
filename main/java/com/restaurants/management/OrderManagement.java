package com.restaurants.management;

import java.util.ArrayList;
import com.restaurants.details.Customer;
import com.restaurants.details.Order;
import com.restaurants.food.Food;

public class OrderManagement {

	 public ArrayList<Order> orderList = new ArrayList<Order>();

	 
	 Order order;
	 Customer customer;

	/**
	 * It sets the order details like item name, price, quantity, order number in order object and put it in orderlist. 
	 * @param list
	 * @param itemNum
	 * @param quantity
	 * @param orderNumber
	 * @return
	 */
	public ArrayList<Order> selectOrder(ArrayList<Food> list, int itemNum, int quantity, int orderNumber){
		

		order = new Order();
		order.setOrderNum( orderNumber );
		order.setBookedItemName(list.get(itemNum-1).getItemName());
		order.setBookedItemPrice(list.get(itemNum-1).getPrice());
		order.setQuantity(quantity);
		order.setBookedTotalPrice(list.get(itemNum-1).getPrice()*quantity);
		orderList.add(order);
		return orderList;
		
	}
	

	/**
	 * set the customer details to book the order.
	 * @param customerName
	 * @param contactNumber
	 * @return
	 */
	public Customer bookOrder(String customerName, String contactNumber) {
		
			customer = new Customer();
			customer.setCustomerName(customerName);
			customer.setContactNumber(contactNumber);
			return customer;
		
	}
	
	
	
}
