import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import info.gridworld.grid.Grid; 


import java.util.ArrayList;

/**
 * A <code>ChameleonCritter</code> takes on the color of neighboring actors as
 * it moves through the grid. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ChameleonKid extends ChameleonCritter
{
    /**
     * Randomly selects a neighbor and changes this critter's color to be the
     * same as that neighbor's. If there are no neighbors, no action is taken.
     */
   public ArrayList<Actor> getActors()
   {
      ArrayList<Actor> actors = new ArrayList<Actor>(); 
      int[] directions = {0, 180};
      ArrayList<Location> locs = new ArrayList<Location>(); 
      Grid gr = getGrid(); 
      Location loc = getLocation(); 
      for(int d : directions)
      {
         Location neighborlocations = loc.getAdjacentLocation(getDirection() + d);
         if(gr.isValid(neighborlocations))
            locs.add(neighborlocations);
            
      } 
      for(Location l : locs)
      {
         Actor ac = getGrid().get(l); 
         if(ac!= null)
            actors.add(ac); 
            
      }
      return actors; 
      
   }
}
