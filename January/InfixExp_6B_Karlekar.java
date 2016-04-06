import java.io.*; 
import java.util.*; 
import javax.swing.*; 


public class InfixExp_6B_Karlekar
{
   public static void main(String[] args)
   {
      while(true)
      {
         String input = JOptionPane.showInputDialog("Please enter a valid infix expression: "); 
         if(input.equals("-1"))
         {
            System.out.println("Good-bye!"); 
            System.exit(0);
         }  
         System.out.println(input + " ------> " +  convert(input) + " ------> " + PostfixExp_6B_Karlekar.eval(convert(input))); 
      } 
   }
   public static String convert(String str)
   {
      String postfix = "";
      Stack<Character> stack = new Stack<Character>();  
      for(int i = 0; i < str.length(); i++)
      {
         char target = str.charAt(i); 

         if(target == '(')
            stack.push(target);
         else if(target == ')')
         {
            for(char temp = stack.pop(); temp != '('; temp = stack.pop())
               postfix += temp + ""; 
         } 
         else if(!PostfixExp_6B_Karlekar.isOperator(target))
         {
            postfix += target + ""; 
         }
         else
         {
            while(!stack.isEmpty() && stack.peek() != '(' && !isLower(stack.peek(), target))
               postfix = postfix + stack.pop();
             
            stack.push(target);  

         }
      }
      while(!stack.isEmpty() && stack.peek() != '(' && stack.peek() != ')')
         postfix = postfix + stack.pop(); 
      return postfix; 
   }
   public static boolean isLower(char c1, char c2)
   {
      String c1pres = ""; 
      String c2pres = ""; 
   
      if(c1 == '+' || c1 == '-')
         c1pres = "low"; 
      if(c2 == '+' || c2 == '-')
         c2pres = "low";
      if(c2 == '*' || c2 == '/')
         c2pres = "high";
      if(c2 == '*' || c2 == '/')
         c2pres = "high";
      
      if(c1pres.equals("low") && c2pres.equals("high"))
         return true; 
      return false;
   
       
   }
}