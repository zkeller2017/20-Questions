/**
	The Stack interface is a data structure built off of the Linked List
	framework that acts like a stack of paper, where objects are added
	to the top and taken from the top.
	@author Zachary Keller
	@version Final

*/
public interface Stack<E>
{
	/**
		Adds a new item to the top of the stack
		@param item the object being added
	*/
	void push(E item);
	/**
		Removes and returns the first item on the Stack
		@return the value of the first item
	*/	
	E pop();
	/**
		Returns the object held on the top of the stack
		@return the object on the top of the stack
	*/
	E peek();
	/**
		Whether or not the stack is empty
		@return Whether or not the stack is empty
	*/
	boolean isEmpty();
	/**
		A string representation of the stack
		@return A string representation of the stack
	*/
	String toString();
}