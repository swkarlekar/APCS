import info.gridworld.actor.* ;
import info.gridworld.grid.Location;

import java.awt.Color;

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class SpiralBugRunner
{
   public static void main(String[] args)
   {
      ActorWorld world = new ActorWorld();
      //world.setGrid(new UnboundedGrid<ActorWorld>());
      //SpiralBug alice = new SpiralBug(6);
      //alice.setColor(Color.ORANGE);
      SpiralBug bob = new SpiralBug(3);
      //world.add(new Location(7, 8), alice);
      world.add(new Location(5, 5), bob);
      world.show();
   }
}