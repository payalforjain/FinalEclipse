package domain.java.introduction;

import java.util.Scanner;

public class FiveLoops {
	
	public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();
       String[] outputArray = new String[t];
       
       if(t>=0 & t<=500)
       {	   
         for(int i=0; i < t; i++)
         {
        	 String outputToArray = "";
    	   int a = sc.nextInt();
    	   int b = sc.nextInt();
    	   int n = sc.nextInt();
    	   if(a >= 0 && a <=50 && b>=0 && b<= 50) 
    	   {
    		   
    		   for( int j =0 ; j<n ;j++)
    		   {
    			   int temp = a;
    			   String output = "";
    			   
    			   for(int k =0 ; k<=j ; k++)
    			   {
    				   double power = k;
    				   int calc = (int) Math.pow(2.0, power);
    				   temp = temp + (calc * b );

        			   output = output + " " + temp;
        			   outputToArray =  output ;
    			   }
    			   
    		   }
    		
    	   }
    	   outputArray[i] = outputToArray.substring(1);
         }
       for(int i=0; i < t; i++)
       {
    	   System.out.println(outputArray[i]);
       }
    }

	}
}
