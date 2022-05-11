package DriverAndClasses;
import java.util.Scanner;

//---------------------------------------------------------------
//Assignment 1
//Part: 2
//COMP 249
//Written by: Liam Daigle (40207583), Gabriel D'Alesio(40208808)
//Due: Monday, February 7th 2022
//---------------------------------------------------------------
public class Main {

	public static void main(String[] args) {
		
		//Creating a Scanner object
		Scanner keyboard = new Scanner(System.in);
		
		//Asking user to input number of players (between 2 and 4) and storing that value in the variable playerCount
		System.out.println("Please enter number of players between 2 and 4 inclusive (4 attempts remaining)");
		int playerCount = keyboard.nextInt();
		
		//Variable representing the number of attempts made to enter number of players
		int attempts = 1;
		
		//while loop controlling user's who inputed an incorrect number of players
		while(playerCount < 2 || playerCount > 4) {
			
			//if statement that exits the program if the user inputed an incorrect number 4 times.
			if(attempts == 4) {
				System.out.println("Maximum attempts reached, terminating program...");
				System.exit(0);
			}
			
			//Attempting to enter proper input
			System.out.println("Incorrect input, please enter number of players between 2 and 4 inclusive (" + (4 - attempts) +" attemps remaining)");
			playerCount = keyboard.nextInt();
			attempts++;
		}
		

		
		//Initializing the Snakes and Ladders game with a specified player count
		LadderAndSnake game = new LadderAndSnake(playerCount);
		
		//Starting the game
		game.play();
		
		//Closing scanner object
		keyboard.close();
	}

}
