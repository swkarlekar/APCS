//Name: Sweta Karlekar     Date: 3/19/14
import java.util.*;
import java.math.BigInteger; 

public class Fib_6B_Karlekar
{
   public static final int DEFAULT = 40;
      
   public static void main(String[] args)
   {
      int n = DEFAULT;
      System.out.println("Recursive");
      calculate(new Fib1(), n);
      System.out.println("Iterative, stored in an array");
      calculate(new Fib2(), n);
      System.out.println("Recursive, stored in an arrayList");
      calculate(new Fib3(), n);
      System.out.println("Recursive, stored in a hashMap");
      calculate(new Fib4(), n);		
   }
      
   public static void calculate(Fibber fibber, int n)
   {
      long start = System.nanoTime();
      int f; 
      f = fibber.fib(n);
      
      long finish = System.nanoTime();
      long time = finish - start;
      
      System.out.print("fib(" + n + ") = " + f);
      System.out.println(" (" + time + " nanoseconds)");		
      System.out.println();		
   }
    
   private static class Fib1 implements Fibber
   {      
      public int fib(int n)
      {
         if(n == 1 || n == 2)
            return 1;
         else
            return fib(n - 1) + fib(n - 2);
      }
   }
   private static class Fib2 implements Fibber //iterative
   {
      public int fib(int n)
      {
         int[] ar = new int[n];
         ar[0] = 0; 
         ar[1] = 1; 
         for(int i = 2; i < n; i++)
         {
            ar[i] = ar[i-1] + ar[i-2]; 
         }
         return ar[n-1] + ar[n-2]; 
            
      }
   }
   private static class Fib3 implements Fibber //recursive w/ arraylist 
   {
      public static ArrayList<Integer> array = new ArrayList<Integer>(); 
      static
      {
         array.add(0); 
         array.add(1); 
      }
      public int fib(int n)
      {
         if (n >= array.size()) 
            array.add(n, (fib(n-1)+fib(n-2)));
         return array.get(n);
      }
   }
   private static class Fib4 implements Fibber //recursive w/ hashMap
   {
     public static Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
     static
     {
     map.put(0, 0); 
     map.put(1, 1); 
     }
     public int fib(int n)
     {
         if(n >= map.size())
            map.put(n, (fib(n-1) + fib(n-2))); 
         return map.get(n);
          
     }
   }
   
   private interface Fibber
   {
      public abstract int fib(int n);
      
   }
}
   	/*
    Recursive
    fib(42) = 267914296 (3276558048 nanoseconds)
    
    Iterative, stored in an array
    fib(42) = 267914296 (4988 nanoseconds)
    
    Recursive, stored in an arrayList
    fib(42) = 267914296 (64025 nanoseconds)
    
    Recursive, stored in a hashMap
    fib(42) = 267914296 (177793 nanoseconds)
    
   	*/
