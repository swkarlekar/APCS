 else
         {
				               //System.out.println("IM HERE!"); 

            /*if((sumUpArrayCol(m, col) < colcount[col]) && (sumUpArrayRow(m, row) < rowcount[row]) && m[row][col] == 0)
            {
               m[row][col] = 1; 
               display(m, rowcount, colcount); 
               System.out.println("IM HERE!"); 
            }*/
				if(row < (m.length-1) && (sumUpArrayCol(m, col) != colcount[col]) && (sumUpArrayRow(m, row) != rowcount[row]) && m[row][col] == 0)
            {
					display(m, rowcount, colcount);
               System.out.println("IM HERE!*" + " " + row + " " + col);
					m[row][col] = 1; 
               recur(m, rowcount, colcount, (row+1), col);
               m[row][col] = 0; 
                
            } 
            if(row > 0 && (sumUpArrayCol(m, col) != colcount[col]) && (sumUpArrayRow(m, row) != rowcount[row]) && m[row][col] == 0)
            {
					display(m, rowcount, colcount);
               System.out.println("IM HERE!**" + " " + row + " " + col); 
					m[row][col] = 1; 
               recur(m, rowcount, colcount, (row-1), col); 
               m[row][col] = 0; 
               
            }
         
            if(col < (m[0].length-1) && (sumUpArrayCol(m, col) != colcount[col]) && (sumUpArrayRow(m, row) != rowcount[row]) && m[row][col] == 0)
            {
					display(m, rowcount, colcount);
               System.out.println("IM HERE!***" + " " + row + " " + col);
					m[row][col] = 1; 
               recur(m, rowcount, colcount, row, (col+1));
               m[row][col] = 0; 
                
            } 
            if(col > 0 && (sumUpArrayCol(m, col) != colcount[col]) && (sumUpArrayRow(m, row) != rowcount[row]) && m[row][col] == 0)
            {
					display(m, rowcount, colcount);
               System.out.println("IM HERE!****" + " " + row + " " + col);
					m[row][col] = 1;
               recur(m, rowcount, colcount, row, (col-1)); 
               m[row][col] = 0;  
            }
         }