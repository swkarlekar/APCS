import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class Stack1Test {
   private Stack1<Double> s; 

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
      s = new Stack1<Double>(); 
      
   }


   /** A test that always fails. **/
   /*@Test public void defaultTest() {
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", 0, 1);
   }*/
   @Test public void push()
   {
      s.push(2.0);
      s.push(3.0); 
      s.push(4.0); 
      s.push(5.0); 
      s.push(6.0); 
      s.push(2.0);
      s.push(3.0); 
      s.push(4.0); 
      s.push(5.0); 
      s.push(6.0);
      s.push(2.0);
      assertEquals(11, s.size()); 
   }
   @Test public void pop()
   {
      s.push(2.0);
      s.push(3.0); 
      s.push(4.0); 
      s.push(5.0); 
      s.push(6.0);
      assertEquals(s.pop(), 6.0, 1E-6);
      assertEquals(s.pop(), 5.0, 1E-6); 
      assertEquals(s.pop(), 4.0, 1E-6);
      assertEquals(s.pop(), 3.0, 1E-6); 
      assertEquals(s.pop(), 2.0, 1E-6); 
      //assertEquals(s.pop(), 2.0, 1E-6); //returns IndexOutOfBoundsException
 
   }
   @Test public void peek()
   {
      s.push(2.0);
      s.push(3.0); 
      s.push(4.0); 
      s.push(5.0); 
      s.push(6.0);
      assertEquals(s.pop(), 6.0, 1E-6);
      assertEquals(s.pop(), 5.0, 1E-6); 
      assertEquals(s.pop(), 4.0, 1E-6);
      assertEquals(s.pop(), 3.0, 1E-6); 
      assertEquals(s.pop(), 2.0, 1E-6);
      //assertEquals(s.pop(), 2.0, 1E-6); //returns IndexOutOfBoundsException
   }
   @Test public void isEmpty()
   {
      assertEquals(s.isEmpty(), true); 
      s.push(2.0);
      s.push(3.0); 
      s.push(4.0); 
      s.push(5.0); 
      s.push(6.0);
      assertEquals(s.isEmpty(), false);
      s.pop();
      s.pop();
      s.pop();
      s.pop();
      s.pop();
      assertEquals(s.isEmpty(), true);  
   }
   @Test public void size()
   {
      assertEquals(s.size(), 0); 
      s.push(2.0);
      s.push(3.0); 
      s.push(4.0); 
      s.push(5.0); 
      s.push(6.0);
      assertEquals(s.size(), 5);
      s.pop();
      s.pop();
      s.pop();
      s.pop();
      s.pop();
      assertEquals(s.size(), 0);  
   }
}
