package com.restaurants.management;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import com.restaurants.food.Food;

public class MenuManagement {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * Check whether the list passed as paramenter is null or not if not null calls the printAllItem method.
	 * @param startersList
	 * @param mainCourseList
	 * @param riceList
	 * @param dessertList
	 */
	public void displayMenu(  ArrayList<Food> startersList, ArrayList<Food> mainCourseList, ArrayList<Food> riceList, ArrayList<Food> dessertList) {

		if(startersList != null) {

			System.out.println("1.Starters\n");
			printAllItems(startersList);
			
		}
		if(mainCourseList != null) {

			System.out.println("2.Main Course\n");
			printAllItems(mainCourseList);

		}

		if(riceList != null) {

			System.out.println("3.Rice\n");
			printAllItems(riceList);
		}

		if(dessertList != null) {

			System.out.println("4.Desserts\n");
			printAllItems(dessertList);

		}

	}


	/**
	 * prints the item name and price present in List
	 * @param List
	 */
	public void printAllItems( ArrayList<Food> List)
	{
		int i = 1;
		System.out.println("Item Name"+"\t\tPrice\n----------------------------------------");
		for(Food type : List) {

			System.out.print(i + ".");
			System.out.println(type);
			i++;
		}
		System.out.println("\n");
	}

	
	/**
	 * check whether newItem is present in list or not, if not present then add it in the ArrayList
	 * @param list
	 * @param newItem
	 */
	public void createMenu(ArrayList<Food> list,Food newItem) {
		
		boolean check = false;
		for (Food item: list) {
		    // Now you have the product. Just get the Id
		    if (newItem.getItemName().equals(item.getItemName())) {
	            System.out.println(newItem.getItemName()+ " is already present in Menu");
	            check = true;
		    }
		}
		
		if(!check) {
			
			list.add(newItem);
		}
	}

	/**
	 * Check whether the food item number is present in that food category or not
	 * @param startersList
	 * @param mainCourseList
	 * @param dessertList
	 * @param riceList
	 * @param foodTypeNum
	 * @param itemNumber
	 * @return
	 */
	public boolean checkPresenceOfFoodTypeNumber(ArrayList<Food>startersList,ArrayList<Food>mainCourseList,ArrayList<Food>dessertList,ArrayList<Food>riceList,int foodTypeNum,int itemNumber) {
		
		if(foodTypeNum == 1) {
			
			if(itemNumber > startersList.size()) {
				System.out.println("Invalid Food Item number");
				return false;
					}
				
		}else if(foodTypeNum == 2) {
			
			if(itemNumber > mainCourseList.size()) {
				System.out.println("Invalid Food Item number");
				return false;
			}
			
		}else if(foodTypeNum == 3) {
			
			if(itemNumber > riceList.size()) {
				System.out.println("Invalid Food Item number");
				return false;
			}
				
		}else if(foodTypeNum == 4) {
			
			if(itemNumber > dessertList.size()) {
				System.out.println("Invalid Food Item number");
				return false;
			}
		}else {
			System.out.println("Invalid Food type entered...");
			return false;
		}
		return true;

	}
	
	
	/**
	 * Checks whether the inputted string is parsable int or not
	 * @param string
	 * @return
	 */
	public boolean isInteger(String string){
	    try {
	        Integer.valueOf(string);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	
	
}
