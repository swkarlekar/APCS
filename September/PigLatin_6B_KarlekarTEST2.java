// Sweta Karlekar, 9/12/13
   import java.util.*;
   import java.io.*;
   public class PigLatin_6B_Karlekar
   {
      static String vowel = "aeiouAEIOU";
      static String punct = ".,?!:;\"/'(){}$<>@#%^&*"; 
      static char[] punctuations = punct.toCharArray(); 
      public static void main(String[] args) throws FileNotFoundException
      {
   		//test();      
			part_1();
         // part_2();
      }
      public static String pig(String w)
      {
         String begend = "";  
         boolean[] uppercase = new boolean[w.length()]; 
       			 
         if(!isValid(w))
            return "INVALID"; 
      	
			String suffix = getSuffix(w); 
         String prefix = getPrefix(w); 
         String s = getWord(w); 
         int vowloc = findVowLoc(s);
      	
         if(vowloc == s.length() && s.contains("y"))
            vowloc = s.indexOf('y'); 
      		
         if(s.contains("y") && s.charAt(0) != 'y')
            if( vowloc > s.indexOf("y"))
               vowloc = s.indexOf('y'); 
      	
         for(int i = 0; i < s.length(); i++)
            if(Character.isUpperCase(s.charAt(i)))
               uppercase[i] = true;  
      	
         s = s.toLowerCase(); 
      		
         if(vowloc != 0 && s.charAt(vowloc) == 'u' && s.charAt(vowloc - 1) == 'q')
         {
            begend = s.substring(0, vowloc + 1); 
            vowloc++;
         }
      	
         if(s.charAt(0) == 'y')
            begend = s.substring(0, vowloc);
      		
         if(vowloc == 0)
            begend = "w"; 
      	
         if(begend == "")
            begend = s.substring(0, vowloc);  
      	
         s = s.substring(vowloc, s.length()) + begend + "ay";
      	
         for(int i = 0; i < uppercase.length; i++)
            if(uppercase[i])
               s = s.replaceFirst(s.charAt(i)+"", Character.toUpperCase(s.charAt(i))+""); 
      	
      			
         s = prefix + s + suffix; 
         return s; 
      				
      }
      public static void part_1()
      {
         Scanner sc = new Scanner(System.in);
         while(true)
         {
            System.out.print("\nWhat word? ");
            String s = sc.next();
            if (s.equals("-1")) 
               break;
            String p = pig(s);
            System.out.println("***** " + p + " *****");
         }		
      }
      public static boolean isAlpha(char c)
      {
         boolean retvalue = false; 
         if((c>='a' && c<='z')||(c>='A' && c<='Z'))
            retvalue = true; 
         return retvalue; 
      }
      public static int findVowLoc(String s)
      {
         int vowloc = s.length(); 
         for(int i = 0; i < s.length(); i++)
            for(int p = 0; p < vowel.length(); p++)
               if(s.charAt(i) == vowel.charAt(p))
                  if(i < vowloc)
                     vowloc = i;
         return vowloc; 
      
      }
      public static boolean isValid(String s)
      {							 
         boolean retvalue = true; 
         if(findVowLoc(s) == s.length() && !s.contains("y"))
            retvalue = false;
         return retvalue;  
      }
      public static String getPrefix(String s)
      {
         String prefix = ""; 
         char[] array = s.toCharArray();
         for(int i = 0; i < s.length(); i++)
         {
            if(isPunctuation(array[i]))
            {
               prefix = prefix + array[i]; 
            }
            else if(isAlpha(array[i]))
               break; 
         } 
         return prefix; 
      	
      }
      public static boolean isPunctuation(char c)
      {
         boolean retvalue = false; 
         for(int i = 0; i < punctuations.length; i++)
            if(c == punctuations[i])
               retvalue = true; 
         return retvalue; 
      }
      public static String getSuffix(String s)
      {
         String suffix = ""; 
         char[] array = s.toCharArray();
         for(int i = s.length()-1; i >=0; i--)
         {
            if(isPunctuation(array[i]))
            {
               suffix = array[i] + suffix; 
            }
            else if(isAlpha(array[i]))
               break; 
         } 
         return suffix; 
      	 
      }
      public static String getWord(String s)
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
      public static void test()
      {
         System.out.println("pig: " + pig("pig")); 
         System.out.println("latin: " + pig("latin")); 
         System.out.println("this: " + pig("this")); 
         System.out.println("strange: " + pig("strange")); 
         System.out.println("bcdfgh: " + pig("bcdfgh")); 
         System.out.println("apple: " + pig("apple")); 
         System.out.println("eye: " + pig("eye")); 
         System.out.println("question: " + pig("question")); 
         System.out.println("squeeze: " + pig("squeeze")); 
         System.out.println("yes: " + pig("yes")); 
         System.out.println("rhyme: " + pig("rhyme"));
         System.out.println("try: " + pig("try")); 
         System.out.println("Thomas: " + pig("Thomas")); 
         System.out.println("Jefferson: " + pig("Jefferson")); 
         System.out.println("What?: " + pig("What?")); 
         System.out.println("Oh!: " + pig("Oh!")); 
         System.out.println("\"hello\": " + pig("\"hello\"")); 
         System.out.println("\"Hello!\": " + pig("\"Hello!\"")); 
      }
      public static void part_2() 
      {
         /***************************
         *
         *   enter your code here:
      		 Scanner class, try-catch, nested loops, file output  
         *
         ****************************/
      }
   }
