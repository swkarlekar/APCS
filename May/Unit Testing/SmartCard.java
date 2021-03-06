  //mlbillington@fcps.edu 
  //Dec 4, 2008    updated for JUnit on March 18, 2013
    
   import java.text.DecimalFormat;

   public class SmartCard 
   {
      public static DecimalFormat df = new DecimalFormat("$0.00");
      public static double MIN_FARE = 0.5;
      //private data
      double moneyRemaining;
      Station boardedAt = null;
      boolean isOnBoard = false;
      
      //constructor
      public SmartCard()
      {
         moneyRemaining = 0.0;
      }
      public SmartCard(double money)
      {
         moneyRemaining = money;
      }
      // consumes how much money to add to this SmartCard and 
      // updates this SmartCard
      public void addMoney( double amount )
      {
         if( amount > 0 )
            moneyRemaining += amount;
      }
      public double moneyOnCard()
      {
         return moneyRemaining;
      }
      public boolean onBoardStatus()
      {
         return isOnBoard;
      }
      //given the Station where the traveler boards
      //returns a new SmartCard with correct information 
      public void board( Station station )
      {
         if(isOnBoard)
         {
            System.out.println("Please see the station manager!");
            return;
         }
         else if(moneyRemaining < MIN_FARE)
         {	
            System.out.println("Please add more money");
          	return;
         }
         boardedAt = station;
         isOnBoard = true;
      }
      //consumes the current station and produces the price the SmartCard holder would have to pay to disembark. 
      public double cost(Station station)
      {
      
         double zoneTraveled = Math.abs(boardedAt.getZone() - station.getZone());
         return .50 + .75 * zoneTraveled;
      }	
      
      //consumes the current station and updates this SmartCard, charging the customer the appropriate amount and setting the other fields correctly. 
      public void disembark(Station station)
      {
         if(!isOnBoard)
         {
            System.out.println("Please see the station manager!");
         	return;
         }
         else
         {
            double cost = cost(station);
            moneyRemaining -= cost;
            isOnBoard = false; 
         }
      }
   }
   class Station
   {
      String stationName;
      int zone;
      public Station(String name, int zone)
      {
         stationName = name;
         this.zone = zone;
      }
      public int getZone()
      {
         return zone;
      }
      public String getName()
      {
         return stationName;
      }
      public String toString()
      {
         return stationName;
      }
   }
