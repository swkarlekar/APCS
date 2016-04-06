	//name:Sweta Karlekar    date:10/21/13
   import java.io.*;      //the File 
   import java.util.*;    //the Scanner 
   //import javax.swing.*;  //the JOptionPane
   public class Search_6B_Karlekar
   {
      static String punct = ".,?!:;\"/'(){}$<>@#%^&*-[]";
      public static void main(String[] args) throws Exception
      {
         while(true)
         {
            Comparable[] stringArray = input("declaration.txt");
            Selection.sort(stringArray); 
            Scanner keyboard = new Scanner(System.in);  		
            System.out.print("Enter a word: "); 
            String wordname = keyboard.next(); 
            if(wordname.equals("-1"))
            {
               System.out.println("Good-bye!"); 
               System.exit(0); 
            }
            else
            {
               int printout = Search.linear(stringArray, wordname); 
					int printout2 = Search.binary(stringArray, wordname);
					if(printout == -1 || printout2 == -1)
					{ 
						if(printout == -1)
							System.out.println("Linear Search did not find this word."); 
						if(printout2 == -1)
							System.out.println("Binary Search did not find this word."); 
						System.out.println();
					}
					else
					{
               	System.out.println("Linear Search found it at location " + printout + " in " + Search.linearCount + " comparisons."); 
						System.out.println("Binary Search found it at location " + printout2 + " in " + Search.binaryCount +  " comparisons."); 
						System.out.println(); 
					}
            }
         }
      	
      }
      public static String[] input(String filename) throws Exception
      { 
         int numberOfWords = findNumWords(filename); 
         Scanner infile2 = new Scanner(new File(filename));
         String[] array = new String[numberOfWords]; 
         for(int i = 0; i < numberOfWords; i++)
         {
            array[i] = new String(removePunc(infile2.next())); 
         }
         infile2.close(); 
         return array; 
      }
      public static int findNumWords(String filename) throws Exception
      {
         Scanner infile = new Scanner(new File(filename));
         int numWords = 0; 
         String stringfile; 
         do{
            stringfile = infile.nextLine(); 
            numWords += stringfile.split(" ").length; 
         }while(infile.hasNextLine()); 
         infile.close(); 
         return numWords;
      }
      public static String removePunc(String s)
      {
         String word = s; 
         for(int i = 0; i < punct.length(); i++)
         {
            for(int w = 0; w < word.length(); w++)
            {
               if(punct.charAt(i) == word.charAt(w))
                  word = word.replace(word.charAt(w)+"", ""); 
            }
         } 
         return word; 
      }	
   
      public static boolean isPunctuation(char c)
      {
         boolean retvalue = false; 
         for(int i = 0; i < punct.length(); i++)
            if(c == punct.charAt(i))
               retvalue = true; 
         return retvalue; 
      }

   
   }
	/////////////////////////////////////////////////////////
   class Search
   {
      static int linearCount = 0;
      static int binaryCount = 0;

      public static int linear(Comparable[] array, Comparable target)
      { 
         int index = -1; 
         for(int i = 0; i < array.length; i++)
         {
				linearCount++; 
            if(array[i].compareTo(target) == 0)
               return i; 
         }
         return index; 
      }
      public static int binary(Comparable[] array, Comparable target)
      {
         return binaryhelper(array, target, 0, (array.length-1)); 
      }
      private static int binaryhelper(Comparable[] array, Comparable target, int start, int end)
      {		

         if(array[start].compareTo(target) == 0)
			{
				binaryCount++; 
				return start; 
			}
			if(array[end].compareTo(target) == 0)
			{
				binaryCount++; 
				return end;
			}
			if(start + 1 == end)
			{
				start++; 
				end--;
			}
			if(array[start].compareTo(array[end]) > 0)
			{
				binaryCount++; 
				return -1; 
			}
			int middle = ((start+end)/2); 
			if(target.compareTo(array[middle]) > 0)
			{
				binaryCount++; 
				return binaryhelper(array, target, middle, end); 
			}
			else
			{
				binaryCount++; 
				return binaryhelper(array, target, start, middle); 
			}
      }
   }
