else
         {
            System.out.println("IM HERE" + " " + row + " " + col);
            System.out.println("row sum: " + sumUpArrayRow(m, row)); 
				System.out.println("column sum: " + sumUpArrayCol(m, col));
				 
            if((sumUpArrayCol(m, col) != colcount[col]) && m[row][col] == 0)
            {	
               m[row][col] = 1; 
               display(m, rowcount, colcount);
               System.out.println("IM HERE****"); 
					if(col < (m[0].length-1)) 
					{
               	recur(m, rowcount, colcount, row, (col+1));
               	m[row][col] = 0; 
					}
            	
            } 
				if((sumUpArrayRow(m, row) != rowcount[row]) && m[row][col] == 0)
            {
               m[row][col] = 1;
               display(m, rowcount, colcount);
               System.out.println("IM HERE*" + " " + row + " " + col); 
					if(row > 0)
					{
               	recur(m, rowcount, colcount,(row-1), col);
               	m[row][col] = 0; 
					}
            }
           
            if((sumUpArrayCol(m, col) != colcount[col]) && m[row][col] == 0)
            {
               m[row][col] = 1; 
               display(m, rowcount, colcount);
               System.out.println("IM HERE***"); 
					if(col > 0)
					{
               	recur(m, rowcount, colcount, row, (col-1));
              		 m[row][col] = 0;
					} 
            	
            }
				 if((sumUpArrayRow(m, row) != rowcount[row]) && m[row][col] == 0)
            {
            
               m[row][col] = 1; 
               display(m, rowcount, colcount);
               System.out.println("IM HERE**"  + " " + row + " " + col); 
					if(row < (m.length-1))
					{
               	recur(m, rowcount, colcount, (row + 1), col);
               	m[row][col] = 0; 
					}
            	
            }
        
