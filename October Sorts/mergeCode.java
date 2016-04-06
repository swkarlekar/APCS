 			for(int k = low; k <= high; k++)
            copyBuffer[k] = array[k]; 
      		
         int midplus = middle+1;
         int pos = low;  
         while((low <= middle && midplus <= high))
         {
            if(copyBuffer[low] <= copyBuffer[midplus])
            {
               array[pos] = copyBuffer[low]; 
               low++; 
               pos++; 
            }
            else
            {
               array[pos] = copyBuffer[midplus]; 
               midplus++; 
               pos++; 
            }
         
         }
      	 
         while((low <= middle) && (midplus > high))
         {
            array[pos] = copyBuffer[low]; 
            low++; 
            pos++; 
         }
         while((midplus <= high) && (low > middle))
         {
            array[pos] = copyBuffer[midplus]; 
            midplus++; 
            pos++; 
         }
      
