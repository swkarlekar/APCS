//Name: Sweta Karlekar    Date: 4/2/14

public class HeapSort_6B_Karlekar
{
   public static final int SIZE = 100;
   public static void swap(double[] array, int a, int b)
   {
      double d = array[a]; 
      array[a] = array[b]; 
      array [b] = d; 
   }
   public static void heapDown(double[] array, int k, int size)
   {
      int left = 2*k; 
      int right = 2*k+1; 
      if(k > size || left > size || right > size)
         return; 
      else
      {
         int maxChild = (array[left] > array[right]) ? left : right; 
         if(array[k] < array[maxChild])
         {
            swap(array, k, maxChild); 
            heapDown(array, maxChild, size); 
         }
      }
   }
   public static void sort(double[] array)
   {
      for(int size = array.length-1; size > 2; size--)
      {
         heapDown(array, 1, size);
         swap(array, 1, size);            
      }
   }
   public static void display(double[] array)
   {
      for(int k = 1; k < array.length; k++)
         System.out.print(array[k] + "    ");
      System.out.println("\n");	
   }
   public static void createRandom(double[] array)
   {  
      for(int k = 1; k <= SIZE; k++)
      {
         int n;
         do
            n = (int)(Math.random() * 9000);
            while(n % 10 == 0);
         array[k] =  n / 100.0;
      }
   }
   public static void makeHeap(double[] array, int size)
   {
      for(int k = SIZE/2; k >= 1; k--)
         heapDown(array, k, SIZE); 
   }
   public static void main(String[] args)
   {
      //Part 2:  Create a heap from random numbers, sort it.
         double[] array = new double[SIZE + 1];
         createRandom(array);
         display(array);
         makeHeap(array, SIZE);
         display(array); 
         sort(array);
         display(array);
      	      	
      //Part 1: Given a heap, sort it. Do this part first.   
         /*double array[] = {-1,99,80,85,17,30,84,2,16,1};
         display(array);
         sort(array);
         display(array);*/
   }
}
