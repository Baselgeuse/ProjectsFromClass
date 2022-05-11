package part_1_subdictionary;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

//---------------------------------------------------------------
//Assignment 4
//Part: 1
//COMP 249
//Written by: Liam Daigle (40207583)
//Due: Friday, April 15th, 2022
//---------------------------------------------------------------

/**
 * The SubDictionaryDriver class asks a user for a text to create a sub-dictionary for with no repeats.
 * @author Liam Daigle
 * @version 1.0
 *
 */


public class SubDictionaryDriver {
	
	public static void main (String[] args) {
		
		Scanner userInput = new Scanner(System.in);		
		Scanner input = null;
		PrintWriter output = null;
		int numberOfEntries = 0;
		
		//Asking user for input
		System.out.println("Enter the name of the file you wish to read from:");
		
		String fileName = userInput.next();
		
		//Removing the txt extension if the user appended one to the name of the file in the input
		if(fileName.length() >= 4 && fileName.substring(fileName.length() - 4).equals(".txt"))
				fileName = fileName.substring(0,fileName.length() - 4);
		
		
		//Try block to receive input from the user chosen text file and outputs to SubDictionary.txt
		try {
			
			input = new Scanner(new FileInputStream(fileName + ".txt"));
			output = new PrintWriter(new FileOutputStream("SubDictionary.txt"));
			
			System.out.println("File found! Creating Sub-Dictionary...");
			
			//SubDictionary ArrayList used to store words until they get outputted into a txt file
			ArrayList<String> subDictionary = new ArrayList<>();
			
			//ArrayList containing all the valid cases of the combination of letters after the apostrophe in a contraction
			ArrayList<String> abbreviationLetters = new ArrayList<>();
			
			abbreviationLetters.add("t");
			abbreviationLetters.add("ll");
			abbreviationLetters.add("re");
			abbreviationLetters.add("d");
			abbreviationLetters.add("nt");
			abbreviationLetters.add("ve");
			abbreviationLetters.add("m");
			abbreviationLetters.add("n");
			abbreviationLetters.add("s");
			
			//While loop that reads through the entire text file
			while(input.hasNext()) {
				
				String token = input.next();
				token = token.toUpperCase();
				
				//case for if the word contains an apostrophe
				if(token.indexOf("’") != -1) {
					int apostropheIndex = token.indexOf("’");
					
					
					//case for if the word has an apostrophe at the beginning or end
					if(token.indexOf(apostropheIndex) == 0 || token.indexOf(apostropheIndex) == token.length() - 1) {
						continue;
					}
					
					String beforeApostrophe = token.substring(0, apostropheIndex);
					String afterApostrophe = token.substring(apostropheIndex + 1);
					
					//case that checks the validity of the contraction, and sets the word before the apostrophe to the token if it is valid
					if(abbreviationLetters.contains(afterApostrophe.toLowerCase())) {
						token = beforeApostrophe;
					}
				}
				
				//case for if the word contains a question mark
				if(token.indexOf("?") != -1)
					if(token.indexOf("?") < token.length() - 1)
						continue;
					else
						token = token.substring(0,token.indexOf("?"));
				//case for if the word contains a colon
				if(token.indexOf(":") != -1) 
					if(token.indexOf(":") < token.length() - 1)
						continue;
					else
						token = token.substring(0,token.indexOf(":"));
				
				//case for if the word contains a semi colon
				if(token.indexOf(";") != -1)
					if(token.indexOf(";") < token.length() - 1)
						continue;
					else
						token = token.substring(0, token.indexOf(";"));
				
				//case for if the word contains an exclamation mark
				if(token.indexOf("!") != -1)
					if(token.indexOf("!") < token.length() - 1)
						continue;
					else
						token = token.substring(0, token.indexOf("!"));
				
				//case for if the word contains a period
				if(token.indexOf(".") != -1)
					if(token.indexOf(".") < token.length() - 1)
						continue;
					else
						token = token.substring(0, token.indexOf("."));
				
				//case for if the word contains a comma
				if(token.indexOf(",") != -1)
					if(token.indexOf(",") < token.length() - 1)
						continue;
					else
						token = token.substring(0,token.indexOf(","));
				
				//case for if the = operator is attached to a word
				if(token.length() > 1 && token.indexOf("=") != -1)
					continue;
				
				//case for if the word contains a number
				if(token.indexOf("0") != -1 || token.indexOf("1") != -1 || token.indexOf("2") != -1 || token.indexOf("3") != -1 || token.indexOf("4") != -1 || token.indexOf("5") != -1 || token.indexOf("6") != -1 || token.indexOf("7") != -1 || token.indexOf("8") != -1 || token.indexOf("9") != -1)
					continue;
				
				//case for if the word is just a single letter
				if(token.length() == 1) {
					if((token.equals("A") || token.equals("I"))) {
						subDictionary.add(token);
						continue;
					}
					else
						continue;
				}
				
				subDictionary.add(token);
				
			}
			//Creating a new ArrayList to add values from our subdictionary too to fix a bug
			ArrayList<String> finalList = new ArrayList<>();
			
			System.out.println(subDictionary.toString());
			//Sorting the subdictionary alphabetically
			for(int i = 0; i < subDictionary.size() - 1; i++) {
				for(int j = 0; j < subDictionary.size() - 1; j++) {
					if(subDictionary.get(j).compareTo(subDictionary.get(j+1)) > 0) {
						String temp = subDictionary.get(j);
						subDictionary.set(j, subDictionary.get(j + 1));
						subDictionary.set(j + 1, temp);
						System.out.println("Hit");
					}
					
				}
			}
			
			
			
			//For loop that iterates through the subdictionary list and only adds unique words to the finallist
			for(int i = 0; i < subDictionary.size(); i++) {
				
				if(finalList.contains(subDictionary.get(i)))
					continue;
				finalList.add(subDictionary.get(i));
				numberOfEntries++;
			}
			
			output.println("The document produced this sub-dictionary, which includes " + numberOfEntries + " entries.");
			
			//character variable to keep track of what letter is being outputted, and a boolean value to properly print the first letter
			char currentLetter = Character.toUpperCase(finalList.get(0).charAt(0));
			boolean firstLetter = true;
			
			for(int i = 0; i < finalList.size();i++) {
				
				if(firstLetter) {
					output.println("\n" + currentLetter + "\n==");
					firstLetter = false;
				}
				//condition that detects a change in first letter and updates currentLetter, as well as printing the new letter
				else if(finalList.get(i).charAt(0) != currentLetter) {
					currentLetter = Character.toUpperCase(finalList.get(i).charAt(0));
					output.println("\n" + currentLetter + "\n==");
				}
				output.println(finalList.get(i));
			}
			//Closing scanner objects
			output.close();
			input.close();
			
			System.out.println("Successfully Created Sub-Dictionary");
			
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			
			input.close();
		}
		
		//Closing scanner objects
		userInput.close();
		
	}//end of driver

}//end of SubDictionaryDriver class
