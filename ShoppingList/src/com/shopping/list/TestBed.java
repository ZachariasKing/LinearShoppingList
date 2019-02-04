package com.shopping.list;

import java.util.Scanner;

/**
 * This class acts as out 'Test Bed Program' for the Shopping List project where we test the different features of it.
 * This class represents (manually) the actions a user might take during their experience using the ShoppingList class
 * 
 * @author Zac
 * @version 15/10/2018
 *
 */
public class TestBed {

	public static void main(String[] args) {
		
		//Prompt for initial capacity of list							//Not used in testing - Uncomment this if you want to use the menu as desired by the user
		//System.out.println("How long do you want this list to be?: "); //Not used in testing - Uncomment this if you want to use the menu as desired by the user
		
		//Use the value the user enters to create a list of 'input' length //Not used in testing - Uncomment this if you want to use the menu as desired by the user
		//Scanner input = new Scanner(System.in); 							//Not used in testing - Uncomment this if you want to use the menu as desired by the user
		
		//Menu menu = new Menu(new ShoppingList(input.nextInt()));		//Not used in testing - Normally, the user would be presented with a menu via the Menu class but for
																		//testing purposes we are going to manually setup the shopping list as below
		
																		//Uncomment this if you want to use the menu as desired by the user
		
		
		//Setup a shopping list manually with the standard initial capacity of 10
		ShoppingList sl = new ShoppingList();		
		
		//1. Testing our first (extra) option on the menu - giving the user the ability to append an item to the list which is more simpler for them 
		//than perhaps thinking of a position. Here we have created some example Items with the format of name, quantity and cost in the constructor
		//One example Item is called "Cheese", with a quantity of 20 and a cost of £20
		Item anItem = new Item("Cheese", 20, 20); 	
		Item anItem2 = new Item("Milk", 20, 20); 	
		sl.appendItem(anItem);
		sl.appendItem(anItem2);
		sl.printList();
		
		//2. Testing our second option on the menu - giving the user the ability to add an item to the list at any position
		Item anItem3 = new Item("Goat Cheese", 20, 20); 		
		sl.add(2, anItem3); //Adding an item to the list at index 2 called "Goat Cheese"
		sl.printList(); //Print list to make sure item has been added
		
		//3. Testing our third option on the menu - giving the user the ability to remove an item to the list at any position		
		sl.removeItem(anItem3.getName()); //removing an item at the list at index 2 called "Goat Cheese" by it's name
		sl.printList(); //Print list to make sure item has been removed
		
		//4. We have already tested the user's option of displaying the list by using it to prove our test cases
		
		//5. Testing our fifth option on the menu - giving the user the ability to display an item at a particular location in the list
	    System.out.println(sl.getItem(1)); //Prints out the item at the index 1
	     
		//6. Testing our sixth option on the menu, which allows the user to check the size of the list
	    System.out.println("\nThe list currently has " + sl.size + " items.");
		
		//7. Testing our seventh option on the menu, which allows the user to check the position of an item. The reason we have a '+1'
	    //in the if statement is because, from a user's perspective, they may want to enter a position (n-1) not an index (n)
	    if ((sl.getPosition(anItem2.getName())+1) == 0)
	    {
	    	System.out.println("This item is not in the list");
	    }
	    else
	    {
	    	System.out.println("This item is " + (sl.getPosition(anItem2.getName()) + 1) + " in the list");
	    }
	    
		//8. Testing our eighth option on our menu which calculates all items costs (multiplied by their quantities)
	    System.out.println("The total cost of all items in this list is: " + sl.calculateSum());
	    
		//9. Testing our ninth option on our menu which returns detailed information about the most expensive item in the list
	    System.out.println(sl.mostExpensive());
	    
		//10. Testing our ninth option on our menu which returns detailed information about the most expensive item in the list
		Item anItem4 = new Item("Clothing", 1, 89); 
		sl.appendItem(anItem4);
		Item anItem5 = new Item("Shower gel", 1, 89); 
		sl.appendItem(anItem5);
		Item anItem6 = new Item("Soap", 1, 91); 
		sl.appendItem(anItem6);
	    sl.removeItemByCost(88);		//This should remove all the items above and return a String to let us know what was removed to prove it
	    
	    
	     
	     
	     
	     
	
	     
		//input.close();	//Close the scanner to stop it requiring resources like memory (NOT USED DURING TESTING BUT WHEN USER WANTS A MENU TO NAVIGATE)
	    					//Uncomment this if you want to use the menu as desired by the user
		
	}

}
