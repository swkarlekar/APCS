import info.gridworld.actor.*;

public class CircleBug extends Bug
{
   private int steps, sideLength; 
   public CircleBug(int length)
   {
      steps = 0; 
      sideLength = length; 
   }
   public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            steps = 0;
        }
    }

}