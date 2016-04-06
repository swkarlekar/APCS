import java.util.PriorityQueue; 
import java.util.LinkedList; 
import java.util.Scanner;
public class McRonaldsHeapPQ_6B_Karlekar
{
   
   private static HeapPriorityQueue_6B_Karlekar<Customer_6B_Karlekar> q = new HeapPriorityQueue_6B_Karlekar<Customer_6B_Karlekar>();
   private static int time = 1080; 
   private static int servicetimelength = 3; 
   private static int[] servicetime; 
   
   private static int seniorlongestwait = 0;
   private static int juniorlongestwait = 0;
   private static int sophomorelongestwait = 0;
   private static int freshmanlongestwait = 0;
   
   private static int numseniors = 0; 
   private static int numjuniors = 0; 
   private static int numsophomores = 0; 
   private static int numfreshmen = 0; 
   
   private static int seniorwait = 0; 
   private static int juniorwait = 0; 
   private static int sophomorewait = 0; 
   private static int freshmanwait = 0; 

  
   public static void main(String[] args)
   {
      servicetime = new int[servicetimelength]; 
      for(int i = 0; i < time; i++)
      {
         if(Math.random() < 0.25)
         {
            if(q.size() < servicetimelength)
               for(int x = 0; x < servicetimelength; x++)
                  if(servicetime[x] == 0)
                  {
                     servicetime[x] = (int)(Math.random() * 6 + 2);
                  }
            Customer_6B_Karlekar t = new Customer_6B_Karlekar(i);
            if(t.getStringClass().equals("Senior"))
               numseniors++; 
            else if(t.getStringClass().equals("Junior")) 
               numjuniors++; 
            else if(t.getStringClass().equals("Sophomore")) 
               numsophomores++; 
            else if(t.getStringClass().equals("Freshman"))
               numfreshmen++; 
            q.add(t); 
         }
         System.out.println(q); 
         serve(q, i); 
      }
      System.out.format("%20s%20s%20s%20s", "Customer", "Total Served", "Longest Wait", "Average Wait");    
      System.out.format("\n%20s%20s%20s%20s", "Senior", numseniors, seniorlongestwait, (seniorwait)/(double)(numseniors));    
      System.out.format("\n%20s%20s%20s%20s", "Junior", numjuniors, juniorlongestwait, (juniorwait)/(double)(numjuniors)); 
      System.out.format("\n%20s%20s%20s%20s", "Sophomore", numsophomores, sophomorelongestwait, (sophomorewait)/(double)(numsophomores)); 
      System.out.format("\n%20s%20s%20s%20s", "Freshman", numfreshmen, freshmanlongestwait, (freshmanwait)/(double)(numfreshmen)); 
   }
   public static void serve(HeapPriorityQueue_6B_Karlekar<Customer_6B_Karlekar> q, int i)
   {
      for(int y = 0; y < servicetimelength; y++)
      {
         if(servicetime[y] > 0)
            servicetime[y]--; 
         else if(q.size() > servicetimelength)
         {  
            Customer_6B_Karlekar t = q.remove(); 
            int temp = t.getArrivalTime();
            
            if(t.getStringClass().equals("Senior"))
               seniorwait = seniorwait + (i -temp); 
            else if(t.getStringClass().equals("Junior")) 
                juniorwait = juniorwait + (i -temp); 
            else if(t.getStringClass().equals("Sophomore")) 
                sophomorewait = sophomorewait + (i -temp); 
            else if(t.getStringClass().equals("Freshman"))
                freshmanwait = freshmanwait + (i -temp);
            
            if(t.getStringClass().equals("Senior") && (i - temp) > seniorlongestwait)
               seniorlongestwait = i-temp; 
            if(t.getStringClass().equals("Junior") && (i - temp) > juniorlongestwait)
               juniorlongestwait = i-temp;
            if(t.getStringClass().equals("Sophomore") && (i - temp) > sophomorelongestwait)
               sophomorelongestwait = i-temp;
            if(t.getStringClass().equals("Freshman") && (i - temp) > freshmanlongestwait)
               freshmanlongestwait = i-temp;
               
            
            if(t.getStringClass().equals("Senior"))
               numseniors++; 
            else if(t.getStringClass().equals("Junior")) 
               numjuniors++; 
            else if(t.getStringClass().equals("Sophomore")) 
               numsophomores++; 
            else if(t.getStringClass().equals("Freshman"))
               numfreshmen++; 

            servicetime[y] = (int)(Math.random() * 6 + 2); 
         }  
         else if(q.size() > 1)
         {
            Customer_6B_Karlekar t2 = q.remove(); 
            int temp2 = t2.getArrivalTime();
            
            if(t2.getStringClass().equals("Senior"))
               seniorwait = seniorwait + (i -temp2); 
            else if(t2.getStringClass().equals("Junior")) 
                juniorwait = juniorwait + (i -temp2); 
            else if(t2.getStringClass().equals("Sophomore")) 
                sophomorewait = sophomorewait + (i -temp2); 
            else if(t2.getStringClass().equals("Freshman"))
                freshmanwait = freshmanwait + (i -temp2);
            
            if(t2.getStringClass().equals("Senior") && (i - temp2) > seniorlongestwait)
               seniorlongestwait = i-temp2; 
            if(t2.getStringClass().equals("Junior") && (i - temp2) > juniorlongestwait)
               juniorlongestwait = i-temp2;
            if(t2.getStringClass().equals("Sophomore") && (i - temp2) > sophomorelongestwait)
               sophomorelongestwait = i-temp2;
            if(t2.getStringClass().equals("Freshman") && (i - temp2) > freshmanlongestwait)
               freshmanlongestwait = i-temp2;
               
            
            if(t2.getStringClass().equals("Senior"))
               numseniors++; 
            else if(t2.getStringClass().equals("Junior")) 
               numjuniors++; 
            else if(t2.getStringClass().equals("Sophomore")) 
               numsophomores++; 
            else if(t2.getStringClass().equals("Freshman"))
               numfreshmen++; 
         }  
               
      }
      
   }
}
class Customer_6B_Karlekar implements Comparable<Customer_6B_Karlekar>
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



   
   
