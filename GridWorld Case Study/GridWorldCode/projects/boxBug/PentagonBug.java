import info.gridworld.actor.*;

public class PentagonBug extends Bug
{
   private int steps, sideLength; 
   public PentagonBug(int length)
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
            sideLength = sideLength + 2; 
            turn(); 
            if (steps < sideLength && canMove())
               for(int i = 0; i < sideLength; i++)
               move();
            turn();
            turn();  
        }
        else
        {
            turn();
            turn(); 
            steps = 0;
        }
    }

}