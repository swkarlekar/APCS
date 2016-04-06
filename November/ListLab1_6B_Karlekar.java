  //Name: Sweta Karlekar  Date: 11/4/13
import java.util.Scanner;
public class ListLab1_6B_Karlekar
{
   public static void main(String[] args)
   {
      ListNode head = new ListNode("hello", null);
      //ListNode p = ListNode.pointerToLast(head);
      //System.out.println("Pointer to Last = " + p.getValue()+ " at " + p);

         
         head = new ListNode("foo", head);
         head = new ListNode("boo", head);
         head = new ListNode("nonsense", head);
         head = new ListNode("computer",
            	new ListNode("science",
            		new ListNode("java",
            			new ListNode("coffee", head)
            		)
            	)
            );
         print(head);
         print(head);
         
         /**** uncomment the code below for ListLab1 methods ****/
      	/****  You need to write all of the methods on the lab sheet ****/
        
      	System.out.println("First = " + ListNode.first(head));
         System.out.println("Second = " + ListNode.second(head));
         ListNode p = ListNode.pointerToLast(head);
         System.out.println("Pointer to Last = " + p.getValue()+ " at " + p);
         ListNode c = ListNode.copyOfLast(head);
         System.out.println("Copy of Last    = " + c.getValue()+ " at " + c);
      	 	
         Scanner in = new Scanner(System.in);
         System.out.print("Insert what? ");
         String x = in.next();
         head = ListNode.insertFirst(head, x);
         head = ListNode.insertLast(head, x);
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
         	
}
class ListNode
{
   private Object value; 
   private ListNode next; 
   public ListNode(Object initValue, ListNode initNext)
   {
      value = initValue; 
      next = initNext; 
   }
   public ListNode()
   {
      value = null; 
      next = null; 
   }
   public ListNode getNext()
   {
      return next; 
   }
   public Object getValue() 
   {
      return value; 
   }
   public void setNext(ListNode theNewNext)
   {
      next = theNewNext; 
   }
   public void setValue(Object theNewValue)
   {
      value = theNewValue; 
   }
   public static boolean isEmpty(ListNode head)
   {
      ListNode p; 
      boolean isEmpty = true; 
      for(p = head; p != null; p = p.next)
      {
         if(!p.value.equals(""))
            isEmpty = false; 
      }
      return isEmpty; 
   }
   private static ListNode copyNode(ListNode arg)
   {
      if(arg == null)
         return null;
      return new ListNode(arg.getValue(), arg.getNext()); 
   }
   private static ListNode copyList(ListNode arg)
   {
      if(arg == null)
         return null; 
      return new ListNode(arg.getValue(), copyList(arg.getNext())); 
   }
   public static ListNode rest(ListNode h)
   {
      return copyList(h.getNext()); 
   }
   public static Object first(ListNode head)
   {
      if(isEmpty(head))
         return null; 
      return head.getValue(); 
   }
   public static Object second(ListNode head)
   {
      ListNode withoutFirst = rest(head); 
      if(isEmpty(withoutFirst))
         return null; 
      return withoutFirst.getValue(); 
   }
   public static int getIndex(ListNode head)
   {
      if(head.getNext() == null)
         return 0; 
      return 1 + getIndex(head.getNext()); 
   }
         /*public static ListNode pointerToLast(ListNode head)
         {
            if(isEmpty(head))
               return null; 
            ListNode p = head; 
            for(int i = 0; i < getIndex(head)-1; i++)
            {
               p = p.getNext(); 
            }
            return p.getNext(); 
         	
         }*/
   public static ListNode pointerToLast(ListNode head)
   {
      if(isEmpty(head))
         return null; 
      ListNode p = head; 
      for(int i = 0; i < getIndex(head); i++)
      {
         p = p.getNext(); 
      }
      return p; 
         	
   }

   public static ListNode copyOfLast(ListNode head)
   {
      ListNode p = copyList(head); 
      for(int i = 0; i < getIndex(head); i++)
         p = p.getNext(); 
      return copyNode(p); 
   }
   public static ListNode insertFirst(ListNode head, Object arg)
   {
      ListNode pointer = new ListNode(arg, head); 
      return pointer; 
   }
   public static ListNode insertLast(ListNode head, Object arg)
   {
      pointerToLast(head).setNext(new ListNode(arg, null)); 
      return head; 
         	
   }
   public String toString()
   {
      String out = "";
      //System.o("[");
      ListNode head = this; 
      while(head != null)
      {
         out = out + (head.getValue());
         head = head.getNext();
         if(head != null)
            out = out + (", ");
      }
      return out; 
      //System.out.println("]");
   }

      
      	
      	
}

