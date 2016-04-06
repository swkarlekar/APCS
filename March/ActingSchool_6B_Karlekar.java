 //name: Sweta Karlekar   date: 3/14/14   
import java.util.*;
public class ActingSchool_6B_Karlekar
{
   public static void main(String[] args)
   {
      TreeMap<String, String> sGrades = new TreeMap<String, String>();     //TreeMap
   
      sGrades.put("Jack Nicholson", "A-");
      sGrades.put("Humphrey Bogart", "A+");
      sGrades.put("Audrey Hepburn", "A");
      sGrades.put("Meryl Streep", "A-");
      sGrades.put("Jimmy Stewart", "A");
   
   	//display initial data
      Iterator<String> it = sGrades.keySet().iterator(); 
      while(it.hasNext())
      {
         String k = it.next(); 
         System.out.println(k + " (" + sGrades.get(k) + ")");
      } 
   	//reverse the map    //TreeMap
      TreeMap<String, ArrayList<String>> rmap = new TreeMap<String, ArrayList<String>>(); 
      Iterator<String> it2 = sGrades.keySet().iterator(); 
      while(it2.hasNext())
      {
         String key = it2.next(); 
         if(!rmap.containsKey(sGrades.get(key)))
         {
            ArrayList<String> temp = new ArrayList<String>(); 
            temp.add(key); 
            rmap.put(sGrades.get(key), temp); 
         }
         else
            for(String s : rmap.keySet())
               if(sGrades.get(key).equals(s))
                   rmap.get(s).add(key); 
      }
      //display the reversed map
   	Iterator<String> it3 = rmap.keySet().iterator();
      System.out.println();  
      while(it3.hasNext())
      {
         String k = it3.next(); 
         System.out.println(k + ": " + rmap.get(k));
      } 
   }
}

/**********************
 Audrey Hepburn (A)
 Humphrey Bogart (A+)
 Jack Nicholson (A-)
 Jimmy Stewart (A)
 Meryl Streep (A-)
 
 A: [Audrey Hepburn, Jimmy Stewart]
 A+: [Humphrey Bogart]
 A-: [Jack Nicholson, Meryl Streep]
 
 *********************/