import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.grid.*;

import java.awt.Color;

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class JumperBug extends Bug
{
   /**
    * Constructs a box bug that traces a square of a given side length
    * @param length the side length
    */
    /*
    * Moves to the next location of the square.
    */
   public void move()
   {
      super.move(true);
   }
   public boolean isJumper()
   {
      return true;
   }
   public boolean canMove()
   {
      Grid<Actor> gr = getGrid();
      if (gr == null)
         return false;
      Location loc = getLocation();
      Location next = loc.getAdjacentLocation(getDirection());
      next = next.getAdjacentLocation(getDirection());
      if (!gr.isValid(next))
         return false;
      Actor neighbor = gr.get(next);
      return (neighbor == null);
   }
   public void act()
   {
      if(canMove())
      {
         move(); 
      }
      else
         turn(); 
   
   }
}
