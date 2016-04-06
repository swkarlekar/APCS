//Name:   Date:
//Graphs, Lesson #2

   import java.util.*;
   import java.io.*;
    class Vertex 
   {
      private final String name;
      private List<Vertex> edges = new ArrayList<Vertex>();
       Vertex()
      {
         name = null;
      }
       Vertex(String str)
      {
         name = str;
      }
       public void addEdge( Vertex c ) 
      {
         edges.add( c );
      }
       public void removeEdge( Vertex c )
      {
         edges.remove( c );
      } 
       public String getName()
      {
         return name;
      } 
       public List<Vertex> getEdges()
      {
         return edges;
      }
       public String toString()
      {
         String temp = name + "-->" ;
         for(Object v : edges)
            temp += ((Vertex)v).name+" ";
         return temp;
      }
   }
   
    public class EdgeList_shell
   {  
       public static void main(String[] args)throws FileNotFoundException
      {
         System.out.println("Edge List Representation! ");
         List<Vertex> vertices = read();
      //   List<Vertex> vertices = read2();
         System.out.println(vertices);				//let's look at it first
         System.out.println();     
         for (Vertex v : vertices)
            System.out.println( findReachableDepth(v) );
            //System.out.println( findReachableBreadth(v) );
      		//System.out.println ( findReachableRecur(v) );
      }
      
   
      
       public static List<Vertex> read() 
      {
      
      }
     
       public static List<Vertex> read2() throws FileNotFoundException
      {
      
      }
       public static List<Vertex> findReachableDepth(Vertex v)
      {
      
      }
       public static List<Vertex> findReachableBreadth(Vertex v)
      {
      
      }
       public static List<Vertex> findReachableRecur(Vertex v)
      {
         ArrayList<Vertex> reachable = new ArrayList<Vertex>();
         findReachableRecurHelper(v, reachable);
         return reachable;
      }  
   	
       private static void findReachableRecurHelper(Vertex v, ArrayList<Vertex> reachable)
      {
      
      }
   }