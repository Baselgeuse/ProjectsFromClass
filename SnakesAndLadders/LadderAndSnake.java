package DriverAndClasses;
import java.util.Scanner;
//---------------------------------------------------------------
//Assignment 1
//Part: 2
//COMP 249
//Written by: Liam Daigle (40207583), Gabriel D'Alesio(40208808)
//Due: Monday, February 7th 2022
//---------------------------------------------------------------
/**
 * Class that simulates a snakes and ladders game in your console
 * 
 * @author Liam Daigle, Gabe D'Alesio
 * @version 1.0
 */
public class LadderAndSnake {
	
	
	private String[][] board = new String[10][10]; 			//board printed to the console that contains null everywhere that a player isn't
	private int [][] oneToOneHundred = new int[10][10]; 	//board used to keep track of what tile a player is on
	private int nbPlayers; 									//integer variable representing number of players
	private boolean win = false; 							//boolean variable representing whether a player has won
	private String winner = ""; 							//String variable representing the winner's name
	private Player[] playerList; 							//Array of Player instances that keeps track of all player's in the game
	
	/**
	 * Default Constructor that sets the number of players in the game
	 * to 2.
	 */
	public LadderAndSnake() {
		
		nbPlayers = 2;
	}
	/**
	 * Parameterized Constructor
	 * 
	 * @param n represents the number of players specified by user
	 */
	public LadderAndSnake(int n) {
		
		nbPlayers = n;
	}
	/**
	 * Method that sets the number of players to a certain integer.
	 * 
	 * @param n represents the number of players specified by user
	 */
	public void setNumberOfPlayers(int n) {
		nbPlayers = n;
	}
	/**
	 * Method that returns the number of players in the game.
	 * 
	 * @return an integer representing the number of players in the game
	 */
	public int getNumberOfPlayers() {
		return nbPlayers;
	}
	
	/**
	 * Method that flips a 6 sided dice.
	 * 
	 * @return a random integer number between 1 and 6
	 */
	public static int flipDice() {
		
		return (int)(Math.random() * 6 + 1);
	}
	
	/**
	 * Method that controls the game.
	 * 
	 */
	public void play() {
		
		//Initializing scanner object and playerList array
		Scanner in = new Scanner(System.in);
		playerList = new Player[nbPlayers];
		
		//Setting names of the players
		for (int i = 0; i < nbPlayers; i++)
			playerList[i] = new Player("P" + (i + 1));
		
		//initializes the oneToOneHundred 2D array
		initializeOneToOneHundredBoard();

		//declaring and initializing variable playerIndex which will keep track of the player turns
		int playerIndex = 0;
		
		//While loop that controls the game functionality
		while(win == false) {
			
			System.out.println("Player " + (playerIndex +1 ) + "'s turn:");
			System.out.println("Press any key to roll the dice!");
			
			//Retrieving that the user entered a key value to roll the dice
	        String key = in.next();
	        key = null;

	        //Setting roll's value to a random integer between 1 and 6
	        int roll = flipDice();

	        System.out.println("You rolled a " + roll + "\n");
	        
	        //moving specified player a certain value through the board
	        move(playerList[playerIndex], roll);
	        
	        //Indicating to the player that they hit a snake or a ladder
	        if(isSnake(playerList[playerIndex]) == true) {
	        	System.out.println("Oh no! You got a snake! Moving down...");
	        }
	        
	        if(isLadder(playerList[playerIndex]) == true) {
	        	System.out.println("WOW! You got a ladder! Moving up...");
	        }
	        
	        //Incrementing playerIndex which represents moving onto the next player's turn
	        playerIndex++;
	        
	        //Displaying the board to the players
	        displayBoard();
	        
	        //If statement that controls the turn cycle (if we get to the last player's turn, it goes back to the first player)
	        if(playerIndex == nbPlayers)
	        	playerIndex = 0;

	        }
		
		//Closing scanner object
		in.close();
		
		System.out.println("Congratulations " + winner + " you won the game!");
		System.out.println("Thanks for playing!");
		
	}
	
