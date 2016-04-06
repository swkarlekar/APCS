// your name, date
   import java.util.*;
   import java.io.*;
    public class PigLatin_6B_KarlekarTEST
   {
		static String vowel = "aeiouAEIOU";
		static String punct = ".,?!:;\"/'(){}$<>@#%^&*"; 
		
       public static void main(String[] args) throws FileNotFoundException
      {
         part_1();
         // part_2();
      }
       public static String pig(String s)
      {
		String begend = "";  
		boolean punctuatboolean = false; 
		boolean[] uppercase = new boolean[s.length()]; 
		String[] punctuation = new String[s.length()]; 
		String punctend = "";
		String punctbeg = ""; 

			
			int vowloc = s.length(); 
			for(int i = 0; i < s.length(); i++)
				for(int p = 0; p < vowel.length(); p++)
					if(s.charAt(i) == vowel.charAt(p))
						if(i < vowloc)
							vowloc = i;
							 
			if(vowloc == s.length() && !s.contains("y"))
				return "INVALID"; 
			
			if(vowloc == s.length() && s.contains("y"))
				vowloc = s.indexOf('y'); 
				
			for(int i = 0; i < s.length(); i++)
				if(Character.isUpperCase(s.charAt(i)))
					uppercase[i] = true;  
			
			for(int i = 0; i < punct.length(); i++)
			{
				for(int w = s.length()/2; w < s.length(); w++)
				{
					if(punct.charAt(i) == s.charAt(w))
					{
						punctend = punctend + (s.charAt(w));  
						
					}
				}
			}
			for(int i = 0; i < punct.length(); i++)
			{
				for(int w = 0; w < s.length()/2; w++)
				{
					if(punct.charAt(i) == s.charAt(w))
					{
						punctbeg = punctbeg + (s.charAt(w));  
						
					}
				}
			}
			for(int i = 0; i < punct.length(); i++)
				for(int w = 0; w< s.length(); w++)
					if(punct.charAt(i) == s.charAt(w))
						s = s.replace(s.charAt(w)+"", ""); 
			s = s.toLowerCase(); 
				
			if(vowloc != 0 && s.charAt(vowloc) == 'u' && s.charAt(vowloc - 1) == 'q')
			{
				begend = "qu"; 
				vowloc++;
			}
			
			if(s.charAt(0) == 'y')
				begend = "y";
				
			if(vowloc == 0)
				begend = "w"; 
			
			if(begend == "")
				begend = s.substring(0, vowloc);  
				
			s = s.substring(vowloc, s.length()) + begend + "ay";
			for(int i = 0; i < uppercase.length; i++)
				if(uppercase[i])
					s = s.replaceFirst(s.charAt(i)+"", Character.toUpperCase(s.charAt(i))+""); 
					
			s = punctbeg + s + punctend; 
			return s; 
						
         /***************************
         *
         *   enter your code here  
         *
         ****************************/
      
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
