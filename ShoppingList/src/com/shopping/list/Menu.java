package com.shopping.list;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Menu class models the interface used by the user to access the functionality of the 'Shoppinglist' class.
 * 
 * @author Zac
 * @version 15/10/2018
 *
 */
public class Menu {
	
	//If false, keeps menu running. Terminates when user makes exit=true
	boolean exit = false;
	
	ShoppingList shoppingList;
	
	public Menu(ShoppingList sl)
	{
		shoppingList = sl;
		this.buildMenu();
	}
	
	/**
	 * In order to keep our code cleaner, we have placed all welcome print statements here
	 */
	public void printMenuItems()
	{
		System.out.println("Welcome to your Shopping List");
		System.out.println("\nPlease select one of the options below (entering the number of the option): ");
		System.out.println("1: Append an item");
		System.out.println("2: Add an item to a certain position");
		System.out.println("3: Remove an item");
		System.out.println("4: Display your list");
		System.out.println("5: Display an item from it's position");
		System.out.println("6: Check the size of the list");
		System.out.println("7: Check the position of an item");
		System.out.println("8: Calculate total cost of each item");
		System.out.println("9: Return the most expensive");
		System.out.println("10: Remove items above a certain cost");
		System.out.println("11: Exit the Menu");
	}
	
	public void buildMenu()
	{
		Scanner input = new Scanner(System.in);
	
		//Start loop to keep menu running until exiting
		while(!exit) 
		{
			//Print menu options
			printMenuItems();
			//Option initialised so that we can get access to it after try statement
			int option = 0;
			//Item name is used twice locally and so causes duplication error so set here to null
			String itemName = null;
			try{
			option = input.nextInt();
			}
			catch(InputMismatchException ex) {
				
				System.err.println("Please make sure you enter a number as a selection!");
				this.buildMenu();
			}
			//Uses switch statement to provide relevant methods for option chosen
			decide(option, input);
			
		}
		//Close Scanner so it stops requiring resources
		input.close();
	}
	
	/**
	 * This is the method that decides what happens when a user has entered an option. It uses a switch statement to provide
	 * appropriate functionality to the option that the user has chosen.
	 * 
	 * The Scanner makes a 'nextLine()' at each option in order to allow for spaces delimiter not tokenising just one word but the 
	 * entire sentence. If we changed the delimiter, it would wrongly parse the input.
	 * 
	 * @param option the numeric option that the user has chosen
	 * @param input the Scanner object used to collect the input from the user
	 */
	public void decide(int option, Scanner input) {
		//Item name is used throughout many different options of switch statement and so declared null here is order to use it later
		String itemName = null;
		int itemQuantity = 0;
		double itemCost = 0;
		switch(option)
		{
			   //Appending to the end of the list
			   case 1:
			   input.nextLine();
			   System.out.println("\nOk, please enter the item name: ");	//Provide user with guidance with text prompts
		       itemName = input.nextLine();
			   System.out.println("Ok, how many of these do you want?: ");
		       itemQuantity = input.nextInt();
		       input.nextLine();
			   System.out.println("Ok, how much does it cost?: ");
		       itemCost = input.nextDouble() * itemQuantity; //Multiply cost by amount of items to get full cost
		       shoppingList.appendItem(new Item(itemName, itemQuantity, itemCost));
		       //Confirmation of list added is already provided by 'add' method in superclass
 		       System.out.println("\n");
		       break;
		       
		       //Adding an item in a certain position
		       case 2:
			   input.nextLine();
			   System.out.println("\nWhat position do you want to place this item at?: ");
		       int index = input.nextInt() - 1; //Minus one here as user might want something in 'nth' position but zero-indexing means n-1
		       input.nextLine(); //Need this here as nextInt() does not consume new line character and would mess up input pattern otherwise causing 'InputMisMatchException'
			   System.out.println("Ok, please enter the item name: ");
		       itemName = input.nextLine();
			   System.out.println("Ok, how many of these do you want?: ");
		       itemQuantity = input.nextInt();
		       input.nextLine();
			   System.out.println("Ok, how much does it cost?: ");
		       itemCost = input.nextDouble() * itemQuantity;
			   shoppingList.add(index,new Item(itemName, itemQuantity,itemCost));
			   System.out.println("Ok, Your list item has been added at the " + index + " position.");
		       System.out.println("\n");
		       break;
		      
		       //Removing Item
		       case 3:
		       input.nextLine();
		       System.out.println("\nOk, What is the name of the item you want to remove? ");
		       shoppingList.removeItem(input.nextLine());
		       System.out.println("\n");
		       break;
		       
		       //Displaying/printing the entire list
		       case 4:
			   input.nextLine();
		       System.out.println("\n");
		       shoppingList.printList();
		       System.out.println("\n");
		       break;
		       
		       //Displaying an item in the list if it exists
		       case 5:
			   input.nextLine();
		       System.out.println("\nOk, enter a position of the list item you want to view: ");
		       System.out.println(shoppingList.getItem(input.nextInt() - 1));
		       System.out.println("\n");
		       break;
		       
		       //Check the size of the list
		       case 6:
			   input.nextLine();
		       System.out.println("\nThe list currently has " + shoppingList.size + " items.");
		       System.out.println("The list size you chose was " + shoppingList.getLength() + " items.");
		       break;
		       
		       //Check the position of an item
		       case 7:
		       input.nextLine();
		       System.out.println("\nOk, enter the name of the item");
		       itemName = input.nextLine();
		       if ((shoppingList.getPosition(itemName)+1) == 0)
		       {
		    	   System.out.println("This item is not in the list");
		       }
		       else
		       {
		       System.out.println("This item is " + (shoppingList.getPosition(itemName) + 1) + " in the list");
		       }
		       break;
		       
		       //Calculate total of each item
		       case 8:
		       System.out.println("The total cost of all items in this list is: " + shoppingList.calculateSum());
		       break;
		       
		       //Return most expensive item
		       case 9:
		       System.out.println(shoppingList.mostExpensive());
		       break;
		       
		       //Remove item above certain cost
		       case 10:
		       input.nextLine();
		       System.out.println("Ok, above what certain cost: ");
		       shoppingList.removeItemByCost(input.nextInt());
		       break;
		       
		       //Exit the menu
		       case 11:
		       System.out.println("Goodbye!");
		       this.exit=true;
		       break;
		       
		       //In case the user enters a value out of range
		       default:
		       System.out.println("\nPlease select an option that exists in the menu!");
		       break;
			
		}
		
	}

}
