package com.shopping.list;

/**
 * This is an interface representing types of a linear list
 * @author Zac
 * @version 15/10/2018
 *
 */
public interface LinearList {
	
	//Adds a new item to the list
	public void add(int index, Object theElement);
	//Returns and removes an object from the list with the specified index
	public Object remove(int index);
	//Returns an object from the list
	public Object get(int index);
	//Checks the index passed as an argument
	public void checkIndex(int index);
	//Returns the index of a specified object
	public int indexOf(Object theElement);
	//Retrieves the size of the list
	public int size();
	//Returns the 'empty' status of the list
	public boolean isEmpty();
	

}
