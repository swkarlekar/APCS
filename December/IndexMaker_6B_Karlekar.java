//  Name: Sweta Karlekar     date:12/4/13
//  This program takes a text file, creates an index (by line numbers)
//  for all the words in the file and writes the index
//  into the output file.  The program prompts the user for the file names.

import java.util.*;
import java.io.*;

public class IndexMaker_6B_Karlekar
{
   public static void main(String[] args) throws IOException
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("\nEnter input file name: ");
      String fileName = keyboard.nextLine().trim();
      Scanner inputFile = new Scanner(new File(fileName));
      System.out.print("\nEnter output file name: ");
      fileName = keyboard.nextLine().trim();
      PrintWriter outputFile = new PrintWriter(new FileWriter(fileName));
      DocumentIndex index = new DocumentIndex(); 	
      String line = null;
      int lineNum = 0;
      while(inputFile.hasNextLine())
      {
         lineNum++;
         index.addAllWords(inputFile.nextLine(), lineNum);
      }
      for(IndexEntry entry : index)
         outputFile.println(entry);
      inputFile.close(); 						
      outputFile.close();
      System.out.println("Done.");
   }
}
class DocumentIndex extends ArrayList<IndexEntry>
{ 
    //constructors
   public DocumentIndex()
   {
      ArrayList<IndexEntry> arrie = new ArrayList<IndexEntry>(); 
   }
   public DocumentIndex(int n)
   {
      ArrayList<IndexEntry> arrie = new ArrayList<IndexEntry>(n); 
   }

   /**
      calls foundOrInserted.  At the IndexEntry at the returned position,  
      updates the list of line numbers with num.   
    */
   public void addWord(String word, int num)
   {
      int index = foundOrInserted(word); 
      this.get(index).add(num); 
   }
      
    /** extracts all the words from str, skipping punctuation and whitespace 
    and for each word calls addWord(word, num).  A good way to skip punctuation 
    and whitespace is to use String's split method, e.g., split("[., \"!?]") */
   public void addAllWords(String str, int num) 
   {
      String[] array = str.split("[&*(^ ., \"!?]"); 
      for(String m : array)
      {
         if(!m.isEmpty())
            addWord(m, num);   
      }
      
   }
      
    /** traverses this DocumentIndex and compares word to the words in the 
    IndexEntry objects in this list, looking for the correct position of 
    word. If an IndexEntry with word is not already in that position, the 
    method creates and inserts a new IndexEntry at that position. The 
    method returns the position of either the found or the inserted 
    IndexEntry.*/
   private int foundOrInserted(String word)
   {
      if(this.isEmpty())
      {
         this.add(new IndexEntry(word)); 
         return 0; 
      }
      ListIterator<IndexEntry> it = this.listIterator();
      boolean isThere = false;
      int index = 0; 
      while(it.hasNext())
      {
         String temp = it.next().getWord(); 
         if(word.compareToIgnoreCase(temp) < 0)
            break; 
         if(word.compareToIgnoreCase(temp) == 0)
         {
            isThere = true; 
            break; 
         }
         index++; 
      }
      if(!isThere)
         this.add(index, new IndexEntry(word)); 
      
      return index;    
   }
}
   
class IndexEntry implements Comparable<IndexEntry>
{
     //fields
   private String word; 
   private ArrayList<Integer> numsList; 
   
     //constructors
   public IndexEntry(String s)
   {
      word = s.toUpperCase(); 
      numsList = new ArrayList<Integer>(); 
   }
   
     /**  appends num to numsList, but only if it is not already in that list.    
          */
   public void add(int num)
   {
      if(!numsList.contains(num))
         numsList.add(num); 
   }
      
   	/** this is a standard accessor method  */
   public String getWord()
   {
      return word; 
   }
      
     /**  returns a string representation of this Index Entry.  */
   public String toString()
   {
      return word + " " + numsList.toString(); 
   }
   public int compareTo(IndexEntry a)
   {
      return word.compareTo(a.getWord()); 
   }
}

