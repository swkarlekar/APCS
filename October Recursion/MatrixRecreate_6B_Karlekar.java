
   public class MatrixRecreate_6B_Karlekar {
	
	//This code requires an increase in heap size. The code works with all matrices, but smaller ones won't give you any StackOverFlow errors. 
   
      private static String[] myComboStringList;
      private static int[][] myComboList;
      private static int comboListIndex;
      private static int ci;
      private static int[] currentRows;
      
      public static void main(String[] args) {
         int[][] matrix = create();
         int[] rowcount = new int[matrix.length];
         int[] colcount = new int[matrix[0].length];
         count(matrix, rowcount, colcount);
         display(matrix, rowcount, colcount);
         System.out.println();
         System.out.println();
      
         re_create(rowcount, colcount);
      
      }
   
   
      public static void display(int[][] matrix, int[] rowcount, int[] colcount) {
         System.out.print("    ");
         for (int i = 0; i < colcount.length; i++) {
            System.out.print("" + colcount[i] + " ");
         }
         System.out.println();
         System.out.print("   ");
         for (int i = 0; i < colcount.length * 2; i++)
            System.out.print("-");
         System.out.println();
         for (int i = 0; i < rowcount.length; i++) {
            System.out.print(rowcount[i] + " | ");
            for (int k = 0; k < colcount.length; k++) {
               System.out.print(matrix[i][k] + " ");
            }
            System.out.println();
         }
      }
   
      public static void re_create(int[] rowcount, int[] colcount) {
         ci = rowcount.length - 1;
         currentRows = new int[rowcount.length];
         for (int j = 0; j < rowcount.length; j++) {
            currentRows[j] = 0;
         }
         genComboList(colcount.length);
         int[][] array = new int[rowcount.length][colcount.length];
         for (int i = 0; i < rowcount.length; i++)
            for (int k = 0; k < colcount.length; k++)
               array[i][k] = 0;
         recur(array, rowcount, colcount, rowcount.length, colcount.length);
      }
   
      private static void recur(int[][] m, int[] rowcount, int[] colcount,
      	int row, int col) // recursive helper method
      {
         int numOfRows = rowcount.length;
         if (compare(m, rowcount, colcount)) // base case: if new matrix works
         {
            display(m, rowcount, colcount);
            //System.out.println("WE'RE DONE!"); // we're done!
            System.exit(0);
         }
         
         else 
         {
            for (int i = 0; i < numOfRows; i++)
            {
               m[i] = myComboList[currentRows[i]];
            }
         
         
            incCurrRows(numOfRows - 1);
                  
            recur(m, rowcount, colcount, row, col);
         }
      // enter your permutation code here
      
      }
   
      private static void incCurrRows(int j) {
         if (j >= 0) {
            currentRows[j]++;
            if (currentRows[j] == (myComboList.length)) {
               currentRows[j] = 0;
               incCurrRows(j - 1);
            }
         }
         return;
      }
   
      public static void count(int[][] matrix, int[] rowcount, int[] colcount) {
         int sum = 0;
         int whichrow = 0;
         while (whichrow < colcount.length) {
            for (int y = 0; y < rowcount.length; y++) {
               for (int x = 0; x < colcount.length; x++) {
                  sum += matrix[y][x];
                  rowcount[y] = sum;
                  whichrow++;
               }
               sum = 0;
            }
         }
         int whichcol = 0;
         while (whichcol < rowcount.length) {
            for (int y = 0; y < colcount.length; y++) {
               for (int x = 0; x < rowcount.length; x++) {
                  sum += matrix[x][y];
                  colcount[y] = sum;
                  whichcol++;
               }
               sum = 0;
            }
         }
      
      }
   
      private static boolean compare(int[][] m, int[] rowcount, int[] colcount) {
         int rc = m.length;
         int cc = m[0].length;
         int[] newRowCount = new int[rc];
         int[] newColCount = new int[cc];
         count(m, newRowCount, newColCount);
         boolean isequal = true;
         for (int i = 0; i < rowcount.length; i++)
            if (newRowCount[i] != rowcount[i])
               isequal = false;
      
         for (int i = 0; i < colcount.length; i++)
            if (newColCount[i] != colcount[i])
               isequal = false;
      
         return isequal;
      }
   
      public static void display(int[][] matrix) {
         int rows = matrix.length;
         int cols = matrix[0].length;
         System.out.println("Number of unique rows: " + matrix.length);
         for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
               System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
         }
      }
   
      static void convertComboListArray(int numOfCols) {
         myComboList = new int[myComboStringList.length][numOfCols];
         for (int i = 0; i < myComboStringList.length; i++) {
            String combo = myComboStringList[i];
            for (int j = 0; j < combo.length(); j++) {
               myComboList[i][j] = Integer.parseInt(combo.charAt(j) + "");
            }
         }
      }
   
      static void genComboList(int numOfCols) {
         myComboStringList = new String[(int) Math.pow(2.0, numOfCols)];
         comboListIndex = 0;
         genComboStrings(numOfCols, "");
         convertComboListArray(numOfCols);
      }
   
      static void genComboStrings(int cols, String binaryNum) {
         if (cols <= 0) {
            myComboStringList[comboListIndex++] = binaryNum;
            return;
         }
         genComboStrings(cols - 1, binaryNum + '0');
         genComboStrings(cols - 1, binaryNum + '1');
      }
   
      public static int[][] create() {
         int r = (int) (Math.random() * 5 + 2);
         int c = (int) (Math.random() * 5 + 2);
         int[][] array = new int[r][c];
         for (int i = 0; i < r; i++)
            for (int k = 0; k < c; k++)
               array[i][k] = (int) (Math.random() * 2);
         return array;
      }
   
         
   }
