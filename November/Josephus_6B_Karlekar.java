// name: Sweta Karlekar           date: 11/13/13

import java.io.*;
import javax.swing.JOptionPane;
import java.util.Scanner; 

public class Josephus_6B_Karlekar
{
   public static void main(String[] args) throws FileNotFoundException
   {
      while(true)
      {
         int numNames = getNumNames(); 
         int numN = getNumN(); 
         ListNode pointer = fillWithNumbers(numNames); 
         print(pointer); 
         pointer = findWinner(numNames, numN, pointer);
         int winpos = Integer.parseInt(pointer.getValue() + ""); 
         ListNode namepointer = fillWithNames(numNames);
         replaceAt(namepointer, "Josephus", winpos); 
         System.out.println("**** Now start all over. ****"); 
         print(namepointer);
         namepointer = findWinner(numNames, numN, namepointer);
         System.out.println("_______________________________"); 
         System.out.println(); 
      }
   }
   
   public static int findWinNumber(int numNames, int numN, ListNode pointer)
   {
       for(int i = 0; i < numNames-1; i++)
      {
         pointer = remove(pointer, numN); 
         print(pointer);  
      }    
      int winner = Integer.parseInt(pointer.getValue()+"");
      return winner; 
   }
   public static ListNode findWinner(int numNames, int numN, ListNode pointer)
   {
     for(int i = 0; i < numNames-1; i++)
      {
         pointer = remove(pointer, numN); 
         print(pointer);  
      }    
      return pointer; 
   } 
   public static ListNode fillWithNames(int numNames) throws FileNotFoundException
   {
      Scanner infile = new Scanner(new File("J_names.txt"));
      ListNode filler = new ListNode(infile.next(), null);  
      ListNode pointer = filler; 
      for(int i = 0; i < numNames-1; i++)
      {
         ListNode temp = new ListNode(infile.next(), null); 
         filler.setNext(temp); 
         filler = filler.getNext();
      }
      filler.setNext(pointer); 
      filler = filler.getNext(); 
      
      return filler;

   }
   public static ListNode fillWithNumbers(int numNames)
   {
      ListNode temp = new ListNode(numNames + "", null); 
      ListNode pointer = temp; 
      for(int i = numNames-1; i > 0; i--)
      {
         temp = new ListNode(i + "", temp); 
      }
      pointer.setNext(temp);
      pointer = pointer.getNext();
      return pointer; 
   }
   public static int getNumNames()
   {
      int numNames = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of names:(1-20)"));
      if(numNames == -1)
      {
         JOptionPane.showMessageDialog(null, "Goodbye!");
         System.exit(0);  
      }
      return numNames;  
   } 
   public static int getNumN()
   {
      int numN = Integer.parseInt(JOptionPane.showInputDialog("Enter the N:")); 
      if(numN == -1)
      {
         JOptionPane.showMessageDialog(null, "Goodbye!"); 
         System.exit(0); 
      } 
      return numN; 
   }
   /* removes the node p after counting n nodes.
	  */    
   private static ListNode remove(ListNode p, int n)
   {
      ListNode temp = p; 
      if(n == 1)
      {
         while(temp.getNext().getValue() != p.getValue())
            temp = temp.getNext(); 
         n = 2; 
      }
      for(int i = 1; i < n-1; i++)
         temp = temp.getNext(); 

      temp.getNext().setValue(null);
      temp.setNext(temp.getNext().getNext());
      temp = temp.getNext();  
      
      return temp;
   }
	
   /* prints the circular linked list.
	  */      
   public static void print(ListNode p)
   {
      if(p == null)
      {
         System.out.println("[]");
         return;
      }
      ListNode pointer = new ListNode(); 
      for(ListNode x = p; x != null; x = x.getNext())
      {
         System.out.print(p.getValue() + " "); 
         if(x.getValue() == p.getValue())
         {
            pointer = p; 
            break; 
         }
      }
      pointer = p.getNext(); 
      while(pointer != p)
      {
         System.out.print(pointer.getValue() + " "); 
         pointer = pointer.getNext();  
      
      }
      System.out.println(); 
   }
	
 /* helper method to build the list.  Creates the node, then
    inserts it in the circular linked list.
	 */  
   private static ListNode insert(ListNode p, Object obj)
   {
      ListNode prev = new ListNode(obj, p); 
      ListNode pointer = new ListNode();  
      for(ListNode x = p; x != null; x = x.getNext())
      {
         if(x.getNext() == p)
         {
            pointer = p; 
            break; 
         }
      }
      prev.setNext(p.getNext()); 
      pointer.setNext(prev);
      
      return prev; 
   }

	
	/* replaces the value (the string) at the winning node.
       */	
   private static void replaceAt(ListNode p, Object obj, int pos)
   {
      for(int i = 1; i < pos; i++)
      {
         p = p.getNext(); 
      }
      p.setValue(obj); 
      
   }
}