//  Name: Sweta Karlekar     date: 3/26/14
//  This program takes a text file, creates an index (by line numbers)
//  for all the words in the file and writes the index
//  into the output file.  The program prompts the user for the file names.

import java.io.*;
import java.util.*;

public class IndexMakerMap_6B_Karlekar
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
      int lineNum = 0;
      while(inputFile.hasNextLine())
      {
         lineNum++;
         index.addAllWords(inputFile.nextLine(), lineNum);
      }
      //print to the outputFile
      for(String s : index.keySet())
         outputFile.println(s + " " + index.get(s));
   	
      inputFile.close(); 						
      outputFile.close();
      System.out.println("Done.");
   }
}

class DocumentIndex extends TreeMap<String, ArrayList<Integer>>
{
   public void addWord(String word, int lineNum)
   {
      if(this.containsKey(word))
      {
         for(String s : this.keySet())
            if(s.equals(word))
               this.get(s).add(lineNum); 
      }
      else
      {
         ArrayList<Integer> insert = new ArrayList<Integer>(); 
         insert.add(lineNum); 
         this.put(word, insert); 
      }
   
   
   }
   
 /** extracts all the words from str, skipping punctuation and whitespace 
 and for each word calls addWord(word, num).  A good way to skip punctuation 
 and whitespace is to use String's split method, e.g., split("[., \"!?]") */
   public void addAllWords(String str, int lineNum) 
   {
      String[] array = str.split("[&*(^ ., \"!?]"); 
      for(String m : array)
      {
         if(!m.isEmpty())
            addWord(m.toUpperCase(), lineNum);   
      }
   }
}


