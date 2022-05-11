package part_2_cellphone;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

//---------------------------------------------------------------
//Assignment 4
//Part: 2
//COMP 249
//Written by: Gabriel D'Alesio (40208808)
//Due: Friday, April 15th, 2022
//---------------------------------------------------------------

// This program will display a list for the user to choose what action they would like to execute on the Cellphone record.
// All of these choices were designed in the CellList class and are executed through linked lists.

public class CellListUtilization {

	public static void main(String[] args) {
		// Variable declaration
		CellList L1 = new CellList();
		CellList L2 = new CellList();
		Scanner sc = null;
		Scanner sc1 = new Scanner(System.in);
		boolean exitLoop = false;
		// Opens scanner in Cell_Info.txt
		try {
			sc = new Scanner(new FileInputStream("Cell_Info.txt"));
		}
		catch(FileNotFoundException e) {
			System.out.print("File not found. Terminating program.");
			System.exit(0);
		}
		// Adds contents of Cell_Info.txt to List 1 and List 2
		while(sc.hasNextLine()) {
			CellPhone c = new CellPhone(sc.nextLong(), sc.next(), sc.nextDouble(), sc.nextInt());
			L1.addToStart(c);
			L2.addToStart(c);
		}
		// Displays contents of List 1
		L1.showContents();
		
		System.out.print("\n\nHere is the CellPhone Record Menu."
				+ "\n\t1. Insert a CellPhone's information."
				+ "\n\t2. Delete a CellPhone's information."
				+ "\n\t3. Add a CellPhone to the beginning of the list."
				+ "\n\t4. Delete a CellPhone from the beginning of the list."
				+ "\n\t5. Replace a CellPhone's information for another."
				+ "\n\t6. Verify if a CellPhone's serial number is present."
				+ "\n\t7. Check to see if two lists are equal."
				+ "\n\t8. Exit the program.");
		// Loop that repeats until exitLoop == true
		while(exitLoop == false) {
		
		System.out.println("\n\nWhat would you like to do? (1-8)");
		
		int choice = sc1.nextInt();
		// Switch state allowing user to choose what option they would like to pick from the menu
		switch(choice) {
		// Case allowing user to insert CellPhone in List 1 or List 2
		case 1: {
			System.out.println("\nPlease enter a serial number, a brand, a price and a year of production for a new cellphone, followed by the list you want to add it to (L1/L2) and the position you want it in.");
			CellPhone c1 = new CellPhone(sc1.nextLong(), sc1.next(), sc1.nextDouble(), sc1.nextInt());
			if(sc1.next() == "L1") {
				try {
				L1.insertAtIndex(c1, sc1.nextInt());
				System.out.println("\nHere is the new list!");
				L1.showContents();
				}
				catch(NoSuchElementException e) {
					String s = e.getLocalizedMessage();
					System.out.print(s);
				}
			}
			else {
				try {
				L2.insertAtIndex(c1, sc1.nextInt());
				System.out.println("\nHere is the new list!");
				L2.showContents();
				}
				catch(NoSuchElementException e) {
					String s = e.getLocalizedMessage();
					System.out.print(s);
				}
			}
		} break;
		// Case allowing allowing user to remove CellPhone in List 1 or List 2
		case 2: {
			System.out.println("\nPlease enter the position of the CellPhone you would like to remove and the list you want it removed from (L1/L2):");
			int deleted = sc1.nextInt();
			if(sc1.next() == "L1") {
				try {
				L1.deleteFromIndex(deleted);
				System.out.println("\nHere is the new list!");
				L1.showContents();
				}
				catch(NoSuchElementException e) {
					String s = e.getLocalizedMessage();
					System.out.print(s);
				}
			}
			else {
				try {
				L2.deleteFromIndex(deleted);
				System.out.println("\nHere is the new list!");
				L2.showContents();
				}
				catch(NoSuchElementException e) {
					String s = e.getLocalizedMessage();
					System.out.print(s);
				}
			}
		} break;
		// Case allowing user to add CellPhone to start of List 1 or List 2
		case 3: {
			System.out.println("\nPlease enter a serial number, a brand, a price and a year of production for a new cellphone and the list you want it added to (L1/L2).");
			CellPhone c2 = new CellPhone(sc1.nextLong(), sc1.next(), sc1.nextDouble(), sc1.nextInt());
			if(sc1.next() == "L1") {
				L1.addToStart(c2);
				System.out.println("\nHere is the new list!");
				L1.showContents();
			}
			else {
				L2.addToStart(c2);
				System.out.println("\nHere is the new list!");
				L2.showContents();
			}
		} break;
		// Case allowing user to remove CellPhone from start of List 1 or List 2
		case 4: {
			System.out.println("\nWhich list would you like to have it deleted from? (L1/L2)");
			if(sc1.next() == "L1") {
				L1.deleteFromStart();
				System.out.println("\nHere is the new list!");
				L1.showContents();
			}
			else {
				L2.deleteFromStart();
				System.out.println("\nHere is the new list!");
				L2.showContents();
			}
		} break;
		// Case allowing user to replace certain CellPhone object in List 1 or List 2
		case 5: {
			System.out.println("\nPlease enter a serial number, a brand, a price and a year of production for a new cellphone, followed by the list you want it replaced in and the location for it to replace.");
			CellPhone c3 = new CellPhone(sc1.nextLong(), sc1.next(), sc1.nextDouble(), sc1.nextInt());
			L1.replaceAtIndex(c3, sc1.nextInt());
			if(sc1.next() == "L1") {
				L1.replaceAtIndex(c3, sc1.nextInt());
				System.out.println("\nHere is the new list!");
				L1.showContents();
			}
			else {
				L2.replaceAtIndex(c3, sc1.nextInt());
				System.out.println("\nHere is the new list!");
				L2.showContents();
			}
		} break;
		// Case allowing user to check if certain CellPhones are located in List 1
		case 6: {
			System.out.println("\nPlease enter three (3) serial numbers to check if they are contained: ");
			long serial1 = sc1.nextLong();
			long serial2 = sc1.nextLong();
			long serial3 = sc1.nextLong();
			
			L1.contains(serial1);
			L1.contains(serial2);
			L1.contains(serial3);
			} break;
		// Case allowing user to check if List 1 or List 2 are the same
		case 7: {
			System.out.println("Checking if contents of List 1 and List 2 are the same...");
			if(L1.equals(L2) == true)
				System.out.print("Lists are the same.");
			else
				System.out.print("Lists are not the same.");
			} break;
		// Case allowing user to exit the program	
		case 8: {
			System.out.print("\nThank you for using our program! Terminating.");
			exitLoop = true;
		} break;
		// Case if user enters a bad value
		default: {
			System.out.print("Not an option!");
		}break;
		} // End of switch statement
	} // End of exitLoop
		sc.close();
		sc1.close();
	
	} // End of main method
} // End of CellListUtilization class
