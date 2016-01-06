import java.lang.Iterable;
import java.util.Iterator;
/**
	The Binary Tree class is a node of a Tree-Structure. The node has two
	pointers to a left and right subtree. This node also holds a value. There are
	various accessors and modifiers in this class, as well as functions that return 
	information about the entire tree.
	@author Zachary Keller
	@version final

*/
public class BinaryTree<E> implements Iterable<E>
{
	/**
		The value held in this node of the tree
	*/
	protected E value;
	
	/**
		A pointer to the left branch subtree
	*/
	protected BinaryTree<E> left;
	
	/**
		A pointer to the right branch subtree
	*/
	protected BinaryTree<E> right;
	
	/**
		Constructor- Creates a new Binary Tree with given values
		@param v The value of this particular node of the tree
		@param l The left branch
		@param r The right branch
	*/
	public BinaryTree(E v, BinaryTree<E> l, BinaryTree<E> r)
	{
		value = v;
		left = l;
		right = r;
	}
	
	/**
		Constructor- creates a new Binary Tree with a stored value,
		but without a left or right branch
		@param v The value stored by this node
	*/
	public BinaryTree(E v)
	{
		this(v, null, null);
	}
	
	/**
		Constructor- Calls the first Constructor with all null values
	*/
	public BinaryTree()
	{
		this(null, null, null);
	}
	
	/**
		Returns the left branch of the tree
		@return The left branch of the tree
	*/
	public BinaryTree<E> left()
	{
		return left;
	}
	
	/**
		Returns the right branch of the tree
		@return The right branch of the tree
	*/
	public BinaryTree<E> right()
	{
		return right;
	}
	
	/**
		Returns the value this node of the tree is holding
		@return The value this node of the tree is holding
	*/
	public E value()
	{
		return value;
	}
	
	/**
		Determines whether or not this tree is a leaf,
		meaning that it has no subtrees
		@return Whether or not it is a leaf
	*/
	public boolean isLeaf()
	{
		return (left == null && right == null);			
	}
	
	/**
		Sets the left branch of the tree to a new Binary Tree
		@param The new Tree
	*/
	public void setLeft(BinaryTree t)
	{
		left = t;
	}
	
	/**
		Sets the right branch of the tree to a new Binary Tree
		@param The new Tree
	*/
	public void setRight(BinaryTree t)
	{
		right = t;
	}
	
	/**
		Sets or changes the value that this tree node is holding
		@param The new value
	*/
	public void setValue(E v)
	{
		value = v;
	}
	
	/**
		Return the maximum path length to a leaf from this node in the tree
		@return The longest route to a leaf
	*/		
	public int height()
	{
		if (isLeaf())
		{
			return 0;
		}
		if (left == null)
			return (1 + right.height());
		else if (right == null)
			return (1 + left.height());
		else
			return 1 + Math.max(left.height() , right.height());
	}
	
	/**
		Returns total number of descendants (subtrees) of this node, including current node
		@return The total number of subtrees
	*/
	public int size()
	{
		if (isLeaf())
		{
			return 1;
		}	
		if (left == null)
			return (1 + right.size());
		else if (right == null)
			return (1 + left.size());
		else
			return (1 + left.size() + right.size());
	}
	
	/**
		Returns true if adding a node to tree would increase its height.
		The entire bottom row of this tree must be complete.
		@return If the tree is full or not
	*/
	public boolean isFull()
	{
		if ((left == null && right != null) || (right == null && left != null))
		{
			return false;
		}
		if (isLeaf())
		{
			return true;
		}
		if (left.height() != right.height())
		{
			return false;
		}
		else
			return (left.isFull() && right.isFull());
	}
	
	/**
		Returns a string representation of the binary tree
		@return A string representation of the binary tree
	*/
	public String toString()
	{
		if (isLeaf())
		{		
			return  "" + this.value();
		}
		if (left == null)
			return value + "(" + "EMPTY, " + right.toString() + ")";
		else if (right == null)
			return  this.value + "(" + left.toString() + ", EMPTY" + ")";
		else
			return  this.value + "(" + left.toString() + ", " + right.toString() + ")";
	}
	
	/**
		Returns true if the difference of heights of subtrees at
		every node is no greater than one.
		@return whether or not the tree is balanced 
	*/
	public boolean isBalanced()
	{

		if (isLeaf())
		{
			return true;
		}
		if (!(right.height() - left.height() < 2 && right.height() - left.height() > -2))
			return false;
		return left.isBalanced() && right.isBalanced();
	}
	
	/**
		Returns true if tree has minimal height and any holes in the
		tree appear in the last level to the right.
		@return If the tree is complete
	*/
	public boolean isComplete()
	{
		if (isLeaf())
		{
			return true;
		}
		if (left == null)
			return false;
		if (right == null)
		return left.height()== 0;
		if (left.height() - right.height() == 1)
		{
			if (left.isComplete() && right.isFull())
			{
				return true;
			}
		}
		else if (left.height() - right.height() == 0)
		{
			if (left.isFull() && right.isComplete())
			{
				return true;
			}
		}
		return false;
	}
	
	/**
		Creates a new Iterator that runs through the Binary tree
		using the Left, Root, Right algorithm.
		@return a new inOrderIterator
	*/
	public inOrderIterator<E> inOrderIterator()
	{
		return new inOrderIterator<E>(this);
	}
	
	/**
		Creates a new Iterator that runs through the Binary tree
		using the Root, Left, Right algorithm.
		@return a new preOrderIterator
	*/
	public preOrderIterator<E> preOrderIterator()
	{
		return new preOrderIterator<E>(this);
	}
	
	/**
		Creates a new Iterator that runs through the Binary tree
		using the Left, Right, Root algorithm.
		@return a new postOrderIterator
	*/
	public postOrderIterator<E> PostOrderIterator()
	{
		return new postOrderIterator<E>(this);
	}
	
	/**
		Chooses one of the preceding iterators to return. Needed because
		This class implements Iterable
		@return a new Iterator
	*/
	public inOrderIterator<E> iterator()
	{
		return new inOrderIterator<E>(this);
	}
	
	
	
	
	
	
}