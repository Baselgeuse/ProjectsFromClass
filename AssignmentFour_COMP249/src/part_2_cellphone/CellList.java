package part_2_cellphone;

import java.util.NoSuchElementException;

//---------------------------------------------------------------
//Assignment 4
//Part: 2
//COMP 249
//Written by: Gabriel D'Alesio (40208808)
//Due: Friday, April 15th, 2022
//---------------------------------------------------------------

/**
 * Class that contains methods and variables of CellList
 * 
 * @author Gabriel D'Alesio
 * @version 1.0
 */
public class CellList {
	/**
	 * Class that contains methods and variables of CellNode
	 * 
	 * @author Gabriel D'Alesio
	 *
	 */
	private class CellNode {
		
		private CellPhone c;
		private CellNode next;
		/**
		 * Default constructor
		 */
		public CellNode() {
			c = null;
			next = null;
		}
		/**
		 * Parameterized constructor
		 * 
		 * @param c Object of type CellPhone
		 * @param next Object of type CellNode
		 */
		public CellNode(CellPhone c, CellNode next) {
			this.c = c;
			this.next = next;
		}
		/**
		 * Copy constructor
		 * 
		 * @param x Object of type CellNode
		 */
		public CellNode(CellNode x) {
			c = x.getCell();
			next = x.getNext();
		}
		/**
		 * Method that clones a CellNode
		 */
		public CellNode clone() {
			return new CellNode(this);
		}
		/**
		 * Method that returns the CellPhone
		 * 
		 * @return Object representing CellPhone
		 */
		public CellPhone getCell() {
			return c;
		}
		/**
		 * Method that sets the CellPhone
		 * 
		 * @param newC Object representing new CellPhone
		 */
		public void setCell(CellPhone newC) {
			c = newC;
		}
		/**
		 * Method that sets the CellNode
		 * 
		 * @param newC Object representing new CellNode
		 */
		public CellNode getNext() {
			return next;
		}
		/**
		 * Method that sets the CellNode
		 * 
		 * @param newC Object representing new CellNode
		 */
		public void setNext(CellNode newNext) {
			next = newNext;
		}
	}
	
	private CellNode head;
	private int size = 0;
	/**
	 * Default constructor
	 */
	public CellList() {
		head = null;
		size = 0;
	}
	/**
	 * Copy constructor
	 * 
	 * @param x Object of type CellList
	 */
	public CellList(CellList x) {
		head = x.getHead();
		size = x.getSize();
	}
	/**
	 * Method that returns the head of the list
	 * 
	 * @return Object that represents head of the list
	 */
	public CellNode getHead() {
		return head;
	}
	/**
	 * Method that returns size of the CellList (number of nodes)
	 * 
	 * @return Integer representing the size of the CellList
	 */
	public int getSize() {
		if(head == null)
			return 0;
		else {
			int count = 0;
			CellNode t = head;
			while(t.next != null) {
			count++;
			t = t.next;
			}
		return count;
		}
	}
	/**
	 * Method that adds a CellPhone to the start of the CellList
	 * 
	 * @param c Object of type CellPhone
	 */
	public void addToStart(CellPhone c) {
		head = new CellNode(c, head);
		size++;
	}
	/**
	 * Method that inserts a CellPhone at a specific location
	 * 
	 * @param c	Object of type CellPhone
	 * @param x Integer representing location
	 * @return boolean that indicates if the CellPhone was added successfully
	 * @throws NoSuchElementException
	 */
	public boolean insertAtIndex(CellPhone c, int x) throws NoSuchElementException {
		if(x < 0 || x > (size - 1)) 
			throw new NoSuchElementException("Index could not be found.");
		else {
			if(head == null)
				return false;
			else {
				CellNode t = head;
				int count = 0;
				while(count != x) {
					count++;
					t = t.next;
				}
				t.next = new CellNode(c, t.next);
				size++;
				return true;
			}
		}
	}
	/**
	 * Method that removes a CellPhone at a specific location
	 * 
	 * @param x	Integer representing location
	 * @throws NoSuchElementException
	 */
	public void deleteFromIndex(int x) throws NoSuchElementException {
		if(x < 0 || x > (size - 1)) 
			throw new NoSuchElementException("Index could not be found");
		else {
			if(x == 0) {
				deleteFromStart();
			}
			else {
				CellNode t = head;
				for(int i = 1; i < x; i++) {
					if(t.next != null)
						t = t.next;
				}
				t.next = t.next.next;
				size--;
			}
		}
	}
	/**
	 * Method that removes the first CellPhone in the CellList
	 * 
	 * @return Boolean that indicates if removal was successful
	 */
	public boolean deleteFromStart() {
		if(head == null) // Handles special case if there is no head to begin with
			return false;
		else {
			head = head.next;
			size--;
		}
		return true;
	}
	/**
	 * Method that replaces a CellPhone with an inputed CellPhone at a specific location
	 * 
	 * @param c	Object of type CellPhone
	 * @param x	Integer representing location
	 */
	public void replaceAtIndex(CellPhone c, int x) {
		if(x < 0 || x > (size - 1)) 
			return;
		else {
			CellNode t = head;
			int count = 0;
			while(count != x) {
				count++;
				t = t.next;
			}
			t.c = c;
		}	
	}
	/**
	 * Method that finds the location of an inputted serial number. This method has the capacity to cause a privacy leak since
	 * it is returning a pointer directly connected to the linked list, and as such leaves the program vulnerable to be manipulated.
	 * To avoid this, the method was made private.
	 * 
	 * @param serial Long representing desired serial number
	 * @return Pointer of CellNode containing desired serial number
	 */
	private CellNode Find(long serial) {
		int count = 1;
		CellNode t = head;
		while(t != null) {
			if(t.c.getSerial() == serial) {
				break;
			}
			else
				count++;
				t = t.next;
		}
		if(count == 27) {
			System.out.print("\nThe serial number " + serial + " was not found.");
		}
		else {
			System.out.print("\nThe serial number " + serial + " was found after " + count + " iterations.");
		}
		return t;
	}
	/**
	 * Method that indicates if a specific serial number is found inside the CellList
	 * 
	 * @param serial Long representing desired serial number
	 * @return Boolean indicating if serial number was found
	 */
	public boolean contains(long serial) {
		if(Find(serial) == null)
			return false;
		return true;
	}
	/**
	 * Method that checks if two CellList objects are the same
	 * 
	 * @param x	Object of type CellList
	 * @return Boolean indicating if two objects are equal
	 */
	public boolean equals(CellList x) {
		CellNode t1 = this.head;
		CellNode t2 = x.head;
		while(t1 != null) {
			if(t1.c.equals(t2.c) == false)
				return false;
			t1 = t1.next;
			t2 = t2.next;
		}
		return true;
	}
	/**
	 * Method that displays the contents of a CellList
	 * 
	 * @return String representing end of CellList
	 */
	public String showContents() {
		System.out.println("The current size of the list is: " + size + ". Here on the contents of the list."
				+ "\n==============================================================================================");
		CellNode t = head;
		while(t != null) {
			System.out.println("[" + t.c.getSerial() + ", " + t.c.getBrand() + ", " + t.c.getPrice() + ", " + t.c.getYear() + "] ---> ");
			t = t.next;
		}
		System.out.print("X");
		return("X");
	}
}
