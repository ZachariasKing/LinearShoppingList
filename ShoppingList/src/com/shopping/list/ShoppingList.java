package com.shopping.list;

import java.util.InputMismatchException;

import java.util.Scanner;

import javax.lang.model.util.Elements;

/**
 * The ShoppingList class represents a type of ArrayLinearList that is used for customers who shop and can add, remove, retrieve and display list items
 * and their positions using a menu that provides the user with options continuously until they decide to exit.
 * All method calls are explicit to show what methods belong to the super class (ArrayLinearList) and those that belong to this class
 * @author Zac
 * @version 15/10/2018
 */
public class ShoppingList extends ArrayLinearList {
	
	//This variable is the break out of the loop when it becomes true (when the user decides to exit)
	private boolean exit = false;
	
	
	public ShoppingList(int initialCapacity) 
	{
		super(initialCapacity);
	}
	
	//Constructor mainly used for testing
	public ShoppingList() 
	{
		super();
	}
	
	
	/**
	 * This method retrieves the position of an Item object with the user passing the argument of the item name
	 * @param itemName the name of the item we want to get the position for
	 * @return the position of the item specified by the user
	 */
	public int getPosition(String itemName)
	{
		int listLength = super.getLength();
		Object[] item = super.getList();
		Item theItem = null;
		for(int i = 0; i < listLength; i++)
		{
			Item itemElement = (Item) item[i];
			if(itemElement != null && itemElement.getName().equals(itemName))
			{
				theItem = (Item) item[i];
			}
		}
		return super.indexOf(theItem);
	}
	
	/**
	 * This returns an item from a particular position in the list
	 * @param index the position of the item we want to get
	 * @return the item the user wants to see at that position
	 */
	public Item getItem(int index)
	{
		return (Item) super.get(index);
	}
	
	/**
	 * @return the exit
	 */
	public boolean getExit() {
		return exit;
	}

	/**
	 * @param exit the exit to set
	 */
	public void setExit(boolean exit) {
		this.exit = exit;
	}

	/**
	 * This checks if the method is empty and returns a message depending on whether or not this is true
	 */
	public void checkEmpty()
	{
		if(super.isEmpty())
		{
		System.out.println("The list is empty");
		}
		else
		{
			System.out.println("The list is not empty");
		}
	}
	
	/**
	 * This checks the lists size and presents a message to the user, detailing the size
	 */
	public void checkSize()
	{
		System.out.println("The list has " + super.size() + " items.");
	}

	
	/**
	 * Here we are adding the item that the user wants to add to their list. We use the add() method from the ArrayLinearList method to specify
	 * where in the list we want to add the item. We use size() to determine the next position in the list as size returns how many elements are in the list
	 * this number is equal to n+1 in terms of the last list item currently in the list
	 * 
	 * @param theItem this is the item we want to add to the list
	 */
	public void appendItem(Item theItem){
		add(super.size(), theItem);
	}

	/**
	 * Here we remove an item based on it's name as this is the most logical way on deciding what to delete from a shopping
	 * list
	 * 
	 * @param itemName This is the name of the item
	 */
	public void removeItem(String itemName)
	{
		//We purposely make local variable here to save on method calls during loop
		Object[] item = super.getList();
		
		String message =  null;
		for(int i = 0; i < size; i++)
		{
			Item itemElement = (Item) item[i];
			if(itemElement != null && itemElement.getName().equals(itemName))
			{
				super.remove(indexOf(item[i]));
				System.out.println(itemName + " has been deleted.");
				return;
			}
			else if(!itemElement.getName().equals(itemName)) {
				message = "List item not found";
			}
		}
		System.out.println(message);
	}
	
	/**
	 * This method calculates the sum of all item costs in the ShoppingList, returning the total
	 * @return The total cost of all items (multiplied by their quantitites)
	 */
	public double calculateSum() {
		
	       int sum = 0;
	       if (!isEmpty()) {
	    	   for(int i = 0; i < size; i++)
	    	   {
	    		   sum += getItem(i).getCost();
	    	   }
	       }
	       else 
	       {
	    	   return 0;
	       }
	       return sum;
	       
	}
	
	/**
	 * This method returns the most expensive item in the list. 
	 * 
	 * @return a String detailing the item with the most expensive costs
	 */
	public String mostExpensive() {
		
	       int size = size(); //local variable here to save on calling method each time during loop
	       Item maxItem = (Item) elements[0];	//Have to store this in a variable first before loop in order to compare against it in loop
	       if (!isEmpty()) {
	    	   for(int i = 1; i < size; i++)
	    	   {
	    		   if(((Item) elements[i]).getCost() > maxItem.getCost()){
	    		   		maxItem = (Item) elements[i];
	    		   }
	    	   }
	       }
	       else 
	       {
	    	   return "There are no items in your list";
	       }
	       return "The most expensive item is " + maxItem;
	       
	}
	
	/**
	 * This method is passed a cost which it will use to determine the removal of items greater than it.
	 * We have used a StringBuffer here as it is more efficent in memory than immutable String objects
	 * 
	 * @param cost the cost at which we will use as a limit to say that anything greater than this shall be deleted from the list
	 */
	public void removeItemByCost(double cost)
	{
		StringBuffer sb = new StringBuffer("The removed items are: ");
		Item[] deletedItems = new Item[size]; //Array of 'to-be deleted items' - worst case size is all items
		int deletedItemsIndex = 0;
	       if (!isEmpty()) {
	    	   for(int i = 0; i < size; i++)	//Indexing shifting and so Items being missed out if we loop through and delete normally
	    	   {
	    		   if(((Item) elements[i]).getCost() > cost){
	    		   		sb.append((((Item) elements[i])) + ", ");
	    		   		//removeItem((((Item) elements[i]).getName())); //This won't work as indexes shift when something is deleted!!
	    		   		deletedItems[deletedItemsIndex] = ((Item) elements[i]);
	    		   		deletedItemsIndex++;
	    		   }
	    	   }
	       }
	       else 
	       {
	    	   System.out.println("There are no items in your list");
	       }
	       System.out.println(new String(sb));;	
	}

}
