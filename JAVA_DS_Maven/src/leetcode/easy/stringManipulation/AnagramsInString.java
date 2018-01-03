package leetcode.easy.stringManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramsInString {
	
	 public static List<Integer> findAnagrams(String s, String p) {
		 List<Integer> output = new ArrayList<>();
		 
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

	
	
	public static void main(String[] args)
	{
		System.out.println(findAnagrams("cbaebabacd","abc"));
	}


}
