import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class DancingBugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        int[] random1 = new int[10]; 
        for(int i = 0; i < random1.length; i++)
        {
            random1[i] = (int)(Math.random() * 11 + 1);
        }
        int[] random2 = new int[10]; 
        for(int i = 0; i < random2.length; i++)
        {
            random2[i] = (int)(Math.random() * 11 + 1);
        }
        DancingBug alice = new DancingBug(random2, 6);
        alice.setColor(Color.ORANGE);
        DancingBug bob = new DancingBug(random1, 3);
        world.add(new Location(7, 8), alice);
        world.add(new Location(5, 5), bob);
        world.show();
    }
}