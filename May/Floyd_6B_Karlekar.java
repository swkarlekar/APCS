//Name:       Date: 
//Graphs, Lesson #3

   import java.util.Scanner;
   import java.io.*;
    public class Floyd_6B_Karlekar
   {
       public static void floyd( int[][] g)
      {
          for(int i = 0; i < g.length; i++)
         {
            for(int v = 0; v < g[0].length; v++)
            {
               for(int j = 0; j < g.length; j++)
               {
                  if((g[v][i] != 9999) && (g[i][j] != 9999))
                     g[v][j] = Math.min(g[v][i] + g[i][j], g[v][j]); 
               }
            }
         } 

      }
      
       public static void main( String[] args)throws FileNotFoundException
      {
         System.out.print("Floyd's Algorithm! Enter filename: "); //citydataweighted.txt
         int[][] adjacency = read();
         floyd(adjacency);
         display(adjacency);
      }
   		
       public static int[][] read() throws FileNotFoundException
      {
		   return Warshall_6B_Karlekar.read(); 
      }
      
       public static void display(int[][] g)
      {
         for(int r = 0; r < g.length; r++)
         {
            for(int c = 0; c < g[0].length; c++)
               System.out.print(" " + g[r][c] + " ");
            System.out.println();
         }
      }
   }