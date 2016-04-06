/*
ID: sweta.k1
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

class friday {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    Scanner infile = new Scanner(new File("friday.in")); 
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
	int N = Integer.parseInt(infile.next()); 
   Map<Integer, Integer> days = new TreeMap<Integer, Integer>(); 
   int[] array = {0, 0, 0, 0, 0, 0 ,0}; 
   int index = 1; 
   days.put(1, 0); days.put(2, 0); days.put(3, 0); days.put(4, 0); days.put(5, 0); days.put(6, 0); days.put(7, 0); 
      for(int i = 1900; i <= 1900+N-1; i++)
      {
         for(int month = 1; month <= 12; month++)
         {
              int numdays = 0; 
              if(month == 9 || month == 4 || month == 6 || month == 11)
                  numdays = 30; 
              else if(month == 2 && i%4 == 0 && i%100 != 0)
                  numdays = 29; 
              else if(month == 2 && i%400 == 0)
                  numdays = 29;
              else if(month == 2)
                  numdays = 28;
              else
                  numdays = 31; 
              for(int day = 1; day <= numdays; day++)
              {
                  if(index == 7)
                        index = 0;                      
                  if(day == 13)
                        days.put(index + 1, days.get(index + 1) + 1); 
                  array[index] = day;
                  index++; 
              }
         }
      }
      int count = 0; 
      for(Integer i : days.values())
      {
         array[count] = i; 
         count++; 
      }
      out.print(array[array.length - 1] + " "); 
      for(int i = 0; i < array.length-1; i++)
      {
         out.print(array[i] + " "); 
      }
      
   }
}