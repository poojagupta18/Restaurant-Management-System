package com.restaurants.filewriting;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;

import com.restaurants.details.BookingDetails;
import com.restaurants.details.Customer;

public class FileOperation {

	/**
	 * Writes the bill details in the file. It will create one file per customer.
	 * @param list
	 * @param customer
	 * @param TotalPrice
	 * @param fName
	 * @return
	 */
	public int fileWrite(ArrayList<BookingDetails> list, Customer customer, double TotalPrice, String fName ) {
		
		String fileName = fName+".txt";
		File file = new File(fileName);
		try {
	
			FileWriter fileWriter = new FileWriter(file);
			Writer output = new BufferedWriter(fileWriter);
			int size = list.size();
			output.write(customer.toString()+System.getProperty("line.separator"));
			output.write("-------------------------------------------------------" + System.getProperty("line.separator"));
			output.write("Sr No  bookedItemName     bookedItemPrice      Quantity      BookedTotalPrice"+System.getProperty("line.separator"));

			for(int i = 0; i < size;i++) {
				output.write(list.get(i).toString()+System.getProperty("line.separator"));
				
			}
			output.write("Total Price: " +  TotalPrice);
			output.close();
			System.out.println("end");
			return 1;
		}catch(Exception e) {
			e.getMessage();
		}
		
		return 0;
		
	}
}
