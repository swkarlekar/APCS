import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Actor; 
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

/**
 * This class runs a world that contains crab critters. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class KingCrabRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        /*world.add(new Location(7, 5), new Rock());
        world.add(new Location(5, 4), new Rock());
        world.add(new Location(5, 7), new Rock());*/
        world.add(new Location(2, 5), new Rock());
        //world.add(new Location(3, 5), new Flower());
        /*world.add(new Location(2, 2), new Flower());
        world.add(new Location(3, 5), new Flower());
        world.add(new Location(3, 8), new Flower());
        world.add(new Location(6, 5), new Bug());
        world.add(new Location(5, 3), new Bug());*/
        world.add(new Location(4, 5), new KingCrab());
        world.add(new Location(3, 5), new Actor()); 
        world.add(new Location(3, 6), new Actor()); 
        world.add(new Location(3, 4), new Actor()); 
        world.add(new Location(4, 6), new Actor()); 
        world.add(new Location(4, 4), new Actor()); 
        world.add(new Location(5, 4), new Actor()); 
        world.add(new Location(5, 5), new Actor()); 
        world.add(new Location(5, 6), new Actor()); 

        //world.add(new Location(6, 1), new KingCrab());
        //world.add(new Location(7, 4), new KingCrab());
        world.show();
    }
}