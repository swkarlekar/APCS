  //Name: Sweta Karlekar  Date: 3/23/14
import java.util.*;
public class Polynomial_6B_Karlekar
{
   public static void main(String[] args)
   {
      Polynomial poly = new Polynomial();
      poly.makeTerm(1.0, -4.0);
      poly.makeTerm(3.0, 2.0);
      poly.makeTerm(0.0, 2.0);
      System.out.println(poly.toString());
      double evaluateAt = 2.0;
      System.out.println("Evaluated at "+ evaluateAt +": " +poly.evaluateAt(evaluateAt));
   	   	
      Polynomial poly2 = new Polynomial();
      poly2.makeTerm(1.0, -5.0);
      poly2.makeTerm(4.0, 2.0);
      poly2.makeTerm(0.0, -3.0);
      poly2.makeTerm(2.0, 1.0); 
      System.out.println(poly2.toString());
   	
      System.out.println("Added: " + poly.add(poly2));
      System.out.println("Subtracted: " + poly.subtract(poly2));
      System.out.println("Poly 1: Differentiated: " + poly.differentiate());
      System.out.println("Poly 2: Differentiated: " + poly2.differentiate());
      System.out.println("Poly 1: Integrated: " + poly.integrate() + "+ c"); 
      System.out.println("Poly 2: Integrated: " + poly2.integrate() + "+ c"); 
      System.out.println("Poly 1: Derivative Integrated: " + poly.differentiate().integrate() + "+ c");   
      System.out.println("Poly 2: Derivative Integrated: " + poly2.differentiate().integrate() + "+ c");
      System.out.println("Multiplied: " + poly.multiply(poly2));
   }
}


class Polynomial
{
   private Map<Double, Double> myMap; 
   public Polynomial()
   {
      myMap = new TreeMap<Double, Double>(); 
   }
   public Polynomial(double pow, double coef)
   {
      myMap = new TreeMap<Double, Double>(); 
      this.makeTerm(pow, coef); 
   }
   public void makeTerm(Double exp, Double coef)
   {
      myMap.put(exp, coef); 
   }
   public double evaluateAt(double x)
   {
      Iterator<Double> it = myMap.keySet().iterator();
      double fineval = 0;  
      while(it.hasNext())
      {
         Double temp = it.next();
         double wocoef = Math.pow(x, temp); 
         fineval += myMap.get(temp) * wocoef; 
      }
      return fineval; 
   }
   public Polynomial add(Polynomial other)
   {
      if(myMap.isEmpty())
         return other; 
      Polynomial added = new Polynomial(); 
      Map<Double, Double> mytemp = new TreeMap<Double, Double>();
      for(Double i : myMap.keySet())
         mytemp.put(i, myMap.get(i)); 
      Iterator<Double> it2 = other.myMap.keySet().iterator(); 
      while(it2.hasNext())
      {
         Double otherpower = it2.next();
         if(myMap.containsKey(otherpower))
         {
            added.makeTerm(otherpower, other.myMap.get(otherpower) + myMap.get(otherpower));
            mytemp.remove(otherpower);     
         }
         else  
         {
            added.makeTerm(otherpower, other.myMap.get(otherpower)); 
         }
      }
      for(Double p : mytemp.keySet())
      {
         added.makeTerm(p, mytemp.get(p)); 
      }
       
      return added; 
   }
   public Polynomial subtract(Polynomial other)
   {
      if(myMap.isEmpty())
         return other; 
      Polynomial added = new Polynomial(); 
      Map<Double, Double> mytemp = new TreeMap<Double, Double>();
      for(Double i : myMap.keySet())
         mytemp.put(i, myMap.get(i)); 
      Iterator<Double> it2 = other.myMap.keySet().iterator(); 
      while(it2.hasNext())
      {
         Double otherpower = it2.next();
         if(myMap.containsKey(otherpower))
         {
            added.makeTerm(otherpower, other.myMap.get(otherpower) - myMap.get(otherpower));
            mytemp.remove(otherpower);     
         }
         else  
         {
            added.makeTerm(otherpower, other.myMap.get(otherpower)); 
         }
      }
      for(Double p : mytemp.keySet())
      {
         added.makeTerm(p, mytemp.get(p)); 
      }
       
      return added; 
   }

   public Polynomial multiply(Polynomial other)
   {
      Polynomial multiplied = new Polynomial(); 
      Map<Double, Double> mytemp = new TreeMap<Double, Double>();
      for(Double i : myMap.keySet())
         mytemp.put(i, myMap.get(i)); 
      Queue<Polynomial> q = new LinkedList<Polynomial>(); 
      for(Double thispower : mytemp.keySet())
         for(Double otherpower : other.myMap.keySet())
            q.add(new Polynomial((otherpower + thispower), (mytemp.get(thispower) * other.myMap.get(otherpower)))); 
    
      while(!q.isEmpty())
         multiplied = multiplied.add(q.remove());  
      
      return multiplied; 
   }
   public Polynomial differentiate()
   {
      Polynomial differed = new Polynomial(); 
      Map<Double, Double> mytemp = new TreeMap<Double, Double>(); 
      for(Double i : myMap.keySet())
         mytemp.put(i, myMap.get(i)); 
      for(Double i : mytemp.keySet())
         if((i-1)>= 0)
            differed.makeTerm(i-1, mytemp.get(i)*i);
      return differed; 
   } 
   public Polynomial integrate()
   {
      Polynomial integrated = new Polynomial(); 
      Map<Double, Double> mytemp = new TreeMap<Double, Double>(); 
      for(Double i : myMap.keySet())
         mytemp.put(i, myMap.get(i)); 
      for(Double i : mytemp.keySet())
         integrated.makeTerm(i+1, mytemp.get(i)/(i+1));
      return integrated;
   } 
   public String toString()
   {
      String toreturn = ""; 
       
      for(Double power : myMap.keySet())
      {
         if(power >1 && myMap.get(power) != 1)
            toreturn = myMap.get(power) + "x^"+ power + " + " + toreturn;
         else if(power >1 && myMap.get(power) == 1)
            toreturn = "x^"+ power + " + " + toreturn;
         else if(power ==1 && myMap.get(power) != 1)
            toreturn = myMap.get(power) + "x"+ " + "+ toreturn;
         else if(power ==1 && myMap.get(power) == 1)
            toreturn = "x"+ " + "+ toreturn;
         else
            toreturn = myMap.get(power) + " + "+ toreturn; 
        
      }
      return toreturn.substring(0, toreturn.length()-2);
   }
}
/*  
expected output
   2x^3 + -4x + 2
   10.0
   2x^4 + x^2 + -5x + -3
   2x^4 + 2x^3 + x^2 + -9x + -1
   4x^7 + -6x^5 + -6x^4 + -10x^3 + 22x^2 + 2x + -6
 */