// Name: Sweta Karlekar           Date: 3/5/14
   import java.util.Scanner;
   import java.io.*;
    public class deHuffman_6B_Karlekar
   {
       public static void main(String[] args) throws IOException
      {
         System.out.print("Please enter the text file: "); 
         Scanner keyboard = new Scanner(System.in); 
         String input = keyboard.next(); 
         Scanner bmessage = new Scanner(new File("message." + input + ".txt"));
         Scanner cscheme = new Scanner(new File("scheme." + input + ".txt")); 
         System.out.print(dehuff(bmessage.next(), huffmanTree(cscheme))); 

      }
       public static TreeNode huffmanTree(Scanner huffLines)
      {
         TreeNode tree = new TreeNode(null, null, null); 
         while(huffLines.hasNext())
         {
            String thisline = huffLines.nextLine(); 
            String letter = thisline.substring(0, 1); 
            String code = thisline.substring(1);
            TreeNode pointer = tree;  
            while(!code.isEmpty())
            {
               if(code.substring(0,1).equals("0"))
               {
                  if(pointer.getLeft() == null)
                     pointer.setLeft(new TreeNode(null, null, null)); 
                  pointer = pointer.getLeft();
                  code = code.substring(1); 
               }
               else
               {
                  if(pointer.getRight() == null)
                     pointer.setRight(new TreeNode(null, null, null));
                  pointer = pointer.getRight(); 
                  code = code.substring(1); 
               }
            }
            pointer.setValue(letter);  
         }
         return tree; 
      }
       public static String dehuff(String text, TreeNode root)
      {
         TreeNode pointer = root; 
         String decoded = ""; 
         while(!text.isEmpty())
         {
            if(text.substring(0,1).equals("0"))
            { 
               pointer = pointer.getLeft(); 
               text = text.substring(1); 
            }
            else
            {
               pointer = pointer.getRight(); 
               text = text.substring(1); 
            }
            if(pointer.getLeft() == null && pointer.getRight() == null)
            {
               decoded += pointer.getValue(); 
               pointer = root; 
            }
               
         }
         return decoded; 
      }
   }
