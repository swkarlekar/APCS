 //Name: Sweta Karlekar   Date: 11/25/13
 // use for-each loops or iterators, not regular for-loops
   import java.io.*;
   import java.util.*;
    public class IteratorLab_6B_Karlekar
   {
       public static void main(String[] args)
      {
         System.out.println("Iterator Lab\n");
         int[] rawNumbers = {-9, 4, 2, 5, -10, 6, -4, 24, 20, -28};
         for(int n : rawNumbers )
            System.out.print(n + " ");  
         System.out.println();   
         ArrayList<Integer> numbers = createNumbers(rawNumbers);
         System.out.println("ArrayList: "+ numbers);      //Implicit Iterator!
         System.out.println("Count negative numbers: " + countNeg(numbers));
         System.out.println("Average: " + average(numbers));
         System.out.println("Replace negative numbers: " + replaceNeg(numbers));
         System.out.println("Delete zeros: " + deleteZero(numbers));
         String[] rawMovies = {"High_Noon", "High_Noon", "Star_Wars", "Tron", "Mary_Poppins", 
               "Dr_No", "Dr_No", "Mary_Poppins", "High_Noon", "Tron"};
         ArrayList<String> movies = createMovies(rawMovies);
         System.out.println("Movies: " + movies);
         System.out.println("Movies: " +  removeDupes(movies));
      }
      // pre: an array of just int values 
   	// post: return an ArrayList containing all the values
       public static ArrayList<Integer> createNumbers(int[] rawNumbers) 
      {
         ArrayList<Integer> arrlist = new ArrayList<Integer>(rawNumbers.length);
         for(int n : rawNumbers)
            arrlist.add(n); 
        
         return arrlist; 

      }
      // pre: an array of just Strings  
   	// post: return an ArrayList containing all the Strings
       public static ArrayList<String> createMovies(String[] rawWords) 
      {  
         ArrayList<String> arrlist = new ArrayList<String>(rawWords.length);
         for(String s : rawWords)
            arrlist.add(s); 
        
         return arrlist; 

      }
   
   	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: return the number of negative values in the ArrayList a
       public static int countNeg(ArrayList<Integer> a)
      {
         int countneg = 0; 
         for(Integer num : a)
         {
            if(num < 0)
               countneg++; 
         }
         return countneg; 

      }
   	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: return the average of all values in the ArrayList a
       public static double average(ArrayList<Integer> a)
      {
         double sum = 0; 
         for(Integer num : a)
         {
            sum += num; 
         }
         return sum/a.size(); 
      }
     	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: replaces all negative values with 0 
       public static ArrayList<Integer> replaceNeg(ArrayList<Integer> a)
      {
         ListIterator<Integer> it = a.listIterator(); 
         while(it.hasNext())
            if(it.next() < 0)
               it.set(0);
         return a;  

      }
     	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: deletes all zeros in the ArrayList a
       public static ArrayList<Integer> deleteZero(ArrayList<Integer> a)
      {
         ListIterator<Integer> it = a.listIterator(); 
         while(it.hasNext())
            if(it.next() == 0)
               it.remove();
         return a;

      }
      // pre: ArrayList a is not empty and contains only String objects
   	// post: return ArrayList without duplicate movie titles
		// strategy: start with an empty array and add movies as needed
       public static ArrayList<String> removeDupes(ArrayList<String> a)
      {
          ArrayList<String> nodupes = new ArrayList<String>(); 
          ListIterator<String> it = a.listIterator(); 
          while(it.hasNext())
          {
            String name = it.next(); 
            if(!nodupes.contains(name))
               nodupes.add(name); 
          }
         return nodupes;
 
      }
   
   }

