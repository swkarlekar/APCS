import java.util.*;
import java.io.*;
public class TextFileBST_6B_Karlekar
{
   public static void main(String[] args) throws Exception
   {
      PrintStream outfile = new PrintStream(new FileOutputStream("output.txt")); //create outfile
      BSTobject<String> treeString = new BSTobject<String>(); //create BST
      fill(treeString); //fill BST with user-prompted word 
      System.out.print("Original Tree: " + "\n" + treeString + "\n"); //print out original tree
      preorderTraverse(treeString.getNode(), outfile);  //print BST to outfile 
      Scanner infile = new Scanner(new File("output.txt")); //create a Scanner to read in outfile
      BSTobject<String> newTree = new BSTobject<String>(); //create a new BSTobject to read in the outfile
      while(infile.hasNext()) //fill new tree 
      {
         newTree.add(infile.next()); 
      }
      System.out.print("New Tree: " + "\n" + newTree + "\n"); //print out new Tree that was made using outfile
        
   }
   public static void fill(BSTobject<String> treeString)
   {
      Scanner keyboard = new Scanner(System.in); 
      System.out.print("Enter input string: "); 
      String input = keyboard.next(); 
      System.out.println(); 
      for(int i = 0; i < input.length(); i++)
         treeString.add(input.charAt(i) + ""); 
   }
   public static void preorderTraverse(Node<String> t, PrintStream outfile)
   {
      if(t == null)
         return;
      outfile.print(t.getValue() + " ");  //preorder visit
      preorderTraverse(t.getLeft(), outfile);         //recurse left
      preorderTraverse(t.getRight(), outfile);        //recurse right
      
   }


   
}