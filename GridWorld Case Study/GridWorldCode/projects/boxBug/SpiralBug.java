import info.gridworld.actor.*;

public class SpiralBug extends Bug
{
   private int steps, sideLength; 
   public SpiralBug(int length)
   {
      steps = 0; 
      sideLength = length; 
   }
   public void act()
    {
        if (steps < sideLength && canMove())
        {
            for(int i = 0; i < sideLength; i++)
               move();
            steps++;
            sideLength++; 
            turn(); 
            turn(); 
        }
        else
        {
            turn();
            steps = 0;
        }
    }

}