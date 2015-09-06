/**
 * This class implements the functionality defined in the interface StackInt
 *
 * Based on the source of Majid Ghaderi posted in the skeleton 
 * 
 * ID:10147880
 * @author(s) Bryce Matthes
 * @date March 27 2015
 * @version	1.0
 */

public class BoundedStack implements BoundedStackInt{
	private String[] stack;
	private int top;

	/*
	* Constructor for the BoundedStack, creates the variable top = -1 and makes a stack of size (maxSize)
	*
	* @param maxSize - the set the max size for the stack 
	*/
	public BoundedStack(int maxSize){
		top = -1;
		stack = new String[maxSize];
	}
	
	/**
	 * Used to return the current size of the stack (how many current elements)
	 * 
	 * @return the size of the stack
	 */
	public int size(){
		return (top + 1); //return the size (populated elements) of the stack
	}

	/**
	 * Used to show the maximum number of elements of the stack
	 * 
	 * @return the integer value of max size
	 */
	public int capacity(){
		return stack.length; //return the max size of the stack
	}

	/**
	 * Used to check if the stack if full
	 * 
	 * @return returns true if full (size == max), false else
	 * @throws EmptyStackException if the stack is empty
	 */
	public boolean isFull(){
		if (this.size() == this.capacity()){ //if size = max capacity
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Pushes the String object x onto the top of the stack.
	 * 
	 * @param x String object to be pushed onto the stack.
	 */
	public void push(String x){
		//Check if the size of the stack out be larger than the max
		if (top+1 == stack.length){
			throw new FullStackException();
		}
		top = top + 1;
		stack[top] = x;
	}

	/**
	 * Returns the String object at the top of the stack and removes it
	 * 
	 * @return String object at the top of the stack
	 * @throws EmptyStackException if the stack is empty
	 */
	public String pop(){
		//Checked to see if the size is 0
		if (top == -1){
			throw new EmptyStackException(); //throws EmptyStackException
		}
		String x = stack[top];
		top = top - 1;
		return x;
	}

	/**
	 * Tests whether the stack is empty.
	 * 
	 * @return true if the stack is empty, false otherwise
	 */
	public boolean isEmpty(){
		if (top==-1){
			return true;
		}
		else{
		 return false;
		}
	}
}