import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import info.gridworld.actor.Rock;

import java.util.ArrayList;

/**
 * A <code>ChameleonCritter</code> takes on the color of neighboring actors as
 * it moves through the grid. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class RockHound extends Critter
{
    /**
     * Randomly selects a neighbor and changes this critter's color to be the
     * same as that neighbor's. If there are no neighbors, no action is taken.
     */
   public void processActors(ArrayList<Actor> actors)
   {
      if (actors.isEmpty())
      { 
         Color c = this.getColor();
         int red = (int) (c.getRed() * (1 - 0.05));
         int green = (int) (c.getGreen() * (1 - 0.05));
         int blue = (int) (c.getBlue() * (1 - 0.05));
         setColor(new Color(red, green, blue));
         return; 
      }
      int r = (int) (Math.random() * actors.size());
      Actor other = actors.get(r);
      setColor(other.getColor());
       
      if((other instanceof Rock))
         other.removeSelfFromGrid();
      
      /*Actor other = actors.get(r);
      setColor(other.getColor());*/

   }
    /**
     * Turns towards the new location as it moves.
     */
   public void makeMove(Location loc)
   {
      setDirection(getLocation().getDirectionToward(loc));
      super.makeMove(loc);
   }
}
