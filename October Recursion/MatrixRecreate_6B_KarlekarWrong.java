// Name: Sweta Karlekar
// Date: 10/4/13

   public class MatrixRecreate_6B_KarlekarWrong
   {
   
      public static void main(String[] args)
      {
         int[][] matrix = create();
         int[] rowcount = new int[matrix.length];
         int[] colcount = new int[matrix[0].length];
         count(matrix, rowcount, colcount);
         display(matrix, rowcount, colcount);
         System.out.println(); 
         System.out.println(); 
      
         re_create(rowcount, colcount);
      }
      public static int[][] create()
      {	
         int r = 2; //(int)(Math.random() * 5 + 2); 
         int c = 2; //(int)(Math.random() * 5 + 2); 
         int[][] array = new int[r][c]; 
         for(int i = 0; i < r; i ++)
            for(int k = 0; k < c; k++)
               array[i][k] = (int)(Math.random() * 2); 
         return array; 
      }
      public static void count(int[][] matrix, int[] rowcount, int[] colcount)
      {
         int sum = 0; 
         int whichrow = 0; 
         while(whichrow < colcount.length)
         {
            for(int y = 0; y < rowcount.length; y++)
            {
               for(int x = 0; x < colcount.length; x++)
               {
                  sum += matrix[y][x]; 
                  rowcount[y] = sum; 
                  whichrow++; 
               }
               sum = 0; 
            }
         }
         int whichcol = 0; 
         while(whichcol < rowcount.length)
         {
            for(int y = 0; y < colcount.length; y++)
            {
               for(int x = 0; x < rowcount.length; x++)
               {
                  sum += matrix[x][y]; 
                  colcount[y] = sum; 
                  whichcol++; 
               }
               sum = 0; 
            }
         }
      	
      }
      public static void display(int[][] matrix, int[] rowcount, int[] colcount)
      {
         System.out.print("    "); 
         for(int i = 0; i < colcount.length; i++)
         {
            System.out.print("" + colcount[i] + " "); 
         }
         System.out.println(); 
         System.out.print("   "); 
         for(int i = 0; i < colcount.length*2; i++)
            System.out.print("-"); 
         System.out.println(); 
         for(int i = 0; i < rowcount.length; i++)
         {
            System.out.print(rowcount[i] + " | "); 
            for(int k = 0; k < colcount.length; k++)
            {
               System.out.print(matrix[i][k] + " "); 
            }
            System.out.println();
         }
      }
      public static void re_create(int[] rowcount, int[] colcount)
      {
         int[][] array = new int[rowcount.length][colcount.length]; 
         for(int i = 0; i < rowcount.length; i++)
            for(int k = 0; k < colcount.length; k++)
               array[i][k] = 0; 
         recur(array, rowcount, colcount, 0, 0);  
      }
      private static int sumUpArrayCol(int[][] array, int col)
      {
         int sum = 0; 
         for(int i = 0; i < array.length; i++)
            sum = sum + array[i][col];
         return sum; 
      }
      private static int sumUpArrayRow(int[][] m, int r)
      {
         int sum = 0;  
         for(int y = 0; y < m[0].length; y++)
            sum += m[r][y]; 
         return sum; 
      }
      private static void recur(int[][] m, int[] rowcount, int[] colcount, int row, int col) //recursive helper method
      {
         if(compare(m, rowcount, colcount))    //base case: if new matrix works
         {
            display(m, rowcount, colcount); 
            System.out.println("WE'RE DONE!");    //we're done!
            System.exit(0);
         }
         
			       
        
      	//enter your permutation code here
      	
      }
      private static boolean compare(int[][] m, int[] rowcount, int[] colcount)
      { 
         int rc = m.length; 
         int cc = m[0].length;
         int[] newRowCount = new int[rc]; 
         int[] newColCount = new int[cc]; 
         count(m, newRowCount, newColCount); 
         boolean isequal = true; 
         for(int i = 0; i < rowcount.length; i++)
            if(newRowCount[i] != rowcount[i])
               isequal = false;
          
         for(int i = 0; i < colcount.length; i++)
            if(newColCount[i] != colcount[i])
               isequal = false;
         
      
         return isequal; 
      }
   }
