 //name: Sweta Karlekar   date: 2/25/14
import java.util.*;
import java.io.*;
public class BSTobject_6B_Karlekar
{
   
   public static void main( String[] args ) throws Exception
   {
      /////////////String////////////
      BSTobject<String> treeString = new BSTobject<String>();
      Scanner keyboard = new Scanner(System.in); 
      System.out.print("Enter input string: "); 
      String input = keyboard.next(); 
      System.out.println(); 
      for(int i = 0; i < input.length(); i++)
         treeString.add(input.charAt(i) + "");  
      System.out.println(treeString); 
      System.out.println(treeString.size());
      System.out.println(treeString.isEmpty());
      //////////////Widgets/////////////
      BSTobject<Widget> treeWidget = new BSTobject<Widget>();
      System.out.print("Enter number of widgets: "); 
      int numW = Integer.parseInt(keyboard.next()); 
      System.out.println(); 
      for(int i = 0; i < numW; i++)
         treeWidget.add(new Widget((int)(Math.random()*100+1), (int)(Math.random()*15+1)));  
      System.out.println(treeWidget); 
      System.out.println(treeWidget.size());
      System.out.println(treeWidget.isEmpty());
      
      System.out.print("Enter #lbs.: "); 
      int lbs = Integer.parseInt(keyboard.next()); 
      System.out.print("Enter #oz.: "); 
      int oz = Integer.parseInt(keyboard.next()); 
      treeWidget.remove(new Widget(lbs, oz)); 
      System.out.print(treeWidget); 

       
   }
}
   	////////////////////////////////
class BSTobject <E extends Comparable<E>> implements BSTinterface<E>
{
      // 2 fields 
   private Node<E> root; 
   private int size;
   private static String output;  
      // 2 constructors, one default and one one-arg
   public BSTobject()
   {
      root = null; 
      size = 0; 
   }
   public BSTobject(E v)
   {
      root = new Node(null, v, null); 
      size = 1; 
   }
   public int size()
   {
      return size; 
   }
   public Node<E> getNode()
   {
      return root; 
   }
   public boolean isEmpty()
   {
      return (size == 0); 
   }
   public String toString()
   { 
      output = ""; 
      display(root, 0, output); 
      return output; 
   }
   public void display(Node<E> t, int level, String str)
   {
      if(t != null)
      {
         display(t.getRight(), level + 1, str); //recurse right
         for(int k = 0; k < level; k++)
            output = output + "\t";
         output = output + t.getValue() + "\n"; 
         display(t.getLeft(), level + 1, str);
      }
     
   }
   public E remove(E current)
   {
      Node<E> temp = root; 
      Node<E> parent = root; 
      int compare = ((E)current).compareTo(temp.getValue());
      while(compare != 0)
      {
         parent = temp; 
         if(compare < 0)
            temp = temp.getLeft(); 
         else if(compare > 0)
            temp = temp.getRight(); 
         else 
            break; 
         if(temp == null)
            return current; 
         compare = ((E)current).compareTo(temp.getValue()); 
      }
      if(temp.getLeft() == null && temp.getRight() == null) 
      {  
         size--; 
         return case1(temp, parent);
      }
         
      else if((temp.getLeft() == null && temp.getRight() != null)|| (temp.getRight() == null && temp.getLeft() != null))
      {
         size--; 
         return case2(temp, parent);
      }
      size--;  
      return case3(temp, parent); 
   }
   public boolean contains(E element)
   {
      return true; 
   }
   public E add(E element)
   { 
      size++;
      if(root == null)
      {
         root = new Node<E>(null, element, null); 
         return element; 
      }
      Node<E> p = null; 
      Node<E> q = root; 
      while(q != null)
      {
         p = q; 
         if(element.compareTo((E)p.getValue()) < 0)
            q = p.getLeft(); 
         else
            q = p.getRight();     
      } 
      if(element.compareTo((E)p.getValue()) < 0)
         p.setLeft(new Node<E>(null, element, null)); 
      else
         p.setRight(new Node<E>(null, element, null)); 
      return (E)root.getValue(); 
      
   }
   public E case1(Node<E> temp, Node<E> parent)
   {
      if(temp.getLeft() == null && temp.getRight() == null) 
      {
         if(parent.getLeft() == temp)
            parent.setLeft(null); 
         else
            parent.setRight(null); 
      }
      return temp.getValue(); 
   }
   public E case2(Node<E> temp, Node<E> parent)
   {
      if(temp.getLeft() == null && temp.getRight() != null)
      {
         if(parent.getLeft() == temp)
            parent.setLeft(temp.getRight());
         else
            parent.setRight(temp.getRight()); 
      } 
      if(temp.getRight() == null && temp.getLeft() != null)
      {
         if(parent.getRight() == temp)
            parent.setRight(temp.getLeft()); 
         else
            parent.setLeft(temp.getLeft()); 
      }
      return temp.getValue();
   
   }
   public E case3(Node<E> temp, Node<E> parent)
   {
      Node<E> replaceParent = findBiggest(temp); 
      if(temp.getLeft().getRight() == null)
      {
         temp.setValue(replaceParent.getLeft().getValue());
         if(replaceParent.getLeft().getLeft() == null && replaceParent.getLeft().getRight() == null) 
            return case1(replaceParent.getLeft(), replaceParent); 
         else
            return case2(replaceParent.getLeft(), replaceParent); 
      }
      temp.setValue(replaceParent.getRight().getValue());
      if(replaceParent.getRight().getLeft() == null && replaceParent.getRight().getRight() == null) 
         return case1(replaceParent.getRight(), replaceParent);
      return case2(replaceParent.getRight(), replaceParent); 
         
   
   }
   public Node<E> findBiggest(Node<E> current)
   {
      if(current.getLeft().getRight() == null)
         return current; 
      Node<E> temp = current; 
      temp = temp.getLeft(); 
      while(temp.getRight() != null && temp.getRight().getRight() != null)
      {
         temp = temp.getRight(); 
      }
      return temp; 
   }
}

   
      //methods
      
      
      
      /***************************private inner class **************/  
