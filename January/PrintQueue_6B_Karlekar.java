import java.util.Queue; 
import java.util.LinkedList; 
import java.util.Scanner;


public class PrintQueue_6B_Karlekar
{
   private static Queue<Integer> q = new LinkedList<Integer>(); 
   private static int currentjob = 100; 
   private static int size = 0; 
   public static void main(String[] args)
   {
      while(true)
      {
         System.out.println(); 
         System.out.print("Add, Print, Delete, eXit: "); 
         Scanner keyboard = new Scanner(System.in);  
         String input = keyboard.next(); 
         if(input.equals("A"))
            addJob(); 
         else if(input.equals("P"))
            printJob(); 
         else if(input.equals("D"))
         {
            System.out.print("Enter job number: "); 
            deleteJob(Integer.parseInt(keyboard.next()));
         } 
         else if(input.equals("X"))
         {     
            System.out.println("Good-bye!"); 
            System.exit(0); 
         } 
         else
            System.out.println("Please input a valid command."); 
         for(Integer i : q)
            System.out.print(i + ", "); 
        
         System.out.println();
      }
   }
   public static void addJob()
   {
      q.add(currentjob); 
      currentjob++; 
      size++; 
   }
   public static void printJob()
   {
      if(q.isEmpty())
      {
         System.out.println("Error--job does not exist."); 
         return;
      }
      q.remove(); 
      size--; 
   }
   public static void deleteJob(int del)
   {
      if(q.isEmpty() || currentjob <= del)
      {
         System.out.println("Error--job does not exist."); 
         return; 
      }
      Queue<Integer> temp = new LinkedList<Integer>(); 
      boolean jobisthere = false; 
      for(int i = 0; i < size; i++)
      {
         Integer base = q.remove();
         if(base != del) 
            temp.add(base); 
         if(base == del)
            jobisthere = true; 
      } 
      q = temp; 
      if(!jobisthere)
      { 
         System.out.println("Error--job does not exist."); 
         return;
      }
      size--;  
             
   }
   
}