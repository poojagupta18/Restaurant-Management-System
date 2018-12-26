package com.restaurants.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import com.restaurants.details.Customer;
import com.restaurants.details.Order;
import com.restaurants.food.Food;
import com.restaurants.foodcategories.Dessert;
import com.restaurants.foodcategories.MainCourse;
import com.restaurants.foodcategories.Rice;
import com.restaurants.foodcategories.Starters;
import com.restaurants.management.BillManagement;
import com.restaurants.management.MenuManagement;
import com.restaurants.management.OrderManagement;

public class Test {

	public static void main(String[] args) throws IOException  {

		BufferedReader input = new BufferedReader ( new InputStreamReader( System.in ) );

		ArrayList<Food> startersList = new ArrayList<Food>();
		ArrayList<Order> orderList = null;

		//Initially 2 items are present in the each food categories.
		
		startersList.add(new Starters("Manchurian ", 110.0));
		startersList.add(new Starters("Kebab ", 165.0));

		ArrayList<Food> dessertList = new ArrayList<Food>();

		dessertList.add(new Dessert("Ice-cream ", 70.0));
		dessertList.add(new Dessert("Custurd", 100.0));

		ArrayList<Food> mainCourseList = new ArrayList<Food>();

		mainCourseList.add(new MainCourse("Spinach dal", 170.0));
		mainCourseList.add(new MainCourse("panner tikka",200.0));


		ArrayList<Food> RiceList = new ArrayList<Food>();

		RiceList.add(new Rice("Veg pulav", 160.0));
		RiceList.add(new Rice("Fried Rice", 160.0));

		MenuManagement management = new MenuManagement();
		OrderManagement orderManagement = new OrderManagement();
		BillManagement billManagement = new BillManagement();
		Customer customer = new Customer();
		int orderNumber = 0;
		double price;
		int choice;
		int choiceOfFoodCategory;
		String inputString;

			while(true) {

				System.out.println("1.Create Menu\n2.Order Food\n3.Print Bill\n4.Exit");
				while(true) {
						System.out.println("Enter your choice:");
						inputString = input.readLine();

						if(management.isInteger(inputString)) {
							choice = Integer.parseInt(inputString);
							break;
						}else {
							System.out.println("Invalid choice...Choice can not be consist of string...");
						}

				}
				
				
				switch(choice) {
				case 1:

					System.out.println("Enter Item name:");
					String itemName = input.readLine();
					while(true) {

						System.out.println("Enter price");
						try {
							price = Double.parseDouble(input.readLine());
							if(price > 0)
								break;
							else {
								System.out.println("Invalid price...Price can't be negative or zero");
							}
						}catch(NumberFormatException e) {
							
							System.out.println("Price value can not be of type string....");
						}catch(IOException e) {
							
							System.out.println(e.getMessage());
						}
					}

					System.out.println("Food Categories\n1.Starter\n2.MainCourse\n3.Rice\n4.Dessert");
					
					while(true) {
						
						System.out.println("Please Choose in which category would you like to add: ");
						inputString = input.readLine();
						
						if(management.isInteger(inputString)) {
							choiceOfFoodCategory = Integer.parseInt(input.readLine());
							break;
						}else {
							System.out.println("Choice of food category can not be of type string...");

						}
					}
					
					switch(choiceOfFoodCategory) {

					case 1: 
						Starters starter = new Starters(itemName, price);
						management.createMenu(startersList, starter);

						break;
					case 2:

						MainCourse mainCourse = new MainCourse(itemName, price);
						management.createMenu(mainCourseList, mainCourse);

						break;
					case 3:

						Rice rice = new Rice(itemName, price);
						management.createMenu(RiceList, rice);

						break;
					case 4:

						Dessert dessert = new Dessert(itemName, price);
						management.createMenu(dessertList, dessert);

						break;
					default :
						System.out.println("Invalid choice...No food category exist for your entered choice.");
					}

					break;


				case 2:
					management.displayMenu(startersList, mainCourseList, RiceList, dessertList);
					++orderNumber;
					int orderTimes = 0;
					int ans = 0;
					int quantity = 0;
					int itemNumber = 0;
					int foodTypeNum =0;
					do {

						orderList= new ArrayList<Order>();

						while(true) {
							System.out.println("Choose the food category");
							inputString = input.readLine();

							if(management.isInteger(inputString)) {
								foodTypeNum = Integer.parseInt(inputString);

								if(foodTypeNum == 1 || foodTypeNum == 2 || foodTypeNum == 3 || foodTypeNum == 4)
									break;
								else
									System.out.println("Food category number you have entered is not present in Menu...");
							}else
								System.out.println("Invalid food item category number. Food category number can not be String or alphanumeric...");

						}


						while(true) {
							System.out.println("Choose the food item number");
							inputString = input.readLine();
							if(management.isInteger(inputString)) {
								itemNumber = Integer.parseInt(inputString);

								if(itemNumber > 0 &&  management.checkPresenceOfFoodTypeNumber(startersList,mainCourseList,dessertList,RiceList,foodTypeNum,itemNumber)) {
									break;
								}
								else {
									System.out.println("Item Number you entered is either negative or not present in Menu...");
								}
							}else
								System.out.println("Invalid food item number. Food item number can not be String or alphanumeric...");

						}

						while(true) {
							System.out.println("Enter the Quantity");
							inputString = input.readLine();
							if(management.isInteger(inputString)) {
								quantity = Integer.parseInt(inputString);
								if(quantity > 0)
									break;
								else 
									System.out.println("Quantity can't be zero or negative...");

							}

							else
								System.out.println("Invalid Quantity entered. Quantity can not be String or alphanumeric... ");
						}


						switch(foodTypeNum) {
						case 1:
							orderList = orderManagement.selectOrder(startersList, itemNumber, quantity, orderNumber);

							break;
						case 2:
							orderList = orderManagement.selectOrder(mainCourseList, itemNumber, quantity, orderNumber);


							break;
						case 3:
							orderList = orderManagement.selectOrder(RiceList, itemNumber, quantity, orderNumber);

							break;
						case 4:
							orderList = orderManagement.selectOrder(dessertList, itemNumber, quantity, orderNumber);

							break;

						default:
							System.out.println("Invalid choice...Choice number that you have entered is not present in Menu List.");

						}
						orderTimes = orderTimes+1;
						
						while(true) {
							System.out.println("Would you like to order more? Press 1 for 'Yes'/ 0 for 'No'");
							inputString = input.readLine();
							if(management.isInteger(inputString)) {
								ans = Integer.parseInt(inputString);
								break;
								}else {
									System.out.println("Wrong choice entered...");
								}
							}
						}while(ans != 0);

					System.out.println("Enter the customer Name");
					String customerName = input.readLine();
					System.out.println("Enter contact number");
					String contactNumber = input.readLine();
					customer = orderManagement.bookOrder(customerName, contactNumber);
					billManagement.setBillDetails(customer, orderList,orderTimes);

					break;

				case 3:
					System.out.println("Enter the customer Name:");
					customerName =  input.readLine();
					System.out.println("Enter the customer contact number:");
					contactNumber = input.readLine();
					customer = orderManagement.bookOrder(customerName, contactNumber);
					billManagement.displayBill(customer);
					break;

				case 4:
					System.exit(0);
				default:
					System.out.println("Invalid choice...");

				}		
			}	
	}

}
