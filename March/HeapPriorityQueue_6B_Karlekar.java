 //Name: Sweta Karlekar  Date: 4/4/14
import java.util.*;
public class HeapPriorityQueue_6B_Karlekar<E extends Comparable<E>> 
{
   private ArrayList<E> myHeap;
   public HeapPriorityQueue_6B_Karlekar()
   {
      myHeap = new ArrayList<E>(); 
   }
   public HeapPriorityQueue_6B_Karlekar(E e)
   {
      myHeap = new ArrayList<E>(); 
      myHeap.add(e); 
   }
   public boolean add(E e)
   {
      if(myHeap.size() == 0)
       myHeap.add(0, null); 
       
      
        myHeap.add(e);
        int k = myHeap.size()-1;
        while (k > 1 && ((Comparable) myHeap.get(k/2)).compareTo(e) < 0) {
            myHeap.set(k,myHeap.get(k/2));
            k = k/2;
        }
        myHeap.set(k,e);
        return true; 
   }
   public E remove() 
   {
      E e = myHeap.get(myHeap.size()-1); 
      myHeap.remove(myHeap.size()-1);
      return e; 
   }
   public ArrayList<E> getHeap()
   {
      return myHeap; 
   }
   public E peek()
   {
      return myHeap.get(myHeap.size()-1); 
   }
   public int size()
   {
      return myHeap.size(); 
   }
   public void heapUp(int size)
   {
      E e = this.remove();
      if(myHeap.size() == 1)
         return;
      myHeap.set(1, e);  
      for(int s = myHeap.size()-1; s > 2; s--)
      {
         heapDown(1, s);
         swap(1, s);            
      }
   }
   public void heapDown(int k, int size)
   {
      int left = 2*k; 
      int right = 2*k+1; 
      if(k > size-1 || left > size-1 || right > size-1)
         return; 
      else
      {
         int maxChild = ((myHeap.get(left).compareTo(myHeap.get(right))) > 0) ? left : right; 
         if(myHeap.get(k).compareTo(myHeap.get(maxChild)) < 0)
         {
            swap(k, maxChild); 
            heapDown(maxChild, size); 
         }
      }
   
   }
   public void swap(int a, int b)
   {
      E d = myHeap.get(a); 
      myHeap.set(a, myHeap.get(b)); 
      myHeap.set(b, d); 
   }
   public boolean isEmpty()
   {
      return(myHeap.size() == 0); 
   }
   public String toString()
   {
      String s = "["; 
      for(E e : myHeap)
         if(e!= null)
            s += e + ", ";
      return s + "]";  
   }
      
  
}
