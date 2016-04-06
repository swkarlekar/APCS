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
   
    public class EdgeList_6B_Karlekar
   {  
       public static void main(String[] args)throws FileNotFoundException
      {
         System.out.println("Edge List Representation! ");
         //List<Vertex> vertices = read();
        List<Vertex> vertices = read2();
         System.out.println(vertices);				//let's look at it first
         System.out.println();     
         for (Vertex v : vertices)
           System.out.println( findReachableDepth(v) );
            //System.out.println( findReachableBreadth(v) );
      		//System.out.println ( findReachableRecur(v) );
      }
      
   
      
       public static List<Vertex> read() 
      {
         List<Vertex> list = new ArrayList<Vertex>(); 
         Vertex pendle = new Vertex("Pendleton"); 
         Vertex pensa = new Vertex("Pensacola"); 
         Vertex peor = new Vertex("Peoria"); 
         Vertex phoe = new Vertex("Phoenix"); 
         Vertex pier = new Vertex("Pierre"); 
         Vertex pitts = new Vertex("Pittsburgh"); 
         Vertex prince = new Vertex("Princeton"); 
         Vertex pueb = new Vertex("Pueblo");
         
         pendle.addEdge(pueb); 
         pensa.addEdge(phoe);
         peor.addEdge(pitts); 
         peor.addEdge(pueb); 
         phoe.addEdge(pitts); 
         phoe.addEdge(pueb); 
         pier.addEdge(pendle); 
         pitts.addEdge(pensa); 
         prince.addEdge(pitts); 
         prince.addEdge(prince); 
         pueb.addEdge(pier); 
         
         list.add(pendle); list.add(pensa); list.add(peor); list.add(phoe); list.add(pier); list.add(pitts); list.add(prince); list.add(pueb); 
         return list; 
      }
       public static List<Vertex> read2() throws FileNotFoundException
      {
         int[][] mat = Warshall_6B_Karlekar.read(); 
         List<Vertex> list = new ArrayList<Vertex>(); 
         Scanner keyboard = new Scanner(System.in);
         System.out.println("Please enter file name: ");  
         Scanner infile = new Scanner(new File(keyboard.next() + ".txt")); 
         while(infile.hasNext())
            list.add(new Vertex(infile.next())); 
         for(int j = 0; j < list.size(); j++)
         {
            Vertex v = list.get(j); 
            for(int i = 0; i < mat[0].length; i++)
            {
               if(mat[j][i] == 1)
               {
                  v.addEdge(list.get(i)); 
               }
            }
         }
         return list; 
      }
       public static List<Vertex> findReachableDepth(Vertex v)
      {
         List<Vertex> list = new ArrayList<Vertex>(); 
         Stack<Vertex> stack = new Stack<Vertex>(); 
         stack.push(v);
         while(!stack.isEmpty())
         {
            Vertex x = stack.pop();  
            list.add(x);
            for(Vertex temp : x.getEdges())
               if(!list.contains(temp))
                  stack.push(temp); 
          }
          return list;     
      }
       public static List<Vertex> findReachableBreadth(Vertex v)
      {
         return new ArrayList(); 
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