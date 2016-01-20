import java.util.Scanner;
import java.io.*;
/**
	The Questions class runs through a Binary Tree, where each node contains
	a yes or no question. When it hits a leaf (all leaves contain noun answer values),
	it will print the value on the screen, suggesting that is the answer. If it guesses
	incorrectly, it will ask the user for the actual answer and a questions that could differentiate
	that answer from the one this gave. It will then turn the leaf node into that new questions, with each
	of its children being the answers. Once the program is finished running, it will copy the new tree
	into a text document, and the next time it runs it will start with that saved document.
	@author Zachary Keller
	@version final
*/
public class Questions
{
	/**
		The Binary Tree in which all the questions and answers are stored in the form of
		leaf nodes
	*/
	private BinaryTree<String> tree;
	/**
		The string of all the nodes of the tree that is copied from the text file
	*/
	private String values;
	
	/**
		The Constructor for Questions either calls the function that populates the binary tree
		from the save file or, if it is empty, initializes the tree with an initial question
		and two possible answers
	*/
	public Questions()
	{
		tree = new BinaryTree<String>();
		readFile();
		//System.out.println(tree);
		if (tree.size() == 1)		
		{
		
			tree.setValue("Is it Alive");
			tree.setLeft(new BinaryTree<String>("Computer"));
			tree.setRight(new BinaryTree<String>("Tree"));
		}
	}
	
	/**
		This function contains a while loop that keeps the game running while the 
		user still wants to play
	*/
	public void play()
	{
		String yesno = "yes";
		while (yesno.equals("yes"))
		{
			run(tree);
			System.out.println("Play Again?");
			Scanner input = new Scanner(System.in);
			yesno = input.nextLine();
		}
		save();
	}
	
	/**
		This populates the binary tree of questions from the String values that was
		read from the file. It does this by looking for parantheses and commas, and dividing
		up the string accordingly
		@param b The Binary Tree that a value is being worked on recursively
		@return whether or not populating was a success
	*/
	private boolean populate(BinaryTree<String> b)
	{
		//System.out.println("values: " + values);
		String s = "";
		if (values.length() == 0)
		{
			return true;
		}
		if (values.charAt(0) == 41)
		{
			values = values.substring(1);
			return populate(b);
		}
		//System.out.println("values before left: " + values);
		if (values.charAt(0) == 40)
		{
			values = values.substring(1);
			int i = 0;
			while (values.substring(i,i+1).equals(",") == false && values.substring(i,i+1).equals("(") == false && values.substring(i,i+1).equals(")") == false)
			{
				s = s + values.charAt(i);
				i++;
			}
			b.setLeft(new BinaryTree<String>(s));
			//System.out.println("tree: " + tree);
			values = values.substring(i);
			if (values.charAt(0) == 40)
			{
				//System.out.println("hitting go left");
				populate(b.left());
			}
			populate(b);
		}
		s="";
		//System.out.println("values before right: " + values);
		if (values.charAt(0) == 44)
		{
			values = values.substring(1);
			int i = 0;
			while (values.substring(i,i+1).equals(")") == false && values.substring(i,i+1).equals("(") == false && values.substring(i,i+1).equals(")") == false)
			{
				s = s + values.charAt(i);
				i++;
			}
			b.setRight(new BinaryTree<String>(s));
			//System.out.println("tree: " + tree);
			values = values.substring(i);
			if (values.charAt(0) == 40)
			{
				//System.out.println("hitting go right");
				populate(b.right());
			}
			
		}
		return true;
	}
	
	/**
		readFile runs through the text file and puts it all into the String values
	*/
	private void readFile()
	{
		File file = new File("Saver.txt");	
		Scanner input = null;
		try
		{
			input = new Scanner(file);
		}
		catch (FileNotFoundException ex)
		{
			System.out.println(" Cannot open " + "Saver.txt" );
			System.exit(1);
		}
		String s = "";
		while (input.hasNext())
		{
			s = input.nextLine();
		}
		//System.out.println("s: " + s);
		if (s.length() > 0 )
		{
			int i = 0;
			while ( s.charAt(i) != 40 )
			{
				i++;
			}
			String head = s.substring(0,i);
			s = s.substring(i);
			tree.setValue(head);
			//System.out.println("Tree init: " + tree);
			values = s;
			populate(tree);
		}
		
		
	}
	
	/**
		run actually runs the game, asking the user questions and navigating the tree
		according to the answers until it gets to a final answer
		@param curr The Binary Tree that contains the question or answer going to be presented
		to the user
		@return whether or not the run was successful 
	*/
	public boolean run(BinaryTree<String> curr)
	{
		if (curr.isLeaf())
		{
			System.out.println("Is it a " + curr.value());
			learn(curr);
			return true;
		}
		System.out.println(curr.value());
		Scanner input = new Scanner(System.in);
		String answer = input.nextLine();
		if (answer.equals("yes"))
		{
			run(curr.right());
		}
		else
		{
			run(curr.left());
		}
		return true;
		 
	}
	
	/**
		Copies the Binary Tree to the saver text file
	*/
	public void save()
	{
		String s = tree.toString();
		
		PrintWriter outputFile;
  		
  		try
  		{
  			outputFile =
                 new PrintWriter(new FileWriter("Saver.txt"));
            outputFile.println(s);
            outputFile.close();
    	}
    	catch(IOException e)
		{
			System.out.println("Error creating file");
			System.exit(1);
		}
	}
	
	/**
		If it gives the wrong answer, this learns from the user the correct
		answer and a question that can differentiate it from the one it gave,
		and then adjusts the tree accordingly
		@param curr The node of the tree with the incorrect answer
	*/
	private void learn(BinaryTree<String> curr)
	{
		System.out.println("Is the answer correct?");
		Scanner input = new Scanner(System.in);
		String correct = input.nextLine();
		if (correct.equals("no"))
		{
			curr.setLeft(new BinaryTree<String>(curr.value()));
			System.out.println("What were you thinking of?");
			input = new Scanner(System.in);
			String answer = input.nextLine();
			curr.setRight(new BinaryTree<String>(answer));
			System.out.println("What is a question that could differentiate your answer from the one I gave?");
			input = new Scanner(System.in);
			String question = input.nextLine();
			curr.setValue(question);
		
		
		}
		
	}
	
}