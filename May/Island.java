   import java.awt.Point;
   import java.util.HashMap;
   import java.util.Set;

   class Island implements Comparable<Island>
   {
      private int minDistance;
      private final Point loc;
      private HashMap<Island, Island> adj;
      private int dists[];
   
      public Island(Point p)
      {
         adj = new HashMap<Island, Island>();
         loc = p;
         dists = new int[6];
         for(int i = 0; i < 6; i++)
         {
            dists[i] = Integer.MAX_VALUE;
         }
      }
   
      public boolean updateDist(int dist, int dir)
      {
         if(dists[dir] >= dist)
         {
            dists[dir] = dist;
            return true;
         } 
         else
            return false;
      }
   
      public int getDist(int dir)
      {
         return dists[dir];
      }
   
      public int getMinOfDists()
      {
         int min = Integer.MAX_VALUE;
         for(int i = 0; i < 6; i++)
         {
            if(dists[i] < min)
            {
               min = dists[i];
            }
         }
         return min;
      }
   
      public void addAdj(Island i)
      {
         adj.put(i, i);
      }
   
      public Point getLocation()
      {
         return loc;
      }
   
      public Set getAdjacent()
      {
         return adj.keySet();
      }
   
      public boolean setMinDist(int d)
      {
         if(d < minDistance)
         {
            minDistance = d;
            return true;
         } 
         else
            return false;
      }
   
      public int getMinDist()
      {
         return minDistance;
      }
   
      public int hashCode()
      {
         return loc.x << 16 & loc.y;
      }
   
      public boolean equals(Island o)
      {
         if(!(o instanceof Island))
         {
            return false;
         } 
         else
         {
            return loc.equals(o.loc);
         }
      }
   
      public int compareTo(Island i)
      {
         return getMinDist() - i.getMinDist();
      }
   
      public boolean hasAdjacent(Island i)
      {
         return adj.containsKey(i);
      }
   
      public Island getAdjacent(Island i)
      {
         return adj.get(i);
      }
   
      public String toString()
      {
         return (new StringBuilder()).append("(").append(loc.x).append(",").append(loc.y).append(")").toString();
      }
   
      // public int compareTo(Object o)
      // {
         // return compareTo((Island)o);
      // }
   }
