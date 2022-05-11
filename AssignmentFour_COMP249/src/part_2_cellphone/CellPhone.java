package part_2_cellphone;

import java.util.Scanner;
//---------------------------------------------------------------
//Assignment 4
//Part: 2
//COMP 249
//Written by: Gabriel D'Alesio (40208808)
//Due: Friday, April 15th, 2022
//---------------------------------------------------------------

/**
 * Class that contains variables and methods of the CellPhone class
 * 
 * @author Gabriel D'Alesio
 * @version 1.0
 */
public class CellPhone implements Cloneable {
	//Variable declaration
	private long serialNum;
	private String brand;
	private int year;
	private double price;
	
	Scanner sc = new Scanner(System.in);
	/**
	 * Parameterized constructor
	 * 
	 * @param serialNum Long representing the CellPhone's serial number
	 * @param brand	String representing the CellPhone's brand
	 * @param price	Double representing the CellPhone's price
	 * @param year	Int representing the CellPhone's year of production
	 */
	public CellPhone(long serialNum, String brand, double price, int year) {
		this.serialNum = serialNum;
		this.brand = brand;
		this.price = price;
		this.year = year;
	}
	/**
	 * Copy constructor
	 * 
	 * @param x	Object representing the CellPhone object
	 * @param serialNum	Long representing the CellPhone's serial number
	 */
	public CellPhone(CellPhone x, long serialNum) {
		this.serialNum = serialNum;
		brand = x.getBrand();
		year = x.getYear();
		price = x.getPrice();
	}
	/**
	 * Method that returns the serial number
	 * 
	 * @return Long representing serial number
	 */
	public long getSerial() {
		return serialNum;
	}
	/**
	 * Method that sets the CellPhone's serial number
	 * 
	 * @param newSerial Long representing the new serial number
	 */
	public void setSerial(long newSerial) {
		serialNum = newSerial;
	}
	/**
	 * Method that returns the CellPhone's brand
	 * 
	 * @return String representing CellPhone's brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * Method that sets the CellPhone's brand
	 * 
	 * @param newBrand String representing the new brand
	 */
	public void setBrand(String newBrand) {
		brand = newBrand;
		
	}
	/**
	 * Method that returns the CellPhone's year of production
	 * 
	 * @return Integer representing CellPhone's year of production
	 */
	public int getYear() {
		return year;
	}
	/**
	 * Method that sets the CellPhone's year of production
	 * 
	 * @param newYear Integer representing CellPhone's new year of production
	 */
	public void setYear(int newYear) {
		year = newYear;
	}
	/**
	 * Method that returns the price of the CellPhone
	 * 
	 * @return Double representing CellPhone's price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * Method that sets the CellPhone's price
	 * 
	 * @param newPrice Double representing CellPhone's new price
	 */
	public void setPrice(double newPrice) {
		price = newPrice;
	}
	/**
	 * Method that clones a CellPhone object
	 */
	public CellPhone clone() {
		
		try {
			System.out.println("Please enter a new serial number:");
			CellPhone c = (CellPhone) super.clone();
			c.setSerial(sc.nextLong());
			return c;
		}
		catch(CloneNotSupportedException e) {
			System.out.print("Cannot clone this cell phone. Clone not supported.");
			return null;
		}	
	}
	/**
	 * Method that displays information of CellPhone object
	 */
	public String toString() {
		return "This " + brand + " " + year + " has serial number " + serialNum + " and has a price of " + price;
	}
	/**
	 * Method that checks if two CellPhone objects are equal
	 */
	public boolean equals(Object x) {
		if(x == null || x.getClass() != this.getClass())
			return false;
		else {
			CellPhone p = (CellPhone) x;
			if(this.brand == p.getBrand() && this.price == p.getPrice() && this.year == p.getYear())
				return true;
		}
		return false;
	}

}
