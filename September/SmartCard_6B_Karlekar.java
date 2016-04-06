 //name:Sweta Karlekar     date: 9/5/13  
   import java.text.DecimalFormat;
    public class SmartCard_6B_Karlekar
   {
       public static void main(String[] args) 
      {
         Station downtown = new Station("Downtown", 1);
         Station center = new Station("Center City", 1);
         Station uptown = new Station("Uptown", 2);
         Station suburbia = new Station("Suburb", 4);
        
         SmartCard jimmy = new SmartCard(20.00); //bought with $20.00 
         jimmy.board(center);            		    //boarded in zone 1
         jimmy.disembark(suburbia);					 //disembark in zone 4
         jimmy.disembark(uptown);					 //disembark without having boarded
      	jimmy.board(uptown); 
			jimmy.board(center);
			jimmy.disembark(downtown); 
			jimmy.board(uptown); 
			jimmy.board(downtown); 
			jimmy.disembark(downtown); 
			jimmy.board(downtown);
			jimmy.disembark(suburbia); 
			
			jimmy.board(downtown); 
			jimmy.disembark(suburbia); 
			jimmy.board(downtown); 
			jimmy.disembark(suburbia); 
			jimmy.board(downtown); 
			jimmy.disembark(suburbia); 
			jimmy.board(downtown); 
			jimmy.disembark(suburbia);
			jimmy.board(downtown); 
			jimmy.disembark(center); 
			jimmy.board(center); 
			
      	//lots more test cases!				
      }
   }
    class SmartCard 
   { 
		DecimalFormat dollar = new DecimalFormat("$0.00"); 
		private static boolean allow = true;  
		private static int zone; 
		private static String stationName; 
		private static double myMoney; 
		public SmartCard(double money)
		{
			myMoney = money; 
		}
   	public void addMoney(double money)
		{
			myMoney += money; 
		}
		public void board(Station k)
		{
			if(allow)
			{
				zone = k.getZone(); 
				stationName = k.getName();
				if(myMoney < 0.50)
				{
					System.out.println("Please add more funds to SmartCard!");
					System.exit(0); 
				}
				else if(myMoney >= .50 && myMoney < 0.75)
					System.out.println("WARNING: Funds are not high enough to leave current zone."); 
				else
					System.out.println("Boarded at: " + stationName);
				allow = false;  
			}
			else
			{
				System.out.println("Please see station manager!");
				System.exit(0); 
			}
		}
		public double cost(Station k)
		{
			double x = (0.50 + 0.75 * Math.abs(k.getZone()-zone)); 
			if(x <= myMoney)
				return x; 
			else
				System.out.println("Please add more funds to SmartCard!"); 
				System.exit(0);
				return 0;  
		}
		public void disembark(Station y)
		{
			if(allow == false)
			{
				System.out.println("From " + stationName + " to " + y.getName() +  " costs " + dollar.format(cost(y)) + ".");
				myMoney = myMoney - cost(y); 
				System.out.println("Balance: " + dollar.format(myMoney)); 
				zone = y.getZone(); 
				stationName = y.getName();
				allow = true; 
			}
			else
			{
				System.out.println("Please see station manager!"); 
				System.exit(0); 
			}
		}		
   }
    class Station
   {
   	private int myZone; 
		private String myName; 
		public Station(String name, int num)
		{
			myName = name; 
			myZone = num; 
		}
		public String getName()
		{
			return myName;
		}
		public int getZone()
		{
			return myZone; 
		}
		public void setName(String x)
		{
			myName = x;
		}
		public void setZone(int y)
		{
			myZone = y;
		}
		public String toString()
		{
			return "Station: " + myName + "\n" + "Zone: " + myZone; 
		} 
   }