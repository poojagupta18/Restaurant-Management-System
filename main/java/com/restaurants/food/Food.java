package com.restaurants.food;

public abstract class Food {

	private String itemName;
	private double price;
	
	
	public String getItemName() {
		return itemName;
	}



	public void setItemName(String itemName) {
		this.itemName = itemName;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public String toString() {
		return this.getItemName() +"\t\t"+ this.getPrice();
	}
}