class Node<E>
{
         // 2 fields 
   private Node<E> left, right; 
   private E myValue; 
         // 2 constructors, one default and one one-arg
   public Node(Node<E> left, E v, Node<E> right)
   {
      this.left = left; 
      myValue = v; 
      this.right = right; 
   }
   public E getValue()
   { 
      return myValue; 
   }
   public Node<E> getLeft()
   {
      return this.left; 
   }
   public Node<E> getRight()
   {
      return this.right; 
   }
   public void setValue(E nv)
   {
      this.myValue = nv;
   }
   public void setLeft(Node<E> nL)
   {
      this.left = nL; 
   }
   public void setRight(Node<E> nR)
   {
      this.right = nR; 
   }  
         
         
}

	//////////////////////////////////
interface BSTinterface<E extends Comparable<E>>
{
   public E add( E element );     //returns the object
   public boolean contains( E element );
   public boolean isEmpty();
   public E remove( E element );  //returns the object
   public int size();
   public String toString();
}
//////////////////////////////////
class Widget implements Comparable<Widget>
   {
   	private int myPounds; 
		private int myOunces;
		public Widget(int pounds, int ounces)
		{
			myPounds = pounds; 
			myOunces = ounces; 
		} 
		public int getPounds()
		{
			return myPounds; 
		}
		public int getOunces()
		{
			return myOunces; 
		}
		public void setPounds(int lbs)
		{
			myPounds = lbs; 
		}
		public void setOunces(int oz)
		{
			myOunces = oz; 
		}
		public int compareTo(Widget w)
		{
			if(myPounds < w.myPounds)
				return -1; 
			if(myPounds > w.myPounds)
				return 1; 
			if(myOunces < w.myOunces)
				return -1; 
			if(myOunces > w.myOunces)
				return 1; 
			return 0; 
		}
		public boolean equals(Widget w)
		{
			if(this.compareTo(w) == 0)
				return true; 
			return false; 
		}
		public String toString()
		{
			return myPounds + " lbs., " + myOunces + " oz."; 
		}
   }