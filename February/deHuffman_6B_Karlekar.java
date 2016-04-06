// Name: Sweta Karlekar           Date: 3/5/14
   import java.util.Scanner;
   import java.io.*;
    public class deHuffman_6B_Karlekar
   {
       public static void main(String[] args) throws IOException
      {
         System.out.print("Please enter the binary message text file: "); 
         Scanner keyboard = new Scanner(System.in); 
         String input = keyboard.next(); 
         Scanner bmessage = new Scanner(new File(input + ".txt"));
         System.out.print("Please enter the Huffman coding scheme text file: ");
         input = keyboard.next(); 
         Scanner cscheme = new Scanner(new File(input + " .txt")); 

      }
       public static TreeNode huffmanTree(Scanner huffLines)
      {
         
      }
       public static String dehuff(String text, TreeNode root)
      {
         
      }
   }
