package DriverAndClasses;
//---------------------------------------------------------------
//Assignment 1
//Part: 2
//COMP 249
//Written by: Liam Daigle (40207583), Gabriel D'Alesio(40208808)
//Due: Monday, February 7th 2022
//---------------------------------------------------------------
/**
 * Class that represents the players in the snakes and ladders game
 * 
 * @author Liam Daigle, Gabe D'Alesio
 * @version 1.0
 *
 */
public class Player {

	private int row = 0, column = 0; 			//int variables representing the row and column the player is currently on respectively
	String name;								//String variable representing the player's name
	boolean startingMove = true;				//boolean variable indicating whether its a player's first move
	
	/**
	 * Default Constructor.
	 */
	public Player() {
		
	}
	
	/**
	 * Paramaterized Constructor.
	 * 
	 * @param name String representing the player's name.
	 */
	public Player(String name) {
		
		this.name = name;
	}
	
	/**
	 * Method that sets a player's row on the Snakes and Ladders board.
	 * 
	 * @param r Integer value representing the current row of the player
	 */
	public void setRow(int r) {
		row = r;
	}
	/**
	 * Method that sets a player's column on the Snakes and Ladders board
	 * 
	 * @param c Integer value representing the current column of the player
	 */
	public void setColumn(int c) {
		column = c;
	}
	/**
	 * Method that retrieves the row of the Player
	 * 
	 * @return int value representing the Player's current row
	 */
	public int getRow() {
		return row;
	}
	/**
	 * Method that retrieves the column of the Player
	 * 
	 * @return int value representing the Player's current column
	 */
	public int getColumn() {
		return column;
	}
	/**
	 * Method that changes the boolean state of a player's starting move
	 * 
	 * @param b boolean value representing if it is a player's starting move (true) or not (false)
	 */
	public void setStartingMove(boolean b) {
		startingMove = b;
	}
	/**
	 * Method that retrieves whether or not the player is on his starting move
	 * 
	 * @return boolean value indicating whether it is the player's first/starting move
	 */
	public boolean getStartingMove() {
		return startingMove;
	}
	/**
	 * Method that returns the name of the player
	 * 
	 * @return String value that represents the name of the player
	 */
	public String getName() {
		return name;
	}

}
