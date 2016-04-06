	//Name:Sweta Karlekar	
	//Date:9/4/13
    public class Modes_6_Karlekar
   {
		private static int[] tally = {0,0,10,5,10,0,7,1,0,6,0,10,3,0,0,1};
		private static int value = 0; 
		private static int freq = tally[value]; 
       public static void main(String[] args)
      {
         display(tally);
         int[] modes = calculateModes(tally);
         display(modes);
         int sum = 0;
         for(int k = 0; k < tally.length; k++)
            sum += tally[k];
         System.out.println("kth \tindex"); 
         for(int k = 1; k <= sum; k++)
            System.out.println(k + "\t\t" + kthDataValue(tally, k));
      }
       public static int[] calculateModes(int[] tally)
      {
      	int num=0; 
			int max = findMax(tally);
			for(int i = 0; i < tally.length; i++)
				if(tally[i]==max)
					num++;
			int[] array = new int[num];
			int a = 0; 
			for(int k = 0; k < tally.length; k++)
			{
				if(tally[k] == max)
				{
					array[a] = k; 
					a++;
				}
			}
			return array; 
      }
       public static int kthDataValue(int[] tally, int k)
      {
     		if(k<=freq)
				return value; 
			else
			{
				value++; 
				freq = freq + tally[value]; 
				kthDataValue(tally, k);
				return value;
			}  
      }
       public static int findMax(int[] nums)
      {
         int pos = 0;
         for(int k = 1; k < nums.length; k++)
            if(nums[k] > nums[pos])
               pos = k;
         return nums[pos];
      }
       public static void display(int[] args)
      {
         for(int k = 0; k < args.length; k++)
            System.out.print(args[k] + " ");
         System.out.println();
         System.out.println();
      }
   }
