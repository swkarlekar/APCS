//Name:Sweta Karlekar          date:9/16/13
    public class Sentence_6B_Karlekar
   {
       public static void main(String[] args)
      {
         System.out.println("PALINDROME TESTER");
			System.out.println("_________________");
			System.out.println(); 
         Sentence s = new Sentence( "\"Hello there!\" she said." );
         System.out.println( s.getSentence() );
         System.out.println( s.getNumWords() );
         System.out.println( s.isPalindrome() );
         System.out.println();
         
         s = new Sentence( "A Santa lived as a devil at NASA." );
         System.out.println( s.getSentence() );
         System.out.println( s.getNumWords() );
         System.out.println( s.isPalindrome() );
         System.out.println();
        
      
         s = new Sentence( "Flo, gin is a sin! I golf." );
         System.out.println( s.getSentence() );
         System.out.println( s.getNumWords() );
         System.out.println( s.isPalindrome() );
         System.out.println();
         
      
         s = new Sentence( "Eva, can I stab bats in a cave?" );
         System.out.println( s.getSentence() );
         System.out.println( s.getNumWords() );
         System.out.println( s.isPalindrome() );
         System.out.println();
      
         s = new Sentence( "Madam, I'm Adam." );
         System.out.println( s.getSentence() );
         System.out.println( s.getNumWords() );
         System.out.println( s.isPalindrome() );
         System.out.println();
			
			s = new Sentence( "Malayalam" );
         System.out.println( s.getSentence() );
         System.out.println( s.getNumWords() );
         System.out.println( s.isPalindrome() );
         System.out.println();
			
			s = new Sentence( "Malaydalam" );
         System.out.println( s.getSentence() );
         System.out.println( s.getNumWords() );
         System.out.println( s.isPalindrome() );
         System.out.println();
			
			s = new Sentence( "Eva, can I stab racecar bats in a cave?" );
         System.out.println( s.getSentence() );
         System.out.println( s.getNumWords() );
         System.out.println( s.isPalindrome() );
         System.out.println();
			
			s = new Sentence( "*&%($(^&" );
         System.out.println( s.getSentence() );
         System.out.println( s.getNumWords() );
         System.out.println( s.isPalindrome() );
         System.out.println();
			
			s = new Sentence( "" );
         System.out.println( s.getSentence() );
         System.out.println( s.getNumWords() );
         System.out.println( s.isPalindrome() );
         System.out.println();
         
      // Lots more test cases.  Test every line of code.  Test
      // the extremes, test the boundaries.  How many test cases do you need?
      
      }
   }
    class Sentence
   {
		private static String punct = ".,?!:;\"/'(){}$<>@#%^&*";
		private String mySentence;
		private boolean isPalindrome = false; 
      private int myNumWords;
      
      //Constructor.  Creates sentence from String str.
      //						Finds the number of words in sentence.
      //Precondition:  Words in str separated by exactly one blank.
       public Sentence( String str )
      { 
         mySentence = str; 
			String[] space = str.split(" "); 
			myNumWords = space.length; 
      }
      
       public int getNumWords()
      {  
         return myNumWords;  
      }
      
       public String getSentence()
      {
         return mySentence; 
      }
      
      //Returns true if mySentence is a palindrome, false otherwise.
       public boolean isPalindrome()
      { 
			String s = mySentence; 
			s = scrub(s); 
			if(s.isEmpty())
			{
				System.out.println("You entered an empty string or just punctuation marks!"); 
				return false; 
			}
			return isPalindrome(s, 0, s.length()); 
      }
      //Precondition: s has no blanks, no punctuation, and is in lower case.
      //Returns true if s is a palindrome, false otherwise.
       private static boolean isPalindrome( String str, int start, int end )
      {
         if(str.length() == 0 || str.length() == 1)
				return true;
				 
			else if(str.charAt(start) != str.charAt(end-1))
				return false; 
			
			str = str.substring(start + 1, end - 1); 
			return isPalindrome(str, 0, str.length());
			  
		}
      //Returns copy of String s with all blanks removed.
      //Postcondition:  Returned string contains just one word.
       private static String removeBlanks( String s )
      {  
         s = s.replace(" ", "");
			return s;  
      }
      
      //Returns copy of String s with all letters in lowercase.
      //Postcondition:  Number of words in returned string equals
      //						number of words in s.
       private static String lowerCase( String s )
      {  
         s = s.toLowerCase(); 
			return s; 
      }
      
      //Returns copy of String s with all punctuation removed.
      //Postcondition:  Number of words in returned string equals
      //						number of words in s.
       private static String removePunctuation( String s )
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
		//Returns copy of lowercase String s with all punctuation and spaces removed.
		//Postcondition: Returned string contains just one word. 
		private static String scrub(String s)
		{
			s = lowerCase(s); 
			s = removeBlanks(s); 
			s = removePunctuation(s);
			return s; 
		}
   }
