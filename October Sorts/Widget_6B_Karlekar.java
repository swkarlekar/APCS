//name: Sweta Karlekar   date:  10/18/13

   import java.io.*;      //the File class
   import java.util.*;    //the Scanner class
   
    public class Widget_6B_Karlekar
   {
      public static final int numberOfWidgets = 57;
       public static void main(String[] args) throws Exception
      {
			Comparable[] widgetArray = input("widget.txt"); 
			selectionSort(widgetArray); 
			insertionSort(widgetArray); 
      }  	
       public static Comparable[] input(String filename) throws Exception
      {
      	Scanner infile = new Scanner(new File(filename));
			Comparable[] array = new Comparable[numberOfWidgets]; 
			for(int i = 0; i < numberOfWidgets; i++)
			{
				array[i] = new Widget(infile.nextInt(), infile.nextInt()); 
			}
			return array; 
      }
       public static void print(Object[] mango)
      {
      	for(Object item : mango)     //for-each
            System.out.println( item );
      }
		public static void selectionSort(Comparable[] array)
      {
         for(int i = array.length-1; i>=0; i--)
         {
            int swapper = findMax(array, i);
            swap(array, i, swapper);  
         }
			System.out.println("----------SELECTION SORT----------"); 
			print(array);
			System.out.println(); 
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
		public static void insertionSort(Comparable[] array)
      { 
         for(int i = 1; i < array.length; i++)
         {
            shift(array, i, array[i]);
         }
			System.out.println("----------INSERTION SORT----------"); 
			print(array);
			System.out.println();
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
   /////////////////////////////////////////////////////
	//name: Sweta Karlekar   date: 10/18/13

    class Widget implements Comparable<Widget>
   {
   	private int myPounds; 
		private int myOunces;
		public Widget(int pounds, int ounces)
		{
			myPounds = pounds; 
			myOunces = ounces; 
		} 
		public int getPounds()
		{
			return myPounds; 
		}
		public int getOunces()
		{
			return myOunces; 
		}
		public void setPounds(int lbs)
		{
			myPounds = lbs; 
		}
		public void setOunces(int oz)
		{
			myOunces = oz; 
		}
		public int compareTo(Widget w)
		{
			if(myPounds < w.myPounds)
				return -1; 
			if(myPounds > w.myPounds)
				return 1; 
			if(myOunces < w.myOunces)
				return -1; 
			if(myOunces > w.myOunces)
				return 1; 
			return 0; 
		}
		public boolean equals(Widget w)
		{
			if(this.compareTo(w) == 0)
				return true; 
			return false; 
		}
		public String toString()
		{
			return myPounds + " lbs., " + myOunces + " oz."; 
		}
   }