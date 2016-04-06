//Name: Sweta Karlekar     Date: 5/23/14
//Graphs, Lesson #1
   import java.util.Scanner;
   import java.io.*;
    public class Warshall_6B_Karlekar
   {
       public static void warshall( int[][] g)
      {
         for(int i = 0; i < g.length; i++)
         {
            for(int v = 0; v < g[0].length; v++)
            {
               for(int j = 0; j < g.length; j++)
               {
                  if((g[v][i] == 1) && (g[i][j] == 1))
                     g[v][j] = 1; 
               }
            }
         } 
      }
      
       public static void main( String[] args) throws FileNotFoundException
      {
         System.out.print("Warshall's Algorithm! Enter filename: "); //citydata.txt
      																					//citydataundirected.txt
         int[][] adjacency = read();
         warshall(adjacency);
         display(adjacency);
      }
   		
       public static int[][] read() throws FileNotFoundException
      {
         Scanner keyboard = new Scanner(System.in); 
         Scanner infile = new Scanner(new File(keyboard.next() + ".txt")); 
         int[][] mx = new int[infile.nextInt()][infile.nextInt()]; 
         for(int r = 0; r < mx.length; r++)
         {
            for(int c = 0; c < mx[0].length; c++)
            {
               mx[r][c] = infile.nextInt(); 
            }
         }
         return mx; 
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