//Name:     Date:
//Graphs, Lesson #4

   import java.util.*;
   import java.io.*;

   class wVertex implements Comparable<wVertex>
   {
      private final String name; 
      private Map<wVertex, Integer> edges = new HashMap<wVertex, Integer>(); 
      private int minDistance = Integer.MAX_VALUE; 
      private wVertex previous; 
      public wVertex(String city)
      {
         name = city; 
      }
      public String toString()
      {
         return name; 
      }
      public void addEdge(wVertex city, Integer weight)
      {
         edges.put(city, weight); 
      }
      public Map<wVertex, Integer> getEdges()
      {
         return edges; 
      }
      public int getMinDistance()
      {
         return minDistance; 
      }
      public void setMinDistance(int d)
      {
         minDistance = d; 
      }
      public int compareTo(wVertex other)
      {
         return minDistance - other.minDistance; 
      }
      public void setPrevious(wVertex x)
      {
         previous = x; 
      }
      public wVertex getPrevious()
      {
         return previous; 
      }
      public boolean hasPrevious()
      {
         return !(previous == null); 
      }
   }

   public class Dijkstra_6B_Karlekar
   {
      public static void main(String[] args) throws FileNotFoundException
      {
         //List<wVertex> vertices = read();
         List<wVertex> vertices = read2();
         int n = enterSource();    
         wVertex source = vertices.get(n);
         computePaths(source);  
         //computePaths(source, vertices);   
         System.out.println("Distance from "+ source.toString() );
         for (wVertex v : vertices)
         {
            System.out.print("    to " + v + ": " + v.getMinDistance() + " " + getShortestPathTo(v));
            System.out.println();
         }
      }
      public static List<wVertex> read()
      {
         List<wVertex> list = new ArrayList<wVertex>(); 
         wVertex pendle = new wVertex("Pendleton"); 
         wVertex pensa = new wVertex("Pensacola"); 
         wVertex peor = new wVertex("Peoria"); 
         wVertex phoe = new wVertex("Phoenix"); 
         wVertex pier = new wVertex("Pierre"); 
         wVertex pitts = new wVertex("Pittsburgh"); 
         wVertex prince = new wVertex("Princeton"); 
         wVertex pueb = new wVertex("Pueblo");
         
         pendle.addEdge(pueb, 8); //pendle, pensa, peor, phoe, pier, pitts, prince, pueb
         pendle.addEdge(pier, 2); 
         pensa.addEdge(phoe, 5);
         pensa.addEdge(pitts, 4); 
         peor.addEdge(pitts, 5); 
         peor.addEdge(pueb, 3); 
         phoe.addEdge(pitts, 10); 
         phoe.addEdge(pueb, 3);
         phoe.addEdge(pensa, 5);  
         pier.addEdge(pendle, 2); 
         pier.addEdge(pueb, 3); 
         pitts.addEdge(pensa, 4); 
         pitts.addEdge(prince, 2); 
         pitts.addEdge(phoe, 10); 
         pitts.addEdge(peor, 5); 
         prince.addEdge(pitts, 2); 
         pueb.addEdge(pier, 3); 
         pueb.addEdge(pendle, 8); 
         pueb.addEdge(phoe, 3); 
         pueb.addEdge(peor, 3); 
         
         list.add(pendle); list.add(pensa); list.add(peor); list.add(phoe); list.add(pier); list.add(pitts); list.add(prince); list.add(pueb); 
         return list; 

      }
      public static List<wVertex> read2() throws FileNotFoundException
      {
         int[][] mat = Warshall_6B_Karlekar.read(); //citydataweighted, cities
         List<wVertex> list = new ArrayList<wVertex>(); 
         Scanner keyboard = new Scanner(System.in);
         System.out.println("Please enter file name: ");  
         Scanner infile = new Scanner(new File(keyboard.next() + ".txt")); 
         while(infile.hasNext())
            list.add(new wVertex(infile.next())); 
         for(int j = 0; j < list.size(); j++)
         {
            wVertex v = list.get(j); 
            for(int i = 0; i < mat[0].length; i++)
            {
               if(mat[j][i] != 9999)
               {
                  v.addEdge(list.get(i), mat[j][i]); 
               }
            }
         }
         return list;  
      }
      public static int enterSource()
      {
         Scanner in = new Scanner(System.in);
         System.out.print("Enter source (number): ");
         int city_number = in.nextInt();
         return city_number;
      }
      public static void computePaths(wVertex source)  //Dijkstra's Algorithm w/ priority queue
      {
         PriorityQueue<wVertex> pq = new PriorityQueue<wVertex>();
         source.setMinDistance(0); 
         pq.add(source);
         while(!pq.isEmpty()) 
         {
            wVertex vertex = pq.remove(); 
            for(wVertex w : vertex.getEdges().keySet())
            {
                if(vertex.getMinDistance() + vertex.getEdges().get(w) < w.getMinDistance())
                {
                  pq.remove(vertex); 
                  w.setMinDistance(vertex.getMinDistance() + vertex.getEdges().get(w));
                  w.setPrevious(vertex); 
                  pq.add(w); 
                }
            }
         }
      }
      public static List<wVertex> getShortestPathTo(wVertex target) //Extension 1
      {
         List<wVertex> list = new ArrayList<wVertex>(); 
         wVertex temp = target; 
         while(temp != null)
         {
            list.add(temp); 
            temp = temp.getPrevious(); 
         }
         return list; 
         
      }
		//Extension 2:  uses a set and a linear search for O(V^2)
       public static void computePaths(wVertex source, List<wVertex> vertices)
      {
         Set<wVertex> pq = new TreeSet<wVertex>();
         source.setMinDistance(0); 
         pq.add(source);
         while(!pq.isEmpty()) 
         {
            wVertex min;  
            Iterator<wVertex> it = pq.iterator(); 
            min = it.next(); 
            while(it.hasNext())
            {
               wVertex temp = it.next(); 
               if(min.compareTo(temp) > 0)
               {
                  min = temp; 
               }
            }
            wVertex vertex = min;  
            for(wVertex w : vertex.getEdges().keySet())
            {
                if(vertex.getMinDistance() + vertex.getEdges().get(w) < w.getMinDistance())
                {
                  pq.remove(vertex); 
                  w.setMinDistance(vertex.getMinDistance() + vertex.getEdges().get(w));
                  w.setPrevious(vertex); 
                  pq.add(w); 
                }
            }
         }

		}
   }

