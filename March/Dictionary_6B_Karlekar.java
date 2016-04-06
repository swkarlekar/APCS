   //Name:  Sweta Karlekar   Date: 3/14/14
import java.io.*;
import java.util.*;
import javax.swing.*; 

public class Dictionary_6B_Karlekar
{
   public static void main(String[] args) throws Exception
   {
      try
      {
         System.setOut(new PrintStream(new FileOutputStream("dictionaryOutput.txt")));
      }
      catch(Exception e)
      {
      }
      Map<String, Set<String>> eng2spn = new TreeMap<String, Set<String>>();
      Scanner infile = new Scanner(new File("spanglish.txt"));
      while(infile.hasNext())
      {
         add(eng2spn, infile.next(), infile.next());
      }
      infile.close();
      System.out.println("ENGLISH TO SPANISH");
      display(eng2spn);
      
      Map<String, Set<String>> spn2eng = reverse(eng2spn);
      System.out.println("\nSPANISH TO ENGLISH");
      display(spn2eng);
      
      String input = JOptionPane.showInputDialog("Would you like to translate from Spanish to English or English to Spanish?"); 
      Scanner diction = new Scanner(new File("dictionaryOutput.txt")); 
      if(input.equalsIgnoreCase("spanish to english"))
      {
         Map<String, Set<String>> newSpanToEng = createSpanToEngDictionary(diction, "SPANISH TO ENGLISH"); 
         lookUp(newSpanToEng); 
         userPrompt(newSpanToEng);
         System.out.println("\nNEW DICTIONARY"); 
         display(newSpanToEng);   
      }
      else if(input.equalsIgnoreCase("english to spanish"))
      {
         Map<String, Set<String>> newEngToSpan = createSpanToEngDictionary(diction, "ENGLISH TO SPANISH"); 
         lookUp(newEngToSpan); 
         userPrompt(newEngToSpan); 
         System.out.println("\nNEW DICTIONARY"); 
         display(newEngToSpan);   
      }
      else
         JOptionPane.showMessageDialog(null, "Please enter either 'Spanish to English' or 'English to Spanish'");  
      
      JOptionPane.showMessageDialog(null, "Good-bye!");
      
   }
   public static void display(Map<String, Set<String>> m)
   {
      Iterator<String> it = m.keySet().iterator(); 
      while(it.hasNext())
      {
         String k = it.next(); 
         System.out.println(k + " " + m.get(k));
      } 
   
   }
   public static void add(Map<String, Set<String>> dictionary, String word, String translation)
   {
      if(dictionary.containsKey(word))
      {
         for(String s : dictionary.keySet())
            if(s.equals(word))
               dictionary.get(s).add(translation); 
      }
      else
      {
         Set<String> insert = new HashSet<String>(); 
         insert.add(translation); 
         dictionary.put(word, insert); 
      }
   
   }
   public static Map<String, Set<String>> reverse(Map<String, Set<String>> dictionary)
   {
      TreeMap<String, Set<String>> rmap = new TreeMap<String, Set<String>>(); 
      Iterator<String> it2 = dictionary.keySet().iterator(); 
      while(it2.hasNext())
      {
         String oldkey = it2.next(); 
         Iterator<String> it3 = dictionary.get(oldkey).iterator(); 
         while(it3.hasNext())
         { 
            String newword = it3.next();
            if(!rmap.containsKey(newword))
            {
               Set<String> temp = new HashSet<String>(); 
               temp.add(oldkey); 
               rmap.put(newword, temp); 
            }
            else
            {
               for(String s : rmap.keySet())
                  if(s.equals(newword))
                     rmap.get(s).add(oldkey);
            } 
         }
      }
      return rmap; 
   
   }
   public static Map<String, Set<String>> createSpanToEngDictionary(Scanner diction, String wanttitle)
   {
      Map<String, Set<String>> spanglish = new TreeMap<String, Set<String>>(); 
      String title = diction.nextLine(); 
      while(!title.equals(wanttitle))
      {
         title = diction.nextLine(); 
      }
      while(diction.hasNextLine())
      {
         String newline = diction.nextLine(); 
         if(newline.isEmpty())
            break; 
         String word = newline.substring(0, newline.indexOf(" ")); 
         newline = newline.substring(newline.indexOf("[")+1);
         newline = newline.replace(',', '&'); 
         newline = newline.replace(']', '&');
         newline = newline.replace(' ', '&');
         newline = newline.replace("&&", "&");    
         while(!newline.isEmpty())
         {
            add(spanglish, word, newline.substring(0, newline.indexOf("&"))); 
            newline = newline.substring(newline.indexOf("&") + 1); 
         }
      } 
      return spanglish; 
   }
   public static void lookUp(Map<String, Set<String>> newSpanToEng)
   {
      String tranword = JOptionPane.showInputDialog("Please enter the word you would like to look up: "); 
      if(newSpanToEng.containsKey(tranword))
      {
         JOptionPane.showMessageDialog(null, "Translation: " + newSpanToEng.get(tranword)); 
      }
      else
      {
         String yesornoadd = JOptionPane.showInputDialog("Sorry, that word was not found in our dictionary. Would you like to add a translation for it?");
         if(yesornoadd.equalsIgnoreCase("yes"))
         {
            String addtrans = JOptionPane.showInputDialog("Please enter your translation: "); 
            add(newSpanToEng, tranword, addtrans); 
            JOptionPane.showMessageDialog(null, "Your translation has been added."); 
         }
      }
   
   }
   public static void userPrompt(Map<String, Set<String>> newSpanToEng)
   {
      String userprompt = JOptionPane.showInputDialog("Are you a user?"); 
      if(userprompt.equalsIgnoreCase("yes"))
      {
         String passwordprompt = JOptionPane.showInputDialog("Password please: "); 
         if(passwordprompt.equals("computerscience")) 
         {
            String dowhat = JOptionPane.showInputDialog("Would you like to add, modify, or remove entries from this dictionary?");  
            if(dowhat.equalsIgnoreCase("add"))
            {
               String addwhatword = JOptionPane.showInputDialog("What word would you like to add?"); 
               String addwhattrans = JOptionPane.showInputDialog("Please enter the translation for this word."); 
               add(newSpanToEng, addwhatword, addwhattrans); 
               JOptionPane.showMessageDialog(null, "Your new word has been added."); 
               
            }
            if(dowhat.equalsIgnoreCase("remove"))
            {
               String removewhatword = JOptionPane.showInputDialog("What word would you like to delete?"); 
               newSpanToEng.remove(removewhatword); 
               JOptionPane.showMessageDialog(null, "Your word has been deleted.");
            }
            if(dowhat.equalsIgnoreCase("modify"))
            {
               String modifywhatword = JOptionPane.showInputDialog("What word would you like to modify?"); 
               Set<String> translations = newSpanToEng.get(modifywhatword); 
               newSpanToEng.remove(modifywhatword); 
               String newlymodifiedword = JOptionPane.showInputDialog("Please enter modified word.");
               for(String s : translations)
                  add(newSpanToEng, newlymodifiedword, s);  
               JOptionPane.showMessageDialog(null, "Your word has been modified.");
            }
         }
         else
         {
            JOptionPane.showMessageDialog(null, "Sorry, but you must be a user."); 
         }
      }
   
   }

   
}
      /********************
	INPUT:
   	holiday
		fiesta
		holiday
		vacaciones
		party
		fiesta
		celebration
		fiesta
     <etc.>
  *********************************** 
	OUTPUT:
		ENGLISH TO SPANISH
			banana [banana]
			celebration [fiesta]
			computer [computadora, ordenador]
			double [doblar, doble, duplicar]
			father [padre]
			feast [fiesta]
			good [bueno]
			hand [mano]
			hello [hola]
			holiday [fiesta, vacaciones]
			party [fiesta]
			plaza [plaza]
			priest [padre]
			program [programa, programar]
			sleep [dormir]
			son [hijo]
			sun [sol]
			vacation [vacaciones]

		SPANISH TO ENGLISH
			banana [banana]
			bueno [good]
			computadora [computer]
			doblar [double]
			doble [double]
			dormir [sleep]
			duplicar [double]
			fiesta [celebration, feast, holiday, party]
			hijo [son]
			hola [hello]
			mano [hand]
			ordenador [computer]
			padre [father, priest]
			plaza [plaza]
			programa [program]
			programar [program]
			sol [sun]
			vacaciones [holiday, vacation]

**********************/