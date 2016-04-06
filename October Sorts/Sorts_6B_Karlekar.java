    /* Name: Sweta Karlekar  Date: 10/18/2013
    Uses the helper classes Selection and Insertion. 
	 Students are to write the Selection and Insertion classes.
    */
   import java.util.*;
   import java.io.*;
   public class Sorts_6B_Karlekar
   {
      public static void main(String[] args) throws Exception
      {
        //Part 1, for doubles
         int n = (int)(Math.random()*100);
         double[] array = new double[n];
         for(int k = 0; k < array.length; k++)
            array[k] = Math.random();	
         print(array);
         System.out.println("*************  *************");
        	//Selection.sort(array);
         Insertion.sort(array);
         print(array);
      
         
      	//Part 2, for Strings
         int size = 100;
         Scanner sc = new Scanner(new File("declaration.txt"));
         String[] arrayStr = new String[size];
         for(int k = 0; k < arrayStr.length; k++)
            arrayStr[k] = sc.next();	
         print(arrayStr);
         System.out.println("*************  *************");
         //Selection.sort(arrayStr);
         Insertion.sort(arrayStr);
         print(arrayStr);
      }
      public static void print(double[] a)
      {
         // for(int k = 0; k < a.length; k++)
            // System.out.println(a[k]);
         for(double d : a)
            System.out.println(d);
         System.out.println();
      }
      public static void print(Object[] papaya)
      {
         for(Object item : papaya)     //for-each
            System.out.println( item );
      }
   }
   //*******************************************************************
  //Name: Sweta Karlekar           Date: 10/18/13
  //The Selection class will have methods sort(), findMax() and swap().
  //Three versions of each method will have to be written, to work 
  //for doubles, Strings, and Comparables.
  
   class Selection
   {
      public static void sort(double[] array)
      { 
         for(int i = array.length-1; i>=0; i--)
         {
            int swapper = findMax(array, i);
            swap(array, i, swapper);  
         }
      }
      public static void sort(double[] array, int low, int high)
      { 
         for(int i = high; i>=low; i--)
         {
            int swapper = findMax(array, i);
            swap(array, i, swapper);  
         }
      }
      private static int findMax(double[] array, int n)
      {
         int pos = 0; 
         for(int i = 0; i <= n; i++)
         {
            if(array[pos] < array[i])
               pos = i; 
         }
         return pos;
      }
      private static void swap(double[] array, int a, int b)
      {
         double k = array[a]; 
         array[a] = array[b]; 
         array[b] = k; 
      }
   	/***************************************************
   	  for Strings
   	  ***********************************************/
      public static void sort(String[] array)
      {
         for(int i = array.length-1; i>=0; i--)
         {
            int swapper = findMax(array, i);
            swap(array, i, swapper);  
         }
      
      }
      public static int findMax(String[] array, int upper)
      {
         int pos = 0; 
         for(int i = 0; i <= upper; i++)
         {
            if(array[pos].compareTo(array[i]) < 0)
               pos = i; 
         }
         return pos;
      
      }
      public static void swap(String[] array, int a, int b)
      {
      	
         String k = array[a]; 
         array[a] = array[b]; 
         array[b] = k; 
      
      }
   	/***************************************************
   	 for Comparables,
   	      Swap() is for Objects.
   	      make sure that print() is for Objects, too.
   	  ***********************************************/
      public static void sort(Comparable[] array)
      {
         for(int i = array.length-1; i>=0; i--)
         {
            int swapper = findMax(array, i);
            swap(array, i, swapper);  
         }
      }
      public static int findMax(Comparable[] array, int upper)
      {
         int pos = 0; 
         for(int i = 0; i <= upper; i++)
         {
            if(array[pos].compareTo(array[i]) < 0)
               pos = i; 
         }
         return pos;
      }
      public static void swap(Object[] array, int a, int b)
      {
         Object k = array[a]; 
         array[a] = array[b]; 
         array[b] = k; 
      }
   }   

//**********************************************************
  //Name: Sweta Karlekar             Date: 10/18/13
  //The Insertion class 
  //write enough methods (sort() and shift()) to handle doubles and Comparables.
   class Insertion
   {
   	/***************************************************
   	  for Doubles
   	  ***********************************************/
   
      public static void sort(double[] array)
      { 
         for(int i = 1; i < array.length; i++)
         {
            shift(array, i, array[i]);
         }
      }
      private static void shift(double[] array, int index, double value)
      {
         for(int i = index - 1; i >=0; i--)
         {
            if(array[i]>value)
            {
               array[i+1]=array[i];
               if(i==0)
                  array[i]=value;
            }
            else
            {
               array[i+1]=value;
               return;
            }
         }
      
      }
   	/***************************************************
   	  for Comparables
   	  ***********************************************/
      public static void sort(Comparable[] array)
      { 
         for(int i = 1; i < array.length; i++)
         {
            shift(array, i, array[i]);
         }
      }
      private static void shift(Comparable[] array, int index, Comparable value)
      {
         for(int i = index - 1; i >=0; i--)
         {
            if(array[i].compareTo(value) > 0)
            {
               array[i+1]=array[i];
               if(i==0)
                  array[i]=value;
            }
            else
            {
               array[i+1]=value;
               return;
            }
         }
      
      }		
   			
   }
