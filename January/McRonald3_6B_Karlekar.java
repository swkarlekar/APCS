import java.util.Queue; 
import java.util.LinkedList; 
import java.util.Scanner;
public class McRonald3_6B_Karlekar
{
   private static Queue<Integer> q = new LinkedList<Integer>();
   private static int time = 1080; 
   private static int longestqueue = 1; 
   private static int servicetimelength = 3; 
   private static int[] servicetime; 
   private static int longestwait = 0;
   private static int customers = 0; 
   private static int totalwait = 0; 
  
   public static void main(String[] args)
   {
      servicetime = new int[servicetimelength]; 
      for(int i = 0; i < time; i++)
      {
         if(Math.random() < 0.20)
         {
            if(q.size() < servicetimelength)
               for(int x = 0; x < servicetimelength; x++)
                  if(servicetime[x] == 0)
                  {
                     servicetime[x] = (int)(Math.random() * 6 + 2);
                  }
            q.add(i); 
         }
         System.out.println(q); 
         serve(q, i); 
      }
      System.out.println("Total customers served = " + customers); 
      System.out.println("Average wait time = " + ((double)totalwait/(double)customers)); 
      System.out.println("Longest wait time = " + longestwait); 
      System.out.println("Longest queue = " + longestqueue); 
            
   }
   public static void serve(Queue<Integer> q, int i)
   {
      for(int y = 0; y < servicetimelength; y++)
      {
         if(servicetime[y] > 0)
            servicetime[y]--; 
         else if(q.size() > servicetimelength)
         {
            int temp = q.remove();
            totalwait = totalwait + (i - temp); 
            if((i - temp) > longestwait)
               longestwait = i-temp; 
            if(q.size() > longestqueue)
               longestqueue = q.size(); 
            customers++; 
            servicetime[y] = (int)(Math.random() * 6 + 2); 
         }  
         else if(!q.isEmpty())
         {
         //int i = 1080; 
         //if(!q.isEmpty())
            //servicetime--; 
            int temp2 = q.remove();
            totalwait = totalwait + (i - temp2); 
            if((i - temp2) > longestwait)
               longestwait = i-temp2; 
            if(q.size() > longestqueue)
               longestqueue = q.size(); 
            customers++; 
         }  
         //System.out.println(q); 
      
      }
      
   }
}
