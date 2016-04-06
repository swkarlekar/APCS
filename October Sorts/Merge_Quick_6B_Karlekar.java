    /* 
    Calls methods in the classes Merge and QuickSort. 
	 Students are to write the Merge and QuickSort classes.
    */
   import java.util.*;
   import java.io.*;
   public class Merge_Quick_6B_Karlekar
   {
      public static void main(String[] args) throws Exception
      {
         int n = (int)(Math.random()*100);
         double[] array = new double[n];
         for(int k = 0; k < array.length; k++)
            array[k] = Math.random();
			System.out.println("---------ORIGINAL ARRAY---------"); 
         print(array);
			System.out.println("---------SORTED ARRAY---------"); 
         MergeSort.sort(array);
        	QuickSort.sort(array, 0, array.length-1);
         print(array);
         if(check(array))
            System.out.println("In order!");
         else
            System.out.println("oops!");
      }
      public static void print(double[] array)
      {
         for(double theNumber : array )     //doing something to each
            System.out.println(theNumber);
         System.out.println();
      }
      public static boolean check(double[] a)
      {
         boolean isorder = true; 
         for(int i = 0; i < a.length; i++)
         {
            if((i+1) == a.length)
               return true; 
            if(a[i] > a[i+1])
               return false; 
         
         }
         return isorder; 
      }
   }
/////////////////////////////////////////////////
// from Lambert & Osborne, p. 482 - 485
   class MergeSort
   {
      private static final int CUTOFF = 10;  // for small lists, recursion isn't worth it
      public static void sort(double[] array)
      { 
         double[] copyBuffer = new double[array.length];
         mergeSortHelper(array, copyBuffer, 0, array.length - 1);
      }
   
      private static void mergeSortHelper(double[] array, double[] copyBuffer,
                                                             int low, int high)
      {  
        	if ( high - low  < CUTOFF )              //switch to selection sort  when
            Selection.sort(array);     //each list gets small enough 
         else 
			{ 
            if (low < high)
            {
               int middle = (low + high) / 2;
               mergeSortHelper(array, copyBuffer, low, middle);
               mergeSortHelper(array, copyBuffer, middle + 1, high);
               merge(array, copyBuffer, low, middle, high);
            }
			}
      }
   	
      public static void merge(double[] array, double[] copyBuffer,
                                      int low, int middle, int high)
      // array				array that is being sorted
      // copyBuffer		temp space needed during the merge process
      // low				beginning of first sorted subarray
      // middle			end of first sorted subarray
      // middle + 1		beginning of second sorted subarray
      // high				end of second sorted subarray
      {
        		/* write the merge method  */
      
         for(int k = low; k <= high; k++)
            copyBuffer[k] = array[k]; 
      		
         int midplus = middle+1;
         int pos = low;  
         while((low <= middle || midplus <= high))
         {
				if((low <= middle) && (midplus > high))
				{
					array[pos] = copyBuffer[low]; 
           	 	low++; 
            	pos++;
				}
				else if((midplus <= high) && (low > middle))
				{
					array[pos] = copyBuffer[midplus]; 
            	midplus++; 
            	pos++; 
				}
            else if(copyBuffer[low] <= copyBuffer[midplus])
            {
               array[pos] = copyBuffer[low]; 
               low++; 
               pos++; 
            }
            else if(copyBuffer[low] > copyBuffer[midplus])
            {
               array[pos] = copyBuffer[midplus]; 
               midplus++; 
               pos++; 
            }
				
         }

      
      }		
   }

////////////////////////////////////////////////////
  class QuickSort
   {
      public static void sort(double[] array, int first, int last)
      {
			int splitPt; 
			if(first < last)
			{
				splitPt = split(array, first, last);
				sort(array, first, splitPt-1); 
				sort(array, splitPt+1, last);  
			}
      }
      private static int split(double[] array, int first, int last)
      {
			int splitPt = first; 
			double pivot = array[first]; 
			
			while(first <= last)
			{
				if(array[first] <= pivot)
					first++; 
				else if(array[last] >= pivot)
					last--; 
				else
				{
					swap(array, first, last); 
					first++; 
					last--; 
				}
			}
			swap(array, last, splitPt); 
			splitPt = last; 
			return splitPt; 
			
      }
      private static void swap(double[] array, int a, int b)
      {
			double temp = array[a]; 
			array[a] = array[b]; 
			array[b] = temp; 
      }
   }