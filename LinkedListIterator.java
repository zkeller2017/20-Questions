import java.util.NoSuchElementException;
import java.util.Iterator;

/*
	The Iterator Class for Linked Lists
	@author Zachary Keller
	@version Final
**/
public class LinkedListIterator<E> implements Iterator<E>
{
/*
	The ListNode that the Iterator is currently on
**/
	private ListNode<E> curr;
	
	
/*
	Constructor for a new Iterator
	@param head The first ListNode of the LinkedList being traversed
**/
	public LinkedListIterator(ListNode head)
	{
		curr = head;
	}
	
/*
	Determines whether or not the iterator has finished traversing the LinkedList
	@return Whether or not the iterator has finished traversing the LinkedList
**/
	public boolean hasNext()
	{
		if (curr == null)
		{
			return false;
		}
		return true;
	}
	
/*
	Returns the object in the next ListNode of the Linked List
	@return The object in the next ListNode of the Linked List
**/
	public E next()
	{
		if (! hasNext())
		{
			throw new NoSuchElementException("End of Linked List");
		}
		ListNode<E> holder = curr;
		curr = curr.getNext();
		return holder.getItem();
		
	}
	
}
	
