package com.shopping.list;

/**
 * 'Item' is a class intended to represent an Item that is able to be manipulated in our ShoppingList. It has a name, quantity and cost
 * @author Zac
 * @version 15/10/2018
 *
 */
public class Item {
	
	//Name of the item
	private String name;
	
	//Quantity of the item
	private int quantity;
	
	//Cost of the item
	private double cost;
	/**
	 * This constructor creates an Item object and passes it a name and a quantity as arguments
	 * @param name the name of the item
	 * @param amount the quantity of the named item
	 */
	public Item(String name, int amount, double cost)
	{
		this.quantity = amount;
		this.name = name;
		this.cost = cost;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	//toString to make printing of object easier
	@Override
	public String toString()
	{
		return "Name: " + name + " Quantity: " + quantity + " Cost: £" + cost;
	}
	
}
