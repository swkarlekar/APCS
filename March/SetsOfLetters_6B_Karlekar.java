// Name: Sweta Karlekar   Date: 3/20/14
   import java.util.*;
   import java.io.*;
    public class SetsOfLetters_6B_Karlekar
   {
       public static void main(String[] args) throws FileNotFoundException
      {
         Scanner infile = new Scanner(new File("declarationLast.txt")); 
         String upperevery = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
         String lowerevery = "abcdefghijklmnopqrstuvwxyz"; 
         String otherevery = "!@#$%^&*()_+|}{:?><,.>;][=-0987654321"; 
         while(infile.hasNextLine())
         {
            String thisline = infile.nextLine(); 
            TreeSet<String> upper = new TreeSet<String>(); 
            TreeSet<String> lower = new TreeSet<String>(); 
            TreeSet<String> other = new TreeSet<String>(); 
            for(int i = 0; i <thisline.length(); i++)
            {
               String focus = thisline.charAt(i) + ""; 
               if(isUpperCase(focus))
                  upper.add(focus); 
               else if(isLowerCase(focus))
                  lower.add(focus); 
               else if(!focus.equals(" "))
                  other.add(focus); 
            }
            for(int i = 0; i < upperevery.length(); i++)
            {
               String upperfocus = upperevery.charAt(i)+""; 
               if(!upper.contains(upperfocus))
                  upperevery = upperevery.replace(upperfocus, ""); 
            }
            for(int i = 0; i < lowerevery.length(); i++)
            {
               if(!lower.contains(lowerevery.charAt(i) + ""))
                  lowerevery = lowerevery.replace(lowerevery.charAt(i) + "", ""); 
            }
            for(int i = 0; i < otherevery.length(); i++)
            {
               if(!other.contains(otherevery.charAt(i) + ""))
                  otherevery = otherevery.replace(otherevery.charAt(i) + "", ""); 
            }
            System.out.println(thisline); 
            System.out.print("Lower case: "); 
            display(lower); 
            System.out.print("\nUpper case: "); 
            display(upper); 
            System.out.print("\nOther: "); 
            display(other);
            System.out.println("\n");  
         }
         lowerevery = lowerevery.replace("", " ").trim(); 
         upperevery = upperevery.replace("", " ").trim();
         otherevery = otherevery.replace("", " ").trim();
         System.out.print("Characters in every line: \t"); 
         System.out.print("Lower case: " + lowerevery + "\n"); 
         System.out.println("\t\t\t\tUpper case: " + upperevery);
         System.out.println("\t\t\t\tOther: " + otherevery); 
      }
      public static boolean isUpperCase(String c)
      {
         String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
         if(uppercase.contains(c))
            return true; 
         return false; 
      }
      public static boolean isLowerCase(String c)
      {
         String lowercase = "abcdefghijklmnopqrstuvwxyz"; 
         if(lowercase.contains(c))
            return true; 
         return false; 
      }
      public static void display(TreeSet<String> ts)
      {
         for(String s : ts)
            System.out.print(s + " "); 
      }
   }