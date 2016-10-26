package array;

import java.util.Scanner;

public class Recursive {
	
	
	public static int exponentRecursion(int base, int exponent)
	{
		if(exponent==0)
			return 1;
		else
			return exponentRecursion(base, exponent-1) * base;
	}
	
	
	//Find if a string is the substring of the other recursion
	public static boolean findrecursive(String text, String target)
	{

	 
	 if (text == null || target == null) {return false;}  // added target null check       
	
	 if (target.length() > text.length()) {return false;}

	 if (text.length() == target.length()) {return text.equals(target);}
	
	 return text.startsWith(target) || findrecursive(text.substring(1) , target);
	}
	

	/* 1) recursive and non-recursive program to generate all possible substrings of a string.  	   
	 2) Permutation of string*/

		public static void permutation(String str) { // Permutation of string
		    permutation("", str); 
		}

		private static void permutation(String prefix, String str) {
		    int n = str.length();
		    if (n == 0) System.out.println(prefix);
		    else {
		        for (int i = 0; i < n; i++)
		            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
		    }
		}

	public void nonrecursive(String d)
	{
		for(int i =0 ; i<d.length();i++)
		{
			for( int j = i + 1 ; j<=d.length();j++)
			{
				System.out.println(d.substring(i,j));
			}
		}
	}


	 String in ;

	 void substrings(String str)
	
	{
	 int start = 0;
	 int end = 1;
	 in = str;
	 substrings(start,end);
	}
	 void substrings(int start, int end){
	    if(start == in.length() && end == in.length()){
	        return;
	    }else{
	        if(end == in.length()+1){
	            substrings(start+1,start+1);
	        }else{
	            System.out.println(in.substring(start, end));
	            substrings(start, end+1);
	        }
	    }
	}	

		public int fact( int n)// This function is used to calculate factorial
		{
			if( n ==1)
				return 1;
			else
			{
				int result = 0;
				result = n * fact(n-1);
				return result;
			}
			
			
		}
		
		 public static  String reverseString(String str){
	            String reverse = "";
		        if(str.length() == 1){
		            return str;
		        } else {
		            reverse += str.charAt(str.length()-1)
		                    +reverseString(str.substring(0,str.length()-1));
		            return reverse;
		        }
		    }
		
		    public static int calculatefactorial(int n){
		        int factorialnumbers=1;
		        while(n>0){
		         factorialnumbers=(int)(factorialnumbers*n--);   
		        }
		        return factorialnumbers;
		    }
		    
		    // Generate from 1 to n with out using loop
		    
		    
		    public static int numberGeneration(int n)
		    {
		    	if(n==0)
		    		return 0;
		    	
		       if(n>0)
		    	   System.out.println(n);
		    	
		    	return numberGeneration(n-1);
		    }
		    
		    
		
	 	public static void main(String args[])
	 	{
	 	
	 		
	 		Recursive a = new Recursive();
	 		String d = "abc";
	 		a.substrings("1234");
	 	
	 		//a.nonrecursive(d);
	 	    //permutation(d);
	 		System.out.println(reverseString(d));
	 		
	 		
	 	    Scanner keyboard = new Scanner(System.in);
	        int n; 
	        System.out.println("Enter number: ");
	        n = keyboard.nextInt();
	        int number = calculatefactorial(n);
	        System.out.println("Factorial: " +number);
	        
	        System.out.println("Number Generation");
	        numberGeneration(100);
	 		
	 	}
	} 


