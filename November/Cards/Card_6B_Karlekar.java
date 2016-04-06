/* mlbillington@fcps.edu, 22 October 2008
	using ideas from	http://www.ccs.neu.edu/jpt/fhs-04-05/Cards/CardSampler/
   NAME: SWETA KARLEKAR   DATE:11/19/13
 */

    public class Card_6B_Karlekar
   {
      public static final int CLUBS  = 0;     //for playing Bridge 
      public static final int DIAMONDS = 1;
      public static final int HEARTS = 2;
      public static final int SPADES = 3;
    
      public static final int ACE = 1;		   //Aces are always low
      public static final int JACK = 11;
      public static final int QUEEN = 12;
      public static final int KING = 13;
      
      private int rank;
      private int suit;
      
      private String[] rankList = {"","Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
      private String[] suitList = {"Clubs","Diamonds","Hearts","Spades"};
     
       public Card_6B_Karlekar(int s, int r) {
         if ((ACE <= r) && (r <= KING))
            this.rank = r;
         else
            throw new RuntimeException
                ("Invalid rank in Card constructor: " + rank);
        
         if ((CLUBS <= s) && (s <= SPADES))
            this.suit = s;
         else
            throw new RuntimeException
                ("Invalid suit in Card constructor: " + suit);
      }
   
       public int getRank() 
      { 
          return rank; 
      }
    
       public int getSuit() 
      { 
         return suit; 
      }
    
       public String getRankAsString() 
      { 
         return rankList[rank];  
      }
    
       public String getSuitAsString() 
      { 
         return suitList[suit]; 
      }
         
       public String toString()
      {
         return getRankAsString() + " of " + getSuitAsString(); 
      }
   }
