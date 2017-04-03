package leetcode.easy.stringManipulation;

public class ReverseStringIndex {
	
	 public String reverseStr(String s, int k) {
	      if(s.length()==1 ||  k > s.length() )
	      {
	          return s; 
	      }
	    
	    String output = "";
	    
	    if(s.length() > ( (2 * k ) - 1 ) )
	    {
	        output = output  +  reverseString( s.substring(0, k) ) + s.substring(k, (2 * k)); 
	        
	        int reminderLength = s.length() - output.length();
	        
	        if(reminderLength < k)
	        {
	            output = output + reverseString(s.substring((2* k)) );
	        }
	        else if (reminderLength < (2* k)& reminderLength >=k )
	        {
	            output = output + reverseString(s.substring(reminderLength+1,reminderLength+1+ k) ) + s.substring(reminderLength+k+1);
	        }
	    }
	    
	    return output;   
	        
	    }
    public String reverseString(String str){
	            String reverse = "";
		        if(str.length() == 1){
		            return str;
		        } else {
		            reverse += str.charAt(str.length()-1)
		                    +reverseString(str.substring(0,str.length()-1));
		            return reverse;
		        }
		    }
    
    
    public static void main(String[] args)
    {
    	ReverseStringIndex a = new ReverseStringIndex();
    	System.out.println(a.reverseStr("abcdefg", 2));
    }

}
