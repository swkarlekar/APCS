//Name: Sweta Karlekar  Date: 1/8/2013
import java.io.*; 
import java.util.*; 
import javax.swing.*; 

public class ParenMatch_6B_Karlekar
{
   public static final String LEFT = "([{<"; 
   public static final String RIGHT = ")]}>"; 
   public static void main(String[] args)
   {
     while(true)
     {
      String input = JOptionPane.showInputDialog("Enter Expression: ");
      if(input.equals("-1"))
      {
         System.out.println("Good-bye!"); 
         System.exit(0);
      }  
      if(check(input))
         System.out.println(input + " is good"); 
      else
         System.out.println("No. Bad. " + input);
     } 
   }
   public static boolean check(String s)
   {
      boolean returnable = true; 
      Stack<String> stack = new Stack<String>(); 
      for(int i = 0; i < s.length(); i++)
      {
         String temp = s.charAt(i) + "";
         if(LEFT.contains(temp))
            stack.push(temp); 
         else if(RIGHT.contains(temp))
         {
            if(stack.isEmpty())
               return false; 
            String temp2 = stack.pop(); 
            if(RIGHT.indexOf(temp) != LEFT.indexOf(temp2))
               return false;
         }   
      }
      if(!stack.isEmpty())
         return false; 
      return returnable; 
   }
}