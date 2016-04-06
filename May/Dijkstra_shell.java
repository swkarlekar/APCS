//Name:     Date:
//Graphs, Lesson #4

   import java.util.*;
   import java.io.*;

   class wVertex implements Comparable<wVertex>
   {
   
   }

   public class Dijkstra_shell
   {
      public static void main(String[] args) throws FileNotFoundException
      {
         List<wVertex> vertices = read();
         //List<wVertex> vertices = read2();
         int n = enterSource();    
         wVertex source = vertices.get(n); 
         computePaths(source);   
         System.out.println("Distance from "+ source.toString() );
         for (wVertex v : vertices)
         {
            System.out.print("    to " + v + ": " + v.getMinDistance() );
            System.out.println();
         }
      }
      public static List<wVertex> read()
      {
         return null;
      }
      public static List<wVertex> read2() throws FileNotFoundException
      {
         return null;
      }
      public static int enterSource()
      {
         Scanner in = new Scanner(System.in);
         System.out.print("Enter source (number): ");
         int city_number = in.nextInt();
         return city_number;
      }
      public static void computePaths(wVertex source)  //Dijkstra's Algorithm
      {
      
      }
   
      public static List<wVertex> getShortestPathTo(wVertex target) //Extension 1
      {
         return null;
      }
		//Extension 2:  uses a set and a linear search for O(V^2)
       public static void computePaths(wVertex source, List<wVertex> vertices)
      {
		}
   }

