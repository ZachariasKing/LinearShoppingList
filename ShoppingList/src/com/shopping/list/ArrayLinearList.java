package com.shopping.list;

/**
 * 
 * The ArrayLinearList is of type 'LinearList' and has implemented it's methods. This class represents an array 
 * implementation of a linear list in that an array is used to store objects.
 * 
 * @author Zac
 * @version 15/10/2018
 */
public class ArrayLinearList implements LinearList {
	
	//Size of the array linear list
	protected int size;
	//Array of Object elements
	protected Object[] elements;
	
	//Constructors
	/**
	 * This constructor allows the user to input an initial capacity which will be set upon initialising the item
	 * as long as the index is not less than 1
	 * 
	 * @throws IllegalArgumentException if the initial capacity is less than 1
	 * @param initialCapacity
	 */
	public ArrayLinearList(int initialCapacity) {
		
		if(initialCapacity < 1)
		{
			throw new IllegalArgumentException("Initial capacity cannot be set to less than 1");
		}
		else
		{
			size = 0;
			elements = new Object[initialCapacity];
		}
		
	}
	
	/**
	 * This is a default constructor with a default initial capacity of 10
	 */
	public ArrayLinearList() {
		
		this(10);
		
	}

	/**
	 * This adds a new element to the list 
	 * 
	 * @param index the position in the list we want to add the item
	 * @param theElement this is the element we want to add to the list
	 */
	@Override
	public void add(int index, Object theElement) {
		
		//Throws exception if invalid index
		if(index < 0 || index > size)
		{
			//Invalid position
			throw new IndexOutOfBoundsException("Index invalid");
		}
		
		
		//If the size of the array is full, use array copy to make an array twice the length, copying all values to it
		if (size == elements.length)
		{
			Object[] newArray = new Object[elements.length*2];
			System.arraycopy(elements, 0, newArray, 0, elements.length);
			elements = newArray;
		}
		
		
		//Shift elements right one position
		for(int i = size - 1; i >=index; i--)
		{
			elements[i+1] = elements[i];
		}
		
		elements[index]  = theElement;
		System.out.println("Element added to list");
		size++;
		
	}

	/**
	 * This removes an element from a specified index position in the list
	 * 
	 * @param index the position we want to remove an object from the list
	 * @return the object we have removed
	 */
	@Override
	public Object remove(int index) {
		
		//Throws exception if invalid index
		checkIndex(index);
		
		Object removedObject = elements[index];
		
		//This removes the element and shifts each index element down by one
		for(int i = index + 1; i < size; i++)
		{
			elements[i-1] = elements[i];
		}
		
		//Removes last duplicate element
		elements[--size] = null;
		
		return removedObject;
	}

	/**
	 * This method retrieves an element from the list at the specified position
	 * 
	 * @param index the position we want to retrieve the element
	 * @return the object that we are trying to locate at the specified index
	 * 
	 */
	@Override
	public Object get(int index) {

		//Throws exception if invalid index number
		checkIndex(index);
		
		return elements[index];
	}

	/**
	 * This method checks to see if an index entered by the user is valid and if not it throws an exception
	 * 
	 * @param index the index we want to check
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public void checkIndex(int index) {
		
		if(index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException("The index you have provided is out of range");
		}
		
	}

	/**
	 * This method simply returns the index position of the object in the list
	 * and returns -1 if the method does not find an object
	 * 
	 * @param theElement this is the object we want to retrieve the index of
	 * @return the position of the element specified
	 */
	@Override
	public int indexOf(Object theElement) {
		
		for(int i = 0; i < size; i++) {
			
			if (elements[i].equals(theElement))
			{
				return i;
			}
			
			//Report back -1 of no index found
		}
		return -1;
	}

	/**
	 * This method returns the size of the list (how many elements are currently in the list)
	 * 
	 * @return the number of elements in the list
	 */
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * This element retrieves the length of the list
	 * 
	 * @return the number of indexed positions in the list (used or unused)
	 */
	public int getLength()
	{
		return elements.length;
	}

	/**
	 * This method tells us whether or not the list is empty or not by returning a simple boolean value
	 * 
	 * @return empty status if the list
	 */
	@Override
	public boolean isEmpty() {
		
		return size == 0;
	}
	
	//Prints all elements in the list
	public void printList()
	{
		if(isEmpty())
		{
			System.out.println("The list is empty, no elements to display.");
		}
		else
		{
			//for(int i = 0; i < size; i++) {
				//System.out.println(elements[i]);
			System.out.println(this.toString());
			//}
		}
	}
	
	/**
	 * This method returns the entire list 
	 * 
	 * @return the list of elements
	 */
	public Object[] getList()
	{
		return elements;
	}
	
	/**
	 * This overrides the toString() method in the Object method which would normally return the 6 digit hex code address in memory
	 * We use a StringBuffer here instead of concatenating Strings because StringBuffers are mutable meaning they can be changed whereas
	 * a String literal would take up more places in memory every time we made a change
	 * 
	 * @return the string of the object we have set
	 */
	//toString to make printing of object easier
	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer("[");
		
		//String listString = "List: \n";
		for(int i = 0; i < size; i++)
		{	if(elements[i] == null)
			{
				sb.append("null, ");
			}
			else
			{
				sb.append(elements[i].toString() + ", ");
			}

		}
		
		if(size > 0)
		{
			sb.delete(sb.length() - 2, sb.length()); //Removes final comma
		}
		sb.append("]");
		
		//Returns the full string we made  by creating an immutable String object
		return new String(sb);
	}
	
}
