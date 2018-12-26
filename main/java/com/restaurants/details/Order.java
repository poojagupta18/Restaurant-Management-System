package com.restaurants.details;

public class Order {

	private String bookedItemName;
	private double bookedItemPrice;
	private int quantity;
	private int orderNum;
	private double bookedTotalPrice;
	
	public Order() {
		
	}
	
	public Order(String bookedItemName, double bookedItemPrice, int quantity, int orderNum, double bookedTotalPrice) {
		this.bookedItemName = bookedItemName;
		this.bookedItemPrice = bookedItemPrice;
		this.quantity = quantity;
		this.orderNum = orderNum;
		this.bookedTotalPrice = bookedTotalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public  void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		
	}
	public String getBookedItemName() {
		return bookedItemName;
	}
	public void setBookedItemName(String bookedItemName) {
		this.bookedItemName = bookedItemName;
	}
	public double getBookedItemPrice() {
		return bookedItemPrice;
	}
	public void setBookedItemPrice(double bookedItemPrice) {
		this.bookedItemPrice = bookedItemPrice;
	}
	
	public double getBookedTotalPrice() {
		return bookedTotalPrice;
	}
	public void setBookedTotalPrice(double d) {
		this.bookedTotalPrice = d;
	}
	/*@Override
	public String toString() {
		return "\n bookedItemName=" + bookedItemName + "\n bookedItemPrice=" + bookedItemPrice + "\n Quantity="
				+ quantity + "\n BookedTotalPrice=" + bookedTotalPrice;
		return "    "+ bookedItemName+ "            " +  bookedItemPrice +"               "+ quantity +"             "+ bookedTotalPrice+System.getProperty("line.separator");
	}*/
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookedItemName == null) ? 0 : bookedItemName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(bookedItemPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(bookedTotalPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + orderNum;
		result = prime * result + quantity;
		return result;
	}
	
	@Override
	public String toString() {
		/*return "Order [bookedItemName=" + bookedItemName + ", bookedItemPrice=" + bookedItemPrice + ", quantity="
				+ quantity + ", orderNum=" + orderNum + ", bookedTotalPrice=" + bookedTotalPrice + "]";*/
		/*return " "+ System.getProperty("line.separator") + "bookedItemName: " +System.getProperty("line.separator")+ bookedItemName +System.getProperty("line.separator")+" bookedItemPrice: " + bookedItemPrice +System.getProperty("line.separator") +" quantity: "
		+ quantity + System.getProperty("line.separator")+"OrderNumber: " + orderNum + System.getProperty("line.separator")+"bookedTotalPrice: " + bookedTotalPrice + System.getProperty("line.separator");*/
		return ""+ bookedItemName + "                " + bookedItemPrice + "              "+ quantity + "       "+bookedTotalPrice + System.getProperty("line.separator");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (bookedItemName == null) {
			if (other.bookedItemName != null)
				return false;
		} else if (!bookedItemName.equals(other.bookedItemName))
			return false;
		if (Double.doubleToLongBits(bookedItemPrice) != Double.doubleToLongBits(other.bookedItemPrice))
			return false;
		if (Double.doubleToLongBits(bookedTotalPrice) != Double.doubleToLongBits(other.bookedTotalPrice))
			return false;
		if (orderNum != other.orderNum)
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	
}
