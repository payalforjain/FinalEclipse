package leetcode.easy.stringManipulation;

import java.util.ArrayList;
import java.util.List;

public class AnagramsInString {
	
	 public static List<Integer> findAnagrams(String s, String p) {
		 List<Integer> output = new ArrayList();
		 
		 if(s==null || p==null || s.length() == 0 || p.length()==0)
		 {
			 return output;
		 }
		 
		 int length = p.length();
		 for(int i=0; i < s.length() - length +1; i++)
		 {
			 String temp = s.substring(i,i+length);
			 if(isAnagram(temp,p))
			 {
				 output.add(i);
			 }
		 }
		 return output;
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
	
	
	public static void main(String[] args)
	{
		System.out.println(findAnagrams("cbaebabacd","abc"));
	}


}
