import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class PrimeCheckTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
   /*@Test public void defaultTest() {
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", 0, 1);
   }*/
   @Test public void prime2()
   {
      Assert.assertEquals("2 is prime.", true, PrimeCheck.isPrime(2)); 
   }
   @Test public void prime1()
   {
      Assert.assertEquals("1 is prime.", false, PrimeCheck.isPrime(1)); 
   }
   @Test public void prime121()
   {
      Assert.assertEquals("121 is prime.", false, PrimeCheck.isPrime(121)); 
   }
   @Test public void prime0()
   {
      Assert.assertEquals("0 is prime.", false, PrimeCheck.isPrime(0)); 
   }
   @Test public void prime15()
   {
      Assert.assertEquals("12 is prime.", false, PrimeCheck.isPrime(12));
   }
   @Test public void primeneg13()
   {
      Assert.assertEquals("-13 is prime.", false, PrimeCheck.isPrime(-13)); 
   }
   @Test public void prime4()
   {
      Assert.assertEquals("4 is prime.", false, PrimeCheck.isPrime(4)); 
   }
   @Test public void prime3()
   {
      Assert.assertEquals("3 is prime.", true, PrimeCheck.isPrime(3)); 
   }
   
}
