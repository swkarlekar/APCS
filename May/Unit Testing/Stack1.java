//author: Ashley Kim      5/9/13
   import java.util.Arrays;
   public class Stack1<E> {
      private Object[] a;
      private int size = 0;
   
      public Stack1() {
         a = (E[])(new Object[10]); //java doesn't support generic array allocation
      }
   
      public void push(E obj) {
         if(size == a.length-1)
            a = Arrays.copyOf(a,size*2);
         if(size==0)
            a[0]=obj;//made this 0 instead of 1
         else{
            for(int i=size-1;i>=0;i--) //switched position of for loop and a[0] = obj; 
               a[i+1]=a[i];    
            a[0] = obj;
              
         }
         size++;//moved this to the bottom

      }
   
      public E peek() {
         if(size==0)
            throw new IndexOutOfBoundsException("Nothing in Stack");	
         return (E)a[0];	  
      }
   
      public E pop() {
         if(size==0)
            throw new IndexOutOfBoundsException("Nothing to pop");      
         size--;
         E temp = (E)a[0];//moved this up here

         for(int x=0;x<=size;x++){
            a[x]=a[x+1];
         }
         return temp;
      }
   
      public boolean isEmpty() {
         return size==0;     
      }
   
      public int size() {
         return size;
      }
   }
		
