 //  name: Sweta Karlekar      date: 11/25/13   
	import java.util.*;

    public class CollectionsSpeed_6B_Karlekar
   {
      public static int N = 10000;
   
       public static void main(String[] args)
      {
         ArrayList<Integer> al = new ArrayList<Integer>();
         LinkedList<Integer> ll = new LinkedList<Integer>();
         makeValues(al, ll);
      
         System.out.println("get each for ArrayList = " + timeGetEach(al));
         System.out.println("get each for LinkedList = " + timeGetEach(ll));
         System.out.println("\nadd at 0 for ArrayList = " + timeAddFirst(al));
         System.out.println("add at 0 for LinkedList = " + timeAddFirst(ll));
         System.out.println("\nadd at list.size() for ArrayList = " + timeAddLast(al));
         System.out.println("add at list.size() for LinkedList = " + timeAddLast(ll));
         System.out.println("addLast for LinkedList = " + timeAddLastLL(ll));
      }
       public static void makeValues(ArrayList<Integer> al, LinkedList<Integer> ll)
      {
        for(int i = 0; i < N; i++)
        {
          Integer random = (int)(Math.random() * 10000); 
          al.add(random); 
          ll.add(random); 
        }
      }
   	/* get N items by searching for each one. */
     public static double timeGetEach(List<Integer> list)
      {
         double start = System.nanoTime();
         for( int i = 0; i < N; i++ )
         {
            int index = list.get(i);
         }
         return (System.nanoTime() - start)/1E6;
      }
   /* add 10000 new objects at position 0  */
       public static double timeAddFirst(List<Integer> list)
      {
         double start = System.nanoTime();
         for(int i = 0; i < N; i++)
        {
          Integer random = (int)(Math.random() * 10000);  
          list.add(0, random); 
        }
         return (System.nanoTime() - start)/1E6;
      }
   /* add 10000 new objects at position list.size() */
       public static double timeAddLast(List<Integer> list)
      {
         double start = System.nanoTime();
         for(int i = 0; i < N; i++)
        {
          Integer random = (int)(Math.random() * 10000);  
          list.add(random); 
        }
         return (System.nanoTime() - start)/1E6;
      }
   /* add 10000 new objects at the end. 
      uses the LinkedList method addLast()      */
       public static double timeAddLastLL(List<Integer> list)
      {
         double start = System.nanoTime();
         for(int i = 0; i < N; i++)
        {
          Integer random = (int)(Math.random() * 10000); 
          ((LinkedList)list).addLast(random); 
        }
         return (System.nanoTime() - start)/1E6;
      }
   }
