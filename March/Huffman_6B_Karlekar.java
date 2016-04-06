// name:Sweta Karlekar        date:5/8/14
import java.util.*;
import java.io.*;
public class Huffman_6B_Karlekar
{
   public static void main(String[] args) throws IOException
   {
      Scanner keyboard = new Scanner(System.in); 
      System.out.print("Enter text to encode: "); 
      String str = keyboard.nextLine();
      String temp = str;
      PriorityQueue<HuffmanTreeNode> pq = new PriorityQueue<HuffmanTreeNode>();
      sortIntoPQ(temp, pq);
      Queue<String> q = new LinkedList<String>(); 
      for(HuffmanTreeNode n : pq)
         q.add(n.getString()); 
        
      buildHuffmanTree(pq); 
      HuffmanTreeNode tree = pq.remove();
      
      System.out.println("\nEnter message file name: "); 
      String outfile = keyboard.next(); 
      try
      {
         System.setOut(new PrintStream(new FileOutputStream("message."+ outfile +".txt")));
      }
      catch(Exception e)
      {
      }
      HuffmanTreeNode pointer = tree; 
      for(int i = 0; i < str.length(); i++)
      {
         getCode(tree, str.charAt(i)+"", ""); 
      }
      try
      {
         System.setOut(new PrintStream(new FileOutputStream("scheme."+ outfile +".txt")));
      }
      catch(Exception e)
      {
      }
      for(String s : q)
      {
         System.out.print(s);
         getCode(pointer, s, ""); 
         System.out.println(); 
      }
      
   }
   public static void sortIntoPQ(String str, PriorityQueue<HuffmanTreeNode> pq)
   {
      while(!str.isEmpty())
      {
         String c = str.charAt(0)+""; 
         int count = 0; 
         while(str.contains(c))
         {
            str = str.replaceFirst(c, ""); 
            count++; 
         }
         pq.add(new HuffmanTreeNode(c, count)); 
      }
   
   }
   public static void buildHuffmanTree(PriorityQueue<HuffmanTreeNode> pq)
   {
      while(pq.size() > 1)
      {
         HuffmanTreeNode one = pq.remove(); 
         HuffmanTreeNode two = pq.remove(); 
         HuffmanTreeNode temp = new HuffmanTreeNode(one, "*", one.getInt() + two.getInt(), two); 
         pq.add(temp); 
      } 
   }
   public static void getCode(HuffmanTreeNode node, String target, String code)
   {
      if(node != null)
      { 
         if(node.getString().equals(target))
            System.out.print(code);  
         if(node.hasRight())        
            getCode(node.getRight(), target, code + "1");
         if(node.hasLeft())
            getCode(node.getLeft(), target, code + "0");
      }
   }
  
}
	/*
	  * This node stores two values.  
	  * The compareTo method must ensure that the lowest frequency has the highest priority.
	  */
class HuffmanTreeNode extends TreeMap<String, Integer> implements Comparable<HuffmanTreeNode>
{
   private HuffmanTreeNode left; 
   private HuffmanTreeNode right; 
   public HuffmanTreeNode(String s, int i)
   {
      this.put(s, i); 
   }
   public HuffmanTreeNode(HuffmanTreeNode l, String s, int i, HuffmanTreeNode r)
   {
      this.put(s, i); 
      left = l; 
      right = r; 
   }
   public void setLeft(HuffmanTreeNode l)
   {
      left = l; 
   }
   public void setRight(HuffmanTreeNode r)
   {
      right = r; 
   }
   public HuffmanTreeNode getLeft()
   {
      return left; 
   }
   public HuffmanTreeNode getRight()
   {
      return right;
   }
   public int compareTo(HuffmanTreeNode t)
   {
      return getInt() - t.getInt();
   }
   public int getInt()
   {
      return this.get(this.firstKey()); 
   }
   public String getString()
   {
      return this.firstKey(); 
   }
   public String toString()
   {
      return getString() + " : " + getInt(); 
   }
   public boolean hasLeft()
   {
      return (left!=null); 
   }
   public boolean hasRight()
   {
      return (right!=null); 
   }
   
      
}
         //Read the string
         //Make a frequency table of the letters
      	//Put each letter-frequency pair into a HuffmanTreeNode. Put each node into a priority queue (or a min-heap).     }
      	//Use the priority queue of nodes to build the Huffman tree
      	//Process the string letter-by-letter and search the tree for the letter.  As you go, build the binary path, where going left is 0 and going right is 1.  
      	//Write the binary path to the hard drive as message.xxx.txt
      	//Write the scheme to the hard drive as scheme.xxx.txt
