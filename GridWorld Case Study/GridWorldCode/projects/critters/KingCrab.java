import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Rock; 
import info.gridworld.actor.Flower; 
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/**
 * A <code>CrabCritter</code> looks at a limited set of neighbors when it eats and moves.
 * <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class KingCrab extends CrabCritter
{
   public void processActors(ArrayList<Actor> actors)
   {
      for(Actor a : actors)
      {
         Location aloc = a.getLocation(); 
         Location myLoc = this.getLocation(); 
         Location moveto = aloc.getAdjacentLocation(myLoc.getDirectionToward(aloc));
         if(getGrid().isValid(moveto) && getGrid().get(moveto) == null) 
            a.moveTo(moveto); 
         else
            a.removeSelfFromGrid();
        
                     
      }
   }

}