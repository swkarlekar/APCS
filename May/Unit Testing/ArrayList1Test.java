import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class ArrayList1Test {
   private ArrayList1<Double> a; 

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   a = new ArrayList1<Double>(); 
   }


   /** A test that always fails. **/
   /*@Test public void defaultTest() {
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", 0, 1);
   }*/
   @Test public void testSize()
   {
      assertEquals(0, a.size()); 
      assertEquals(false, 1 == a.size()); 
      a.add(1.0); 
      assertEquals(true, 1 == a.size()); 
      a.add(1.0); 
      assertEquals(true, 2 == a.size()); 
   }
   @Test public void testAddGet()
   {
      for(int i = 0; i < 10; i++)
         a.add(i*1.0); 
      for(int i = 0; i < 10; i++)
         assertEquals(i, a.get(i), 1E-6);
      //assertEquals(a.size(), 10);  
      
   }
   @Test public void testAddGet2()
   {
      for(int i = 0; i < 10; i++)
         a.add(0, i*1.0); 
      //System.out.println(a.size()); 
      //for(int i = 0; i < 10; i++)
         //assertEquals(i, a.get(i), 1E-6); 
      //assertEquals(1, a.size(), 1E-6); 
   }
   @Test public void testRemove()
   {
      /*a.add(5.6); 
      a.add(0, 4.2); 
      a.add(3.9); 
      assertEquals(4.2, a.get(0), 1E-6); 
      a.remove(0); 
      assertEquals(5.6, a.get(0), 1E-6); 
      a.remove(1); 
      assertEquals(5.6, a.get(0), 1E-6); */
      a.add(5.6); 
      a.add(4.2); 
      a.add(3.9);
      a.add(5.6); 
      a.add(4.2); 
      a.add(3.9);
      a.add(5.6); 
      a.add(4.2); 
      a.add(3.9);
      a.add(5.6); 
      a.add(4.2); 
      a.add(4.2); 
      assertEquals(4.2, a.get(11), 1E-6); 
   }
}
