package hu.elte.txtuml.stdlib.util;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class Dictionary_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	  	Dictionary<Integer, String> dict = new Hashtable<Integer, String>();
    
	  		// adding elements to dictionary using put method
	  		//put(key, value)
	  		dict.put(1, "Java");
	  		dict.put(2, "txtUMl");
	  		dict.put(3, "C++");
	  		dict.put(4, "python");
	  		
	  		System.out.println( "Items in the dictionary..." + dict);
	  		
	  		
	  			//keys() return the Enumeration of the keys in the  dictionary	
  			for (Enumeration<Integer> e = dict.keys(); e.hasMoreElements();)
			{
							 System.out.println("key : " + e.nextElement());
						   }
  			
				//elements() return the Enumeration of the values 
			for (Enumeration<String> e = dict.elements(); e.hasMoreElements();) 
			{
							   System.out.println("element : " + e.nextElement());
						   }
	  		
	  		//isEmpty() checking the dictionary if its empty or not 
	  		boolean X = dict.isEmpty();
	  				System.out.println("isEmpty = " + X );
	  		
	  		//size() return the size of the dictionary
	  		int S = dict.size();
	  				System.out.println("size of dictionary is " + S);
   
    
    		//get()  elements can be retrieved using their key
    		System.out.println("Retrieve element from dictionary with key 1 : " + 
    		dict.get(1) );
   
    		//remove()  elements can be removed using their key
    		System.out.println("Removing element from dictionary with key 2 : " + 
    		dict.remove(2) );
    
    		System.out.println("Items in the dictionary after removing..." + dict );
    
  }


		
		

	}


