public class Jug
{
   public int cap, current; //private final int a, b; 
                           //private HashSet<Jug> egdges = new HashSet<Jug>(); 
                              //private Jug Parent; 
   public Jug(int ca)
   {
      cap = ca; 
      current = 0; 
   } 
   public Jug(int ca, int cu)
   { 
      cap = ca; 
      current = cu; 
   }
   public void setCap(int newcap)
   {
      cap = newcap; 
   }
   public void fill()
   {
      current = cap; 
   }
   public void empty()
   {
      current = 0; 
   }
   public void pour(Jug B)
   {
      int tofill = b.cap - b.current; 
      
      
   }
   public void pourBA()
   {
      capA += capB; 
      capB = 0; 
   }
   public boolean success()
   {
      return capA + capB 
   }
}