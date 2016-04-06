int numNames = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of names:(1-20)"));
      if(numNames == -1)
      {
         JOptionPane.showMessageDialog(null, "Goodbye!");
         System.exit(0);  
      } 
      int numN = Integer.parseInt(JOptionPane.showInputDialog("Enter the N:(1-10)")); 
      if(numN == -1)
      {
         JOptionPane.showMessageDialog(null, "Goodbye!"); 
         System.exit(0); 
      }
      ListNode temp = new ListNode(numNames + "", null); 
      ListNode pointer = temp; 
      for(int i = numNames-1; i > 0; i--)
      {
         temp = new ListNode(i + "", temp); 
      }
      pointer.setNext(temp);
      pointer = pointer.getNext();  
      print(pointer); 
      System.out.println(); 
      for(int i = 0; i < numNames-1; i++)
      {
         pointer = remove(pointer, numN); 
         print(pointer);  
         System.out.println(); 
      }    
      int winner = Integer.parseInt(pointer.getValue()+"");

      //System.out.println(winner);
      
      
      
      /*ListNode fourth = new ListNode("four", null); 
      ListNode third = new ListNode("three", fourth); 
      ListNode second = new ListNode("two", third);
      ListNode first = new ListNode("one", second); 
      fourth.setNext(first);
      insert(fourth, "five");    
      print(first); 
      System.out.println("-------"); 
      print(remove(first, 4)); */
      
      
      ListNode fourth = new ListNode("4", null); 
      ListNode third = new ListNode("3", fourth); 
      ListNode second = new ListNode("2", third);
      ListNode first = new ListNode("1", second); 
      fourth.setNext(first);
      insert(fourth, "5");    
      print(first); 
      System.out.println("-------"); 
      first = remove(first, 4); 
      print(first); 
      System.out.println(); 
      replaceAt(first, "Josephus", 2);
      print(first); 