/**
	The ListNode class comprises of an item that is stored
	and a pointer to another ListNode. These Nodes can be 
	linked together to form a Linked List
	@author Zachary Keller
	@version final
*/
public class ListNode<E>
{
	/**
		The value that the ListNode holds
	*/
	private E item;
	
	/**
		The next ListNode that this one will point to
	*/
	private ListNode<E> next;
	
	/**
		Constructor for ListNode that takes in a value to hold
		and another ListNode that it will point to
		@param object The item the ListNode will hold
		@param pointer The next listNode this one will point to
	*/
	public ListNode(E object, ListNode<E> pointer)
	{
		item = object;
		next = pointer;
	}
	
	/**
		Constructor for ListNode that takes in a value to hold, but
		no pointer towards another ListNode
		@param object The item the ListNode will hold
	*/
	public ListNode(E object)
	{
		this(object, null);
	}
	
	/**
		Returns the item contained in the ListNode
		@return The Item it holds
	*/
	public E getItem()
	{
		return item;
	}
	
	/**
		Returns the pointer to the next ListNode, like in a
		Linked List
		@return The next ListNode
	*/
	public ListNode<E> getNext()
	{
		return next;
	}
	
	/**
		Sets the object that the ListNode holds to a given value
		@param object The new value for the ListNode to hold	
	*/
	public void setItem(E object)
	{
		item = object;
	}
	
	/**
		Sets the next ListNode that this ListNode will point to
		@param pointer The new ListNode for this ListNode to point to
	*/
	public void setNext(ListNode<E> pointer)
	{
		next = pointer;
	}
	
	/**
		Creates a String representation of the ListNode
		@return the String representation of the ListNode
	*/
	public String toString()
	{
		if (item != null)
			return item.toString();
		return "null";
	}

}