//name: Sweta Karlekar       date: 2/4/14
   import java.util.*;

    public class AssemblyLine_6B_Karlekar
   {
      static int NDISKS = 50;
      static int MAXRADIUS = 100;
       public static void main(String[] args)
      {
         AssemblyLine a = new AssemblyLine(NDISKS, MAXRADIUS);
         a.showInput();
         a.process();
         a.showOutput();
      }
   }
   
    class AssemblyLine
   {
      private Queue<Disk> assemblyLineIn = new LinkedList<Disk>();
      private Queue<Pyramid> assemblyLineOut;
      private Pyramid robotArm;
   	/**
   		* initializes this object so the assemblyLineIn contains 
   		* nDisks with random radii;  assemblyLineOut is initialized to * an empty Queue; robotArm is initialized to an empty Pyramid.
   		**/
   	//Part A
       public AssemblyLine( int nDisks, int maxRadius )
      {	
         for(int i = 0; i < nDisks; i++)
            assemblyLineIn.add(new Disk(maxRadius)); 
         assemblyLineOut = new LinkedList<Pyramid>(); 
         robotArm = new Pyramid(); 
      }
   
   	/**
   		* "flips over" the pyramid in the robotArm and adds it to the
   		* assemblyLineOut queue.
   		* Precondition:  robotArm is not empty and holds an inverted 
   		*				pyramid of disks
   		**/
   	// Part B
       private void unloadRobot()
      { 
         Pyramid stack = new Pyramid(); 
         while(!robotArm.isEmpty())
            stack.add(robotArm.pop());
         assemblyLineOut.add(stack); 
      }
   
   	/**
   		* processes all disks from assemblyLineIn; a disk is processed
   		* as follows:  if robotArm is not empty and the next disk does
   		* not fit on top of robotArm (which must be an inverted 
   		* pyramid) then robotArm is unloaded first; the disk from
   		* assemblyLineIn is added to robotArm; when all the disks
   		* have been retrieved from assemblyLineIn, robotArm is unloaded.
   		*  Precondition:  robotArm is empty;
   		*				assemblyLineOut is empty
   		**/
   	//Part C
       public void process()
      {
         while(!assemblyLineIn.isEmpty())
         {
            if(!robotArm.isEmpty())
            {
               if(robotArm.peek().compareTo(assemblyLineIn.peek()) < 0)
                  robotArm.push(assemblyLineIn.remove());
               else
                  unloadRobot(); 
            }
            else
               robotArm.push(assemblyLineIn.remove()); 
         }
         unloadRobot(); 
      }
      
       public void showInput()
      {
         System.out.println(assemblyLineIn);
      }
       public void showOutput()
      {
         System.out.println(assemblyLineOut);
      }
   }
   //Disk is standard and straightforward.
    class Disk implements Comparable<Disk>
   {
      private int myRadius;  
      public Disk(int max)
      {
         myRadius = (int)(Math.random() * max + 1); 
      }
      public int getRadius()
      {
         return myRadius; 
      }
      public int compareTo(Disk d)
      {
         return myRadius - d.myRadius; 
      }
      public String toString()
      {
         return myRadius + ""; 
      }
   
   }
   //Pyramid is sly.
    class Pyramid extends Stack<Disk>
   {
   }