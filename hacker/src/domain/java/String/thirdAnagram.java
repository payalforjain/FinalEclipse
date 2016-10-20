package domain.java.String;

import java.util.Scanner;

public class thirdAnagram {
	
	   static boolean isAnagram(String data1, String data2) {
		     
	       String A = data1.toUpperCase();
	       String B = data2.toUpperCase();
	       char[] first = A.toCharArray();
	       
	       if(A==null || B==null || (A.length()!= B.length()))
	       {
	         return false;   
	       }
	       for(char ch: first)
	           {
	               int ind = B.indexOf(ch);
	                if(ind >=0)
	                {
	                      B = B.substring(0,ind) + B.substring(ind+1);    
	                }
	           }
	        return B.length()==0? true :false;
	   }
	    public static void main(String[] args) {
	        
	        Scanner sc=new Scanner(System.in);
	        String A=sc.next();
	        String B=sc.next();
	         sc.close();
	        boolean ret=isAnagram(A,B);
	        if(ret)System.out.println("Anagrams");
	        else System.out.println("Not Anagrams");
	        
	    }

}