	/**
	 * A method that outputs the snakes and ladders board to the console.
	 */
	private void displayBoard() {
		
		//Count variable to be subtracted from to output the tiles of the board
		int count = 100;

		//Outer for loop responsible for printing the board to the console
        for(int i = 0; i < 10; i++) {
        	
        	//If statement controlling printing the even rows to the console
            if(i % 2 == 0 || i == 0) {
	            for(int j = 0; j < 10; j++) {
	            	
	            	//if statement that prints the player's name onto their respective tile
	            	if(board[i][j] != null) {
	            		System.out.print("[ " + board[i][j] + "]");
	            		count--;
	            		continue;
	            	}
	            	
	            	//if statement that prints the number tile to the console with two 00's to keep the format clean
	                if(count < 10) {
	                    System.out.print("[00" + count + "]");
	                    count--;
	                }
	                
	                //else if statement that prints the number tile to the console with one 0 to keep the format clean
	                else if(count >= 10 && count < 100) {
	                    System.out.print("[0" + count + "]");
	                    count--;
	                }
	                
	                //else statement that prints the number tile to the console
	                else {
	                System.out.print("[" + count + "]");
	                count--;}
            }
            }
            //else statement controlling printing the odd rows to the console
            else {
            	
            	//Due to the structure of the board, for odd rows we must start at what our count was - 9 and add 1 each time until we reach the new row 
                int newCount = count - 9;
                
                
                for(int j = 0; j < 10; j++) {
                	
	            	//if statement that prints the player's name onto their respective tile
                	if(board[i][j] != null) {
                		System.out.print("[ " + board[i][j] + "]");
                		count--;
                		continue;
                	}
                	
	            	//if statement that prints the number tile to the console with two 00's to keep the format clean
                    if((newCount + j) < 10) {
                        System.out.print("[00" + (newCount + j) + "]");
                        count--;
                    }
                    
	                //else if statement that prints the number tile to the console with one 0 to keep the format clean
                    else if((newCount + j) >= 10 && (newCount + j) < 100) {
                        System.out.print("[0" + (newCount + j) + "]");
                        count--;
                    }
                    
	                //else statement that prints the number tile to the console
                    else {
                    System.out.print("[" + (newCount + j) + "]");
                    count--;
                    }
                }
            }
            //Skipping two lines for formatting
            System.out.println();
            System.out.println();
        }
	}
	
	/**
	 * The method that moves a player through the board.
	 * 
	 * @param p An instance of type Player, representing the player to be moved
	 * @param n An integer value representing how far the player must move on the board
	 */
        private void move(Player p, int n) {
        	
        	//Retrieving the player's position before they move
        	int oldRow = p.getRow();
        	int oldColumn = p.getColumn();
        	
        	//if statement controlling the movement of the player's first move
        	if(p.getStartingMove() == true) {
        		p.setRow(9);
        		p.setColumn(n - 1);
        		p.setStartingMove(false);
        		
        		board[p.getRow()][p.getColumn()] = p.getName();
        	}
        	//else if statement controlling player's forward movement (on odd rows)
        	else if(p.getRow() % 2 != 0)
        	
        		forward(p, n);
        	
        	//else statement controlling player's backwards movement (on even rows)
        	else {
        		
        		backward(p,n);
        	}
        	
        	//Setting the player's old position to null so a player only ever appears on the board on one tile
        	board[oldRow][oldColumn] = null;
        	
        	//Reinitialize position of players in case there were 2 on the same tile (since right now that tile is null)
        	
        	for (int i = 0; i < playerList.length; i++) {
        		Player currentPlayer = playerList[i];
        		if(currentPlayer.getStartingMove() == true)
        			continue;
        		else	
        		board[currentPlayer.getRow()][currentPlayer.getColumn()] = currentPlayer.getName();
        	}
        }
        
        /**
    	 * The method that controls forward motion through the board (right to left).
    	 * 
    	 * @param p An instance of type Player, representing the player to be moved
    	 * @param n An integer value representing how far the player must move on the board
    	 */
        private void forward(Player p, int n) {
        	
        	//if statement controlling the player movement when they move forwards and have to switch rows
        	if(p.getColumn() + n > 9) {
        		
        		int backwardsMovement = (p.getColumn() + n) - 9;
        		int newIndex = 10 - backwardsMovement;
        		
        		p.setRow(p.getRow() - 1);
        		p.setColumn(newIndex);
        		
        		board[p.getRow()][p.getColumn()] = p.getName();
        		
        	}
        	
        	//else statement controlling the regular forward movement of the player
        	else {
        		
        		int newIndex = p.getColumn() + n;
        		p.setColumn(newIndex);
        		
        		board[p.getRow()][p.getColumn()] = p.getName();
        	}
        	
        	
        } 
        
        /**
    	 * The method that controls backwards motion through the board (left to right).
    	 * 
    	 * @param p An instance of type Player, representing the player to be moved
    	 * @param n An integer value representing how far the player must move on the board
    	 */
        private void backward(Player p, int n) {
        	
        	//if statement controlling the backwards motion if a player goes over the 100 tile
			if(p.getColumn() - n < 0 && p.getRow() == 0) {
			        		
			    	int newIndex = n - p.getColumn();
			        		
			        p.setColumn(newIndex);
			        
			        board[p.getRow()][p.getColumn()] = p.getName();
        	}
			
			//else if controlling the movement for when the player moves backwards to the end of the row, and then switches rows
        	else if(p.getColumn() - n < 0) {
        		
	        		int forwardMovement = (n - p.getColumn());
	        		int newIndex = forwardMovement - 1;
	        		
	        		p.setRow(p.getRow() - 1);
	        		p.setColumn(newIndex);
	        		
	        		board[p.getRow()][p.getColumn()] = p.getName();
        		}
        	//else statement controlling regular backwards movement
        	else {
        			int newIndex = p.getColumn() - n;
        			p.setColumn(newIndex);
        			
        			board[p.getRow()][p.getColumn()] = p.getName();
        			
        			//if statement controlling the win condition should a player land on 100	
        			if(p.getRow() == 0 && p.getColumn() == 0) {
        			win = true;
        			winner = p.getName();
        		}
        	}
        }
        
