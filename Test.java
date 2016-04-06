import java.util.Queue; 
import java.util.Stack; 
import java.util.ArrayList;
import java.util.List;
import java.util.*;  
public class Test
{
   public static void main(String[] args)
   {
      ArrayList<Integer> a = new ArrayList<Integer>(10); 
      a.get(2); 
   }
   public static String recombine(String word1, String word2)
   {
      return(word1.substring(0, word1.length()/2) + word2.substring(word2.length()/2, word2.length())); 
   }
   public static String[] mixedWords(String[] words)
   {
      String[] mixed = new String[words.length];
      for(int i = 0; i < words.length; i=i+2)
      {
         String word1 = words[i]; 
         String word2 = words[i+1]; 
         mixed[i] = recombine(word1, word2); 
         mixed[i+1] = recombine(word2, word1); 
      }
      return mixed;
   
      
   }
  
}