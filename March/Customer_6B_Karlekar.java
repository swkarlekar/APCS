import java.util.PriorityQueue; 
import java.util.LinkedList; 
import java.util.Scanner;
public class Customer_6B_Karlekar implements Comparable<Customer_6B_Karlekar>
{
   private String myClass = "";
   private int myArrivalTime = 0; 
   private int intClass;  
   public Customer_6B_Karlekar(int arrival)
   {
      intClass = (int)(Math.random() * 4 + 1);
      switch(intClass)
      {
         case 1: myClass = "Senior"; break; 
         case 2: myClass = "Junior"; break;
         case 3: myClass = "Sophomore"; break;  
         case 4: myClass = "Freshman"; break;
         default: System.out.println("Error."); break; 
      }
      myArrivalTime = arrival; 
   }
   public Customer_6B_Karlekar(int arrival, int myclass)
   {
      intClass = myclass;
      switch(intClass)
      {
         case 1: myClass = "Senior"; break; 
         case 2: myClass = "Junior"; break;
         case 3: myClass = "Sophomore"; break;  
         case 4: myClass = "Freshman"; break;
         default: System.out.println("Error."); break; 
      }
      myArrivalTime = arrival; 
   }

   public String getStringClass()
   {
      return myClass; 
   }
   public int getIntClass()
   {
      return intClass; 
   }
   public int getArrivalTime()
   {
      return myArrivalTime; 
   }
   public int compareTo(Customer_6B_Karlekar c)
   {
      return intClass - c.intClass; 
   }
   public String toString()
   {
     return myClass; 
   }
   
}