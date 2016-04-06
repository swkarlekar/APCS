import java.util.Queue; 
import java.util.LinkedList; 
import java.util.Scanner;
public class McRonald1000_6B_Karlekar
{
   private static Queue<Integer> q = new LinkedList<Integer>();
   private static int time = 1080; 
   private static int longestqueue = 1; 
   private static int longestday = 0;
   private static int templongestday = 0; 
   private static int servicetime = (int)(Math.random() * 6 + 2); 
   private static int longestwait = 0; 
   private static int customers = 0; 
   private static int totalwait = 0; 
  
   public static void main(String[] args)
   {
      for(int x = 0; x < 1000; x++)
      { 
         for(int i = 0; i < time; i++)
         {
            if(Math.random() < 0.20)
               q.add(i); 
            if(!q.isEmpty())
               servicetime--; 
            if(servicetime == 0)
            {
               int temp = q.remove();
               totalwait = totalwait + (i - temp); 
               if((i - temp) > longestwait)
                  longestwait = i-temp; 
               if(q.size() > longestqueue)
                  longestqueue = q.size(); 
               customers++;
               templongestday++;  
               servicetime = (int)(Math.random() * 6 + 2); 
            }  
         }
         int i = 1080; 
         while(!q.isEmpty())
         {
            if(!q.isEmpty())
               servicetime--; 
            if(servicetime == 0)
            {
               int temp = q.remove();
               totalwait = totalwait + (i - temp); 
               if((i - temp) > longestwait)
                  longestwait = i-temp; 
               if(q.size() > longestqueue)
                  longestqueue = q.size(); 
               customers++; 
               templongestday++; 
               servicetime = (int)(Math.random() * 6 + 2); 
            }  
            i++; 
         
         }
         
         if(templongestday > longestday)
            longestday = templongestday; 
         templongestday = 0; 
         
      }
      System.out.println("Total customers served = " + customers); 
      System.out.println("Average wait time = " + ((double)totalwait/(double)customers)); 
      System.out.println("Longest wait time = " + longestwait); 
      System.out.println("Longest queue = " + longestqueue); 
      System.out.println("Average served per day = " + ((double)(customers)/(double)(1000))); 
      System.out.println("Largest day = " + longestday);       
            
   }
}
