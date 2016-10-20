package domain.java.advanced;


// https://www.hackerrank.com/challenges/simple-addition-varargs/
public class SimpleAddition {
	
	class Add
	{
	  
	    public void add(int... args)
	    {
	        int sum = 0;  
	        String temp="";
	        for (int i : args)  
	        {
	            sum += i;  
	            if(temp.length()==0)
	            {
	                temp = "" + i;
	            }
	            
	            else
	            {
	               temp = temp + "+" +i;
	                   
	            }
	            
	        }    
	        
	        
	        System.out.println( temp + "=" + sum); 
	    }
	}

}
