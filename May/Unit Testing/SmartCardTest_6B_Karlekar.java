import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class SmartCardTest_6B_Karlekar {
   private SmartCard a; 
   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
      a = new SmartCard(); 
   }


   /** A test that always fails. **/
   /*@Test public void defaultTest() {
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", 0, 1);
   }*/
   @Test public void testAddMoney()
   {
      assertEquals(0.0, a.moneyOnCard(), 1E-6); 
      a.addMoney(3.0); 
      assertEquals(3.0, a.moneyOnCard(), 1E-6); 
   }
   @Test public void testOnBoardStatus()
   {
      Station s = new Station("Station 1", 1); 
      assertEquals(false, a.onBoardStatus()); 
      a.addMoney(5.00); 
      a.board(s); 
      assertEquals(true, a.onBoardStatus()); 
      a.disembark(s); 
      assertEquals(false, a.onBoardStatus()); //disembark doesn't make onBoardStatus false 
   }
}
