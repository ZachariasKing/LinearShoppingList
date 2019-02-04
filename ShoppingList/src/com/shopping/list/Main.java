package com.shopping.list;

import java.util.Scanner;

/**
 * The Main class represents how the user would use the shoppingList and it's menu feature to navigate such options
 * 
 * @author Zac
 * @version 15/10/2018
 *
 */
public class Main {

	public static void main(String[] args) {
		//Prompt for initial capacity of list	
		System.out.println("How long do you want this list to be?: "); 
		
		//Use the value the user enters to create a list of 'input' length 
		Scanner input = new Scanner(System.in);
	    Menu menu = new Menu(new ShoppingList(input.nextInt()));
	    
	    
		input.close();	
		

	}

}
