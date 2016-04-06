import info.gridworld.actor.*;

public class ZBug extends Bug
{
   private int steps, sideLength, stopPoint; 
   public ZBug(int length)
   {
      steps= stopPoint= 0; 
      sideLength = length;
      turn(); 
      turn();         
   }
   public void act()
   {
      if(steps < sideLength && canMove())
      {
         move(); 
         steps++;  
      }
      else if(steps >= sideLength && canMove() && stopPoint == 0)
      {
         turn(); 
         turn(); 
         turn(); 
         steps = 0;
         stopPoint++;  
      } 
       else if(steps >= sideLength && canMove() && stopPoint == 1)
      {
         turn(); 
         turn(); 
         turn(); 
         turn(); 
         turn(); 
         steps = 0;
         stopPoint++;  
      } 

      
      
   }

}