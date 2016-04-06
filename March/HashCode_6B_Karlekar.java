//name:  Sweta Karlekar          date:  3/14/14
 /*  Assignment:  A simple hashing program is given below. Compile 
 and run.  Notice that collisions occur.  You are to implement 
 three different collision schemes, namely, linear probing, 
 rehashing, and chaining.
 */
import java.util.*;
public class HashCode_6B_Karlekar
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);  
      System.out.print("Enter the size of the array:  ");
      int arrayLength = keyboard.nextInt();       //20
      Hashtable table = new Hashtable(arrayLength);
      
      System.out.print("\nEnter the number of items:  ");
      int numItems = keyboard.nextInt();          //15
      System.out.print("\nThe Load Factor is " + (double)numItems/arrayLength);
      System.out.println();
      for(int i = 0; i < numItems; i++)
         table.add("Item "+i);
      System.out.println();
      System.out.print("Search for:  Item ");
      int i = keyboard.nextInt();
      String key = "Item " + i; 
      if(!table.contains(key))
         System.out.println(key + " NOT found");
   }
}
   
class Hashtable
{
   private int size;
   private Object[] table;
   public Hashtable(int numSlots)
   {
      size = numSlots;
      table = new Object[size];
   }
   public void add(Object obj)
   {
      int code = obj.hashCode();
      int index = Math.abs(code % size);
      if(table[index] == null)
      {
         table[index] = obj;
         System.out.println(obj + "\t" + code + "\t" + index);
      }
      else
      {
         System.out.println(obj + "\t" + code + "\tCollision at "+ index);
         //index = linearProbe(index);
         index = rehash(index);
         //obj = chaining(index, obj);
         table[index] = obj;
         System.out.println(obj + "\t" + code + "\t" + index);
      }
   }
   public boolean contains(Object obj)     //Big-O is O(____)
   {
      int index = Math.abs(obj.hashCode() % size);
     
      //LINEAR PROBE SEARCH
      /*boolean isthere = false; 
      int probe; 
      if(index == table.length - 1)
         probe = 0; 
      else
         probe = index + 1; 
         
      while((probe != index) && isthere == false)
      {
         if(table[probe].equals(obj))
         {
            isthere = true;
            index = probe;  
         }
         else
         {
            if(probe == table.length - 1) 
               probe = 0;
            else
               probe++; 
         }
      }
      Object found = table[index];
      if(found.equals(obj))
      {
         System.out.println(obj + " at index " + index);
         return true;
      }
      else 
         return false;
   */
   
      //REHASH SEARCH 
      int counter = index; 
      boolean isthere2 = table[counter].equals(obj); 
      while(!isthere2)
      {
         if(table[counter] != null && table[counter].equals(obj))
         {
            isthere2 = true; 
            index = counter; 
            break;
         }
         else
            counter = (counter+3) % table.length; 
      }
      Object found = table[index];
      if(found.equals(obj))
      {
         System.out.println(obj + " at index " + index);
         return true;
      }
      else 
         return false;
   
      
      //CHAINING SEARCH
      
      /*boolean isthere3 = false; 
      if(table[index] instanceof ListNode) 
      {
         ListNode temp = (ListNode)table[index];
         while(temp != null && !isthere3)
         {
            if(temp.getValue().equals(obj))
               isthere3 = true; 
            else
               temp = temp.getNext(); 
         }
      }
      if(!isthere3)
      {
         while(!table[index].equals(obj))
            index++; 
      }
      if(table[index] instanceof ListNode)
      {
         ListNode ln = (ListNode)table[index]; 
         while(ln != null)
         {
            if(ln.getValue().equals(obj))
            {
               System.out.println(obj + " at index " + index);
               return true;
            }
            else
               ln = ln.getNext(); 
         }
               
      }
      return false;*/

      
   }
   public int linearProbe(int index)
   {
      int probe; 
      if(index == table.length - 1)
         probe = 0; 
      else
         probe = index + 1; 
         
      while((probe != index))
      {
         if(table[probe] == null)
            return probe;  
         else
         {
            if(probe == table.length - 1) 
               probe = 0;
            else
               probe++; 
         }
      }
      return probe; 
   }
   public int rehash(int index)
   {
      while(table[index] != null)
      {
         index = Math.abs((index + 3) % 10); 
      }
      return index; 
   }
   public Object chaining(int index, Object obj)
   {
      ListNode head;
      if(table[index] instanceof ListNode) {
         head = (ListNode) table[index];
      } 
      else {
         head = new ListNode(table[index], null);
      } 
      ListNode pointer = head; 
      while(pointer.getNext() != null)
         pointer = pointer.getNext(); 
      pointer.setNext(new ListNode(obj, null)); 
      return head; 
   }
   
   
}
 
