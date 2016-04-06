 //name: Sweta Karlekar  date: 06/6/14
 
   import java.util.*;
   import java.io.*;

   public class Jugs_6B_Karlekar
   {
   
      public static void main(String[] args) throws Exception
      {
         Jug a = new Jug(3, 4, 4, 5); 
         a.pourAB();
         System.out.print(a); 
         /*Scanner in = new Scanner(System.in);
         System.out.print("What file? ");
         String file = in.nextLine();
         Scanner read = new Scanner(new File(file));
         while (read.hasNext())
         {
            String[] line = read.nextLine().split(" ");
            int a = Integer.parseInt(line[0]); //Capacity of first jug
            int b = Integer.parseInt(line[1]); //Capacity of second jug
            int n = Integer.parseInt(line[2]); //Desired volume of liquid
            solve(a, b, n);
            System.out.println("success");
         }
      	
         read.close();
         in.close();*/
      }
   	
      public static void solve(int a, int b, int n)
      {
         Jug start = createGraph(a, b); //Build a graph of the possible Jug pair states, given a as the capacity of the first jug, b as the capacity of the second jug, and n as the desired measurement of liquid
         findReachableBreadth(start, a, b, n); //Print the solution to the given Jug problem using breadth-first search
      }
   	
   	//Breadth-first search from EdgeList
      public static void findReachableBreadth(Jug v, int ac, int bc, int n)
      {
      }   
      public static Jug createGraph(int a, int b)
      {
      return null;
      }
   		   
   }
	
	//The Jug object is a representation of the state of the pair of jugs.
	//Jug is a slight modification of the Vertex class from EdgeList.
   class Jug 
   {
      private int acap, bcap; 
      private int acurr, bcurr; 
      private TreeSet<Jug> edges = new TreeSet<Jug>(); 
      private Jug parent; 
      public String name; 
      public Jug(int a, int b, int ac, int bc)
      {
         acap = ac; 
         bcap = bc; 
         acurr = a; 
         bcurr = b; 
         name = acurr + " " + bcurr; 
      }
      public void addEdge(Jug j)
      {
         edges.add(j);
      }
      public void removeEdge(Jug j)
      {
         edges.remove(j); 
      }
      public TreeSet<Jug> getEdges()
      {
         return edges; 
      }
      public String toString()
      {
         String temp = name + "" ;
         for(Object v : edges)
            temp += ((Jug)v).name+" ";
         return temp;
      }
      public void pourAB()
      {
         while(bcurr <= bcap || acurr != 0)
         {
            acurr--;
            bcurr++; 
         }
      }
      public void pourBA()
      {
         while(acurr != acap || bcurr != 0)
         {
            acurr--; 
            bcurr++; 
         }
      }
      
      
   }
