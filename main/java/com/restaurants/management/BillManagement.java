package com.restaurants.management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import com.restaurants.details.BookingDetails;
import com.restaurants.details.Customer;
import com.restaurants.details.Order;
import com.restaurants.filewriting.FileOperation;

public class BillManagement {

	static int i = 0 ;
	
	//To store customers and his all booking details, hashMap is used.
	public HashMap<Customer, ArrayList<BookingDetails>> hashMap =   new HashMap<Customer, ArrayList<BookingDetails>>(); 
	
	//To keep the track of visiting customers set is used.
	public Set<Customer> alreadyVisited = new HashSet<Customer>(); 
	
    FileOperation writeInFile = new FileOperation();
    
    //To provide discount of 20% 
    final double discoutRate = 0.2;

	/**
	 * set the billing details like bill number, orderlist
	 * @param customer
	 * @param order
	 * @param orderTimes
	 */
	public void setBillDetails(Customer customer,ArrayList<Order> order, int orderTimes) {

		ArrayList<BookingDetails> bill = new ArrayList<BookingDetails>();		
		ArrayList<Order> arrayOfOrder = new ArrayList<Order>();


		if (order.size() >= orderTimes) 
		{

			for(int i =1; i<=orderTimes; i++){

				arrayOfOrder.add(order.get(order.size()-i)); 

			}
		}
		BookingDetails bookingDetails = new BookingDetails();

		bookingDetails.setBillNo(++i);
		bookingDetails.setOrder(arrayOfOrder);
		bill.add(bookingDetails);

		if(!hashMap.containsKey(customer))
		{
			hashMap.put(customer, bill);
			return;
		}
		else if(hashMap.containsKey(customer))
		{
			ArrayList<BookingDetails>list=hashMap.get(customer);
			list.addAll(bill);
			hashMap.put(customer,list);

		}

	}

	/**
	 * checks whether customer has already visited or not, 20% discount will be provided to the customers which are 
	 * going to visit Restaurant for the 1st time. Also displayBill method writes the bill in the file.
	 * @param customer
	 */
	public void displayBill(Customer customer) {


		double total = 0;
		if(hashMap.containsKey(customer)) {

			if(alreadyVisited.contains(customer)) {

				ArrayList<Order> orderlist1 = new ArrayList<Order>();
				total = 0;
				System.out.println("New customer");
				ArrayList<BookingDetails>list = hashMap.get(customer);
				for(BookingDetails detail: list) {
					orderlist1 = detail.getOrderList();
					
					for(Order order: orderlist1) {
						
						total = total + order.getBookedTotalPrice();
						
					}
				}
				
				System.out.println("Total = " + total);
				writeInFile.fileWrite(list, customer, total, customer.getCustomerName() + customer.getContactNumber());
				list.removeAll(list);   //Once bill is printed and written to the file clear all the booking details. 

			}


			else {
				ArrayList<Order> orderlist1 = new ArrayList<Order>();
				total = 0;
				System.out.println("new customer");
				ArrayList<BookingDetails>list = hashMap.get(customer);
				
				for(BookingDetails detail: list) {
					
					orderlist1 = detail.getOrderList();
					
					for(Order order: orderlist1) {
						
						total = total + order.getBookedTotalPrice();
						
					}
				}
				total = total - discoutRate * total;
				System.out.println("Total bill including 20% discount = " + total);
				writeInFile.fileWrite(list, customer, total, customer.getCustomerName()+customer.getContactNumber());
				alreadyVisited.add(customer);
				list.removeAll(list); //Once bill is printed and written to the file clear all the booking details. 

			
			}


		}else {
			System.out.println("No such Customer found...");
		}

	}



}