        /**
    	 * Method that checks if a player is on a snake tile.
    	 * 
    	 * @param p An instance of Player on a tile
    	 */
        private boolean isSnake(Player p) {
        	
        	//Retrieving player's current position
        	int row = p.getRow();
        	int column = p.getColumn();
        	
        	//Retrieving tile value for player's position
        	int tile = oneToOneHundred[row][column];
        	
        	//Switch statement that checks what tile the player is on, and checks to see if it is on a snake tile. If yes,
        	//it moves the player to the position indicated by the Snakes and Ladders board.
        	
        	switch(tile) {
        	
        		case 16:board[row][column] = null;board[9][5] = p.getName(); p.setRow(9);p.setColumn(5);return true;//Moves to 6
        		
        		case 48:board[row][column] = null;board[5][7] = p.getName(); p.setRow(5);p.setColumn(7);return true;//Moves to 30
        		
        		case 64:board[row][column] = null;board[4][0] = p.getName(); p.setRow(4);p.setColumn(0);return true;//Moves to 60
        		
        		case 79:board[row][column] = null;board[8][1] = p.getName(); p.setRow(8);p.setColumn(1);return true;//Moves to 19
        		
        		case 93:board[row][column] = null;board[3][7] = p.getName(); p.setRow(3);p.setColumn(7);return true;//Moves to 68
        		
        		case 95:board[row][column] = null;board[7][3] = p.getName(); p.setRow(7);p.setColumn(3);return true;//Moves to 24
        		
        		case 97:board[row][column] = null;board[2][4] = p.getName(); p.setRow(2);p.setColumn(4);return true;//Moves to 76
        		
        		case 98:board[row][column] = null;board[2][2] = p.getName(); p.setRow(2);p.setColumn(2);return true;//Moves to 78
        		
        	}
        	
        	return false;
        	
        }
        
        /**
    	 * Method that checks if a player is on a ladder tile.
    	 * 
    	 * @param p An instance of Player on a tile
    	 */
        private boolean isLadder(Player p) {
        	
        	//Retrieving player's current position
        	int row = p.getRow();
        	int column = p.getColumn();
        	
        	//Retrieving tile value for player's position
        	int tile = oneToOneHundred[row][column];
        	
        	//Switch statement that checks what tile the player is on, and checks to see if it is on a ladder tile. If yes,
        	//it moves the player to the position indicated by the Snakes and Ladders board.
        	
        	switch(tile) {
        	
        		case 1:board[row][column] = null;board[6][2] = p.getName(); p.setRow(6);p.setColumn(2); return true;//Moves to 38
        		
        		case 4:board[row][column] = null;board[8][6] = p.getName(); p.setRow(8);p.setColumn(6);return true;//Moves to 14
        		
        		case 9:board[row][column] = null;board[6][9] = p.getName(); p.setRow(6);p.setColumn(9);return true;//Moves to 31
        		
        		case 21:board[row][column] = null;board[5][1] = p.getName(); p.setRow(5);p.setColumn(1);return true;//Moves to 42
        		
        		case 28:board[row][column] = null;board[1][3] = p.getName(); p.setRow(1);p.setColumn(3);return true;//Moves to 84
        		
        		case 36:board[row][column] = null;board[5][3] = p.getName(); p.setRow(5);p.setColumn(3);return true;//Moves to 44
        		
        		case 51:board[row][column] = null;board[3][6] = p.getName(); p.setRow(3);p.setColumn(6);return true;//Moves to 67
        		
        		case 71:board[row][column] = null;board[0][9] = p.getName(); p.setRow(0);p.setColumn(9);return true;//Moves to 91
        		
        		case 80:{ //Moves to 100
        			board[row][column] = null;
        			board[0][0] = p.getName();
        			
        			//Since the ladder moved player to 100, the player wins
        			win = true;
        			winner = p.getName();
        			return true;
        		}
        	}
        	
        	return false;
        }
        
        /**
    	 * A method that sets the 2D array oneToOneHundred with values from 1 to 100
    	 * according to the structure of the snakes and ladders board.
    	 */
        private void initializeOneToOneHundredBoard() {
        	//Setting up the 1 to 100 board to refer to in the isSnake and isLadder methods
    		int count = 100;
    		for(int i = 0; i < oneToOneHundred.length; i++) {
    			
    			//If statement that detects if the row is odd. If it is, the row must start from 9 - count due to the structure of the board
    			if (i % 2 != 0 && i != 0) {
    				
    				int newCount = count - 9;
    				
    				for(int j = 0; j < oneToOneHundred[i].length; j++) {
    					
    					oneToOneHundred[i][j] = newCount + j;
    					count--;
    				}
    			}
    			//Else statement that executes the code for when the row is an even index (or 0)
    			else {
    				
    				for(int j = 0; j < oneToOneHundred[i].length; j++) {
    					
    					oneToOneHundred[i][j] = count;
    					count --;
    				}
    			}
    		}
        }
	}
