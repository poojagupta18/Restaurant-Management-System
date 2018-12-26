package com.restaurants.details;

import java.util.ArrayList;

public class BookingDetails {
	
	private int billNo;
	ArrayList<Order> orderList = null;
	
	public BookingDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public BookingDetails(int billNo, ArrayList<Order> orderList) {
		this.billNo = billNo;
		this.orderList = orderList;
	}

	public int getBillNo() {
		return billNo;
	}
	
	public ArrayList<Order> getOrder() {
		return orderList;
	}

	
	public void setOrder(ArrayList<Order> orderList) {	
		this.orderList = orderList;
	}
	

    public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public ArrayList<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + billNo;
		result = prime * result + ((orderList == null) ? 0 : orderList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingDetails other = (BookingDetails) obj;
		if (billNo != other.billNo)
			return false;
		if (orderList == null) {
			if (other.orderList != null)
				return false;
		} else if (!orderList.equals(other.orderList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ""+ System.getProperty("line.separator")+ billNo +System.getProperty("line.separator") + orderList+System.getProperty("line.separator") ;
	}

	

	

	

	

	
}
