import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import java.awt.Color;
import java.util.ArrayList;

public class BlusterCritter extends Critter
{
   private int courage; 
   public BlusterCritter(int c)
   {
      courage = c; 
   }
   public ArrayList<Actor> getActors()
   {
      Grid gr = getGrid(); 
      ArrayList<Actor> actors = new ArrayList<Actor>(); 
      Location myLoc = this.getLocation(); 
      int myRow = myLoc.getRow(); 
      int myCol = myLoc.getCol(); 
      for(int r = myRow - 2; r <= myRow + 2; r++)
      {
         for(int c = myCol -2; c <= myCol + 2; c++)
         {
            Location newLoc = new Location(r, c);
            //Actor actatloc = gr.get(newLoc);  
            if(gr.isValid(newLoc) && (gr.get(newLoc) instanceof Actor))
            {
               Actor atloc = (Actor)gr.get(newLoc); 
               actors.add(atloc); 
            }
         }
      } 
      actors.remove(this); 
      return actors;    
   }
   public void processActors(ArrayList<Actor> actors)
   {
      if(actors.size() < courage)
      {
         this.setColor(this.getColor().brighter()); 
      }
      else if(actors.size() >= courage)
      {
         this.setColor(this.getColor().darker());  
      }
   }
   public void makeMove(Location loc)
   {
      setDirection(getLocation().getDirectionToward(loc));
      super.makeMove(loc);
   }


}