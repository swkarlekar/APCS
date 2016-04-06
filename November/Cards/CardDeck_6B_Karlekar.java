/* name: Sweta Karlekar
   date: 11/20/13
	 */

public class CardDeck_6B_Karlekar
{
   private ListNode myCards;
   public CardDeck_6B_Karlekar() 
   {
      for (int suit = Card_6B_Karlekar.CLUBS; suit <= Card_6B_Karlekar.SPADES; suit++)
         for (int rank = Card_6B_Karlekar.ACE; rank <= Card_6B_Karlekar.KING; rank++) 
         {    
            Card_6B_Karlekar card = new Card_6B_Karlekar(suit, rank);
            putAtEnd(card);
         }
   }  
      /*  returns the top card from the deck.
   		 reassigns a pointer to the new top card.
   		 */
   public Card_6B_Karlekar getTopCard() 
   { 
      return (Card_6B_Karlekar)myCards.getValue(); 
   }
      /*  helper method to put a card at the end of the deck.
   	 	 */
   public void putAtEnd(Card_6B_Karlekar c)
   {
      if(myCards == null)
         myCards = new ListNode(c, null); 
      else
      { 
         ListNode pointer = myCards; 
         while(pointer.getNext() != null)
         {
            pointer = pointer.getNext();
         } 
         ListNode temp = new ListNode(c, null); 
         pointer.setNext(temp);
       
             
      }
   
   }
   public void printDeck()
   {
      if( myCards == null)
      {
         System.out.println("[]");
         return;
      }
      ListNode pointer = new ListNode(); 
      for(ListNode x = myCards; x != null; x = x.getNext())
      {
         System.out.println(myCards.getValue() + " "); 
         if(x.getValue() == myCards.getValue())
         {
            pointer = myCards; 
            break; 
         }
      }
      pointer = myCards.getNext(); 
      while(pointer != myCards && pointer != null)
      {
         System.out.println(pointer.getValue() + " "); 
         pointer = pointer.getNext();  
      
      }
      System.out.println(); 
   }
   	
   	/*  splits this deck into two almost equal halves;
   		 chooses the split point randomly at 26 +- 10; 
   	    the first half remains in this deck in the same order;
   		 the second half is placed into a separate linked list in the same order;
   		 @return a reference to the list that refers to the second half of the deck
   		*/
   private ListNode split() 
   {
      int splitpoint = (int)(Math.random() * 20 + 16);
      ListNode secondHalf = new ListNode();
      ListNode temp = new ListNode(); 
   
      ListNode pointer = myCards;
      for(int i = 0; i < splitpoint -1; i++)
      {
         pointer = pointer.getNext();
      }
      for(ListNode x = pointer; x != null; x = x.getNext())
      {
         temp = new ListNode((Card_6B_Karlekar)x.getValue(), temp);
      } 
      //temp.setNext(null); 
      for(ListNode x = temp; x != null; x = x.getNext())
      {
         secondHalf = new ListNode((Card_6B_Karlekar)x.getValue(), secondHalf);
      } 
      secondHalf = secondHalf.getNext().getNext(); 
      pointer.setNext(null); 
      
      return secondHalf; 
   }
      
      /*  combines the cards from cards1 and cards2 into one list.
   		 takes one card from cards1, the next from cards2, the third
   		 from cards1, and so on, alternating decks;  if there are cards
   		 left over, all the rest of those cards are copied into the combined list.
   		 @return a reference to the first node of the combined list.
   		 */
   private ListNode combine(ListNode cards1, ListNode cards2)
   {
      myCards = null; 
      while(cards1 != null && cards2.getValue() != null)
      {
         myCards = new ListNode(cards1.getValue(), myCards); 
         cards1 = cards1.getNext(); 
         myCards = new ListNode(cards2.getValue(), myCards);
         cards2 = cards2.getNext(); 
      } 
      if(cards1 != null)
      {
         while(cards1!= null)
         {
            myCards = new ListNode(cards1.getValue(), myCards); 
            cards1 = cards1.getNext(); 
         }
      }
      if(cards2.getValue() != null)
      {
         while(cards2.getValue() != null)
         {
            myCards = new ListNode(cards2.getValue(), myCards); 
            cards2 = cards2.getNext(); 
         }
      } 
      ListNode prev = null, next = myCards.getNext();
      while(next != null)
      {
         myCards.setNext(prev); 
         prev = myCards; 
         myCards = next;
         next = myCards.getNext(); 
      } 
      myCards.setNext(prev); 
      return myCards; 
      
   }
      
      
      /*  splits the deck, then combines the 2 halves;
   	    this operation is repeated numTimes number of times.
   		*/
   public void shuffle(int numTimes)
   {
      System.out.println("----------IN ORDER---------"); 
      printDeck(); 
      for(int i = 0; i < numTimes; i++)
      {
         ListNode otherdeck = split(); 
         combine(myCards, otherdeck); 
      }
      System.out.println("----------SHUFFLED----------"); 
      printDeck(); 
   }
}
