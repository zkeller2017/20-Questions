/**
	The Queue interface is a data structure built off of the Linked List
	framework that acts like a line would in a store, where objects are added
	to the end and taken from the top.
	@author Zachary Keller
	@version Final

*/

public interface Queue<E>
{
	/**
		Adds a new item to the bottom of the queue
		@param item the object being added
	*/
	void offer(E item);
	/**
		Removes and returns the first item in the Queue
		@return the value of the first item
	*/	
	E poll();
	/**
		Returns the object held in the top of the queue
		@return the object on the top of the queue
	*/
	E peek();
	/**
		Whether or not the queue is empty
		@return Whether or not the queue is empty
	*/
	boolean isEmpty();
	/**
		A string representation of the queue
		@return A string representation of the queue
	*/
	String toString();
}