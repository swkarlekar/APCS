//Name:      Date:
import java.util.Scanner;
/****************************************************************
Practice with a Binary Search Tree. Uses TreeNode.
	Prompt the user for an input string.  Build a Binary Search Tree 
using Comparables.  Display it as a sideways tree (take the code 
from TreeLab).  Prompt the user for a target and delete that node, if it
exists. 
*****************************************************************/
public class BinarySearchTreeDelete_6B_Karlekar
{ 
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("Input string: ");
      String s = sc.nextLine();
   									//Case 1:  		ECSBPWANR 
   								//Case 2a:  	SNTPOR    
   								//Case 2b:	   HBRNVJSZIK  
   								//Case 3.a.i:  DBNACFSEJHM 
   								//Case 3.a.ii: NFSAKPXGQ 
   								//Case 3b:     RNVGPCAE  
      TreeNode t = null;
      for(int x = 0; x<s.length(); x++)
         t = insert(t, s.substring(x, x+1));
      display(t, 0);
     
      System.out.print("Delete? ");
      String target = sc.next();
      if(delete(t, target))
         System.out.println("\n" + target+" deleted.");
      else
         System.out.println("\n" + target+" not found");
      display(t, 0);       
   }
   
   public static TreeNode insert(TreeNode t, String s)
   {  	
      return BinarySearchTree_6B_Karlekar.insert(t, s); 
   }
   
   public static void display(TreeNode t, int level)
   {
      if(t == null)
         return;
      display(t.getRight(), level + 1); //recurse right
      for(int k = 0; k < level; k++)
         System.out.print("\t");
      System.out.println(t.getValue());
      display(t.getLeft(), level + 1); //recurse left
   }
   public static boolean delete(TreeNode current, Object target)
   {
      TreeNode parent = current; 
      TreeNode temp = current; 
      int compare = ((Comparable)target).compareTo(current.getValue());
      while(compare != 0)
      {
         parent = temp; 
         if(compare < 0)
            temp = temp.getLeft(); 
         else if(compare > 0)
            temp = temp.getRight(); 
         else 
            break; 
         if(temp == null)
            return false; 
         compare = ((Comparable)target).compareTo(temp.getValue()); 
      }
      case1(temp, parent); 
      case2(temp, parent);
      case3(temp, parent); 
      
      return true;  //never reached
   }
   private static void case1(TreeNode temp, TreeNode parent)
   {
      if(temp.getLeft() == null && temp.getRight() == null) 
      {
         if(parent.getLeft() == temp)
            parent.setLeft(null); 
         else
            parent.setRight(null); 
      }
   }
   private static void case2(TreeNode temp, TreeNode parent)
   {
      if(temp.getLeft() == null && temp.getRight() != null)
      {
         if(parent.getLeft() == temp)
            parent.setLeft(temp.getRight());
         else
            parent.setRight(temp.getRight()); 
      } 
      if(temp.getRight() == null && temp.getLeft() != null)
      {
         if(parent.getRight() == temp)
            parent.setRight(temp.getLeft()); 
         else
            parent.setLeft(temp.getLeft()); 
      }
   
   }
   private static void case3(TreeNode temp, TreeNode parent)
   {
      if(temp.getRight() != null && temp.getLeft() != null)
      {
         TreeNode replaceParent = findBiggest(temp); 
         if(temp.getLeft().getRight() == null)
         {
            temp.setValue(replaceParent.getLeft().getValue()); 
            case1(replaceParent.getLeft(), replaceParent); 
            if(replaceParent.getLeft() != null)
               case2(replaceParent.getLeft(), replaceParent); 
         }
         else
         {
            temp.setValue(replaceParent.getRight().getValue());
            case1(replaceParent.getRight(), replaceParent); 
            if(replaceParent.getRight() != null)
               case2(replaceParent.getRight(), replaceParent); 
         }
      }
   
   }
   private static TreeNode findBiggest(TreeNode current)
   {
      if(current.getLeft().getRight() == null)
         return current; 
      TreeNode temp = current; 
      temp = temp.getLeft(); 
      while(temp.getRight() != null && temp.getRight().getRight() != null)
      {
         temp = temp.getRight(); 
      }
      return temp; 
   }
}