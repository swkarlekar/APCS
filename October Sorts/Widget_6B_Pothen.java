//name: Melissa Pothen    date: October 20, 2013
   import java.io.*;      //the File class
   import java.util.*;    //the Scanner class
   public class Widget_6B_Pothen
   {
      public static final int numberOfWidgets = 57;
      public static Comparable[] compare;
      public static void main(String[] args) throws Exception
      {
         selectionSort(compare);
         insertionSort(compare);
         print(compare);
      }      	
      public static Comparable[] input(String filename) throws Exception
      {
         compare = new Widget[numberOfWidgets];      
         Scanner infile = new Scanner ( new File("widget.txt") );
         while(infile.hasNext())
         {
            for(int x = 0; x < compare.length; x++)
            {
               Widget newwidget = new Widget(infile.nextInt(), infile.nextInt());
            }
         }
			return compare;
      }  
      public static void print(Object[] mango)
      {
         for(Object abc : mango)     //for-each
            System.out.println(abc);
      }
      public static void selectionSort(Comparable[] array)
      {
         for(int x = array.length - 1; x >= 0; x--)
         {
            int max = findMax(array, x);
            swap(array, x, max);
         }
      }
      public static void insertionSort(Comparable[] array)
      {
         for(int x = 1; x < array.length; x++)
         {
            shift(array, x, array[x]);
         } 
      }
      public static void shift(Comparable[] array, int index, Comparable value)
      {
         for (int x = 1; x < array.length; x++) 
         {
            while (index > 0 && array[index - 1].compareTo(value) > 0) 
            {
               array[index] = array[index - 1];
               index--;
            }
            array[index] = value;
         }      	
      }
      public static int findMax(Comparable[] array, int upper)
      {
         int index = 0;
         for(int x = 0; x < upper; x++)
         {
            if(array[x].compareTo(array[index]) > 0)
            {
               index = x;
            }
         }
         return index;
      }
      public static void swap(Object[] array, int a, int b)
      {
         Object temp = array[a];
         array[a]=array[b];
         array[b]=temp;
      }
   
   
   }
   /////////////////////////////////////////////////////
	//name:Melissa Pothen    date:October 20, 2013

   class Widget implements Comparable<Widget>
   {
      private static int ounces, pounds;
      public Widget(int x, int y)
      {
         pounds = x;
         ounces = y;
      }
      public static void setPounds(int x)
      {
         pounds = x;
      }
      public static void setOunces(int x)
      {
         ounces = x;
      }
      public static int getPounds()
      {
         return pounds;
      }
      public static int getOunces()
      {
         return ounces;
      }
      public  String toString()
      {
         return pounds + " lbs., " + ounces + " oz.";
      }
      public static boolean equals(Widget a, Widget b)
      {
         if(a.compareTo(b) > 1 || a.compareTo(b) == 0)
         {
            return true;
         }
         return false;
      }
      public  int compareTo(Widget b)
      {      
			if(pounds > b.getPounds())
         {
            return 1;
         }
         if(pounds < b.getPounds())
         {
            return -1;
         }
         if(pounds == b.getPounds() && ounces == b.getPounds())
         {
            return 0;
         }
         else
         {
            if(ounces > b.getOunces())
            {
               return 1;
            }
            return -1;
         }
      }
   }