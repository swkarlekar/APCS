//name: Sweta Karlekar   date: 2/28/14
public class TreePriorityQueue_6B_Karlekar
{
   public static void main(String[] args)
   {
      TreePriorityQueue tpq = new TreePriorityQueue();
      //int[] array = {13, 11, 14, 11, 15, 14, 14};//DONE
    	//int[] array = {4, 6, 5, 7}; //DONE
   //  int[] array = {7, 6, 4, 5}; //DONE
      int[] array = {7, 6, 4, 5, 4, 4}; //DONE
   //  int[] array = {4, 5, 4, 4, 7, 6, 7, 7};//DONE
     
      for( int x : array )
         tpq.add(x);
      tpq.display();       
      System.out.println("Peek min: " + tpq.peekMin());
      System.out.println("Removing");
      while( !tpq.isEmpty() )
         System.out.println( "     " + tpq.removeMin() );
   }
}

class TreePriorityQueue
{
   private TreeNode root;

   public TreePriorityQueue()
   {   root = null;  }

	//postcondition:  returns true if the priority queue is empty;
	//					  otherwise, returns false
   public boolean isEmpty()
   {  
      return root == null;
   }

	//postcondition:  obj has been added to the priority queue
   public void add(Object obj)
   {	
      root = addHelper((Comparable) obj, root);  
   }

	//postcondition:  obj has been added to the subtree rooted at t;
	//					  the updated subtree is returned
   private TreeNode addHelper(Comparable obj, TreeNode t)
   {
      if(t==null)
         return new TreeNode(new Item(obj)); 
      TreeNode pointer = t; 
      TreeNode parent = t; 
      int compare = obj.compareTo(((Item)pointer.getValue()).getData()); 
      while(compare!=0)
      {
         if(compare < 0)
         {
            parent = pointer; 
            pointer = pointer.getLeft(); 
         }
         else if(compare > 0)
         {
            parent = pointer;
            pointer = pointer.getRight();  
         }
         else 
            break; 
         if(pointer == null)
            break; 
         compare = obj.compareTo(((Item)pointer.getValue()).getData());
      }
      if(pointer != null)  
         ((Item)pointer.getValue()).incrementCount(); 
      else  
      {
         if(obj.compareTo(((Item)parent.getValue()).getData()) < 0)
            parent.setLeft(new TreeNode(new Item(obj))); 
         else
            parent.setRight(new TreeNode(new Item(obj))); 
      }
      return t; 
   }
			
					
	//precondition:  the priority queue is not empty
	//postcondition:  a data value of smallest priority has been 
	//						removed and returned
   public Object removeMin()
   { 
      TreeNode temp = root; 
      TreeNode parent = root; 
      int compare = (((Item)temp.getValue()).getData()).compareTo(this.peekMin());
      while(compare != 0)
      {
         parent = temp; 
         if(compare > 0)
            temp = temp.getLeft(); 
         else if(compare < 0)
            temp = temp.getRight(); 
         else 
            break;  
         compare = (((Item)temp.getValue()).getData()).compareTo(this.peekMin());
      
      }
      int iteration = ((Item)temp.getValue()).getCount(); 
      Comparable mydata = ((Item)temp.getValue()).getData();
      Item tempItem = new Item(mydata); 
      for(int i = 1; i < iteration; i++)
      {
         tempItem.incrementCount(); 
      }
      if(temp == parent && (temp.getRight() != null || temp.getLeft() != null))
      {
         if(((Item)temp.getValue()).getCount() > 1)
            ((Item)temp.getValue()).decrementCount();
         else 
         {
            temp = temp.getRight(); 
            parent.setRight(null); 
            root = temp; 
            return parent.getValue();
         }
         return tempItem; 
         
      }
      else if(temp == parent)
      {
        if(((Item)temp.getValue()).getCount() > 1)
            ((Item)temp.getValue()).decrementCount();
        else
            root = null; 
        return tempItem;
         
      }
      if(temp.getLeft() == null && temp.getRight() == null) 
      {  
         if(((Item)temp.getValue()).getCount() > 1)
            ((Item)temp.getValue()).decrementCount(); 
         else
            parent.setLeft(null);  
         return tempItem;      
      } 
      if(((Item)temp.getValue()).getCount() > 1)
         ((Item)temp.getValue()).decrementCount(); 
      else
         parent.setLeft(temp.getRight());
      return tempItem;       
       
   }

	//precondition:   the priority queue is not empty
	//postcondition: a data value of smallest priority if returned; 
	//					 the priority queue is unchanged
   public Object peekMin()
   {	
      TreeNode temp = root; 
      while(temp.getLeft() != null)  
         temp = temp.getLeft(); 
      return ((Item)temp.getValue()).getData(); 
   }
	
   public void display()
   {
      display(root, 0);
   }
	
   private void display(TreeNode t, int level)
   {
      if(t == null)
         return;
      display(t.getRight(), level + 1); //recurse right
      for(int k = 0; k < level; k++)
         System.out.print("\t");
      System.out.println(t.getValue());
      display(t.getLeft(), level + 1); //recurse left
   
   
   }
}
  
class Item
{
   private Comparable data;
   private int count;
   public Item(Comparable d)
   {  
      data = d; 
      count = 1;  
   }
   public void incrementCount()
   {	
      count++; 
   }
//precondition:  the count of this item is greater than 0;
   public void decrementCount()
   {  
      count--;  
   }
   public int getCount()
   {	
      return count;  
   }
   public Comparable getData()
   {  
      return data;  
   }
   public String toString()
   {
      return data + " " + count; 
   }
}


 
