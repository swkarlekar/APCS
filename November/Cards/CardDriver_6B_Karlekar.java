import javax.swing.JFrame;
import java.io.*;
import javax.swing.JOptionPane;
import java.util.Scanner;
public class CardDriver_6B_Karlekar
{
	public static void main(String[] args)
	{
		CardDeck_6B_Karlekar c = new CardDeck_6B_Karlekar();
      System.out.println("Top Card: " + c.getTopCard());
      c.shuffle(7);
      Card_6B_Karlekar hello = new Card_6B_Karlekar(1, 2); 
      c.putAtEnd(hello);
      System.out.println("----------CARD ADDED TO END----------"); 
      c.printDeck();  

	}
}