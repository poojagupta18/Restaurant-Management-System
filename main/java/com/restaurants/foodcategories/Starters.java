package com.restaurants.foodcategories;

import com.restaurants.food.Food;

public class Starters extends Food {
	
	public Starters(String itemName, double price) {
		
		setItemName(itemName);
		setPrice(price);
	}

	//Starters can have add-ons eg. with soup one can take toast or dry noodles.
	public void addOns() {
		
	}


}
