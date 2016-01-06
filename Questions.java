import java.util.Scanner;
import java.io.*;
public class Questions
{
	private BinaryTree<String> tree;
	
	public Questions()
	{
		tree = new BinaryTree<String>();
		tree.setValue("Is it Alive");
		tree.setLeft(new BinaryTree<String>("Computer"));
		tree.setRight(new BinaryTree<String>("Tree"));
	}
	
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
	
	private void saved()
	{
		String pathname = "Saved.txt";
		File file = new File(pathname);	
		Scanner input = null;
		try
		{
			input = new Scanner(file);
		}
		catch (FileNotFoundException ex)
		{
			System.out.println(" Cannot open " + pathname );
			System.exit(1);
		}
		Queue<String> tempString = new LinkedList<String>;
		while( input.hasNextLine() )
		{
			String s = input.nextLine();
			tempString[index] = s.split(",");
			index += 1;
		}
	}
	
	public boolean run(BinaryTree<String> curr)
	{
		if (curr.isLeaf())
		{
			System.out.println("Is it " + curr.value());
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
	
	public void save()
	{
		String s = "";
		for (String a: tree)
		{
			s = s + a + ",";
		}
		
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