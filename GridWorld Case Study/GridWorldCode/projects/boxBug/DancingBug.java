import info.gridworld.actor.Bug;

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class DancingBug extends Bug
{
   private int steps, index;
   private int sideLength;
   private int[] numTurns; 

   /**
    * Constructs a box bug that traces a square of a given side length
    * @param length the side length
    */
   public DancingBug(int[] arrayTurns, int length)
   {
      steps = index = 0;
      sideLength = length;
      numTurns = arrayTurns; 
   }

   /**
    * Moves to the next location of the square.
    */
   public void act()
   {
      if (steps < sideLength && canMove())
      {
         move();
         steps++;
      }
      else
      {
         for(int i = 0; i < numTurns[index]; i++)
         {
            turn(); 
         }
         index++; 
         if(index >= numTurns.length)
            index = 0; 
         steps = 0; 
      
      }
   
   }
}
