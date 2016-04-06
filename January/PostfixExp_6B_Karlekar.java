import java.io.*; 
import java.util.*; 
import javax.swing.*; 

public class PostfixExp_6B_Karlekar
{
   public static void main(String[] args)
   {
      while(true)
      {
         String input = JOptionPane.showInputDialog("Please enter a valid postfix expression: "); 
         if(input.equals("-1"))
         {
            System.out.println("Good-bye!"); 
            System.exit(0);
         }  
         System.out.println(input + " = " + eval(input)); 
      } 
   }
   public static int eval(String str)
   {
      Stack<Integer> stacks = new Stack<Integer>(); 
      for(int i = 0; i <str.length(); i++)
      { 
         if(!isOperator(str.charAt(i)))
            stacks.push(Integer.parseInt(str.charAt(i)+"")); 
         else
         {
            int b = stacks.pop(); 
            int a = stacks.pop(); 
            stacks.push(eval(a, b, str.charAt(i))); 
         }
      }
      return stacks.pop();       
   }
   private static int eval(int a, int b, char ch)
   {
      if(ch == '+')
         return a+b; 
      if(ch == '-')
         return a-b; 
      if(ch == '*')
         return a*b; 
      return a/b; 
   }
   public static boolean isOperator(char ch)
   {
      String operators = "+-*/"; 
      if(operators.contains(ch+""))
         return true; 
      return false; 
   }
}