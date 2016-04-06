// name: Sweta Karlekar   date: 11/15/13
    public class DLL_6B_Karlekar
   {
       public static void main(String args[])
      {
         DLL list = new DLL();	
         
         list.addLast("Apple");
         list.addLast("Banana");
         list.addLast("Cucumber");
         list.add("Dumpling");
         list.add("Escargot");
         System.out.println(list);
         System.out.println("Size: " + list.size());
         Object obj = list.remove(3);
         System.out.println(list);
         System.out.println("Size: " +list.size());
         System.out.println("Removed "+ obj);
         System.out.print("Add at 3:   ");
         list.add(3,"Cheese");
         System.out.println(list);
         System.out.println("Get values at 1 and first: " + list.get(1)+" and " + list.getFirst());
         System.out.println("No change: " +list);
         System.out.println( list.removeFirst() + " is now removed!"); 
         System.out.println(list);
         System.out.print("Add first:  ");
         list.addFirst("Anchovie");
         System.out.println(list);
         System.out.println("Size: " + list.size());
      }
   }

//////////////////////////////////////////////////////////
    
    class DLL        //DoubleLinkedList
   {
      private int size;
      private DLNode head = new DLNode(); //dummy node--very useful--simplifies the code
   
       public int size()
      {
         return size; 
      }
    	      /* inserts obj at position index.  increments size. 
   		*/
       public void add(int index, Object obj)
      {
         DLNode temp = head; 
         for(int i = 1; i < index-1; i++)
         {
            temp = temp.getNext(); 
         }
         DLNode insertion = new DLNode(obj, temp, temp.getNext()); 
         temp.setNext(insertion); 
         temp.getNext().getNext().setPrev(insertion); 
         size++; 
      }
      /* appends obj to end of list; increases size;
   	  @return true  */
       public boolean add(Object obj)
      {
         addLast(obj); 
         return true; 
      }

      /* return obj at position index.  
   		*/
       public Object get(int index)
      {
         DLNode temp = head; 
         for(int i = 0; i < index-1; i++)
         {
            temp = temp.getNext(); 
         }
         return temp.getValue(); 
      }
    /* replaces obj at position index.  
   		*/
       public void set(int index, Object obj)
      {
         DLNode temp = head; 
         for(int i = 0; i < index-1; i++)
         {
            temp = temp.getNext(); 
         }
         temp.setValue(obj); 
      }
    /*  removes the node from position index.  decrements size.
   	  @return the object at position index.
   	 */
       public Object remove(int index)
      {
         DLNode pointer = head; 
         for(int i = 0; i < index-1; i++)
         {
            pointer = pointer.getNext(); 
         } 
         pointer.getPrev().setNext(pointer.getNext()); 
         pointer.getNext().setPrev(pointer.getPrev()); 
         size--; 
         return pointer.getValue();
      }
    /* inserts obj at front of list; increases size;
   	  */
       public void addFirst(Object obj)
      {
         DLNode temp = new DLNode(obj, head.getPrev(), head); 
         head.getPrev().setNext(temp); 
         head.setPrev(temp); 
         size++; 
         head = temp; 
      }
   	/* appends obj to end of list; increases size;
   	    */
       public void addLast(Object obj)
      {
         size++; 
         if(head.getValue() == null)
            head.setValue(obj); 
         else
         {
            DLNode temp = new DLNode(obj, head.getPrev(), head); 
            head.getPrev().setNext(temp); 
            head.setPrev(temp); 
         }
      }
       public Object getFirst()
      { 
         return head.getValue(); 
      }
       public Object getLast()
      {
         return head.getPrev().getValue();  
      }
       public Object removeFirst()
      {
         size--; 
         head.getPrev().setNext(head.getNext()); 
         head.getNext().setPrev(head.getPrev());
         DLNode holder = head; 
         head = head.getNext();      
         return holder.getValue();  
      }
       public Object removeLast()
      {
         size--; 
         head.getPrev().setValue(null); 
         head.getPrev().getPrev().setNext(head);
         head.setPrev(head.getPrev().getPrev()); 
         return head; 
      }
       public String toString()
      {
         String printout = "[" + head.getValue() + ", ";
         for(DLNode x = head.getNext(); x.getValue() != head.getValue(); x = x.getNext())
         {
            printout = printout + x.getValue() + ", ";
         }
         printout = printout.substring(0, printout.length()-2) + "]"; 
         return printout; 
      }
   }
	
	///////////////////////////////////////

	  
    class DLNode 
   {
      private Object value;
      private DLNode prev;
      private DLNode next;
       public DLNode(Object arg, DLNode p, DLNode n)
      {
         value=arg;
         prev=p;
         next=n;
      }
       public DLNode()
      {
         value=null;
         next=this;
         prev=this;
      }
       public void setValue(Object arg)
      {
         value=arg;
      }
       public void setNext(DLNode arg)
      {
         next=arg;
      }
       public void setPrev(DLNode arg)
      {
         prev=arg;
      }
       public DLNode getNext()
      {
         return next;
      }
       public DLNode getPrev()
      {
         return prev;
      }
       public Object getValue()
      {
         return value;
      }
   }
