import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/**
 * A <code>CrabCritter</code> looks at a limited set of neighbors when it eats and moves.
 * <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class QuickCrab extends CrabCritter
{
   

   public ArrayList<Location> getMoveLocations()
   {
      ArrayList<Location> locs = new ArrayList<Location>();
      Grid gr = getGrid();
      Location loc = getLocation(); 
      Location locleft = loc.getAdjacentLocation(getDirection() + Location.LEFT); 
      if(gr.isValid(locleft) && gr.get(locleft) == null)
      {
         Location locleft2 = locleft.getAdjacentLocation(getDirection() + Location.LEFT); 
         if(gr.isValid(locleft2) && gr.get(locleft2) == null)
            locs.add(locleft2);
      } 
      
      Location locright = loc.getAdjacentLocation(getDirection() + Location.RIGHT); 
      if(gr.isValid(locright) && gr.get(locright) == null)
      {
         Location locright2 = locright.getAdjacentLocation(getDirection() + Location.RIGHT); 
         if(gr.isValid(locright2) && gr.get(locright2) == null)
            locs.add(locright2);
      }
      
      if(locs.size() > 0)
         return locs; 
      return super.getMoveLocations(); 

 
   }
     
}
