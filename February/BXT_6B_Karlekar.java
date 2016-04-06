   //Name: Sweta Karlekar     Date: 2/16/14
import java.util.*;

 	/***********************************
	Represents a binary expression tree.
	The BXT can build itself from a postorder expression.  It can
	evaluate and print itself. It also prints an inorder string and a preorder string.  
	************************************/
class BXT
{
   private int count;
   private TreeNode root;
   
   public BXT()
   {
      count = 0;
      root = null;
   }
   public BXT(Object obj)
   {
      count = 1;
      root = new TreeNode(obj, null, null);
   }
      /***********************
   	Builds a BXT from a postfix expression.  Uses a helper stack of TreeNodes.
   	****************************/
   public void buildTree(String str)
   {
      Stack<TreeNode> helper = new Stack<TreeNode>();
      StringTokenizer st = new StringTokenizer(str); 
      while(st.hasMoreTokens())
      {
         String holder = st.nextToken(); 
         if(!isOperator(holder))
         {
            TreeNode temp = new TreeNode(holder);
            helper.push(temp);  
         }
         else
         {
            TreeNode one = helper.pop(); 
            TreeNode two = helper.pop(); 
            TreeNode head = new TreeNode(holder, two, one); 
            helper.push(head); 
         }
            
      }
      root = helper.pop();
   }
   public double evaluateTree()
   {
      return evaluateNode(root);
   }
   private double evaluateNode(TreeNode root)  //recursive
   {
      if(root.getLeft() == null && root.getRight() == null)
      {
         return Double.parseDouble(root.getValue() + ""); 
      }
      double leftValue = evaluateNode(root.getLeft()); 
      double rightValue = evaluateNode(root.getRight());
      return computeTerm(root.getValue() + "", leftValue, rightValue);           
   }
   private double computeTerm(String s, double a, double b)
   {
      if(s.equals("+"))
         return a+b; 
      if(s.equals("-"))
         return a-b; 
      if(s.equals("*"))
         return a*b; 
      return a/b;
   }
   private boolean isOperator(String s)
   {
      String operators = "+/*-"; 
      if(operators.contains(s))
         return true; 
      return false; 
   }
   public void display()
   {
      TreeLab_6B_Karlekar.display(root, 0); 
   }
   public void inorderTraverse()
   {
      TreeLab_6B_Karlekar.inorderTraverse(root); 
   }
   public void preorderTraverse()
   {
      TreeLab_6B_Karlekar.preorderTraverse(root);
   }
}
	
	/*******************
	Driver for a binary expression tree class.
	Input: a postfix string, each token separated by a space.
	**********************/
public class BXT_6B_Karlekar
{
   public static void main(String[] args)
   {
      BXT tree = new BXT();
      Scanner sc = new Scanner(System.in);
      System.out.print("Input postfix string: ");
      String s =  sc.nextLine();   // 14 -5 / ,   3 4 5 + *  ,  2 3 + 5 / 4 5 - *
      tree.buildTree(s);
      tree.display();
      System.out.print("Infix order:  ");
      tree.inorderTraverse();
      System.out.print("\nPrefix order:  ");
      tree.preorderTraverse();
      System.out.print("\nEvaluates to " + tree.evaluateTree());
   }
}
	
