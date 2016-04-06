import javax.swing.JFrame;
import java.io.*;
import javax.swing.JOptionPane;
import java.util.Scanner;
public class CardDriver
{
	public static void main(String[] args)
	{
		CardDeck_6B_Karlekar c = new CardDeck_6B_Karlekar();
      System.out.println("Top Card: " + c.getTopCard());
      c.shuffle(7);
      Card hello = new Card(1, 2); 
      c.putAtEnd(hello);
      System.out.println("----------CARD ADDED TO END----------"); 
      c.printDeck();  

	}
}