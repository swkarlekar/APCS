// Name: Sweta Karlekar  Date: 11/11/13

/*****************************************
Demonstrates many ways to reverse a list made of ListNodes.
******************************************/
public class ListLabReverse_6B_Karlekar
{
   public static void main(String[] args)
   {
      ListNode head = new ListNode("hello", null);
      head = new ListNode("foo", head);
      head = new ListNode("boo", head);
      head = new ListNode("nonsense", head);
      head = new ListNode("computer",
         new ListNode("science",
         new ListNode("java",
         new ListNode("coffee", head))));
         
      System.out.print("original: \t\t");
      print(head);
      
      System.out.print("printReverse: \t\t");
      printReverse(head);
   
      System.out.println();
      System.out.print("original: \t\t");
      print(head);
           
      System.out.print("reverse with 2 pointers:");
      head = reverse(null, head);
      print(head);
   		       	
      System.out.print("iterative reverse:\t");
      head = reverseIterate(head);
      print(head);
   				         
      System.out.print("reverse in place: \t");
      head = reverseInPlace(head);
      print(head);
   	
      System.out.print("reverse a ll: \t\t");
      head = reverseLL(head);
      print(head);
   
      System.out.print("Mind Bender reverse:\t");
      head = mindBender(head);
      print(head);
   }
   public static void print(ListNode head)
   {
      System.out.print("[");
      while(head != null)
      {
         
         System.out.print(head.getValue());
         head = head.getNext();
         if(head != null)
            System.out.print(", ");
        
      }
      System.out.println("]");
   }
	
	/*********************************************
	These two methods don't reverse the list.  They only print out
	the list in reverse order.  printReverse() prints the square 
	brackets and calls helper().  helper() is recursive.
	********************************************************/
   public static void printReverse(ListNode h)
   {
      if(h==null)
      {
         System.out.print("[]"); 
         return; 
      }
      System.out.print("["); 
      helper(h.getNext()); 
      System.out.print(h.getValue() + "]"); 
   }
   private static void helper(ListNode p)
   {
      if(p == null)
         return; 
      helper(p.getNext()); 
      System.out.print(p.getValue() + ", "); 
   }
   
   /*********************************************
	This iterative method (for or while) produces a copy of the 
	reversed list.	 For each node going forward, make a new node and 
	link it to the list.	The list will naturally be in reverse. 
	***********************************************************/
   public static ListNode reverseIterate(ListNode head)
   {
      if(head == null)
      {
         System.out.println("[]"); 
         return null; 
      }
      ListNode wih = new ListNode(head.getValue(), null); 
      for(ListNode x = head.getNext(); x != null; x = x.getNext())
      {
         wih = new ListNode(x.getValue(), wih);
      } 
   
      return wih;
   } 
    
   /*******************************************
	This iterative method (while) uses 3 pointers to reverse 
	the list in place.   The two local pointers are called
	prev and next.
   ********************************************************/
   public static ListNode reverseInPlace(ListNode head)
   {
      if(head == null)
         return null; 
      ListNode prev = null, next = head.getNext();
      while(next != null)
      {
         head.setNext(prev); 
         prev = head; 
         head = next;
         next = head.getNext(); 
      } 
      head.setNext(prev); 
      return head;
   }
   	
	/**************************************************
	This method uses two pointers as arguments to reverse 
	the list in place. It is recursive.
	*********************************************************/
   public static ListNode reverse(ListNode prev, ListNode head)
   {
      if(head == null)
         return prev; 
      prev = new ListNode(head.getValue(), prev); 
      head = head.getNext(); 
      return reverse(prev, head); 
      
   } 
	/**********************************************
	Each time, do pointerToLast() and nextToLast(), and link (append())
	them together.  ReverseLL is recursive.
	********************************************************/
   public static ListNode reverseLL(ListNode head)
   {
      int index = getIndex(head);
      if (index==0) 
         return head;
   
      ListNode pToLast = pointerToLast(head);
      
      ListNode nToLast = nextToLast(head);
      
      nToLast.setNext(null);
      
      ListNode reverse = reverseLL(head);
      ListNode append = append(pToLast, reverse);
      
      return append;
   
   }
   
   private static ListNode pointerToLast(ListNode head)
   {
      if(head == null)
         return null; 
      ListNode p = head; 
      for(int i = 0; i < getIndex(head); i++)
      {
         p = p.getNext(); 
      }
      return p;
   }
   public static int getIndex(ListNode head)
   {
      if(head.getNext() == null)
         return 0; 
      return 1 + getIndex(head.getNext()); 
   }
   private static ListNode nextToLast(ListNode head)
   { 
      int indexNegOne = getIndex(head);
      if(indexNegOne == 0)
         head = null; 
      for(int i = 0; i < indexNegOne-1; i++)
      {
         head = head.getNext(); 
      }
      return head; 
   }
   private static ListNode append(ListNode h1, ListNode h2)
   {
      pointerToLast(h1).setNext(h2);
      return h1; 
   }
    /**********************************************
   This difficult method reverses the list in place, using one
   local pointer. Start with pointerToLast(). The helper method
   is recursive.
	********************************************************/
   public static ListNode mindBender(ListNode head)
   {
      ListNode temp = pointerToLast(head);
      mindBenderHelper(head);
      head.setNext(null);
      return temp;
   }
   public static void mindBenderHelper(ListNode head)
   {
      if(head == null)
         return; 
      if(head.getNext() == null)
         return;
      mindBenderHelper(head.getNext()); 
      head.getNext().setNext(head); 
      head.setNext(null); 
   }
  
}