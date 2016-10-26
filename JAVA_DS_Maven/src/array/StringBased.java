package array;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class StringBased {
	
	//using regular expression
	public static String removeVowels(String data)
	{
		String temp = data.replaceAll("[AaEeIiOoUu]", "");
		
		return temp;
	}
	
	// String builder
	public static String removeVowelsBuilder(final String string){
	    final String vowels = "AaEeIiOoUu";
	    final StringBuilder builder = new StringBuilder();
	    char[] s =string.toCharArray();
	    for(final char c : s)
	        if(vowels.indexOf(c) < 0)
	            builder.append(c);
	    return builder.toString();
	}
	
	

	//Find if a string is the substring of the other 
	public static  void  findMe(String mainString, String subString ) {
       
      
        System.out.println("Check it status" +mainString.contains(subString));
        System.out.println(mainString.indexOf(subString) > -1 ? true : false);
       
      
    }

	/* 1) add s1 + s1 = sAdd
	 * 2) sAdd.contains(s2)
	 */
	
	// Find if a string is rotation of another string ex. abcd , dabc is rotation of abcd 
	public static boolean isRotated(String s1, String s2){
		if(s1.length()!=s2.length()){
			return false;
		}
		String sAdd = s1 + s1;
		if(sAdd.contains(s2)){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isRotatedIndex(String s1, String s2){
		if(s1.length()!=s2.length()){
			return false;
		}
		String sAdd = s1 + s1;
		if(sAdd.indexOf(s2)> -1)
			return true;
		
	return false;
	}
	
	// reminder of String
	public static String remainderOfString(String s1, String s2){
		String output = "";
		if(s1.indexOf(s2)> -1)
		{
			System.out.println("remainder" + s1.indexOf(s2));
			int temp = s1.indexOf(s2)+ s2.length();
			output =  s1.substring(temp, s1.length());
		}
		
	    return output;
	}
	
	 public static void swapNumbersWithoutTemp(int x, int y) {
	        System.out.println("Before swap: x = " + x + " y = " + y);
	        x = y - x;
	        y = y - x;
	        x = x + y;
	        System.out.println("After swap: x = " + x + " y = " + y);
	    }

	    public static void swapNumbersUsingXOR(int x, int y) {
	        System.out.println("Before swap: x = " + x + " y = " + y);
	        x = x ^ y;
	        y = x ^ y;
	        x = x ^ y;
	        System.out.println("After swap: x = " + x + " y = " + y);

	    }
	    
	    // Concatenate two numbers. for e.g. 123, 456 = 123456
	    
	   
		private static String removeDuplicateCharactersFromWord(String word) {

		    String result = new String("");

		    for (int i = 0; i < word.length(); i++) {
		        if (!result.contains("" + word.charAt(i))) {
		            result += "" + word.charAt(i);
		        }
		    }

		    return result;
		}
		public static boolean isAnagram(String word, String anagram) {
			if (word.length() != anagram.length()) {
				return false;
			}
			char[] chars = word.toCharArray();
			for (char c : chars) {
				int index = anagram.indexOf(c);
				if (index != -1) {
					anagram = anagram.substring(0, index) + anagram.substring(index + 1, anagram.length());
				} else {
					return false;
				}
			}
			return anagram.isEmpty();
		}

		/*
		 * * Another way to check if two Strings are anagram or not in Java * This
		 * method assumes that both word and anagram are not null and lowercase
		 * * @return true, if both Strings are anagram.
		 */ public static boolean iAnagram(String word, String anagram) {
			char[] charFromWord = word.toCharArray();
			char[] charFromAnagram = anagram.toCharArray();
			Arrays.sort(charFromWord);
			Arrays.sort(charFromAnagram);
			return Arrays.equals(charFromWord, charFromAnagram);
		}

		public static boolean checkAnagram(String first, String second) {
			char[] characters = first.toCharArray();
			StringBuilder sbSecond = new StringBuilder(second);
			for (char ch : characters) {
				int index = sbSecond.indexOf("" + ch);
				if (index != -1) {
					sbSecond.deleteCharAt(index);
				} else {
					return false;
				}
			}
			return sbSecond.length() == 0 ? true : false;
		}
		
		public static boolean palindromeUsingStack(String input)
		{
			Stack<Character> in = new Stack<Character>();
			
			String output = "";
			
			for(int i =0; i<input.length();i++)
			{
				in.push(input.charAt(i));
			}
			
			while (!in.isEmpty()) 
			{
				output = output + in.pop();
			}
			
			
			if(input.equals(output))
			{	
				return true;
			}
			
			
				return false;
			}
		
		public static int totalNoOfpalindrome(String input)
		{
			
			String out ="";
			Set<String> s = new HashSet<String>();
			
			for(int i =0; i<input.length();i++)
			{
				String temp = input.substring(i);
				
				out ="";
			  for(int j =0; j<temp.length();j++)
			  {
				out = out +temp.charAt(j);
			
				
				if(palindromeUsingStack(out))
				{
				  s.add(out);
				}  
				
			  }	
			 	
			}
			
			for( String temp : s)
			{
				System.out.println(temp);
			}
			return s.size();
				
		}
		
		
		public static String largestPalindrome(String input) {
			String largestPalindrome = "";
			int largestLength = 0;

			String out = "";
			Set<String> s = new HashSet<String>();

			for (int i = 0; i < input.length(); i++) {
				String temp = input.substring(i);

				out = "";
				for (int j = 0; j < temp.length(); j++) {
					out = out + temp.charAt(j);

					if (palindromeUsingStack(out)) 
					{
						
						if (largestLength < out.length()) {
							largestPalindrome = out;
							largestLength = largestPalindrome.length();
						}
						s.add(out);
					}

				}

			}
		
			return largestPalindrome;
				
		}
		
	    public static void reverseStringUsingStack(String inputString) {
	        if (inputString.isEmpty()) {
	            System.out.println("Please enter a valid string.");
	        } else if (inputString.length() == 1) {
	            System.out.println(inputString);
	        } else {
	            Stack<Character> stack = new Stack<Character>();
	            String reverseString = "";
	            int counter = 0;
	            while (counter < inputString.length()) {
	                stack.push(inputString.charAt(counter));
	                counter++;
	            }
	            while (!stack.isEmpty()) {
	                reverseString = reverseString + stack.pop();
	            }
	            System.out.println("Original String: " + inputString);
	            System.out.println("Reversed String: " + reverseString);
	        }
	    }
	    
	    public static List<String> findDuplicatesUsingSetAdd(List<String> inputStringList) {
	    	List<String> output = new ArrayList<String>();
	    	
	    	for(String temp : inputStringList)
	    	{
	    		if(!output.contains(temp))
	    		{
	    			output.add(temp);
	    		}
	    	}
	    	return output;
	    }
	    
	    public static List<String> findDuplicatesOrCountUsingFrequency(List<String> inputStringList) {
	    	List<String> output = new ArrayList<String>();
	    	
	    	Set<String> s = new HashSet<String>();
	    	s.addAll(inputStringList);
	    	
	    	for(String temp :s)
	    	{
	    		if(!output.contains(temp))
	    		{
	    			output.add(temp + Collections.frequency(inputStringList, temp)) ;
	    		}
	    	}
	    	return output;
	    }
			
	    public static char findFirstNonRepeatedChar(String inputString) {
	        
	        Set<Character> repeatedCharSet = new HashSet<Character>();
	        char out = '\0'; ;
	        char[] ch = inputString.toCharArray();
	        
	        for(char c: ch)
	        {
	        	if(repeatedCharSet.contains(c))
	        	{
	        		out  = c;
	        		break;
	        	}
	        	
	        	repeatedCharSet.add(c);
	        	
	        }
	        
	        
	        return out;
	    }
		 
		 
	    


		//unique character Check in a string
		
		public static boolean uniquecharCheck(String input)
		{
			char[] in = input.toCharArray();
			Set<Character> s = new HashSet<Character>();
			boolean out = true;
			for (char temp : in )
			{
				if(!s.contains(temp))
				{
					s.add(temp);
					
					
				}
				else if(s.contains(temp))
					out = false;
				
			}
			return out;
		}
		
		 public static void StringToDate() throws ParseException{
			 
				
			 SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		     String dateString="11/12/2010";
		     Date d=sdf.parse(dateString);
		     System.out.println(d);
			 
			 }
		 
		 public static void convertByteArrayToString() {
			 
		        byte[] byteArray = new byte[] {78,73, 67,69};
		        String value = new String(byteArray);
		       System.out.println(value);
		 
		    }
	
		 
			public static String replaceAll(String source, final String findToken, final String replaceToken) 
			 {
			
				int index =-1;
				
				do
				{	
				   index = source.indexOf(findToken) ;
				   if(index > -1)
				   {	   
				     source = source.substring(0, index) + replaceToken + source.substring(index  + findToken.length()) ;
				   }  
				}while(index !=-1)  ;
				
				
				return source;
			 } 
			 
		 
		
		//  Given s string, Find max size of a sub-string, in which no duplicate chars present.
		 public static String longestSubstringUnrepeatedChar(String input)
		 {
			 if(input.length()==0)
				 return "";
			 if(input.length()==1)
				 return input;
			 char[] in = input.toCharArray();
			 Set<Character> s = new HashSet<Character>();
			 String out = "";
		
			String temp = "";
			 
			 for(char a : in)
			 {
				 
				if(!s.contains(a))
				{
					s.add(a);
					out = out + a;
					if(temp.length() < out.length())
					{
						temp = out;
						
					}	
					
				}
				
				else if(s.contains(a))
				{
					out = "";
					s.clear();
					// very important critera 
					if(temp.equals("" +a))
					{
				      out = out + a;
					}
						
					
				}
				
				 
				 
			 }
			 return temp ;
			 
		 }
		
		 
		 /**
		  * Finds common starting string for a list of strings. For e.g. aab and aaade have aa in common.
		  * Date: 9/13/13
		  * Time: 4:31 PM
		  */
		 
		 public static String commonPrefexinList(List<String> input)
		 {
			 String temp = "";
			 if(input.size()==0)
				 return "No common prefeix since list is zero";
			 else 
			 {
				 for (int i =0 ;i< input.size() -1 ;i++)
				 {
					 temp = temp + " " + findCommon(input.get(i), input.get(i+1));
				 }
			 }
			 
			 return temp;
		 }
		 
		 public static String findCommon(String a , String b)
		 {
			 String out = "";
			 int minLength = Math.min(a.length(),b.length());
			 for(int i = 0 ; i < minLength;i++)
			 {
				 if(a.charAt(i) == b.charAt(i))
				 {
					 out = out + a.charAt(i) ;
				 }
				 else
				 {
					 break;
				 }
			 }
			 
			 return out;
		 }
			// learn this


		
		
		  public static String findLatest(String string1, String string2) {
		        StringTokenizer stringTokenizer1 = new StringTokenizer(string1, ".");
		        StringTokenizer stringTokenizer2 = new StringTokenizer(string2, ".");
		        while (stringTokenizer1.hasMoreElements() || stringTokenizer2.hasMoreElements()) {
		            long strVal1;
		            long strVal2;
		            try {
		                strVal1 = Long.parseLong(stringTokenizer1.nextToken());
		            } catch (NoSuchElementException ne) {
		                strVal1 = 0l;
		            }
		            try {
		                strVal2 = Long.parseLong(stringTokenizer2.nextToken());
		            } catch (NoSuchElementException ne) {
		                strVal2 = 0l;
		            }
		            if (strVal1 > strVal2) {
		                return string1;
		            } else if (strVal2 > strVal1){
		                return string2;
		            }
		        }
		        return string1;
		    }
		  
		
		  public static String findMinimumSubstring(String S, String T) {
		     if (S==null||T==null){
	             return null;
	         }
	         
	         if(S.length()==0 && T.length()==0){
	             return "";
	         }
	         if (S.length()<T.length()){
	             return"";
	         }
	         
	         char[] c = T.toCharArray();
	         
	         Set<Character> s = new HashSet<Character>();
	         for(Character temp: c)
			  {
				  s.add(temp);
			  }
	         String output = "";
	         String actualOutput = "";
	         
	         String temp = "";
	         
	         for(int i =0 ; i <S.length();i++)
	         {
	        	 if(output.length() ==0 && T.indexOf(S.charAt(i)) <0)    
	        	 {
	        		 output = "";
	        	 }
	        	 else
	        	 {
	        			 output = output + S.charAt(i);
	        	 }
	        	 //System.out.println(output);
	        	
	        	 
	        	 if(s.contains(S.charAt(i)))
	        	 {
	        		temp = temp +S.charAt(i);
	        	 }
	        	 //System.out.println(temp + "  " + T);
	        	 if(temp.length() == T.length())
	        	 {
	        		 //System.out.println(actualOutput.length() + "  " + output.length());
	        		 if(actualOutput.length()==0)
	        		 { 
	        			 actualOutput = output;
	        			 output="";
	        		 }
	        		 
	        		 else if(actualOutput.length()>0 && actualOutput.length() > output.length())
	        		 { 
	        			 System.out.println(output);
	        			 actualOutput = output;
	        			 output="";
	        		 }
	        		 
	        		
	        		 temp = "";
	        	 }
	         }
	         
	         return actualOutput;
		  }
		  
		  
		    public static void printDiamond(int n){
		 	   
		    	System.out.println("Diamond of Stars are \n");
		    	for (int i = 1; i <= n; i++) {
		    	for (int j = 0; j < (n - i); j++)
		    	System.out.print(" ");
		    	for (int j = 1; j <= i; j++)
		    	System.out.print("*");
		    	for (int k = 1; k < i; k++)
		    	System.out.print("*");
		    	System.out.println();
		    	}

		    	for (int i = n - 1; i >= 1; i--) {
		    	for (int j = 0; j < (n - i); j++)
		    	System.out.print(" ");
		    	for (int j = 1; j <= i; j++)
		    	System.out.print("*");
		    	for (int k = 1; k < i; k++)
		    	System.out.print("*");
		    	System.out.println();
		    	}

		    	System.out.println();
		    	}


			public static void printDiamonds(int size) {
				// for odd size
				// we can do similar thing for even size.
				if (size % 2 != 0) {
					int spaceCount = size / 2;
					int starCount = 1;
					while (spaceCount >= 0) {
						for (int i = 0; i < spaceCount; i++) {
							System.out.print(" ");
						}
						for (int j = 0; j < starCount; j++) {
							System.out.print("*");
						}
						starCount = starCount + 2;
						spaceCount--;
						System.out.println();
					}
					starCount = size - 2;
					spaceCount = 1;
					while (starCount > 0) {
						for (int i = 0; i < spaceCount; i++) {
							System.out.print(" ");
						}
						for (int j = 0; j < starCount; j++) {
							System.out.print("*");
						}
						starCount = starCount - 2;
						spaceCount++;
						System.out.println();
					}
				}
			}
	public static void main(String[] args)
	{
		/*System.out.println(removeVowels("hemanth"));
		System.out.println(removeVowelsBuilder("hemanth"));
	
		findMe("Sachin", "ll");
		System.out.println(findrecursive("Sachin", "ac"));
		
		System.out.println("rotation:" + isRotated("abcd", "dabc"));
		System.out.println("rotation:" + isRotatedIndex("abcd", "dabc"));
		System.out.println("Remainder of the String" + remainderOfString("hemanth", "th"));
		 System.out.println(removeDuplicateCharactersFromWord("Green Apple"));
		 
		 System.out.println(palindromeUsingStack("mada"));
			List<String> in = new ArrayList<String>();
			in.add("ee");
			in.add("ff");
			in.add("ee");
			System.out.println(findDuplicatesUsingSetAdd(in).size());
			
			List<String> out = findDuplicatesOrCountUsingFrequency(in);	
			//System.out.println(out.size());
			for(String temp: out)
			{
				System.out.println(temp);
			}
			
			 System.out.println(findFirstNonRepeatedChar("ffaaebbccad"));
		        System.out.println(findFirstNonRepeatedChar("faaebbccad"));
		        System.out.println(findFirstNonRepeatedChar("aabbcca"));
		        printDiamonds(5);
		        System.out.println(uniquecharCheck("abc"));
		        System.out.println(longestSubstringUnrepeatedChar("AABC"));
		      
		*/
		System.out.println(largestPalindrome("1234"));
        System.out.println(largestPalindrome("12321"));
        System.out.println(largestPalindrome("9912321456"));
        System.out.println(largestPalindrome("9912333321456"));
        System.out.println(largestPalindrome("12145445499"));
        System.out.println(largestPalindrome("1223213"));
        System.out.println(largestPalindrome("abb"));
		
		
		 
	}

}
