//name:Sweta Karlekar   date: 
    public class TeamBuilder_6B_Karlekar
   {
       public static void main(String[] args) 
      {
         //String[] path = {"010", "000", "110"};	   
         //String[] path = {"0010", "1000", "1100", "1000"};
         //String[] path = {"01000", "00100", "00010", "00001", "10000"};
         1String[] path = {"0110000", "1000100", "0000001", "0010000", "0110000", "1000010", "0001000"};
        
         int[] ret = specialLocations(path);
         
         System.out.println("{" + ret[0] + ", " + ret[1] + "}");
      }
       public static int[] specialLocations(String[] paths)
      {
         //create matrix
         int[][] matrix = new int[paths.length][paths.length]; 
         for(int i = 0; i < paths.length; i++)
         {
            for(int j = 0; j < paths[i].length(); j++)
            {
               matrix[i][j] = Integer.parseInt(paths[i].charAt(j) + ""); 
            }
         }
         //warshall to account for multiple paths
         Warshall_6B_Karlekar.warshall(matrix); 
         //find number of locations that reaches all other locations
         int reachable = 0; 
         boolean reachablebool = true;  
         for(int r = 0; r < matrix.length; r++)
         {
            for(int c = 0; c < matrix[0].length; c++)
            {
               if(c != r)
               {
                  if(matrix[r][c] != 1)
                     reachablebool = false; 
               } 
            }
            if(reachablebool == true)
               reachable++; 
            reachablebool = true; 
         }
         //find number of locations that are reached by all other locations
         int reached = 0;
         boolean reachedbool = true;  
         for(int c = 0; c < matrix[0].length; c++)
         {
            for(int r = 0; r < matrix.length; r++)
            {
               if(c != r)
               {
                  if(matrix[r][c] != 1)
                     reachedbool = false; 
               } 
            }
            if(reachedbool == true)
               reached++; 
            reachedbool = true; 
         }
         //return array with reachable and reached ints
         int[] array = {reachable, reached}; 
         return array; 
         
      }
   }