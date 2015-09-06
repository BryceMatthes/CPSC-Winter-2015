/**
 * This interface extends the StackInt interface by adding 4 methods
 * 
 * ID:10147880
 * @author Bryce Matthes
 * @date March 27 2015
 * @version	1.0
 */

public interface BoundedStackInt extends StackInt{

	/**
	 * Used to return the current size of the stack (how many current elements)
	 * 
	 * @return the size of the stack
	 */
	public int size();
	/**
	 * Used to show the maximum number of elements of the stack
	 * 
	 * @return the integer value of max size
	 */
	public int capacity();
	
	/**
	 * Used to check if the stack if full
	 * 
	 * @return returns true if full (size == max), false else
	 * @throws EmptyStackException if the stack is empty
	 */
	public boolean isFull();
	/**
	 * Pushes the String object x onto the top of the stack.
	 * 
	 * @param x String object to be pushed onto the stack.
	 * @throws FullStackException if the stack is full
	 */
	public void push(String x);

	

}